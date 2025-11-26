package com.sec.widget;

import android.widget.AbsListView;
import android.widget.ListView;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.c */
/* loaded from: classes.dex */
class C1615c implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableListView f5709a;

    C1615c(FastScrollableListView fastScrollableListView) {
        this.f5709a = fastScrollableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5709a.f5664a != null) {
            this.f5709a.f5664a.m5935a((ListView) absListView, absListView.getFirstVisiblePosition(), this.f5709a.getChildCount(), absListView.getCount());
        }
        if (this.f5709a.f5665b != null) {
            this.f5709a.f5665b.onScroll(absListView, i, i2, i3);
        }
    }
}
