package org.jboss.netty.channel.socket.oio;

import java.net.SocketAddress;
import java.util.concurrent.Executor;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
class OioDatagramPipelineSink extends AbstractChannelSink {
    private final Executor workerExecutor;

    OioDatagramPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    private void bind(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) throws Throwable {
        boolean z;
        try {
            oioDatagramChannel.socket.bind(socketAddress);
            try {
                channelFuture.setSuccess();
                Channels.fireChannelBound(oioDatagramChannel, oioDatagramChannel.getLocalAddress());
                DeadLockProofWorker.start(this.workerExecutor, new ThreadRenamingRunnable(new OioDatagramWorker(oioDatagramChannel), "Old I/O datagram worker (" + oioDatagramChannel + ')'));
                if (1 == 0 || 1 != 0) {
                    return;
                }
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            } catch (Throwable th) {
                th = th;
                z = true;
                try {
                    channelFuture.setFailure(th);
                    Channels.fireExceptionCaught(oioDatagramChannel, th);
                    if (z && 0 == 0) {
                        OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z && 0 == 0) {
                        OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    private void connect(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) throws Throwable {
        boolean z;
        boolean zIsBound = oioDatagramChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        oioDatagramChannel.remoteAddress = null;
        try {
            oioDatagramChannel.socket.connect(socketAddress);
            try {
                channelFuture.setSuccess();
                if (!zIsBound) {
                    Channels.fireChannelBound(oioDatagramChannel, oioDatagramChannel.getLocalAddress());
                }
                Channels.fireChannelConnected(oioDatagramChannel, oioDatagramChannel.getRemoteAddress());
                String str = "Old I/O datagram worker (" + oioDatagramChannel + ')';
                if (zIsBound) {
                    Thread thread = oioDatagramChannel.workerThread;
                    if (thread != null) {
                        try {
                            thread.setName(str);
                        } catch (SecurityException e) {
                        }
                    }
                } else {
                    DeadLockProofWorker.start(this.workerExecutor, new ThreadRenamingRunnable(new OioDatagramWorker(oioDatagramChannel), str));
                }
                if (1 == 0 || 1 != 0) {
                    return;
                }
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            } catch (Throwable th) {
                th = th;
                z = true;
                try {
                    channelFuture.setFailure(th);
                    Channels.fireExceptionCaught(oioDatagramChannel, th);
                    if (z && 0 == 0) {
                        OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z && 0 == 0) {
                        OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Throwable {
        OioDatagramChannel oioDatagramChannel = (OioDatagramChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof MessageEvent) {
                MessageEvent messageEvent = (MessageEvent) channelEvent;
                OioDatagramWorker.write(oioDatagramChannel, future, messageEvent.getMessage(), messageEvent.getRemoteAddress());
                return;
            }
            return;
        }
        ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
        ChannelState state = channelStateEvent.getState();
        Object value = channelStateEvent.getValue();
        switch (state) {
            case OPEN:
                if (Boolean.FALSE.equals(value)) {
                    OioDatagramWorker.close(oioDatagramChannel, future);
                    break;
                }
                break;
            case BOUND:
                if (value == null) {
                    OioDatagramWorker.close(oioDatagramChannel, future);
                    break;
                } else {
                    bind(oioDatagramChannel, future, (SocketAddress) value);
                    break;
                }
            case CONNECTED:
                if (value == null) {
                    OioDatagramWorker.disconnect(oioDatagramChannel, future);
                    break;
                } else {
                    connect(oioDatagramChannel, future, (SocketAddress) value);
                    break;
                }
            case INTEREST_OPS:
                OioDatagramWorker.setInterestOps(oioDatagramChannel, future, ((Integer) value).intValue());
                break;
        }
    }
}
