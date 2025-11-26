package com.sec.chaton.msgbox;

import android.widget.AbsListView;
import com.sec.chaton.p074l.C2496n;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ba */
/* loaded from: classes.dex */
class C2636ba implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9485a;

    C2636ba(MsgboxFragment msgboxFragment) {
        this.f9485a = msgboxFragment;
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
