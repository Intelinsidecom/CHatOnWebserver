package com.sec.chaton.buddy;

import android.widget.AbsListView;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.df */
/* loaded from: classes.dex */
class C0348df implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1492a;

    C0348df(BuddyProfileFragment buddyProfileFragment) {
        this.f1492a = buddyProfileFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f1492a.f1132ap && this.f1492a.f1129am != null && this.f1492a.f1129am.equals("true")) {
            this.f1492a.f1132ap = true;
            this.f1492a.f1118aa.m2898a(this.f1492a.f1159u, this.f1492a.f1130an);
        }
    }
}
