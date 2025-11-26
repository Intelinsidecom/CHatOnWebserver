package com.sec.chaton.account;

import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.d */
/* loaded from: classes.dex */
class HandlerC0997d extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0996c f3262a;

    HandlerC0997d(ServiceConnectionC0996c serviceConnectionC0996c) {
        this.f3262a = serviceConnectionC0996c;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("push deregister : success", getClass().getSimpleName());
            }
        } else if (C4904y.f17872b) {
            C4904y.m18639b("push deregister : fail", getClass().getSimpleName());
        }
        if (this.f3262a.f3259e == null) {
            this.f3262a.f3260f = null;
            this.f3262a.f3256b.sendEmptyMessage(202);
            C4904y.m18639b("onReceiveRemoveAccount : regControl is null.", ChatONAccountService.class.getSimpleName());
        } else {
            this.f3262a.f3260f = this.f3262a.f3259e.m9349a(this.f3262a.f3257c);
        }
    }
}
