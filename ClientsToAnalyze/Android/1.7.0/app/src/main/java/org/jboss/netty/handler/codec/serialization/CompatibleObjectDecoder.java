package org.jboss.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

@Deprecated
/* loaded from: classes.dex */
public class CompatibleObjectDecoder extends ReplayingDecoder {
    private final SwitchableInputStream bin;
    private ObjectInputStream oin;

    public CompatibleObjectDecoder() {
        super(CompatibleObjectDecoderState.READ_HEADER);
        this.bin = new SwitchableInputStream();
    }

    protected ObjectInputStream newObjectInputStream(InputStream inputStream) {
        return new ObjectInputStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, CompatibleObjectDecoderState compatibleObjectDecoderState) {
        this.bin.switchStream(new ChannelBufferInputStream(channelBuffer));
        switch (compatibleObjectDecoderState) {
            case READ_HEADER:
                this.oin = newObjectInputStream(this.bin);
                checkpoint(CompatibleObjectDecoderState.READ_OBJECT);
                break;
            case READ_OBJECT:
                break;
            default:
                throw new IllegalStateException("Unknown state: " + compatibleObjectDecoderState);
        }
        return this.oin.readObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    public Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, CompatibleObjectDecoderState compatibleObjectDecoderState) throws IOException {
        switch (channelBuffer.readableBytes()) {
            case 0:
                return null;
            case 1:
                if (channelBuffer.getByte(channelBuffer.readerIndex()) == 121) {
                    channelBuffer.skipBytes(1);
                    this.oin.close();
                    return null;
                }
                break;
        }
        Object objDecode = decode(channelHandlerContext, channel, channelBuffer, compatibleObjectDecoderState);
        this.oin.close();
        return objDecode;
    }
}
