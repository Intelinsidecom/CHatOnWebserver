package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
final class NioClientSocketChannel extends NioSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioClientSocketChannel.class);
    volatile boolean boundManually;
    long connectDeadlineNanos;
    volatile ChannelFuture connectFuture;

    private static SocketChannel newSocket() throws IOException {
        try {
            SocketChannel socketChannelOpen = SocketChannel.open();
            try {
                try {
                    socketChannelOpen.configureBlocking(false);
                    return socketChannelOpen;
                } catch (Throwable th) {
                    try {
                        socketChannelOpen.close();
                    } catch (IOException e) {
                        logger.warn("Failed to close a partially initialized socket.", e);
                    }
                    throw th;
                }
            } catch (IOException e2) {
                throw new ChannelException("Failed to enter non-blocking mode.", e2);
            }
        } catch (IOException e3) {
            throw new ChannelException("Failed to open a socket.", e3);
        }
    }

    NioClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, NioWorker nioWorker) {
        super(null, channelFactory, channelPipeline, channelSink, newSocket(), nioWorker);
        Channels.fireChannelOpen(this);
    }
}
