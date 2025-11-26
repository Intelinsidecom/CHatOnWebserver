package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ae */
/* loaded from: classes.dex */
class RunnableC1608ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1604aa f5701a;

    RunnableC1608ae(C1604aa c1604aa) {
        this.f5701a = c1604aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5701a.f5694a.m5866c();
        this.f5701a.f5694a.invalidate();
        this.f5701a.f5694a.requestLayout();
    }
}
