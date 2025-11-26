package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

/* renamed from: com.samsung.samm.lib.a.h */
/* loaded from: classes.dex */
public class C0894h {

    /* renamed from: a */
    private static final byte[] f561a = "SAMSUNG AMS".getBytes();

    /* renamed from: b */
    private static final int f562b = f561a.length;

    /* renamed from: c */
    private int f578c = 1;

    /* renamed from: d */
    private int f579d = 17;

    /* renamed from: e */
    private int f580e = 0;

    /* renamed from: f */
    private int f581f = 0;

    /* renamed from: g */
    private int f582g = 0;

    /* renamed from: h */
    private int f583h = 0;

    /* renamed from: i */
    private int f584i = 0;

    /* renamed from: j */
    private int f585j = 0;

    /* renamed from: k */
    private int f586k = 0;

    /* renamed from: l */
    private int f587l = 0;

    /* renamed from: m */
    private int f588m = 0;

    /* renamed from: n */
    private int f589n = 0;

    /* renamed from: o */
    private int f590o = 0;

    /* renamed from: p */
    private int f591p = 0;

    /* renamed from: q */
    private int f592q = 0;

    /* renamed from: r */
    private int f593r = 0;

    /* renamed from: s */
    private int f594s = 0;

    /* renamed from: t */
    private int f595t = 0;

    /* renamed from: u */
    private int f596u = 0;

    /* renamed from: v */
    private int f597v = 0;

    /* renamed from: w */
    private int f598w = 0;

    /* renamed from: x */
    private int f599x = 0;

    /* renamed from: y */
    private int f600y = 0;

    /* renamed from: z */
    private int f601z = 0;

    /* renamed from: A */
    private int f563A = 0;

    /* renamed from: B */
    private int f564B = 0;

    /* renamed from: C */
    private int f565C = 0;

    /* renamed from: D */
    private int f566D = 0;

    /* renamed from: E */
    private int f567E = 0;

    /* renamed from: F */
    private int f568F = 0;

    /* renamed from: G */
    private int f569G = 0;

    /* renamed from: H */
    private int f570H = 0;

    /* renamed from: I */
    private int f571I = 0;

    /* renamed from: J */
    private int f572J = 0;

    /* renamed from: K */
    private int f573K = 0;

    /* renamed from: L */
    private int f574L = 0;

    /* renamed from: M */
    private int f575M = 0;

    /* renamed from: N */
    private long f576N = 0;

    /* renamed from: O */
    private long f577O = 0;

    /* renamed from: a */
    public long m452a() {
        return this.f576N;
    }

    /* renamed from: b */
    public long m455b() {
        return this.f577O;
    }

    /* renamed from: a */
    public void m453a(int i) {
        this.f580e = i;
    }

    /* renamed from: c */
    public int m458c() {
        return this.f581f;
    }

    /* renamed from: b */
    public void m456b(int i) {
        this.f581f = i;
    }

    /* renamed from: d */
    public int m460d() {
        return this.f582g;
    }

    /* renamed from: c */
    public void m459c(int i) {
        this.f582g = i;
    }

    /* renamed from: e */
    public int m462e() {
        return this.f583h;
    }

    /* renamed from: d */
    public void m461d(int i) {
        this.f583h = i;
    }

    /* renamed from: f */
    public int m464f() {
        return this.f584i;
    }

    /* renamed from: e */
    public void m463e(int i) {
        this.f584i = i;
    }

    /* renamed from: g */
    public int m466g() {
        return this.f585j;
    }

    /* renamed from: f */
    public void m465f(int i) {
        this.f585j = i;
    }

    /* renamed from: h */
    public int m468h() {
        return this.f586k;
    }

    /* renamed from: g */
    public void m467g(int i) {
        this.f586k = i;
    }

    /* renamed from: i */
    public int m470i() {
        return this.f589n;
    }

    /* renamed from: h */
    public void m469h(int i) {
        this.f589n = i;
    }

    /* renamed from: j */
    public int m472j() {
        return this.f590o;
    }

    /* renamed from: i */
    public void m471i(int i) {
        this.f590o = i;
    }

    /* renamed from: k */
    public int m474k() {
        return this.f592q;
    }

    /* renamed from: j */
    public void m473j(int i) {
        this.f592q = i;
    }

    /* renamed from: l */
    public int m476l() {
        return this.f593r;
    }

    /* renamed from: k */
    public void m475k(int i) {
        this.f593r = i;
    }

    /* renamed from: m */
    public int m478m() {
        return this.f594s;
    }

    /* renamed from: l */
    public void m477l(int i) {
        this.f594s = i;
    }

    /* renamed from: n */
    public int m480n() {
        return this.f595t;
    }

    /* renamed from: m */
    public void m479m(int i) {
        this.f595t = i;
    }

    /* renamed from: o */
    public int m482o() {
        return this.f596u;
    }

    /* renamed from: n */
    public void m481n(int i) {
        this.f596u = i;
    }

    /* renamed from: p */
    public int m484p() {
        return this.f597v;
    }

    /* renamed from: o */
    public void m483o(int i) {
        this.f597v = i;
    }

