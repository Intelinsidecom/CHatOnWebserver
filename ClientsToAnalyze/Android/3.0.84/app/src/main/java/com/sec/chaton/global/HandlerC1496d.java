package com.sec.chaton.global;

import android.os.Handler;
import android.os.Message;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.d */
/* loaded from: classes.dex */
class HandlerC1496d extends Handler {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f5532a;

    HandlerC1496d(GlobalApplication globalApplication) {
        this.f5532a = globalApplication;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f5532a.m6460n();
        sendEmptyMessageDelayed(0, 10000L);
    }
}
