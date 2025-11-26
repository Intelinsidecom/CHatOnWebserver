package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.widget.C1619g;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.d */
/* loaded from: classes.dex */
class HandlerC0235d extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0236e f576a;

    HandlerC0235d(ServiceConnectionC0236e serviceConnectionC0236e) {
        this.f576a = serviceConnectionC0236e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 202:
                if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                    C1619g.m5888a(this.f576a.f579c, R.string.toast_dereg_failed, 0).show();
                    break;
                } else {
                    this.f576a.f580d.mo743b(this.f576a.f577a);
                    break;
                }
                break;
        }
    }
}
