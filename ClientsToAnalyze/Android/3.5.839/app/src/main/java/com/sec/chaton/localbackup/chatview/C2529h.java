package com.sec.chaton.localbackup.chatview;

import android.widget.AbsListView;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.h */
/* loaded from: classes.dex */
class C2529h implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f9116a;

    C2529h(ChatViewFragment chatViewFragment) {
        this.f9116a = chatViewFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f9116a.f9082j.getSelectedView() != null) {
            this.f9116a.f9082j.getSelectedView().requestFocus();
            this.f9116a.f9082j.getSelectedView().setSelected(false);
        }
        if (i == 0 && i3 - 1 > 0 && this.f9116a.f9090r && this.f9116a.f9081i != null && !this.f9116a.f9089q) {
            ChatViewFragment.m10898a(this.f9116a, 30);
            C4904y.m18639b("onScroll - QUERY_MESSAGE_LOAD_MORE, " + this.f9116a.f9077e, ChatViewFragment.f9073c);
            this.f9116a.f9081i.startQuery(2, null, C2543a.m10948a(this.f9116a.f9077e), null, "message_inbox_no=?", new String[]{this.f9116a.f9083k}, null);
            this.f9116a.f9089q = true;
        }
        if (i + 1 + i2 > i3) {
            if (this.f9116a.f9082j != null) {
                this.f9116a.f9082j.setTranscriptMode(2);
                this.f9116a.f9088p = true;
                return;
            }
            return;
        }
        if (i2 != 0) {
            this.f9116a.f9088p = false;
            this.f9116a.f9082j.setTranscriptMode(0);
        }
    }
}
