package org.p138a.p142b.p143a.p144a;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* compiled from: Base64InputStream.java */
/* renamed from: org.a.b.a.a.a */
/* loaded from: classes.dex */
public class C5226a extends InputStream {

    /* renamed from: a */
    static final /* synthetic */ boolean f19038a;

    /* renamed from: b */
    private static Log f19039b;

    /* renamed from: c */
    private static final int[] f19040c;

    /* renamed from: d */
    private final byte[] f19041d;

    /* renamed from: e */
    private boolean f19042e;

    /* renamed from: f */
    private final InputStream f19043f;

    /* renamed from: g */
    private boolean f19044g;

    /* renamed from: h */
    private final byte[] f19045h;

    /* renamed from: i */
    private int f19046i;

    /* renamed from: j */
    private int f19047j;

    /* renamed from: k */
    private final C5228c f19048k;

    /* renamed from: l */
    private boolean f19049l;

    static {
        f19038a = !C5226a.class.desiredAssertionStatus();
        f19039b = LogFactory.getLog(C5226a.class);
        f19040c = new int[256];
        for (int i = 0; i < 256; i++) {
            f19040c[i] = -1;
        }
        for (int i2 = 0; i2 < C5227b.f19050a.length; i2++) {
            f19040c[C5227b.f19050a[i2] & 255] = i2;
        }
    }

    public C5226a(InputStream inputStream) {
        this(inputStream, false);
    }

    public C5226a(InputStream inputStream, boolean z) {
        this.f19041d = new byte[1];
        this.f19044g = false;
        this.f19045h = new byte[1536];
        this.f19046i = 0;
        this.f19047j = 0;
        this.f19048k = new C5228c();
        if (inputStream == null) {
            throw new IllegalArgumentException();
        }
        this.f19043f = inputStream;
        this.f19042e = z;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int iM19909a;
        if (this.f19044g) {
            throw new IOException("Base64InputStream has been closed");
        }
        do {
            iM19909a = m19909a(this.f19041d, 0, 1);
            if (iM19909a == -1) {
                return -1;
            }
        } while (iM19909a != 1);
        return this.f19041d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f19044g) {
            throw new IOException("Base64InputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (bArr.length == 0) {
            return 0;
        }
        return m19909a(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f19044g) {
            throw new IOException("Base64InputStream has been closed");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        return m19909a(bArr, i, i + i2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f19044g) {
            this.f19044g = true;
        }
    }

    /* renamed from: a */
    private int m19909a(byte[] bArr, int i, int i2) throws IOException {
        int iM19919b = this.f19048k.m19919b();
        int i3 = i;
        while (true) {
            int i4 = iM19919b - 1;
            if (iM19919b <= 0 || i3 >= i2) {
                break;
            }
            bArr[i3] = this.f19048k.m19917a();
            i3++;
            iM19919b = i4;
        }
        if (this.f19049l) {
            if (i3 == i) {
                return -1;
            }
            return i3 - i;
        }
        int i5 = 0;
        int i6 = 0;
        while (i3 < i2) {
            while (this.f19046i == this.f19047j) {
                int i7 = this.f19043f.read(this.f19045h, 0, this.f19045h.length);
                if (i7 == -1) {
                    this.f19049l = true;
                    if (i5 != 0) {
                        m19910a(i5);
                    }
                    if (i3 != i) {
                        return i3 - i;
                    }
                    return -1;
                }
                if (i7 > 0) {
                    this.f19046i = 0;
                    this.f19047j = i7;
                } else if (!f19038a && i7 != 0) {
                    throw new AssertionError();
                }
            }
            while (this.f19046i < this.f19047j && i3 < i2) {
                byte[] bArr2 = this.f19045h;
                int i8 = this.f19046i;
                this.f19046i = i8 + 1;
                int i9 = bArr2[i8] & 255;
                if (i9 == 61) {
                    return m19908a(i6, i5, bArr, i3, i2) - i;
                }
                int i10 = f19040c[i9];
                if (i10 >= 0) {
                    i6 = (i6 << 6) | i10;
                    i5++;
                    if (i5 == 4) {
                        byte b2 = (byte) (i6 >>> 16);
                        byte b3 = (byte) (i6 >>> 8);
                        byte b4 = (byte) i6;
                        if (i3 < i2 - 2) {
                            int i11 = i3 + 1;
                            bArr[i3] = b2;
                            int i12 = i11 + 1;
                            bArr[i11] = b3;
                            i3 = i12 + 1;
                            bArr[i12] = b4;
                            i5 = 0;
                        } else {
                            if (i3 < i2 - 1) {
                                int i13 = i3 + 1;
                                bArr[i3] = b2;
                                i3 = i13 + 1;
                                bArr[i13] = b3;
                                this.f19048k.m19918a(b4);
                            } else if (i3 < i2) {
                                bArr[i3] = b2;
                                this.f19048k.m19918a(b3);
                                this.f19048k.m19918a(b4);
                                i3++;
                            } else {
                                this.f19048k.m19918a(b2);
                                this.f19048k.m19918a(b3);
                                this.f19048k.m19918a(b4);
                            }
                            if (f19038a || i3 == i2) {
                                return i2 - i;
                            }
                            throw new AssertionError();
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!f19038a && i5 != 0) {
            throw new AssertionError();
        }
        if (f19038a || i3 == i2) {
            return i2 - i;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private int m19908a(int i, int i2, byte[] bArr, int i3, int i4) throws IOException {
        this.f19049l = true;
        if (i2 == 2) {
            byte b2 = (byte) (i >>> 4);
            if (i3 < i4) {
                int i5 = i3 + 1;
                bArr[i3] = b2;
                return i5;
            }
            this.f19048k.m19918a(b2);
            return i3;
        }
        if (i2 == 3) {
            byte b3 = (byte) (i >>> 10);
            byte b4 = (byte) ((i >>> 2) & 255);
            if (i3 < i4 - 1) {
                int i6 = i3 + 1;
                bArr[i3] = b3;
                int i7 = i6 + 1;
                bArr[i6] = b4;
                return i7;
            }
            if (i3 < i4) {
                int i8 = i3 + 1;
                bArr[i3] = b3;
                this.f19048k.m19918a(b4);
                return i8;
            }
            this.f19048k.m19918a(b3);
            this.f19048k.m19918a(b4);
            return i3;
        }
        m19911b(i2);
        return i3;
    }

    /* renamed from: a */
    private void m19910a(int i) throws IOException {
        if (this.f19042e) {
            throw new IOException("unexpected end of file");
        }
        f19039b.warn("unexpected end of file; dropping " + i + " sextet(s)");
    }

    /* renamed from: b */
    private void m19911b(int i) throws IOException {
        if (this.f19042e) {
            throw new IOException("unexpected padding character");
        }
        f19039b.warn("unexpected padding character; dropping " + i + " sextet(s)");
    }
}
