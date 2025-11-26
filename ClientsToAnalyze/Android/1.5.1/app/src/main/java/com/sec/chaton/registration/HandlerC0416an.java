package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.an */
/* loaded from: classes.dex */
class HandlerC0416an extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2927a;

    HandlerC0416an(ActivityNonSelfSMS activityNonSelfSMS) {
        this.f2927a = activityNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 201:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f2927a.setResult(-1, new Intent());
                    this.f2927a.f2824q.dismiss();
                    this.f2927a.finish();
                    break;
                } else if (httpEntry.m1957f() != 12007 && httpEntry.m1957f() != 12008) {
                    this.f2927a.f2824q.dismiss();
                    new AlertDialog.Builder(this.f2927a).setMessage(this.f2927a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0444t(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0443s(this)).create().show();
                    ChatONLogWriter.m3499a("[Dev]Registration Failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
                    break;
                } else {
                    this.f2927a.f2816i.setText("");
                    this.f2927a.f2824q.dismiss();
                    this.f2927a.m3049c();
                    break;
                }
                break;
        }
    }
}
