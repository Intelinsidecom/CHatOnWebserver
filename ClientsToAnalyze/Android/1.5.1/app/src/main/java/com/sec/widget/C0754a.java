package com.sec.widget;

import android.widget.AbsListView;
import android.widget.ExpandableListView;

/* renamed from: com.sec.widget.a */
/* loaded from: classes.dex */
class C0754a implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableExpandableListView f4556a;

    C0754a(FastScrollableExpandableListView fastScrollableExpandableListView) {
        this.f4556a = fastScrollableExpandableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f4556a.f4527a != null) {
            this.f4556a.f4527a.m4383a((ExpandableListView) absListView, absListView.getFirstVisiblePosition(), this.f4556a.getChildCount(), absListView.getCount());
        }
        if (this.f4556a.f4528b != null) {
            this.f4556a.f4528b.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
