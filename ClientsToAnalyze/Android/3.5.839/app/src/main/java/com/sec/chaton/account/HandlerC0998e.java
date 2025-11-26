package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.widget.C5179v;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.e */
/* loaded from: classes.dex */
class HandlerC0998e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0996c f3263a;

    HandlerC0998e(ServiceConnectionC0996c serviceConnectionC0996c) {
        this.f3263a = serviceConnectionC0996c;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 202:
                if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR || this.f3263a.f3260f == null || !this.f3263a.f3260f.m9091e()) {
                    C5179v.m19810a(this.f3263a.f3257c, R.string.toast_dereg_failed, 0).show();
                }
                if (ChatONAccountService.f3250a != null) {
                    ChatONAccountService.f3250a.m6048a();
                }
                C0991aa.m6037a().m18962d(new C1058ba());
                break;
        }
    }
}
