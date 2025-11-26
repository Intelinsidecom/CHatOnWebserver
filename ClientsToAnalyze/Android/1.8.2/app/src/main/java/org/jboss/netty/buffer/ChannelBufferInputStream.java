package org.jboss.netty.buffer;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ChannelBufferInputStream extends InputStream implements DataInput {
    private final ChannelBuffer buffer;
    private final int endIndex;
    private final StringBuilder lineBuf;
    private final int startIndex;

    public ChannelBufferInputStream(ChannelBuffer channelBuffer) {
        this(channelBuffer, channelBuffer.readableBytes());
    }

    public ChannelBufferInputStream(ChannelBuffer channelBuffer, int i) {
        this.lineBuf = new StringBuilder();
        if (channelBuffer == null) {
            throw new NullPointerException("buffer");
        }
        if (i < 0) {
            throw new IllegalArgumentException("length: " + i);
        }
        if (i > channelBuffer.readableBytes()) {
            throw new IndexOutOfBoundsException();
        }
        this.buffer = channelBuffer;
        this.startIndex = channelBuffer.readerIndex();
        this.endIndex = this.startIndex + i;
        channelBuffer.markReaderIndex();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.buffer.readable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        this.buffer.readBytes(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return j > 2147483647L ? skipBytes(Integer.MAX_VALUE) : skipBytes((int) j);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws EOFException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() throws EOFException {
        if (!this.buffer.readable()) {
            throw new EOFException();
        }
        return this.buffer.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws EOFException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws EOFException {
        checkAvailable(i2);
        this.buffer.readBytes(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws EOFException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        this.lineBuf.setLength(0);
        while (true) {
            int i = read();
            if (i < 0 || i == 10) {
                break;
            }
            this.lineBuf.append((char) i);
        }
        while (this.lineBuf.charAt(this.lineBuf.length() - 1) == '\r') {
            this.lineBuf.setLength(this.lineBuf.length() - 1);
        }
        return this.lineBuf.toString();
    }

    @Override // java.io.DataInput
    public long readLong() throws EOFException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws EOFException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        int iMin = Math.min(available(), i);
        this.buffer.skipBytes(iMin);
        return iMin;
    }

    private void checkAvailable(int i) throws EOFException {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i > available()) {
            throw new EOFException();
        }
    }
}
