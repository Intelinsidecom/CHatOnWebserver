package com.sec.chaton.smsplugin.spam;

import android.os.Handler;
import android.os.Message;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.am */
/* loaded from: classes.dex */
class HandlerC3982am extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14423a;

    HandlerC3982am(SetupSpamNumberList setupSpamNumberList) {
        this.f14423a = setupSpamNumberList;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 100) {
            this.f14423a.f14367q.notifyDataSetChanged();
            this.f14423a.m15386h();
            this.f14423a.f14348E = false;
        }
    }
}
