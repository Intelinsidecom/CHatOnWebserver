package org.jboss.netty.buffer;

import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface ChannelBufferFactory {
    ChannelBuffer getBuffer(int i);

    ChannelBuffer getBuffer(ByteOrder byteOrder, int i);

    ChannelBuffer getBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2);

    ChannelBuffer getBuffer(byte[] bArr, int i, int i2);

    ByteOrder getDefaultOrder();
}
