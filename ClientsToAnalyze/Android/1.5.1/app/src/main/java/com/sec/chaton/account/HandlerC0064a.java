package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;

/* renamed from: com.sec.chaton.account.a */
/* loaded from: classes.dex */
class HandlerC0064a extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0067d f331a;

    HandlerC0064a(ServiceConnectionC0067d serviceConnectionC0067d) {
        this.f331a = serviceConnectionC0067d;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue()) {
            Toast.makeText(this.f331a.f335c, C0062R.string.toast_push_dereg_failed, 1).show();
        }
        GlobalApplication.m2384a(this.f331a.f335c);
    }
}
