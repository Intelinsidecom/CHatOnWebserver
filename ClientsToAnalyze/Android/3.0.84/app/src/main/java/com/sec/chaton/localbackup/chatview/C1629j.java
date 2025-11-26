package com.sec.chaton.localbackup.chatview;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.j */
/* loaded from: classes.dex */
class C1629j extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f6074a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1629j(ChatViewFragment chatViewFragment, Handler handler) {
        super(handler);
        this.f6074a = chatViewFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f6074a.f6044p = false;
        this.f6074a.f6037i.startQuery(1, null, C1641a.m6917a(this.f6074a.f6033e), null, "message_inbox_no=?", new String[]{this.f6074a.f6039k}, null);
        C3250y.m11450b("onChange - QUERY_MESSAGE, " + this.f6074a.f6033e, ChatViewFragment.f6029c);
    }
}
