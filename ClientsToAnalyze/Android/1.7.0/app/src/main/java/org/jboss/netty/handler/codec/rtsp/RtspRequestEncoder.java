package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpRequest;

/* loaded from: classes.dex */
public class RtspRequestEncoder extends RtspMessageEncoder {
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
