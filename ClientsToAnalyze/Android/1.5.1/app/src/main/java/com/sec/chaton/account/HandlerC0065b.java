package com.sec.chaton.account;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.account.b */
/* loaded from: classes.dex */
class HandlerC0065b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0067d f332a;

    HandlerC0065b(ServiceConnectionC0067d serviceConnectionC0067d) {
        this.f332a = serviceConnectionC0067d;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 202:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f332a.f336d.mo1976b(this.f332a.f333a);
                    break;
                } else {
                    Toast.makeText(this.f332a.f335c, C0062R.string.toast_dereg_failed, 0).show();
                    break;
                }
                break;
        }
    }
}
