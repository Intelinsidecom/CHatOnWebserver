package com.sec.chaton.poston;

import android.widget.AbsListView;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.x */
/* loaded from: classes.dex */
class C2033x implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7822a;

    C2033x(PostONDetailFragment postONDetailFragment) {
        this.f7822a = postONDetailFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !this.f7822a.f7538aj && this.f7822a.f7523U != null && "true".equals(this.f7822a.f7523U)) {
            this.f7822a.f7538aj = true;
            this.f7822a.f7522T.m5916a(this.f7822a.f7505C, this.f7822a.f7506D, this.f7822a.f7508F, this.f7822a.f7524V, this.f7822a.f7512J);
        }
    }
}
