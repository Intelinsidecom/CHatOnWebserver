package com.sec.chaton.updates;

import android.widget.AbsListView;

/* compiled from: UpdatesFragment.java */
/* renamed from: com.sec.chaton.updates.m */
/* loaded from: classes.dex */
class C4706m implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ UpdatesFragment f17053a;

    C4706m(UpdatesFragment updatesFragment) {
        this.f17053a = updatesFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && this.f17053a.f16983q != null && "true".equals(this.f17053a.f16983q) && !this.f17053a.f16979m) {
            this.f17053a.f16979m = true;
            this.f17053a.f16971e.setVisibility(0);
            this.f17053a.f16982p.m9467a(this.f17053a.f16984r);
        }
    }
}
