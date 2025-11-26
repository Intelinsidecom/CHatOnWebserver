package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.z */
/* loaded from: classes.dex */
class RunnableC1638z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f5785a;

    RunnableC1638z(HorizontalListView horizontalListView) {
        this.f5785a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5785a.requestLayout();
    }
}
