package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import java.io.InputStream;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class ProtobufDecoder extends OneToOneDecoder {
    private final ExtensionRegistry extensionRegistry;
    private final MessageLite prototype;

    public ProtobufDecoder(MessageLite messageLite) {
        this(messageLite, null);
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistry extensionRegistry) {
        if (messageLite == null) {
            throw new NullPointerException("prototype");
        }
        this.prototype = messageLite.getDefaultInstanceForType();
        this.extensionRegistry = extensionRegistry;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        if (!channelBuffer.hasArray()) {
            return this.extensionRegistry == null ? this.prototype.newBuilderForType().mergeFrom(new ChannelBufferInputStream((ChannelBuffer) obj)).build() : this.prototype.newBuilderForType().mergeFrom((InputStream) new ChannelBufferInputStream((ChannelBuffer) obj), (ExtensionRegistryLite) this.extensionRegistry).build();
        }
        int i = channelBuffer.readerIndex();
        return this.extensionRegistry == null ? this.prototype.newBuilderForType().mergeFrom(channelBuffer.array(), i + channelBuffer.arrayOffset(), channelBuffer.readableBytes()).build() : this.prototype.newBuilderForType().mergeFrom(channelBuffer.array(), i + channelBuffer.arrayOffset(), channelBuffer.readableBytes(), this.extensionRegistry).build();
    }
}
