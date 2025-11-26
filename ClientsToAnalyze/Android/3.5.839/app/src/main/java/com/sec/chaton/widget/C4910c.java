package com.sec.chaton.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.c */
/* loaded from: classes.dex */
class C4910c implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ DynamicListView f17955a;

    C4910c(DynamicListView dynamicListView) {
        this.f17955a = dynamicListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f17955a.f17900h = 0;
        int iPointToPosition = this.f17955a.pointToPosition(this.f17955a.f17899g, this.f17955a.f17898f);
        View childAt = this.f17955a.getChildAt(iPointToPosition - this.f17955a.getFirstVisiblePosition());
        this.f17955a.f17906n = this.f17955a.getAdapter().getItemId(iPointToPosition);
        this.f17955a.f17908p = this.f17955a.m18666a(childAt);
        childAt.setVisibility(4);
        this.f17955a.f17901i = true;
        this.f17955a.m18682c(this.f17955a.f17906n);
        return true;
    }
}
