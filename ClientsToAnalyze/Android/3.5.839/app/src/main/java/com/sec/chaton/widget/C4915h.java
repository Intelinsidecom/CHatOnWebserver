package com.sec.chaton.widget;

import android.widget.AbsListView;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.h */
/* loaded from: classes.dex */
class C4915h implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ DynamicListView f17964a;

    /* renamed from: b */
    private int f17965b = -1;

    /* renamed from: c */
    private int f17966c = -1;

    /* renamed from: d */
    private int f17967d;

    /* renamed from: e */
    private int f17968e;

    /* renamed from: f */
    private int f17969f;

    C4915h(DynamicListView dynamicListView) {
        this.f17964a = dynamicListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f17967d = i;
        this.f17968e = i2;
        this.f17965b = this.f17965b == -1 ? this.f17967d : this.f17965b;
        this.f17966c = this.f17966c == -1 ? this.f17968e : this.f17966c;
        m18715a();
        m18716b();
        this.f17965b = this.f17967d;
        this.f17966c = this.f17968e;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f17969f = i;
        this.f17964a.f17914v = i;
        m18714c();
    }

    /* renamed from: c */
    private void m18714c() {
        if (this.f17968e > 0 && this.f17969f == 0) {
            if (!this.f17964a.f17901i || !this.f17964a.f17902j) {
                if (this.f17964a.f17913u) {
                    this.f17964a.m18688f();
                    return;
                }
                return;
            }
            this.f17964a.m18692h();
        }
    }

    /* renamed from: a */
    public void m18715a() {
        if (this.f17967d != this.f17965b && this.f17964a.f17901i && this.f17964a.f17906n != -1) {
            this.f17964a.m18682c(this.f17964a.f17906n);
            this.f17964a.m18684d();
        }
    }

    /* renamed from: b */
    public void m18716b() {
        if (this.f17967d + this.f17968e != this.f17965b + this.f17966c && this.f17964a.f17901i && this.f17964a.f17906n != -1) {
            this.f17964a.m18682c(this.f17964a.f17906n);
            this.f17964a.m18684d();
        }
    }
}
