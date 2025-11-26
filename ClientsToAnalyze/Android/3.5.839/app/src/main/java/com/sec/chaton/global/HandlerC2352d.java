package com.sec.chaton.global;

import android.os.Handler;
import android.os.Message;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.d */
/* loaded from: classes.dex */
class HandlerC2352d extends Handler {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f8384a;

    HandlerC2352d(GlobalApplication globalApplication) {
        this.f8384a = globalApplication;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f8384a.m10293t();
        sendEmptyMessageDelayed(0, 10000L);
    }
}
