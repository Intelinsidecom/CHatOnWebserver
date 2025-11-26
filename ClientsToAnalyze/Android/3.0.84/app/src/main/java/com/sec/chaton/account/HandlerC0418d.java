package com.sec.chaton.account;

import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.widget.C3641ai;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.d */
/* loaded from: classes.dex */
class HandlerC0418d extends HandlerC3176ar {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0417c f1472a;

    HandlerC0418d(ServiceConnectionC0417c serviceConnectionC0417c) {
        this.f1472a = serviceConnectionC0417c;
    }

    @Override // com.sec.chaton.util.HandlerC3176ar
    /* renamed from: a */
    public void mo3031a(Message message) {
        if (!((Boolean) message.obj).booleanValue()) {
            C3641ai.m13210a(this.f1472a.f1467c, R.string.toast_push_dereg_failed, 1).show();
        }
        GlobalApplication.m6449a(this.f1472a.f1467c);
    }
}
