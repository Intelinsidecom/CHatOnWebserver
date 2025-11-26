package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0154ao;
import android.support.v4.view.C0224z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* renamed from: android.support.v4.widget.am */
/* loaded from: classes.dex */
public class C0238am {

    /* renamed from: v */
    private static final Interpolator f552v = new InterpolatorC0239an();

    /* renamed from: a */
    private int f553a;

    /* renamed from: b */
    private int f554b;

    /* renamed from: d */
    private float[] f556d;

    /* renamed from: e */
    private float[] f557e;

    /* renamed from: f */
    private float[] f558f;

    /* renamed from: g */
    private float[] f559g;

    /* renamed from: h */
    private int[] f560h;

    /* renamed from: i */
    private int[] f561i;

    /* renamed from: j */
    private int[] f562j;

    /* renamed from: k */
    private int f563k;

    /* renamed from: l */
    private VelocityTracker f564l;

    /* renamed from: m */
    private float f565m;

    /* renamed from: n */
    private float f566n;

    /* renamed from: o */
    private int f567o;

    /* renamed from: p */
    private int f568p;

    /* renamed from: q */
    private C0260t f569q;

    /* renamed from: r */
    private final AbstractC0241ap f570r;

    /* renamed from: s */
    private View f571s;

    /* renamed from: t */
    private boolean f572t;

    /* renamed from: u */
    private final ViewGroup f573u;

    /* renamed from: c */
    private int f555c = -1;

    /* renamed from: w */
    private final Runnable f574w = new RunnableC0240ao(this);

    /* renamed from: a */
    public static C0238am m828a(ViewGroup viewGroup, AbstractC0241ap abstractC0241ap) {
        return new C0238am(viewGroup.getContext(), viewGroup, abstractC0241ap);
    }

    /* renamed from: a */
    public static C0238am m827a(ViewGroup viewGroup, float f, AbstractC0241ap abstractC0241ap) {
        C0238am c0238amM828a = m828a(viewGroup, abstractC0241ap);
        c0238amM828a.f554b = (int) (c0238amM828a.f554b * (1.0f / f));
        return c0238amM828a;
    }

