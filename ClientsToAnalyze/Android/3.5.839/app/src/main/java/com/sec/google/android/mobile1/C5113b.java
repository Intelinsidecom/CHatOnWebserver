package com.sec.google.android.mobile1;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: DrmRawContent.java */
/* renamed from: com.sec.google.android.mobile1.b */
/* loaded from: classes.dex */
class C5113b extends InputStream {

    /* renamed from: a */
    final /* synthetic */ DrmRawContent f18603a;

    /* renamed from: b */
    private boolean f18604b = false;

    /* renamed from: c */
    private int f18605c = 0;

    /* renamed from: d */
    private byte[] f18606d = new byte[1];

    public C5113b(DrmRawContent drmRawContent, DrmRights drmRights) {
        this.f18603a = drmRawContent;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        int iNativeGetContentLength = this.f18603a.nativeGetContentLength();
        if (-1 == iNativeGetContentLength) {
            throw new IOException();
        }
        if (-3 == iNativeGetContentLength) {
            return 0;
        }
        int i = iNativeGetContentLength - this.f18605c;
        if (i < 0) {
            throw new IOException();
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read() {
        if (-1 == read(this.f18606d, 0, 1)) {
            return -1;
        }
        return this.f18606d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (true == this.f18604b) {
            throw new IOException();
        }
        if (i2 != 0) {
            int iNativeReadContent = this.f18603a.nativeReadContent(bArr, i, i2, this.f18605c);
            if (-1 == iNativeReadContent) {
                throw new IOException();
            }
            if (-2 == iNativeReadContent) {
                return -1;
            }
            this.f18605c += iNativeReadContent;
            return iNativeReadContent;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new IOException();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return 0L;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18604b = true;
    }
}
