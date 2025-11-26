package com.sec.vip.amschaton.ics;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.am */
/* loaded from: classes.dex */
class HandlerC1990am extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7264a;

    HandlerC1990am(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7264a = aMSMyWorksActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f7264a.m7028n();
        this.f7264a.m7027m();
    }
}
