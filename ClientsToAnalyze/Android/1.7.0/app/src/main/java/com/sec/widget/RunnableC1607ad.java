package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ad */
/* loaded from: classes.dex */
class RunnableC1607ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1604aa f5700a;

    RunnableC1607ad(C1604aa c1604aa) {
        this.f5700a = c1604aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5700a.f5694a.f5687o = true;
        this.f5700a.f5694a.invalidate();
        this.f5700a.f5694a.requestLayout();
    }
}
