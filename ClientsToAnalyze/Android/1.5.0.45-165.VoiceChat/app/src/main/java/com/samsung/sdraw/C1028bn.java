package com.samsung.sdraw;

import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.bn */
/* loaded from: classes.dex */
class C1028bn {

    /* renamed from: b */
    protected Vector<C1043cb> f1576b;

    /* renamed from: c */
    protected Vector<C1053i> f1577c;

    /* renamed from: d */
    protected StrokeSprite f1578d;

    /* renamed from: e */
    protected C1032br f1579e;

    C1028bn() {
    }

    /* renamed from: a */
    public static float m1410a(float f, float f2, float f3) {
        return ((1.0f - f) * f2) + (f3 * f);
    }

    /* renamed from: b */
    public static float m1412b(float f, float f2, float f3) {
        double dCos = (1.0d - Math.cos(f * 3.141592653589793d)) * 0.5d;
        return (float) ((dCos * f3) + (f2 * (1.0d - dCos)));
    }

    /* renamed from: a */
    public static float m1411a(float f, float f2, float f3, float f4, float f5) {
        float f6 = f * f;
        float f7 = f6 * f;
        return (((((((f6 * 3.0f) + ((-3.0f) * f7)) + (3.0f * f)) + 1.0f) * f4) + ((((((-f7) + (3.0f * f6)) - (3.0f * f)) + 1.0f) * f2) + ((((3.0f * f7) - (6.0f * f6)) + 4.0f) * f3))) + (f7 * f5)) / 6.0f;
    }

    /* renamed from: a */
    public void m1414a(StrokeSprite strokeSprite, C1032br c1032br) {
        this.f1578d = strokeSprite;
        this.f1579e = c1032br;
        this.f1576b = strokeSprite.m1156d();
        this.f1577c = strokeSprite.m1158e();
    }

