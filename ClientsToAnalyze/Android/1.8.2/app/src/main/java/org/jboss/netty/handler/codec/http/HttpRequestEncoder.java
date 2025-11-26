package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

/* loaded from: classes.dex */
public class HttpRequestEncoder extends HttpMessageEncoder {
    @Override // org.jboss.netty.handler.codec.http.HttpMessageEncoder
    protected void encodeInitialLine(ChannelBuffer channelBuffer, HttpMessage httpMessage) {
        HttpRequest httpRequest = (HttpRequest) httpMessage;
        channelBuffer.writeBytes(httpRequest.getMethod().toString().getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(httpRequest.getUri().getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(httpRequest.getProtocolVersion().toString().getBytes("ASCII"));
        channelBuffer.writeByte(13);
        channelBuffer.writeByte(10);
    }
}
