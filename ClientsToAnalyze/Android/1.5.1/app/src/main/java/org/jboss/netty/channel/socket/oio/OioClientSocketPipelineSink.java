package org.jboss.netty.channel.socket.oio;

import java.io.PushbackInputStream;
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
class OioClientSocketPipelineSink extends AbstractChannelSink {
    private final Executor workerExecutor;

    OioClientSocketPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    private void bind(OioClientSocketChannel oioClientSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            oioClientSocketChannel.socket.bind(socketAddress);
            channelFuture.setSuccess();
            Channels.fireChannelBound(oioClientSocketChannel, oioClientSocketChannel.getLocalAddress());
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioClientSocketChannel, th);
        }
    }

    private void connect(OioClientSocketChannel oioClientSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) throws Throwable {
        boolean z;
        boolean zIsBound = oioClientSocketChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        try {
            oioClientSocketChannel.socket.connect(socketAddress, oioClientSocketChannel.getConfig().getConnectTimeoutMillis());
            try {
                oioClientSocketChannel.f4569in = new PushbackInputStream(oioClientSocketChannel.socket.getInputStream(), 1);
                oioClientSocketChannel.out = oioClientSocketChannel.socket.getOutputStream();
                channelFuture.setSuccess();
                if (!zIsBound) {
                    Channels.fireChannelBound(oioClientSocketChannel, oioClientSocketChannel.getLocalAddress());
                }
                Channels.fireChannelConnected(oioClientSocketChannel, oioClientSocketChannel.getRemoteAddress());
                DeadLockProofWorker.start(this.workerExecutor, new ThreadRenamingRunnable(new OioWorker(oioClientSocketChannel), "Old I/O client worker (" + oioClientSocketChannel + ')'));
                if (1 == 0 || 1 != 0) {
                    return;
                }
                OioWorker.close(oioClientSocketChannel, channelFuture);
            } catch (Throwable th) {
                th = th;
                z = true;
                try {
                    channelFuture.setFailure(th);
                    Channels.fireExceptionCaught(oioClientSocketChannel, th);
                    if (z && 0 == 0) {
                        OioWorker.close(oioClientSocketChannel, channelFuture);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z && 0 == 0) {
                        OioWorker.close(oioClientSocketChannel, channelFuture);
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
        OioClientSocketChannel oioClientSocketChannel = (OioClientSocketChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof MessageEvent) {
                OioWorker.write(oioClientSocketChannel, future, ((MessageEvent) channelEvent).getMessage());
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
                    OioWorker.close(oioClientSocketChannel, future);
                    break;
                }
                break;
            case BOUND:
                if (value == null) {
                    OioWorker.close(oioClientSocketChannel, future);
                    break;
                } else {
                    bind(oioClientSocketChannel, future, (SocketAddress) value);
                    break;
                }
            case CONNECTED:
                if (value == null) {
                    OioWorker.close(oioClientSocketChannel, future);
                    break;
                } else {
                    connect(oioClientSocketChannel, future, (SocketAddress) value);
                    break;
                }
            case INTEREST_OPS:
                OioWorker.setInterestOps(oioClientSocketChannel, future, ((Integer) value).intValue());
                break;
        }
    }
}
