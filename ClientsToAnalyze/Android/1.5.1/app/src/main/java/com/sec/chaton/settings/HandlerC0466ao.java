package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.settings.ao */
/* loaded from: classes.dex */
class HandlerC0466ao extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityDeleteAccount f3158a;

    HandlerC0466ao(ActivityDeleteAccount activityDeleteAccount) {
        this.f3158a = activityDeleteAccount;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 202:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f3158a.f2989d.mo1976b(this.f3158a.f2988c);
                    break;
                } else {
                    this.f3158a.f2992g.dismiss();
                    new AlertDialog.Builder(this.f3158a.f2986a).setMessage(C0062R.string.toast_dereg_failed).setPositiveButton(C0062R.string.dialog_ok, (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
        }
    }
}
