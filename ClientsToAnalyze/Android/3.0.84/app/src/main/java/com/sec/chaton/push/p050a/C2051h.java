package com.sec.chaton.push.p050a;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.util.InterfaceC2110b;
import com.sec.common.CommonApplication;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.h */
/* loaded from: classes.dex */
class C2051h implements InterfaceC2110b {

    /* renamed from: a */
    final /* synthetic */ RunnableC2049f f7905a;

    C2051h(RunnableC2049f runnableC2049f) {
        this.f7905a = runnableC2049f;
    }

    @Override // com.sec.chaton.push.util.InterfaceC2110b
    /* renamed from: a */
    public void mo8178a(Context context) {
        CommonApplication.m11493l().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }
}
