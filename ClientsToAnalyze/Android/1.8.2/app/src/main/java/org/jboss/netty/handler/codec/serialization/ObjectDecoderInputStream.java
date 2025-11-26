package org.jboss.netty.handler.codec.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;

/* loaded from: classes.dex */
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    private final ClassResolver classResolver;

    /* renamed from: in */
    private final DataInputStream f7871in;
    private final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader) {
        this(inputStream, classLoader, 1048576);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i) {
        this(inputStream, null, i);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("maxObjectSize: " + i);
        }
        if (inputStream instanceof DataInputStream) {
            this.f7871in = (DataInputStream) inputStream;
        } else {
            this.f7871in = new DataInputStream(inputStream);
        }
        this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
        this.maxObjectSize = i;
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws StreamCorruptedException {
        int i = readInt();
        if (i <= 0) {
            throw new StreamCorruptedException("invalid data length: " + i);
        }
        if (i > this.maxObjectSize) {
            throw new StreamCorruptedException("data length too big: " + i + " (max: " + this.maxObjectSize + ')');
        }
        return new CompactObjectInputStream(this.f7871in, this.classResolver).readObject();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() {
        return this.f7871in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() {
        this.f7871in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f7871in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f7871in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() {
        return this.f7871in.read();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr, int i, int i2) {
        return this.f7871in.read(bArr, i, i2);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr) {
        return this.f7871in.read(bArr);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return this.f7871in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return this.f7871in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return this.f7871in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return this.f7871in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return this.f7871in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f7871in.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f7871in.readFully(bArr);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        return this.f7871in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() {
        return this.f7871in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() {
        return this.f7871in.readLong();
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return this.f7871in.readShort();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        return this.f7871in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return this.f7871in.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return this.f7871in.readUTF();
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f7871in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long j) {
        return this.f7871in.skip(j);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return this.f7871in.skipBytes(i);
    }
}
