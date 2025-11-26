package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.g */
/* loaded from: classes.dex */
class HandlerC0975g extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f3372a;

    HandlerC0975g(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f3372a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 301:
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    if (this.f3372a.getActivity() != null) {
                        this.f3372a.getActivity().setResult(-1);
                        this.f3372a.getActivity().finish();
                        break;
                    }
                } else {
                    if (this.f3372a.getActivity() != null) {
                        new AlertDialogBuilderC1625m(this.f3372a.getActivity()).setMessage(this.f3372a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0966bk(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0965bj(this)).create().show();
                    }
                    C1341p.m4651a("[Dev]Get All buddy failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
                    break;
                }
                break;
            case 302:
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    this.f3372a.f3182b.m757a();
                    break;
                } else if (c0259g.m928b() == EnumC0518y.NO_REQUEST) {
                    this.f3372a.f3182b.m757a();
                    break;
                } else if (this.f3372a.getActivity() != null) {
                    new AlertDialogBuilderC1625m(this.f3372a.getActivity()).setMessage(this.f3372a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0968bm(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0967bl(this)).create().show();
                    C1341p.m4651a("[Dev]Upload Address failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
                    break;
                }
                break;
            case 1101:
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    this.f3372a.f3182b.m760a("new");
                    break;
                } else if (this.f3372a.getActivity() != null) {
                    new AlertDialogBuilderC1625m(this.f3372a.getActivity()).setMessage(this.f3372a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0970bo(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0969bn(this)).create().show();
                    C1341p.m4651a("[Dev]GetVersion Failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
