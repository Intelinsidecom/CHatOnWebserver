package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ad */
/* loaded from: classes.dex */
class RunnableC2124ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f7765a;

    RunnableC2124ad(HorizontalListView horizontalListView) {
        this.f7765a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7765a.requestLayout();
    }
}
