package org.jboss.netty.handler.queue;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.internal.DeadLockProofWorker;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
public class BlockingReadHandler extends SimpleChannelUpstreamHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private volatile boolean closed;
    private final BlockingQueue queue;

    static {
        $assertionsDisabled = !BlockingReadHandler.class.desiredAssertionStatus();
    }

    public BlockingReadHandler() {
        this(new LinkedTransferQueue());
    }

    public BlockingReadHandler(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            throw new NullPointerException("queue");
        }
        this.queue = blockingQueue;
    }

    private void detectDeadLock() {
        if (DeadLockProofWorker.PARENT.get() != null) {
            throw new IllegalStateException("read*(...) in I/O thread causes a dead lock or sudden performance drop. Implement a state machine or call read*() from a different thread.");
        }
    }

    private Object getMessage(MessageEvent messageEvent) {
        return messageEvent.getMessage();
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws InterruptedException {
        this.closed = true;
        getQueue().put(channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws InterruptedException {
        getQueue().put(exceptionEvent);
    }

    protected BlockingQueue getQueue() {
        return this.queue;
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws InterruptedException {
        getQueue().put(messageEvent);
    }

    public Object read() throws IOException {
        ChannelEvent event = readEvent();
        if (event == null) {
            return null;
        }
        if (event instanceof MessageEvent) {
            return getMessage((MessageEvent) event);
        }
        if (event instanceof ExceptionEvent) {
            throw ((IOException) new IOException().initCause(((ExceptionEvent) event).getCause()));
        }
        throw new IllegalStateException();
    }

    public Object read(long j, TimeUnit timeUnit) throws IOException {
        ChannelEvent event = readEvent(j, timeUnit);
        if (event == null) {
            return null;
        }
        if (event instanceof MessageEvent) {
            return getMessage((MessageEvent) event);
        }
        if (event instanceof ExceptionEvent) {
            throw ((IOException) new IOException().initCause(((ExceptionEvent) event).getCause()));
        }
        throw new IllegalStateException();
    }

    public ChannelEvent readEvent() {
        detectDeadLock();
        if (isClosed() && getQueue().isEmpty()) {
            return null;
        }
        ChannelEvent channelEvent = (ChannelEvent) getQueue().take();
        if (!(channelEvent instanceof ChannelStateEvent)) {
            return channelEvent;
        }
        if ($assertionsDisabled || this.closed) {
            return null;
        }
        throw new AssertionError();
    }

    public ChannelEvent readEvent(long j, TimeUnit timeUnit) throws BlockingReadTimeoutException {
        detectDeadLock();
        if (isClosed() && getQueue().isEmpty()) {
            return null;
        }
        ChannelEvent channelEvent = (ChannelEvent) getQueue().poll(j, timeUnit);
        if (channelEvent == null) {
            throw new BlockingReadTimeoutException();
        }
        if (!(channelEvent instanceof ChannelStateEvent)) {
            return channelEvent;
        }
        if ($assertionsDisabled || this.closed) {
            return null;
        }
        throw new AssertionError();
    }
}
