package com.sec.common.widget;

import android.widget.AbsListView;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.n */
/* loaded from: classes.dex */
class C5069n implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f18504a;

    private C5069n(IcsListPopupWindow icsListPopupWindow) {
        this.f18504a = icsListPopupWindow;
    }

    /* synthetic */ C5069n(IcsListPopupWindow icsListPopupWindow, C5065j c5065j) {
        this(icsListPopupWindow);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f18504a.m19252f() && this.f18504a.f18446b.getContentView() != null) {
            this.f18504a.f18466v.removeCallbacks(this.f18504a.f18462r);
            this.f18504a.f18462r.run();
        }
    }
}
