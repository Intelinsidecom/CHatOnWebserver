package org.jboss.netty.handler.codec.replay;

import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.DynamicChannelBuffer;

/* loaded from: classes.dex */
class UnsafeDynamicChannelBuffer extends DynamicChannelBuffer {
    UnsafeDynamicChannelBuffer(ChannelBufferFactory channelBufferFactory) {
        super(channelBufferFactory.getDefaultOrder(), 256, channelBufferFactory);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer
    protected void checkReadableBytes(int i) {
    }
}
