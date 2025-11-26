package org.jboss.netty.handler.codec.http.websocket;

import android.support.v4.view.MotionEventCompat;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public interface WebSocketFrame {
    public static final WebSocketFrame CLOSING_HANDSHAKE = new DefaultWebSocketFrame(MotionEventCompat.ACTION_MASK, ChannelBuffers.EMPTY_BUFFER);

    ChannelBuffer getBinaryData();

    String getTextData();

    int getType();

    boolean isBinary();

    boolean isText();

    void setData(int i, ChannelBuffer channelBuffer);

    String toString();
}
