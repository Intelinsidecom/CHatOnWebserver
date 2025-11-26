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

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dp */
/* loaded from: classes.dex */
class HandlerC3228dp extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f11994a;

    HandlerC3228dp(FragmentRegist fragmentRegist) {
        this.f11994a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11994a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 301:
                    this.f11994a.m12939j();
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        if (this.f11994a.getActivity() != null && this.f11994a.f11730S != null && this.f11994a.f11730S.isShowing()) {
                            this.f11994a.f11730S.dismiss();
                        }
                        if (this.f11994a.getActivity() != null) {
                            if (EnumC3297gd.auto_register.equals(this.f11994a.f11752ak)) {
                                this.f11994a.getActivity().setResult(4);
                                this.f11994a.getActivity().finish();
                                break;
                            } else {
                                this.f11994a.getActivity().setResult(-1);
                                this.f11994a.getActivity().finish();
                                break;
                            }
                        }
                    } else {
                        if (this.f11994a.getActivity() != null && this.f11994a.f11730S != null && this.f11994a.f11730S.isShowing()) {
                            this.f11994a.f11730S.dismiss();
                        }
                        if (this.f11994a.getActivity() != null) {
                            String strM3112g = c0778b.m3112g();
                            this.f11994a.f11743ab = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11994a.getActivity()).mo18740a(this.f11994a.getResources().getString(R.string.pop_up_attention)).mo18749b(C4822an.m18209a(this.f11994a.getResources().getString(R.string.toast_network_unable), this.f11994a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3230dr(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3229dq(this)), this.f11994a.getActivity(), strM3112g).mo18745a();
                            if (EnumC3297gd.auto_register.equals(this.f11994a.f11752ak)) {
                                this.f11994a.f11743ab.setCancelable(false);
                            }
                            this.f11994a.f11743ab.show();
                        }
                        C4904y.m18634a("[Dev]Get All buddy failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                        break;
                    }
                    break;
                case 302:
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f11994a.f11734W.m9495a();
                        break;
                    } else if (c0778b.m3107b() == EnumC2464o.NO_REQUEST) {
                        this.f11994a.f11734W.m9495a();
                        break;
                    } else {
                        if (this.f11994a.getActivity() != null && this.f11994a.f11730S != null && this.f11994a.f11730S.isShowing()) {
                            this.f11994a.f11730S.dismiss();
                        }
                        this.f11994a.m12939j();
                        if (this.f11994a.getActivity() != null) {
                            String strM3112g2 = c0778b.m3112g();
                            this.f11994a.f11743ab = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11994a.getActivity()).mo18740a(this.f11994a.getResources().getString(R.string.pop_up_attention)).mo18749b(C4822an.m18209a(this.f11994a.getResources().getString(R.string.toast_network_unable), this.f11994a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3232dt(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3231ds(this)), this.f11994a.getActivity(), strM3112g2).mo18745a();
                            if (EnumC3297gd.auto_register.equals(this.f11994a.f11752ak)) {
                                this.f11994a.f11743ab.setCancelable(false);
                            }
                            this.f11994a.f11743ab.show();
                            C4904y.m18634a("[Dev]Upload Address failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
