package com.sec.widget;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.am */
/* loaded from: classes.dex */
class RunnableC3645am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3644al f13522a;

    RunnableC3645am(C3644al c3644al) {
        this.f13522a = c3644al;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13522a.f13521a.f13418o = true;
        this.f13522a.f13521a.invalidate();
        this.f13522a.f13521a.requestLayout();
    }
}
