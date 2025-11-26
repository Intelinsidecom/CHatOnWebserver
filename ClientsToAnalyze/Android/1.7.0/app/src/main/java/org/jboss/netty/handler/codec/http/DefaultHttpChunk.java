package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

/* loaded from: classes.dex */
public class DefaultHttpChunk implements HttpChunk {
    private ChannelBuffer content;
    private boolean last;

    public DefaultHttpChunk(ChannelBuffer channelBuffer) {
        setContent(channelBuffer);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    public ChannelBuffer getContent() {
        return this.content;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    public void setContent(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("content");
        }
        this.last = !channelBuffer.readable();
        this.content = channelBuffer;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    public boolean isLast() {
        return this.last;
    }
}
