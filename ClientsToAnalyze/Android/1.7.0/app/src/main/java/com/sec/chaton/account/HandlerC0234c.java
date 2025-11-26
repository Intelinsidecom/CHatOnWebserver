package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C1619g;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.c */
/* loaded from: classes.dex */
class HandlerC0234c extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0236e f575a;

    HandlerC0234c(ServiceConnectionC0236e serviceConnectionC0236e) {
        this.f575a = serviceConnectionC0236e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue()) {
            C1619g.m5888a(this.f575a.f579c, R.string.toast_push_dereg_failed, 1).show();
        }
        GlobalApplication.m3102a(this.f575a.f579c);
    }
}
