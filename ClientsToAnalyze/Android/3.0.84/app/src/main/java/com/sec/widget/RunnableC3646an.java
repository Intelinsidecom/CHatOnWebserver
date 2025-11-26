package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.an */
/* loaded from: classes.dex */
class RunnableC3646an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3644al f13523a;

    RunnableC3646an(C3644al c3644al) {
        this.f13523a = c3644al;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13523a.f13521a.m13126c();
        this.f13523a.f13521a.invalidate();
        this.f13523a.f13521a.requestLayout();
    }
}
