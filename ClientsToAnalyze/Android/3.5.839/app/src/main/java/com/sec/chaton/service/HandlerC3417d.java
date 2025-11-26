package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: BaseService.java */
/* renamed from: com.sec.chaton.service.d */
/* loaded from: classes.dex */
public final class HandlerC3417d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BaseService f12431a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3417d(BaseService baseService, Looper looper) {
        super(looper);
        this.f12431a = baseService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12431a.mo13280a(message);
    }
}
