package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.r */
/* loaded from: classes.dex */
class HandlerC0442r extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f2955a;

    HandlerC0442r(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f2955a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 301:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f2955a.getActivity().setResult(-1);
                    this.f2955a.getActivity().finish();
                    break;
                } else {
                    new AlertDialog.Builder(this.f2955a.getActivity()).setMessage(this.f2955a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0407ae(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0406ad(this)).create().show();
                    ChatONLogWriter.m3499a("[Dev]Get All buddy failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
                    break;
                }
                break;
            case 302:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f2955a.f2837d.m1992a();
                    break;
                } else if (httpEntry.m1951b() != HttpResultCode.NO_REQUEST) {
                    new AlertDialog.Builder(this.f2955a.getActivity()).setMessage(this.f2955a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0403aa(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0408af(this)).create().show();
                    ChatONLogWriter.m3499a("[Dev]Upload Address failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
                    break;
                } else {
                    this.f2955a.f2837d.m1992a();
                    break;
                }
                break;
            case 1101:
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f2955a.f2837d.m1993a("new");
                    break;
                } else {
                    new AlertDialog.Builder(this.f2955a.getActivity()).setMessage(this.f2955a.getResources().getString(C0062R.string.toast_network_unable)).setPositiveButton(C0062R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0405ac(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0404ab(this)).create().show();
                    ChatONLogWriter.m3499a("[Dev]GetVersion Failed. httpStatus: " + httpEntry.m1959h() + ", FaultCode: " + httpEntry.m1957f() + ", Message: " + httpEntry.m1958g(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
