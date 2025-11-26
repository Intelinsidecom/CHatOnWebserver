package org.jboss.netty.channel.socket.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

/* loaded from: classes.dex */
class NioSocketChannel extends AbstractChannel implements SocketChannel {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int ST_BOUND = 1;
    private static final int ST_CLOSED = -1;
    private static final int ST_CONNECTED = 2;
    private static final int ST_OPEN = 0;
    private final NioSocketChannelConfig config;
    SocketSendBufferPool.SendBuffer currentWriteBuffer;
    MessageEvent currentWriteEvent;
    final AtomicInteger highWaterMarkCounter;
    boolean inWriteNowLoop;
    final Object interestOpsLock;
    private volatile InetSocketAddress localAddress;
    private volatile InetSocketAddress remoteAddress;
    final java.nio.channels.SocketChannel socket;
    volatile int state;
    final NioWorker worker;
    final Queue writeBuffer;
    final AtomicInteger writeBufferSize;
    final Object writeLock;
    boolean writeSuspended;
    final Runnable writeTask;
    final AtomicBoolean writeTaskInTaskQueue;

    final class WriteRequestQueue extends LinkedTransferQueue {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final long serialVersionUID = -246694024103520626L;
        private final ThreadLocalBoolean notifying = new ThreadLocalBoolean();

        static {
            $assertionsDisabled = !NioSocketChannel.class.desiredAssertionStatus();
        }

        WriteRequestQueue() {
        }

        private int getMessageSize(MessageEvent messageEvent) {
            Object message = messageEvent.getMessage();
            if (message instanceof ChannelBuffer) {
                return ((ChannelBuffer) message).readableBytes();
            }
            return 0;
        }

        @Override // org.jboss.netty.util.internal.LinkedTransferQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(MessageEvent messageEvent) {
            boolean zOffer = super.offer((Object) messageEvent);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            int messageSize = getMessageSize(messageEvent);
            int iAddAndGet = NioSocketChannel.this.writeBufferSize.addAndGet(messageSize);
            int writeBufferHighWaterMark = NioSocketChannel.this.getConfig().getWriteBufferHighWaterMark();
            if (iAddAndGet < writeBufferHighWaterMark || iAddAndGet - messageSize >= writeBufferHighWaterMark) {
                return true;
            }
            NioSocketChannel.this.highWaterMarkCounter.incrementAndGet();
            if (((Boolean) this.notifying.get()).booleanValue()) {
                return true;
            }
            this.notifying.set(Boolean.TRUE);
            Channels.fireChannelInterestChanged(NioSocketChannel.this);
            this.notifying.set(Boolean.FALSE);
            return true;
        }

        @Override // org.jboss.netty.util.internal.LinkedTransferQueue, java.util.Queue
        public MessageEvent poll() {
            MessageEvent messageEvent = (MessageEvent) super.poll();
            if (messageEvent != null) {
                int messageSize = getMessageSize(messageEvent);
                int iAddAndGet = NioSocketChannel.this.writeBufferSize.addAndGet(-messageSize);
                int writeBufferLowWaterMark = NioSocketChannel.this.getConfig().getWriteBufferLowWaterMark();
                if ((iAddAndGet == 0 || iAddAndGet < writeBufferLowWaterMark) && messageSize + iAddAndGet >= writeBufferLowWaterMark) {
                    NioSocketChannel.this.highWaterMarkCounter.decrementAndGet();
                    if (NioSocketChannel.this.isConnected() && !((Boolean) this.notifying.get()).booleanValue()) {
                        this.notifying.set(Boolean.TRUE);
                        Channels.fireChannelInterestChanged(NioSocketChannel.this);
                        this.notifying.set(Boolean.FALSE);
                    }
                }
            }
            return messageEvent;
        }
    }

    final class WriteTask implements Runnable {
        WriteTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NioSocketChannel.this.writeTaskInTaskQueue.set(false);
            NioSocketChannel.this.worker.writeFromTaskLoop(NioSocketChannel.this);
        }
    }

    static {
        $assertionsDisabled = !NioSocketChannel.class.desiredAssertionStatus();
    }

    public NioSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, java.nio.channels.SocketChannel socketChannel, NioWorker nioWorker) {
        super(channel, channelFactory, channelPipeline, channelSink);
        this.state = 0;
        this.interestOpsLock = new Object();
        this.writeLock = new Object();
        this.writeTask = new WriteTask();
        this.writeTaskInTaskQueue = new AtomicBoolean();
        this.writeBuffer = new WriteRequestQueue();
        this.writeBufferSize = new AtomicInteger();
        this.highWaterMarkCounter = new AtomicInteger();
        this.socket = socketChannel;
        this.worker = nioWorker;
        this.config = new DefaultNioSocketChannelConfig(socketChannel.socket());
        getCloseFuture().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.nio.NioSocketChannel.1
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                NioSocketChannel.this.state = -1;
            }
        });
    }

    @Override // org.jboss.netty.channel.Channel
    public NioSocketChannelConfig getConfig() {
        return this.config;
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public int getInterestOps() {
        if (!isOpen()) {
            return 4;
        }
        int rawInterestOps = getRawInterestOps();
        int i = this.writeBufferSize.get();
        return i != 0 ? this.highWaterMarkCounter.get() > 0 ? i >= getConfig().getWriteBufferLowWaterMark() ? rawInterestOps | 4 : rawInterestOps & (-5) : i >= getConfig().getWriteBufferHighWaterMark() ? rawInterestOps | 4 : rawInterestOps & (-5) : rawInterestOps & (-5);
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.socket().getLocalSocketAddress();
            this.localAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable th) {
            return null;
        }
    }

    int getRawInterestOps() {
        return super.getInterestOps();
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getRemoteAddress() {
        InetSocketAddress inetSocketAddress = this.remoteAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.socket().getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isBound() {
        return this.state >= 1;
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return this.state == 2;
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public boolean isOpen() {
        return this.state >= 0;
    }

    final void setBound() {
        if (!$assertionsDisabled && this.state != 0) {
            throw new AssertionError("Invalid state: " + this.state);
        }
        this.state = 1;
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    final void setConnected() {
        if (this.state != -1) {
            this.state = 2;
        }
    }

    void setRawInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return (socketAddress == null || socketAddress.equals(getRemoteAddress())) ? super.write(obj, null) : getUnsupportedOperationFuture();
    }
}
