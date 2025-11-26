package org.jboss.netty.buffer;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface ChannelBuffer extends Comparable<ChannelBuffer> {
    byte[] array();

    int capacity();

    void discardReadBytes();

    ChannelBuffer duplicate();

    ChannelBufferFactory factory();

    byte getByte(int i);

    void getBytes(int i, OutputStream outputStream, int i2);

    void getBytes(int i, ByteBuffer byteBuffer);

    void getBytes(int i, byte[] bArr, int i2, int i3);

    int getInt(int i);

    long getLong(int i);

    short getShort(int i);

    short getUnsignedByte(int i);

    long getUnsignedInt(int i);

    boolean isDirect();

    ByteOrder order();

    byte readByte();

    ChannelBuffer readBytes(int i);

    int readInt();

    short readShort();

    boolean readable();

    int readableBytes();

    int readerIndex();

    void readerIndex(int i);

    void setByte(int i, int i2);

    void setBytes(int i, ByteBuffer byteBuffer);

    void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3);

    void setBytes(int i, byte[] bArr, int i2, int i3);

    void setIndex(int i, int i2);

    void setInt(int i, int i2);

    void setLong(int i, long j);

    void setShort(int i, int i2);

    void skipBytes(int i);

    ByteBuffer toByteBuffer();

    ByteBuffer toByteBuffer(int i, int i2);

    void writeByte(int i);

    void writeBytes(ChannelBuffer channelBuffer);

    void writeBytes(ChannelBuffer channelBuffer, int i, int i2);

    void writeBytes(byte[] bArr);

    void writeBytes(byte[] bArr, int i, int i2);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(int i);

    int writerIndex();

    void writerIndex(int i);
}
