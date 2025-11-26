package org.jboss.netty.handler.codec.http.websocket;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.util.CharsetUtil;

/* loaded from: classes.dex */
public class DefaultWebSocketFrame implements WebSocketFrame {
    private ChannelBuffer binaryData;
    private int type;

    public DefaultWebSocketFrame() {
        this(0, ChannelBuffers.EMPTY_BUFFER);
    }

    public DefaultWebSocketFrame(String str) {
        this(0, ChannelBuffers.copiedBuffer(str, CharsetUtil.UTF_8));
    }

    public DefaultWebSocketFrame(int i, ChannelBuffer channelBuffer) {
        setData(i, channelBuffer);
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public int getType() {
        return this.type;
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public boolean isText() {
        return (getType() & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 0;
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public boolean isBinary() {
        return !isText();
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public ChannelBuffer getBinaryData() {
        return this.binaryData;
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public String getTextData() {
        return getBinaryData().toString(CharsetUtil.UTF_8);
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public void setData(int i, ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("binaryData");
        }
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 0 && channelBuffer.indexOf(channelBuffer.readerIndex(), channelBuffer.writerIndex(), (byte) -1) >= 0) {
            throw new IllegalArgumentException("a text frame should not contain 0xFF.");
        }
        this.type = i & MotionEventCompat.ACTION_MASK;
        this.binaryData = channelBuffer;
    }

    @Override // org.jboss.netty.handler.codec.http.websocket.WebSocketFrame
    public String toString() {
        return getClass().getSimpleName() + "(type: " + getType() + ", data: " + getBinaryData() + ')';
    }
}
