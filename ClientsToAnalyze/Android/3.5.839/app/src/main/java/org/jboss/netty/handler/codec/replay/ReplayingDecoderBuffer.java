package org.jboss.netty.handler.codec.replay;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;

/* loaded from: classes.dex */
class ReplayingDecoderBuffer implements ChannelBuffer {
    private static final Error REPLAY = new ReplayError();
    private final ChannelBuffer buffer;
    private boolean terminated;

    ReplayingDecoderBuffer(ChannelBuffer channelBuffer) {
        this.buffer = channelBuffer;
    }

    void terminate() {
        this.terminated = true;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int capacity() {
        if (this.terminated) {
            return this.buffer.capacity();
        }
        return Integer.MAX_VALUE;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void discardReadBytes() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer duplicate() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte getByte(int i) {
        checkIndex(i);
        return this.buffer.getByte(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getUnsignedByte(int i) {
        checkIndex(i);
        return this.buffer.getUnsignedByte(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getInt(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getUnsignedInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getUnsignedInt(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getLong(int i) {
        checkIndex(i, 8);
        return this.buffer.getLong(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(i);
    }

    public int hashCode() {
        throw new UnreplayableOperationException();
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
    public boolean readable() {
        if (this.terminated) {
            return this.buffer.readable();
        }
        return true;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readableBytes() {
        return this.terminated ? this.buffer.readableBytes() : Integer.MAX_VALUE - this.buffer.readerIndex();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer readBytes(int i) {
        checkReadableBytes(i);
        return this.buffer.readBytes(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readerIndex() {
        return this.buffer.readerIndex();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readerIndex(int i) {
        this.buffer.readerIndex(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setByte(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setIndex(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setInt(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setLong(int i, long j) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setShort(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void skipBytes(int i) {
        checkReadableBytes(i);
        this.buffer.skipBytes(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffer(i, i2);
    }

    public String toString() {
        return getClass().getSimpleName() + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeByte(int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(byte[] bArr, int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(byte[] bArr) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeInt(int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeLong(long j) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writerIndex() {
        return this.buffer.writerIndex();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writerIndex(int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeShort(int i) {
        throw new UnreplayableOperationException();
    }

    private void checkIndex(int i) {
        if (i > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    private void checkIndex(int i, int i2) {
        if (i + i2 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    private void checkReadableBytes(int i) {
        if (this.buffer.readableBytes() < i) {
            throw REPLAY;
        }
    }
}
