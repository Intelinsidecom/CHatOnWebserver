package com.sds.coolots.login;

import com.sds.coolots.MainApplication;
import java.util.TimerTask;

/* renamed from: com.sds.coolots.login.f */
/* loaded from: classes.dex */
class C1280f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C1279e f3213a;

    C1280f(C1279e c1279e) {
        this.f3213a = c1279e;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3213a.m3074a("COOLOTS 15 Second Timer Done!!!!!!");
        MainApplication.mPhoneManager.getLoginManager().login();
    }
}
