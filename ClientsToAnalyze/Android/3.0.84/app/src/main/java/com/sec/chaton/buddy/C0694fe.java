package com.sec.chaton.buddy;

import android.widget.AbsListView;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fe */
/* loaded from: classes.dex */
class C0694fe implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2917a;

    C0694fe(BuddyProfileFragment buddyProfileFragment) {
        this.f2917a = buddyProfileFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f2917a.f2044aC && this.f2917a.f2092az != null && "true".equals(this.f2917a.f2092az)) {
            this.f2917a.f2044aC = true;
            if (this.f2917a.f2082ap != null) {
                this.f2917a.f2082ap.setVisibility(0);
            }
            this.f2917a.f2041Z.m5915a(this.f2917a.f2117t, this.f2917a.f2042aA);
        }
    }
}
