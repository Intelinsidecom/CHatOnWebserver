package com.sec.chaton.global;

import android.os.Handler;
import android.os.Message;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.b */
/* loaded from: classes.dex */
class HandlerC0762b extends Handler {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f2793a;

    HandlerC0762b(GlobalApplication globalApplication) {
        this.f2793a = globalApplication;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2793a.m3266l();
        sendEmptyMessageDelayed(0, 10000L);
    }
}
