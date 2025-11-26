package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.g */
/* loaded from: classes.dex */
class HandlerC3293g extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f12061a;

    HandlerC3293g(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f12061a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 301:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (this.f12061a.getActivity() != null) {
                        this.f12061a.getActivity().setResult(-1);
                        this.f12061a.getActivity().finish();
                        break;
                    }
                } else {
                    if (this.f12061a.getActivity() != null) {
                        AbstractC4932a.m18733a(this.f12061a.getActivity()).mo18740a(this.f12061a.getResources().getString(R.string.toast_error)).mo18749b(this.f12061a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3302i(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3301h(this)).mo18745a().show();
                    }
                    C4904y.m18634a("[Dev]Get All buddy failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                    break;
                }
                break;
            case 302:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f12061a.f11546b.m9495a();
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.NO_REQUEST) {
                    this.f12061a.f11546b.m9495a();
                    break;
                } else if (this.f12061a.getActivity() != null) {
                    AbstractC4932a.m18733a(this.f12061a.getActivity()).mo18740a(this.f12061a.getResources().getString(R.string.toast_error)).mo18749b(this.f12061a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3304k(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3303j(this)).mo18745a().show();
                    C4904y.m18634a("[Dev]Upload Address failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
