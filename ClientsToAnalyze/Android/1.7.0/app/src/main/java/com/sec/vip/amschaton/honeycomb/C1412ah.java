package com.sec.vip.amschaton.honeycomb;

import android.widget.AbsListView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ah */
/* loaded from: classes.dex */
class C1412ah implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5041a;

    C1412ah(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5041a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f5041a.m5266l();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
