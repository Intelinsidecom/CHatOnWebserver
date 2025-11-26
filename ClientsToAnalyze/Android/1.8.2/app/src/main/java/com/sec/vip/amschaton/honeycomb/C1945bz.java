package com.sec.vip.amschaton.honeycomb;

import android.widget.AbsListView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bz */
/* loaded from: classes.dex */
class C1945bz implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7089a;

    C1945bz(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7089a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f7089a.m6837l();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
