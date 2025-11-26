package org.jboss.netty.handler.codec.replay;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.DynamicChannelBuffer;

/* loaded from: classes.dex */
class UnsafeDynamicChannelBuffer extends DynamicChannelBuffer {
    UnsafeDynamicChannelBuffer(ChannelBufferFactory channelBufferFactory) {
        super(channelBufferFactory.getDefaultOrder(), AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT, channelBufferFactory);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer
    protected void checkReadableBytes(int i) {
    }
}
