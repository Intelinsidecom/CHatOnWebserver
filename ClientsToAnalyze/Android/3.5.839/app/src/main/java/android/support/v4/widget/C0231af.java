package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

/* compiled from: SlidingPaneLayout.java */
/* renamed from: android.support.v4.widget.af */
/* loaded from: classes.dex */
class C0231af extends AbstractC0241ap {

    /* renamed from: a */
    final /* synthetic */ SlidingPaneLayout f549a;

    private C0231af(SlidingPaneLayout slidingPaneLayout) {
        this.f549a = slidingPaneLayout;
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public boolean mo815a(View view, int i) {
        if (this.f549a.f529k) {
            return false;
        }
        return ((SlidingPaneLayout.LayoutParams) view.getLayoutParams()).f541b;
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo812a(int i) {
        if (this.f549a.f534p.m844a() == 0) {
            if (this.f549a.f526h == 0.0f) {
                this.f549a.m802d(this.f549a.f525g);
                this.f549a.m800c(this.f549a.f525g);
                this.f549a.f535q = false;
            } else {
                this.f549a.m798b(this.f549a.f525g);
                this.f549a.f535q = true;
            }
        }
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public void mo817b(View view, int i) {
        this.f549a.m795a();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo814a(View view, int i, int i2, int i3, int i4) {
        this.f549a.m780a(i);
        this.f549a.invalidate();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo813a(View view, float f, float f2) {
        SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams) view.getLayoutParams();
        int paddingLeft = layoutParams.leftMargin + this.f549a.getPaddingLeft();
        if (f > 0.0f || (f == 0.0f && this.f549a.f526h > 0.5f)) {
            paddingLeft += this.f549a.f528j;
        }
        this.f549a.f534p.m848a(paddingLeft, view.getTop());
        this.f549a.invalidate();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public int mo810a(View view) {
        return this.f549a.f528j;
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public int mo811a(View view, int i, int i2) {
        SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams) this.f549a.f525g.getLayoutParams();
        int paddingLeft = layoutParams.leftMargin + this.f549a.getPaddingLeft();
        return Math.min(Math.max(i, paddingLeft), this.f549a.f528j + paddingLeft);
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public void mo816b(int i, int i2) {
        this.f549a.f534p.m847a(this.f549a.f525g, i2);
    }
}
