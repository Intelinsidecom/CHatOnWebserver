package org.jboss.netty.buffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class AbstractChannelBuffer implements ChannelBuffer {
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int readerIndex;
    private int writerIndex;

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readerIndex(int i) {
        if (i < 0 || i > this.writerIndex) {
            throw new IndexOutOfBoundsException();
        }
        this.readerIndex = i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writerIndex(int i) {
        if (i < this.readerIndex || i > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.writerIndex = i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setIndex(int i, int i2) {
        if (i < 0 || i > i2 || i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.readerIndex = i;
        this.writerIndex = i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean readable() {
        return readableBytes() > 0;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void discardReadBytes() {
        if (this.readerIndex != 0) {
            setBytes(0, this, this.readerIndex, this.writerIndex - this.readerIndex);
            this.writerIndex -= this.readerIndex;
            this.markedReaderIndex = Math.max(this.markedReaderIndex - this.readerIndex, 0);
            this.markedWriterIndex = Math.max(this.markedWriterIndex - this.readerIndex, 0);
            this.readerIndex = 0;
        }
    }

    public void ensureWritableBytes(int i) {
        if (i > writableBytes()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getUnsignedByte(int i) {
        return (short) (getByte(i) & 255);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getUnsignedInt(int i) {
        return getInt(i) & 4294967295L;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte readByte() {
        if (this.readerIndex == this.writerIndex) {
            throw new IndexOutOfBoundsException();
        }
        int i = this.readerIndex;
        this.readerIndex = i + 1;
        return getByte(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short readShort() {
        checkReadableBytes(2);
        short s = getShort(this.readerIndex);
        this.readerIndex += 2;
        return s;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readInt() {
        checkReadableBytes(4);
        int i = getInt(this.readerIndex);
        this.readerIndex += 4;
        return i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer readBytes(int i) {
        checkReadableBytes(i);
        if (i == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        ChannelBuffer buffer = factory().getBuffer(order(), i);
        buffer.writeBytes(this, this.readerIndex, i);
        this.readerIndex += i;
        return buffer;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void skipBytes(int i) {
        int i2 = this.readerIndex + i;
        if (i2 > this.writerIndex) {
            throw new IndexOutOfBoundsException();
        }
        this.readerIndex = i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeByte(int i) {
        int i2 = this.writerIndex;
        this.writerIndex = i2 + 1;
        setByte(i2, i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeShort(int i) {
        setShort(this.writerIndex, i);
        this.writerIndex += 2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeInt(int i) {
        setInt(this.writerIndex, i);
        this.writerIndex += 4;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeLong(long j) {
        setLong(this.writerIndex, j);
        this.writerIndex += 8;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(byte[] bArr, int i, int i2) {
        setBytes(this.writerIndex, bArr, i, i2);
        this.writerIndex += i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer) {
        writeBytes(channelBuffer, channelBuffer.readableBytes());
    }

    public void writeBytes(ChannelBuffer channelBuffer, int i) {
        if (i > channelBuffer.readableBytes()) {
            throw new IndexOutOfBoundsException();
        }
        writeBytes(channelBuffer, channelBuffer.readerIndex(), i);
        channelBuffer.readerIndex(channelBuffer.readerIndex() + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        setBytes(this.writerIndex, channelBuffer, i, i2);
        this.writerIndex += i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer() {
        return toByteBuffer(this.readerIndex, readableBytes());
    }

    public int hashCode() {
        return ChannelBuffers.hashCode(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChannelBuffer) {
            return ChannelBuffers.equals(this, (ChannelBuffer) obj);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelBuffer channelBuffer) {
        return ChannelBuffers.compare(this, channelBuffer);
    }

    public String toString() {
        return getClass().getSimpleName() + "(ridx=" + this.readerIndex + ", widx=" + this.writerIndex + ", cap=" + capacity() + ')';
    }

    protected void checkReadableBytes(int i) {
        if (readableBytes() < i) {
            throw new IndexOutOfBoundsException();
        }
    }
}
