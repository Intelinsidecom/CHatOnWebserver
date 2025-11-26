package org.jboss.netty.buffer;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: classes.dex */
public class SlicedChannelBuffer extends AbstractChannelBuffer implements WrappedChannelBuffer {
    private final int adjustment;
    private final ChannelBuffer buffer;
    private final int length;

    public SlicedChannelBuffer(ChannelBuffer channelBuffer, int i, int i2) {
        if (i < 0 || i > channelBuffer.capacity()) {
            throw new IndexOutOfBoundsException();
        }
        if (i + i2 > channelBuffer.capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.buffer = channelBuffer;
        this.adjustment = i;
        this.length = i2;
        writerIndex(i2);
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= capacity()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndex(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("length is negative: " + i2);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i + i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int arrayOffset() {
        return this.buffer.arrayOffset() + this.adjustment;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int capacity() {
        return this.length;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer copy(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.copy(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer duplicate() {
        SlicedChannelBuffer slicedChannelBuffer = new SlicedChannelBuffer(this.buffer, this.adjustment, this.length);
        slicedChannelBuffer.setIndex(readerIndex(), writerIndex());
        return slicedChannelBuffer;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBufferFactory factory() {
        return this.buffer.factory();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte getByte(int i) {
        checkIndex(i);
        return this.buffer.getByte(this.adjustment + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        checkIndex(i, i2);
        return this.buffer.getBytes(this.adjustment + i, gatheringByteChannel, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) {
        checkIndex(i, i2);
        this.buffer.getBytes(this.adjustment + i, outputStream, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        this.buffer.getBytes(this.adjustment + i, byteBuffer);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(this.adjustment + i, channelBuffer, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(this.adjustment + i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getInt(this.adjustment + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getLong(int i) {
        checkIndex(i, 8);
        return this.buffer.getLong(this.adjustment + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(this.adjustment + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMedium(this.adjustment + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteOrder order() {
        return this.buffer.order();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setByte(int i, int i2) {
        checkIndex(i);
        this.buffer.setByte(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, InputStream inputStream, int i2) {
        checkIndex(i, i2);
        return this.buffer.setBytes(this.adjustment + i, inputStream, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex(i, i2);
        return this.buffer.setBytes(this.adjustment + i, scatteringByteChannel, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        this.buffer.setBytes(this.adjustment + i, byteBuffer);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.setBytes(this.adjustment + i, channelBuffer, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.setBytes(this.adjustment + i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setInt(int i, int i2) {
        checkIndex(i, 4);
        this.buffer.setInt(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setLong(int i, long j) {
        checkIndex(i, 8);
        this.buffer.setLong(this.adjustment + i, j);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setMedium(int i, int i2) {
        checkIndex(i, 3);
        this.buffer.setMedium(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setShort(int i, int i2) {
        checkIndex(i, 2);
        this.buffer.setShort(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer slice(int i, int i2) {
        checkIndex(i, i2);
        return i2 == 0 ? ChannelBuffers.EMPTY_BUFFER : new SlicedChannelBuffer(this.buffer, this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffer(this.adjustment + i, i2);
    }

    @Override // org.jboss.netty.buffer.WrappedChannelBuffer
    public ChannelBuffer unwrap() {
        return this.buffer;
    }
}
