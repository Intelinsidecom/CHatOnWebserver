package org.jboss.netty.buffer;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class DuplicatedChannelBuffer extends AbstractChannelBuffer implements WrappedChannelBuffer {
    private final ChannelBuffer buffer;

    public DuplicatedChannelBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("buffer");
        }
        this.buffer = channelBuffer;
        setIndex(channelBuffer.readerIndex(), channelBuffer.writerIndex());
    }

    private DuplicatedChannelBuffer(DuplicatedChannelBuffer duplicatedChannelBuffer) {
        this.buffer = duplicatedChannelBuffer.buffer;
        setIndex(duplicatedChannelBuffer.readerIndex(), duplicatedChannelBuffer.writerIndex());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBufferFactory factory() {
        return this.buffer.factory();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteOrder order() {
        return this.buffer.order();
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
    public ChannelBuffer duplicate() {
        return new DuplicatedChannelBuffer(this);
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) {
        this.buffer.getBytes(i, outputStream, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        return this.buffer.toByteBuffer(i, i2);
    }
}
