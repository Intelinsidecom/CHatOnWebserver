package com.sec.chaton;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cn */
/* loaded from: classes.dex */
class HandlerC1885cn extends Handler {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7102a;

    HandlerC1885cn(SplashActivity splashActivity) {
        this.f7102a = splashActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f7102a.f2018t = false;
        if (GlobalApplication.f8360f != null && GlobalApplication.f8360f.getStatus() == AsyncTask.Status.FINISHED) {
            this.f7102a.startActivity(this.f7102a.m2974b((Intent) message.obj));
            this.f7102a.finish();
            this.f7102a.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
