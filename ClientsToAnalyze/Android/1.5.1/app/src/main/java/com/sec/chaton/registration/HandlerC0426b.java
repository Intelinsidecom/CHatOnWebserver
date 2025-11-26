package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetSSMServerAddress3;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.b */
/* loaded from: classes.dex */
class HandlerC0426b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.PhoneNumberAuthFragment f2937a;

    HandlerC0426b(ActivityRegist.PhoneNumberAuthFragment phoneNumberAuthFragment) {
        this.f2937a = phoneNumberAuthFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f2937a.f2852c.dismiss();
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 103) {
            if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
                new AlertDialog.Builder(this.f2937a.getActivity()).setTitle(this.f2937a.getResources().getString(C0062R.string.toast_error)).setMessage(this.f2937a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0414al(this)).create().show();
                ChatONLogWriter.m3499a("[Dev]GLD failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
                return;
            }
            GetSSMServerAddress3 getSSMServerAddress3 = (GetSSMServerAddress3) httpEntry.m1955d();
            Intent intent = new Intent();
            intent.putExtra("MSISDN", getSSMServerAddress3.msisdn);
            this.f2937a.getActivity().setResult(-1, intent);
            this.f2937a.getActivity().finish();
        }
    }
}
