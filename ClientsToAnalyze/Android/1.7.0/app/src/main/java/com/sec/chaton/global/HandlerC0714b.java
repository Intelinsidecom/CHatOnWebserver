package com.sec.chaton.global;

import android.os.Handler;
import android.os.Message;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.b */
/* loaded from: classes.dex */
class HandlerC0714b extends Handler {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f2427a;

    HandlerC0714b(GlobalApplication globalApplication) {
        this.f2427a = globalApplication;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2427a.m3110k();
        sendEmptyMessageDelayed(0, 10000L);
    }
}
