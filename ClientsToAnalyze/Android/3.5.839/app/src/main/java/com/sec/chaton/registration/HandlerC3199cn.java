package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cn */
/* loaded from: classes.dex */
class HandlerC3199cn extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11963a;

    HandlerC3199cn(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11963a = fragmentNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11963a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 301:
                    this.f11963a.m12892k();
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        if (this.f11963a.getActivity() != null) {
                            this.f11963a.getActivity().setResult(-1);
                            this.f11963a.getActivity().finish();
                            break;
                        }
                    } else {
                        String strM3112g = "";
                        if (c0778b != null) {
                            strM3112g = c0778b.m3112g();
                        }
                        if (this.f11963a.getActivity() != null) {
                            this.f11963a.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11963a.getActivity()).mo18740a(this.f11963a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f11963a.getResources().getString(R.string.toast_network_unable), this.f11963a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3201cp(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3200co(this)), this.f11963a.getActivity(), strM3112g).mo18745a();
                            this.f11963a.f11671H.show();
                        }
                        try {
                            C4904y.m18634a("[Dev]Get All buddy failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                            break;
                        } catch (NullPointerException e) {
                            C4904y.m18634a("[Dev]Get All buddy failed. httpStatus: " + e.toString(), getClass().getSimpleName());
                            return;
                        }
                    }
                    break;
                case 302:
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f11963a.f11668E.m9495a();
                        break;
                    } else if (c0778b == null || c0778b.m3107b() != EnumC2464o.NO_REQUEST) {
                        this.f11963a.m12892k();
                        String strM3112g2 = "";
                        if (c0778b != null) {
                            strM3112g2 = c0778b.m3112g();
                        }
                        if (this.f11963a.getActivity() != null) {
                            this.f11963a.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11963a.getActivity()).mo18740a(this.f11963a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f11963a.getResources().getString(R.string.toast_network_unable), this.f11963a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3203cr(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3202cq(this)), this.f11963a.getActivity(), strM3112g2).mo18745a();
                            this.f11963a.f11671H.show();
                            if (c0778b != null) {
                                try {
                                    C4904y.m18634a("[Dev]Upload Address failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                                    break;
                                } catch (NullPointerException e2) {
                                    C4904y.m18634a("[Dev]Get All buddy failed. httpStatus: " + e2.toString(), getClass().getSimpleName());
                                    return;
                                }
                            }
                        }
                    } else {
                        this.f11963a.f11668E.m9495a();
                        break;
                    }
                    break;
            }
        }
    }
}
