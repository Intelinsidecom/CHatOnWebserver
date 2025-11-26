package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.aa */
/* loaded from: classes.dex */
class RunnableC5138aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5182y f18830a;

    RunnableC5138aa(C5182y c5182y) {
        this.f18830a = c5182y;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18830a.f18971a.m19659c();
        this.f18830a.f18971a.invalidate();
        this.f18830a.f18971a.requestLayout();
    }
}
