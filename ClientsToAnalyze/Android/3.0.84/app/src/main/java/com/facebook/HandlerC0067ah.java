package com.facebook;

import android.os.Handler;
import android.os.Message;

/* compiled from: GetTokenClient.java */
/* renamed from: com.facebook.ah */
/* loaded from: classes.dex */
class HandlerC0067ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0066ag f101a;

    HandlerC0067ah(ServiceConnectionC0066ag serviceConnectionC0066ag) {
        this.f101a = serviceConnectionC0066ag;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f101a.m118a(message);
    }
}
