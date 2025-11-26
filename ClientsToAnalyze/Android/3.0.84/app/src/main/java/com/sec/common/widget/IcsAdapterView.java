package com.sec.common.widget;

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

/* loaded from: classes.dex */
public abstract class IcsAdapterView<T extends Adapter> extends ViewGroup {

    /* renamed from: A */
    @ViewDebug.ExportedProperty(category = "list")
    int f12149A;

    /* renamed from: B */
    int f12150B;

    /* renamed from: C */
    int f12151C;

    /* renamed from: D */
    long f12152D;

    /* renamed from: E */
    boolean f12153E;

    /* renamed from: a */
    private int f12154a;

    /* renamed from: b */
    private View f12155b;

    /* renamed from: c */
    private boolean f12156c;

    /* renamed from: d */
    private boolean f12157d;

    /* renamed from: e */
    private IcsAdapterView<T>.RunnableC3379l f12158e;

    /* renamed from: k */
    @ViewDebug.ExportedProperty(category = "scrolling")
    int f12159k;

    /* renamed from: l */
    int f12160l;

    /* renamed from: m */
    int f12161m;

    /* renamed from: n */
    long f12162n;

    /* renamed from: o */
    long f12163o;

    /* renamed from: p */
    boolean f12164p;

    /* renamed from: q */
    int f12165q;

    /* renamed from: r */
    boolean f12166r;

    /* renamed from: s */
    InterfaceC3378k f12167s;

    /* renamed from: t */
    AdapterView.OnItemClickListener f12168t;

    /* renamed from: u */
    InterfaceC3377j f12169u;

    /* renamed from: v */
    boolean f12170v;

    /* renamed from: w */
    @ViewDebug.ExportedProperty(category = "list")
    int f12171w;

    /* renamed from: x */
    long f12172x;

    /* renamed from: y */
    @ViewDebug.ExportedProperty(category = "list")
    int f12173y;

    /* renamed from: z */
    long f12174z;

    /* renamed from: c */
    public abstract View mo11877c();

    /* renamed from: f */
    public abstract T mo11880f();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public IcsAdapterView(Context context) {
        super(context);
        this.f12159k = 0;
        this.f12162n = Long.MIN_VALUE;
        this.f12164p = false;
        this.f12166r = false;
        this.f12171w = -1;
        this.f12172x = Long.MIN_VALUE;
        this.f12173y = -1;
        this.f12174z = Long.MIN_VALUE;
        this.f12151C = -1;
        this.f12152D = Long.MIN_VALUE;
        this.f12153E = false;
    }

