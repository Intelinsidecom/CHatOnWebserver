package org.jboss.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.CharsetUtil;

/* loaded from: classes.dex */
public abstract class HttpMessageEncoder extends OneToOneEncoder {
    private static final ChannelBuffer LAST_CHUNK = ChannelBuffers.copiedBuffer("0\r\n\r\n", CharsetUtil.US_ASCII);
    private volatile boolean chunked;

    protected HttpMessageEncoder() {
    }

    private void encodeHeader(ChannelBuffer channelBuffer, String str, String str2) {
        channelBuffer.writeBytes(str.getBytes("ASCII"));
        channelBuffer.writeByte(58);
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(str2.getBytes("ASCII"));
        channelBuffer.writeByte(13);
        channelBuffer.writeByte(10);
    }

    private void encodeHeaders(ChannelBuffer channelBuffer, HttpMessage httpMessage) {
        try {
            for (Map.Entry entry : httpMessage.getHeaders()) {
                encodeHeader(channelBuffer, (String) entry.getKey(), (String) entry.getValue());
            }
        } catch (UnsupportedEncodingException e) {
            throw ((Error) new Error().initCause(e));
        }
    }

    private void encodeTrailingHeaders(ChannelBuffer channelBuffer, HttpChunkTrailer httpChunkTrailer) {
        try {
            for (Map.Entry entry : httpChunkTrailer.getHeaders()) {
                encodeHeader(channelBuffer, (String) entry.getKey(), (String) entry.getValue());
            }
        } catch (UnsupportedEncodingException e) {
            throw ((Error) new Error().initCause(e));
        }
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (obj instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) obj;
            boolean zIsTransferEncodingChunked = HttpCodecUtil.isTransferEncodingChunked(httpMessage);
            this.chunked = zIsTransferEncodingChunked;
            ChannelBuffer channelBufferDynamicBuffer = ChannelBuffers.dynamicBuffer(channel.getConfig().getBufferFactory());
            encodeInitialLine(channelBufferDynamicBuffer, httpMessage);
            encodeHeaders(channelBufferDynamicBuffer, httpMessage);
            channelBufferDynamicBuffer.writeByte(13);
            channelBufferDynamicBuffer.writeByte(10);
            ChannelBuffer content = httpMessage.getContent();
            if (!content.readable()) {
                return channelBufferDynamicBuffer;
            }
            if (zIsTransferEncodingChunked) {
                throw new IllegalArgumentException("HttpMessage.content must be empty if Transfer-Encoding is chunked.");
            }
            return ChannelBuffers.wrappedBuffer(channelBufferDynamicBuffer, content);
        }
        if (!(obj instanceof HttpChunk)) {
            return obj;
        }
        HttpChunk httpChunk = (HttpChunk) obj;
        if (!this.chunked) {
            if (httpChunk.isLast()) {
                return null;
            }
            return httpChunk.getContent();
        }
        if (!httpChunk.isLast()) {
            ChannelBuffer content2 = httpChunk.getContent();
            int i = content2.readableBytes();
            return ChannelBuffers.wrappedBuffer(ChannelBuffers.copiedBuffer(Integer.toHexString(i), CharsetUtil.US_ASCII), ChannelBuffers.wrappedBuffer(HttpCodecUtil.CRLF), content2.slice(content2.readerIndex(), i), ChannelBuffers.wrappedBuffer(HttpCodecUtil.CRLF));
        }
        this.chunked = false;
        if (!(httpChunk instanceof HttpChunkTrailer)) {
            return LAST_CHUNK.duplicate();
        }
        ChannelBuffer channelBufferDynamicBuffer2 = ChannelBuffers.dynamicBuffer(channel.getConfig().getBufferFactory());
        channelBufferDynamicBuffer2.writeByte(48);
        channelBufferDynamicBuffer2.writeByte(13);
        channelBufferDynamicBuffer2.writeByte(10);
        encodeTrailingHeaders(channelBufferDynamicBuffer2, (HttpChunkTrailer) httpChunk);
        channelBufferDynamicBuffer2.writeByte(13);
        channelBufferDynamicBuffer2.writeByte(10);
        return channelBufferDynamicBuffer2;
    }

    protected abstract void encodeInitialLine(ChannelBuffer channelBuffer, HttpMessage httpMessage);
}
