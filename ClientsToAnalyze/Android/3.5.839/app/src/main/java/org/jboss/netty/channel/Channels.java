package org.jboss.netty.channel;

import java.net.SocketAddress;
import java.util.Map;

/* loaded from: classes.dex */
public class Channels {
    public static ChannelPipeline pipeline() {
        return new DefaultChannelPipeline();
    }

    public static ChannelPipeline pipeline(ChannelPipeline channelPipeline) {
        ChannelPipeline channelPipelinePipeline = pipeline();
        for (Map.Entry<String, ChannelHandler> entry : channelPipeline.toMap().entrySet()) {
            channelPipelinePipeline.addLast(entry.getKey(), entry.getValue());
        }
        return channelPipelinePipeline;
    }

    public static ChannelPipelineFactory pipelineFactory(final ChannelPipeline channelPipeline) {
        return new ChannelPipelineFactory() { // from class: org.jboss.netty.channel.Channels.1
            @Override // org.jboss.netty.channel.ChannelPipelineFactory
            public ChannelPipeline getPipeline() {
                return Channels.pipeline(channelPipeline);
            }
        };
    }

    public static ChannelFuture future(Channel channel) {
        return future(channel, false);
    }

    public static ChannelFuture future(Channel channel, boolean z) {
        return new DefaultChannelFuture(channel, z);
    }

    public static ChannelFuture succeededFuture(Channel channel) {
        return channel instanceof AbstractChannel ? ((AbstractChannel) channel).getSucceededFuture() : new SucceededChannelFuture(channel);
    }

    public static ChannelFuture failedFuture(Channel channel, Throwable th) {
        return new FailedChannelFuture(channel, th);
    }

    public static void fireChannelOpen(Channel channel) {
        if (channel.getParent() != null) {
            fireChildChannelStateChanged(channel.getParent(), channel);
        }
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.OPEN, Boolean.TRUE));
    }

    public static void fireChannelBound(Channel channel, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.BOUND, socketAddress));
    }

    public static void fireChannelConnected(Channel channel, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.CONNECTED, socketAddress));
    }

    public static void fireMessageReceived(Channel channel, Object obj) {
        fireMessageReceived(channel, obj, (SocketAddress) null);
    }

    public static void fireMessageReceived(Channel channel, Object obj, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamMessageEvent(channel, obj, socketAddress));
    }

    public static void fireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj, SocketAddress socketAddress) {
        channelHandlerContext.sendUpstream(new UpstreamMessageEvent(channelHandlerContext.getChannel(), obj, socketAddress));
    }

    public static void fireWriteComplete(Channel channel, long j) {
        if (j != 0) {
            channel.getPipeline().sendUpstream(new DefaultWriteCompletionEvent(channel, j));
        }
    }

    public static void fireChannelInterestChanged(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.INTEREST_OPS, 1));
    }

    public static void fireChannelDisconnected(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.CONNECTED, null));
    }

    public static void fireChannelDisconnected(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.CONNECTED, null));
    }

    public static void fireChannelUnbound(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.BOUND, null));
    }

    public static void fireChannelClosed(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.OPEN, Boolean.FALSE));
        if (channel.getParent() != null) {
            fireChildChannelStateChanged(channel.getParent(), channel);
        }
    }

    public static void fireChannelClosed(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.OPEN, Boolean.FALSE));
    }

    public static void fireExceptionCaught(Channel channel, Throwable th) {
        channel.getPipeline().sendUpstream(new DefaultExceptionEvent(channel, th));
    }

    public static void fireExceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.sendUpstream(new DefaultExceptionEvent(channelHandlerContext.getChannel(), th));
    }

    private static void fireChildChannelStateChanged(Channel channel, Channel channel2) {
        channel.getPipeline().sendUpstream(new DefaultChildChannelStateEvent(channel, channel2));
    }

    public static ChannelFuture bind(Channel channel, SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        ChannelFuture channelFutureFuture = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, channelFutureFuture, ChannelState.BOUND, socketAddress));
        return channelFutureFuture;
    }

    public static ChannelFuture connect(Channel channel, SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        ChannelFuture channelFutureFuture = future(channel, true);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, channelFutureFuture, ChannelState.CONNECTED, socketAddress));
        return channelFutureFuture;
    }

    public static ChannelFuture write(Channel channel, Object obj) {
        return write(channel, obj, (SocketAddress) null);
    }

    public static void write(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, Object obj) {
        write(channelHandlerContext, channelFuture, obj, null);
    }

    public static ChannelFuture write(Channel channel, Object obj, SocketAddress socketAddress) {
        ChannelFuture channelFutureFuture = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamMessageEvent(channel, channelFutureFuture, obj, socketAddress));
        return channelFutureFuture;
    }

    public static void write(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, Object obj, SocketAddress socketAddress) {
        channelHandlerContext.sendDownstream(new DownstreamMessageEvent(channelHandlerContext.getChannel(), channelFuture, obj, socketAddress));
    }

    public static ChannelFuture disconnect(Channel channel) {
        ChannelFuture channelFutureFuture = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, channelFutureFuture, ChannelState.CONNECTED, null));
        return channelFutureFuture;
    }

    public static ChannelFuture close(Channel channel) {
        ChannelFuture closeFuture = channel.getCloseFuture();
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, closeFuture, ChannelState.OPEN, Boolean.FALSE));
        return closeFuture;
    }

    public static void close(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.OPEN, Boolean.FALSE));
    }
}
