package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.as */
/* loaded from: classes.dex */
class HandlerC0444as extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0443ar f1512a;

    HandlerC0444as(C0443ar c0443ar) {
        this.f1512a = c0443ar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f1512a.f1510a.f761ab.m11165a("get_all_unread", this.f1512a.f1510a.f765af, ((Boolean) message.obj).booleanValue() ? 6000000 : 60000, "last_sync_time_get_all_unread", true);
    }
}
