package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dn */
/* loaded from: classes.dex */
class HandlerC2217dn extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8511a;

    HandlerC2217dn(FragmentRegist fragmentRegist) {
        this.f8511a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (this.f8511a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 301:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.f8270J.dismiss();
                        }
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.getActivity().setResult(-1);
                            this.f8511a.getActivity().finish();
                            break;
                        }
                    } else {
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.f8270J.dismiss();
                        }
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.f8276P = AbstractC3271a.m11494a(this.f8511a.getActivity()).mo11500a(this.f8511a.getResources().getString(R.string.pop_up_attention)).mo11509b(C3171am.m11046a(this.f8511a.getResources().getString(R.string.toast_network_unable), this.f8511a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2219dp(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2218do(this)).mo11505a();
                            this.f8511a.f8276P.show();
                        }
                        C3250y.m11442a("[Dev]Get All buddy failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                        break;
                    }
                    break;
                case HttpResponseCode.FOUND /* 302 */:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8511a.f8274N.m5717a();
                        break;
                    } else if (c0267d.m1351b() == EnumC1587o.NO_REQUEST) {
                        this.f8511a.f8274N.m5717a();
                        break;
                    } else {
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.f8270J.dismiss();
                        }
                        if (this.f8511a.getActivity() != null) {
                            this.f8511a.f8276P = AbstractC3271a.m11494a(this.f8511a.getActivity()).mo11500a(this.f8511a.getResources().getString(R.string.pop_up_attention)).mo11509b(C3171am.m11046a(this.f8511a.getResources().getString(R.string.toast_network_unable), this.f8511a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2221dr(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2220dq(this)).mo11505a();
                            this.f8511a.f8276P.show();
                            C3250y.m11442a("[Dev]Upload Address failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
