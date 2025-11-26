package com.sec.chaton.localbackup.chatview;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.j */
/* loaded from: classes.dex */
class C2531j extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f9118a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2531j(ChatViewFragment chatViewFragment, Handler handler) {
        super(handler);
        this.f9118a = chatViewFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f9118a.f9088p = false;
        this.f9118a.f9081i.startQuery(1, null, C2543a.m10948a(this.f9118a.f9077e), null, "message_inbox_no=?", new String[]{this.f9118a.f9083k}, null);
        C4904y.m18639b("onChange - QUERY_MESSAGE, " + this.f9118a.f9077e, ChatViewFragment.f9073c);
    }
}
