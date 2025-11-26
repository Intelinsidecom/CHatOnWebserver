package org.jboss.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class ReadTimeoutHandler extends SimpleChannelUpstreamHandler implements LifeCycleAwareChannelHandler, ExternalResourceReleasable {
    static final ReadTimeoutException EXCEPTION = new ReadTimeoutException();
    final long timeoutMillis;
    final Timer timer;

    public ReadTimeoutHandler(Timer timer, int i) {
        this(timer, i, TimeUnit.SECONDS);
    }

    public ReadTimeoutHandler(Timer timer, long j, TimeUnit timeUnit) {
        if (timer == null) {
            throw new NullPointerException("timer");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        this.timer = timer;
        if (j <= 0) {
            this.timeoutMillis = 0L;
        } else {
            this.timeoutMillis = Math.max(timeUnit.toMillis(j), 1L);
        }
    }

    @Override // org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        this.timer.stop();
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeAdd(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getPipeline().isAttached()) {
            initialize(channelHandlerContext);
        }
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterAdd(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeRemove(ChannelHandlerContext channelHandlerContext) {
        destroy(channelHandlerContext);
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        initialize(channelHandlerContext);
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        destroy(channelHandlerContext);
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        ((State) channelHandlerContext.getAttachment()).lastReadTime = System.currentTimeMillis();
        channelHandlerContext.sendUpstream(messageEvent);
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        State state = new State();
        channelHandlerContext.setAttachment(state);
        if (this.timeoutMillis > 0) {
            state.timeout = this.timer.newTimeout(new ReadTimeoutTask(channelHandlerContext), this.timeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void destroy(ChannelHandlerContext channelHandlerContext) {
        State state = (State) channelHandlerContext.getAttachment();
        if (state.timeout != null) {
            state.timeout.cancel();
            state.timeout = null;
        }
    }

    protected void readTimedOut(ChannelHandlerContext channelHandlerContext) {
        Channels.fireExceptionCaught(channelHandlerContext, EXCEPTION);
    }

    final class ReadTimeoutTask implements TimerTask {
        private final ChannelHandlerContext ctx;

        ReadTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // org.jboss.netty.util.TimerTask
        public void run(Timeout timeout) {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                State state = (State) this.ctx.getAttachment();
                long jCurrentTimeMillis = ReadTimeoutHandler.this.timeoutMillis - (System.currentTimeMillis() - state.lastReadTime);
                if (jCurrentTimeMillis <= 0) {
                    state.timeout = ReadTimeoutHandler.this.timer.newTimeout(this, ReadTimeoutHandler.this.timeoutMillis, TimeUnit.MILLISECONDS);
                    try {
                        ReadTimeoutHandler.this.readTimedOut(this.ctx);
                        return;
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                        return;
                    }
                }
                state.timeout = ReadTimeoutHandler.this.timer.newTimeout(this, jCurrentTimeMillis, TimeUnit.MILLISECONDS);
            }
        }
    }

    final class State {
        volatile long lastReadTime = System.currentTimeMillis();
        volatile Timeout timeout;

        State() {
        }
    }
}
