package com.sec.chaton.userprofile;

import android.widget.AbsListView;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ba */
/* loaded from: classes.dex */
class C1231ba implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4311a;

    C1231ba(MyPageFragment myPageFragment) {
        this.f4311a = myPageFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f4311a.f4131ac && this.f4311a.f4129aa != null && this.f4311a.f4129aa.equals("true")) {
            this.f4311a.f4131ac = true;
            this.f4311a.f4120R.m865a(this.f4311a.f4110H, this.f4311a.f4130ab);
        }
    }
}
