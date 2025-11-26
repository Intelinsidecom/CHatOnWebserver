package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.db */
/* loaded from: classes.dex */
class HandlerC2147db extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2146da f7776a;

    HandlerC2147db(C2146da c2146da) {
        this.f7776a = c2146da;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f7776a.f7774a.f2073aj.m18340a("get_all_unread", this.f7776a.f7774a.f2077an, ((Boolean) message.obj).booleanValue() ? 86400000 : 60000, "last_sync_time_get_all_unread", true);
    }
}
