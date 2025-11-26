package org.jboss.netty.handler.execution;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.internal.ExecutorUtil;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class ExecutionHandler implements ChannelDownstreamHandler, ChannelUpstreamHandler, ExternalResourceReleasable {
    private final Executor executor;

    public ExecutionHandler(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("executor");
        }
        this.executor = executor;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            if (channelStateEvent.getState() == ChannelState.INTEREST_OPS && (((Integer) channelStateEvent.getValue()).intValue() & 1) != 0) {
                if (channelHandlerContext.getAttachment() != null) {
                    channelEvent.getFuture().setSuccess();
                    return;
                }
            }
        }
        channelHandlerContext.sendDownstream(channelEvent);
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.executor.execute(new ChannelEventRunnable(channelHandlerContext, channelEvent));
    }

    @Override // org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        ExecutorUtil.terminate(getExecutor());
    }
}
