package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.ChatONHttpClient2;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetSMSAuthToken;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.l */
/* loaded from: classes.dex */
class HandlerC0436l extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0436l(ActivityNonSelfSMS activityNonSelfSMS, Looper looper) {
        super(looper);
        this.f2949a = activityNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 1301) {
            if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                this.f2949a.f2808a = (GetSMSAuthToken) httpEntry.m1955d();
                if (this.f2949a.f2808a != null) {
                    ChatONLogWriter.m3506b("mToken=" + this.f2949a.f2808a.token, getClass().getSimpleName());
                    this.f2949a.m3054e();
                } else {
                    this.f2949a.f2824q.dismiss();
                    new AlertDialog.Builder(this.f2949a).setTitle(this.f2949a.getResources().getString(C0062R.string.toast_error)).setMessage(this.f2949a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0446v(this)).create().show();
                }
            } else if (httpEntry.m1957f() == 30002) {
                ChatONLogWriter.m3499a("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", ChatONHttpClient2.class.getSimpleName());
                this.f2949a.f2824q.dismiss();
                this.f2949a.m3048b();
            } else {
                this.f2949a.f2824q.dismiss();
                new AlertDialog.Builder(this.f2949a).setTitle(this.f2949a.getResources().getString(C0062R.string.toast_error)).setMessage(this.f2949a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0447w(this)).create().show();
                ChatONLogWriter.m3499a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
        }
        if (message.what == 1302) {
            if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                ChatONLogWriter.m3506b("mToken=" + this.f2949a.f2808a.token, getClass().getSimpleName());
                this.f2949a.f2824q.dismiss();
            } else if (httpEntry.m1957f() == 40003) {
                ChatONLogWriter.m3499a("serversent error cause by SEND_SMS_REQUEST_LIMIT", ChatONHttpClient2.class.getSimpleName());
                this.f2949a.m3051d();
            } else {
                this.f2949a.f2824q.dismiss();
                new AlertDialog.Builder(this.f2949a).setTitle(this.f2949a.getResources().getString(C0062R.string.toast_error)).setMessage(this.f2949a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0448x(this)).create().show();
                ChatONLogWriter.m3499a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
        }
    }
}
