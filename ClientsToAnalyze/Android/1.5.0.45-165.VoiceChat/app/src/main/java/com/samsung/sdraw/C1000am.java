package com.samsung.sdraw;

import com.samsung.sdraw.StrokeSprite;

/* renamed from: com.samsung.sdraw.am */
/* loaded from: classes.dex */
class C1000am extends C1028bn {

    /* renamed from: a */
    protected static final float[] f1513a = {8.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f */
    private C0995ah f1514f = new C0995ah();

    @Override // com.samsung.sdraw.C1028bn
    /* renamed from: a */
    protected int mo1364a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) Math.max(1.0f, Math.max(Math.abs(f6 - f3), (this.f1578d.m1160f() != StrokeSprite.InputMethod.Hand ? 1.0f : 2.0f) * f1513a[Math.min(Math.max(1, (int) Math.ceil(f6 * 2.0f)), f1513a.length) - 1] * ((float) Math.log(Math.abs(f4 - f) + Math.abs(f5 - f2)))));
    }

    @Override // com.samsung.sdraw.C1028bn
    /* renamed from: a */
    protected void mo1365a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        int iMo1364a = mo1364a(f5, f6, f7, f9, f10, f11);
        float f17 = f11 * 0.1f;
        for (int i = 1; i <= iMo1364a; i++) {
            float f18 = i / iMo1364a;
            float fA = m1411a(f18, f, f5, f9, f13) + (this.f1514f.m1279b() * f17);
            float fA2 = m1411a(f18, f2, f6, f10, f14) + (this.f1514f.m1279b() * f17);
            float fA3 = m1411a(f18, f3, f7, f11, f15);
            float fA4 = m1411a(f18, f4, f8, f12, f16);
            C1043cb c1043cb = new C1043cb(fA, fA2, fA3);
            c1043cb.f1688h = fA3;
            c1043cb.f1689i = fA4;
            this.f1576b.add(c1043cb);
        }
    }
}
