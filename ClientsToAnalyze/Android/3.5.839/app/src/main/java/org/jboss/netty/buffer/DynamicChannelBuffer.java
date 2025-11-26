package org.jboss.netty.buffer;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class DynamicChannelBuffer extends AbstractChannelBuffer {
    private ChannelBuffer buffer;
    private final ByteOrder endianness;
    private final ChannelBufferFactory factory;

    public DynamicChannelBuffer(ByteOrder byteOrder, int i, ChannelBufferFactory channelBufferFactory) {
        if (i < 0) {
            throw new IllegalArgumentException("estimatedLength: " + i);
        }
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        this.factory = channelBufferFactory;
        this.endianness = byteOrder;
        this.buffer = channelBufferFactory.getBuffer(order(), i);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer
    public void ensureWritableBytes(int i) {
        int iCapacity;
        if (i > writableBytes()) {
            if (capacity() == 0) {
                iCapacity = 1;
            } else {
                iCapacity = capacity();
            }
            while (iCapacity < writerIndex() + i) {
                iCapacity <<= 1;
            }
            ChannelBuffer buffer = factory().getBuffer(order(), iCapacity);
            buffer.writeBytes(this.buffer, 0, writerIndex());
            this.buffer = buffer;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBufferFactory factory() {
        return this.factory;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteOrder order() {
        return this.endianness;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte getByte(int i) {
        return this.buffer.getByte(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getShort(int i) {
        return this.buffer.getShort(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getInt(int i) {
        return this.buffer.getInt(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getLong(int i) {
        return this.buffer.getLong(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        this.buffer.getBytes(i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        this.buffer.getBytes(i, byteBuffer);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) {
        this.buffer.getBytes(i, outputStream, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setByte(int i, int i2) {
        this.buffer.setByte(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setShort(int i, int i2) {
        this.buffer.setShort(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setInt(int i, int i2) {
        this.buffer.setInt(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setLong(int i, long j) {
        this.buffer.setLong(i, j);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        this.buffer.setBytes(i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        this.buffer.setBytes(i, channelBuffer, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ByteBuffer byteBuffer) {
        this.buffer.setBytes(i, byteBuffer);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeByte(int i) {
        ensureWritableBytes(1);
        super.writeByte(i);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeShort(int i) {
        ensureWritableBytes(2);
        super.writeShort(i);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeInt(int i) {
        ensureWritableBytes(4);
        super.writeInt(i);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeLong(long j) {
        ensureWritableBytes(8);
        super.writeLong(j);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(byte[] bArr, int i, int i2) {
        ensureWritableBytes(i2);
        super.writeBytes(bArr, i, i2);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        ensureWritableBytes(i2);
        super.writeBytes(channelBuffer, i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer duplicate() {
        return new DuplicatedChannelBuffer(this);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        return this.buffer.toByteBuffer(i, i2);
    }
}
