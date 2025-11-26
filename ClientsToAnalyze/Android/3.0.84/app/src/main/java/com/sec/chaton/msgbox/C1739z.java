package com.sec.chaton.msgbox;

import android.widget.AbsListView;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.z */
/* loaded from: classes.dex */
class C1739z implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6412a;

    C1739z(MsgboxFragment msgboxFragment) {
        this.f6412a = msgboxFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f6412a.f6241J.m11229c();
        } else {
            this.f6412a.f6241J.m11223b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
