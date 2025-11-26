package com.sec.chaton.chat;

import android.widget.AbsListView;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cv */
/* loaded from: classes.dex */
class C1641cv implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6173a;

    C1641cv(ChatFragment chatFragment) {
        this.f6173a = chatFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f6173a.f5527aT.getSelectedView() != null && !this.f6173a.f5564bF.isFocused()) {
            this.f6173a.f5527aT.getSelectedView().requestFocus();
            this.f6173a.f5527aT.getSelectedView().setSelected(false);
        }
        if (i + 1 + i2 > i3) {
            this.f6173a.m8265j();
        } else if (i2 != 0) {
            this.f6173a.f5527aT.setTranscriptMode(0);
        }
    }
}
