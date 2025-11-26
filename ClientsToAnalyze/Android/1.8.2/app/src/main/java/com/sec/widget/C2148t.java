package com.sec.widget;

import android.widget.AbsListView;
import android.widget.ExpandableListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.t */
/* loaded from: classes.dex */
class C2148t implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableExpandableListView f7816a;

    C2148t(FastScrollableExpandableListView fastScrollableExpandableListView) {
        this.f7816a = fastScrollableExpandableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f7816a.f7719a != null) {
            this.f7816a.f7719a.m7527a((ExpandableListView) absListView, absListView.getFirstVisiblePosition(), this.f7816a.getChildCount(), absListView.getCount());
        }
        if (this.f7816a.f7720b != null) {
            this.f7816a.f7720b.onScroll(absListView, i, i2, i3);
        }
    }
}
