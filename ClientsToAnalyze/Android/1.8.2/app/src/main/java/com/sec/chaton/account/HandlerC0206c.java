package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.c */
/* loaded from: classes.dex */
class HandlerC0206c extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0205b f743a;

    HandlerC0206c(ServiceConnectionC0205b serviceConnectionC0205b) {
        this.f743a = serviceConnectionC0205b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue()) {
            Toast.makeText(this.f743a.f740c, R.string.toast_push_dereg_failed, 1).show();
        }
        GlobalApplication.m3258a(this.f743a.f740c);
    }
}
