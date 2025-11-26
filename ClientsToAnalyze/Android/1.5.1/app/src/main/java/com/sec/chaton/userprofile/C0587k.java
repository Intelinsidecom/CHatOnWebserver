package com.sec.chaton.userprofile;

import android.widget.AbsListView;

/* renamed from: com.sec.chaton.userprofile.k */
/* loaded from: classes.dex */
class C0587k implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3584a;

    C0587k(UserProfileFragment userProfileFragment) {
        this.f3584a = userProfileFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i < i3 - i2 || i3 == 0 || this.f3584a.f3468ai || this.f3584a.f3466ag == null || !this.f3584a.f3466ag.equals("true")) {
            return;
        }
        this.f3584a.f3468ai = true;
        this.f3584a.f3459Z.m2007a(this.f3584a.f3443J, this.f3584a.f3467ah);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