    /* renamed from: q */
    public int m486q() {
        return this.f598w;
    }

    /* renamed from: p */
    public void m485p(int i) {
        this.f598w = i;
    }

    /* renamed from: r */
    public int m488r() {
        return this.f599x;
    }

    /* renamed from: q */
    public void m487q(int i) {
        this.f599x = i;
    }

    /* renamed from: s */
    public int m490s() {
        return this.f600y;
    }

    /* renamed from: r */
    public void m489r(int i) {
        this.f600y = i;
    }

    /* renamed from: s */
    public void m491s(int i) {
        this.f563A = i;
    }

    /* renamed from: t */
    public int m492t() {
        return this.f564B;
    }

    /* renamed from: t */
    public void m493t(int i) {
        this.f564B = i;
    }

    /* renamed from: u */
    public int m494u() {
        return this.f565C;
    }

    /* renamed from: u */
    public void m495u(int i) {
        this.f565C = i;
    }

    /* renamed from: v */
    public int m496v() {
        return this.f566D;
    }

    /* renamed from: v */
    public void m497v(int i) {
        this.f566D = i;
    }

    /* renamed from: w */
    public int m498w() {
        return this.f567E;
    }

    /* renamed from: w */
    public void m499w(int i) {
        this.f567E = i;
    }

    /* renamed from: x */
    public int m500x() {
        return this.f568F;
    }

    /* renamed from: x */
    public void m501x(int i) {
        this.f568F = i;
    }

    /* renamed from: y */
    public int m502y() {
        return this.f569G;
    }

    /* renamed from: y */
    public void m503y(int i) {
        this.f569G = i;
    }

    /* renamed from: z */
    public int m504z() {
        return this.f570H;
    }

    /* renamed from: z */
    public void m505z(int i) {
        this.f570H = i;
    }

    /* renamed from: A */
    public int m442A() {
        return this.f571I;
    }

    /* renamed from: A */
    public void m443A(int i) {
        this.f571I = i;
    }

    /* renamed from: B */
    public int m444B() {
        return this.f572J;
    }

    /* renamed from: B */
    public void m445B(int i) {
        this.f572J = i;
    }

    /* renamed from: C */
    public int m446C() {
        return this.f573K;
    }

    /* renamed from: C */
    public void m447C(int i) {
        this.f573K = i;
    }

    /* renamed from: D */
    public int m448D() {
        return this.f574L;
    }

    /* renamed from: D */
    public void m449D(int i) {
        this.f574L = i;
    }

    /* renamed from: E */
    public int m450E() {
        return this.f575M;
    }

    /* renamed from: E */
    public void m451E(int i) {
        this.f575M = i;
    }

