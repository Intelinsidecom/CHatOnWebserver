package org.jboss.netty.handler.codec.replay;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.ChannelBufferIndexFinder;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
class ReplayingDecoderBuffer implements ChannelBuffer {
    private final ChannelBuffer buffer;
    private boolean terminated;
    private static final Error REPLAY = new ReplayError();
    public static ReplayingDecoderBuffer EMPTY_BUFFER = new ReplayingDecoderBuffer(ChannelBuffers.EMPTY_BUFFER);

    static {
        EMPTY_BUFFER.terminate();
    }

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
    public boolean hasArray() {
        return false;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void clear() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer copy() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer copy(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.copy(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void discardReadBytes() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void ensureWritableBytes(int i) {
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
    public void getBytes(int i, byte[] bArr) {
        checkIndex(i, bArr.length);
        this.buffer.getBytes(i, bArr);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, channelBuffer, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
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
    public int getMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getMedium(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMedium(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getUnsignedShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getUnsignedShort(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public char getChar(int i) {
        checkIndex(i, 2);
        return this.buffer.getChar(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public float getFloat(int i) {
        checkIndex(i, 4);
        return this.buffer.getFloat(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public double getDouble(int i) {
        checkIndex(i, 8);
        return this.buffer.getDouble(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int hashCode() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int indexOf(int i, int i2, byte b) {
        int iIndexOf = this.buffer.indexOf(i, i2, b);
        if (iIndexOf < 0) {
            throw REPLAY;
        }
        return iIndexOf;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int indexOf(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = this.buffer.indexOf(i, i2, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw REPLAY;
        }
        return iIndexOf;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(byte b) {
        int iBytesBefore = this.buffer.bytesBefore(b);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iBytesBefore = this.buffer.bytesBefore(channelBufferIndexFinder);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, byte b) {
        checkReadableBytes(i);
        int iBytesBefore = this.buffer.bytesBefore(i, b);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkReadableBytes(i);
        int iBytesBefore = this.buffer.bytesBefore(i, channelBufferIndexFinder);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, int i2, byte b) {
        int iBytesBefore = this.buffer.bytesBefore(i, i2, b);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iBytesBefore = this.buffer.bytesBefore(i, i2, channelBufferIndexFinder);
        if (iBytesBefore < 0) {
            throw REPLAY;
        }
        return iBytesBefore;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void markReaderIndex() {
        this.buffer.markReaderIndex();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void markWriterIndex() {
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
    public short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(channelBuffer, i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer, int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public ChannelBuffer readBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = this.buffer.indexOf(this.buffer.readerIndex(), this.buffer.writerIndex(), channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw REPLAY;
        }
        return this.buffer.readBytes(iIndexOf - this.buffer.readerIndex());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer readBytes(int i) {
        checkReadableBytes(i);
        return this.buffer.readBytes(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public ChannelBuffer readSlice(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = this.buffer.indexOf(this.buffer.readerIndex(), this.buffer.writerIndex(), channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw REPLAY;
        }
        return this.buffer.readSlice(iIndexOf - this.buffer.readerIndex());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer readSlice(int i) {
        checkReadableBytes(i);
        return this.buffer.readSlice(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(OutputStream outputStream, int i) {
        throw new UnreplayableOperationException();
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
    public long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readMedium() {
        checkReadableBytes(3);
        return this.buffer.readMedium();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readUnsignedMedium() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMedium();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public char readChar() {
        checkReadableBytes(2);
        return this.buffer.readChar();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public float readFloat() {
        checkReadableBytes(4);
        return this.buffer.readFloat();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public double readDouble() {
        checkReadableBytes(8);
        return this.buffer.readDouble();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void resetReaderIndex() {
        this.buffer.resetReaderIndex();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void resetWriterIndex() {
        throw new UnreplayableOperationException();
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
    public void setBytes(int i, byte[] bArr) {
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
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, InputStream inputStream, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setZero(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
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
    public void setMedium(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setShort(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setChar(int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setFloat(int i, float f) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setDouble(int i, double d) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public int skipBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int i = this.buffer.readerIndex();
        int iIndexOf = this.buffer.indexOf(i, this.buffer.writerIndex(), channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw REPLAY;
        }
        this.buffer.readerIndex(iIndexOf);
        return iIndexOf - i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void skipBytes(int i) {
        checkReadableBytes(i);
        this.buffer.skipBytes(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer slice() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer slice(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.slice(i, i2);
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer[] toByteBuffers() {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer[] toByteBuffers(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.toByteBuffers(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, charset);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString(Charset charset) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(int i, int i2, String str) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, str);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(int i, int i2, String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, str, channelBufferIndexFinder);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(String str) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString() {
        return getClass().getSimpleName() + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean writable() {
        return false;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writableBytes() {
        return 0;
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
    public void writeBytes(ByteBuffer byteBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer, int i, int i2) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer, int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeBytes(ChannelBuffer channelBuffer) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writeBytes(InputStream inputStream, int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) {
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
    public void writeMedium(int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeZero(int i) {
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeChar(int i) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeFloat(float f) {
        throw new UnreplayableOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeDouble(double d) {
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
