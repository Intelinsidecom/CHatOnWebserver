package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.ar */
/* loaded from: classes.dex */
class C5155ar extends DataSetObserver {

    /* renamed from: c */
    final /* synthetic */ TwIndexScrollView f18867c;

    /* renamed from: d */
    private final long f18868d = 200;

    /* renamed from: a */
    boolean f18865a = false;

    /* renamed from: b */
    Runnable f18866b = new RunnableC5156as(this);

    C5155ar(TwIndexScrollView twIndexScrollView) {
        this.f18867c = twIndexScrollView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        m19726b();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        m19726b();
    }

    /* renamed from: a */
    public boolean m19727a() {
        return !this.f18865a;
    }

    /* renamed from: b */
    private void m19726b() {
        this.f18865a = true;
        this.f18867c.removeCallbacks(this.f18866b);
        this.f18867c.postDelayed(this.f18866b, 200L);
    }
}
