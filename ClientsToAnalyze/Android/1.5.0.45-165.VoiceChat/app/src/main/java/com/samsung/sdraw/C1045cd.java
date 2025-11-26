package com.samsung.sdraw;

import com.samsung.sdraw.StrokeSprite;

/* renamed from: com.samsung.sdraw.cd */
/* loaded from: classes.dex */
class C1045cd extends C1028bn {

    /* renamed from: a */
    protected static final float[] f1704a = {1.0f, 1.0f, 0.5f, 0.5f, 0.7f, 0.45f, 0.4f, 0.4f, 0.4f, 0.38f, 0.38f, 0.37f, 0.35f, 0.35f, 0.34f, 0.32f, 0.32f, 0.3f, 0.3f, 0.3f, 0.29f, 0.29f, 0.29f, 0.29f, 0.29f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.26f, 0.26f, 0.25f, 0.25f, 0.25f, 0.24f, 0.24f, 0.24f, 0.24f, 0.24f, 0.24f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.22f, 0.22f, 0.21f, 0.21f, 0.21f, 0.21f, 0.21f, 0.2f, 0.2f, 0.2f, 0.2f, 0.19f, 0.19f, 0.18f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.16f, 0.16f, 0.26f, 0.26f, 0.26f, 0.26f, 0.25f, 0.25f, 0.24f, 0.24f, 0.24f, 0.24f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f};

    /* renamed from: f */
    protected static final float[] f1705f = {0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.28f, 0.28f, 0.27f, 0.25f, 0.25f, 0.24f, 0.32f, 0.32f, 0.3f, 0.3f, 0.3f, 0.29f, 0.29f, 0.29f, 0.29f, 0.29f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.27f, 0.26f, 0.26f, 0.25f, 0.25f, 0.25f, 0.24f, 0.24f, 0.24f, 0.24f, 0.24f, 0.24f, 0.23f, 0.23f, 0.23f, 0.23f, 0.23f, 0.22f, 0.22f, 0.21f, 0.21f, 0.21f, 0.21f, 0.21f, 0.2f, 0.2f, 0.2f, 0.2f, 0.19f, 0.19f, 0.18f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f, 0.16f, 0.16f, 0.16f, 0.16f, 0.16f, 0.16f, 0.15f, 0.15f, 0.14f, 0.14f, 0.14f, 0.14f, 0.14f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f, 0.13f};

    @Override // com.samsung.sdraw.C1028bn
    /* renamed from: a */
    protected int mo1364a(float f, float f2, float f3, float f4, float f5, float f6) {
        float fAbs = Math.abs(f4 - f);
        float fAbs2 = Math.abs(f5 - f2);
        int iMin = Math.min(Math.max(1, (int) Math.floor(f6 * 2.0f)), f1704a.length);
        float f7 = f1704a[iMin - 1];
        if (this.f1578d.m1160f() == StrokeSprite.InputMethod.Hand && iMin <= 15) {
            f7 *= 2.0f;
        }
        return (int) Math.max(2.0d, Math.sqrt((fAbs * fAbs) + (fAbs2 * fAbs2)) * f7);
    }

    /* renamed from: b */
    protected int m1534b(float f, float f2, float f3, float f4, float f5, float f6) {
        float fAbs = Math.abs(f4 - f);
        float fAbs2 = Math.abs(f5 - f2);
        return (int) Math.max(2.0d, Math.sqrt((fAbs * fAbs) + (fAbs2 * fAbs2)) * f1705f[Math.min(Math.max(1, (int) Math.floor(2.0f * f6)), f1704a.length) - 1]);
    }

    @Override // com.samsung.sdraw.C1028bn
    /* renamed from: a */
    protected void mo1365a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        int iMo1364a = mo1364a(f5, f6, f7, f9, f10, f11);
        for (int i = 1; i <= iMo1364a; i++) {
            float f17 = i / iMo1364a;
            float fA = m1411a(f17, f, f5, f9, f13);
            float fA2 = m1411a(f17, f2, f6, f10, f14);
            float fA3 = m1411a(f17, f3, f7, f11, f15);
            float fA4 = m1411a(f17, f4, f8, f12, f16);
            C1043cb c1043cb = new C1043cb(fA, fA2, fA3);
            c1043cb.f1688h = fA3;
            c1043cb.f1689i = fA4;
            this.f1576b.add(c1043cb);
        }
    }

    @Override // com.samsung.sdraw.C1028bn
    /* renamed from: b */
    protected void mo1417b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        int iM1534b = m1534b(f5, f6, f7, f9, f10, f11);
        if (this.f1578d.m1160f() == StrokeSprite.InputMethod.Hand && iM1534b < 30) {
            iM1534b = 30;
        }
        for (int i = 1; i <= iM1534b; i++) {
            float f17 = i / iM1534b;
            float fA = m1411a(f17, f, f5, f9, f13);
            float fA2 = m1411a(f17, f2, f6, f10, f14);
            float fA3 = m1411a(f17, f3, f7, f11, f15);
            float fA4 = m1411a(f17, f4, f8, f12, f16);
            C1043cb c1043cb = new C1043cb(fA, fA2, fA3);
            c1043cb.f1688h = fA3;
            c1043cb.f1689i = fA4;
            this.f1576b.add(c1043cb);
        }
    }
}
