package org.jboss.netty.handler.codec.http.websocket;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

/* loaded from: classes.dex */
public class WebSocketFrameDecoder extends ReplayingDecoder {
    public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final int maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocketFrameDecoder() {
        this(DEFAULT_MAX_FRAME_SIZE);
    }

    public WebSocketFrameDecoder(int i) {
        this.maxFrameSize = i;
    }

    private WebSocketFrame decodeBinaryFrame(int i, ChannelBuffer channelBuffer) throws TooLongFrameException {
        byte b;
        int i2 = 0;
        long j = 0;
        do {
            b = channelBuffer.readByte();
            j = (j << 7) | (b & 127);
            if (j > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            i2++;
            if (i2 > 8) {
                throw new TooLongFrameException();
            }
        } while ((b & 128) == 128);
        if (i == 255 && j == 0) {
            this.receivedClosingHandshake = true;
        }
        return new DefaultWebSocketFrame(i, channelBuffer.readBytes((int) j));
    }

    private WebSocketFrame decodeTextFrame(int i, ChannelBuffer channelBuffer) throws TooLongFrameException {
        int i2 = channelBuffer.readerIndex();
        int iActualReadableBytes = actualReadableBytes();
        int iIndexOf = channelBuffer.indexOf(i2, i2 + iActualReadableBytes, (byte) -1);
        if (iIndexOf == -1) {
            if (iActualReadableBytes > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            return null;
        }
        int i3 = iIndexOf - i2;
        if (i3 > this.maxFrameSize) {
            throw new TooLongFrameException();
        }
        ChannelBuffer bytes = channelBuffer.readBytes(i3);
        channelBuffer.skipBytes(1);
        return new DefaultWebSocketFrame(i, bytes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, VoidEnum voidEnum) {
        if (this.receivedClosingHandshake) {
            channelBuffer.skipBytes(actualReadableBytes());
            return null;
        }
        byte b = channelBuffer.readByte();
        return (b & 128) == 128 ? decodeBinaryFrame(b, channelBuffer) : decodeTextFrame(b, channelBuffer);
    }
}
