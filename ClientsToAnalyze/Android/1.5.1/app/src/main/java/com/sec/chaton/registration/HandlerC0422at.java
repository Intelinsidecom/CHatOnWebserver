package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetSSMServerAddress3;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.at */
/* loaded from: classes.dex */
class HandlerC0422at extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2933a;

    HandlerC0422at(ActivityRegist.RegisteFragment registeFragment) {
        this.f2933a = registeFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 103) {
            if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
                new AlertDialog.Builder(this.f2933a.getActivity()).setTitle(this.f2933a.getResources().getString(C0062R.string.toast_error)).setMessage(this.f2933a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0415am(this)).create().show();
                ChatONLogWriter.m3499a("[Dev]GLD failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
            } else {
                GetSSMServerAddress3 getSSMServerAddress3 = (GetSSMServerAddress3) httpEntry.m1955d();
                try {
                    if (!TextUtils.isEmpty(getSSMServerAddress3.msisdn)) {
                        ChatONLogWriter.m3506b("msisnd =" + getSSMServerAddress3.msisdn, getClass().getSimpleName());
                        ActivityRegist.f2845a = getSSMServerAddress3.msisdn;
                    }
                    if (TextUtils.isEmpty(getSSMServerAddress3.selfsmspn)) {
                        ChatONLogWriter.m3506b("invalid phone number server return result empty", getClass().getSimpleName());
                    } else {
                        ChatONLogWriter.m3506b("selfsmspn =" + getSSMServerAddress3.selfsmspn, getClass().getSimpleName());
                        ActivityRegist.f2846b = getSSMServerAddress3.selfsmspn;
                        this.f2933a.m3074a(this.f2933a.f2864i, getSSMServerAddress3.selfsmspn).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.f2933a.f2874s.dismiss();
    }
}
