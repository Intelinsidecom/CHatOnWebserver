package org.jboss.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
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

/* loaded from: classes.dex */
public class ReadTimeoutHandler extends SimpleChannelUpstreamHandler implements LifeCycleAwareChannelHandler, ExternalResourceReleasable {
    static final ReadTimeoutException EXCEPTION = new ReadTimeoutException();
    volatile long lastReadTime;
    private volatile ReadTimeoutTask task;
    volatile Timeout timeout;
    final long timeoutMillis;
    final Timer timer;

    final class ReadTimeoutTask implements TimerTask {
        private final ChannelHandlerContext ctx;

        ReadTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // org.jboss.netty.util.TimerTask
        public void run(Timeout timeout) {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                long jCurrentTimeMillis = ReadTimeoutHandler.this.timeoutMillis - (System.currentTimeMillis() - ReadTimeoutHandler.this.lastReadTime);
                if (jCurrentTimeMillis > 0) {
                    ReadTimeoutHandler.this.timeout = ReadTimeoutHandler.this.timer.newTimeout(this, jCurrentTimeMillis, TimeUnit.MILLISECONDS);
                    return;
                }
                ReadTimeoutHandler.this.timeout = ReadTimeoutHandler.this.timer.newTimeout(this, ReadTimeoutHandler.this.timeoutMillis, TimeUnit.MILLISECONDS);
                try {
                    ReadTimeoutHandler.this.readTimedOut(this.ctx);
                } catch (Throwable th) {
                    Channels.fireExceptionCaught(this.ctx, th);
                }
            }
        }
    }

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

    private void destroy() {
        if (this.timeout != null) {
            this.timeout.cancel();
        }
        this.timeout = null;
        this.task = null;
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        updateLastReadTime();
        this.task = new ReadTimeoutTask(channelHandlerContext);
        if (this.timeoutMillis > 0) {
            this.timeout = this.timer.newTimeout(this.task, this.timeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void updateLastReadTime() {
        this.lastReadTime = System.currentTimeMillis();
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterAdd(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeAdd(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getPipeline().isAttached()) {
            initialize(channelHandlerContext);
        }
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeRemove(ChannelHandlerContext channelHandlerContext) {
        destroy();
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        destroy();
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        initialize(channelHandlerContext);
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        updateLastReadTime();
        channelHandlerContext.sendUpstream(messageEvent);
    }

    protected void readTimedOut(ChannelHandlerContext channelHandlerContext) {
        Channels.fireExceptionCaught(channelHandlerContext, EXCEPTION);
    }

    @Override // org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        this.timer.stop();
    }
}
