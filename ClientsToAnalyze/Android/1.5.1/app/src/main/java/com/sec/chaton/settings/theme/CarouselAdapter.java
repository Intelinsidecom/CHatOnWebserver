package com.sec.chaton.settings.theme;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public abstract class CarouselAdapter extends ViewGroup {

    /* renamed from: a */
    @ViewDebug.ExportedProperty
    int f3223a;

    /* renamed from: b */
    int f3224b;

    /* renamed from: c */
    int f3225c;

    /* renamed from: d */
    long f3226d;

    /* renamed from: e */
    long f3227e;

    /* renamed from: f */
    boolean f3228f;

    /* renamed from: g */
    int f3229g;

    /* renamed from: h */
    boolean f3230h;

    /* renamed from: i */
    OnItemSelectedListener f3231i;

    /* renamed from: j */
    OnItemClickListener f3232j;

    /* renamed from: k */
    OnItemLongClickListener f3233k;

    /* renamed from: l */
    boolean f3234l;

    /* renamed from: m */
    @ViewDebug.ExportedProperty
    int f3235m;

    /* renamed from: n */
    long f3236n;

    /* renamed from: o */
    @ViewDebug.ExportedProperty
    int f3237o;

    /* renamed from: p */
    long f3238p;

    /* renamed from: q */
    @ViewDebug.ExportedProperty
    int f3239q;

    /* renamed from: r */
    int f3240r;

    /* renamed from: s */
    int f3241s;

    /* renamed from: t */
    long f3242t;

    /* renamed from: u */
    boolean f3243u;

    /* renamed from: v */
    private int f3244v;

    /* renamed from: w */
    private View f3245w;

    /* renamed from: x */
    private boolean f3246x;

    /* renamed from: y */
    private boolean f3247y;

    /* renamed from: z */
    private HandlerC0512c f3248z;

    public class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {

        /* renamed from: a */
        public View f3249a;

        /* renamed from: b */
        public int f3250b;

        /* renamed from: c */
        public long f3251c;

        public AdapterContextMenuInfo(View view, int i, long j) {
            this.f3249a = view;
            this.f3250b = i;
            this.f3251c = j;
        }
    }

    public interface OnItemClickListener {
        /* renamed from: a */
        void mo3220a(CarouselAdapter carouselAdapter, View view, int i, long j);
    }

    public interface OnItemLongClickListener {
        /* renamed from: a */
        boolean m3260a(CarouselAdapter carouselAdapter, View view, int i, long j);
    }

    public interface OnItemSelectedListener {
        /* renamed from: a */
        void mo3193a(CarouselAdapter carouselAdapter);

        /* renamed from: a */
        void mo3194a(CarouselAdapter carouselAdapter, View view, int i, long j);
    }

    public CarouselAdapter(Context context) {
        super(context);
        this.f3223a = 0;
        this.f3226d = Long.MIN_VALUE;
        this.f3228f = false;
        this.f3230h = false;
        this.f3235m = -1;
        this.f3236n = Long.MIN_VALUE;
        this.f3237o = -1;
        this.f3238p = Long.MIN_VALUE;
        this.f3241s = -1;
        this.f3242t = Long.MIN_VALUE;
        this.f3243u = false;
    }

    public CarouselAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3223a = 0;
        this.f3226d = Long.MIN_VALUE;
        this.f3228f = false;
        this.f3230h = false;
        this.f3235m = -1;
        this.f3236n = Long.MIN_VALUE;
        this.f3237o = -1;
        this.f3238p = Long.MIN_VALUE;
        this.f3241s = -1;
        this.f3242t = Long.MIN_VALUE;
        this.f3243u = false;
    }

    public CarouselAdapter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3223a = 0;
        this.f3226d = Long.MIN_VALUE;
        this.f3228f = false;
        this.f3230h = false;
        this.f3235m = -1;
        this.f3236n = Long.MIN_VALUE;
        this.f3237o = -1;
        this.f3238p = Long.MIN_VALUE;
        this.f3241s = -1;
        this.f3242t = Long.MIN_VALUE;
        this.f3243u = false;
    }

    /* renamed from: a */
    private void m3241a(boolean z) {
        if (!(m3254g() ? false : z)) {
            if (this.f3245w != null) {
                this.f3245w.setVisibility(8);
            }
            setVisibility(0);
            return;
        }
        if (this.f3245w != null) {
            this.f3245w.setVisibility(0);
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        if (this.f3234l) {
            onLayout(false, getLeft(), getTop(), getRight(), getBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m3243m() {
        if (this.f3231i == null) {
            return;
        }
        int iM3249c = m3249c();
        if (iM3249c < 0) {
            this.f3231i.mo3193a(this);
        } else {
            this.f3231i.mo3194a(this, mo3252e(), iM3249c, mo3248b().getItemId(iM3249c));
        }
    }

    /* renamed from: a */
    public int m3244a(View view) {
        View view2 = view;
        while (true) {
            try {
                View view3 = (View) view2.getParent();
                if (view3.equals(this)) {
                    break;
                }
                view2 = view3;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view2)) {
                return this.f3223a + i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    void mo3235a() {
        if (this.f3231i != null) {
            if (this.f3230h || this.f3243u) {
                if (this.f3248z == null) {
                    this.f3248z = new HandlerC0512c(this);
                }
                this.f3248z.post(this.f3248z);
            } else {
                m3243m();
            }
        }
        if (this.f3237o == -1 || !isShown() || isInTouchMode()) {
            return;
        }
        sendAccessibilityEvent(4);
    }

    /* renamed from: a */
    void mo3237a(int i) {
        this.f3237o = i;
        this.f3238p = m3247b(i);
    }

    /* renamed from: a */
    public boolean m3245a(View view, int i, long j) {
        if (this.f3232j == null) {
            return false;
        }
        ChatONLogWriter.m3506b("Carousel Adapter Position = " + i + "===id=" + j, null);
        playSoundEffect(0);
        this.f3232j.mo3220a(this, view, i, j);
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in CarouselAdapter");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in CarouselAdapter");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in CarouselAdapter");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in CarouselAdapter");
    }

    /* renamed from: b */
    int m3246b(int i, boolean z) {
        return i;
    }

    /* renamed from: b */
    public long m3247b(int i) {
        Adapter adapterMo3248b = mo3248b();
        if (adapterMo3248b == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapterMo3248b.getItemId(i);
    }

    /* renamed from: b */
    public abstract Adapter mo3248b();

    @ViewDebug.CapturedViewProperty
    /* renamed from: c */
    public int m3249c() {
        return this.f3235m;
    }

    /* renamed from: c */
    void m3250c(int i) {
        this.f3235m = i;
        this.f3236n = m3247b(i);
        if (this.f3228f && this.f3229g == 0 && i >= 0) {
            this.f3225c = i;
            this.f3226d = this.f3236n;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.f3239q > 0;
    }

    @ViewDebug.CapturedViewProperty
    /* renamed from: d */
    public long m3251d() {
        return this.f3236n;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View viewMo3252e = mo3252e();
        boolean zDispatchPopulateAccessibilityEvent = viewMo3252e != null ? viewMo3252e.dispatchPopulateAccessibilityEvent(accessibilityEvent) : false;
        if (!zDispatchPopulateAccessibilityEvent) {
            if (viewMo3252e != null) {
                accessibilityEvent.setEnabled(viewMo3252e.isEnabled());
            }
            accessibilityEvent.setItemCount(mo3253f());
            accessibilityEvent.setCurrentItemIndex(m3249c());
        }
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* renamed from: e */
    public abstract View mo3252e();

    @ViewDebug.CapturedViewProperty
    /* renamed from: f */
    public int mo3253f() {
        return this.f3239q;
    }

    /* renamed from: g */
    boolean m3254g() {
        return false;
    }

    /* renamed from: h */
    void m3255h() {
        Adapter adapterMo3248b = mo3248b();
        boolean z = !(adapterMo3248b == null || adapterMo3248b.getCount() == 0) || m3254g();
        super.setFocusableInTouchMode(z && this.f3247y);
        super.setFocusable(z && this.f3246x);
        if (this.f3245w != null) {
            m3241a(adapterMo3248b == null || adapterMo3248b.isEmpty());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m3256i() {
        /*
            r8 = this;
            r6 = -9223372036854775808
            r5 = -1
            r4 = 1
            r3 = 0
            int r0 = r8.f3239q
            if (r0 <= 0) goto L56
            boolean r1 = r8.f3228f
            if (r1 == 0) goto L54
            r8.f3228f = r3
            int r1 = r8.m3258k()
            if (r1 < 0) goto L54
            int r2 = r8.m3246b(r1, r4)
            if (r2 != r1) goto L54
            r8.m3250c(r1)
            r1 = r4
        L1f:
            if (r1 != 0) goto L4e
            int r2 = r8.m3249c()
            if (r2 < r0) goto L52
            int r0 = r0 - r4
        L28:
            if (r0 >= 0) goto L2b
            r0 = r3
        L2b:
            int r2 = r8.m3246b(r0, r4)
            if (r2 >= 0) goto L50
            int r0 = r8.m3246b(r0, r3)
        L35:
            if (r0 < 0) goto L4e
            r8.m3250c(r0)
            r8.m3257j()
            r0 = r4
        L3e:
            if (r0 != 0) goto L4d
            r8.f3237o = r5
            r8.f3238p = r6
            r8.f3235m = r5
            r8.f3236n = r6
            r8.f3228f = r3
            r8.m3257j()
        L4d:
            return
        L4e:
            r0 = r1
            goto L3e
        L50:
            r0 = r2
            goto L35
        L52:
            r0 = r2
            goto L28
        L54:
            r1 = r3
            goto L1f
        L56:
            r0 = r3
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.theme.CarouselAdapter.m3256i():void");
    }

    /* renamed from: j */
    void m3257j() {
        if (this.f3237o == this.f3241s && this.f3238p == this.f3242t) {
            return;
        }
        mo3235a();
        this.f3241s = this.f3237o;
        this.f3242t = this.f3238p;
    }

    /* renamed from: k */
    int m3258k() {
        int i = this.f3239q;
        if (i == 0) {
            return -1;
        }
        long j = this.f3226d;
        int i2 = this.f3225c;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int iMin = Math.min(i - 1, Math.max(0, i2));
        long jUptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapterMo3248b = mo3248b();
        if (adapterMo3248b == null) {
            return -1;
        }
        int i3 = iMin;
        int i4 = iMin;
        int i5 = iMin;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= jUptimeMillis) {
            if (adapterMo3248b.getItemId(i5) != j) {
                boolean z2 = i3 == i - 1;
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

    /* renamed from: l */
    void m3259l() {
        if (getChildCount() > 0) {
            this.f3228f = true;
            this.f3227e = this.f3244v;
            if (this.f3237o >= 0) {
                View childAt = getChildAt(this.f3237o - this.f3223a);
                this.f3226d = this.f3236n;
                this.f3225c = this.f3235m;
                if (childAt != null) {
                    this.f3224b = childAt.getTop();
                }
                this.f3229g = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapterMo3248b = mo3248b();
            if (this.f3223a < 0 || this.f3223a >= adapterMo3248b.getCount()) {
                this.f3226d = -1L;
            } else {
                this.f3226d = adapterMo3248b.getItemId(this.f3223a);
            }
            this.f3225c = this.f3223a;
            if (childAt2 != null) {
                this.f3224b = childAt2.getTop();
            }
            this.f3229g = 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f3244v = getHeight();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in CarouselAdapter");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in CarouselAdapter");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in CarouselAdapter");
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view) {
        this.f3245w = view;
        Adapter adapterMo3248b = mo3248b();
        m3241a(adapterMo3248b == null || adapterMo3248b.isEmpty());
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        Adapter adapterMo3248b = mo3248b();
        boolean z2 = adapterMo3248b == null || adapterMo3248b.getCount() == 0;
        this.f3246x = z;
        if (!z) {
            this.f3247y = false;
        }
        super.setFocusable(z && (!z2 || m3254g()));
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        Adapter adapterMo3248b = mo3248b();
        boolean z2 = adapterMo3248b == null || adapterMo3248b.getCount() == 0;
        this.f3247y = z;
        if (z) {
            this.f3246x = true;
        }
        super.setFocusableInTouchMode(z && (!z2 || m3254g()));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f3232j = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f3233k = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f3231i = onItemSelectedListener;
    }

    public abstract void setSelection(int i);
}
