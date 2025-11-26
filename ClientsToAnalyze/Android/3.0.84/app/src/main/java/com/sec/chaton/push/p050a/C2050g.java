package com.sec.chaton.push.p050a;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.util.InterfaceC2110b;
import com.sec.common.CommonApplication;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.g */
/* loaded from: classes.dex */
class C2050g implements InterfaceC2110b {

    /* renamed from: a */
    final /* synthetic */ RunnableC2049f f7904a;

    C2050g(RunnableC2049f runnableC2049f) {
        this.f7904a = runnableC2049f;
    }

    @Override // com.sec.chaton.push.util.InterfaceC2110b
    /* renamed from: a */
    public void mo8178a(Context context) {
        CommonApplication.m11493l().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }
}
