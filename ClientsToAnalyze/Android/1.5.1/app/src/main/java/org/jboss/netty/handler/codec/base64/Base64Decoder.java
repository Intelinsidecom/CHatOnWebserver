package org.jboss.netty.handler.codec.base64;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.CharsetUtil;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class Base64Decoder extends OneToOneDecoder {
    private final Base64Dialect dialect;

    public Base64Decoder() {
        this(Base64Dialect.STANDARD);
    }

    public Base64Decoder(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        this.dialect = base64Dialect;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        Object objCopiedBuffer;
        if (obj instanceof String) {
            objCopiedBuffer = ChannelBuffers.copiedBuffer((String) obj, CharsetUtil.US_ASCII);
        } else {
            if (!(obj instanceof ChannelBuffer)) {
                return obj;
            }
            objCopiedBuffer = obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) objCopiedBuffer;
        return Base64.decode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), this.dialect);
    }
}
