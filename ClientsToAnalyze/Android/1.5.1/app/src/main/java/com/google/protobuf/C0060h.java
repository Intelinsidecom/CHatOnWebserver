package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.protobuf.h */
/* loaded from: classes.dex */
final class C0060h extends FilterInputStream {

    /* renamed from: a */
    private int f281a;

    C0060h(InputStream inputStream, int i) {
        super(inputStream);
        this.f281a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return Math.min(super.available(), this.f281a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f281a <= 0) {
            return -1;
        }
        int i = super.read();
        if (i < 0) {
            return i;
        }
        this.f281a--;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f281a <= 0) {
            return -1;
        }
        int i3 = super.read(bArr, i, Math.min(i2, this.f281a));
        if (i3 < 0) {
            return i3;
        }
        this.f281a -= i3;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(Math.min(j, this.f281a));
        if (jSkip >= 0) {
            this.f281a = (int) (this.f281a - jSkip);
        }
        return jSkip;
    }
}
