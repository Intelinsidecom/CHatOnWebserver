package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.p007b.C0073a;
import android.support.v4.widget.C0254n;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: A */
    private boolean f386A;

    /* renamed from: B */
    private boolean f387B;

    /* renamed from: C */
    private int f388C;

    /* renamed from: D */
    private int f389D;

    /* renamed from: E */
    private int f390E;

    /* renamed from: F */
    private float f391F;

    /* renamed from: G */
    private float f392G;

    /* renamed from: H */
    private float f393H;

    /* renamed from: I */
    private float f394I;

    /* renamed from: J */
    private int f395J;

    /* renamed from: K */
    private VelocityTracker f396K;

    /* renamed from: L */
    private int f397L;

    /* renamed from: M */
    private int f398M;

    /* renamed from: N */
    private int f399N;

    /* renamed from: O */
    private int f400O;

    /* renamed from: P */
    private boolean f401P;

    /* renamed from: Q */
    private C0254n f402Q;

    /* renamed from: R */
    private C0254n f403R;

    /* renamed from: S */
    private boolean f404S;

    /* renamed from: T */
    private boolean f405T;

    /* renamed from: U */
    private boolean f406U;

    /* renamed from: V */
    private int f407V;

    /* renamed from: W */
    private InterfaceC0196cc f408W;

    /* renamed from: Z */
    private InterfaceC0196cc f409Z;

    /* renamed from: aa */
    private InterfaceC0195cb f410aa;

    /* renamed from: ab */
    private InterfaceC0197cd f411ab;

    /* renamed from: ac */
    private Method f412ac;

    /* renamed from: ad */
    private int f413ad;

    /* renamed from: ae */
    private ArrayList<View> f414ae;

    /* renamed from: ag */
    private final Runnable f415ag;

    /* renamed from: ah */
    private int f416ah;

    /* renamed from: b */
    private int f417b;

    /* renamed from: e */
    private final ArrayList<C0192bz> f418e;

    /* renamed from: f */
    private final C0192bz f419f;

    /* renamed from: g */
    private final Rect f420g;

    /* renamed from: h */
    private AbstractC0144ae f421h;

    /* renamed from: i */
    private int f422i;

    /* renamed from: j */
    private int f423j;

    /* renamed from: k */
    private Parcelable f424k;

    /* renamed from: l */
    private ClassLoader f425l;

    /* renamed from: m */
    private Scroller f426m;

    /* renamed from: n */
    private C0198ce f427n;

    /* renamed from: o */
    private int f428o;

    /* renamed from: p */
    private Drawable f429p;

    /* renamed from: q */
    private int f430q;

    /* renamed from: r */
    private int f431r;

    /* renamed from: s */
    private float f432s;

    /* renamed from: t */
    private float f433t;

    /* renamed from: u */
    private int f434u;

    /* renamed from: v */
    private int f435v;

    /* renamed from: w */
    private boolean f436w;

    /* renamed from: x */
    private boolean f437x;

    /* renamed from: y */
    private boolean f438y;

    /* renamed from: z */
    private int f439z;

    /* renamed from: a */
    private static final int[] f382a = {R.attr.layout_gravity};

    /* renamed from: c */
    private static final Comparator<C0192bz> f384c = new C0188bv();

    /* renamed from: d */
    private static final Interpolator f385d = new InterpolatorC0189bw();

    /* renamed from: af */
    private static final C0201ch f383af = new C0201ch();

    public ViewPager(Context context) {
        super(context);
        this.f418e = new ArrayList<>();
        this.f419f = new C0192bz();
        this.f420g = new Rect();
        this.f423j = -1;
        this.f424k = null;
        this.f425l = null;
        this.f432s = -3.4028235E38f;
        this.f433t = Float.MAX_VALUE;
        this.f439z = 1;
        this.f395J = -1;
        this.f404S = true;
        this.f405T = false;
        this.f415ag = new RunnableC0190bx(this);
        this.f416ah = 0;
        m411a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f418e = new ArrayList<>();
        this.f419f = new C0192bz();
        this.f420g = new Rect();
        this.f423j = -1;
        this.f424k = null;
        this.f425l = null;
        this.f432s = -3.4028235E38f;
        this.f433t = Float.MAX_VALUE;
        this.f439z = 1;
        this.f395J = -1;
        this.f404S = true;
        this.f405T = false;
        this.f415ag = new RunnableC0190bx(this);
        this.f416ah = 0;
        m411a();
    }

    /* renamed from: a */
    void m411a() {
        setWillNotDraw(false);
        setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        setFocusable(true);
        Context context = getContext();
        this.f426m = new Scroller(context, f385d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f390E = C0176bj.m684a(viewConfiguration);
        this.f397L = (int) (400.0f * f);
        this.f398M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f402Q = new C0254n(context);
        this.f403R = new C0254n(context);
        this.f399N = (int) (25.0f * f);
        this.f400O = (int) (2.0f * f);
        this.f388C = (int) (16.0f * f);
        C0159at.m635a(this, new C0194ca(this));
        if (C0159at.m640c(this) == 0) {
            C0159at.m639b(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f415ag);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m397d(int i) {
        if (this.f416ah != i) {
            this.f416ah = i;
            if (this.f411ab != null) {
                m396c(i != 0);
            }
            if (this.f408W != null) {
                this.f408W.mo622b(i);
            }
        }
    }

    public void setAdapter(AbstractC0144ae abstractC0144ae) {
        if (this.f421h != null) {
            this.f421h.m613b(this.f427n);
            this.f421h.mo78a((ViewGroup) this);
            for (int i = 0; i < this.f418e.size(); i++) {
                C0192bz c0192bz = this.f418e.get(i);
                this.f421h.mo79a((ViewGroup) this, c0192bz.f473b, c0192bz.f472a);
            }
            this.f421h.mo82b((ViewGroup) this);
            this.f418e.clear();
            m402i();
            this.f422i = 0;
            scrollTo(0, 0);
        }
        AbstractC0144ae abstractC0144ae2 = this.f421h;
        this.f421h = abstractC0144ae;
        this.f417b = 0;
        if (this.f421h != null) {
            if (this.f427n == null) {
                this.f427n = new C0198ce(this, null);
            }
            this.f421h.m609a((DataSetObserver) this.f427n);
            this.f438y = false;
            boolean z = this.f404S;
            this.f404S = true;
            this.f417b = this.f421h.mo612b();
            if (this.f423j >= 0) {
                this.f421h.mo77a(this.f424k, this.f425l);
                m415a(this.f423j, false, true);
                this.f423j = -1;
                this.f424k = null;
                this.f425l = null;
            } else if (!z) {
                m427e();
            } else {
                requestLayout();
            }
        }
        if (this.f410aa != null && abstractC0144ae2 != abstractC0144ae) {
            this.f410aa.mo621a(abstractC0144ae2, abstractC0144ae);
        }
    }

    /* renamed from: i */
    private void m402i() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f440a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public AbstractC0144ae m421b() {
        return this.f421h;
    }

    /* renamed from: a */
    void m417a(InterfaceC0195cb interfaceC0195cb) {
        this.f410aa = interfaceC0195cb;
    }

    /* renamed from: j */
    private int m403j() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.f438y = false;
        m415a(i, !this.f404S, false);
    }

    public void setCurrentItem(int i, boolean z) throws Resources.NotFoundException {
        this.f438y = false;
        m415a(i, z, false);
    }

    /* renamed from: c */
    public int m424c() {
        return this.f422i;
    }

    /* renamed from: a */
    void m415a(int i, boolean z, boolean z2) throws Resources.NotFoundException {
        m416a(i, z, z2, 0);
    }

    /* renamed from: a */
    void m416a(int i, boolean z, boolean z2, int i2) throws Resources.NotFoundException {
        if (this.f421h == null || this.f421h.mo612b() <= 0) {
            m399e(false);
            return;
        }
        if (!z2 && this.f422i == i && this.f418e.size() != 0) {
            m399e(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f421h.mo612b()) {
            i = this.f421h.mo612b() - 1;
        }
        int i3 = this.f439z;
        if (i > this.f422i + i3 || i < this.f422i - i3) {
            for (int i4 = 0; i4 < this.f418e.size(); i4++) {
                this.f418e.get(i4).f474c = true;
            }
        }
        boolean z3 = this.f422i != i;
        if (this.f404S) {
            this.f422i = i;
            if (z3 && this.f408W != null) {
                this.f408W.mo619a(i);
            }
            if (z3 && this.f409Z != null) {
                this.f409Z.mo619a(i);
            }
            requestLayout();
            return;
        }
        m412a(i);
        m388a(i, z, i2, z3);
    }

    /* renamed from: a */
    private void m388a(int i, boolean z, int i2, boolean z2) throws Resources.NotFoundException {
        int iMax;
        C0192bz c0192bzM422b = m422b(i);
        if (c0192bzM422b != null) {
            iMax = (int) (Math.max(this.f432s, Math.min(c0192bzM422b.f476e, this.f433t)) * m403j());
        } else {
            iMax = 0;
        }
        if (z) {
            m414a(iMax, 0, i2);
            if (z2 && this.f408W != null) {
                this.f408W.mo619a(i);
            }
            if (z2 && this.f409Z != null) {
                this.f409Z.mo619a(i);
                return;
            }
            return;
        }
        if (z2 && this.f408W != null) {
            this.f408W.mo619a(i);
        }
        if (z2 && this.f409Z != null) {
            this.f409Z.mo619a(i);
        }
        m394b(false);
        scrollTo(iMax, 0);
        m400e(iMax);
    }

    public void setOnPageChangeListener(InterfaceC0196cc interfaceC0196cc) {
        this.f408W = interfaceC0196cc;
    }

    public void setPageTransformer(boolean z, InterfaceC0197cd interfaceC0197cd) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = interfaceC0197cd != null;
            boolean z3 = z2 != (this.f411ab != null);
            this.f411ab = interfaceC0197cd;
            m418a(z2);
            if (z2) {
                this.f413ad = z ? 2 : 1;
            } else {
                this.f413ad = 0;
            }
            if (z3) {
                m427e();
            }
        }
    }

    /* renamed from: a */
    void m418a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f412ac == null) {
                try {
                    this.f412ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f412ac.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f413ad == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f414ae.get(i2).getLayoutParams()).f445f;
    }

    /* renamed from: a */
    InterfaceC0196cc m410a(InterfaceC0196cc interfaceC0196cc) {
        InterfaceC0196cc interfaceC0196cc2 = this.f409Z;
        this.f409Z = interfaceC0196cc;
        return interfaceC0196cc2;
    }

    public void setOffscreenPageLimit(int i) throws Resources.NotFoundException {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f439z) {
            this.f439z = i;
            m427e();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f428o;
        this.f428o = i;
        int width = getWidth();
        m387a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f429p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f429p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f429p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    float m407a(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    /* renamed from: a */
    void m414a(int i, int i2, int i3) throws Resources.NotFoundException {
        int iAbs;
        if (getChildCount() == 0) {
            m399e(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m394b(false);
            m427e();
            m397d(0);
            return;
        }
        m399e(true);
        m397d(2);
        int iM403j = m403j();
        int i6 = iM403j / 2;
        float fM407a = (i6 * m407a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / iM403j))) + i6;
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(1000.0f * Math.abs(fM407a / iAbs2)) * 4;
        } else {
            iAbs = (int) (((Math.abs(i4) / ((iM403j * this.f421h.m618d(this.f422i)) + this.f428o)) + 1.0f) * 100.0f);
        }
        this.f426m.startScroll(scrollX, scrollY, i4, i5, Math.min(iAbs, 600));
        C0159at.m638b(this);
    }

    /* renamed from: a */
    C0192bz m408a(int i, int i2) {
        C0192bz c0192bz = new C0192bz();
        c0192bz.f473b = i;
        c0192bz.f472a = this.f421h.mo76a((ViewGroup) this, i);
        c0192bz.f475d = this.f421h.m618d(i);
        if (i2 < 0 || i2 >= this.f418e.size()) {
            this.f418e.add(c0192bz);
        } else {
            this.f418e.add(i2, c0192bz);
        }
        return c0192bz;
    }

    /* renamed from: d */
    void m426d() {
        int i;
        boolean z;
        int iMax;
        boolean z2;
        int iMo612b = this.f421h.mo612b();
        this.f417b = iMo612b;
        boolean z3 = this.f418e.size() < (this.f439z * 2) + 1 && this.f418e.size() < iMo612b;
        boolean z4 = false;
        int i2 = this.f422i;
        boolean z5 = z3;
        int i3 = 0;
        while (i3 < this.f418e.size()) {
            C0192bz c0192bz = this.f418e.get(i3);
            int iMo607a = this.f421h.mo607a(c0192bz.f472a);
            if (iMo607a == -1) {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            } else if (iMo607a == -2) {
                this.f418e.remove(i3);
                int i4 = i3 - 1;
                if (!z4) {
                    this.f421h.mo78a((ViewGroup) this);
                    z4 = true;
                }
                this.f421h.mo79a((ViewGroup) this, c0192bz.f473b, c0192bz.f472a);
                if (this.f422i == c0192bz.f473b) {
                    i = i4;
                    z = z4;
                    iMax = Math.max(0, Math.min(this.f422i, iMo612b - 1));
                    z2 = true;
                } else {
                    i = i4;
                    z = z4;
                    iMax = i2;
                    z2 = true;
                }
            } else if (c0192bz.f473b != iMo607a) {
                if (c0192bz.f473b == this.f422i) {
                    i2 = iMo607a;
                }
                c0192bz.f473b = iMo607a;
                i = i3;
                z = z4;
                iMax = i2;
                z2 = true;
            } else {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            }
            z5 = z2;
            i2 = iMax;
            z4 = z;
            i3 = i + 1;
        }
        if (z4) {
            this.f421h.mo82b((ViewGroup) this);
        }
        Collections.sort(this.f418e, f384c);
        if (z5) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.f440a) {
                    layoutParams.f442c = 0.0f;
                }
            }
            m415a(i2, false, true);
            requestLayout();
        }
    }

    /* renamed from: e */
    void m427e() throws Resources.NotFoundException {
        m412a(this.f422i);
    }

    /* renamed from: a */
    void m412a(int i) throws Resources.NotFoundException {
        C0192bz c0192bz;
        int i2;
        String hexString;
        int i3;
        C0192bz c0192bz2;
        C0192bz c0192bzM409a;
        if (this.f422i == i) {
            c0192bz = null;
            i2 = 2;
        } else {
            int i4 = this.f422i < i ? 66 : 17;
            C0192bz c0192bzM422b = m422b(this.f422i);
            this.f422i = i;
            c0192bz = c0192bzM422b;
            i2 = i4;
        }
        if (this.f421h == null) {
            m404k();
            return;
        }
        if (this.f438y) {
            m404k();
            return;
        }
        if (getWindowToken() != null) {
            this.f421h.mo78a((ViewGroup) this);
            int i5 = this.f439z;
            int iMax = Math.max(0, this.f422i - i5);
            int iMo612b = this.f421h.mo612b();
            int iMin = Math.min(iMo612b - 1, i5 + this.f422i);
            if (iMo612b != this.f417b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f417b + ", found: " + iMo612b + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f421h.getClass());
            }
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i3 >= this.f418e.size()) {
                    break;
                }
                c0192bz2 = this.f418e.get(i3);
                if (c0192bz2.f473b < this.f422i) {
                    i6 = i3 + 1;
                } else if (c0192bz2.f473b != this.f422i) {
                    break;
                }
            }
            c0192bz2 = null;
            C0192bz c0192bzM408a = (c0192bz2 != null || iMo612b <= 0) ? c0192bz2 : m408a(this.f422i, i3);
            if (c0192bzM408a != null) {
                int i7 = i3 - 1;
                C0192bz c0192bz3 = i7 >= 0 ? this.f418e.get(i7) : null;
                int iM403j = m403j();
                float paddingLeft = iM403j <= 0 ? 0.0f : (2.0f - c0192bzM408a.f475d) + (getPaddingLeft() / iM403j);
                float f = 0.0f;
                int i8 = i3;
                int i9 = i7;
                for (int i10 = this.f422i - 1; i10 >= 0; i10--) {
                    if (f >= paddingLeft && i10 < iMax) {
                        if (c0192bz3 == null) {
                            break;
                        }
                        if (i10 == c0192bz3.f473b && !c0192bz3.f474c) {
                            this.f418e.remove(i9);
                            this.f421h.mo79a((ViewGroup) this, i10, c0192bz3.f472a);
                            i9--;
                            i8--;
                            c0192bz3 = i9 >= 0 ? this.f418e.get(i9) : null;
                        }
                    } else if (c0192bz3 != null && i10 == c0192bz3.f473b) {
                        f += c0192bz3.f475d;
                        i9--;
                        c0192bz3 = i9 >= 0 ? this.f418e.get(i9) : null;
                    } else {
                        f += m408a(i10, i9 + 1).f475d;
                        i8++;
                        c0192bz3 = i9 >= 0 ? this.f418e.get(i9) : null;
                    }
                }
                float f2 = c0192bzM408a.f475d;
                int i11 = i8 + 1;
                if (f2 < 2.0f) {
                    C0192bz c0192bz4 = i11 < this.f418e.size() ? this.f418e.get(i11) : null;
                    float paddingRight = iM403j <= 0 ? 0.0f : (getPaddingRight() / iM403j) + 2.0f;
                    C0192bz c0192bz5 = c0192bz4;
                    int i12 = i11;
                    int i13 = this.f422i + 1;
                    while (i13 < iMo612b) {
                        if (f2 >= paddingRight && i13 > iMin) {
                            if (c0192bz5 == null) {
                                break;
                            }
                            if (i13 == c0192bz5.f473b && !c0192bz5.f474c) {
                                this.f418e.remove(i12);
                                this.f421h.mo79a((ViewGroup) this, i13, c0192bz5.f472a);
                                c0192bz5 = i12 < this.f418e.size() ? this.f418e.get(i12) : null;
                            }
                        } else if (c0192bz5 != null && i13 == c0192bz5.f473b) {
                            f2 += c0192bz5.f475d;
                            i12++;
                            c0192bz5 = i12 < this.f418e.size() ? this.f418e.get(i12) : null;
                        } else {
                            C0192bz c0192bzM408a2 = m408a(i13, i12);
                            i12++;
                            f2 += c0192bzM408a2.f475d;
                            c0192bz5 = i12 < this.f418e.size() ? this.f418e.get(i12) : null;
                        }
                        i13++;
                        c0192bz5 = c0192bz5;
                        f2 = f2;
                    }
                }
                m390a(c0192bzM408a, i8, c0192bz);
            }
            this.f421h.mo83b((ViewGroup) this, this.f422i, c0192bzM408a != null ? c0192bzM408a.f472a : null);
            this.f421h.mo82b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f445f = i14;
                if (!layoutParams.f440a && layoutParams.f442c == 0.0f && (c0192bzM409a = m409a(childAt)) != null) {
                    layoutParams.f442c = c0192bzM409a.f475d;
                    layoutParams.f444e = c0192bzM409a.f473b;
                }
            }
            m404k();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                C0192bz c0192bzM423b = viewFindFocus != null ? m423b(viewFindFocus) : null;
                if (c0192bzM423b == null || c0192bzM423b.f473b != this.f422i) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        C0192bz c0192bzM409a2 = m409a(childAt2);
                        if (c0192bzM409a2 != null && c0192bzM409a2.f473b == this.f422i && childAt2.requestFocus(i2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private void m404k() {
        if (this.f413ad != 0) {
            if (this.f414ae == null) {
                this.f414ae = new ArrayList<>();
            } else {
                this.f414ae.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f414ae.add(getChildAt(i));
            }
            Collections.sort(this.f414ae, f383af);
        }
    }

    /* renamed from: a */
    private void m390a(C0192bz c0192bz, int i, C0192bz c0192bz2) {
        C0192bz c0192bz3;
        C0192bz c0192bz4;
        int iMo612b = this.f421h.mo612b();
        int iM403j = m403j();
        float f = iM403j > 0 ? this.f428o / iM403j : 0.0f;
        if (c0192bz2 != null) {
            int i2 = c0192bz2.f473b;
            if (i2 < c0192bz.f473b) {
                float fM618d = c0192bz2.f476e + c0192bz2.f475d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= c0192bz.f473b && i4 < this.f418e.size()) {
                    C0192bz c0192bz5 = this.f418e.get(i4);
                    while (true) {
                        c0192bz4 = c0192bz5;
                        if (i3 <= c0192bz4.f473b || i4 >= this.f418e.size() - 1) {
                            break;
                        }
                        i4++;
                        c0192bz5 = this.f418e.get(i4);
                    }
                    while (i3 < c0192bz4.f473b) {
                        fM618d += this.f421h.m618d(i3) + f;
                        i3++;
                    }
                    c0192bz4.f476e = fM618d;
                    fM618d += c0192bz4.f475d + f;
                    i3++;
                }
            } else if (i2 > c0192bz.f473b) {
                int size = this.f418e.size() - 1;
                float fM618d2 = c0192bz2.f476e;
                int i5 = i2 - 1;
                while (i5 >= c0192bz.f473b && size >= 0) {
                    C0192bz c0192bz6 = this.f418e.get(size);
                    while (true) {
                        c0192bz3 = c0192bz6;
                        if (i5 >= c0192bz3.f473b || size <= 0) {
                            break;
                        }
                        size--;
                        c0192bz6 = this.f418e.get(size);
                    }
                    while (i5 > c0192bz3.f473b) {
                        fM618d2 -= this.f421h.m618d(i5) + f;
                        i5--;
                    }
                    fM618d2 -= c0192bz3.f475d + f;
                    c0192bz3.f476e = fM618d2;
                    i5--;
                }
            }
        }
        int size2 = this.f418e.size();
        float f2 = c0192bz.f476e;
        int i6 = c0192bz.f473b - 1;
        this.f432s = c0192bz.f473b == 0 ? c0192bz.f476e : -3.4028235E38f;
        this.f433t = c0192bz.f473b == iMo612b + (-1) ? (c0192bz.f476e + c0192bz.f475d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            C0192bz c0192bz7 = this.f418e.get(i7);
            float fM618d3 = f2;
            while (i6 > c0192bz7.f473b) {
                fM618d3 -= this.f421h.m618d(i6) + f;
                i6--;
            }
            f2 = fM618d3 - (c0192bz7.f475d + f);
            c0192bz7.f476e = f2;
            if (c0192bz7.f473b == 0) {
                this.f432s = f2;
            }
            i6--;
        }
        float f3 = c0192bz.f476e + c0192bz.f475d + f;
        int i8 = c0192bz.f473b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            C0192bz c0192bz8 = this.f418e.get(i9);
            float fM618d4 = f3;
            while (i8 < c0192bz8.f473b) {
                fM618d4 = this.f421h.m618d(i8) + f + fM618d4;
                i8++;
            }
            if (c0192bz8.f473b == iMo612b - 1) {
                this.f433t = (c0192bz8.f475d + fM618d4) - 1.0f;
            }
            c0192bz8.f476e = fM618d4;
            f3 = fM618d4 + c0192bz8.f475d + f;
            i8++;
        }
        this.f405T = false;
    }

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = C0073a.m244a(new C0199cf());
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.f422i;
        if (this.f421h != null) {
            savedState.adapterState = this.f421h.mo74a();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f421h != null) {
            this.f421h.mo77a(savedState.adapterState, savedState.loader);
            m415a(savedState.position, false, true);
        } else {
            this.f423j = savedState.position;
            this.f424k = savedState.adapterState;
            this.f425l = savedState.loader;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) layoutParamsGenerateLayoutParams;
        layoutParams2.f440a |= view instanceof InterfaceC0191by;
        if (this.f436w) {
            if (layoutParams2 != null && layoutParams2.f440a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f443d = true;
            addViewInLayout(view, i, layoutParamsGenerateLayoutParams);
            return;
        }
        super.addView(view, i, layoutParamsGenerateLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f436w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* renamed from: a */
    C0192bz m409a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f418e.size()) {
                C0192bz c0192bz = this.f418e.get(i2);
                if (!this.f421h.mo80a(view, c0192bz.f472a)) {
                    i = i2 + 1;
                } else {
                    return c0192bz;
                }
            } else {
                return null;
            }
        }
    }

    /* renamed from: b */
    C0192bz m423b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return m409a(view);
            }
        }
        return null;
    }

    /* renamed from: b */
    C0192bz m422b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f418e.size()) {
                C0192bz c0192bz = this.f418e.get(i3);
                if (c0192bz.f473b != i) {
                    i2 = i3 + 1;
                } else {
                    return c0192bz;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f404S = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010a A[PHI: r1
  0x010a: PHI (r1v18 int) = (r1v17 int), (r1v20 int) binds: [B:28:0x0088, B:30:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m387a(i, i3, this.f428o, this.f428o);
        }
    }

    /* renamed from: a */
    private void m387a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f418e.isEmpty()) {
            int paddingLeft = (int) ((((i - getPaddingLeft()) - getPaddingRight()) + i3) * (getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)));
            scrollTo(paddingLeft, getScrollY());
            if (!this.f426m.isFinished()) {
                this.f426m.startScroll(paddingLeft, 0, (int) (m422b(this.f422i).f476e * i), 0, this.f426m.getDuration() - this.f426m.timePassed());
                return;
            }
            return;
        }
        C0192bz c0192bzM422b = m422b(this.f422i);
        int iMin = (int) ((c0192bzM422b != null ? Math.min(c0192bzM422b.f476e, this.f433t) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m394b(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f426m.isFinished() && this.f426m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f426m.getCurrX();
            int currY = this.f426m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m400e(currX)) {
                    this.f426m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            C0159at.m638b(this);
            return;
        }
        m394b(true);
    }

    /* renamed from: e */
    private boolean m400e(int i) {
        if (this.f418e.size() == 0) {
            this.f406U = false;
            m413a(0, 0.0f, 0);
            if (this.f406U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0192bz c0192bzM405l = m405l();
        int iM403j = m403j();
        int i2 = this.f428o + iM403j;
        int i3 = c0192bzM405l.f473b;
        float f = ((i / iM403j) - c0192bzM405l.f476e) / (c0192bzM405l.f475d + (this.f428o / iM403j));
        this.f406U = false;
        m413a(i3, f, (int) (i2 * f));
        if (!this.f406U) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    /* renamed from: a */
    protected void m413a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.f407V > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f440a) {
                    switch (layoutParams.f441b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i6 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i6;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i9 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        if (this.f408W != null) {
            this.f408W.mo620a(i, f, i2);
        }
        if (this.f409Z != null) {
            this.f409Z.mo620a(i, f, i2);
        }
        if (this.f411ab != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((LayoutParams) childAt2.getLayoutParams()).f440a) {
                    this.f411ab.m699a(childAt2, (childAt2.getLeft() - scrollX2) / m403j());
                }
            }
        }
        this.f406U = true;
    }

    /* renamed from: b */
    private void m394b(boolean z) {
        boolean z2 = this.f416ah == 2;
        if (z2) {
            m399e(false);
            this.f426m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f426m.getCurrX();
            int currY = this.f426m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.f438y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f418e.size(); i++) {
            C0192bz c0192bz = this.f418e.get(i);
            if (c0192bz.f474c) {
                c0192bz.f474c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                C0159at.m636a(this, this.f415ag);
            } else {
                this.f415ag.run();
            }
        }
    }

    /* renamed from: a */
    private boolean m392a(float f, float f2) {
        return (f < ((float) this.f389D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f389D)) && f2 < 0.0f);
    }

    /* renamed from: c */
    private void m396c(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0159at.m633a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f386A = false;
            this.f387B = false;
            this.f395J = -1;
            if (this.f396K == null) {
                return false;
            }
            this.f396K.recycle();
            this.f396K = null;
            return false;
        }
        if (action != 0) {
            if (this.f386A) {
                return true;
            }
            if (this.f387B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f393H = x;
                this.f391F = x;
                float y = motionEvent.getY();
                this.f394I = y;
                this.f392G = y;
                this.f395J = C0224z.m744b(motionEvent, 0);
                this.f387B = false;
                this.f426m.computeScrollOffset();
                if (this.f416ah == 2 && Math.abs(this.f426m.getFinalX() - this.f426m.getCurrX()) > this.f400O) {
                    this.f426m.abortAnimation();
                    this.f438y = false;
                    m427e();
                    this.f386A = true;
                    m398d(true);
                    m397d(1);
                    break;
                } else {
                    m394b(false);
                    this.f386A = false;
                    break;
                }
            case 2:
                int i = this.f395J;
                if (i != -1) {
                    int iM742a = C0224z.m742a(motionEvent, i);
                    float fM745c = C0224z.m745c(motionEvent, iM742a);
                    float f = fM745c - this.f391F;
                    float fAbs = Math.abs(f);
                    float fM747d = C0224z.m747d(motionEvent, iM742a);
                    float fAbs2 = Math.abs(fM747d - this.f394I);
                    if (f != 0.0f && !m392a(this.f391F, f) && m420a(this, false, (int) f, (int) fM745c, (int) fM747d)) {
                        this.f391F = fM745c;
                        this.f392G = fM747d;
                        this.f387B = true;
                        return false;
                    }
                    if (fAbs > this.f390E && 0.5f * fAbs > fAbs2) {
                        this.f386A = true;
                        m398d(true);
                        m397d(1);
                        this.f391F = f > 0.0f ? this.f393H + this.f390E : this.f393H - this.f390E;
                        this.f392G = fM747d;
                        m399e(true);
                    } else if (fAbs2 > this.f390E) {
                        this.f387B = true;
                    }
                    if (this.f386A && m395b(fM745c)) {
                        C0159at.m638b(this);
                        break;
                    }
                }
                break;
            case 6:
                m391a(motionEvent);
                break;
        }
        if (this.f396K == null) {
            this.f396K = VelocityTracker.obtain();
        }
        this.f396K.addMovement(motionEvent);
        return this.f386A;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        boolean zM896c = false;
        if (this.f401P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f421h == null || this.f421h.mo612b() == 0) {
            return false;
        }
        if (this.f396K == null) {
            this.f396K = VelocityTracker.obtain();
        }
        this.f396K.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f426m.abortAnimation();
                this.f438y = false;
                m427e();
                float x = motionEvent.getX();
                this.f393H = x;
                this.f391F = x;
                float y = motionEvent.getY();
                this.f394I = y;
                this.f392G = y;
                this.f395J = C0224z.m744b(motionEvent, 0);
                break;
            case 1:
                if (this.f386A) {
                    VelocityTracker velocityTracker = this.f396K;
                    velocityTracker.computeCurrentVelocity(1000, this.f398M);
                    int iM625a = (int) C0154ao.m625a(velocityTracker, this.f395J);
                    this.f438y = true;
                    int iM403j = m403j();
                    int scrollX = getScrollX();
                    C0192bz c0192bzM405l = m405l();
                    m416a(m384a(c0192bzM405l.f473b, ((scrollX / iM403j) - c0192bzM405l.f476e) / c0192bzM405l.f475d, iM625a, (int) (C0224z.m745c(motionEvent, C0224z.m742a(motionEvent, this.f395J)) - this.f393H)), true, true, iM625a);
                    this.f395J = -1;
                    m406m();
                    zM896c = this.f403R.m896c() | this.f402Q.m896c();
                    break;
                }
                break;
            case 2:
                if (!this.f386A) {
                    int iM742a = C0224z.m742a(motionEvent, this.f395J);
                    float fM745c = C0224z.m745c(motionEvent, iM742a);
                    float fAbs = Math.abs(fM745c - this.f391F);
                    float fM747d = C0224z.m747d(motionEvent, iM742a);
                    float fAbs2 = Math.abs(fM747d - this.f392G);
                    if (fAbs > this.f390E && fAbs > fAbs2) {
                        this.f386A = true;
                        m398d(true);
                        this.f391F = fM745c - this.f393H > 0.0f ? this.f393H + this.f390E : this.f393H - this.f390E;
                        this.f392G = fM747d;
                        m397d(1);
                        m399e(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f386A) {
                    zM896c = false | m395b(C0224z.m745c(motionEvent, C0224z.m742a(motionEvent, this.f395J)));
                    break;
                }
                break;
            case 3:
                if (this.f386A) {
                    m388a(this.f422i, true, 0, false);
                    this.f395J = -1;
                    m406m();
                    zM896c = this.f403R.m896c() | this.f402Q.m896c();
                    break;
                }
                break;
            case 5:
                int iM743b = C0224z.m743b(motionEvent);
                this.f391F = C0224z.m745c(motionEvent, iM743b);
                this.f395J = C0224z.m744b(motionEvent, iM743b);
                break;
            case 6:
                m391a(motionEvent);
                this.f391F = C0224z.m745c(motionEvent, C0224z.m742a(motionEvent, this.f395J));
                break;
        }
        if (zM896c) {
            C0159at.m638b(this);
        }
        return true;
    }

    /* renamed from: d */
    private void m398d(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: b */
    private boolean m395b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        float f3 = this.f391F - f;
        this.f391F = f;
        float scrollX = getScrollX() + f3;
        int iM403j = m403j();
        float f4 = iM403j * this.f432s;
        float f5 = iM403j * this.f433t;
        C0192bz c0192bz = this.f418e.get(0);
        C0192bz c0192bz2 = this.f418e.get(this.f418e.size() - 1);
        if (c0192bz.f473b != 0) {
            f4 = c0192bz.f476e * iM403j;
            z = false;
        } else {
            z = true;
        }
        if (c0192bz2.f473b != this.f421h.mo612b() - 1) {
            f2 = c0192bz2.f476e * iM403j;
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                zM893a = this.f402Q.m893a(Math.abs(f4 - scrollX) / iM403j);
            }
        } else if (scrollX > f2) {
            zM893a = z2 ? this.f403R.m893a(Math.abs(scrollX - f2) / iM403j) : false;
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f391F += f4 - ((int) f4);
        scrollTo((int) f4, getScrollY());
        m400e((int) f4);
        return zM893a;
    }

    /* renamed from: l */
    private C0192bz m405l() {
        int i;
        C0192bz c0192bz;
        int iM403j = m403j();
        float scrollX = iM403j > 0 ? getScrollX() / iM403j : 0.0f;
        float f = iM403j > 0 ? this.f428o / iM403j : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        C0192bz c0192bz2 = null;
        while (i3 < this.f418e.size()) {
            C0192bz c0192bz3 = this.f418e.get(i3);
            if (z || c0192bz3.f473b == i2 + 1) {
                i = i3;
                c0192bz = c0192bz3;
            } else {
                C0192bz c0192bz4 = this.f419f;
                c0192bz4.f476e = f2 + f3 + f;
                c0192bz4.f473b = i2 + 1;
                c0192bz4.f475d = this.f421h.m618d(c0192bz4.f473b);
                i = i3 - 1;
                c0192bz = c0192bz4;
            }
            float f4 = c0192bz.f476e;
            float f5 = c0192bz.f475d + f4 + f;
            if (!z && scrollX < f4) {
                return c0192bz2;
            }
            if (scrollX < f5 || i == this.f418e.size() - 1) {
                return c0192bz;
            }
            f3 = f4;
            i2 = c0192bz.f473b;
            z = false;
            f2 = c0192bz.f475d;
            c0192bz2 = c0192bz;
            i3 = i + 1;
        }
        return c0192bz2;
    }

    /* renamed from: a */
    private int m384a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.f399N && Math.abs(i2) > this.f397L) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i = (int) ((i >= this.f422i ? 0.4f : 0.6f) + i + f);
        }
        if (this.f418e.size() > 0) {
            return Math.max(this.f418e.get(0).f473b, Math.min(i, this.f418e.get(this.f418e.size() - 1).f473b));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean zM894a = false;
        int iM631a = C0159at.m631a(this);
        if (iM631a == 0 || (iM631a == 1 && this.f421h != null && this.f421h.mo612b() > 1)) {
            if (!this.f402Q.m892a()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f432s * width);
                this.f402Q.m891a(height, width);
                zM894a = false | this.f402Q.m894a(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f403R.m892a()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f433t + 1.0f)) * width2);
                this.f403R.m891a(height2, width2);
                zM894a |= this.f403R.m894a(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f402Q.m895b();
            this.f403R.m895b();
        }
        if (zM894a) {
            C0159at.m638b(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f428o > 0 && this.f429p != null && this.f418e.size() > 0 && this.f421h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = this.f428o / width;
            C0192bz c0192bz = this.f418e.get(0);
            float f3 = c0192bz.f476e;
            int size = this.f418e.size();
            int i = c0192bz.f473b;
            int i2 = this.f418e.get(size - 1).f473b;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > c0192bz.f473b && i3 < size) {
                    i3++;
                    c0192bz = this.f418e.get(i3);
                }
                if (i4 == c0192bz.f473b) {
                    f = (c0192bz.f476e + c0192bz.f475d) * width;
                    f3 = c0192bz.f476e + c0192bz.f475d + f2;
                } else {
                    float fM618d = this.f421h.m618d(i4);
                    f = (f3 + fM618d) * width;
                    f3 += fM618d + f2;
                }
                if (this.f428o + f > scrollX) {
                    this.f429p.setBounds((int) f, this.f430q, (int) (this.f428o + f + 0.5f), this.f431r);
                    this.f429p.draw(canvas);
                }
                if (f > scrollX + width) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m391a(MotionEvent motionEvent) {
        int iM743b = C0224z.m743b(motionEvent);
        if (C0224z.m744b(motionEvent, iM743b) == this.f395J) {
            int i = iM743b == 0 ? 1 : 0;
            this.f391F = C0224z.m745c(motionEvent, i);
            this.f395J = C0224z.m744b(motionEvent, i);
            if (this.f396K != null) {
                this.f396K.clear();
            }
        }
    }

    /* renamed from: m */
    private void m406m() {
        this.f386A = false;
        this.f387B = false;
        if (this.f396K != null) {
            this.f396K.recycle();
            this.f396K = null;
        }
    }

    /* renamed from: e */
    private void m399e(boolean z) {
        if (this.f437x != z) {
            this.f437x = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f421h == null) {
            return false;
        }
        int iM403j = m403j();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) iM403j) * this.f432s));
        }
        if (i > 0) {
            return scrollX < ((int) (((float) iM403j) * this.f433t));
        }
        return false;
    }

    /* renamed from: a */
    protected boolean m420a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && m420a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && C0159at.m637a(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m419a(keyEvent);
    }

    /* renamed from: a */
    public boolean m419a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                break;
            case 22:
                break;
            case 61:
                if (Build.VERSION.SDK_INT >= 11) {
                    if (!C0217s.m729a(keyEvent)) {
                        if (C0217s.m730a(keyEvent, 1)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m425c(int r10) throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            r1 = 0
            r8 = 66
            r7 = 17
            r4 = 1
            r3 = 0
            android.view.View r2 = r9.findFocus()
            if (r2 != r9) goto L3e
            r0 = r1
        Le:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r9, r0, r10)
            if (r1 == 0) goto Lc9
            if (r1 == r0) goto Lc9
            if (r10 != r7) goto La7
            android.graphics.Rect r2 = r9.f420g
            android.graphics.Rect r2 = r9.m385a(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r9.f420g
            android.graphics.Rect r3 = r9.m385a(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto La2
            if (r2 < r3) goto La2
            boolean r0 = r9.m428f()
        L34:
            if (r0 == 0) goto L3d
            int r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r10)
            r9.playSoundEffect(r1)
        L3d:
            return r0
        L3e:
            if (r2 == 0) goto Le1
            android.view.ViewParent r0 = r2.getParent()
        L44:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto Le4
            if (r0 != r9) goto L7c
            r0 = r4
        L4b:
            if (r0 != 0) goto Le1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r5.append(r0)
            android.view.ViewParent r0 = r2.getParent()
        L61:
            boolean r2 = r0 instanceof android.view.ViewGroup
            if (r2 == 0) goto L81
            java.lang.String r2 = " => "
            java.lang.StringBuilder r2 = r5.append(r2)
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r2.append(r6)
            android.view.ViewParent r0 = r0.getParent()
            goto L61
        L7c:
            android.view.ViewParent r0 = r0.getParent()
            goto L44
        L81:
            java.lang.String r0 = "ViewPager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "arrowScroll tried to find focus based on non-child current focused view "
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r0, r2)
            r0 = r1
            goto Le
        La2:
            boolean r0 = r1.requestFocus()
            goto L34
        La7:
            if (r10 != r8) goto Lde
            android.graphics.Rect r2 = r9.f420g
            android.graphics.Rect r2 = r9.m385a(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r9.f420g
            android.graphics.Rect r3 = r9.m385a(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lc3
            if (r2 > r3) goto Lc3
            boolean r0 = r9.m429g()
            goto L34
        Lc3:
            boolean r0 = r1.requestFocus()
            goto L34
        Lc9:
            if (r10 == r7) goto Lcd
            if (r10 != r4) goto Ld3
        Lcd:
            boolean r0 = r9.m428f()
            goto L34
        Ld3:
            if (r10 == r8) goto Ld8
            r0 = 2
            if (r10 != r0) goto Lde
        Ld8:
            boolean r0 = r9.m429g()
            goto L34
        Lde:
            r0 = r3
            goto L34
        Le1:
            r0 = r2
            goto Le
        Le4:
            r0 = r3
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.m425c(int):boolean");
    }

    /* renamed from: a */
    private Rect m385a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    /* renamed from: f */
    boolean m428f() throws Resources.NotFoundException {
        if (this.f422i <= 0) {
            return false;
        }
        setCurrentItem(this.f422i - 1, true);
        return true;
    }

    /* renamed from: g */
    boolean m429g() throws Resources.NotFoundException {
        if (this.f421h == null || this.f422i >= this.f421h.mo612b() - 1) {
            return false;
        }
        setCurrentItem(this.f422i + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C0192bz c0192bzM409a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (c0192bzM409a = m409a(childAt)) != null && c0192bzM409a.f473b == this.f422i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0192bz c0192bzM409a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (c0192bzM409a = m409a(childAt)) != null && c0192bzM409a.f473b == this.f422i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        C0192bz c0192bzM409a;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (c0192bzM409a = m409a(childAt)) != null && c0192bzM409a.f473b == this.f422i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0192bz c0192bzM409a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (c0192bzM409a = m409a(childAt)) != null && c0192bzM409a.f473b == this.f422i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f440a;

        /* renamed from: b */
        public int f441b;

        /* renamed from: c */
        float f442c;

        /* renamed from: d */
        boolean f443d;

        /* renamed from: e */
        int f444e;

        /* renamed from: f */
        int f445f;

        public LayoutParams() {
            super(-1, -1);
            this.f442c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f442c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f382a);
            this.f441b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
