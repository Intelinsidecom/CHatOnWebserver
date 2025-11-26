package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.h */
/* loaded from: classes.dex */
class HandlerC2291h extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f8596a;

    HandlerC2291h(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f8596a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 301:
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    if (this.f8596a.getActivity() != null) {
                        this.f8596a.getActivity().setResult(-1);
                        this.f8596a.getActivity().finish();
                        break;
                    }
                } else {
                    if (this.f8596a.getActivity() != null) {
                        AbstractC3271a.m11494a(this.f8596a.getActivity()).mo11500a(this.f8596a.getResources().getString(R.string.toast_error)).mo11509b(this.f8596a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2293j(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2292i(this)).mo11505a().show();
                    }
                    C3250y.m11442a("[Dev]Get All buddy failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                    break;
                }
                break;
            case HttpResponseCode.FOUND /* 302 */:
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f8596a.f8090b.m5717a();
                    break;
                } else if (c0267d.m1351b() == EnumC1587o.NO_REQUEST) {
                    this.f8596a.f8090b.m5717a();
                    break;
                } else if (this.f8596a.getActivity() != null) {
                    AbstractC3271a.m11494a(this.f8596a.getActivity()).mo11500a(this.f8596a.getResources().getString(R.string.toast_error)).mo11509b(this.f8596a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2295l(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2294k(this)).mo11505a().show();
                    C3250y.m11442a("[Dev]Upload Address failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
