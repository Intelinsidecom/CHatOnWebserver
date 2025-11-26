package org.jboss.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class IdleStateHandler extends SimpleChannelUpstreamHandler implements LifeCycleAwareChannelHandler, ExternalResourceReleasable {
    final long allIdleTimeMillis;
    final long readerIdleTimeMillis;
    final Timer timer;
    final long writerIdleTimeMillis;

    public IdleStateHandler(Timer timer, int i, int i2, int i3) {
        this(timer, i, i2, i3, TimeUnit.SECONDS);
    }

    public IdleStateHandler(Timer timer, long j, long j2, long j3, TimeUnit timeUnit) {
        if (timer == null) {
            throw new NullPointerException("timer");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        this.timer = timer;
        if (j <= 0) {
            this.readerIdleTimeMillis = 0L;
        } else {
            this.readerIdleTimeMillis = Math.max(timeUnit.toMillis(j), 1L);
        }
        if (j2 <= 0) {
            this.writerIdleTimeMillis = 0L;
        } else {
            this.writerIdleTimeMillis = Math.max(timeUnit.toMillis(j2), 1L);
        }
        if (j3 <= 0) {
            this.allIdleTimeMillis = 0L;
        } else {
            this.allIdleTimeMillis = Math.max(timeUnit.toMillis(j3), 1L);
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

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) {
        if (writeCompletionEvent.getWrittenAmount() > 0) {
            ((State) channelHandlerContext.getAttachment()).lastWriteTime = System.currentTimeMillis();
        }
        channelHandlerContext.sendUpstream(writeCompletionEvent);
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        State state = new State();
        channelHandlerContext.setAttachment(state);
        long jCurrentTimeMillis = System.currentTimeMillis();
        state.lastWriteTime = jCurrentTimeMillis;
        state.lastReadTime = jCurrentTimeMillis;
        if (this.readerIdleTimeMillis > 0) {
            state.readerIdleTimeout = this.timer.newTimeout(new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
        if (this.writerIdleTimeMillis > 0) {
            state.writerIdleTimeout = this.timer.newTimeout(new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
        if (this.allIdleTimeMillis > 0) {
            state.allIdleTimeout = this.timer.newTimeout(new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void destroy(ChannelHandlerContext channelHandlerContext) {
        State state = (State) channelHandlerContext.getAttachment();
        if (state.readerIdleTimeout != null) {
            state.readerIdleTimeout.cancel();
            state.readerIdleTimeout = null;
        }
        if (state.writerIdleTimeout != null) {
            state.writerIdleTimeout.cancel();
            state.writerIdleTimeout = null;
        }
        if (state.allIdleTimeout != null) {
            state.allIdleTimeout.cancel();
            state.allIdleTimeout = null;
        }
    }

    protected void channelIdle(ChannelHandlerContext channelHandlerContext, IdleState idleState, long j) {
        channelHandlerContext.sendUpstream(new DefaultIdleStateEvent(channelHandlerContext.getChannel(), idleState, j));
    }

    final class ReaderIdleTimeoutTask implements TimerTask {
        private final ChannelHandlerContext ctx;

        ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // org.jboss.netty.util.TimerTask
        public void run(Timeout timeout) {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                State state = (State) this.ctx.getAttachment();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = state.lastReadTime;
                long j2 = IdleStateHandler.this.readerIdleTimeMillis - (jCurrentTimeMillis - j);
                if (j2 <= 0) {
                    state.readerIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, IdleStateHandler.this.readerIdleTimeMillis, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.READER_IDLE, j);
                        return;
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                        return;
                    }
                }
                state.readerIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, j2, TimeUnit.MILLISECONDS);
            }
        }
    }

    final class WriterIdleTimeoutTask implements TimerTask {
        private final ChannelHandlerContext ctx;

        WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // org.jboss.netty.util.TimerTask
        public void run(Timeout timeout) {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                State state = (State) this.ctx.getAttachment();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = state.lastWriteTime;
                long j2 = IdleStateHandler.this.writerIdleTimeMillis - (jCurrentTimeMillis - j);
                if (j2 <= 0) {
                    state.writerIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, IdleStateHandler.this.writerIdleTimeMillis, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.WRITER_IDLE, j);
                        return;
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                        return;
                    }
                }
                state.writerIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, j2, TimeUnit.MILLISECONDS);
            }
        }
    }

    final class AllIdleTimeoutTask implements TimerTask {
        private final ChannelHandlerContext ctx;

        AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // org.jboss.netty.util.TimerTask
        public void run(Timeout timeout) {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                State state = (State) this.ctx.getAttachment();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jMax = Math.max(state.lastReadTime, state.lastWriteTime);
                long j = IdleStateHandler.this.allIdleTimeMillis - (jCurrentTimeMillis - jMax);
                if (j <= 0) {
                    state.allIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, IdleStateHandler.this.allIdleTimeMillis, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.ALL_IDLE, jMax);
                        return;
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                        return;
                    }
                }
                state.allIdleTimeout = IdleStateHandler.this.timer.newTimeout(this, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    final class State {
        volatile Timeout allIdleTimeout;
        volatile long lastReadTime;
        volatile long lastWriteTime;
        volatile Timeout readerIdleTimeout;
        volatile Timeout writerIdleTimeout;

        State() {
        }
    }
}
