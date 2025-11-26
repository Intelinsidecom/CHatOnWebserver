package org.jboss.netty.channel;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class SimpleChannelHandler implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SimpleChannelHandler.class.getName());

    public void bindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void channelBound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelInterestChanged(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelUnbound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void childChannelClosed(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }

    public void childChannelOpen(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }

    public void closeRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void connectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void disconnectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (this == channelHandlerContext.getPipeline().getLast()) {
            logger.warn("EXCEPTION, please implement " + getClass().getName() + ".exceptionCaught() for proper handling.", exceptionEvent.getCause());
        }
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof MessageEvent) {
            writeRequested(channelHandlerContext, (MessageEvent) channelEvent);
        }
        if (!(channelEvent instanceof ChannelStateEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
        switch (channelStateEvent.getState()) {
            case OPEN:
                if (!Boolean.TRUE.equals(channelStateEvent.getValue())) {
                    closeRequested(channelHandlerContext, channelStateEvent);
                    break;
                }
                break;
            case BOUND:
                if (channelStateEvent.getValue() == null) {
                    unbindRequested(channelHandlerContext, channelStateEvent);
                    break;
                } else {
                    bindRequested(channelHandlerContext, channelStateEvent);
                    break;
                }
            case CONNECTED:
                if (channelStateEvent.getValue() == null) {
                    disconnectRequested(channelHandlerContext, channelStateEvent);
                    break;
                } else {
                    connectRequested(channelHandlerContext, channelStateEvent);
                    break;
                }
            case INTEREST_OPS:
                setInterestOpsRequested(channelHandlerContext, channelStateEvent);
                break;
            default:
                channelHandlerContext.sendDownstream(channelEvent);
                break;
        }
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof MessageEvent) {
            messageReceived(channelHandlerContext, (MessageEvent) channelEvent);
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
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof ExceptionEvent) {
                exceptionCaught(channelHandlerContext, (ExceptionEvent) channelEvent);
                return;
            } else {
                channelHandlerContext.sendUpstream(channelEvent);
                return;
            }
        }
        ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
        switch (channelStateEvent.getState()) {
            case OPEN:
                if (!Boolean.TRUE.equals(channelStateEvent.getValue())) {
                    channelClosed(channelHandlerContext, channelStateEvent);
                    break;
                } else {
                    channelOpen(channelHandlerContext, channelStateEvent);
                    break;
                }
            case BOUND:
                if (channelStateEvent.getValue() == null) {
                    channelUnbound(channelHandlerContext, channelStateEvent);
                    break;
                } else {
                    channelBound(channelHandlerContext, channelStateEvent);
                    break;
                }
            case CONNECTED:
                if (channelStateEvent.getValue() == null) {
                    channelDisconnected(channelHandlerContext, channelStateEvent);
                    break;
                } else {
                    channelConnected(channelHandlerContext, channelStateEvent);
                    break;
                }
            case INTEREST_OPS:
                channelInterestChanged(channelHandlerContext, channelStateEvent);
                break;
            default:
                channelHandlerContext.sendUpstream(channelEvent);
                break;
        }
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public void setInterestOpsRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void unbindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) {
        channelHandlerContext.sendUpstream(writeCompletionEvent);
    }

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        channelHandlerContext.sendDownstream(messageEvent);
    }
}
