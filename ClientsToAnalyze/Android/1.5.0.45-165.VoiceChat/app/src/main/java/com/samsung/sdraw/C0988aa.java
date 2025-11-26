package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.aa */
/* loaded from: classes.dex */
class C0988aa {

    /* renamed from: p */
    private Context f1382p;

    /* renamed from: q */
    private Rect f1383q;

    /* renamed from: r */
    private Rect f1384r;

    /* renamed from: y */
    private b f1391y;

    /* renamed from: a */
    protected Matrix f1367a = new Matrix();

    /* renamed from: b */
    protected Matrix f1368b = new Matrix();

    /* renamed from: f */
    private final Matrix f1372f = new Matrix();

    /* renamed from: g */
    private final float[] f1373g = new float[9];

    /* renamed from: h */
    private int f1374h = -1;

    /* renamed from: i */
    private int f1375i = -1;

    /* renamed from: j */
    private float f1376j = 50.0f;

    /* renamed from: k */
    private float f1377k = 50.0f;

    /* renamed from: l */
    private Handler f1378l = new Handler();

    /* renamed from: m */
    private float f1379m = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;

    /* renamed from: n */
    private boolean f1380n = false;

    /* renamed from: o */
    private boolean f1381o = false;

    /* renamed from: s */
    private boolean f1385s = true;

    /* renamed from: t */
    private boolean f1386t = true;

    /* renamed from: u */
    private boolean f1387u = true;

    /* renamed from: c */
    a f1369c = null;

    /* renamed from: d */
    c f1370d = null;

    /* renamed from: v */
    private Runnable f1388v = null;

    /* renamed from: w */
    private boolean f1389w = true;

    /* renamed from: x */
    private boolean f1390x = true;

