package org.jboss.netty.channel.socket.oio;

import java.net.SocketAddress;
import java.util.concurrent.Executor;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
class OioClientSocketPipelineSink extends AbstractChannelSink {
    private final Executor workerExecutor;

    OioClientSocketPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Throwable {
        OioClientSocketChannel oioClientSocketChannel = (OioClientSocketChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (channelEvent instanceof ChannelStateEvent) {
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
                    if (value != null) {
                        bind(oioClientSocketChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        OioWorker.close(oioClientSocketChannel, future);
                        break;
                    }
                case CONNECTED:
                    if (value != null) {
                        connect(oioClientSocketChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        OioWorker.close(oioClientSocketChannel, future);
                        break;
                    }
                case INTEREST_OPS:
                    OioWorker.setInterestOps(oioClientSocketChannel, future, ((Integer) value).intValue());
                    break;
            }
            return;
        }
        if (channelEvent instanceof MessageEvent) {
            OioWorker.write(oioClientSocketChannel, future, ((MessageEvent) channelEvent).getMessage());
        }
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void connect(org.jboss.netty.channel.socket.oio.OioClientSocketChannel r7, org.jboss.netty.channel.ChannelFuture r8, java.net.SocketAddress r9) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 1
            boolean r0 = r7.isBound()
            r2 = 0
            org.jboss.netty.channel.ChannelFutureListener r3 = org.jboss.netty.channel.ChannelFutureListener.CLOSE_ON_FAILURE
            r8.addListener(r3)
            java.net.Socket r3 = r7.socket     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L78
            org.jboss.netty.channel.socket.SocketChannelConfig r4 = r7.getConfig()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L78
            int r4 = r4.getConnectTimeoutMillis()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L78
            r3.connect(r9, r4)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L78
            java.io.PushbackInputStream r2 = new java.io.PushbackInputStream     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.net.Socket r3 = r7.socket     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r4 = 1
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r7.f7859in = r2     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.net.Socket r2 = r7.socket     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r7.out = r2     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r8.setSuccess()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            if (r0 != 0) goto L3a
            java.net.InetSocketAddress r0 = r7.getLocalAddress()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            org.jboss.netty.channel.Channels.fireChannelBound(r7, r0)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
        L3a:
            java.net.InetSocketAddress r0 = r7.getRemoteAddress()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            org.jboss.netty.channel.Channels.fireChannelConnected(r7, r0)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.util.concurrent.Executor r0 = r6.workerExecutor     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            org.jboss.netty.util.ThreadRenamingRunnable r2 = new org.jboss.netty.util.ThreadRenamingRunnable     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            org.jboss.netty.channel.socket.oio.OioWorker r3 = new org.jboss.netty.channel.socket.oio.OioWorker     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r4.<init>()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.lang.String r5 = "Old I/O client worker ("
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r5 = 41
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
            org.jboss.netty.util.internal.DeadLockProofWorker.start(r0, r2)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
        L69:
            return
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            r8.setFailure(r0)     // Catch: java.lang.Throwable -> L80
            org.jboss.netty.channel.Channels.fireExceptionCaught(r7, r0)     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L69
            org.jboss.netty.channel.socket.oio.OioWorker.close(r7, r8)
            goto L69
        L78:
            r0 = move-exception
            r1 = r2
        L7a:
            if (r1 == 0) goto L7f
            org.jboss.netty.channel.socket.oio.OioWorker.close(r7, r8)
        L7f:
            throw r0
        L80:
            r0 = move-exception
            goto L7a
        L82:
            r0 = move-exception
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioClientSocketPipelineSink.connect(org.jboss.netty.channel.socket.oio.OioClientSocketChannel, org.jboss.netty.channel.ChannelFuture, java.net.SocketAddress):void");
    }
}
