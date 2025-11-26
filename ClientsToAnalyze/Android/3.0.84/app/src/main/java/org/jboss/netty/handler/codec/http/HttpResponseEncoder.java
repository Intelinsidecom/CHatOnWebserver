package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

/* loaded from: classes.dex */
public class HttpResponseEncoder extends HttpMessageEncoder {
    @Override // org.jboss.netty.handler.codec.http.HttpMessageEncoder
    protected void encodeInitialLine(ChannelBuffer channelBuffer, HttpMessage httpMessage) {
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        channelBuffer.writeBytes(httpResponse.getProtocolVersion().toString().getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(String.valueOf(httpResponse.getStatus().getCode()).getBytes("ASCII"));
        channelBuffer.writeByte(32);
        channelBuffer.writeBytes(String.valueOf(httpResponse.getStatus().getReasonPhrase()).getBytes("ASCII"));
        channelBuffer.writeByte(13);
        channelBuffer.writeByte(10);
    }
}
