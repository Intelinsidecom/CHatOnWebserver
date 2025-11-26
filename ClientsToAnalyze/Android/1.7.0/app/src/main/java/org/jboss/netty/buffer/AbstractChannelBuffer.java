package org.jboss.netty.buffer;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

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
    public void clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean readable() {
        return readableBytes() > 0;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean writable() {
        return writableBytes() > 0;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void resetWriterIndex() {
        this.writerIndex = this.markedWriterIndex;
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
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
    public int getUnsignedShort(int i) {
        return getShort(i) & 65535;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getMedium(int i) {
        int unsignedMedium = getUnsignedMedium(i);
        if ((8388608 & unsignedMedium) != 0) {
            return unsignedMedium | (-16777216);
        }
        return unsignedMedium;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getUnsignedInt(int i) {
        return getInt(i) & 4294967295L;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public char getChar(int i) {
        return (char) getShort(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr) {
        getBytes(i, bArr, 0, bArr.length);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer) {
        getBytes(i, channelBuffer, channelBuffer.writableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer, int i2) {
        if (i2 > channelBuffer.writableBytes()) {
            throw new IndexOutOfBoundsException();
        }
        getBytes(i, channelBuffer, channelBuffer.writerIndex(), i2);
        channelBuffer.writerIndex(channelBuffer.writerIndex() + i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setChar(int i, int i2) {
        setShort(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setFloat(int i, float f) {
        setInt(i, Float.floatToRawIntBits(f));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setDouble(int i, double d) {
        setLong(i, Double.doubleToRawLongBits(d));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr) {
        setBytes(i, bArr, 0, bArr.length);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer) {
        setBytes(i, channelBuffer, channelBuffer.readableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2) {
        if (i2 > channelBuffer.readableBytes()) {
            throw new IndexOutOfBoundsException();
        }
        setBytes(i, channelBuffer, channelBuffer.readerIndex(), i2);
        channelBuffer.readerIndex(channelBuffer.readerIndex() + i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setZero(int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException("length must be 0 or greater than 0.");
            }
            int i3 = i2 & 7;
            int i4 = i2 >>> 3;
            int i5 = i;
            while (i4 > 0) {
                setLong(i5, 0L);
                i4--;
                i5 += 8;
            }
            if (i3 == 4) {
                setInt(i5, 0);
                return;
            }
            if (i3 < 4) {
                while (i3 > 0) {
                    setByte(i5, 0);
                    i5++;
                    i3--;
                }
                return;
            }
            setInt(i5, 0);
            int i6 = i5 + 4;
            for (int i7 = i3 - 4; i7 > 0; i7--) {
                setByte(i6, 0);
                i6++;
            }
        }
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
    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short readShort() {
        checkReadableBytes(2);
        short s = getShort(this.readerIndex);
        this.readerIndex += 2;
        return s;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readMedium() {
        int unsignedMedium = readUnsignedMedium();
        if ((8388608 & unsignedMedium) != 0) {
            return unsignedMedium | (-16777216);
        }
        return unsignedMedium;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readUnsignedMedium() {
        checkReadableBytes(3);
        int unsignedMedium = getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return unsignedMedium;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readInt() {
        checkReadableBytes(4);
        int i = getInt(this.readerIndex);
        this.readerIndex += 4;
        return i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long readUnsignedInt() {
        return readInt() & 4294967295L;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long readLong() {
        checkReadableBytes(8);
        long j = getLong(this.readerIndex);
        this.readerIndex += 8;
        return j;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public char readChar() {
        return (char) readShort();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
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
    @Deprecated
    public ChannelBuffer readBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = indexOf(this.readerIndex, this.writerIndex, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw new NoSuchElementException();
        }
        return readBytes(iIndexOf - this.readerIndex);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer readSlice(int i) {
        ChannelBuffer channelBufferSlice = slice(this.readerIndex, i);
        this.readerIndex += i;
        return channelBufferSlice;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public ChannelBuffer readSlice(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = indexOf(this.readerIndex, this.writerIndex, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw new NoSuchElementException();
        }
        return readSlice(iIndexOf - this.readerIndex);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2);
        this.readerIndex += i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer) {
        readBytes(channelBuffer, channelBuffer.writableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer, int i) {
        if (i > channelBuffer.writableBytes()) {
            throw new IndexOutOfBoundsException();
        }
        readBytes(channelBuffer, channelBuffer.writerIndex(), i);
        channelBuffer.writerIndex(channelBuffer.writerIndex() + i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ChannelBuffer channelBuffer, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, channelBuffer, i, i2);
        this.readerIndex += i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkReadableBytes(iRemaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex = iRemaining + this.readerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void readBytes(OutputStream outputStream, int i) {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i);
        this.readerIndex += i;
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
    @Deprecated
    public int skipBytes(ChannelBufferIndexFinder channelBufferIndexFinder) {
        int i = this.readerIndex;
        int iIndexOf = indexOf(i, this.writerIndex, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            throw new NoSuchElementException();
        }
        readerIndex(iIndexOf);
        return iIndexOf - i;
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
    public void writeMedium(int i) {
        setMedium(this.writerIndex, i);
        this.writerIndex += 3;
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
    public void writeChar(int i) {
        writeShort(i);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeFloat(float f) {
        writeInt(Float.floatToRawIntBits(f));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeDouble(double d) {
        writeLong(Double.doubleToRawLongBits(d));
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
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
    public void writeBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex = iRemaining + this.writerIndex;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writeBytes(InputStream inputStream, int i) {
        int bytes = setBytes(this.writerIndex, inputStream, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) {
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void writeZero(int i) {
        if (i != 0) {
            if (i < 0) {
                throw new IllegalArgumentException("length must be 0 or greater than 0.");
            }
            int i2 = i & 7;
            for (int i3 = i >>> 3; i3 > 0; i3--) {
                writeLong(0L);
            }
            if (i2 == 4) {
                writeInt(0);
                return;
            }
            if (i2 < 4) {
                while (i2 > 0) {
                    writeByte(0);
                    i2--;
                }
            } else {
                writeInt(0);
                for (int i4 = i2 - 4; i4 > 0; i4--) {
                    writeByte(0);
                }
            }
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer copy() {
        return copy(this.readerIndex, readableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer slice() {
        return slice(this.readerIndex, readableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer() {
        return toByteBuffer(this.readerIndex, readableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer[] toByteBuffers() {
        return toByteBuffers(this.readerIndex, readableBytes());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer[] toByteBuffers(int i, int i2) {
        return new ByteBuffer[]{toByteBuffer(i, i2)};
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString(int i, int i2, Charset charset) {
        return i2 == 0 ? "" : ChannelBuffers.decodeString(toByteBuffer(i, i2), charset);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(int i, int i2, String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        if (channelBufferIndexFinder == null) {
            return toString(i, i2, str);
        }
        int iIndexOf = indexOf(i, i + i2, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            return toString(i, i2, str);
        }
        return toString(i, iIndexOf - i, str);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(int i, int i2, String str) {
        return toString(i, i2, Charset.forName(str));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(String str, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return toString(this.readerIndex, readableBytes(), str, channelBufferIndexFinder);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    @Deprecated
    public String toString(String str) {
        return toString(Charset.forName(str));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int indexOf(int i, int i2, byte b) {
        return ChannelBuffers.indexOf(this, i, i2, b);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int indexOf(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return ChannelBuffers.indexOf(this, i, i2, channelBufferIndexFinder);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(byte b) {
        return bytesBefore(readerIndex(), readableBytes(), b);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(ChannelBufferIndexFinder channelBufferIndexFinder) {
        return bytesBefore(readerIndex(), readableBytes(), channelBufferIndexFinder);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, byte b) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, b);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, ChannelBufferIndexFinder channelBufferIndexFinder) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, channelBufferIndexFinder);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, int i2, byte b) {
        int iIndexOf = indexOf(i, i + i2, b);
        if (iIndexOf < 0) {
            return -1;
        }
        return iIndexOf - i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int bytesBefore(int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iIndexOf = indexOf(i, i + i2, channelBufferIndexFinder);
        if (iIndexOf < 0) {
            return -1;
        }
        return iIndexOf - i;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int hashCode() {
        return ChannelBuffers.hashCode(this);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
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

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public String toString() {
        return getClass().getSimpleName() + "(ridx=" + this.readerIndex + ", widx=" + this.writerIndex + ", cap=" + capacity() + ')';
    }

    protected void checkReadableBytes(int i) {
        if (readableBytes() < i) {
            throw new IndexOutOfBoundsException();
        }
    }
}
