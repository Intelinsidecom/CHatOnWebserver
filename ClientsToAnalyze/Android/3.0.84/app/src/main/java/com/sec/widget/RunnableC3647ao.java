package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ao */
/* loaded from: classes.dex */
class RunnableC3647ao implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f13524a;

    RunnableC3647ao(HorizontalListView horizontalListView) {
        this.f13524a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13524a.requestLayout();
    }
}
