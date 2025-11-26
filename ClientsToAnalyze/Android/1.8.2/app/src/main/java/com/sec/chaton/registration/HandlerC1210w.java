package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.registration.ActivityProvisioning;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.w */
/* loaded from: classes.dex */
class HandlerC1210w extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityProvisioning.JoinWorkerFragment f4426a;

    HandlerC1210w(ActivityProvisioning.JoinWorkerFragment joinWorkerFragment) {
        this.f4426a = joinWorkerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 301:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    if (this.f4426a.getActivity() != null) {
                        this.f4426a.getActivity().setResult(-1);
                        this.f4426a.getActivity().finish();
                        break;
                    }
                } else {
                    if (this.f4426a.getActivity() != null) {
                        new AlertDialogBuilderC2120a(this.f4426a.getActivity()).setTitle(this.f4426a.getResources().getString(R.string.toast_error)).setMessage(this.f4426a.getResources().getString(R.string.toast_network_unable)).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1212y(this)).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1211x(this)).show();
                    }
                    C1786r.m6054a("[Dev]Get All buddy failed. httpStatus: " + c0101b.m675h() + ", FaultCode: " + c0101b.m673f() + ", Message: " + c0101b.m674g(), getClass().getSimpleName());
                    break;
                }
                break;
            case HttpResponseCode.FOUND /* 302 */:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f4426a.f4207b.m2853a();
                    break;
                } else if (c0101b.m665b() == EnumC0803m.NO_REQUEST) {
                    this.f4426a.f4207b.m2853a();
                    break;
                } else {
                    new AlertDialogBuilderC2120a(this.f4426a.getActivity()).setTitle(this.f4426a.getResources().getString(R.string.toast_error)).setMessage(this.f4426a.getResources().getString(R.string.toast_network_unable)).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1147aa(this)).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1213z(this)).show();
                    C1786r.m6054a("[Dev]Upload Address failed. httpStatus: " + c0101b.m675h() + ", FaultCode: " + c0101b.m673f() + ", Message: " + c0101b.m674g(), getClass().getSimpleName());
                    break;
                }
                break;
            case 1101:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f4426a.f4207b.m2858a("new");
                    break;
                } else {
                    new AlertDialogBuilderC2120a(this.f4426a.getActivity()).setTitle(this.f4426a.getResources().getString(R.string.toast_error)).setMessage(this.f4426a.getResources().getString(R.string.toast_network_unable)).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1149ac(this)).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1148ab(this)).show();
                    C1786r.m6054a("[Dev]GetVersion Failed. httpStatus: " + c0101b.m675h() + ", FaultCode: " + c0101b.m673f() + ", Message: " + c0101b.m674g(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
