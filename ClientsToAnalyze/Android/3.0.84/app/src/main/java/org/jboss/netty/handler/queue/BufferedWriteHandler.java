package org.jboss.netty.handler.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
public class BufferedWriteHandler extends SimpleChannelHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final boolean consolidateOnFlush;
    private volatile ChannelHandlerContext ctx;
    private final Queue<MessageEvent> queue;

    static {
        $assertionsDisabled = !BufferedWriteHandler.class.desiredAssertionStatus();
    }

    public BufferedWriteHandler() {
        this(false);
    }

    public BufferedWriteHandler(Queue<MessageEvent> queue) {
        this(queue, false);
    }

    public BufferedWriteHandler(boolean z) {
        this(new LinkedTransferQueue(), z);
    }

    public BufferedWriteHandler(Queue<MessageEvent> queue, boolean z) {
        if (queue == null) {
            throw new NullPointerException("queue");
        }
        this.queue = queue;
        this.consolidateOnFlush = z;
    }

    public boolean isConsolidateOnFlush() {
        return this.consolidateOnFlush;
    }

    protected Queue<MessageEvent> getQueue() {
        return this.queue;
    }

    public void flush() {
        flush(this.consolidateOnFlush);
    }

    public void flush(boolean z) {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            Queue<MessageEvent> queue = getQueue();
            if (z) {
                if (!queue.isEmpty()) {
                    List<MessageEvent> arrayList = new ArrayList<>();
                    synchronized (this) {
                        while (true) {
                            MessageEvent messageEventPoll = queue.poll();
                            if (messageEventPoll != null) {
                                if (!(messageEventPoll.getMessage() instanceof ChannelBuffer)) {
                                    arrayList = consolidatedWrite(arrayList);
                                    if (arrayList == null) {
                                        arrayList = new ArrayList<>();
                                    }
                                    channelHandlerContext.sendDownstream(messageEventPoll);
                                } else {
                                    arrayList.add(messageEventPoll);
                                }
                                arrayList = arrayList;
                            } else {
                                consolidatedWrite(arrayList);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            synchronized (this) {
                while (true) {
                    MessageEvent messageEventPoll2 = queue.poll();
                    if (messageEventPoll2 != null) {
                        channelHandlerContext.sendDownstream(messageEventPoll2);
                    }
                }
            }
        }
    }

    private List<MessageEvent> consolidatedWrite(final List<MessageEvent> list) {
        int i = 0;
        int size = list.size();
        if (size == 1) {
            this.ctx.sendDownstream(list.remove(0));
            return list;
        }
        if (size != 0) {
            ChannelBuffer[] channelBufferArr = new ChannelBuffer[size];
            while (true) {
                int i2 = i;
                if (i2 < channelBufferArr.length) {
                    channelBufferArr[i2] = (ChannelBuffer) list.get(i2).getMessage();
                    i = i2 + 1;
                } else {
                    ChannelBuffer channelBufferWrappedBuffer = ChannelBuffers.wrappedBuffer(channelBufferArr);
                    ChannelFuture channelFutureFuture = Channels.future(this.ctx.getChannel());
                    channelFutureFuture.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.handler.queue.BufferedWriteHandler.1
                        @Override // org.jboss.netty.channel.ChannelFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    ((MessageEvent) it.next()).getFuture().setSuccess();
                                }
                            } else {
                                Throwable cause = channelFuture.getCause();
                                Iterator it2 = list.iterator();
                                while (it2.hasNext()) {
                                    ((MessageEvent) it2.next()).getFuture().setFailure(cause);
                                }
                            }
                        }
                    });
                    Channels.write(this.ctx, channelFutureFuture, channelBufferWrappedBuffer);
                    return null;
                }
            }
        } else {
            return list;
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (this.ctx == null) {
            this.ctx = channelHandlerContext;
        } else if (!$assertionsDisabled && this.ctx != channelHandlerContext) {
            throw new AssertionError();
        }
        getQueue().add(messageEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void disconnectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        try {
            flush(this.consolidateOnFlush);
        } finally {
            channelHandlerContext.sendDownstream(channelStateEvent);
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void closeRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        try {
            flush(this.consolidateOnFlush);
        } finally {
            channelHandlerContext.sendDownstream(channelStateEvent);
        }
    }
}
