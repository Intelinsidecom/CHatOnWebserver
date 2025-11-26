package com.sec.vip.amschaton.ics;

import android.widget.AbsListView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.y */
/* loaded from: classes.dex */
class C1543y implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5373a;

    C1543y(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5373a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f5373a.m5595l();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
