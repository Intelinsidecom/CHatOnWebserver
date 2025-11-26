package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.ab */
/* loaded from: classes.dex */
class HandlerC0201ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0200aa f726a;

    HandlerC0201ab(C0200aa c0200aa) {
        this.f726a = c0200aa;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f726a.f724a.f224o.m5932a("get_all_unread", this.f726a.f724a.f226q, ((Boolean) message.obj).booleanValue() ? 10800000 : 60000, "last_sync_time_get_all_unread", true);
    }
}
