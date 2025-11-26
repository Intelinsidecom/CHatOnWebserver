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

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        OioDatagramChannel oioDatagramChannel = (OioDatagramChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (channelEvent instanceof ChannelStateEvent) {
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
                    if (value != null) {
                        bind(oioDatagramChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        OioDatagramWorker.close(oioDatagramChannel, future);
                        break;
                    }
                case CONNECTED:
                    if (value != null) {
                        connect(oioDatagramChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        OioDatagramWorker.disconnect(oioDatagramChannel, future);
                        break;
                    }
                case INTEREST_OPS:
                    OioDatagramWorker.setInterestOps(oioDatagramChannel, future, ((Integer) value).intValue());
                    break;
            }
            return;
        }
        if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            OioDatagramWorker.write(oioDatagramChannel, future, messageEvent.getMessage(), messageEvent.getRemoteAddress());
        }
    }

    private void bind(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            try {
                oioDatagramChannel.socket.bind(socketAddress);
                z = true;
                channelFuture.setSuccess();
                Channels.fireChannelBound(oioDatagramChannel, oioDatagramChannel.getLocalAddress());
                DeadLockProofWorker.start(this.workerExecutor, new ThreadRenamingRunnable(new OioDatagramWorker(oioDatagramChannel), "Old I/O datagram worker (" + oioDatagramChannel + ')'));
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(oioDatagramChannel, th);
                if (z) {
                    OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (z) {
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            }
            throw th2;
        }
    }

    private void connect(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean zIsBound = oioDatagramChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        oioDatagramChannel.remoteAddress = null;
        try {
            try {
                oioDatagramChannel.socket.connect(socketAddress);
                channelFuture.setSuccess();
                if (!zIsBound) {
                    Channels.fireChannelBound(oioDatagramChannel, oioDatagramChannel.getLocalAddress());
                }
                Channels.fireChannelConnected(oioDatagramChannel, oioDatagramChannel.getRemoteAddress());
                String str = "Old I/O datagram worker (" + oioDatagramChannel + ')';
                if (!zIsBound) {
                    DeadLockProofWorker.start(this.workerExecutor, new ThreadRenamingRunnable(new OioDatagramWorker(oioDatagramChannel), str));
                    return;
                }
                Thread thread = oioDatagramChannel.workerThread;
                if (thread != null) {
                    try {
                        thread.setName(str);
                    } catch (SecurityException e) {
                    }
                }
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(oioDatagramChannel, th);
                if (0 != 0) {
                    OioDatagramWorker.close(oioDatagramChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            }
            throw th2;
        }
    }
}
