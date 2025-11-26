package com.sec.chaton.push.p090a;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.util.InterfaceC3110b;
import com.sec.common.CommonApplication;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.g */
/* loaded from: classes.dex */
class C3050g implements InterfaceC3110b {

    /* renamed from: a */
    final /* synthetic */ RunnableC3049f f11314a;

    C3050g(RunnableC3049f runnableC3049f) {
        this.f11314a = runnableC3049f;
    }

    @Override // com.sec.chaton.push.util.InterfaceC3110b
    /* renamed from: a */
    public void mo12521a(Context context) {
        CommonApplication.m18732r().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }
}
