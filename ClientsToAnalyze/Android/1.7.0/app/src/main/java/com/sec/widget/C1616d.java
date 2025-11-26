package com.sec.widget;

import android.widget.AbsListView;
import android.widget.ExpandableListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.d */
/* loaded from: classes.dex */
class C1616d implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableExpandableListView f5710a;

    C1616d(FastScrollableExpandableListView fastScrollableExpandableListView) {
        this.f5710a = fastScrollableExpandableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5710a.f5660a != null) {
            this.f5710a.f5660a.m5903a((ExpandableListView) absListView, absListView.getFirstVisiblePosition(), this.f5710a.getChildCount(), absListView.getCount());
        }
        if (this.f5710a.f5661b != null) {
            this.f5710a.f5661b.onScroll(absListView, i, i2, i3);
        }
    }
}
