package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.v */
/* loaded from: classes.dex */
class HandlerC1352v extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0715h f4603a;

    HandlerC1352v(C0715h c0715h) {
        this.f4603a = c0715h;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f4603a.f2428a.f256k.m4594a("get_all_unread", this.f4603a.f2428a.f261p, ((Boolean) message.obj).booleanValue() ? 600000 : 60000, "last_sync_time_get_all_unread", true);
    }
}
