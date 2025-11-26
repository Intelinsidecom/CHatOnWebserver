package org.jboss.netty.channel.socket.http;

import java.net.SocketAddress;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
final class HttpTunnelingClientSocketPipelineSink extends AbstractChannelSink {
    HttpTunnelingClientSocketPipelineSink() {
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        HttpTunnelingClientSocketChannel httpTunnelingClientSocketChannel = (HttpTunnelingClientSocketChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof MessageEvent) {
                httpTunnelingClientSocketChannel.writeReal((ChannelBuffer) ((MessageEvent) channelEvent).getMessage(), future);
                return;
            }
            return;
        }
        ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
        ChannelState state = channelStateEvent.getState();
        Object value = channelStateEvent.getValue();
        switch (state) {
            case OPEN:
                if (Boolean.FALSE.equals(value)) {
                    httpTunnelingClientSocketChannel.closeReal(future);
                    break;
                }
                break;
            case BOUND:
                if (value == null) {
                    httpTunnelingClientSocketChannel.unbindReal(future);
                    break;
                } else {
                    httpTunnelingClientSocketChannel.bindReal((SocketAddress) value, future);
                    break;
                }
            case CONNECTED:
                if (value == null) {
                    httpTunnelingClientSocketChannel.closeReal(future);
                    break;
                } else {
                    httpTunnelingClientSocketChannel.connectReal((SocketAddress) value, future);
                    break;
                }
            case INTEREST_OPS:
                httpTunnelingClientSocketChannel.setInterestOpsReal(((Integer) value).intValue(), future);
                break;
        }
    }
}
