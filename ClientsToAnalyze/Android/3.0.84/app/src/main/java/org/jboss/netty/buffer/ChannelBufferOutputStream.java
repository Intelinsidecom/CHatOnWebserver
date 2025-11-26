package org.jboss.netty.buffer;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ChannelBufferOutputStream extends OutputStream implements DataOutput {
    private final ChannelBuffer buffer;
    private final int startIndex;
    private final DataOutputStream utf8out = new DataOutputStream(this);

    public ChannelBufferOutputStream(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("buffer");
        }
        this.buffer = channelBuffer;
        this.startIndex = channelBuffer.writerIndex();
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.buffer.writeBytes(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr) {
        this.buffer.writeBytes(bArr);
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(int i) {
        this.buffer.writeByte((byte) i);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) {
        write(z ? 1 : 0);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) {
        write(i);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            write((byte) str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) {
        writeShort((short) i);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            writeChar(str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) {
        this.buffer.writeInt(i);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) {
        this.buffer.writeLong(j);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) {
        this.buffer.writeShort((short) i);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        this.utf8out.writeUTF(str);
    }

    public ChannelBuffer buffer() {
        return this.buffer;
    }
}
