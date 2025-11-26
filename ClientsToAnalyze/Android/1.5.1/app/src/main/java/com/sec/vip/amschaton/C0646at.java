package com.sec.vip.amschaton;

import android.widget.AbsListView;

/* renamed from: com.sec.vip.amschaton.at */
/* loaded from: classes.dex */
class C0646at implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionDialog f4256a;

    C0646at(AMSStampSelectionDialog aMSStampSelectionDialog) {
        this.f4256a = aMSStampSelectionDialog;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.f4256a.m4086b();
        }
    }
}
