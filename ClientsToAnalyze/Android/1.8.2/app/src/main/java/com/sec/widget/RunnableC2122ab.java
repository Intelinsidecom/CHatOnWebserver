package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ab */
/* loaded from: classes.dex */
class RunnableC2122ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2121aa f7763a;

    RunnableC2122ab(C2121aa c2121aa) {
        this.f7763a = c2121aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7763a.f7762a.f7751q = true;
        this.f7763a.f7762a.invalidate();
        this.f7763a.f7762a.requestLayout();
    }
}
