package com.samsung.spen.engine.signature;

import android.graphics.PointF;
import android.util.Log;
import java.io.File;

/* renamed from: com.samsung.spen.engine.signature.a */
/* loaded from: classes.dex */
public class C1100a implements InterfaceC1101b {

    /* renamed from: a */
    private int[] f2019a = null;

    /* renamed from: b */
    private int[] f2020b = null;

    /* renamed from: c */
    private char[] f2021c = null;

    /* renamed from: d */
    private String f2022d = "/data/data/com.samsung.spensdk.example.hsv/data/";

    /* renamed from: e */
    private int f2023e = 1024;

    /* renamed from: f */
    private int f2024f = 3;

    /* renamed from: g */
    private int f2025g = 500;

    /* renamed from: h */
    private int f2026h = 10;

    /* renamed from: i */
    private int f2027i = 200;

    /* renamed from: j */
    private HSVJniLib f2028j = null;

    /* renamed from: k */
    private short f2029k = 0;

    /* renamed from: l */
    private int f2030l = 0;

    /* renamed from: m */
    private short f2031m = 0;

    /* renamed from: a */
    public void m1981a(String str, int i, int i2, int i3, int i4) {
        this.f2022d = str;
        this.f2023e = i;
        this.f2024f = i2;
        this.f2025g = 500;
        this.f2026h = i3;
        this.f2027i = i4;
        if (m1978a(this.f2022d)) {
        }
        this.f2019a = new int[this.f2023e * 2];
        this.f2020b = new int[this.f2023e];
        this.f2021c = new char[this.f2023e];
        try {
            this.f2028j = new HSVJniLib();
            this.f2028j.jni_HSVInit(this.f2022d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f2028j != null) {
            this.f2028j.jni_HSVDelUser(this.f2026h);
        }
    }

    /* renamed from: a */
    private boolean m1978a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    /* renamed from: b */
    private boolean m1979b(String str) {
        File file = new File(String.valueOf(str) + "SPenHSVreg00.dat");
        File file2 = new File(String.valueOf(str) + "SPenHSVreg01.dat");
        File file3 = new File(String.valueOf(str) + "SPenHSVreg02.dat");
        if (file.exists() && !file.delete()) {
            return false;
        }
        if (!file2.exists() || file2.delete()) {
            return !file3.exists() || file3.delete();
        }
        return false;
    }

    /* renamed from: c */
    private boolean m1980c(String str) {
        return new File(new StringBuilder(String.valueOf(str)).append("SPenHSVreg00.dat").toString()).exists() && new File(new StringBuilder(String.valueOf(str)).append("SPenHSVreg01.dat").toString()).exists() && new File(new StringBuilder(String.valueOf(str)).append("SPenHSVreg02.dat").toString()).exists();
    }

    /* renamed from: a */
    public boolean m1984a(int i) {
        return i == 10 && m1980c(this.f2022d);
    }

    /* renamed from: b */
    public boolean m1987b(int i) {
        return m1984a(i) && m1979b(this.f2022d);
    }

    /* renamed from: a */
    public void m1982a(PointF[] pointFArr, long[] jArr) {
        if (this.f2029k + jArr.length >= this.f2023e) {
            this.f2029k = (short) this.f2023e;
            return;
        }
        for (int i = 0; i < jArr.length; i++) {
            this.f2019a[(this.f2029k * 2) + (i * 2)] = (int) (pointFArr[i].x + 0.5f);
            this.f2019a[(this.f2029k * 2) + (i * 2) + 1] = (int) (pointFArr[i].y + 0.5f);
            this.f2020b[this.f2029k + i] = (int) jArr[i];
            if (i == 0) {
                this.f2021c[this.f2029k + i] = 0;
            } else {
                this.f2021c[this.f2029k + i] = 1;
            }
        }
        this.f2029k = (short) (this.f2029k + jArr.length);
    }

    /* renamed from: c */
    public int m1988c(int i) {
        if (this.f2030l == 0) {
            this.f2028j.jni_HSVDelUser(this.f2026h);
        }
        if (this.f2028j.jni_HSVCheckSignature(this.f2019a, this.f2020b, this.f2021c, this.f2029k, this.f2030l, this.f2026h, this.f2027i) != 0) {
            m1983a();
            return -1;
        }
        if (this.f2030l == this.f2024f - 1) {
            this.f2028j.jni_HSVAddSignatureModel(this.f2019a, this.f2020b, this.f2021c, this.f2029k, this.f2030l, this.f2026h);
            this.f2030l = 0;
            m1983a();
            return this.f2024f;
        }
        if (this.f2030l == 0) {
            if (!m1979b(this.f2022d)) {
                return -1;
            }
            if (m1978a(this.f2022d)) {
                Log.i("Signature", "make folder success");
            } else {
                Log.i("Signature", "make folder failure or existed");
            }
            this.f2028j.jni_HSVAddSignatureModel(this.f2019a, this.f2020b, this.f2021c, this.f2029k, this.f2030l, this.f2026h);
            this.f2030l++;
            m1983a();
            return this.f2030l;
        }
        this.f2028j.jni_HSVAddSignatureModel(this.f2019a, this.f2020b, this.f2021c, this.f2029k, this.f2030l, this.f2026h);
        this.f2030l++;
        m1983a();
        return this.f2030l;
    }

    /* renamed from: a */
    public boolean m1985a(int i, int i2) {
        if (m1984a(i)) {
            this.f2028j.jni_HSVDelUser(this.f2026h);
            this.f2028j.jni_HSVLoadSignatureModel();
            this.f2031m = this.f2028j.jni_HSVVerify(this.f2019a, this.f2020b, this.f2021c, this.f2029k, this.f2026h, this.f2025g);
            if (this.f2031m >= this.f2025g) {
                m1989d(i);
                return true;
            }
            m1989d(i);
            return false;
        }
        m1989d(i);
        return false;
    }

    /* renamed from: a */
    public boolean m1983a() {
        this.f2029k = (short) 0;
        return true;
    }

    /* renamed from: d */
    public boolean m1989d(int i) {
        m1983a();
        if (this.f2028j == null) {
            return false;
        }
        if (!m1984a(i)) {
            m1983a();
            this.f2028j.jni_HSVDelUser(this.f2026h);
            this.f2028j.jni_HSVClose();
            this.f2028j = null;
            this.f2030l = 0;
            if (!m1979b(this.f2022d)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.spen.engine.signature.InterfaceC1101b
    /* renamed from: b */
    public void mo1986b(PointF[] pointFArr, long[] jArr) {
        m1982a(pointFArr, jArr);
    }
}
