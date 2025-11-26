package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.embedder.DecoderEmbedder;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpMessageDecoder;

/* loaded from: classes.dex */
public abstract class RtspMessageDecoder extends HttpMessageDecoder {
    private final DecoderEmbedder<HttpMessage> aggregator;

    protected RtspMessageDecoder() {
        this(4096, 8192, 8192);
    }

    protected RtspMessageDecoder(int i, int i2, int i3) {
        super(i, i2, i3 * 2);
        this.aggregator = new DecoderEmbedder<>(new HttpChunkAggregator(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.http.HttpMessageDecoder, org.jboss.netty.handler.codec.replay.ReplayingDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, HttpMessageDecoder.State state) throws TooLongFrameException {
        Object objDecode = super.decode(channelHandlerContext, channel, channelBuffer, state);
        if (objDecode == null || !this.aggregator.offer(objDecode)) {
            return null;
        }
        return this.aggregator.poll();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessageDecoder
    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean zIsContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (!zIsContentAlwaysEmpty && httpMessage.containsHeader("Content-Length")) {
            return zIsContentAlwaysEmpty;
        }
        return true;
    }
}
