package org.jboss.netty.channel;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class SimpleChannelUpstreamHandler implements ChannelUpstreamHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SimpleChannelUpstreamHandler.class.getName());

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof MessageEvent) {
            messageReceived(channelHandlerContext, (MessageEvent) channelEvent);
            return;
        }
        if (channelEvent instanceof WriteCompletionEvent) {
            writeComplete(channelHandlerContext, (WriteCompletionEvent) channelEvent);
            return;
        }
        if (channelEvent instanceof ChildChannelStateEvent) {
            ChildChannelStateEvent childChannelStateEvent = (ChildChannelStateEvent) channelEvent;
            if (childChannelStateEvent.getChildChannel().isOpen()) {
                childChannelOpen(channelHandlerContext, childChannelStateEvent);
                return;
            } else {
                childChannelClosed(channelHandlerContext, childChannelStateEvent);
                return;
            }
        }
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            switch (channelStateEvent.getState()) {
                case OPEN:
                    if (Boolean.TRUE.equals(channelStateEvent.getValue())) {
                        channelOpen(channelHandlerContext, channelStateEvent);
                        break;
                    } else {
                        channelClosed(channelHandlerContext, channelStateEvent);
                        break;
                    }
                case BOUND:
                    if (channelStateEvent.getValue() != null) {
                        channelBound(channelHandlerContext, channelStateEvent);
                        break;
                    } else {
                        channelUnbound(channelHandlerContext, channelStateEvent);
                        break;
                    }
                case CONNECTED:
                    if (channelStateEvent.getValue() != null) {
                        channelConnected(channelHandlerContext, channelStateEvent);
                        break;
                    } else {
                        channelDisconnected(channelHandlerContext, channelStateEvent);
                        break;
                    }
                case INTEREST_OPS:
                    channelInterestChanged(channelHandlerContext, channelStateEvent);
                    break;
                default:
                    channelHandlerContext.sendUpstream(channelEvent);
                    break;
            }
            return;
        }
        if (channelEvent instanceof ExceptionEvent) {
            exceptionCaught(channelHandlerContext, (ExceptionEvent) channelEvent);
        } else {
            channelHandlerContext.sendUpstream(channelEvent);
        }
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (this == channelHandlerContext.getPipeline().getLast()) {
            logger.warn("EXCEPTION, please implement " + getClass().getName() + ".exceptionCaught() for proper handling.", exceptionEvent.getCause());
        }
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelBound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelInterestChanged(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelUnbound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) {
        channelHandlerContext.sendUpstream(writeCompletionEvent);
    }

    public void childChannelOpen(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }

    public void childChannelClosed(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }
}
