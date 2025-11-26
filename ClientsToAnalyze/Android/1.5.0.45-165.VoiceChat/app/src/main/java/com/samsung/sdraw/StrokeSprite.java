package com.samsung.sdraw;

import android.graphics.Color;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

/* loaded from: classes.dex */
final class StrokeSprite extends AbstractSprite {

    /* renamed from: A */
    private static final C1030bp[] f1310A = {new C1013az(), new C1062r(), new C1068x(), new C1014b(), new C1058n(), new C1048d(), new C1001an(), new C1046ce()};

    /* renamed from: B */
    private float[] f1311B;

    /* renamed from: C */
    private float[] f1312C;

    /* renamed from: d */
    boolean f1315d;

    /* renamed from: g */
    private InterfaceC1033bs f1318g;

    /* renamed from: h */
    private C1028bn f1319h;

    /* renamed from: i */
    private C1032br f1320i;

    /* renamed from: j */
    private Vector<C1053i> f1321j;

    /* renamed from: k */
    private Vector<C1043cb> f1322k;

    /* renamed from: l */
    private int f1323l;

    /* renamed from: m */
    private float f1324m;

    /* renamed from: n */
    private float f1325n;

    /* renamed from: o */
    private float f1326o;

    /* renamed from: p */
    private C1030bp f1327p;

    /* renamed from: q */
    private InputMethod f1328q;

    /* renamed from: r */
    private int f1329r;

    /* renamed from: s */
    private ThicknessParameter f1330s;

    /* renamed from: t */
    private Type f1331t;

    /* renamed from: u */
    private boolean f1332u;

    /* renamed from: v */
    private boolean f1333v;

    /* renamed from: w */
    private String f1334w;

    /* renamed from: x */
    private int f1335x;

    /* renamed from: y */
    private int f1336y;

    /* renamed from: z */
    private boolean f1337z;

    /* renamed from: e */
    float f1316e = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;

    /* renamed from: f */
    Vector<C1007at> f1317f = new Vector<>();

    /* renamed from: D */
    private StrokeInfo f1313D = null;

    /* renamed from: E */
    private boolean f1314E = false;

    StrokeSprite() {
    }

    public enum InputMethod {
        Hand,
        Tablet;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static InputMethod[] valuesCustom() {
            InputMethod[] inputMethodArrValuesCustom = values();
            int length = inputMethodArrValuesCustom.length;
            InputMethod[] inputMethodArr = new InputMethod[length];
            System.arraycopy(inputMethodArrValuesCustom, 0, inputMethodArr, 0, length);
            return inputMethodArr;
        }

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }

