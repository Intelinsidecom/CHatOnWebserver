package com.sec.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.AdapterView;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public abstract class IcsAdapterView<T extends Adapter> extends ViewGroup {

    /* renamed from: A */
    @ViewDebug.ExportedProperty(category = "list")
    int f18419A;

    /* renamed from: B */
    int f18420B;

    /* renamed from: C */
    int f18421C;

    /* renamed from: D */
    long f18422D;

    /* renamed from: E */
    boolean f18423E;

    /* renamed from: a */
    private int f18424a;

    /* renamed from: b */
    private View f18425b;

    /* renamed from: c */
    private boolean f18426c;

    /* renamed from: d */
    private boolean f18427d;

    /* renamed from: e */
    private IcsAdapterView<T>.RunnableC5063h f18428e;

    /* renamed from: k */
    @ViewDebug.ExportedProperty(category = "scrolling")
    int f18429k;

    /* renamed from: l */
    int f18430l;

    /* renamed from: m */
    int f18431m;

    /* renamed from: n */
    long f18432n;

    /* renamed from: o */
    long f18433o;

    /* renamed from: p */
    boolean f18434p;

    /* renamed from: q */
    int f18435q;

    /* renamed from: r */
    boolean f18436r;

    /* renamed from: s */
    InterfaceC5062g f18437s;

    /* renamed from: t */
    AdapterView.OnItemClickListener f18438t;

    /* renamed from: u */
    InterfaceC5061f f18439u;

    /* renamed from: v */
    boolean f18440v;

    /* renamed from: w */
    @ViewDebug.ExportedProperty(category = "list")
    int f18441w;

    /* renamed from: x */
    long f18442x;

    /* renamed from: y */
    @ViewDebug.ExportedProperty(category = "list")
    int f18443y;

    /* renamed from: z */
    long f18444z;

    /* renamed from: c */
    public abstract View mo19219c();

    /* renamed from: f */
    public abstract T mo19222f();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public IcsAdapterView(Context context) {
        super(context);
        this.f18429k = 0;
        this.f18432n = Long.MIN_VALUE;
        this.f18434p = false;
        this.f18436r = false;
        this.f18441w = -1;
        this.f18442x = Long.MIN_VALUE;
        this.f18443y = -1;
        this.f18444z = Long.MIN_VALUE;
        this.f18421C = -1;
        this.f18422D = Long.MIN_VALUE;
        this.f18423E = false;
    }

    public IcsAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18429k = 0;
        this.f18432n = Long.MIN_VALUE;
        this.f18434p = false;
        this.f18436r = false;
        this.f18441w = -1;
        this.f18442x = Long.MIN_VALUE;
        this.f18443y = -1;
        this.f18444z = Long.MIN_VALUE;
        this.f18421C = -1;
        this.f18422D = Long.MIN_VALUE;
        this.f18423E = false;
    }

    public IcsAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18429k = 0;
        this.f18432n = Long.MIN_VALUE;
        this.f18434p = false;
        this.f18436r = false;
        this.f18441w = -1;
        this.f18442x = Long.MIN_VALUE;
        this.f18443y = -1;
        this.f18444z = Long.MIN_VALUE;
        this.f18421C = -1;
        this.f18422D = Long.MIN_VALUE;
        this.f18423E = false;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f18438t = onItemClickListener;
    }

    public void setOnItemLongClickListener(InterfaceC5061f interfaceC5061f) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f18439u = interfaceC5061f;
    }

    public void setOnItemSelectedListener(InterfaceC5062g interfaceC5062g) {
        this.f18437s = interfaceC5062g;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f18424a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: g */
    public int m19233g() {
        return this.f18441w;
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: h */
    public long m19234h() {
        return this.f18442x;
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: e */
    public int mo19221e() {
        return this.f18419A;
    }

    /* renamed from: i */
    public int m19235i() {
        return this.f18429k;
    }

    /* renamed from: j */
    public int m19236j() {
        return (this.f18429k + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f18425b = view;
        Adapter adapterMo19222f = mo19222f();
        m19226a(adapterMo19222f == null || adapterMo19222f.isEmpty());
    }

    /* renamed from: k */
    boolean m19237k() {
        return false;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapterMo19222f = mo19222f();
        boolean z3 = adapterMo19222f == null || adapterMo19222f.getCount() == 0;
        this.f18426c = z;
        if (!z) {
            this.f18427d = false;
        }
        if (!z || (z3 && !m19237k())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapterMo19222f = mo19222f();
        boolean z3 = adapterMo19222f == null || adapterMo19222f.getCount() == 0;
        this.f18427d = z;
        if (z) {
            this.f18426c = true;
        }
        if (!z || (z3 && !m19237k())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* renamed from: l */
    void m19238l() {
        Adapter adapterMo19222f = mo19222f();
        boolean z = !(adapterMo19222f == null || adapterMo19222f.getCount() == 0) || m19237k();
        super.setFocusableInTouchMode(z && this.f18427d);
        super.setFocusable(z && this.f18426c);
        if (this.f18425b != null) {
            m19226a(adapterMo19222f == null || adapterMo19222f.isEmpty());
        }
    }

    /* renamed from: a */
    private void m19226a(boolean z) {
        if (m19237k()) {
            z = false;
        }
        if (z) {
            if (this.f18425b != null) {
                this.f18425b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f18440v) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f18425b != null) {
            this.f18425b.setVisibility(8);
        }
        setVisibility(0);
    }

    /* renamed from: a */
    public long m19229a(int i) {
        Adapter adapterMo19222f = mo19222f();
        if (adapterMo19222f == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapterMo19222f.getItemId(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f18428e);
    }

    /* compiled from: IcsAdapterView.java */
    /* renamed from: com.sec.common.widget.h */
    class RunnableC5063h implements Runnable {
        private RunnableC5063h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!IcsAdapterView.this.f18440v) {
                IcsAdapterView.this.m19224a();
            } else if (IcsAdapterView.this.mo19222f() != null) {
                IcsAdapterView.this.post(this);
            }
        }
    }

    /* renamed from: m */
    void m19239m() {
        if (this.f18437s != null) {
            if (this.f18436r || this.f18423E) {
                if (this.f18428e == null) {
                    this.f18428e = new RunnableC5063h();
                }
                post(this.f18428e);
            } else {
                m19224a();
            }
        }
        if (this.f18443y != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19224a() {
        if (this.f18437s != null) {
            int iM19233g = m19233g();
            if (iM19233g >= 0) {
                this.f18437s.mo18802a(this, mo19219c(), iM19233g, mo19222f().getItemId(iM19233g));
            } else {
                this.f18437s.mo18801a(this);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View viewMo19219c = mo19219c();
        return viewMo19219c != null && viewMo19219c.getVisibility() == 0 && viewMo19219c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        view.dispatchPopulateAccessibilityEvent(accessibilityEventObtain);
        accessibilityEvent.appendRecord(accessibilityEventObtain);
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setScrollable(m19228b());
        View viewMo19219c = mo19219c();
        if (viewMo19219c != null) {
            accessibilityNodeInfo.setEnabled(viewMo19219c.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(m19228b());
        View viewMo19219c = mo19219c();
        if (viewMo19219c != null) {
            accessibilityEvent.setEnabled(viewMo19219c.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(m19233g());
        accessibilityEvent.setFromIndex(m19235i());
        accessibilityEvent.setToIndex(m19236j());
        accessibilityEvent.setItemCount(mo19221e());
    }

    /* renamed from: b */
    private boolean m19228b() {
        int count;
        Adapter adapterMo19222f = mo19222f();
        if (adapterMo19222f == null || (count = adapterMo19222f.getCount()) <= 0) {
            return false;
        }
        return m19235i() > 0 || m19236j() < count + (-1);
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.f18419A > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m19240n() {
        /*
            r8 = this;
            r6 = -9223372036854775808
            r5 = -1
            r2 = 1
            r1 = 0
            int r4 = r8.f18419A
            if (r4 <= 0) goto L55
            boolean r0 = r8.f18434p
            if (r0 == 0) goto L53
            r8.f18434p = r1
            int r0 = r8.m19242p()
            if (r0 < 0) goto L53
            int r3 = r8.m19231c(r0, r2)
            if (r3 != r0) goto L53
            r8.m19232c(r0)
            r3 = r2
        L1f:
            if (r3 != 0) goto L4f
            int r0 = r8.m19233g()
            if (r0 < r4) goto L29
            int r0 = r4 + (-1)
        L29:
            if (r0 >= 0) goto L2c
            r0 = r1
        L2c:
            int r4 = r8.m19231c(r0, r2)
            if (r4 >= 0) goto L51
            int r0 = r8.m19231c(r0, r1)
        L36:
            if (r0 < 0) goto L4f
            r8.m19232c(r0)
            r8.m19241o()
            r0 = r2
        L3f:
            if (r0 != 0) goto L4e
            r8.f18443y = r5
            r8.f18444z = r6
            r8.f18441w = r5
            r8.f18442x = r6
            r8.f18434p = r1
            r8.m19241o()
        L4e:
            return
        L4f:
            r0 = r3
            goto L3f
        L51:
            r0 = r4
            goto L36
        L53:
            r3 = r1
            goto L1f
        L55:
            r0 = r1
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.widget.IcsAdapterView.m19240n():void");
    }

    /* renamed from: o */
    void m19241o() {
        if (this.f18443y != this.f18421C || this.f18444z != this.f18422D) {
            m19239m();
            this.f18421C = this.f18443y;
            this.f18422D = this.f18444z;
        }
    }

    /* renamed from: p */
    int m19242p() {
        int i = this.f18419A;
        if (i == 0) {
            return -1;
        }
        long j = this.f18432n;
        int i2 = this.f18431m;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int iMin = Math.min(i - 1, Math.max(0, i2));
        long jUptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapterMo19222f = mo19222f();
        if (adapterMo19222f == null) {
            return -1;
        }
        int i3 = iMin;
        int i4 = iMin;
        int i5 = iMin;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= jUptimeMillis) {
            if (adapterMo19222f.getItemId(i5) != j) {
                boolean z2 = i3 == i + (-1);
                boolean z3 = i4 == 0;
                if (z2 && z3) {
                    break;
                }
                if (z3 || (z && !z2)) {
                    int i6 = i3 + 1;
                    i3 = i6;
                    i5 = i6;
                    z = false;
                } else if (z2 || (!z && !z3)) {
                    int i7 = i4 - 1;
                    i4 = i7;
                    i5 = i7;
                    z = true;
                }
            } else {
                return i5;
            }
        }
        return -1;
    }

    /* renamed from: c */
    int m19231c(int i, boolean z) {
        return i;
    }

    /* renamed from: b */
    void m19230b(int i) {
        this.f18443y = i;
        this.f18444z = m19229a(i);
    }

    /* renamed from: c */
    void m19232c(int i) {
        this.f18441w = i;
        this.f18442x = m19229a(i);
        if (this.f18434p && this.f18435q == 0 && i >= 0) {
            this.f18431m = i;
            this.f18432n = this.f18442x;
        }
    }

    /* renamed from: q */
    void m19243q() {
        if (getChildCount() > 0) {
            this.f18434p = true;
            this.f18433o = this.f18424a;
            if (this.f18443y >= 0) {
                View childAt = getChildAt(this.f18443y - this.f18429k);
                this.f18432n = this.f18442x;
                this.f18431m = this.f18441w;
                if (childAt != null) {
                    this.f18430l = childAt.getTop();
                }
                this.f18435q = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapterMo19222f = mo19222f();
            if (this.f18429k >= 0 && this.f18429k < adapterMo19222f.getCount()) {
                this.f18432n = adapterMo19222f.getItemId(this.f18429k);
            } else {
                this.f18432n = -1L;
            }
            this.f18431m = this.f18429k;
            if (childAt2 != null) {
                this.f18430l = childAt2.getTop();
            }
            this.f18435q = 1;
        }
    }
}
