package com.facebook.p032b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.h */
/* loaded from: classes.dex */
final class C0465h extends InputStream {

    /* renamed from: a */
    final InputStream f1144a;

    /* renamed from: b */
    final OutputStream f1145b;

    C0465h(InputStream inputStream, OutputStream outputStream) {
        this.f1144a = inputStream;
        this.f1145b = outputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f1144a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f1144a.close();
        } finally {
            this.f1145b.close();
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.f1144a.read(bArr);
        if (i > 0) {
            this.f1145b.write(bArr, 0, i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f1144a.read();
        if (i >= 0) {
            this.f1145b.write(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f1144a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f1145b.write(bArr, i, i3);
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i;
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (j2 < j && (i = read(bArr, 0, (int) Math.min(j - j2, bArr.length))) >= 0) {
            j2 += i;
        }
        return j2;
    }
}
