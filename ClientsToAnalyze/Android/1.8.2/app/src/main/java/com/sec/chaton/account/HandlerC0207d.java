package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.d */
/* loaded from: classes.dex */
class HandlerC0207d extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0205b f744a;

    HandlerC0207d(ServiceConnectionC0205b serviceConnectionC0205b) {
        this.f744a = serviceConnectionC0205b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 202:
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    Toast.makeText(this.f744a.f740c, R.string.toast_dereg_failed, 0).show();
                    break;
                } else {
                    this.f744a.f741d.mo2704b(this.f744a.f738a);
                    break;
                }
                break;
        }
    }
}
