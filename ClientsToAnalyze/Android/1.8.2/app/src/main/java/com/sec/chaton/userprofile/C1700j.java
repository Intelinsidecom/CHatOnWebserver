package com.sec.chaton.userprofile;

import android.widget.AbsListView;

/* compiled from: MyPageBuddiesSay.java */
/* renamed from: com.sec.chaton.userprofile.j */
/* loaded from: classes.dex */
class C1700j implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MyPageBuddiesSay f6211a;

    C1700j(MyPageBuddiesSay myPageBuddiesSay) {
        this.f6211a = myPageBuddiesSay;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f6211a.f5808o && this.f6211a.f5801h != null && this.f6211a.f5801h.equals("true")) {
            this.f6211a.f5808o = true;
            this.f6211a.f5796c.m2898a(this.f6211a.f5799f, this.f6211a.f5802i);
        }
    }
}
