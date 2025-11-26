package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.trunk.database.C1178f;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.m */
/* loaded from: classes.dex */
class C0596m extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2038a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0596m(ChatActivity chatActivity, Handler handler) {
        super(handler);
        this.f2038a = chatActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2038a.f1722w.startQuery(9, null, C1178f.f4044a, null, "session_id=?", new String[]{this.f2038a.f1716p}, null);
    }
}
