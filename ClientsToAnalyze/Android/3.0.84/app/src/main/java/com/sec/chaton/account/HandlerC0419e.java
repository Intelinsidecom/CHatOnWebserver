package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.e */
/* loaded from: classes.dex */
class HandlerC0419e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0417c f1473a;

    HandlerC0419e(ServiceConnectionC0417c serviceConnectionC0417c) {
        this.f1473a = serviceConnectionC0417c;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 202:
                if (c0267d == null || !c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || this.f1473a.f1470f == null || !this.f1473a.f1470f.m5508i()) {
                    C3641ai.m13210a(this.f1473a.f1467c, R.string.toast_dereg_failed, 0).show();
                } else {
                    this.f1473a.f1468d.mo5481b(this.f1473a.f1465a);
                    this.f1473a.f1465a.m11090a(30000);
                }
                if (ChatONAccountService.f1460a != null) {
                    ChatONAccountService.f1460a.m3029a();
                    break;
                }
                break;
        }
    }
}
