package com.sec.widget;

import android.widget.AbsListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.ab */
/* loaded from: classes.dex */
class C3634ab implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableExpandableListView f13464a;

    C3634ab(FastScrollableExpandableListView fastScrollableExpandableListView) {
        this.f13464a = fastScrollableExpandableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f13464a.f13397c.onScrollStateChanged(absListView, i);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f13464a.f13396b != null) {
            this.f13464a.f13396b.m13181a(absListView, absListView.getFirstVisiblePosition(), this.f13464a.getChildCount(), absListView.getCount());
        }
        if (this.f13464a.f13397c != null) {
            this.f13464a.f13397c.onScroll(absListView, i, i2, i3);
        }
    }
}
