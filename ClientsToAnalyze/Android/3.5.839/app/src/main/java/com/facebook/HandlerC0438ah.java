package com.facebook;

import android.os.Handler;
import android.os.Message;

/* compiled from: GetTokenClient.java */
/* renamed from: com.facebook.ah */
/* loaded from: classes.dex */
class HandlerC0438ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0437ag f1070a;

    HandlerC0438ah(ServiceConnectionC0437ag serviceConnectionC0437ag) {
        this.f1070a = serviceConnectionC0437ag;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f1070a.m1562a(message);
    }
}
