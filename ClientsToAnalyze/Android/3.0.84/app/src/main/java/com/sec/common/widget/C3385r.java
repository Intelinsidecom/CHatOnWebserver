package com.sec.common.widget;

import android.widget.AbsListView;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.r */
/* loaded from: classes.dex */
class C3385r implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f12258a;

    private C3385r(IcsListPopupWindow icsListPopupWindow) {
        this.f12258a = icsListPopupWindow;
    }

    /* synthetic */ C3385r(IcsListPopupWindow icsListPopupWindow, C3381n c3381n) {
        this(icsListPopupWindow);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f12258a.m11910f() && this.f12258a.f12176b.getContentView() != null) {
            this.f12258a.f12196v.removeCallbacks(this.f12258a.f12192r);
            this.f12258a.f12192r.run();
        }
    }
}
