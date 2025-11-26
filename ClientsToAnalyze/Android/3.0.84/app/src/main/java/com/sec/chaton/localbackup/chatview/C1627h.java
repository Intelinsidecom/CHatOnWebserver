package com.sec.chaton.localbackup.chatview;

import android.widget.AbsListView;
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.h */
/* loaded from: classes.dex */
class C1627h implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f6072a;

    C1627h(ChatViewFragment chatViewFragment) {
        this.f6072a = chatViewFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f6072a.f6038j.getSelectedView() != null) {
            this.f6072a.f6038j.getSelectedView().requestFocus();
            this.f6072a.f6038j.getSelectedView().setSelected(false);
        }
        if (i == 0 && i3 - 1 > 0 && this.f6072a.f6046r && this.f6072a.f6037i != null && !this.f6072a.f6045q) {
            ChatViewFragment.m6868a(this.f6072a, 30);
            C3250y.m11450b("onScroll - QUERY_MESSAGE_LOAD_MORE, " + this.f6072a.f6033e, ChatViewFragment.f6029c);
            this.f6072a.f6037i.startQuery(2, null, C1641a.m6917a(this.f6072a.f6033e), null, "message_inbox_no=?", new String[]{this.f6072a.f6039k}, null);
            this.f6072a.f6045q = true;
        }
        if (i + 1 + i2 > i3) {
            if (this.f6072a.f6038j != null) {
                this.f6072a.f6038j.setTranscriptMode(2);
                this.f6072a.f6044p = true;
                return;
            }
            return;
        }
        if (i2 != 0) {
            this.f6072a.f6044p = false;
            this.f6072a.f6038j.setTranscriptMode(0);
        }
    }
}
