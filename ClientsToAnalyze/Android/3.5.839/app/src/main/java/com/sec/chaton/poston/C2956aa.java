package com.sec.chaton.poston;

import android.widget.AbsListView;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aa */
/* loaded from: classes.dex */
class C2956aa implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11048a;

    C2956aa(PostONDetailFragment postONDetailFragment) {
        this.f11048a = postONDetailFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f11048a.f10929ak && this.f11048a.f10907V != null && "true".equals(this.f11048a.f10907V)) {
            this.f11048a.f10929ak = true;
            this.f11048a.f10906U.m9291a(this.f11048a.f10890E, this.f11048a.f10908W, this.f11048a.f10896K);
        }
    }
}
