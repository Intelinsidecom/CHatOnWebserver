package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpResponse;

/* loaded from: classes.dex */
public class RtspResponseEncoder extends RtspMessageEncoder {
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
