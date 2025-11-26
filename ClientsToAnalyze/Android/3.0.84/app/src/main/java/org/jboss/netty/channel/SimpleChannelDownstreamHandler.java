package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class SimpleChannelDownstreamHandler implements ChannelDownstreamHandler {
    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof MessageEvent) {
            writeRequested(channelHandlerContext, (MessageEvent) channelEvent);
            return;
        }
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            switch (channelStateEvent.getState()) {
                case OPEN:
                    if (!Boolean.TRUE.equals(channelStateEvent.getValue())) {
                        closeRequested(channelHandlerContext, channelStateEvent);
                        break;
                    }
                    break;
                case BOUND:
                    if (channelStateEvent.getValue() != null) {
                        bindRequested(channelHandlerContext, channelStateEvent);
                        break;
                    } else {
                        unbindRequested(channelHandlerContext, channelStateEvent);
                        break;
                    }
                case CONNECTED:
                    if (channelStateEvent.getValue() != null) {
                        connectRequested(channelHandlerContext, channelStateEvent);
                        break;
                    } else {
                        disconnectRequested(channelHandlerContext, channelStateEvent);
                        break;
                    }
                case INTEREST_OPS:
                    setInterestOpsRequested(channelHandlerContext, channelStateEvent);
                    break;
                default:
                    channelHandlerContext.sendDownstream(channelEvent);
                    break;
            }
            return;
        }
        channelHandlerContext.sendDownstream(channelEvent);
    }

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        channelHandlerContext.sendDownstream(messageEvent);
    }

    public void bindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void connectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void setInterestOpsRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void disconnectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void unbindRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }

    public void closeRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        channelHandlerContext.sendDownstream(channelStateEvent);
    }
}
