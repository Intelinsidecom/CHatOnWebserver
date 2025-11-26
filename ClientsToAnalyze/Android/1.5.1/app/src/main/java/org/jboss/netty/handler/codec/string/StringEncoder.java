package org.jboss.netty.handler.codec.string;

import java.nio.charset.Charset;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class StringEncoder extends OneToOneEncoder {
    private final Charset charset;

    public StringEncoder() {
        this(Charset.defaultCharset());
    }

    @Deprecated
    public StringEncoder(String str) {
        this(Charset.forName(str));
    }

    public StringEncoder(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.charset = charset;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        return !(obj instanceof String) ? obj : ChannelBuffers.copiedBuffer((String) obj, this.charset);
    }
}
