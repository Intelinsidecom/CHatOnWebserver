package com.samsung.sdraw;

import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.TreeMap;

/* renamed from: com.samsung.sdraw.br */
/* loaded from: classes.dex */
class C1032br {

    /* renamed from: f */
    private static /* synthetic */ int[] f1584f;

    /* renamed from: a */
    public TreeMap<Float, Integer> f1585a;

    /* renamed from: b */
    public TreeMap<Float, Integer> f1586b;

    /* renamed from: c */
    private StrokeSprite f1587c;

    /* renamed from: d */
    private StrokeSprite.ThicknessParameter f1588d;

    /* renamed from: e */
    private float f1589e;

    C1032br() {
    }

    /* renamed from: a */
    static /* synthetic */ int[] m1430a() {
        int[] iArr = f1584f;
        if (iArr == null) {
            iArr = new int[StrokeSprite.ThicknessParameter.valuesCustom().length];
            try {
                iArr[StrokeSprite.ThicknessParameter.Constant.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StrokeSprite.ThicknessParameter.Pressure.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[StrokeSprite.ThicknessParameter.Speed.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[StrokeSprite.ThicknessParameter.SpeedAndPressure.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f1584f = iArr;
        }
        return iArr;
    }

    /* renamed from: a */
    public void m1432a(StrokeSprite strokeSprite) {
        this.f1587c = strokeSprite;
        this.f1588d = strokeSprite.m1162g();
        this.f1589e = strokeSprite.m1153c().getStrokeWidth();
        if (strokeSprite.m1150b()) {
            if (this.f1585a == null) {
                this.f1585a = new TreeMap<>();
            }
            if (this.f1586b == null) {
                this.f1586b = new TreeMap<>();
            }
        }
    }

    /* renamed from: a */
    public float m1431a(float f, float f2, long j, float f3) {
        return m1428a(m1429a(f, f2, j), m1426a(f3), f, f2);
    }

    /* renamed from: a */
    private float m1427a(float f, float f2) {
        switch (m1430a()[this.f1588d.ordinal()]) {
            case 1:
                f2 = 1.0f;
                break;
            case 2:
                f2 = f;
                break;
            case 3:
                break;
            case 4:
                if (this.f1587c.getType() != StrokeSprite.Type.Zenbrush) {
                    f2 = (f + f2) / 2.0f;
                    break;
                } else if (f >= 0.35d) {
                    if (f < 0.7d) {
                        f2 = ((0.5f * f) + (1.5f * f2)) / 2.0f;
                        break;
                    } else {
                        f2 = (f + f2) / 2.0f;
                        break;
                    }
                }
                break;
            default:
                f2 = 0.0f;
                break;
        }
        return this.f1589e * f2;
    }

    /* renamed from: a */
    private float m1428a(float f, float f2, float f3, float f4) {
        float fSqrt;
        float fM1427a;
        float f5 = 0.5f;
        if (this.f1587c.m1158e().size() == 0) {
            if (f2 > (this.f1587c.m1168m()[1] * 0.6f) + (this.f1587c.m1168m()[2] * 0.4f)) {
                f5 = 0.6f;
            } else if (this.f1587c.getType() != StrokeSprite.Type.Brush) {
                f2 = 0.5f;
            } else {
                f2 = 0.4f;
                f5 = 0.4f;
            }
            fM1427a = m1427a(f5, f2);
        } else {
            if (this.f1587c.getType() != StrokeSprite.Type.Zenbrush) {
                fSqrt = 1.0f;
            } else {
                fSqrt = ((float) Math.sqrt((f3 * f3) + (f4 * f4))) / 10.0f;
                if (fSqrt > 20.0f) {
                    fSqrt = 20.0f;
                }
            }
            float fM1163h = this.f1587c.m1163h();
            float fM1427a2 = (m1427a(f, f2) + fM1163h) / 2.0f;
            if (Math.abs(fM1163h - fM1427a2) > fSqrt) {
                fM1427a = (fSqrt * (fM1163h > fM1427a2 ? -1 : 1)) + fM1163h;
            } else {
                fM1427a = (fM1163h <= fM1427a2 || fM1163h >= fSqrt) ? fM1427a2 : (-0.5f) + fM1163h;
            }
        }
        return Math.max(Math.max(1.0f, this.f1587c.m1153c().getStrokeWidth() / 10.0f), fM1427a);
    }

    /* renamed from: a */
    private float m1429a(float f, float f2, long j) {
        float f3;
        if (f == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && f2 == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return 0.1f;
        }
        float[] fArrM1167l = this.f1587c.m1167l();
        float f4 = fArrM1167l[0];
        float f5 = fArrM1167l[1];
        float f6 = fArrM1167l[2];
        float f7 = fArrM1167l[3];
        float fMax = (float) Math.max(f4, Math.min(Math.sqrt((f * f) + (f2 * f2)), f7));
        if (this.f1587c.getType() == StrokeSprite.Type.Zenbrush) {
            if (fMax < f5) {
                f3 = 1.0f;
            } else if (fMax < f6) {
                f3 = 0.6f;
            } else {
                f3 = (0.5f - (((fMax - f6) / (f7 - f6)) * 0.5f)) + 0.1f;
            }
        } else if (fMax < f5 || fMax < f6) {
            f3 = 1.0f;
        } else {
            f3 = (0.8f - (((fMax - f6) / (f7 - f6)) * 0.8f)) + 0.2f;
        }
        if (this.f1587c.m1150b() && this.f1585a != null) {
            int iIntValue = 0;
            float f8 = ((int) (100.0f * fMax)) / 100.0f;
            if (this.f1585a.containsKey(Float.valueOf(f8))) {
                iIntValue = this.f1585a.get(Float.valueOf(f8)).intValue();
            }
            this.f1585a.put(Float.valueOf(f8), Integer.valueOf(iIntValue + 1));
        }
        this.f1587c.f1316e = f3;
        return f3;
    }

    /* renamed from: a */
    private float m1426a(float f) {
        float f2;
        if (f == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return 0.1f;
        }
        if (this.f1587c.m1160f() == StrokeSprite.InputMethod.Hand) {
            if (this.f1587c.getType() == StrokeSprite.Type.Brush) {
                return 1.2f;
            }
            return this.f1587c.getType() == StrokeSprite.Type.Zenbrush ? 0.9f : 1.0f;
        }
        float[] fArrM1168m = this.f1587c.m1168m();
        float f3 = fArrM1168m[0];
        float f4 = fArrM1168m[1];
        float f5 = fArrM1168m[2];
        float f6 = fArrM1168m[3];
        float fMax = Math.max(f3, Math.min(f6, f));
        if (this.f1587c.getType() == StrokeSprite.Type.Brush) {
            if (fMax < f4) {
                f2 = 0.6f + (((fMax - f3) / (f4 - f3)) * 0.3f);
            } else if (fMax < f5) {
                f2 = 0.9f + (0.1f * ((fMax - f4) / (f5 - f4)));
            } else {
                f2 = (((fMax - f5) / (f6 - f5)) * 0.3f) + 1.0f;
            }
        } else if (this.f1587c.getType() == StrokeSprite.Type.Zenbrush) {
            if (fMax < f4) {
                f2 = 0.05f + (((fMax - f3) / (f4 - f3)) * 0.7f);
            } else if (fMax < f5) {
                f2 = 0.8f + (((fMax - f4) / (f5 - f4)) * 0.3f);
            } else {
                f2 = (((fMax - f5) / (f6 - f5)) * 0.3f) + 1.0f;
            }
        } else if (fMax < f4) {
            f2 = (((fMax - f3) / (f4 - f3)) * 0.5f) + 0.1f;
        } else if (fMax < f5) {
            f2 = 0.9f + (0.1f * ((fMax - f4) / (f5 - f4)));
        } else {
            f2 = (((fMax - f5) / (f6 - f5)) * 0.2f) + 1.0f;
        }
        if (this.f1587c.m1150b() && this.f1586b != null) {
            int iIntValue = 0;
            float f7 = ((int) (fMax * 100.0f)) / 100.0f;
            if (this.f1586b.containsKey(Float.valueOf(f7))) {
                iIntValue = this.f1586b.get(Float.valueOf(f7)).intValue();
            }
            this.f1586b.put(Float.valueOf(f7), Integer.valueOf(iIntValue + 1));
            return f2;
        }
        return f2;
    }
}
