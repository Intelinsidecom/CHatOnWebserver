package com.sec.chaton.userprofile;

import android.widget.AbsListView;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.o */
/* loaded from: classes.dex */
class C1705o implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6218a;

    C1705o(MyPageFragment myPageFragment) {
        this.f6218a = myPageFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f6218a.f5831S && this.f6218a.f5829Q != null && this.f6218a.f5829Q.equals("true")) {
            this.f6218a.f5831S = true;
            this.f6218a.f5824L.m2898a(this.f6218a.f5859z, this.f6218a.f5830R);
        }
    }
}
