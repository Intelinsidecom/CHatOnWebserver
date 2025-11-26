package org.p138a.p142b.p143a.p144a;

import com.sec.amsoma.AMSLibs;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Base64OutputStream.java */
/* renamed from: org.a.b.a.a.b */
/* loaded from: classes.dex */
public class C5227b extends FilterOutputStream {

    /* renamed from: a */
    static final byte[] f19050a;

    /* renamed from: b */
    static final /* synthetic */ boolean f19051b;

    /* renamed from: c */
    private static final byte[] f19052c;

    /* renamed from: d */
    private static final Set<Byte> f19053d;

    /* renamed from: e */
    private final byte[] f19054e;

    /* renamed from: f */
    private final int f19055f;

    /* renamed from: g */
    private final byte[] f19056g;

    /* renamed from: h */
    private boolean f19057h;

    /* renamed from: i */
    private final byte[] f19058i;

    /* renamed from: j */
    private int f19059j;

    /* renamed from: k */
    private int f19060k;

    /* renamed from: l */
    private int f19061l;

    /* renamed from: m */
    private int f19062m;

    static {
        f19051b = !C5227b.class.desiredAssertionStatus();
        f19052c = new byte[]{AMSLibs.ENUM_VIP_AMS_DIAGRAM_OBJECT_NUM_FULL, 10};
        f19050a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, AMSLibs.ENUM_VIP_AMS_WVGA_DRAW_BASIC_STAMPSIZE, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_ERROR_OBJECT_IMAGE_NUM_FULL, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, AMSLibs.ENUM_VIP_AMS_CB_ERROR_FILE_WRITE, AMSLibs.ENUM_VIP_AMS_CB_ERROR_JPEG_DECODING};
        f19053d = new HashSet();
        for (byte b2 : f19050a) {
            f19053d.add(Byte.valueOf(b2));
        }
        f19053d.add((byte) 61);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        if (this.f19057h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        this.f19054e[0] = (byte) i;
        m19913a(this.f19054e, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        if (this.f19057h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (bArr.length != 0) {
            m19913a(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f19057h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            m19913a(bArr, i, i + i2);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.f19057h) {
            throw new IOException("Base64OutputStream has been closed");
        }
        m19912a();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f19057h) {
            this.f19057h = true;
            m19914b();
        }
    }

    /* renamed from: a */
    private void m19913a(byte[] bArr, int i, int i2) throws IOException {
        while (i < i2) {
            this.f19060k = (this.f19060k << 8) | (bArr[i] & 255);
            int i3 = this.f19061l + 1;
            this.f19061l = i3;
            if (i3 == 3) {
                this.f19061l = 0;
                if (this.f19055f > 0 && this.f19062m >= this.f19055f) {
                    this.f19062m = 0;
                    if (this.f19058i.length - this.f19059j < this.f19056g.length) {
                        m19912a();
                    }
                    for (byte b2 : this.f19056g) {
                        byte[] bArr2 = this.f19058i;
                        int i4 = this.f19059j;
                        this.f19059j = i4 + 1;
                        bArr2[i4] = b2;
                    }
                }
                if (this.f19058i.length - this.f19059j < 4) {
                    m19912a();
                }
                byte[] bArr3 = this.f19058i;
                int i5 = this.f19059j;
                this.f19059j = i5 + 1;
                bArr3[i5] = f19050a[(this.f19060k >> 18) & 63];
                byte[] bArr4 = this.f19058i;
                int i6 = this.f19059j;
                this.f19059j = i6 + 1;
                bArr4[i6] = f19050a[(this.f19060k >> 12) & 63];
                byte[] bArr5 = this.f19058i;
                int i7 = this.f19059j;
                this.f19059j = i7 + 1;
                bArr5[i7] = f19050a[(this.f19060k >> 6) & 63];
                byte[] bArr6 = this.f19058i;
                int i8 = this.f19059j;
                this.f19059j = i8 + 1;
                bArr6[i8] = f19050a[this.f19060k & 63];
                this.f19062m += 4;
            }
            i++;
        }
    }

    /* renamed from: a */
    private void m19912a() throws IOException {
        if (this.f19059j > 0) {
            this.out.write(this.f19058i, 0, this.f19059j);
            this.f19059j = 0;
        }
    }

    /* renamed from: b */
    private void m19914b() throws IOException {
        if (this.f19061l != 0) {
            m19915c();
        }
        if (this.f19055f > 0 && this.f19062m > 0) {
            m19916d();
        }
        m19912a();
    }

    /* renamed from: c */
    private void m19915c() throws IOException {
        if (this.f19055f > 0 && this.f19062m >= this.f19055f) {
            m19916d();
        }
        if (this.f19058i.length - this.f19059j < 4) {
            m19912a();
        }
        if (this.f19061l == 1) {
            byte[] bArr = this.f19058i;
            int i = this.f19059j;
            this.f19059j = i + 1;
            bArr[i] = f19050a[(this.f19060k >> 2) & 63];
            byte[] bArr2 = this.f19058i;
            int i2 = this.f19059j;
            this.f19059j = i2 + 1;
            bArr2[i2] = f19050a[(this.f19060k << 4) & 63];
            byte[] bArr3 = this.f19058i;
            int i3 = this.f19059j;
            this.f19059j = i3 + 1;
            bArr3[i3] = 61;
            byte[] bArr4 = this.f19058i;
            int i4 = this.f19059j;
            this.f19059j = i4 + 1;
            bArr4[i4] = 61;
        } else {
            if (!f19051b && this.f19061l != 2) {
                throw new AssertionError();
            }
            byte[] bArr5 = this.f19058i;
            int i5 = this.f19059j;
            this.f19059j = i5 + 1;
            bArr5[i5] = f19050a[(this.f19060k >> 10) & 63];
            byte[] bArr6 = this.f19058i;
            int i6 = this.f19059j;
            this.f19059j = i6 + 1;
            bArr6[i6] = f19050a[(this.f19060k >> 4) & 63];
            byte[] bArr7 = this.f19058i;
            int i7 = this.f19059j;
            this.f19059j = i7 + 1;
            bArr7[i7] = f19050a[(this.f19060k << 2) & 63];
            byte[] bArr8 = this.f19058i;
            int i8 = this.f19059j;
            this.f19059j = i8 + 1;
            bArr8[i8] = 61;
        }
        this.f19062m += 4;
    }

    /* renamed from: d */
    private void m19916d() throws IOException {
        this.f19062m = 0;
        if (this.f19058i.length - this.f19059j < this.f19056g.length) {
            m19912a();
        }
        for (byte b2 : this.f19056g) {
            byte[] bArr = this.f19058i;
            int i = this.f19059j;
            this.f19059j = i + 1;
            bArr[i] = b2;
        }
    }
}
