package com.sec.chaton.buddy;

import android.widget.AbsListView;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.gg */
/* loaded from: classes.dex */
class C1327gg implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4864a;

    C1327gg(BuddyProfileFragment buddyProfileFragment) {
        this.f4864a = buddyProfileFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f4864a.f3940aG && this.f4864a.f3937aD != null && "true".equals(this.f4864a.f3937aD)) {
            this.f4864a.f3940aG = true;
            if (this.f4864a.f3977as != null) {
                this.f4864a.f3977as.setVisibility(0);
            }
            this.f4864a.f3969aj.m9290a(this.f4864a.f4013t, this.f4864a.f3938aE);
        }
    }
}
