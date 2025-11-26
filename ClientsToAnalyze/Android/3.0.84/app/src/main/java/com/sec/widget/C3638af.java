package com.sec.widget;

import android.widget.AbsListView;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.af */
/* loaded from: classes.dex */
class C3638af implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableListView f13492a;

    C3638af(FastScrollableListView fastScrollableListView) {
        this.f13492a = fastScrollableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f13492a.f13400a != null) {
            this.f13492a.f13400a.m13202a(absListView, absListView.getFirstVisiblePosition(), this.f13492a.getChildCount(), absListView.getCount());
        }
        if (this.f13492a.f13401b != null) {
            this.f13492a.f13401b.onScroll(absListView, i, i2, i3);
        }
    }
}
