package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ab */
/* loaded from: classes.dex */
class RunnableC5139ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f18831a;

    RunnableC5139ab(HorizontalListView horizontalListView) {
        this.f18831a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18831a.requestLayout();
    }
}
