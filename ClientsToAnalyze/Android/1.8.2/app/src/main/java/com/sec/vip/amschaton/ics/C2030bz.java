package com.sec.vip.amschaton.ics;

import android.widget.AbsListView;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bz */
/* loaded from: classes.dex */
class C2030bz implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7318a;

    C2030bz(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7318a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f7318a.m7152l();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
