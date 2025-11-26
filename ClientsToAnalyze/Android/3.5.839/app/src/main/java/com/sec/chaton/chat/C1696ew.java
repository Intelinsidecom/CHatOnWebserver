package com.sec.chaton.chat;

import android.widget.AbsListView;
import com.sec.chaton.p074l.C2496n;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.ew */
/* loaded from: classes.dex */
class C1696ew implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6298a;

    C1696ew(ChatInfoFragment chatInfoFragment) {
        this.f6298a = chatInfoFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            C2496n.m10791e();
        } else {
            C2496n.m10788d();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
