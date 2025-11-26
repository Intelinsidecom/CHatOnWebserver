package org.jboss.netty.handler.stream;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
public class ChunkedWriteHandler implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final InternalLogger logger;
    private ChannelHandlerContext ctx;
    private MessageEvent currentEvent;
    private final Queue queue = new LinkedTransferQueue();

    static {
        $assertionsDisabled = !ChunkedWriteHandler.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    }

    static void closeInput(ChunkedInput chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th) {
            logger.warn("Failed to close a chunked input.", th);
        }
    }

    private synchronized void discard(ChannelHandlerContext channelHandlerContext) {
        while (true) {
            if (this.currentEvent == null) {
                this.currentEvent = (MessageEvent) this.queue.poll();
            }
            if (this.currentEvent != null) {
                MessageEvent messageEvent = this.currentEvent;
                this.currentEvent = null;
                Object message = messageEvent.getMessage();
                if (message instanceof ChunkedInput) {
                    closeInput((ChunkedInput) message);
                    Channels.write(channelHandlerContext, messageEvent.getFuture(), ChannelBuffers.EMPTY_BUFFER, messageEvent.getRemoteAddress());
                } else {
                    channelHandlerContext.sendDownstream(messageEvent);
                }
            }
        }
    }

    private synchronized void flush(ChannelHandlerContext channelHandlerContext) {
        Object obj;
        boolean z;
        ChannelFuture channelFutureFuture;
        Channel channel = channelHandlerContext.getChannel();
        if (!channel.isConnected()) {
            discard(channelHandlerContext);
        }
        while (true) {
            if (!channel.isWritable()) {
                break;
            }
            if (this.currentEvent == null) {
                this.currentEvent = (MessageEvent) this.queue.poll();
            }
            if (this.currentEvent == null) {
                break;
            }
            if (this.currentEvent.getFuture().isDone()) {
                this.currentEvent = null;
            } else {
                final MessageEvent messageEvent = this.currentEvent;
                Object message = messageEvent.getMessage();
                if (message instanceof ChunkedInput) {
                    ChunkedInput chunkedInput = (ChunkedInput) message;
                    try {
                        Object objNextChunk = chunkedInput.nextChunk();
                        if (objNextChunk == null) {
                            obj = ChannelBuffers.EMPTY_BUFFER;
                            z = true;
                        } else {
                            obj = objNextChunk;
                            z = false;
                        }
                        if (chunkedInput.isEndOfInput()) {
                            this.currentEvent = null;
                            closeInput(chunkedInput);
                            channelFutureFuture = messageEvent.getFuture();
                        } else {
                            channelFutureFuture = Channels.future(channel);
                            channelFutureFuture.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.handler.stream.ChunkedWriteHandler.1
                                @Override // org.jboss.netty.channel.ChannelFutureListener
                                public void operationComplete(ChannelFuture channelFuture) {
                                    if (channelFuture.isSuccess()) {
                                        return;
                                    }
                                    messageEvent.getFuture().setFailure(channelFuture.getCause());
                                    ChunkedWriteHandler.closeInput((ChunkedInput) messageEvent.getMessage());
                                }
                            });
                        }
                        Channels.write(channelHandlerContext, channelFutureFuture, obj, messageEvent.getRemoteAddress());
                        if (z) {
                            break;
                        }
                    } catch (Throwable th) {
                        this.currentEvent = null;
                        messageEvent.getFuture().setFailure(th);
                        Channels.fireExceptionCaught(channelHandlerContext, th);
                        closeInput(chunkedInput);
                    }
                } else {
                    this.currentEvent = null;
                    channelHandlerContext.sendDownstream(messageEvent);
                }
            }
            if (!channel.isConnected()) {
                discard(channelHandlerContext);
                break;
            }
        }
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        boolean zOffer = this.queue.offer((MessageEvent) channelEvent);
        if (!$assertionsDisabled && !zOffer) {
            throw new AssertionError();
        }
        Channel channel = channelHandlerContext.getChannel();
        if (channel.isWritable()) {
            this.ctx = channelHandlerContext;
            flush(channelHandlerContext);
        } else {
            if (channel.isConnected()) {
                return;
            }
            this.ctx = channelHandlerContext;
            discard(channelHandlerContext);
        }
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            switch (channelStateEvent.getState()) {
                case INTEREST_OPS:
                    flush(channelHandlerContext);
                    break;
                case OPEN:
                    if (!Boolean.TRUE.equals(channelStateEvent.getValue())) {
                        discard(channelHandlerContext);
                        break;
                    }
                    break;
            }
        }
        channelHandlerContext.sendUpstream(channelEvent);
    }

    public void resumeTransfer() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            return;
        }
        try {
            flush(channelHandlerContext);
        } catch (Exception e) {
            logger.warn("Unexpected exception while sending chunks.", e);
        }
    }
}
