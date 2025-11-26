package com.facebook.p032b;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.g */
/* loaded from: classes.dex */
class C0464g extends OutputStream {

    /* renamed from: a */
    final OutputStream f1142a;

    /* renamed from: b */
    final InterfaceC0468k f1143b;

    C0464g(OutputStream outputStream, InterfaceC0468k interfaceC0468k) {
        this.f1142a = outputStream;
        this.f1143b = interfaceC0468k;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f1142a.close();
        } finally {
            this.f1143b.mo1675a();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f1142a.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f1142a.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f1142a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f1142a.write(i);
    }
}
