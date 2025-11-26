package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: BaseService.java */
/* renamed from: com.sec.chaton.service.d */
/* loaded from: classes.dex */
public final class HandlerC2389d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BaseService f8901a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2389d(BaseService baseService, Looper looper) {
        super(looper);
        this.f8901a = baseService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f8901a.mo8896a(message);
    }
}
