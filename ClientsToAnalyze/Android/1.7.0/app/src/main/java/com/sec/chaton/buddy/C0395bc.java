package com.sec.chaton.buddy;

import android.widget.AbsListView;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bc */
/* loaded from: classes.dex */
class C0395bc implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1369a;

    C0395bc(BuddyProfileActivity buddyProfileActivity) {
        this.f1369a = buddyProfileActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f1369a.f1226ac && this.f1369a.f1223Z != null && this.f1369a.f1223Z.equals("true")) {
            this.f1369a.f1226ac = true;
            this.f1369a.f1216R.m865a(this.f1369a.f1242m, this.f1369a.f1224aa);
        }
    }
}
