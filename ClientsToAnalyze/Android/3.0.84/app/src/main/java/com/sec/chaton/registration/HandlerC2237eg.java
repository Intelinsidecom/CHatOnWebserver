package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.eg */
/* loaded from: classes.dex */
class HandlerC2237eg extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8532a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2237eg(FragmentRegist fragmentRegist, Looper looper) {
        super(looper);
        this.f8532a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f8532a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 1104) {
                if (this.f8532a.getActivity() != null && this.f8532a.f8269I != null && this.f8532a.f8269I.isShowing()) {
                    this.f8532a.f8269I.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8532a.getActivity() != null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                    }
                    this.f8532a.m8589g();
                } else if (this.f8532a.getActivity() != null) {
                    String strM1356g = c0267d.m1356g();
                    this.f8532a.f8276P = AbstractC3271a.m11494a(this.f8532a.getActivity()).mo11500a(this.f8532a.getResources().getString(R.string.pop_up_attention)).mo11509b(C3171am.m11046a(this.f8532a.getResources().getString(R.string.toast_network_unable), this.f8532a.getResources().getString(R.string.toast_error), strM1356g)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2239ei(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2238eh(this)).mo11505a();
                    if (this.f8532a.getActivity() != null) {
                        this.f8532a.f8276P.show();
                    }
                    C3250y.m11442a("GET_VERSION_NOTICE failed becuase netwrok error", getClass().getSimpleName());
                }
            }
        }
    }
}
