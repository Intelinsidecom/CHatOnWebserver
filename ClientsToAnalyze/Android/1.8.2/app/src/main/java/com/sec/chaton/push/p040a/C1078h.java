package com.sec.chaton.push.p040a;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.InterfaceC1134b;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.h */
/* loaded from: classes.dex */
class C1078h implements InterfaceC1134b {

    /* renamed from: a */
    final /* synthetic */ RunnableC1076f f4002a;

    C1078h(RunnableC1076f runnableC1076f) {
        this.f4002a = runnableC1076f;
    }

    @Override // com.sec.chaton.push.util.InterfaceC1134b
    /* renamed from: a */
    public void mo4134a(Context context) {
        PushClientApplication.m4111g().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }
}
