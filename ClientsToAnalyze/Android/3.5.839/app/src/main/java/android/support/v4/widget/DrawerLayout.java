package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.C0159at;
import android.support.v4.view.C0181bo;
import android.support.v4.view.C0212n;
import android.support.v4.view.C0217s;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: a */
    private static final int[] f494a = {R.attr.layout_gravity};

    /* renamed from: b */
    private int f495b;

    /* renamed from: c */
    private int f496c;

    /* renamed from: d */
    private float f497d;

    /* renamed from: e */
    private Paint f498e;

    /* renamed from: f */
    private final C0238am f499f;

    /* renamed from: g */
    private final C0238am f500g;

    /* renamed from: h */
    private final C0252l f501h;

    /* renamed from: i */
    private final C0252l f502i;

    /* renamed from: j */
    private int f503j;

    /* renamed from: k */
    private boolean f504k;

    /* renamed from: l */
    private boolean f505l;

    /* renamed from: m */
    private int f506m;

    /* renamed from: n */
    private int f507n;

    /* renamed from: o */
    private boolean f508o;

    /* renamed from: p */
    private boolean f509p;

    /* renamed from: q */
    private InterfaceC0250j f510q;

    /* renamed from: r */
    private float f511r;

    /* renamed from: s */
    private float f512s;

    /* renamed from: t */
    private Drawable f513t;

    /* renamed from: u */
    private Drawable f514u;

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f496c = -1728053248;
        this.f498e = new Paint();
        this.f505l = true;
        float f = getResources().getDisplayMetrics().density;
        this.f495b = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        this.f501h = new C0252l(this, 3);
        this.f502i = new C0252l(this, 5);
        this.f499f = C0238am.m827a(this, 1.0f, this.f501h);
        this.f499f.m846a(1);
        this.f499f.m845a(f2);
        this.f501h.m890a(this.f499f);
        this.f500g = C0238am.m827a(this, 1.0f, this.f502i);
        this.f500g.m846a(2);
        this.f500g.m845a(f2);
        this.f502i.m890a(this.f500g);
        setFocusableInTouchMode(true);
        C0159at.m635a(this, new C0249i(this));
        C0181bo.m687a(this, false);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        int iM726a = C0212n.m726a(i, C0159at.m642e(this));
        if ((iM726a & 3) == 3) {
            this.f513t = drawable;
            invalidate();
        }
        if ((iM726a & 5) == 5) {
            this.f514u = drawable;
            invalidate();
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(getResources().getDrawable(i), i2);
    }

    public void setScrimColor(int i) {
        this.f496c = i;
        invalidate();
    }

    public void setDrawerListener(InterfaceC0250j interfaceC0250j) {
        this.f510q = interfaceC0250j;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int iM726a = C0212n.m726a(i2, C0159at.m642e(this));
        if (iM726a == 3) {
            this.f506m = i;
        } else if (iM726a == 5) {
            this.f507n = i;
        }
        if (i != 0) {
            (iM726a == 3 ? this.f499f : this.f500g).m864e();
        }
        switch (i) {
            case 1:
                View viewM761a = m761a(iM726a);
                if (viewM761a != null) {
                    m776i(viewM761a);
                    break;
                }
                break;
            case 2:
                View viewM761a2 = m761a(iM726a);
                if (viewM761a2 != null) {
                    m775h(viewM761a2);
                    break;
                }
                break;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (!m774g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
        }
        setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).f515a);
    }

    /* renamed from: a */
    public int m759a(View view) {
        int iM772e = m772e(view);
        if (iM772e == 3) {
            return this.f506m;
        }
        if (iM772e == 5) {
            return this.f507n;
        }
        return 0;
    }

    /* renamed from: a */
    void m762a(int i, int i2, View view) {
        int i3 = 1;
        int iM844a = this.f499f.m844a();
        int iM844a2 = this.f500g.m844a();
        if (iM844a != 1 && iM844a2 != 1) {
            i3 = (iM844a == 2 || iM844a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f516b == 0.0f) {
                m767b(view);
            } else if (layoutParams.f516b == 1.0f) {
                m770c(view);
            }
        }
        if (i3 != this.f503j) {
            this.f503j = i3;
            if (this.f510q != null) {
                this.f510q.mo66a(i3);
            }
        }
    }

    /* renamed from: b */
    void m767b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f518d) {
            layoutParams.f518d = false;
            if (this.f510q != null) {
                this.f510q.mo70b(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    /* renamed from: c */
    void m770c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f518d) {
            layoutParams.f518d = true;
            if (this.f510q != null) {
                this.f510q.mo67a(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    /* renamed from: a */
    void m763a(View view, float f) {
        if (this.f510q != null) {
            this.f510q.mo68a(view, f);
        }
    }

    /* renamed from: b */
    void m768b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f516b) {
            layoutParams.f516b = f;
            m763a(view, f);
        }
    }

    /* renamed from: d */
    float m771d(View view) {
        return ((LayoutParams) view.getLayoutParams()).f516b;
    }

    /* renamed from: e */
    int m772e(View view) {
        return C0212n.m726a(((LayoutParams) view.getLayoutParams()).f515a, C0159at.m642e(this));
    }

    /* renamed from: a */
    boolean m765a(View view, int i) {
        return (m772e(view) & i) == i;
    }

    /* renamed from: a */
    View m760a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f518d) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    View m761a(int i) {
        int iM726a = C0212n.m726a(i, C0159at.m642e(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m772e(childAt) & 7) == iM726a) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: b */
    static String m753b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f505l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f505l = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[PHI: r2
  0x0046: PHI (r2v14 int) = (r2v2 int), (r2v0 int) binds: [B:17:0x0044, B:4:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        this.f504k = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m773f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m765a(childAt, 3)) {
                        i5 = ((int) (measuredWidth * layoutParams.f516b)) + (-measuredWidth);
                        f = (measuredWidth + i5) / measuredWidth;
                    } else {
                        i5 = i6 - ((int) (measuredWidth * layoutParams.f516b));
                        f = (i6 - i5) / measuredWidth;
                    }
                    boolean z2 = f != layoutParams.f516b;
                    switch (layoutParams.f515a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < layoutParams.topMargin) {
                                i9 = layoutParams.topMargin;
                            } else if (i9 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i9 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z2) {
                        m768b(childAt, f);
                    }
                    int i11 = layoutParams.f516b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        this.f504k = false;
        this.f505l = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f504k) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i).getLayoutParams()).f516b);
        }
        this.f497d = fMax;
        if (this.f499f.m851a(true) | this.f500g.m851a(true)) {
            C0159at.m638b(this);
        }
    }

    /* renamed from: l */
    private static boolean m758l(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean drawChild(android.graphics.Canvas r10, android.view.View r11, long r12) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    /* renamed from: f */
    boolean m773f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f515a == 0;
    }

    /* renamed from: g */
    boolean m774g(View view) {
        return (C0212n.m726a(((LayoutParams) view.getLayoutParams()).f515a, C0159at.m642e(view)) & 7) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0016  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int r0 = android.support.v4.view.C0224z.m741a(r8)
            android.support.v4.widget.am r3 = r7.f499f
            boolean r3 = r3.m849a(r8)
            android.support.v4.widget.am r4 = r7.f500g
            boolean r4 = r4.m849a(r8)
            r3 = r3 | r4
            switch(r0) {
                case 0: goto L27;
                case 1: goto L63;
                case 2: goto L4e;
                case 3: goto L63;
                default: goto L16;
            }
        L16:
            r0 = r2
        L17:
            if (r3 != 0) goto L25
            if (r0 != 0) goto L25
            boolean r0 = r7.m755e()
            if (r0 != 0) goto L25
            boolean r0 = r7.f509p
            if (r0 == 0) goto L26
        L25:
            r2 = r1
        L26:
            return r2
        L27:
            float r0 = r8.getX()
            float r4 = r8.getY()
            r7.f511r = r0
            r7.f512s = r4
            float r5 = r7.f497d
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L6b
            android.support.v4.widget.am r5 = r7.f499f
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r0 = r5.m862d(r0, r4)
            boolean r0 = r7.m773f(r0)
            if (r0 == 0) goto L6b
            r0 = r1
        L49:
            r7.f508o = r2
            r7.f509p = r2
            goto L17
        L4e:
            android.support.v4.widget.am r0 = r7.f499f
            r4 = 3
            boolean r0 = r0.m863d(r4)
            if (r0 == 0) goto L16
            android.support.v4.widget.l r0 = r7.f501h
            r0.m889a()
            android.support.v4.widget.l r0 = r7.f502i
            r0.m889a()
            r0 = r2
            goto L17
        L63:
            r7.m764a(r1)
            r7.f508o = r2
            r7.f509p = r2
            goto L16
        L6b:
            r0 = r2
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewM760a;
        this.f499f.m853b(motionEvent);
        this.f500g.m853b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f511r = x;
                this.f512s = y;
                this.f508o = false;
                this.f509p = false;
                return true;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View viewM862d = this.f499f.m862d((int) x2, (int) y2);
                if (viewM862d != null && m773f(viewM862d)) {
                    float f = x2 - this.f511r;
                    float f2 = y2 - this.f512s;
                    int iM861d = this.f499f.m861d();
                    z = (f * f) + (f2 * f2) >= ((float) (iM861d * iM861d)) || (viewM760a = m760a()) == null || m759a(viewM760a) == 2;
                    m764a(z);
                    this.f508o = false;
                } else {
                    z = true;
                    m764a(z);
                    this.f508o = false;
                }
                return true;
            case 2:
            default:
                return true;
            case 3:
                m764a(true);
                this.f508o = false;
                this.f509p = false;
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f508o = z;
        if (z) {
            m764a(true);
        }
    }

    /* renamed from: b */
    public void m766b() {
        m764a(false);
    }

    /* renamed from: a */
    void m764a(boolean z) {
        int childCount = getChildCount();
        boolean zM850a = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m774g(childAt) && (!z || layoutParams.f517c)) {
                int width = childAt.getWidth();
                if (m765a(childAt, 3)) {
                    zM850a |= this.f499f.m850a(childAt, -width, childAt.getTop());
                } else {
                    zM850a |= this.f500g.m850a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f517c = false;
            }
        }
        this.f501h.m889a();
        this.f502i.m889a();
        if (zM850a) {
            invalidate();
        }
    }

    /* renamed from: h */
    public void m775h(View view) {
        if (!m774g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f505l) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f516b = 1.0f;
            layoutParams.f518d = true;
        } else if (m765a(view, 3)) {
            this.f499f.m850a(view, 0, view.getTop());
        } else {
            this.f500g.m850a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    /* renamed from: i */
    public void m776i(View view) {
        if (!m774g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f505l) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f516b = 0.0f;
            layoutParams.f518d = false;
        } else if (m765a(view, 3)) {
            this.f499f.m850a(view, -view.getWidth(), view.getTop());
        } else {
            this.f500g.m850a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    /* renamed from: j */
    public boolean m777j(View view) {
        if (!m774g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return ((LayoutParams) view.getLayoutParams()).f518d;
    }

    /* renamed from: k */
    public boolean m778k(View view) {
        if (m774g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f516b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: e */
    private boolean m755e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f517c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: f */
    private boolean m756f() {
        return m757g() != null;
    }

    /* renamed from: g */
    private View m757g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m774g(childAt) && m778k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: c */
    void m769c() {
        if (!this.f509p) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(motionEventObtain);
            }
            motionEventObtain.recycle();
            this.f509p = true;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m756f()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0217s.m731b(keyEvent);
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View viewM757g = m757g();
            if (viewM757g != null && m759a(viewM757g) == 0) {
                m766b();
            }
            return viewM757g != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewM761a;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0 && (viewM761a = m761a(savedState.openDrawerGravity)) != null) {
            m775h(viewM761a);
        }
        setDrawerLockMode(savedState.lockModeLeft, 3);
        setDrawerLockMode(savedState.lockModeRight, 5);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (m774g(childAt)) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f518d) {
                    savedState.openDrawerGravity = layoutParams.f515a;
                    break;
                }
            }
            i++;
        }
        savedState.lockModeLeft = this.f506m;
        savedState.lockModeRight = this.f507n;
        return savedState;
    }

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0251k();
        int lockModeLeft;
        int lockModeRight;
        int openDrawerGravity;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.openDrawerGravity = 0;
            this.lockModeLeft = 0;
            this.lockModeRight = 0;
            this.openDrawerGravity = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
            this.lockModeLeft = 0;
            this.lockModeRight = 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.openDrawerGravity);
        }
    }

    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f515a;

        /* renamed from: b */
        float f516b;

        /* renamed from: c */
        boolean f517c;

        /* renamed from: d */
        boolean f518d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f515a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f494a);
            this.f515a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f515a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f515a = 0;
            this.f515a = layoutParams.f515a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f515a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f515a = 0;
        }
    }
}
