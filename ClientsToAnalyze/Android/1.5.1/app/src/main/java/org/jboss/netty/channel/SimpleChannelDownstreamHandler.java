package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class SimpleChannelDownstreamHandler implements ChannelDownstreamHandler {
    public void bindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
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

    public void setInterestOpsRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void unbindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        channelHandlerContext.sendDownstream(messageEvent);
    }
}
