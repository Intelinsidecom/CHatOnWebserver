package com.sec.chaton.buddy;

import android.widget.AbsListView;

/* renamed from: com.sec.chaton.buddy.aa */
/* loaded from: classes.dex */
class C0077aa implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f610a;

    C0077aa(BuddyProfileActivity buddyProfileActivity) {
        this.f610a = buddyProfileActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i < i3 - i2 || i3 == 0 || this.f610a.f575W || this.f610a.f572T == null || !this.f610a.f572T.equals("true")) {
            return;
        }
        this.f610a.f575W = true;
        this.f610a.f565L.m2007a(this.f610a.f586k, this.f610a.f573U);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
