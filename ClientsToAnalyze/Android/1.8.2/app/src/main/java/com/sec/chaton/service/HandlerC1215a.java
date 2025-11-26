package com.sec.chaton.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: BaseService.java */
/* renamed from: com.sec.chaton.service.a */
/* loaded from: classes.dex */
public final class HandlerC1215a extends Handler {

    /* renamed from: a */
    final /* synthetic */ BaseService f4438a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1215a(BaseService baseService, Looper looper) {
        super(looper);
        this.f4438a = baseService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f4438a.mo4465a(message);
    }
}
