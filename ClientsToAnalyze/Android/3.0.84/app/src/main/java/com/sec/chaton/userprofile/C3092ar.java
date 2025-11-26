package com.sec.chaton.userprofile;

import android.widget.AbsListView;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ar */
/* loaded from: classes.dex */
class C3092ar implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11304a;

    C3092ar(MyPageFragment myPageFragment) {
        this.f11304a = myPageFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f11304a.f11176h && this.f11304a.f11177i != null && "true".equals(this.f11304a.f11177i)) {
            this.f11304a.f11176h = true;
            this.f11304a.f11192x.m5915a(this.f11304a.f11102E, this.f11304a.f11178j);
        }
    }
}
