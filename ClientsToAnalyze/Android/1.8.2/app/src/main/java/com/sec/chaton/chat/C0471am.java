package com.sec.chaton.chat;

import android.widget.AbsListView;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.util.C1786r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.am */
/* loaded from: classes.dex */
class C0471am implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1939a;

    C0471am(ChatFragment chatFragment) {
        this.f1939a = chatFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f1939a.f1827ap.getSelectedView() != null) {
            this.f1939a.f1827ap.getSelectedView().requestFocus();
            this.f1939a.f1827ap.getSelectedView().setSelected(false);
        }
        if (i == 0 && i3 > 0 && i3 == this.f1939a.f1895cg) {
            ChatFragment.m2498a(this.f1939a, ChatFragment.f1745cf);
            if (this.f1939a.f1783X != null) {
                C1786r.m6061b("onScroll - QUERY_MESSAGE", getClass().getSimpleName());
                this.f1939a.f1783X.startQuery(0, null, C0698m.m3148a(this.f1939a.f1895cg), null, "message_inbox_no=?", new String[]{this.f1939a.f1912z}, null);
            }
        }
        if (i + 1 + i2 > i3) {
            if (this.f1939a.f1827ap.getChoiceMode() != 2) {
                this.f1939a.m2608f();
            }
        } else {
            this.f1939a.f1772M = false;
            this.f1939a.f1827ap.setTranscriptMode(0);
        }
    }
}
