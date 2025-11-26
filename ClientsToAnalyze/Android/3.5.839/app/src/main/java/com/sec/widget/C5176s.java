package com.sec.widget;

import android.widget.AbsListView;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.s */
/* loaded from: classes.dex */
class C5176s implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ FastScrollableListView f18942a;

    C5176s(FastScrollableListView fastScrollableListView) {
        this.f18942a = fastScrollableListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f18942a.f18768b != null) {
            this.f18942a.f18768b.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f18942a.f18767a != null) {
            this.f18942a.f18767a.m19802a(absListView, absListView.getFirstVisiblePosition(), this.f18942a.getChildCount(), absListView.getCount());
        }
        if (this.f18942a.f18768b != null) {
            this.f18942a.f18768b.onScroll(absListView, i, i2, i3);
        }
    }
}
