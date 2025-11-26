package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0694i;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.w */
/* loaded from: classes.dex */
class C0517w extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2127a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0517w(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2127a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2127a.f1783X.startQuery(10, null, C0694i.f2616a, new String[]{"inbox_valid", "inbox_session_id", "inbox_last_timestamp"}, "inbox_no=?", new String[]{this.f2127a.f1912z}, null);
    }
}
