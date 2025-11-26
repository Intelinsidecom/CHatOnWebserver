package com.sec.chaton.buddy;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ct */
/* loaded from: classes.dex */
class C0589ct implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2552a;

    C0589ct(BuddyFragment buddyFragment) {
        this.f2552a = buddyFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f2552a.f1739C.m11229c();
            if (this.f2552a.m3224F() && this.f2552a.f1738B != null) {
                BuddyFragment.f1728c = this.f2552a.f1738B.getFirstVisiblePosition();
                View childAt = this.f2552a.f1738B.getChildAt(0);
                BuddyFragment.f1729d = childAt != null ? childAt.getTop() : 0;
                return;
            }
            return;
        }
        this.f2552a.f1739C.m11223b();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
