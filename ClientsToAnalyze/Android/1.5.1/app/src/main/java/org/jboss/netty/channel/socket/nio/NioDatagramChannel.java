package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

/* loaded from: classes.dex */
class NioDatagramChannel extends AbstractChannel implements DatagramChannel {
    private final NioDatagramChannelConfig config;
    SocketSendBufferPool.SendBuffer currentWriteBuffer;
    MessageEvent currentWriteEvent;
    private final java.nio.channels.DatagramChannel datagramChannel;
    final AtomicInteger highWaterMarkCounter;
    boolean inWriteNowLoop;
    final Object interestOpsLock;
    private volatile InetSocketAddress localAddress;
    volatile InetSocketAddress remoteAddress;
    final NioDatagramWorker worker;
    final Queue writeBufferQueue;
    final AtomicInteger writeBufferSize;
    final Object writeLock;
    boolean writeSuspended;
    final Runnable writeTask;
    final AtomicBoolean writeTaskInTaskQueue;

    final class WriteRequestQueue extends LinkedTransferQueue {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final long serialVersionUID = 5057413071460766376L;
        private final ThreadLocalBoolean notifying = new ThreadLocalBoolean();

        static {
            $assertionsDisabled = !NioDatagramChannel.class.desiredAssertionStatus();
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
            int iAddAndGet = NioDatagramChannel.this.writeBufferSize.addAndGet(messageSize);
            int writeBufferHighWaterMark = NioDatagramChannel.this.getConfig().getWriteBufferHighWaterMark();
            if (iAddAndGet < writeBufferHighWaterMark || iAddAndGet - messageSize >= writeBufferHighWaterMark) {
                return true;
            }
            NioDatagramChannel.this.highWaterMarkCounter.incrementAndGet();
            if (((Boolean) this.notifying.get()).booleanValue()) {
                return true;
            }
            this.notifying.set(Boolean.TRUE);
            Channels.fireChannelInterestChanged(NioDatagramChannel.this);
            this.notifying.set(Boolean.FALSE);
            return true;
        }

        @Override // org.jboss.netty.util.internal.LinkedTransferQueue, java.util.Queue
        public MessageEvent poll() {
            MessageEvent messageEvent = (MessageEvent) super.poll();
            if (messageEvent != null) {
                int messageSize = getMessageSize(messageEvent);
                int iAddAndGet = NioDatagramChannel.this.writeBufferSize.addAndGet(-messageSize);
                int writeBufferLowWaterMark = NioDatagramChannel.this.getConfig().getWriteBufferLowWaterMark();
                if ((iAddAndGet == 0 || iAddAndGet < writeBufferLowWaterMark) && messageSize + iAddAndGet >= writeBufferLowWaterMark) {
                    NioDatagramChannel.this.highWaterMarkCounter.decrementAndGet();
                    if (NioDatagramChannel.this.isBound() && !((Boolean) this.notifying.get()).booleanValue()) {
                        this.notifying.set(Boolean.TRUE);
                        Channels.fireChannelInterestChanged(NioDatagramChannel.this);
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
            NioDatagramChannel.this.writeTaskInTaskQueue.set(false);
            NioDatagramChannel.this.worker.writeFromTaskLoop(NioDatagramChannel.this);
        }
    }

    NioDatagramChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, NioDatagramWorker nioDatagramWorker) {
        super(null, channelFactory, channelPipeline, channelSink);
        this.interestOpsLock = new Object();
        this.writeLock = new Object();
        this.writeTask = new WriteTask();
        this.writeTaskInTaskQueue = new AtomicBoolean();
        this.writeBufferQueue = new WriteRequestQueue();
        this.writeBufferSize = new AtomicInteger();
        this.highWaterMarkCounter = new AtomicInteger();
        this.worker = nioDatagramWorker;
        this.datagramChannel = openNonBlockingChannel();
        this.config = new DefaultNioDatagramChannelConfig(this.datagramChannel.socket());
        Channels.fireChannelOpen(this);
    }

    private java.nio.channels.DatagramChannel openNonBlockingChannel() throws IOException {
        try {
            java.nio.channels.DatagramChannel datagramChannelOpen = java.nio.channels.DatagramChannel.open();
            datagramChannelOpen.configureBlocking(false);
            return datagramChannelOpen;
        } catch (IOException e) {
            throw new ChannelException("Failed to open a DatagramChannel.", e);
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public NioDatagramChannelConfig getConfig() {
        return this.config;
    }

    java.nio.channels.DatagramChannel getDatagramChannel() {
        return this.datagramChannel;
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
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.datagramChannel.socket().getLocalSocketAddress();
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
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.datagramChannel.socket().getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isBound() {
        return isOpen() && this.datagramChannel.socket().isBound();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return this.datagramChannel.isConnected();
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void joinGroup(InetAddress inetAddress) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void leaveGroup(InetAddress inetAddress) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    void setRawInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return (socketAddress == null || socketAddress.equals(getRemoteAddress())) ? super.write(obj, null) : super.write(obj, socketAddress);
    }
}
