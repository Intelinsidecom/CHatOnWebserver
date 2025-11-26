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

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cm */
/* loaded from: classes.dex */
class HandlerC2189cm extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8481a;

    HandlerC2189cm(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8481a = fragmentNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (this.f8481a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 301:
                    if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        if (this.f8481a.getActivity() != null && this.f8481a.f8246n != null && this.f8481a.f8246n.isShowing()) {
                            this.f8481a.f8246n.dismiss();
                        }
                        if (this.f8481a.getActivity() != null) {
                            this.f8481a.getActivity().setResult(-1);
                            this.f8481a.getActivity().finish();
                            break;
                        }
                    } else {
                        if (this.f8481a.getActivity() != null) {
                            this.f8481a.f8246n.dismiss();
                        }
                        String strM1356g = c0267d.m1356g();
                        if (this.f8481a.getActivity() != null) {
                            this.f8481a.f8226G = AbstractC3271a.m11494a(this.f8481a.getActivity()).mo11500a(this.f8481a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8481a.getResources().getString(R.string.toast_network_unable), this.f8481a.getResources().getString(R.string.toast_error), strM1356g)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2191co(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2190cn(this)).mo11505a();
                            this.f8481a.f8226G.show();
                        }
                        C3250y.m11442a("[Dev]Get All buddy failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                        break;
                    }
                    break;
                case HttpResponseCode.FOUND /* 302 */:
                    if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8481a.f8223D.m5717a();
                        break;
                    } else if (c0267d != null && c0267d.m1351b() == EnumC1587o.NO_REQUEST) {
                        this.f8481a.f8223D.m5717a();
                        break;
                    } else {
                        if (this.f8481a.getActivity() != null && this.f8481a.f8246n != null && this.f8481a.f8246n.isShowing()) {
                            this.f8481a.f8246n.dismiss();
                        }
                        String strM1356g2 = c0267d.m1356g();
                        if (this.f8481a.getActivity() != null) {
                            this.f8481a.f8226G = AbstractC3271a.m11494a(this.f8481a.getActivity()).mo11500a(this.f8481a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8481a.getResources().getString(R.string.toast_network_unable), this.f8481a.getResources().getString(R.string.toast_error), strM1356g2)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2193cq(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2192cp(this)).mo11505a();
                            this.f8481a.f8226G.show();
                            C3250y.m11442a("[Dev]Upload Address failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
