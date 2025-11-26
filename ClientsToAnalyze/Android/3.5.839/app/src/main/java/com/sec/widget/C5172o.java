package com.sec.widget;

import android.widget.AbsListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.o */
/* loaded from: classes.dex */
class C5172o implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableExpandableListView f18914a;

    C5172o(FastScrollableExpandableListView fastScrollableExpandableListView) {
        this.f18914a = fastScrollableExpandableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f18914a.f18764c.onScrollStateChanged(absListView, i);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f18914a.f18763b != null) {
            this.f18914a.f18763b.m19781a(absListView, absListView.getFirstVisiblePosition(), this.f18914a.getChildCount(), absListView.getCount());
        }
        if (this.f18914a.f18764c != null) {
            this.f18914a.f18764c.onScroll(absListView, i, i2, i3);
        }
    }
}