    private C0238am(Context context, ViewGroup viewGroup, AbstractC0241ap abstractC0241ap) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0241ap == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f573u = viewGroup;
        this.f570r = abstractC0241ap;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f567o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f554b = viewConfiguration.getScaledTouchSlop();
        this.f565m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f566n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f569q = C0260t.m911a(context, f552v);
    }

    /* renamed from: a */
    public void m845a(float f) {
        this.f566n = f;
    }

    /* renamed from: a */
    public int m844a() {
        return this.f553a;
    }

    /* renamed from: a */
    public void m846a(int i) {
        this.f568p = i;
    }

    /* renamed from: b */
    public int m852b() {
        return this.f567o;
    }

    /* renamed from: a */
    public void m847a(View view, int i) {
        if (view.getParent() != this.f573u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f573u + ")");
        }
        this.f571s = view;
        this.f555c = i;
        this.f570r.mo817b(view, i);
        m859c(1);
    }

    /* renamed from: c */
    public View m858c() {
        return this.f571s;
    }

    /* renamed from: d */
    public int m861d() {
        return this.f554b;
    }

    /* renamed from: e */
    public void m864e() {
        this.f555c = -1;
        m842g();
        if (this.f564l != null) {
            this.f564l.recycle();
            this.f564l = null;
        }
    }

    /* renamed from: f */
    public void m865f() {
        m864e();
        if (this.f553a == 2) {
            int iM914b = this.f569q.m914b();
            int iM915c = this.f569q.m915c();
            this.f569q.m919g();
            int iM914b2 = this.f569q.m914b();
            int iM915c2 = this.f569q.m915c();
            this.f570r.mo814a(this.f571s, iM914b2, iM915c2, iM914b2 - iM914b, iM915c2 - iM915c);
        }
        m859c(0);
    }

    /* renamed from: a */
    public boolean m850a(View view, int i, int i2) {
        this.f571s = view;
        this.f555c = -1;
        return m832a(i, i2, 0, 0);
    }

    /* renamed from: a */
    public boolean m848a(int i, int i2) {
        if (!this.f572t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return m832a(i, i2, (int) C0154ao.m625a(this.f564l, this.f555c), (int) C0154ao.m626b(this.f564l, this.f555c));
    }

    /* renamed from: a */
    private boolean m832a(int i, int i2, int i3, int i4) {
        int left = this.f571s.getLeft();
        int top = this.f571s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f569q.m919g();
            m859c(0);
            return false;
        }
        this.f569q.m912a(left, top, i5, i6, m826a(this.f571s, i5, i6, i3, i4));
        m859c(2);
        return true;
    }

    /* renamed from: a */
    private int m826a(View view, int i, int i2, int i3, int i4) {
        int iM835b = m835b(i3, (int) this.f566n, (int) this.f565m);
        int iM835b2 = m835b(i4, (int) this.f566n, (int) this.f565m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iM835b);
        int iAbs4 = Math.abs(iM835b2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        return (int) (((iM835b2 != 0 ? iAbs4 / i5 : iAbs2 / i6) * m825a(i2, iM835b2, this.f570r.m867b(view))) + ((iM835b != 0 ? iAbs3 / i5 : iAbs / i6) * m825a(i, iM835b, this.f570r.mo810a(view))));
    }

    /* renamed from: a */
    private int m825a(int i, int i2, int i3) {
        int iAbs;
        if (i == 0) {
            return 0;
        }
        int width = this.f573u.getWidth();
        int i4 = width / 2;
        float fM834b = (m834b(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM834b / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(iAbs, 600);
    }

    /* renamed from: b */
    private int m835b(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    /* renamed from: a */
    private float m824a(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    /* renamed from: b */
    private float m834b(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    /* renamed from: a */
    public boolean m851a(boolean z) {
        boolean zM913a;
        if (this.f553a == 2) {
            boolean zM918f = this.f569q.m918f();
            int iM914b = this.f569q.m914b();
            int iM915c = this.f569q.m915c();
            int left = iM914b - this.f571s.getLeft();
            int top = iM915c - this.f571s.getTop();
            if (left != 0) {
                this.f571s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f571s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f570r.mo814a(this.f571s, iM914b, iM915c, left, top);
            }
            if (zM918f && iM914b == this.f569q.m916d() && iM915c == this.f569q.m917e()) {
                this.f569q.m919g();
                zM913a = this.f569q.m913a();
            } else {
                zM913a = zM918f;
            }
            if (!zM913a) {
                if (z) {
                    this.f573u.post(this.f574w);
                } else {
                    m859c(0);
                }
            }
        }
        return this.f553a == 2;
    }

    /* renamed from: a */
    private void m829a(float f, float f2) {
        this.f572t = true;
        this.f570r.mo813a(this.f571s, f, f2);
        this.f572t = false;
        if (this.f553a == 1) {
            m859c(0);
        }
    }

    /* renamed from: g */
    private void m842g() {
        if (this.f556d != null) {
            Arrays.fill(this.f556d, 0.0f);
            Arrays.fill(this.f557e, 0.0f);
            Arrays.fill(this.f558f, 0.0f);
            Arrays.fill(this.f559g, 0.0f);
            Arrays.fill(this.f560h, 0);
            Arrays.fill(this.f561i, 0);
            Arrays.fill(this.f562j, 0);
            this.f563k = 0;
        }
    }

    /* renamed from: e */
    private void m840e(int i) {
        if (this.f556d != null) {
            this.f556d[i] = 0.0f;
            this.f557e[i] = 0.0f;
            this.f558f[i] = 0.0f;
            this.f559g[i] = 0.0f;
            this.f560h[i] = 0;
            this.f561i[i] = 0;
            this.f562j[i] = 0;
            this.f563k &= (1 << i) ^ (-1);
        }
    }

    /* renamed from: f */
    private void m841f(int i) {
        if (this.f556d == null || this.f556d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.f556d != null) {
                System.arraycopy(this.f556d, 0, fArr, 0, this.f556d.length);
                System.arraycopy(this.f557e, 0, fArr2, 0, this.f557e.length);
                System.arraycopy(this.f558f, 0, fArr3, 0, this.f558f.length);
                System.arraycopy(this.f559g, 0, fArr4, 0, this.f559g.length);
                System.arraycopy(this.f560h, 0, iArr, 0, this.f560h.length);
                System.arraycopy(this.f561i, 0, iArr2, 0, this.f561i.length);
                System.arraycopy(this.f562j, 0, iArr3, 0, this.f562j.length);
            }
            this.f556d = fArr;
            this.f557e = fArr2;
            this.f558f = fArr3;
            this.f559g = fArr4;
            this.f560h = iArr;
            this.f561i = iArr2;
            this.f562j = iArr3;
        }
    }

    /* renamed from: a */
    private void m830a(float f, float f2, int i) {
        m841f(i);
        float[] fArr = this.f556d;
        this.f558f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f557e;
        this.f559g[i] = f2;
        fArr2[i] = f2;
        this.f560h[i] = m839e((int) f, (int) f2);
        this.f563k |= 1 << i;
    }

    /* renamed from: c */
    private void m838c(MotionEvent motionEvent) {
        int iM746c = C0224z.m746c(motionEvent);
        for (int i = 0; i < iM746c; i++) {
            int iM744b = C0224z.m744b(motionEvent, i);
            float fM745c = C0224z.m745c(motionEvent, i);
            float fM747d = C0224z.m747d(motionEvent, i);
            this.f558f[iM744b] = fM745c;
            this.f559g[iM744b] = fM747d;
        }
    }

    /* renamed from: b */
    public boolean m854b(int i) {
        return (this.f563k & (1 << i)) != 0;
    }

    /* renamed from: c */
    void m859c(int i) {
        if (this.f553a != i) {
            this.f553a = i;
            this.f570r.mo812a(i);
            if (i == 0) {
                this.f571s = null;
            }
        }
    }

    /* renamed from: b */
    boolean m856b(View view, int i) {
        if (view == this.f571s && this.f555c == i) {
            return true;
        }
        if (view != null && this.f570r.mo815a(view, i)) {
            this.f555c = i;
            m847a(view, i);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m849a(MotionEvent motionEvent) {
        View viewM862d;
        View viewM862d2;
        int iM741a = C0224z.m741a(motionEvent);
        int iM743b = C0224z.m743b(motionEvent);
        if (iM741a == 0) {
            m864e();
        }
        if (this.f564l == null) {
            this.f564l = VelocityTracker.obtain();
        }
        this.f564l.addMovement(motionEvent);
        switch (iM741a) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iM744b = C0224z.m744b(motionEvent, 0);
                m830a(x, y, iM744b);
                View viewM862d3 = m862d((int) x, (int) y);
                if (viewM862d3 == this.f571s && this.f553a == 2) {
                    m856b(viewM862d3, iM744b);
                }
                int i = this.f560h[iM744b];
                if ((this.f568p & i) != 0) {
                    this.f570r.mo866a(i & this.f568p, iM744b);
                    break;
                }
                break;
            case 1:
            case 3:
                m864e();
                break;
            case 2:
                int iM746c = C0224z.m746c(motionEvent);
                for (int i2 = 0; i2 < iM746c; i2++) {
                    int iM744b2 = C0224z.m744b(motionEvent, i2);
                    float fM745c = C0224z.m745c(motionEvent, i2);
                    float fM747d = C0224z.m747d(motionEvent, i2);
                    float f = fM745c - this.f556d[iM744b2];
                    float f2 = fM747d - this.f557e[iM744b2];
                    m836b(f, f2, iM744b2);
                    if (this.f553a == 1 || ((viewM862d = m862d((int) fM745c, (int) fM747d)) != null && m833a(viewM862d, f, f2) && m856b(viewM862d, iM744b2))) {
                        m838c(motionEvent);
                        break;
                    }
                }
                m838c(motionEvent);
                break;
            case 5:
                int iM744b3 = C0224z.m744b(motionEvent, iM743b);
                float fM745c2 = C0224z.m745c(motionEvent, iM743b);
                float fM747d2 = C0224z.m747d(motionEvent, iM743b);
                m830a(fM745c2, fM747d2, iM744b3);
                if (this.f553a == 0) {
                    int i3 = this.f560h[iM744b3];
                    if ((this.f568p & i3) != 0) {
                        this.f570r.mo866a(i3 & this.f568p, iM744b3);
                        break;
                    }
                } else if (this.f553a == 2 && (viewM862d2 = m862d((int) fM745c2, (int) fM747d2)) == this.f571s) {
                    m856b(viewM862d2, iM744b3);
                    break;
                }
                break;
            case 6:
                m840e(C0224z.m744b(motionEvent, iM743b));
                break;
        }
        return this.f553a == 1;
    }

    /* renamed from: b */
    public void m853b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int iM741a = C0224z.m741a(motionEvent);
        int iM743b = C0224z.m743b(motionEvent);
        if (iM741a == 0) {
            m864e();
        }
        if (this.f564l == null) {
            this.f564l = VelocityTracker.obtain();
        }
        this.f564l.addMovement(motionEvent);
        switch (iM741a) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iM744b = C0224z.m744b(motionEvent, 0);
                View viewM862d = m862d((int) x, (int) y);
                m830a(x, y, iM744b);
                m856b(viewM862d, iM744b);
                int i3 = this.f560h[iM744b];
                if ((this.f568p & i3) != 0) {
                    this.f570r.mo866a(i3 & this.f568p, iM744b);
                    break;
                }
                break;
            case 1:
                if (this.f553a == 1) {
                    m843h();
                }
                m864e();
                break;
            case 2:
                if (this.f553a == 1) {
                    int iM742a = C0224z.m742a(motionEvent, this.f555c);
                    float fM745c = C0224z.m745c(motionEvent, iM742a);
                    float fM747d = C0224z.m747d(motionEvent, iM742a);
                    int i4 = (int) (fM745c - this.f558f[this.f555c]);
                    int i5 = (int) (fM747d - this.f559g[this.f555c]);
                    m837b(this.f571s.getLeft() + i4, this.f571s.getTop() + i5, i4, i5);
                    m838c(motionEvent);
                    break;
                } else {
                    int iM746c = C0224z.m746c(motionEvent);
                    while (i2 < iM746c) {
                        int iM744b2 = C0224z.m744b(motionEvent, i2);
                        float fM745c2 = C0224z.m745c(motionEvent, i2);
                        float fM747d2 = C0224z.m747d(motionEvent, i2);
                        float f = fM745c2 - this.f556d[iM744b2];
                        float f2 = fM747d2 - this.f557e[iM744b2];
                        m836b(f, f2, iM744b2);
                        if (this.f553a != 1) {
                            View viewM862d2 = m862d((int) fM745c2, (int) fM747d2);
                            if (!m833a(viewM862d2, f, f2) || !m856b(viewM862d2, iM744b2)) {
                                i2++;
                            }
                        }
                        m838c(motionEvent);
                        break;
                    }
                    m838c(motionEvent);
                }
                break;
            case 3:
                if (this.f553a == 1) {
                    m829a(0.0f, 0.0f);
                }
                m864e();
                break;
            case 5:
                int iM744b3 = C0224z.m744b(motionEvent, iM743b);
                float fM745c3 = C0224z.m745c(motionEvent, iM743b);
                float fM747d3 = C0224z.m747d(motionEvent, iM743b);
                m830a(fM745c3, fM747d3, iM744b3);
                if (this.f553a == 0) {
                    m856b(m862d((int) fM745c3, (int) fM747d3), iM744b3);
                    int i6 = this.f560h[iM744b3];
                    if ((this.f568p & i6) != 0) {
                        this.f570r.mo866a(i6 & this.f568p, iM744b3);
                        break;
                    }
                } else if (m860c((int) fM745c3, (int) fM747d3)) {
                    m856b(this.f571s, iM744b3);
                    break;
                }
                break;
            case 6:
                int iM744b4 = C0224z.m744b(motionEvent, iM743b);
                if (this.f553a == 1 && iM744b4 == this.f555c) {
                    int iM746c2 = C0224z.m746c(motionEvent);
                    while (true) {
                        if (i2 >= iM746c2) {
                            i = -1;
                        } else {
                            int iM744b5 = C0224z.m744b(motionEvent, i2);
                            if (iM744b5 != this.f555c) {
                                if (m862d((int) C0224z.m745c(motionEvent, i2), (int) C0224z.m747d(motionEvent, i2)) == this.f571s && m856b(this.f571s, iM744b5)) {
                                    i = this.f555c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m843h();
                    }
                }
                m840e(iM744b4);
                break;
        }
    }

    /* renamed from: b */
    private void m836b(float f, float f2, int i) {
        int i2 = m831a(f, f2, i, 1) ? 1 : 0;
        if (m831a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m831a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m831a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f561i;
            iArr[i] = iArr[i] | i2;
            this.f570r.mo816b(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m831a(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f560h[i] & i2) != i2 || (this.f568p & i2) == 0 || (this.f562j[i] & i2) == i2 || (this.f561i[i] & i2) == i2) {
            return false;
        }
        if (fAbs <= this.f554b && fAbs2 <= this.f554b) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f570r.mo869b(i2)) {
            return (this.f561i[i] & i2) == 0 && fAbs > ((float) this.f554b);
        }
        int[] iArr = this.f562j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m833a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f570r.mo810a(view) > 0;
        boolean z2 = this.f570r.m867b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f554b * this.f554b)) : z ? Math.abs(f) > ((float) this.f554b) : z2 && Math.abs(f2) > ((float) this.f554b);
    }

    /* renamed from: d */
    public boolean m863d(int i) {
        int length = this.f556d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m855b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m855b(int i, int i2) {
        if (!m854b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f558f[i2] - this.f556d[i2];
        float f2 = this.f559g[i2] - this.f557e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f554b * this.f554b)) : z ? Math.abs(f) > ((float) this.f554b) : z2 && Math.abs(f2) > ((float) this.f554b);
    }

    /* renamed from: h */
    private void m843h() {
        this.f564l.computeCurrentVelocity(1000, this.f565m);
        m829a(m824a(C0154ao.m625a(this.f564l, this.f555c), this.f566n, this.f565m), m824a(C0154ao.m626b(this.f564l, this.f555c), this.f566n, this.f565m));
    }

    /* renamed from: b */
    private void m837b(int i, int i2, int i3, int i4) {
        int iMo811a;
        int iMo868b;
        int left = this.f571s.getLeft();
        int top = this.f571s.getTop();
        if (i3 != 0) {
            iMo811a = this.f570r.mo811a(this.f571s, i, i3);
            this.f571s.offsetLeftAndRight(iMo811a - left);
        } else {
            iMo811a = i;
        }
        if (i4 != 0) {
            iMo868b = this.f570r.mo868b(this.f571s, i2, i4);
            this.f571s.offsetTopAndBottom(iMo868b - top);
        } else {
            iMo868b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f570r.mo814a(this.f571s, iMo811a, iMo868b, iMo811a - left, iMo868b - top);
        }
    }

    /* renamed from: c */
    public boolean m860c(int i, int i2) {
        return m857b(this.f571s, i, i2);
    }

    /* renamed from: b */
    public boolean m857b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: d */
    public View m862d(int i, int i2) {
        for (int childCount = this.f573u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f573u.getChildAt(this.f570r.m870c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: e */
    private int m839e(int i, int i2) {
        int i3 = i < this.f573u.getLeft() + this.f567o ? 1 : 0;
        if (i2 < this.f573u.getTop() + this.f567o) {
            i3 |= 4;
        }
        if (i > this.f573u.getRight() - this.f567o) {
            i3 |= 2;
        }
        return i2 > this.f573u.getBottom() - this.f567o ? i3 | 8 : i3;
    }
}
