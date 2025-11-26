package com.sec.chaton.buddy;

import android.view.View;
import android.widget.AbsListView;
import com.sec.chaton.p074l.C2496n;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dn */
/* loaded from: classes.dex */
class C1253dn implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4755a;

    C1253dn(BuddyFragment buddyFragment) {
        this.f4755a = buddyFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            C2496n.m10791e();
            if (this.f4755a.m6286B() && this.f4755a.f3602I != null) {
                BuddyFragment.f3581c = this.f4755a.f3602I.getFirstVisiblePosition();
                View childAt = this.f4755a.f3602I.getChildAt(0);
                BuddyFragment.f3582d = childAt != null ? childAt.getTop() : 0;
                if (BuddyFragment.f3581c == 0) {
                    this.f4755a.m6526g(true);
                    return;
                } else {
                    this.f4755a.m6534h(true);
                    return;
                }
            }
            return;
        }
        C2496n.m10788d();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
