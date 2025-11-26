package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.bf */
/* loaded from: classes.dex */
class C3665bf extends DataSetObserver {

    /* renamed from: c */
    final /* synthetic */ TwIndexScrollView f13563c;

    /* renamed from: d */
    private final long f13564d = 200;

    /* renamed from: a */
    boolean f13561a = false;

    /* renamed from: b */
    Runnable f13562b = new RunnableC3666bg(this);

    C3665bf(TwIndexScrollView twIndexScrollView) {
        this.f13563c = twIndexScrollView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        m13241b();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        m13241b();
    }

    /* renamed from: a */
    public boolean m13242a() {
        return !this.f13561a;
    }

    /* renamed from: b */
    private void m13241b() {
        this.f13561a = true;
        this.f13563c.removeCallbacks(this.f13562b);
        this.f13563c.postDelayed(this.f13562b, 200L);
    }
}