    /* renamed from: a */
    public boolean m454a(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[100];
        int[] iArr = new int[1];
        try {
            randomAccessFile.read(bArr);
            byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, f562b);
            int iM582a = C0903q.m582a(bArr, 0, bArr2);
            if (!new String(f561a).equals(new String(bArr2[0]))) {
                for (int i = 0; i < f562b; i++) {
                    Log.e("SAMMLibraryCore", "Invalid AMS Marker[" + i + "]" + ((int) bArr2[0][i]));
                }
                return false;
            }
            int i2 = iM582a + 1;
            this.f578c = bArr[iM582a] & 255;
            int i3 = i2 + 1;
            this.f579d = bArr[i2] & 255;
            int i4 = i3 + 1;
            this.f580e = bArr[i3] & 255;
            int i5 = i4 + 1;
            this.f581f = bArr[i4] & 255;
            int i6 = i5 + 1;
            this.f582g = bArr[i5] & 255;
            int i7 = i6 + 1;
            this.f583h = bArr[i6] & 255;
            int i8 = i7 + 1;
            this.f584i = bArr[i7] & 255;
            int i9 = i8 + 1;
            this.f585j = bArr[i8] & 255;
            int i10 = i9 + 1;
            this.f586k = bArr[i9] & 255;
            int i11 = i10 + 1;
            this.f587l = bArr[i10] & 255;
            this.f588m = bArr[i11] & 255;
            int iM581a = C0903q.m581a(bArr, i11 + 1, iArr);
            this.f589n = iArr[0];
            int i12 = iM581a + 1;
            this.f590o = bArr[iM581a] & 255;
            this.f591p = bArr[i12] & 255;
            int iM581a2 = C0903q.m581a(bArr, i12 + 1, iArr);
            this.f592q = iArr[0];
            int iM581a3 = C0903q.m581a(bArr, iM581a2, iArr);
            this.f593r = iArr[0] >> 3;
            int iM593b = C0903q.m593b(bArr, iM581a3, iArr);
            this.f594s = iArr[0];
            int iM593b2 = C0903q.m593b(bArr, iM593b, iArr);
            this.f595t = iArr[0];
            int iM593b3 = C0903q.m593b(bArr, iM593b2, iArr);
            this.f596u = iArr[0];
            int i13 = iM593b3 + 1;
            this.f597v = bArr[iM593b3] & 255;
            this.f598w = bArr[i13] & 255;
            int iM581a4 = C0903q.m581a(bArr, i13 + 1, iArr);
            this.f599x = iArr[0];
            int iM593b4 = C0903q.m593b(bArr, iM581a4, iArr);
            this.f600y = iArr[0];
            int i14 = iM593b4 + 1;
            this.f601z = bArr[iM593b4] & 255;
            int i15 = i14 + 1;
            this.f563A = bArr[i14] & 255;
            int i16 = i15 + 1;
            this.f564B = bArr[i15] & 255;
            int i17 = i16 + 1;
            this.f565C = bArr[i16] & 255;
            int i18 = i17 + 1;
            this.f566D = bArr[i17] & 255;
            int i19 = i18 + 1;
            this.f567E = bArr[i18] & 255;
            int i20 = i19 + 1;
            this.f568F = bArr[i19] & 255;
            int i21 = i20 + 1;
            this.f569G = bArr[i20] & 255;
            int i22 = i21 + 1;
            this.f570H = bArr[i21] & 255;
            int i23 = i22 + 1;
            this.f571I = bArr[i22] & 255;
            int i24 = i23 + 1;
            this.f572J = bArr[i23] & 255;
            int i25 = i24 + 1;
            this.f573K = bArr[i24] & 255;
            this.f574L = bArr[i25] & 255;
            this.f575M = bArr[i25 + 1] & 255;
            if (this.f578c != 1) {
                return false;
            }
            if (this.f579d <= 17 || (this.f579d >> 4) == 1) {
                return this.f569G <= 1 && this.f572J <= 1;
            }
            return false;
        } catch (FileNotFoundException e) {
            Log.e("SAMMLibraryCore", "Read AMS Header Error : FileNotFoundException : " + e);
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            Log.e("SAMMLibraryCore", "Read AMS Header Error : IOException : " + e2);
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean m457b(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[100];
        try {
            int iM580a = C0903q.m580a(bArr, 0, f561a);
            int i = iM580a + 1;
            bArr[iM580a] = 1;
            int i2 = i + 1;
            bArr[i] = 17;
            int i3 = i2 + 1;
            bArr[i2] = (byte) this.f580e;
            int i4 = i3 + 1;
            bArr[i3] = (byte) this.f581f;
            int i5 = i4 + 1;
            bArr[i4] = (byte) this.f582g;
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.f583h;
            int i7 = i6 + 1;
            bArr[i6] = (byte) this.f584i;
            int i8 = i7 + 1;
            bArr[i7] = (byte) this.f585j;
            int i9 = i8 + 1;
            bArr[i8] = (byte) this.f586k;
            int i10 = i9 + 1;
            bArr[i9] = (byte) this.f587l;
            bArr[i10] = (byte) this.f588m;
            int iM579a = C0903q.m579a(bArr, i10 + 1, this.f589n);
            this.f576N = randomAccessFile.getFilePointer() + iM579a;
            int i11 = iM579a + 1;
            int i12 = i11 + 1;
            bArr[i11] = (byte) this.f591p;
            this.f577O = randomAccessFile.getFilePointer() + i12;
            int iM592b = C0903q.m592b(bArr, C0903q.m592b(bArr, C0903q.m592b(bArr, i12 + 4 + 4, this.f594s), this.f595t), this.f596u);
            int i13 = iM592b + 1;
            bArr[iM592b] = (byte) this.f597v;
            bArr[i13] = (byte) this.f598w;
            int iM592b2 = C0903q.m592b(bArr, C0903q.m579a(bArr, i13 + 1, this.f599x), this.f600y);
            int i14 = iM592b2 + 1;
            bArr[iM592b2] = (byte) this.f601z;
            int i15 = i14 + 1;
            bArr[i14] = (byte) this.f563A;
            int i16 = i15 + 1;
            bArr[i15] = (byte) this.f564B;
            int i17 = i16 + 1;
            bArr[i16] = (byte) this.f565C;
            int i18 = i17 + 1;
            bArr[i17] = (byte) this.f566D;
            int i19 = i18 + 1;
            bArr[i18] = (byte) this.f567E;
            int i20 = i19 + 1;
            bArr[i19] = (byte) this.f568F;
            int i21 = i20 + 1;
            bArr[i20] = (byte) this.f569G;
            int i22 = i21 + 1;
            bArr[i21] = (byte) this.f570H;
            int i23 = i22 + 1;
            bArr[i22] = (byte) this.f571I;
            int i24 = i23 + 1;
            bArr[i23] = (byte) this.f572J;
            int i25 = i24 + 1;
            bArr[i24] = (byte) this.f573K;
            int i26 = i25 + 1;
            bArr[i25] = (byte) this.f574L;
            int i27 = i26 + 1;
            bArr[i26] = (byte) this.f575M;
            while (i27 < bArr.length) {
                int i28 = i27 + 1;
                bArr[i27] = 0;
                i27 = i28;
            }
            randomAccessFile.write(bArr);
            return true;
        } catch (IOException e) {
            Log.e("SAMMLibraryCore", "Write AMS Header Error : IOException : " + e);
            e.printStackTrace();
            return false;
        }
    }
}
