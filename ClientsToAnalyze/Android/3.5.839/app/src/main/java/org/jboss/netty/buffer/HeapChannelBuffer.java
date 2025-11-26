package org.jboss.netty.buffer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class HeapChannelBuffer extends AbstractChannelBuffer {
    protected final byte[] array;

    public HeapChannelBuffer(int i) {
        this(new byte[i], 0, 0);
    }

    public HeapChannelBuffer(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    protected HeapChannelBuffer(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("array");
        }
        this.array = bArr;
        setIndex(i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean isDirect() {
        return false;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int capacity() {
        return this.array.length;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        return this.array;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte getByte(int i) {
        return this.array[i];
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        System.arraycopy(this.array, i, bArr, i2, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        byteBuffer.put(this.array, i, Math.min(capacity() - i, byteBuffer.remaining()));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        outputStream.write(this.array, i, i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setByte(int i, int i2) {
        this.array[i] = (byte) i2;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        if (channelBuffer instanceof HeapChannelBuffer) {
            setBytes(i, ((HeapChannelBuffer) channelBuffer).array, i2, i3);
        } else {
            channelBuffer.getBytes(i2, this.array, i, i3);
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        System.arraycopy(bArr, i2, this.array, i, i3);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ByteBuffer byteBuffer) {
        byteBuffer.get(this.array, i, byteBuffer.remaining());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        return ByteBuffer.wrap(this.array, i, i2).order(order());
    }
}