    /* renamed from: e */
    View.OnTouchListener f1371e = new View.OnTouchListener() { // from class: com.samsung.sdraw.aa.1

        /* renamed from: k */
        private GestureDetector f1403k;

        /* renamed from: c */
        private int f1395c = -1;

        /* renamed from: d */
        private android.graphics.PointF f1396d = new android.graphics.PointF();

        /* renamed from: e */
        private android.graphics.PointF f1397e = new android.graphics.PointF();

        /* renamed from: f */
        private RectF f1398f = new RectF();

        /* renamed from: g */
        private android.graphics.PointF f1399g = new android.graphics.PointF();

        /* renamed from: h */
        private android.graphics.PointF f1400h = new android.graphics.PointF();

        /* renamed from: i */
        private float f1401i = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;

        /* renamed from: j */
        private GestureDetector.OnGestureListener f1402j = new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.sdraw.aa.1.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                if (C0988aa.this.m1238e() > 1.0f) {
                    C0988aa.this.m1229b(1.0f, e.getX(), e.getY());
                    return true;
                }
                C0988aa.this.m1229b(3.0f, e.getX(), e.getY());
                return true;
            }
        };

        /* renamed from: l */
        private boolean f1404l = false;

        /* renamed from: a */
        boolean f1393a = false;

        {
            this.f1403k = new GestureDetector(C0988aa.this.f1382p, this.f1402j);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            if (1 == event.getPointerCount()) {
                this.f1403k.onTouchEvent(event);
                switch (event.getAction()) {
                    case 0:
                        this.f1396d.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        this.f1397e.set(event.getX(), event.getY());
                        if (!C0988aa.this.m1224a()) {
                            C0988aa.this.m1221a(true);
                            break;
                        }
                        break;
                    case 1:
                        if (this.f1395c == 0 && this.f1404l) {
                            C0988aa.this.m1219a(this.f1398f);
                        } else if (1 == this.f1395c && C0988aa.this.m1238e() < C0988aa.this.f1392z) {
                            C0988aa.this.m1231c(C0988aa.this.f1392z);
                        }
                        this.f1404l = false;
                        this.f1395c = -1;
                        break;
                    case 2:
                        if (this.f1393a) {
                            this.f1397e.x = event.getX(0);
                            this.f1397e.y = event.getY(0);
                            this.f1393a = false;
                        }
                        float x = ((int) event.getX(0)) - this.f1397e.x;
                        float y = ((int) event.getY(0)) - this.f1397e.y;
                        C0988aa.this.m1221a(true);
                        this.f1397e.set((int) event.getX(0), (int) event.getY(0));
                        C0988aa.this.m1219a(this.f1398f);
                        if (C0988aa.this.m1237d()) {
                            this.f1396d.y += y;
                        }
                        if (C0988aa.this.m1234c()) {
                            this.f1396d.x += x;
                            C0988aa.this.m1214a(x);
                            C0988aa.this.m1228b(x, y);
                            C0988aa.this.m1211j();
                            break;
                        } else {
                            C0988aa.this.m1227b(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                            C0988aa.this.m1228b(x, y);
                            C0988aa.this.m1211j();
                            break;
                        }
                    default:
                        this.f1404l = false;
                        break;
                }
            } else if (2 == event.getPointerCount()) {
                if ((event.getAction() & 255) == 5) {
                    this.f1404l = true;
                    m1246a(this.f1400h, event);
                    this.f1401i = m1244a(event);
                    this.f1397e.set((((int) event.getX(0)) + ((int) event.getX(1))) / 2.0f, (((int) event.getY(0)) + ((int) event.getY(1))) / 2.0f);
                    this.f1396d.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                    if (C0988aa.this.m1226b() != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        C0988aa.this.m1227b(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                    }
                } else if (event.getAction() == 2) {
                    this.f1393a = true;
                    float fM1244a = m1244a(event);
                    float f = fM1244a - this.f1401i;
                    m1246a(this.f1399g, event);
                    float fAbs = Math.abs(this.f1400h.x - this.f1399g.x);
                    float fAbs2 = Math.abs(this.f1400h.y - this.f1399g.y);
                    this.f1400h = this.f1399g;
                    float fAbs3 = Math.abs(fAbs - fAbs2);
                    float fAbs4 = Math.abs(f);
                    if (fAbs4 > 20.0f && fAbs3 <= 20.0f) {
                        this.f1395c = 1;
                    } else if (fAbs4 <= 20.0f) {
                        this.f1395c = 0;
                    }
                    C0993af.m1275a("S", "mstate");
                    C0988aa.this.m1221a(false);
                    float fM1238e = C0988aa.this.m1238e() * (fM1244a / this.f1401i);
                    this.f1401i = fM1244a;
                    if (this.f1395c == 1) {
                        C0988aa.this.m1216a(fM1238e, this.f1399g.x, this.f1399g.y);
                    }
                    float x2 = ((((int) event.getX(0)) + ((int) event.getX(1))) / 2.0f) - this.f1397e.x;
                    float y2 = ((((int) event.getY(0)) + ((int) event.getY(1))) / 2.0f) - this.f1397e.y;
                    C0988aa.this.m1221a(true);
                    this.f1397e.set((((int) event.getX(0)) + ((int) event.getX(1))) / 2.0f, (((int) event.getY(0)) + ((int) event.getY(1))) / 2.0f);
                    C0988aa.this.m1219a(this.f1398f);
                    if (C0988aa.this.m1237d()) {
                        this.f1396d.y += y2;
                    }
                    if (C0988aa.this.m1234c()) {
                        this.f1396d.x += x2;
                        C0988aa.this.m1214a(x2);
                        C0988aa.this.m1228b(x2, y2);
                        C0988aa.this.m1211j();
                    } else {
                        C0988aa.this.m1227b(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        C0988aa.this.m1228b(x2, y2);
                        C0988aa.this.m1211j();
                    }
                } else if (event.getAction() == 3) {
                    if (this.f1395c == 0 && this.f1404l) {
                        C0988aa.this.m1219a(this.f1398f);
                    } else if (1 == this.f1395c && C0988aa.this.m1238e() < C0988aa.this.f1392z) {
                        C0988aa.this.m1231c(C0988aa.this.f1392z);
                    }
                    this.f1404l = false;
                    this.f1395c = -1;
                } else {
                    this.f1404l = false;
                }
            }
            return true;
        }

        /* renamed from: a */
        private float m1244a(MotionEvent motionEvent) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return FloatMath.sqrt((x * x) + (y * y));
        }

        /* renamed from: a */
        private void m1246a(android.graphics.PointF pointF, MotionEvent motionEvent) {
            pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
        }
    };

    /* renamed from: z */
    private float f1392z = 1.0f;

    /* renamed from: A */
    private boolean f1366A = false;

    /* renamed from: com.samsung.sdraw.aa$a */
    interface a {
        /* renamed from: a */
        void m1247a(float f, float f2);
    }

    /* renamed from: com.samsung.sdraw.aa$b */
    interface b {
        /* renamed from: a */
        void mo979a();

        /* renamed from: a */
        void mo980a(Matrix matrix);
    }

    /* renamed from: com.samsung.sdraw.aa$c */
    interface c {
        /* renamed from: a */
        void m1248a();
    }

    public C0988aa(Context context, Rect rect, Rect rect2) {
        this.f1382p = context;
        this.f1383q = rect;
        this.f1384r = rect2;
    }

    /* renamed from: a */
    public void m1221a(boolean z) {
        this.f1380n = z;
    }

    /* renamed from: b */
    public void m1230b(boolean z) {
        this.f1381o = z;
    }

    /* renamed from: a */
    public boolean m1224a() {
        return this.f1381o;
    }

    /* renamed from: a */
    public void m1214a(float f) {
        this.f1379m += f;
    }

    /* renamed from: b */
    public void m1227b(float f) {
        this.f1379m = f;
    }

    /* renamed from: b */
    public float m1226b() {
        return this.f1379m;
    }

    /* renamed from: a */
    public void m1222a(boolean z, int i, int i2, int i3, int i4) {
        this.f1374h = i3 - i;
        this.f1375i = i4 - i2;
        Runnable runnable = this.f1388v;
        if (runnable != null) {
            this.f1388v = null;
            runnable.run();
        }
        this.f1384r.set(0, 0, i3 - i, i4 - i2);
        if (!this.f1366A) {
            m1207b(this.f1367a);
            m1208c(m1242h());
        }
        this.f1376j = m1243i();
        m1223a(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m1223a(boolean r9, boolean r10) {
        /*
            r8 = this;
            r7 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            android.graphics.Rect r1 = r8.f1383q
            int r1 = r1.width()
            android.graphics.Rect r2 = r8.f1384r
            int r2 = r2.width()
            int r2 = java.lang.Math.min(r1, r2)
            android.graphics.Rect r1 = r8.f1383q
            int r1 = r1.height()
            android.graphics.Rect r3 = r8.f1384r
            int r3 = r3.height()
            int r1 = java.lang.Math.min(r1, r3)
            android.graphics.Rect r3 = r8.f1383q
            int r3 = r3.width()
            if (r3 != 0) goto L2c
        L2b:
            return
        L2c:
            android.graphics.Matrix r3 = r8.m1242h()
            android.graphics.RectF r4 = new android.graphics.RectF
            android.graphics.Rect r5 = r8.f1383q
            int r5 = r5.width()
            float r5 = (float) r5
            android.graphics.Rect r6 = r8.f1383q
            int r6 = r6.height()
            float r6 = (float) r6
            r4.<init>(r0, r0, r5, r6)
            r3.mapRect(r4)
            float r3 = r4.height()
            float r5 = r4.width()
            if (r10 == 0) goto Lbe
            float r6 = (float) r1
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L92
            float r6 = (float) r1
            float r3 = r6 - r3
            float r3 = r3 / r7
            android.graphics.Rect r6 = r8.f1383q
            int r6 = r6.height()
            int r1 = r1 - r6
            float r1 = (float) r1
            float r1 = r1 / r7
            float r1 = r3 - r1
            float r3 = r4.top
            float r1 = r1 - r3
        L67:
            if (r9 == 0) goto L7e
            float r3 = (float) r2
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto La8
            float r0 = (float) r2
            float r0 = r0 - r5
            float r0 = r0 / r7
            android.graphics.Rect r3 = r8.f1383q
            int r3 = r3.width()
            int r2 = r2 - r3
            float r2 = (float) r2
            float r2 = r2 / r7
            float r0 = r0 - r2
            float r2 = r4.left
            float r0 = r0 - r2
        L7e:
            r8.m1215a(r0, r1)
            android.graphics.Matrix r2 = r8.m1242h()
            r8.m1208c(r2)
            com.samsung.sdraw.aa$a r2 = r8.f1369c
            if (r2 == 0) goto L2b
            com.samsung.sdraw.aa$a r2 = r8.f1369c
            r2.m1247a(r0, r1)
            goto L2b
        L92:
            float r3 = r4.top
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L9c
            float r1 = r4.top
            float r1 = -r1
            goto L67
        L9c:
            float r3 = r4.bottom
            float r6 = (float) r1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto Lbe
            float r1 = (float) r1
            float r3 = r4.bottom
            float r1 = r1 - r3
            goto L67
        La8:
            float r3 = r4.left
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto Lb2
            float r0 = r4.left
            float r0 = -r0
            goto L7e
        Lb2:
            float r3 = r4.right
            float r5 = (float) r2
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L7e
            float r0 = (float) r2
            float r2 = r4.right
            float r0 = r0 - r2
            goto L7e
        Lbe:
            r1 = r0
            goto L67
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.C0988aa.m1223a(boolean, boolean):void");
    }

    /* renamed from: c */
    public boolean m1234c() {
        return this.f1389w;
    }

    /* renamed from: d */
    public boolean m1237d() {
        return this.f1390x;
    }

    /* renamed from: a */
    public void m1219a(RectF rectF) {
        if (this.f1383q.width() == 0) {
            this.f1389w = true;
            this.f1390x = true;
            return;
        }
        Matrix matrixM1242h = m1242h();
        rectF.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1383q.width(), this.f1383q.height());
        matrixM1242h.mapRect(rectF);
        int i = (int) (rectF.right - rectF.left);
        int i2 = (int) (rectF.bottom - rectF.top);
        int iWidth = this.f1384r.width();
        int iHeight = this.f1384r.height();
        if (i <= iWidth || (i > iWidth && (rectF.left >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || rectF.right <= iWidth))) {
            this.f1389w = true;
        } else {
            this.f1389w = false;
        }
        if (i2 <= iHeight || (i2 > iHeight && (rectF.top >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || rectF.bottom <= iHeight))) {
            this.f1390x = true;
        } else {
            this.f1390x = false;
        }
    }

    /* renamed from: a */
    public float m1213a(Matrix matrix, int i) {
        matrix.getValues(this.f1373g);
        return this.f1373g[i];
    }

    /* renamed from: a */
    public float m1212a(Matrix matrix) {
        return m1213a(matrix, 0);
    }

    /* renamed from: e */
    public float m1238e() {
        return m1212a(this.f1368b);
    }

    /* renamed from: f */
    float m1240f() {
        return m1213a(this.f1372f, 2);
    }

    /* renamed from: g */
    float m1241g() {
        return m1213a(this.f1372f, 5);
    }

    /* renamed from: b */
    private void m1207b(Matrix matrix) {
        matrix.reset();
        m1242h().mapRect(new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1383q.width(), this.f1383q.height()));
    }

    /* renamed from: h */
    public Matrix m1242h() {
        this.f1372f.set(this.f1367a);
        this.f1372f.postConcat(this.f1368b);
        return this.f1372f;
    }

    /* renamed from: i */
    public float m1243i() {
        if (this.f1383q.width() == 0) {
            return 1.0f;
        }
        return Math.max(this.f1374h / this.f1383q.width(), this.f1375i / this.f1383q.height()) * this.f1377k;
    }

    /* renamed from: a */
    public void m1216a(float f, float f2, float f3) {
        if (this.f1386t) {
            if (f > this.f1376j) {
                f = this.f1376j;
            }
            if (f < this.f1392z) {
                f = this.f1392z;
            }
            float fM1238e = f / m1238e();
            this.f1368b.postScale(fM1238e, fM1238e, f2, f3);
            m1208c(m1242h());
            m1223a(true, true);
        }
    }

    /* renamed from: a */
    public void m1217a(final float f, final float f2, final float f3, final float f4) {
        final float f5 = f4 + 150.0f;
        final float fM1238e = ((f - m1238e()) * 0.6f) / f4;
        final float fM1238e2 = ((f - m1238e()) * 0.4f) / 150.0f;
        final float fM1238e3 = m1238e();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final boolean z = fM1238e3 < f;
        m1230b(true);
        this.f1378l.post(new Runnable() { // from class: com.samsung.sdraw.aa.2
            @Override // java.lang.Runnable
            public void run() {
                float fMin = Math.min(f5, System.currentTimeMillis() - jCurrentTimeMillis);
                float f6 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                C0988aa.this.m1230b(true);
                if (fMin <= f4) {
                    f6 = fM1238e3 + (fM1238e * fMin);
                } else if (fMin <= f5) {
                    f6 = fM1238e3 + (fM1238e * f4) + (fM1238e2 * (fMin - f4));
                }
                if ((z && f6 > f) || (!z && f6 < f)) {
                    f6 = f;
                }
                C0988aa.this.m1216a(f6, f2, f3);
                if (fMin < f5) {
                    C0988aa.this.f1378l.post(this);
                    return;
                }
                C0988aa.this.m1230b(false);
                if (C0988aa.this.f1370d != null) {
                    C0988aa.this.f1370d.m1248a();
                }
            }
        });
    }

    /* renamed from: c */
    public void m1231c(float f) {
        if (this.f1386t) {
            if (f < this.f1392z) {
                f = this.f1392z;
            }
            if (this.f1384r != null && this.f1384r.width() > 0) {
                m1216a(f, this.f1384r.width() / 2.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            }
        }
    }

    /* renamed from: b */
    public void m1229b(float f, float f2, float f3) {
        if (this.f1386t) {
            if (f < this.f1392z) {
                f = this.f1392z;
            }
            m1217a(f, (f2 - (this.f1384r.width() / 2.0f)) + f2, (f3 - (this.f1384r.height() / 2.0f)) + f3, 200.0f);
        }
    }

    /* renamed from: a */
    public void m1215a(float f, float f2) {
        if (this.f1384r != null && this.f1383q != null) {
            if (this.f1385s) {
                if (m1240f() + f > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || this.f1383q.width() * m1238e() < this.f1384r.width()) {
                    f = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET - m1240f();
                } else if (VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET > (((this.f1383q.width() * m1238e()) + m1240f()) - this.f1384r.width()) + f) {
                    f = this.f1384r.width() - ((this.f1383q.width() * m1238e()) + m1240f());
                }
                if (m1241g() + f2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || this.f1383q.height() * m1238e() < this.f1384r.height()) {
                    f2 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET - m1241g();
                } else if (VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET > (((this.f1383q.height() * m1238e()) + m1241g()) - this.f1384r.height()) + f2) {
                    f2 = this.f1384r.height() - ((this.f1383q.height() * m1238e()) + m1241g());
                }
            }
            this.f1368b.postTranslate(f, f2);
        }
    }

    /* renamed from: b */
    public void m1228b(float f, float f2) {
        if (this.f1387u) {
            m1215a(f, f2);
            m1208c(m1242h());
        }
    }

    /* renamed from: c */
    public void m1232c(float f, float f2) {
        float[] fArr = new float[9];
        this.f1368b.getValues(fArr);
        this.f1368b.postTranslate(-fArr[2], -fArr[5]);
        this.f1368b.postTranslate(f, f2);
        m1208c(m1242h());
    }

    /* renamed from: a */
    public void m1220a(b bVar) {
        this.f1391y = bVar;
    }

    /* renamed from: a */
    public boolean m1225a(View view, MotionEvent motionEvent) {
        return this.f1371e.onTouch(view, motionEvent);
    }

    /* renamed from: c */
    private void m1208c(Matrix matrix) {
        if (this.f1391y != null) {
            this.f1391y.mo980a(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m1211j() {
        if (this.f1391y != null) {
            this.f1391y.mo979a();
        }
    }

    /* renamed from: d */
    public void m1235d(float f) {
        this.f1392z = f;
    }

    /* renamed from: e */
    public void m1239e(float f) {
        this.f1376j = f;
        this.f1377k = f;
    }

    /* renamed from: a */
    public void m1218a(Rect rect) {
        this.f1383q = rect;
    }

    /* renamed from: c */
    public void m1233c(boolean z) {
        this.f1386t = z;
    }

    /* renamed from: d */
    public void m1236d(boolean z) {
        this.f1387u = z;
    }
}