        public static InputMethod lookup(String name) {
            for (InputMethod inputMethod : valuesCustom()) {
                if (name.compareToIgnoreCase(inputMethod.name()) == 0) {
                    return inputMethod;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public enum ThicknessParameter {
        Constant,
        Speed,
        Pressure,
        SpeedAndPressure;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ThicknessParameter[] valuesCustom() {
            ThicknessParameter[] thicknessParameterArrValuesCustom = values();
            int length = thicknessParameterArrValuesCustom.length;
            ThicknessParameter[] thicknessParameterArr = new ThicknessParameter[length];
            System.arraycopy(thicknessParameterArrValuesCustom, 0, thicknessParameterArr, 0, length);
            return thicknessParameterArr;
        }

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }

        public static ThicknessParameter lookup(String name) {
            for (ThicknessParameter thicknessParameter : valuesCustom()) {
                if (name.compareToIgnoreCase(thicknessParameter.name()) == 0) {
                    return thicknessParameter;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Type {
        Solid,
        Eraser,
        Hightlighter,
        Blur,
        Emboss,
        Brush,
        Pencil,
        Zenbrush;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }

        public static Type lookup(String name) {
            for (Type type : valuesCustom()) {
                if (name.compareToIgnoreCase(type.name()) == 0) {
                    return type;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    boolean m1150b() {
        return this.f1332u;
    }

    public Type getType() {
        return this.f1331t;
    }

    /* renamed from: c */
    C1030bp m1153c() {
        return this.f1327p;
    }

    /* renamed from: d */
    Vector<C1043cb> m1156d() {
        return this.f1322k;
    }

    /* renamed from: e */
    Vector<C1053i> m1158e() {
        return this.f1321j;
    }

    /* renamed from: f */
    InputMethod m1160f() {
        return this.f1328q;
    }

    /* renamed from: g */
    ThicknessParameter m1162g() {
        return this.f1330s;
    }

    /* renamed from: h */
    float m1163h() {
        return this.f1326o;
    }

    /* renamed from: a */
    boolean m1145a(float f, float f2, float f3, long j) {
        float f4;
        float f5 = ((int) (100.0f * f3)) / 100.0f;
        this.f1317f.add(new C1007at(f, f2, f5 / 255.0f, j, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET));
        if (this.f1333v) {
            return false;
        }
        float f6 = f5 / 255.0f;
        PointF pointF = new PointF(f, f2);
        if (this.f1328q == InputMethod.Hand && f6 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            f6 = getType() == Type.Zenbrush ? this.f1312C[3] : this.f1312C[1];
        }
        int size = this.f1321j.size();
        if (size == 0) {
            this.f1326o = this.f1320i.m1431a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1L, f6);
            this.f1321j.add(new C1053i(pointF, f6, this.f1326o, j));
            m1133a(pointF, this.f1326o);
            this.f1323l = 0;
            this.f1315d = false;
        } else {
            float fAbs = Math.abs(f - this.f1324m);
            float fAbs2 = Math.abs(f2 - this.f1325n);
            float fM1431a = (getType() == Type.Solid && f6 == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) ? 0.0f : this.f1320i.m1431a(fAbs, fAbs2, j - this.f1321j.lastElement().f1748e, f6);
            if (this.f1331t != Type.Hightlighter) {
                f4 = 0.0f;
            } else {
                f4 = size == 2 ? 2.0f * fM1431a : fM1431a;
            }
            float fMax = Math.max(1.0f, f4);
            if (fAbs >= fMax || fAbs2 >= fMax) {
                if (size == 1) {
                    C1053i c1053iFirstElement = this.f1321j.firstElement();
                    this.f1321j.add(0, new C1053i(new PointF((c1053iFirstElement.f1744a - f) + c1053iFirstElement.f1744a, (c1053iFirstElement.f1745b - f2) + c1053iFirstElement.f1745b), c1053iFirstElement.f1747d, c1053iFirstElement.f1746c, c1053iFirstElement.f1748e - 1));
                }
                float f7 = ((float) Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2)))) < 1.5f ? this.f1326o : fM1431a;
                this.f1321j.add(new C1053i(pointF, f6, f7, j));
                boolean zM1416a = this.f1319h.m1416a();
                m1133a(pointF, f7);
                return zM1416a;
            }
        }
        return false;
    }

    /* renamed from: a */
    boolean m1146a(float f, float f2, float f3, long j, boolean z) {
        float fSqrt;
        float f4;
        float f5 = ((int) (100.0f * f3)) / 100.0f;
        if (this.f1317f.size() > 0 && (getType() == Type.Brush || getType() == Type.Zenbrush)) {
            fSqrt = (float) Math.sqrt(((f2 - this.f1317f.lastElement().f1535b) * (f2 - this.f1317f.lastElement().f1535b)) + ((f - this.f1317f.lastElement().f1534a) * (f - this.f1317f.lastElement().f1534a)));
            if (this.f1317f.lastElement().f1538e != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && fSqrt > this.f1317f.lastElement().f1538e * 1.6d) {
                C1007at c1007atLastElement = this.f1317f.lastElement();
                m1152b((c1007atLastElement.f1534a + f) / 2.0f, (c1007atLastElement.f1535b + f2) / 2.0f, f5, (c1007atLastElement.f1537d + j) / 2, true);
                fSqrt /= 2.0f;
            } else if (fSqrt * 1.6d < this.f1317f.lastElement().f1538e) {
                return false;
            }
        } else {
            fSqrt = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (!z) {
            this.f1317f.add(new C1007at(f, f2, f5 / 255.0f, j, fSqrt));
        }
        if (this.f1333v) {
            return false;
        }
        float f6 = f5 / 255.0f;
        PointF pointF = new PointF(f, f2);
        if (this.f1328q == InputMethod.Hand && f6 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            f6 = getType() == Type.Zenbrush ? this.f1312C[3] : this.f1312C[1];
        }
        int size = this.f1321j.size();
        if (size == 0) {
            this.f1326o = this.f1320i.m1431a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1L, f6);
            this.f1321j.add(new C1053i(pointF, f6, this.f1326o, j));
            m1133a(pointF, this.f1326o);
            this.f1323l = 0;
            this.f1315d = false;
        } else {
            float fAbs = Math.abs(f - this.f1324m);
            float fAbs2 = Math.abs(f2 - this.f1325n);
            float fM1431a = f6 == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? 0.0f : this.f1320i.m1431a(fAbs, fAbs2, j - this.f1321j.lastElement().f1748e, f6);
            if (this.f1331t != Type.Hightlighter) {
                f4 = 0.0f;
            } else {
                f4 = size == 2 ? 2.0f * fM1431a : fM1431a;
            }
            float fMax = Math.max(2.0f, f4);
            if (fAbs >= fMax || fAbs2 >= fMax) {
                if (size == 1) {
                    C1053i c1053iFirstElement = this.f1321j.firstElement();
                    this.f1321j.add(0, new C1053i(new PointF((c1053iFirstElement.f1744a - f) + c1053iFirstElement.f1744a, (c1053iFirstElement.f1745b - f2) + c1053iFirstElement.f1745b), c1053iFirstElement.f1747d, c1053iFirstElement.f1746c, c1053iFirstElement.f1748e - 1));
                }
                float f7 = ((float) Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2)))) < 1.5f ? this.f1326o : fM1431a;
                this.f1321j.add(new C1053i(pointF, f6, f7, j));
                boolean zM1418b = this.f1319h.m1418b();
                m1133a(pointF, f7);
                return zM1418b;
            }
        }
        return false;
    }

    /* renamed from: b */
    boolean m1152b(float f, float f2, float f3, long j, boolean z) {
        float f4;
        float f5 = ((int) (100.0f * f3)) / 100.0f;
        if (this.f1321j.size() > 0 && this.f1320i.m1431a(Math.abs(f - this.f1324m), Math.abs(f2 - this.f1325n), j - this.f1321j.lastElement().f1748e, f5) <= m1153c().getStrokeWidth() / 10.0f) {
            this.f1314E = true;
        }
        float fSqrt = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (this.f1331t == Type.Brush || this.f1331t == Type.Zenbrush) {
            if (this.f1317f.size() > 0) {
                C1007at c1007atLastElement = this.f1317f.lastElement();
                fSqrt = (float) Math.sqrt(((f2 - this.f1317f.lastElement().f1535b) * (f2 - this.f1317f.lastElement().f1535b)) + ((f - this.f1317f.lastElement().f1534a) * (f - this.f1317f.lastElement().f1534a)));
                if (this.f1317f.lastElement().f1538e != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && fSqrt > this.f1317f.lastElement().f1538e * 1.6d) {
                    ArrayList arrayList = new ArrayList();
                    float f6 = fSqrt / 2.0f;
                    arrayList.add(Float.valueOf(f6));
                    while (f6 > c1007atLastElement.f1538e * 1.6f) {
                        f6 /= 2.0f;
                        arrayList.add(Float.valueOf(f6));
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        float fFloatValue = ((Float) arrayList.remove(arrayList.size() - 1)).floatValue();
                        m1151b((((f - c1007atLastElement.f1534a) * fFloatValue) / fSqrt) + c1007atLastElement.f1534a, (((f2 - c1007atLastElement.f1535b) * fFloatValue) / fSqrt) + c1007atLastElement.f1535b, f5, c1007atLastElement.f1537d + ((long) ((fFloatValue * (j - c1007atLastElement.f1537d)) / fSqrt)));
                    }
                } else if (fSqrt * 1.6d < this.f1317f.lastElement().f1538e) {
                    return false;
                }
            } else {
                fSqrt = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
        }
        if (!z) {
            this.f1317f.add(new C1007at(f, f2, f5 / 255.0f, j, fSqrt));
        }
        if (this.f1333v) {
            return false;
        }
        float f7 = f5 / 255.0f;
        PointF pointF = new PointF(f, f2);
        if (this.f1328q == InputMethod.Hand && f7 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            f7 = getType() == Type.Zenbrush ? this.f1312C[3] : this.f1312C[1];
        }
        int size2 = this.f1321j.size();
        if (size2 == 0) {
            this.f1326o = this.f1320i.m1431a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1L, f7);
            this.f1321j.add(new C1053i(pointF, f7, this.f1326o, j));
            m1133a(pointF, this.f1326o);
            this.f1323l = 0;
            this.f1315d = false;
        } else {
            float fAbs = Math.abs(f - this.f1324m);
            float fAbs2 = Math.abs(f2 - this.f1325n);
            float fM1431a = (getType() == Type.Solid && f7 == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) ? 0.0f : this.f1320i.m1431a(fAbs, fAbs2, j - this.f1321j.lastElement().f1748e, f7);
            if (this.f1331t != Type.Hightlighter) {
                f4 = 0.0f;
            } else {
                f4 = size2 == 2 ? 2.0f * fM1431a : fM1431a;
            }
            float fMax = Math.max(1.0f, f4);
            if (fAbs >= fMax || fAbs2 >= fMax) {
                if (size2 == 1) {
                    C1053i c1053iFirstElement = this.f1321j.firstElement();
                    this.f1321j.add(0, new C1053i(new PointF((c1053iFirstElement.f1744a - f) + c1053iFirstElement.f1744a, (c1053iFirstElement.f1745b - f2) + c1053iFirstElement.f1745b), c1053iFirstElement.f1747d, c1053iFirstElement.f1746c, c1053iFirstElement.f1748e - 1));
                }
                float f8 = ((float) Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2)))) < 1.5f ? this.f1326o : fM1431a;
                this.f1321j.add(new C1053i(pointF, f7, f8, j));
                boolean zM1416a = this.f1319h.m1416a();
                m1133a(pointF, f8);
                return zM1416a;
            }
        }
        return false;
    }

    @Deprecated
    /* renamed from: b */
    boolean m1151b(float f, float f2, float f3, long j) {
        float f4;
        float f5 = ((int) (100.0f * f3)) / 100.0f;
        if (this.f1321j.size() > 0 && this.f1320i.m1431a(Math.abs(f - this.f1324m), Math.abs(f2 - this.f1325n), j - this.f1321j.lastElement().f1748e, f5) <= m1153c().getStrokeWidth() / 10.0f) {
            this.f1314E = true;
        }
        if ((this.f1331t == Type.Brush || this.f1331t == Type.Zenbrush) && this.f1317f.size() > 0) {
            if (((float) Math.sqrt(((f2 - this.f1317f.lastElement().f1535b) * (f2 - this.f1317f.lastElement().f1535b)) + ((f - this.f1317f.lastElement().f1534a) * (f - this.f1317f.lastElement().f1534a)))) * 1.6d < this.f1317f.lastElement().f1538e) {
                return false;
            }
        }
        if (this.f1333v) {
            return false;
        }
        float f6 = f5 / 255.0f;
        PointF pointF = new PointF(f, f2);
        if (this.f1328q == InputMethod.Hand && f6 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            f6 = getType() == Type.Zenbrush ? this.f1312C[3] : this.f1312C[1];
        }
        int size = this.f1321j.size();
        if (size == 0) {
            this.f1326o = this.f1320i.m1431a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1L, f6);
            this.f1321j.add(new C1053i(pointF, f6, this.f1326o, j));
            m1133a(pointF, this.f1326o);
            this.f1323l = 0;
            this.f1315d = false;
        } else {
            float fAbs = Math.abs(f - this.f1324m);
            float fAbs2 = Math.abs(f2 - this.f1325n);
            float fM1431a = (getType() == Type.Solid && f6 == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) ? 0.0f : this.f1320i.m1431a(fAbs, fAbs2, j - this.f1321j.lastElement().f1748e, f6);
            if (this.f1331t != Type.Hightlighter) {
                f4 = 0.0f;
            } else {
                f4 = size == 2 ? 2.0f * fM1431a : fM1431a;
            }
            float fMax = Math.max(1.0f, f4);
            if (fAbs >= fMax || fAbs2 >= fMax) {
                if (size == 1) {
                    C1053i c1053iFirstElement = this.f1321j.firstElement();
                    this.f1321j.add(0, new C1053i(new PointF((c1053iFirstElement.f1744a - f) + c1053iFirstElement.f1744a, (c1053iFirstElement.f1745b - f2) + c1053iFirstElement.f1745b), c1053iFirstElement.f1747d, c1053iFirstElement.f1746c, c1053iFirstElement.f1748e - 1));
                }
                float f7 = ((float) Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2)))) < 1.5f ? this.f1326o : fM1431a;
                this.f1321j.add(new C1053i(pointF, f6, f7, j));
                boolean zM1416a = this.f1319h.m1416a();
                m1133a(pointF, f7);
                return zM1416a;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1139a(android.graphics.Canvas r7, android.graphics.RectF r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r2 = 0
            boolean r0 = r6.m1171p()
            if (r0 == 0) goto L9d
            android.graphics.RectF r0 = r6.getBounds()
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r0.roundOut(r3)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L70 java.io.IOException -> L80 java.lang.Throwable -> L90
            java.lang.String r0 = r6.f1334w     // Catch: java.io.FileNotFoundException -> L70 java.io.IOException -> L80 java.lang.Throwable -> L90
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L70 java.io.IOException -> L80 java.lang.Throwable -> L90
            int r0 = r6.f1335x     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r2 = r6.f1336y     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r0 = r0 * r2
            int r0 = r0 * 4
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            byte[] r2 = r0.array()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r2 = r1.read(r2)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            byte[] r4 = r0.array()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r4 = r4.length     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            if (r2 == r4) goto L3f
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L3a
        L39:
            return
        L3a:
            r0 = move-exception
            r0.printStackTrace()
            goto L39
        L3f:
            int r2 = r6.f1335x     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r4 = r6.f1336y     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r4, r5)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            if (r2 == 0) goto L65
            r2.copyPixelsFromBuffer(r0)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            r0 = 0
            int r4 = r3.left     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r0 = java.lang.Math.max(r0, r4)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            float r0 = (float) r0     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            r4 = 0
            int r3 = r3.top     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            int r3 = java.lang.Math.max(r4, r3)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            float r3 = (float) r3     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            r4 = 0
            r7.drawBitmap(r2, r0, r3, r4)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
            r2.recycle()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5 java.io.FileNotFoundException -> La7
        L65:
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L39
        L6b:
            r0 = move-exception
            r0.printStackTrace()
            goto L39
        L70:
            r0 = move-exception
            r1 = r2
        L72:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L7b
            goto L39
        L7b:
            r0 = move-exception
            r0.printStackTrace()
            goto L39
        L80:
            r0 = move-exception
            r1 = r2
        L82:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L8b
            goto L39
        L8b:
            r0 = move-exception
            r0.printStackTrace()
            goto L39
        L90:
            r0 = move-exception
            r1 = r2
        L92:
            if (r1 == 0) goto L97
            r1.close()     // Catch: java.io.IOException -> L98
        L97:
            throw r0
        L98:
            r1 = move-exception
            r1.printStackTrace()
            goto L97
        L9d:
            com.samsung.sdraw.bs r0 = r6.f1318g
            r0.mo1376a(r7, r8)
            goto L39
        La3:
            r0 = move-exception
            goto L92
        La5:
            r0 = move-exception
            goto L82
        La7:
            r0 = move-exception
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.StrokeSprite.mo1139a(android.graphics.Canvas, android.graphics.RectF):void");
    }

    /* renamed from: a */
    public RectF m1137a(boolean z) {
        RectF rectFMo1374a;
        if (this.f1322k.isEmpty()) {
            return new RectF();
        }
        int iMax = Math.max(this.f1323l - 1, 0);
        if (this.f1318g instanceof C1012ay) {
            rectFMo1374a = ((C1012ay) this.f1318g).m1400b(iMax, z);
        } else {
            rectFMo1374a = this.f1318g.mo1374a(iMax, z);
        }
        this.f1323l = this.f1322k.size();
        mo1136a();
        return rectFMo1374a;
    }

    /* renamed from: b */
    public RectF m1147b(boolean z) {
        if (this.f1322k.isEmpty()) {
            return new RectF();
        }
        RectF rectFMo1374a = this.f1318g.mo1374a(Math.max(this.f1323l - 1, 0), z);
        this.f1323l = this.f1322k.size();
        mo1136a();
        return rectFMo1374a;
    }

    /* renamed from: u */
    private RectF m1134u() {
        if (this.f1322k.isEmpty()) {
            if (this.f1321j.size() == 1) {
                C1053i c1053iFirstElement = this.f1321j.firstElement();
                this.f1321j.add(new C1053i(new PointF((this.f1331t == Type.Hightlighter ? c1053iFirstElement.f1746c * 1.5f : 1.0f) + c1053iFirstElement.f1744a, c1053iFirstElement.f1745b), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, c1053iFirstElement.f1746c, c1053iFirstElement.f1748e + 1));
            }
            this.f1319h.m1419c();
        } else {
            this.f1319h.m1420d();
        }
        if (this.f1331t == Type.Solid) {
            return m1137a(this.f1321j.size() > 2);
        }
        if (this.f1331t != Type.Hightlighter) {
            return m1147b(this.f1321j.size() > 2);
        }
        return m1147b(true);
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public RectF mo1136a() {
        return this.f831b;
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public void dispose() {
        m1143a(this.f1321j);
        m1143a(this.f1322k);
        m1173r();
        this.f1333v = true;
    }

    /* renamed from: a */
    void m1143a(Vector<?> vector) {
        vector.clear();
        vector.setSize(0);
        vector.trimToSize();
    }

    /* renamed from: i */
    RectF m1164i() {
        if (this.f1318g instanceof C1012ay) {
            m1134u();
            this.f1318g.mo1375a();
            RectF rectF = new RectF(this.f1318g.mo1374a(0, true));
            rectF.union(this.f1318g.mo1374a(-1, false));
            m1143a(this.f1322k);
            return rectF;
        }
        RectF rectF2 = new RectF(m1134u());
        rectF2.union(this.f1318g.mo1374a(-1, false));
        return rectF2;
    }

    /* renamed from: j */
    void m1165j() {
        this.f1321j = new Vector<>();
        this.f1322k = new Vector<>();
        this.f1333v = false;
        this.f1337z = false;
    }

    /* renamed from: a */
    void m1140a(Type type, ThicknessParameter thicknessParameter, InputMethod inputMethod, float f, int i) {
        if (type == Type.Hightlighter) {
            thicknessParameter = ThicknessParameter.Constant;
        }
        this.f1327p = new C1030bp(f1310A[type.ordinal()]);
        this.f1327p.setStrokeWidth(0.5f * f);
        if (type != Type.Eraser) {
            this.f1327p.setColor(i);
        }
        if (type == Type.Hightlighter || type == Type.Brush || type == Type.Zenbrush) {
            this.f1327p.setAlpha(Color.alpha(i));
        } else {
            this.f1327p.setAlpha(255);
        }
        this.f1328q = inputMethod;
        this.f1330s = thicknessParameter;
        this.f1331t = type;
        setLayerID(3);
        this.f1320i = new C1032br();
        this.f1320i.m1432a(this);
        m1135v();
    }

    /* renamed from: a */
    void m1141a(Type type, ThicknessParameter thicknessParameter, InputMethod inputMethod, float f, int i, int i2) {
        if (type == Type.Hightlighter) {
            thicknessParameter = ThicknessParameter.Constant;
        }
        this.f1327p = new C1030bp(f1310A[type.ordinal()]);
        this.f1327p.setStrokeWidth(0.5f * f);
        if (type != Type.Eraser) {
            this.f1327p.setColor(i);
        }
        if (type == Type.Hightlighter || type == Type.Brush || type == Type.Zenbrush) {
            this.f1327p.setAlpha(Color.alpha(i));
        } else {
            this.f1327p.setAlpha(255);
        }
        this.f1328q = inputMethod;
        this.f1330s = thicknessParameter;
        this.f1331t = type;
        setLayerID(i2);
        this.f1320i = new C1032br();
        this.f1320i.m1432a(this);
        m1135v();
    }

    /* renamed from: k */
    float m1166k() {
        return this.f1327p.getStrokeWidth();
    }

    /* renamed from: v */
    private void m1135v() {
        if (this.f1331t == Type.Pencil) {
            this.f1318g = new C1002ao();
            this.f1319h = new C1000am();
        } else if (this.f1331t == Type.Brush) {
            this.f1318g = new C1049e();
            this.f1319h = new C1041c();
        } else if (this.f1331t == Type.Zenbrush) {
            this.f1318g = new C1047cf();
            this.f1319h = new C1045cd();
        } else {
            this.f1318g = new C1012ay();
            this.f1319h = new C1028bn();
        }
        this.f1319h.m1414a(this, this.f1320i);
        this.f1318g.mo1377a(this);
    }

    /* renamed from: a */
    private void m1133a(PointF pointF, float f) {
        this.f1324m = pointF.x;
        this.f1325n = pointF.y;
        this.f1326o = f;
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public StringBuilder toXML() {
        StringBuilder sb = new StringBuilder("<point>\n");
        StringBuilder sb2 = new StringBuilder("<pressure>\n");
        int size = this.f1317f.size();
        for (int i = 0; i < size; i++) {
            C1007at c1007at = this.f1317f.get(i);
            sb.append(String.format("%s %s, ", Float.toString(c1007at.f1534a), Float.toString(c1007at.f1535b)));
            sb2.append(String.format("%s, ", Float.toString(c1007at.f1536c * 255.0f)));
        }
        sb.append("</point>\n");
        sb2.append("</pressure>\n");
        StringBuilder sb3 = new StringBuilder();
        Object[] objArr = new Object[11];
        objArr[0] = this.f1331t.toString();
        objArr[1] = Integer.valueOf(this.f1327p.getColor());
        objArr[2] = this.f1330s.toString();
        objArr[3] = this.f1328q.toString();
        objArr[4] = Integer.toString((int) (this.f1327p.getStrokeWidth() * 2.0f));
        objArr[5] = Integer.valueOf(this.f830a ? 1 : 0);
        objArr[6] = Integer.valueOf(this.f1337z ? 1 : 0);
        objArr[7] = Integer.valueOf(this.objectID);
        objArr[8] = Integer.valueOf(getLayerID());
        objArr[9] = Integer.valueOf(this.multiUserID);
        objArr[10] = Integer.valueOf(this.multiObjectID);
        sb3.append(String.format("<stroke type=\"%s\" color=\"#%08x\" parameter=\"%s\" input=\"%s\" width=\"%s\" visible=\"%d\" fixed=\"%d\" id=\"%d\" layerID=\"%d\" userID=\"%d\" strokeID=\"%d\">\n", objArr));
        sb3.append((CharSequence) sb);
        sb3.append((CharSequence) sb2);
        sb3.append("</stroke>\n");
        return sb3;
    }

    /* renamed from: c */
    void m1155c(boolean z) {
        this.f1332u = z;
    }

    /* renamed from: a */
    void m1144a(float[] fArr) {
        this.f1311B = fArr;
    }

    /* renamed from: l */
    float[] m1167l() {
        return this.f1311B;
    }

    /* renamed from: b */
    void m1149b(float[] fArr) {
        this.f1312C = fArr;
    }

    /* renamed from: m */
    float[] m1168m() {
        return this.f1312C;
    }

    /* renamed from: n */
    boolean m1169n() {
        return this.f1315d;
    }

    /* renamed from: d */
    void m1157d(boolean z) {
        this.f1315d = z;
    }

    /* renamed from: o */
    boolean m1170o() {
        return this.f1327p.m1421a();
    }

    /* renamed from: a */
    void m1142a(String str) {
        if (str == null) {
            m1173r();
        }
        this.f1334w = str;
    }

    /* renamed from: a */
    void m1138a(int i) {
        this.f1335x = i;
    }

    /* renamed from: b */
    void m1148b(int i) {
        this.f1336y = i;
    }

    /* renamed from: p */
    boolean m1171p() {
        return this.f1334w != null && new File(this.f1334w).exists();
    }

    /* renamed from: q */
    public boolean m1172q() {
        return this.f1337z;
    }

    /* renamed from: e */
    void m1159e(boolean z) {
        if (z) {
            this.f1318g.mo1375a();
            m1173r();
        }
        setVisible(!z);
        this.f1337z = z;
    }

    /* renamed from: r */
    protected void m1173r() {
        if (this.f1334w != null) {
            File file = new File(this.f1334w);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f1334w = null;
            }
        }
    }

    /* renamed from: s */
    public StrokeInfo m1174s() {
        float[] fArr = new float[this.f1317f.size()];
        long[] jArr = new long[this.f1317f.size()];
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[this.f1317f.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                break;
            }
            fArr[i2] = this.f1317f.get(i2).f1536c;
            jArr[i2] = this.f1317f.get(i2).f1537d;
            pointFArr[i2] = new android.graphics.PointF(this.f1317f.get(i2).f1534a, this.f1317f.get(i2).f1535b);
            i = i2 + 1;
        }
        if (PenSettingInfo.m1019a(getType()) == 5) {
            this.f1313D = new StrokeInfo(getLayerID(), PenSettingInfo.m1019a(getType()), this.f1327p.getColor(), this.f1327p.getAlpha(), (this.f1327p.getStrokeWidth() * 2.0f) / 1.1f, fArr, pointFArr, this.f1329r, jArr);
        } else {
            this.f1313D = new StrokeInfo(getLayerID(), PenSettingInfo.m1019a(getType()), this.f1327p.getColor(), this.f1327p.getAlpha(), this.f1327p.getStrokeWidth() * 2.0f, fArr, pointFArr, this.f1329r, jArr);
        }
        this.f1313D.setID(this.objectID);
        this.f1313D.setMultiObjectID(this.multiObjectID);
        this.f1313D.setMultiUserID(this.multiUserID);
        return this.f1313D;
    }

    /* renamed from: c */
    void m1154c(int i) {
        this.f1329r = i;
    }

    @Override // com.samsung.sdraw.AbstractSprite, com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return false;
    }

    /* renamed from: f */
    public void m1161f(boolean z) {
        this.f1314E = z;
    }

    /* renamed from: t */
    public boolean m1175t() {
        return this.f1314E;
    }
}
