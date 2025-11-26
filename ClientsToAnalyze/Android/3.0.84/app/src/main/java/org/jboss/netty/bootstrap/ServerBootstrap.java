package org.jboss.netty.bootstrap;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ChildChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.ServerChannelFactory;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

/* loaded from: classes.dex */
public class ServerBootstrap extends Bootstrap {
    private volatile ChannelHandler parentHandler;

    public ServerBootstrap() {
    }

    public ServerBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
    }

    @Override // org.jboss.netty.bootstrap.Bootstrap
    public void setFactory(ChannelFactory channelFactory) {
        if (channelFactory == null) {
            throw new NullPointerException("factory");
        }
        if (!(channelFactory instanceof ServerChannelFactory)) {
            throw new IllegalArgumentException("factory must be a " + ServerChannelFactory.class.getSimpleName() + ": " + channelFactory.getClass());
        }
        super.setFactory(channelFactory);
    }

    public ChannelHandler getParentHandler() {
        return this.parentHandler;
    }

    public void setParentHandler(ChannelHandler channelHandler) {
        this.parentHandler = channelHandler;
    }

    public Channel bind() {
        SocketAddress socketAddress = (SocketAddress) getOption("localAddress");
        if (socketAddress == null) {
            throw new IllegalStateException("localAddress option is not set.");
        }
        return bind(socketAddress);
    }

    public Channel bind(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Binder binder = new Binder(socketAddress, linkedBlockingQueue);
        ChannelHandler parentHandler = getParentHandler();
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("binder", binder);
        if (parentHandler != null) {
            channelPipelinePipeline.addLast("userHandler", parentHandler);
        }
        Channel channelNewChannel = getFactory().newChannel(channelPipelinePipeline);
        ChannelFuture channelFuture = null;
        boolean z = false;
        do {
            ChannelFuture channelFuture2 = channelFuture;
            boolean z2 = z;
            try {
                channelFuture = (ChannelFuture) linkedBlockingQueue.poll(2147483647L, TimeUnit.SECONDS);
                z = z2;
            } catch (InterruptedException e) {
                z = true;
                channelFuture = channelFuture2;
            }
        } while (channelFuture == null);
        if (z) {
            Thread.currentThread().interrupt();
        }
        channelFuture.awaitUninterruptibly();
        if (!channelFuture.isSuccess()) {
            channelFuture.getChannel().close().awaitUninterruptibly();
            throw new ChannelException("Failed to bind to: " + socketAddress, channelFuture.getCause());
        }
        return channelNewChannel;
    }

    final class Binder extends SimpleChannelUpstreamHandler {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final Map<String, Object> childOptions = new HashMap();
        private final BlockingQueue<ChannelFuture> futureQueue;
        private final SocketAddress localAddress;

        static {
            $assertionsDisabled = !ServerBootstrap.class.desiredAssertionStatus();
        }

        Binder(SocketAddress socketAddress, BlockingQueue<ChannelFuture> blockingQueue) {
            this.localAddress = socketAddress;
            this.futureQueue = blockingQueue;
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            try {
                channelStateEvent.getChannel().getConfig().setPipelineFactory(ServerBootstrap.this.getPipelineFactory());
                Map<String, Object> options = ServerBootstrap.this.getOptions();
                HashMap map = new HashMap();
                for (Map.Entry<String, Object> entry : options.entrySet()) {
                    if (entry.getKey().startsWith("child.")) {
                        this.childOptions.put(entry.getKey().substring(6), entry.getValue());
                    } else if (!entry.getKey().equals("pipelineFactory")) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
                channelStateEvent.getChannel().getConfig().setOptions(map);
                channelHandlerContext.sendUpstream(channelStateEvent);
                boolean zOffer = this.futureQueue.offer(channelStateEvent.getChannel().bind(this.localAddress));
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
            } catch (Throwable th) {
                channelHandlerContext.sendUpstream(channelStateEvent);
                throw th;
            }
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void childChannelOpen(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) {
            childChannelStateEvent.getChildChannel().getConfig().setOptions(this.childOptions);
            channelHandlerContext.sendUpstream(childChannelStateEvent);
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
            boolean zOffer = this.futureQueue.offer(Channels.failedFuture(exceptionEvent.getChannel(), exceptionEvent.getCause()));
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            channelHandlerContext.sendUpstream(exceptionEvent);
        }
    }
}
