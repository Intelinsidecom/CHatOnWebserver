package com.sec.chaton.chat;

import android.widget.AbsListView;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ct */
/* loaded from: classes.dex */
class C1024ct implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4108a;

    C1024ct(ChatFragment chatFragment) {
        this.f4108a = chatFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f4108a.f3526aB.getSelectedView() != null && !this.f4108a.f3613bj.isFocused()) {
            this.f4108a.f3526aB.getSelectedView().requestFocus();
            this.f4108a.f3526aB.getSelectedView().setSelected(false);
        }
        if (i == 0 && i3 - 1 > 0) {
            if (this.f4108a.f3593bP) {
                ChatFragment.m4862b(this.f4108a, 30);
                if (this.f4108a.f3551aa != null && !this.f4108a.f3632cB) {
                    C3250y.m11450b("onScroll - QUERY_MESSAGE_LOAD_MORE", getClass().getSimpleName());
                    this.f4108a.f3551aa.startQuery(14, null, C1454v.m6344a(this.f4108a.f3597bT), null, "message_inbox_no=?", new String[]{this.f4108a.f3703r}, null);
                    this.f4108a.f3632cB = true;
                }
            } else {
                C3250y.m11450b("onScroll - request message from server", getClass().getSimpleName());
                this.f4108a.m4859ay();
            }
        }
        if (i + 1 + i2 > i3) {
            this.f4108a.m5010k();
        } else if (i2 != 0) {
            this.f4108a.f3503E = false;
            this.f4108a.f3526aB.setTranscriptMode(0);
        }
    }
}
