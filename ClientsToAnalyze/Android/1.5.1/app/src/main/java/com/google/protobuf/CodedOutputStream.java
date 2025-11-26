package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class CodedOutputStream {

    /* renamed from: a */
    private final byte[] f232a;

    /* renamed from: b */
    private final int f233b;

    /* renamed from: c */
    private int f234c;

    /* renamed from: d */
    private final OutputStream f235d;

    public class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f235d = outputStream;
        this.f232a = bArr;
        this.f234c = 0;
        this.f233b = bArr.length;
    }

    private CodedOutputStream(byte[] bArr, int i, int i2) {
        this.f235d = null;
        this.f232a = bArr;
        this.f234c = i;
        this.f233b = i + i2;
    }

    /* renamed from: a */
    static int m296a(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    /* renamed from: a */
    public static CodedOutputStream m297a(OutputStream outputStream) {
        return m298a(outputStream, 4096);
    }

    /* renamed from: a */
    public static CodedOutputStream m298a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static CodedOutputStream m299a(byte[] bArr) {
        return m300a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static CodedOutputStream m300a(byte[] bArr, int i, int i2) {
        return new CodedOutputStream(bArr, i, i2);
    }

    /* renamed from: b */
    public static int m301b(int i, long j) {
        return m315g(i) + m305b(j);
    }

    /* renamed from: b */
    public static int m302b(int i, MessageLite messageLite) {
        return m315g(i) + m306b(messageLite);
    }

    /* renamed from: b */
    public static int m303b(int i, String str) {
        return m315g(i) + m307b(str);
    }

    /* renamed from: b */
    public static int m304b(int i, boolean z) {
        return m315g(i) + m308b(z);
    }

    /* renamed from: b */
    public static int m305b(long j) {
        return m312d(j);
    }

    /* renamed from: b */
    public static int m306b(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return serializedSize + m316i(serializedSize);
    }

    /* renamed from: b */
    public static int m307b(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m316i(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: b */
    public static int m308b(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m309c(int i, int i2) {
        return m315g(i) + m310d(i2);
    }

    /* renamed from: d */
    public static int m310d(int i) {
        if (i >= 0) {
            return m316i(i);
        }
        return 10;
    }

    /* renamed from: d */
    public static int m311d(int i, int i2) {
        return m315g(i) + m314e(i2);
    }

    /* renamed from: d */
    public static int m312d(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: d */
    private void m313d() throws IOException {
        if (this.f235d == null) {
            throw new OutOfSpaceException();
        }
        this.f235d.write(this.f232a, 0, this.f234c);
        this.f234c = 0;
    }

    /* renamed from: e */
    public static int m314e(int i) {
        return m316i(i);
    }

    /* renamed from: g */
    public static int m315g(int i) {
        return m316i(WireFormat.m352a(i, 0));
    }

    /* renamed from: i */
    public static int m316i(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public void m317a() throws IOException {
        if (this.f235d != null) {
            m313d();
        }
    }

    /* renamed from: a */
    public void m318a(byte b) throws IOException {
        if (this.f234c == this.f233b) {
            m313d();
        }
        byte[] bArr = this.f232a;
        int i = this.f234c;
        this.f234c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void m319a(int i, int i2) throws IOException {
        m336e(i, 0);
        m329b(i2);
    }

    /* renamed from: a */
    public void m320a(int i, long j) throws IOException {
        m336e(i, 0);
        m324a(j);
    }

    /* renamed from: a */
    public void m321a(int i, MessageLite messageLite) throws IOException {
        m336e(i, 2);
        m325a(messageLite);
    }

    /* renamed from: a */
    public void m322a(int i, String str) throws IOException {
        m336e(i, 2);
        m326a(str);
    }

    /* renamed from: a */
    public void m323a(int i, boolean z) throws IOException {
        m336e(i, 0);
        m327a(z);
    }

    /* renamed from: a */
    public void m324a(long j) throws IOException {
        m335c(j);
    }

    /* renamed from: a */
    public void m325a(MessageLite messageLite) throws IOException {
        m338h(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    /* renamed from: a */
    public void m326a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m338h(bytes.length);
        m331b(bytes);
    }

    /* renamed from: a */
    public void m327a(boolean z) throws IOException {
        m337f(z ? 1 : 0);
    }

    /* renamed from: b */
    public int m328b() {
        if (this.f235d == null) {
            return this.f233b - this.f234c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: b */
    public void m329b(int i) throws IOException {
        if (i >= 0) {
            m338h(i);
        } else {
            m335c(i);
        }
    }

    /* renamed from: b */
    public void m330b(int i, int i2) throws IOException {
        m336e(i, 0);
        m334c(i2);
    }

    /* renamed from: b */
    public void m331b(byte[] bArr) throws IOException {
        m332b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void m332b(byte[] bArr, int i, int i2) throws IOException {
        if (this.f233b - this.f234c >= i2) {
            System.arraycopy(bArr, i, this.f232a, this.f234c, i2);
            this.f234c += i2;
            return;
        }
        int i3 = this.f233b - this.f234c;
        System.arraycopy(bArr, i, this.f232a, this.f234c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f234c = this.f233b;
        m313d();
        if (i5 > this.f233b) {
            this.f235d.write(bArr, i4, i5);
        } else {
            System.arraycopy(bArr, i4, this.f232a, 0, i5);
            this.f234c = i5;
        }
    }

    /* renamed from: c */
    public void m333c() {
        if (m328b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: c */
    public void m334c(int i) throws IOException {
        m338h(i);
    }

    /* renamed from: c */
    public void m335c(long j) throws IOException {
        long j2 = j;
        while (((-128) & j2) != 0) {
            m337f((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        m337f((int) j2);
    }

    /* renamed from: e */
    public void m336e(int i, int i2) throws IOException {
        m338h(WireFormat.m352a(i, i2));
    }

    /* renamed from: f */
    public void m337f(int i) throws IOException {
        m318a((byte) i);
    }

    /* renamed from: h */
    public void m338h(int i) throws IOException {
        int i2 = i;
        while ((i2 & (-128)) != 0) {
            m337f((i2 & 127) | 128);
            i2 >>>= 7;
        }
        m337f(i2);
    }
}
