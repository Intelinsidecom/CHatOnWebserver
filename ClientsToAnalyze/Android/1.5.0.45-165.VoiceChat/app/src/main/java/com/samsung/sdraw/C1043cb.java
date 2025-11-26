package com.samsung.sdraw;

import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.cb */
/* loaded from: classes.dex */
class C1043cb extends PointF {

    /* renamed from: a */
    public float f1681a;

    /* renamed from: b */
    public float f1682b;

    /* renamed from: c */
    public float f1683c;

    /* renamed from: d */
    public float f1684d;

    /* renamed from: e */
    public float f1685e;

    /* renamed from: f */
    public float f1686f;

    /* renamed from: g */
    public float f1687g;

    /* renamed from: h */
    public float f1688h;

    /* renamed from: i */
    public float f1689i;

    public C1043cb(float f, float f2, float f3) {
        this.f1681a = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.f1682b = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.f1688h = 1.0f;
        this.f1689i = 1.0f;
        set(f, f2);
        this.f1687g = f3;
    }

    public C1043cb(C1043cb c1043cb) {
        this(c1043cb.x, c1043cb.y, c1043cb.f1687g);
        this.f1681a = c1043cb.f1681a;
        this.f1682b = c1043cb.f1682b;
        this.f1683c = c1043cb.f1683c;
        this.f1684d = c1043cb.f1684d;
        this.f1685e = c1043cb.f1685e;
        this.f1686f = c1043cb.f1686f;
        this.f1688h = c1043cb.f1688h;
        this.f1689i = c1043cb.f1689i;
    }

    /* renamed from: b */
    private void m1520b(float f, float f2, float f3) {
        this.f1681a = f;
        this.f1682b = f2;
        this.f1688h = f3;
    }

    /* renamed from: a */
    public void m1522a(float f, float f2, float f3) {
        m1523a(f - this.x, f2 - this.y, f3, true);
    }

    /* renamed from: a */
    public void m1523a(float f, float f2, float f3, boolean z) {
        if (z) {
            float f4 = -f;
            f = f2;
            f2 = f4;
        }
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        if (Math.abs(fSqrt) >= 1.2357884E-4f) {
            float f5 = f3 / fSqrt;
            m1520b(f * f5, f5 * f2, f3);
            m1519a();
        }
    }

    /* renamed from: a */
    private void m1519a() {
        this.f1683c = this.x + this.f1681a;
        this.f1684d = this.y + this.f1682b;
        this.f1685e = this.x - this.f1681a;
        this.f1686f = this.y - this.f1682b;
    }

    /* renamed from: a */
    public PointF m1521a(C1043cb c1043cb, float f) {
        float f2 = c1043cb.x - this.x;
        float f3 = c1043cb.y - this.y;
        PointF pointF = new PointF();
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
        if (Math.abs(fSqrt) >= 1.2357884E-4f) {
            float f4 = f / fSqrt;
            pointF.set((f2 * f4) + this.x, (f3 * f4) + this.y);
        }
        return pointF;
    }
}
