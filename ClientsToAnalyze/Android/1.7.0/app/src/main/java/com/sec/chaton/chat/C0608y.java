package com.sec.chaton.chat;

import android.widget.AbsListView;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.y */
/* loaded from: classes.dex */
class C0608y implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2142a;

    C0608y(ChatFragment chatFragment) {
        this.f2142a = chatFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!ChatFragment.f1726aC.hasFocus()) {
            ChatFragment.f1726aC.requestFocus();
        }
    }
}
