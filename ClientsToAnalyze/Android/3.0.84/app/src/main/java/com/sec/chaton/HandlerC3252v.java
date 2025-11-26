package com.sec.chaton;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.v */
/* loaded from: classes.dex */
class HandlerC3252v extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f11740a;

    HandlerC3252v(HomeActivity homeActivity) {
        this.f11740a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (GlobalApplication.f5515e != null && GlobalApplication.f5515e.getStatus() == AsyncTask.Status.FINISHED) {
            this.f11740a.startActivity(this.f11740a.m1165d((Intent) message.obj));
            this.f11740a.finish();
            this.f11740a.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
