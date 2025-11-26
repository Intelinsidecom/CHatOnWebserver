package com.sec.chaton.chat;

import android.widget.AbsListView;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.z */
/* loaded from: classes.dex */
class C0609z implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2143a;

    C0609z(ChatFragment chatFragment) {
        this.f2143a = chatFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 0 && i3 > 0 && i3 == this.f2143a.f1852by) {
            ChatFragment.m2617a(this.f2143a, ChatFragment.f1729bx);
            if (this.f2143a.f1760U != null) {
                C1341p.m4658b("onScroll - QUERY_MESSAGE_LOAD_MORE", getClass().getSimpleName());
                this.f2143a.f1760U.startQuery(14, null, C0662o.m2995a(this.f2143a.f1852by), null, "message_inbox_no=?", new String[]{this.f2143a.f1861t}, null);
            }
        }
        if (i + 1 + i2 > i3) {
            if (this.f2143a.f1794ad.getChoiceMode() != 2) {
                this.f2143a.m2705e();
            }
        } else {
            this.f2143a.f1745F = false;
            this.f2143a.f1794ad.setTranscriptMode(0);
        }
    }
}
