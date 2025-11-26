package com.sec.chaton.push.p038b;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.InterfaceC0922h;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.j */
/* loaded from: classes.dex */
class C0877j implements InterfaceC0922h {

    /* renamed from: a */
    final /* synthetic */ RunnableC0878k f3005a;

    C0877j(RunnableC0878k runnableC0878k) {
        this.f3005a = runnableC0878k;
    }

    @Override // com.sec.chaton.push.util.InterfaceC0922h
    /* renamed from: a */
    public void mo3462a(Context context) {
        PushClientApplication.m3436a().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }
}
