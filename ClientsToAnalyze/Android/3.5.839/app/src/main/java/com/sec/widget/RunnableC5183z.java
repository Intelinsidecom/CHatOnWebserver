package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.z */
/* loaded from: classes.dex */
class RunnableC5183z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5182y f18972a;

    RunnableC5183z(C5182y c5182y) {
        this.f18972a = c5182y;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18972a.f18971a.f18785o = true;
        this.f18972a.f18971a.invalidate();
        this.f18972a.f18971a.requestLayout();
    }
}