    public IcsAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12159k = 0;
        this.f12162n = Long.MIN_VALUE;
        this.f12164p = false;
        this.f12166r = false;
        this.f12171w = -1;
        this.f12172x = Long.MIN_VALUE;
        this.f12173y = -1;
        this.f12174z = Long.MIN_VALUE;
        this.f12151C = -1;
        this.f12152D = Long.MIN_VALUE;
        this.f12153E = false;
    }

    public IcsAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12159k = 0;
        this.f12162n = Long.MIN_VALUE;
        this.f12164p = false;
        this.f12166r = false;
        this.f12171w = -1;
        this.f12172x = Long.MIN_VALUE;
        this.f12173y = -1;
        this.f12174z = Long.MIN_VALUE;
        this.f12151C = -1;
        this.f12152D = Long.MIN_VALUE;
        this.f12153E = false;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12168t = onItemClickListener;
    }

    public void setOnItemLongClickListener(InterfaceC3377j interfaceC3377j) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f12169u = interfaceC3377j;
    }

    public void setOnItemSelectedListener(InterfaceC3378k interfaceC3378k) {
        this.f12167s = interfaceC3378k;
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
        this.f12154a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: g */
    public int m11891g() {
        return this.f12171w;
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: h */
    public long m11892h() {
        return this.f12172x;
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: e */
    public int mo11879e() {
        return this.f12149A;
    }

    /* renamed from: i */
    public int m11893i() {
        return this.f12159k;
    }

    /* renamed from: j */
    public int m11894j() {
        return (this.f12159k + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f12155b = view;
        Adapter adapterMo11880f = mo11880f();
        m11884a(adapterMo11880f == null || adapterMo11880f.isEmpty());
    }

    /* renamed from: k */
    boolean m11895k() {
        return false;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapterMo11880f = mo11880f();
        boolean z3 = adapterMo11880f == null || adapterMo11880f.getCount() == 0;
        this.f12156c = z;
        if (!z) {
            this.f12157d = false;
        }
        if (!z || (z3 && !m11895k())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapterMo11880f = mo11880f();
        boolean z3 = adapterMo11880f == null || adapterMo11880f.getCount() == 0;
        this.f12157d = z;
        if (z) {
            this.f12156c = true;
        }
        if (!z || (z3 && !m11895k())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* renamed from: l */
    void m11896l() {
        Adapter adapterMo11880f = mo11880f();
        boolean z = !(adapterMo11880f == null || adapterMo11880f.getCount() == 0) || m11895k();
        super.setFocusableInTouchMode(z && this.f12157d);
        super.setFocusable(z && this.f12156c);
        if (this.f12155b != null) {
            m11884a(adapterMo11880f == null || adapterMo11880f.isEmpty());
        }
    }

    /* renamed from: a */
    private void m11884a(boolean z) {
        if (m11895k()) {
            z = false;
        }
        if (z) {
            if (this.f12155b != null) {
                this.f12155b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f12170v) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f12155b != null) {
            this.f12155b.setVisibility(8);
        }
        setVisibility(0);
    }

    /* renamed from: a */
    public long m11887a(int i) {
        Adapter adapterMo11880f = mo11880f();
        if (adapterMo11880f == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapterMo11880f.getItemId(i);
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
        removeCallbacks(this.f12158e);
    }

    /* compiled from: IcsAdapterView.java */
    /* renamed from: com.sec.common.widget.l */
    class RunnableC3379l implements Runnable {
        private RunnableC3379l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!IcsAdapterView.this.f12170v) {
                IcsAdapterView.this.m11882a();
            } else if (IcsAdapterView.this.mo11880f() != null) {
                IcsAdapterView.this.post(this);
            }
        }
    }

    /* renamed from: m */
    void m11897m() {
        if (this.f12167s != null) {
            if (this.f12166r || this.f12153E) {
                if (this.f12158e == null) {
                    this.f12158e = new RunnableC3379l();
                }
                post(this.f12158e);
            } else {
                m11882a();
            }
        }
        if (this.f12173y != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11882a() {
        if (this.f12167s != null) {
            int iM11891g = m11891g();
            if (iM11891g >= 0) {
                this.f12167s.mo11561a(this, mo11877c(), iM11891g, mo11880f().getItemId(iM11891g));
            } else {
                this.f12167s.mo11560a(this);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View viewMo11877c = mo11877c();
        return viewMo11877c != null && viewMo11877c.getVisibility() == 0 && viewMo11877c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
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
        accessibilityNodeInfo.setScrollable(m11886b());
        View viewMo11877c = mo11877c();
        if (viewMo11877c != null) {
            accessibilityNodeInfo.setEnabled(viewMo11877c.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(m11886b());
        View viewMo11877c = mo11877c();
        if (viewMo11877c != null) {
            accessibilityEvent.setEnabled(viewMo11877c.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(m11891g());
        accessibilityEvent.setFromIndex(m11893i());
        accessibilityEvent.setToIndex(m11894j());
        accessibilityEvent.setItemCount(mo11879e());
    }

    /* renamed from: b */
    private boolean m11886b() {
        int count;
        Adapter adapterMo11880f = mo11880f();
        if (adapterMo11880f == null || (count = adapterMo11880f.getCount()) <= 0) {
            return false;
        }
        return m11893i() > 0 || m11894j() < count + (-1);
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.f12149A > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m11898n() {
        /*
            r8 = this;
            r6 = -9223372036854775808
            r5 = -1
            r2 = 1
            r1 = 0
            int r4 = r8.f12149A
            if (r4 <= 0) goto L55
            boolean r0 = r8.f12164p
            if (r0 == 0) goto L53
            r8.f12164p = r1
            int r0 = r8.m11900p()
            if (r0 < 0) goto L53
            int r3 = r8.m11889c(r0, r2)
            if (r3 != r0) goto L53
            r8.m11890c(r0)
            r3 = r2
        L1f:
            if (r3 != 0) goto L4f
            int r0 = r8.m11891g()
            if (r0 < r4) goto L29
            int r0 = r4 + (-1)
        L29:
            if (r0 >= 0) goto L2c
            r0 = r1
        L2c:
            int r4 = r8.m11889c(r0, r2)
            if (r4 >= 0) goto L51
            int r0 = r8.m11889c(r0, r1)
        L36:
            if (r0 < 0) goto L4f
            r8.m11890c(r0)
            r8.m11899o()
            r0 = r2
        L3f:
            if (r0 != 0) goto L4e
            r8.f12173y = r5
            r8.f12174z = r6
            r8.f12171w = r5
            r8.f12172x = r6
            r8.f12164p = r1
            r8.m11899o()
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.widget.IcsAdapterView.m11898n():void");
    }

    /* renamed from: o */
    void m11899o() {
        if (this.f12173y != this.f12151C || this.f12174z != this.f12152D) {
            m11897m();
            this.f12151C = this.f12173y;
            this.f12152D = this.f12174z;
        }
    }

    /* renamed from: p */
    int m11900p() {
        int i = this.f12149A;
        if (i == 0) {
            return -1;
        }
        long j = this.f12162n;
        int i2 = this.f12161m;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int iMin = Math.min(i - 1, Math.max(0, i2));
        long jUptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapterMo11880f = mo11880f();
        if (adapterMo11880f == null) {
            return -1;
        }
        int i3 = iMin;
        int i4 = iMin;
        int i5 = iMin;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= jUptimeMillis) {
            if (adapterMo11880f.getItemId(i5) != j) {
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
    int m11889c(int i, boolean z) {
        return i;
    }

    /* renamed from: b */
    void m11888b(int i) {
        this.f12173y = i;
        this.f12174z = m11887a(i);
    }

    /* renamed from: c */
    void m11890c(int i) {
        this.f12171w = i;
        this.f12172x = m11887a(i);
        if (this.f12164p && this.f12165q == 0 && i >= 0) {
            this.f12161m = i;
            this.f12162n = this.f12172x;
        }
    }

    /* renamed from: q */
    void m11901q() {
        if (getChildCount() > 0) {
            this.f12164p = true;
            this.f12163o = this.f12154a;
            if (this.f12173y >= 0) {
                View childAt = getChildAt(this.f12173y - this.f12159k);
                this.f12162n = this.f12172x;
                this.f12161m = this.f12171w;
                if (childAt != null) {
                    this.f12160l = childAt.getTop();
                }
                this.f12165q = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapterMo11880f = mo11880f();
            if (this.f12159k >= 0 && this.f12159k < adapterMo11880f.getCount()) {
                this.f12162n = adapterMo11880f.getItemId(this.f12159k);
            } else {
                this.f12162n = -1L;
            }
            this.f12161m = this.f12159k;
            if (childAt2 != null) {
                this.f12160l = childAt2.getTop();
            }
            this.f12165q = 1;
        }
    }
}
