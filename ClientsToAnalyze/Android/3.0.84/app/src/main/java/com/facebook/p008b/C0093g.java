package com.facebook.p008b;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.g */
/* loaded from: classes.dex */
class C0093g extends OutputStream {

    /* renamed from: a */
    final OutputStream f173a;

    /* renamed from: b */
    final InterfaceC0097k f174b;

    C0093g(OutputStream outputStream, InterfaceC0097k interfaceC0097k) {
        this.f173a = outputStream;
        this.f174b = interfaceC0097k;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f173a.close();
        } finally {
            this.f174b.mo231a();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f173a.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f173a.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f173a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f173a.write(i);
    }
}