    /* renamed from: a */
    protected void m1413a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        int iMo1364a = mo1364a(f, f2, f3, f5, f6, f7);
        for (int i = 0; i <= iMo1364a; i++) {
            float f9 = i / iMo1364a;
            float fM1412b = m1412b(f9, f, f5);
            float fM1412b2 = m1412b(f9, f2, f6);
            float fM1412b3 = m1412b(f9, f3, f7);
            float fM1412b4 = m1412b(f9, f4, f8);
            C1043cb c1043cb = new C1043cb(fM1412b, fM1412b2, fM1412b3);
            c1043cb.f1689i = fM1412b4;
            c1043cb.m1523a(f5 - f, f6 - f2, fM1412b3, true);
            m1415a(c1043cb);
            this.f1576b.add(c1043cb);
        }
    }

    /* renamed from: a */
    protected void mo1365a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        int iMo1364a = mo1364a(f5, f6, f7, f9, f10, f11);
        for (int i = 1; i <= iMo1364a; i++) {
            float f17 = i / iMo1364a;
            float fM1411a = m1411a(f17, f, f5, f9, f13);
            float fM1411a2 = m1411a(f17, f2, f6, f10, f14);
            float fM1411a3 = m1411a(f17, f3, f7, f11, f15);
            float fM1411a4 = m1411a(f17, f4, f8, f12, f16);
            C1043cb c1043cb = new C1043cb(fM1411a, fM1411a2, fM1411a3);
            c1043cb.f1689i = fM1411a4;
            c1043cb.m1523a(f9 - f5, f10 - f6, fM1411a3, true);
            m1415a(c1043cb);
            this.f1576b.add(c1043cb);
        }
    }

    /* renamed from: b */
    protected void mo1417b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        int iMo1364a = mo1364a(f5, f6, f7, f9, f10, f11);
        for (int i = 1; i <= iMo1364a; i++) {
            float f17 = i / iMo1364a;
            float fM1411a = m1411a(f17, f, f5, f9, f13);
            float fM1411a2 = m1411a(f17, f2, f6, f10, f14);
            float fM1411a3 = m1411a(f17, f3, f7, f11, f15);
            float fM1411a4 = m1411a(f17, f4, f8, f12, f16);
            C1043cb c1043cb = new C1043cb(fM1411a, fM1411a2, fM1411a3);
            c1043cb.f1689i = fM1411a4;
            c1043cb.m1523a(f9 - f5, f10 - f6, fM1411a3, true);
            m1415a(c1043cb);
            this.f1576b.add(c1043cb);
        }
    }

    /* renamed from: a */
    protected void m1415a(C1043cb c1043cb) {
        if (!this.f1576b.isEmpty()) {
            C1043cb c1043cbLastElement = this.f1576b.lastElement();
            c1043cbLastElement.m1522a(c1043cb.x, c1043cb.y, c1043cbLastElement.f1688h);
        }
    }

    /* renamed from: a */
    protected int mo1364a(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.f1578d.getType() == StrokeSprite.Type.Hightlighter) {
            return this.f1578d.m1160f() == StrokeSprite.InputMethod.Hand ? 32 : 16;
        }
        if (this.f1578d.m1160f() == StrokeSprite.InputMethod.Hand) {
            return (int) Math.max(4.0f, ((float) Math.log(Math.abs(f4 - f) + Math.abs(f5 - f2))) * 10.0f);
        }
        return 4;
    }

    /* renamed from: a */
    public boolean m1416a() {
        int size = this.f1577c.size();
        if (size <= 3) {
            return false;
        }
        C1053i c1053i = this.f1577c.get(size - 4);
        C1053i c1053i2 = this.f1577c.get(size - 3);
        C1053i c1053i3 = this.f1577c.get(size - 2);
        C1053i c1053i4 = this.f1577c.get(size - 1);
        mo1365a(c1053i.f1744a, c1053i.f1745b, c1053i.f1746c, c1053i.f1747d, c1053i2.f1744a, c1053i2.f1745b, c1053i2.f1746c, c1053i2.f1747d, c1053i3.f1744a, c1053i3.f1745b, c1053i3.f1746c, c1053i3.f1747d, c1053i4.f1744a, c1053i4.f1745b, c1053i4.f1746c, c1053i4.f1747d);
        return true;
    }

    /* renamed from: b */
    public boolean m1418b() {
        int size = this.f1577c.size();
        if (size <= 3) {
            return false;
        }
        C1053i c1053i = this.f1577c.get(size - 4);
        C1053i c1053i2 = this.f1577c.get(size - 3);
        C1053i c1053i3 = this.f1577c.get(size - 2);
        C1053i c1053i4 = this.f1577c.get(size - 1);
        mo1417b(c1053i.f1744a, c1053i.f1745b, c1053i.f1746c, c1053i.f1747d, c1053i2.f1744a, c1053i2.f1745b, c1053i2.f1746c, c1053i2.f1747d, c1053i3.f1744a, c1053i3.f1745b, c1053i3.f1746c, c1053i3.f1747d, c1053i4.f1744a, c1053i4.f1745b, c1053i4.f1746c, c1053i4.f1747d);
        return true;
    }

    /* renamed from: c */
    public void m1419c() {
        int size = this.f1577c.size();
        if (size >= 2) {
            if (size == 2) {
                int i = 1;
                C1053i c1053i = this.f1577c.get(0);
                while (i < size) {
                    C1053i c1053i2 = this.f1577c.get(i);
                    m1413a(c1053i.f1744a, c1053i.f1745b, c1053i.f1746c, c1053i.f1747d, c1053i2.f1744a, c1053i2.f1745b, c1053i2.f1746c, c1053i2.f1747d);
                    i++;
                    c1053i = c1053i2;
                }
                this.f1577c.add(c1053i);
                return;
            }
            int i2 = 2;
            C1053i c1053i3 = this.f1577c.get(1);
            while (i2 < size) {
                C1053i c1053i4 = this.f1577c.get(i2);
                m1413a(c1053i3.f1744a, c1053i3.f1745b, c1053i3.f1746c, c1053i3.f1747d, c1053i4.f1744a, c1053i4.f1745b, c1053i4.f1746c, c1053i4.f1747d);
                i2++;
                c1053i3 = c1053i4;
            }
        }
    }

    /* renamed from: d */
    public void m1420d() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        if (this.f1578d.m1162g() != StrokeSprite.ThicknessParameter.Constant || this.f1578d.getType() == StrokeSprite.Type.Hightlighter || this.f1578d.getType() == StrokeSprite.Type.Zenbrush) {
            if (this.f1578d.getType() == StrokeSprite.Type.Hightlighter) {
                int size = this.f1577c.size();
                if (size >= 2) {
                    C1053i c1053i = this.f1577c.get(size - 2);
                    C1053i c1053i2 = this.f1577c.get(size - 1);
                    float fAbs = Math.abs(c1053i2.f1744a - c1053i.f1744a);
                    float fAbs2 = Math.abs(c1053i2.f1745b - c1053i.f1745b);
                    float f18 = c1053i2.f1744a - c1053i.f1744a;
                    float f19 = c1053i2.f1745b - c1053i.f1745b;
                    float fMax = Math.max(1.0f, c1053i2.f1746c);
                    float f20 = c1053i2.f1745b - c1053i.f1745b;
                    float f21 = c1053i2.f1744a - c1053i.f1744a;
                    float f22 = (c1053i2.f1744a * c1053i.f1745b) - (c1053i.f1744a * c1053i2.f1745b);
                    if (fAbs > fAbs2) {
                        float f23 = f18 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? -fMax : fMax;
                        f15 = c1053i2.f1744a + f23;
                        f13 = ((f20 * f15) + f22) / f21;
                        f14 = f23;
                    } else {
                        if (f19 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            fMax = -fMax;
                        }
                        f13 = c1053i2.f1745b + fMax;
                        f14 = fMax;
                        f15 = ((f21 * f13) - f22) / f20;
                    }
                    this.f1578d.m1152b(f15, f13, c1053i2.f1747d, c1053i2.f1748e + 1, true);
                    if (fAbs > fAbs2) {
                        f17 = f15 + f14;
                        f16 = ((f20 * f17) + f22) / f21;
                    } else {
                        f16 = f13 + f14;
                        f17 = ((f21 * f16) - f22) / f20;
                    }
                    this.f1578d.m1152b(f17, f16, c1053i2.f1747d, c1053i2.f1748e + 1, true);
                    return;
                }
                return;
            }
            if (this.f1578d.getType() == StrokeSprite.Type.Solid) {
                int size2 = this.f1577c.size();
                if (size2 >= 2) {
                    C1053i c1053i3 = this.f1577c.get(size2 - 2);
                    C1053i c1053i4 = this.f1577c.get(size2 - 1);
                    float f24 = c1053i4.f1744a - c1053i3.f1744a;
                    float f25 = c1053i4.f1745b - c1053i3.f1745b;
                    float fAbs3 = Math.abs(f24);
                    float fAbs4 = Math.abs(f25);
                    float fMax2 = Math.max(1.0f, c1053i4.f1746c / this.f1578d.f1316e);
                    float f26 = (c1053i4.f1744a * c1053i3.f1745b) - (c1053i3.f1744a * c1053i4.f1745b);
                    if (fAbs3 > fAbs4) {
                        f11 = f24 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? -fMax2 : fMax2;
                        f12 = c1053i4.f1744a + f11;
                        f10 = ((f25 * f12) + f26) / f24;
                    } else {
                        if (f25 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            fMax2 = -fMax2;
                        }
                        f10 = c1053i4.f1745b + fMax2;
                        f11 = fMax2;
                        f12 = ((f24 * f10) - f26) / f25;
                    }
                    if (this.f1578d.f1316e >= 1.0f) {
                        this.f1578d.m1152b(f12, f10, c1053i4.f1747d, c1053i4.f1748e + 1, true);
                        return;
                    }
                    while (true) {
                        float f27 = f11;
                        if (fAbs3 > fAbs4) {
                            f12 += f27;
                            f10 = ((f25 * f12) + f26) / f24;
                        } else {
                            f10 += f27;
                            f12 = ((f24 * f10) - f26) / f25;
                        }
                        this.f1578d.m1152b(f12, f10, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053i4.f1748e + 1, true);
                        if (this.f1578d.m1175t()) {
                            this.f1578d.m1161f(false);
                            return;
                        }
                        C1043cb c1043cbLastElement = this.f1578d.m1156d().lastElement();
                        if (Math.abs(c1043cbLastElement.f1685e - c1043cbLastElement.f1683c) != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || Math.abs(c1043cbLastElement.f1686f - c1043cbLastElement.f1684d) != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            f11 = 1.05f * f27;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                if (this.f1578d.getType() == StrokeSprite.Type.Zenbrush) {
                    int size3 = this.f1577c.size();
                    if (size3 >= 2) {
                        C1053i c1053i5 = this.f1577c.get(size3 - 2);
                        C1053i c1053i6 = this.f1577c.get(size3 - 1);
                        float f28 = c1053i6.f1744a - c1053i5.f1744a;
                        float f29 = c1053i6.f1745b - c1053i5.f1745b;
                        float fAbs5 = Math.abs(f28);
                        float fAbs6 = Math.abs(f29);
                        float fMax3 = Math.max(1.0f, (c1053i6.f1746c / this.f1578d.f1316e) / 2.0f);
                        float f30 = (c1053i6.f1744a * c1053i5.f1745b) - (c1053i5.f1744a * c1053i6.f1745b);
                        if (fAbs5 > fAbs6) {
                            float f31 = (fAbs5 <= 5.0f || fAbs5 >= 15.0f) ? fMax3 : fMax3 * 4.0f;
                            if (f28 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                f31 = -f31;
                            }
                            f4 = c1053i6.f1744a + (f31 / 2.0f);
                            f3 = ((f29 * f4) + f30) / f28;
                            f5 = f31;
                        } else {
                            float f32 = (fAbs6 <= 5.0f || fAbs6 >= 15.0f) ? fMax3 : 4.0f * fMax3;
                            if (f29 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                f32 = -f32;
                            }
                            f3 = (f32 / 2.0f) + c1053i6.f1745b;
                            f4 = ((f28 * f3) - f30) / f29;
                            f5 = f32;
                        }
                        this.f1578d.m1146a(f4, f3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053i6.f1748e + 1, true);
                        if (fAbs5 > fAbs6) {
                            f7 = f4 + (f5 / 2.0f);
                            f6 = ((f29 * f7) + f30) / f28;
                        } else {
                            f6 = f3 + (f5 / 2.0f);
                            f7 = ((f28 * f6) - f30) / f29;
                        }
                        this.f1578d.m1146a(f7, f6, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053i6.f1748e + 1, true);
                        if (fAbs5 > fAbs6) {
                            f9 = f7 + f5;
                            f8 = ((f29 * f9) + f30) / f28;
                        } else {
                            f8 = f6 + f5;
                            f9 = ((f28 * f8) - f30) / f29;
                        }
                        this.f1578d.m1146a(f9, f8, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053i6.f1748e + 1, true);
                        C0993af.m1275a("SAMSUNG/SDraw", String.format("%f, %f", Float.valueOf(c1053i6.f1744a), Float.valueOf(c1053i6.f1745b)));
                        return;
                    }
                    return;
                }
                int size4 = this.f1577c.size();
                if (size4 >= 2) {
                    C1053i c1053i7 = this.f1577c.get(size4 - 2);
                    C1053i c1053i8 = this.f1577c.get(size4 - 1);
                    float f33 = c1053i8.f1744a - c1053i7.f1744a;
                    float f34 = c1053i8.f1745b - c1053i7.f1745b;
                    float fAbs7 = Math.abs(f33);
                    float fAbs8 = Math.abs(f34);
                    float fMax4 = Math.max(1.0f, c1053i8.f1746c / this.f1578d.f1316e);
                    float f35 = (c1053i8.f1744a * c1053i7.f1745b) - (c1053i7.f1744a * c1053i8.f1745b);
                    if (fAbs7 > fAbs8) {
                        f2 = c1053i8.f1744a + (f33 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? -fMax4 : fMax4);
                        f = ((f34 * f2) + f35) / f33;
                    } else {
                        if (f34 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            fMax4 = -fMax4;
                        }
                        f = c1053i8.f1745b + fMax4;
                        f2 = ((f33 * f) - f35) / f34;
                    }
                    this.f1578d.m1152b(f2, f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053i8.f1748e + 1, true);
                }
            }
        }
    }
}
