package com.google.protobuf;

import java.io.FilterOutputStream;

/* loaded from: classes.dex */
public final class ByteString {

    /* renamed from: a */
    public static final ByteString f218a = new ByteString(new byte[0]);

    /* renamed from: b */
    private final byte[] f219b;

    /* renamed from: c */
    private volatile int f220c;

    public final class Output extends FilterOutputStream {
    }

    private ByteString(byte[] bArr) {
        this.f220c = 0;
        this.f219b = bArr;
    }

    /* renamed from: a */
    static C0058f m268a(int i) {
        return new C0058f(i);
    }

    /* renamed from: a */
    public CodedInputStream m269a() {
        return CodedInputStream.m272a(this.f219b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        int length = this.f219b.length;
        if (length != byteString.f219b.length) {
            return false;
        }
        byte[] bArr = this.f219b;
        byte[] bArr2 = byteString.f219b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f220c;
        if (i == 0) {
            byte[] bArr = this.f219b;
            int length = this.f219b.length;
            int i2 = length;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + bArr[i3];
            }
            i = i2 == 0 ? 1 : i2;
            this.f220c = i;
        }
        return i;
    }
}
