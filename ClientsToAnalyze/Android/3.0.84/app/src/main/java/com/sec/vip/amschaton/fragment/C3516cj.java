package com.sec.vip.amschaton.fragment;

import android.widget.AbsListView;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cj */
/* loaded from: classes.dex */
class C3516cj implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12914a;

    C3516cj(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12914a = aMSStampSelectionFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f12914a.m12625f();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
