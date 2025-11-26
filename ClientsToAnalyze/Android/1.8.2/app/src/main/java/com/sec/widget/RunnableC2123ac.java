package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ac */
/* loaded from: classes.dex */
class RunnableC2123ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2121aa f7764a;

    RunnableC2123ac(C2121aa c2121aa) {
        this.f7764a = c2121aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7764a.f7762a.m7470c();
        this.f7764a.f7762a.invalidate();
        this.f7764a.f7762a.requestLayout();
    }
}
