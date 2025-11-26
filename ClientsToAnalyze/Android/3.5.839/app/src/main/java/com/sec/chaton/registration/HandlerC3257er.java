package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.er */
/* loaded from: classes.dex */
class HandlerC3257er extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12024a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3257er(FragmentRegist fragmentRegist, Looper looper) {
        super(looper);
        this.f12024a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f12024a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 1104) {
                if (this.f12024a.getActivity() != null && this.f12024a.f11729R != null && this.f12024a.f11729R.isShowing()) {
                    this.f12024a.f11729R.dismiss();
                }
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && this.f12024a.getActivity() != null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                    }
                    this.f12024a.m12933g();
                } else if (this.f12024a.getActivity() != null) {
                    String strM3112g = c0778b.m3112g();
                    AbstractC4932a abstractC4932aMo18747b = AbstractC4932a.m18733a(this.f12024a.getActivity()).mo18740a(this.f12024a.getResources().getString(R.string.pop_up_attention)).mo18749b(C4822an.m18209a(this.f12024a.getResources().getString(R.string.toast_network_unable), this.f12024a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3259et(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3258es(this));
                    this.f12024a.f11743ab = C4859bx.m18375a(abstractC4932aMo18747b, this.f12024a.getActivity(), strM3112g).mo18745a();
                    if (this.f12024a.getActivity() != null) {
                        this.f12024a.f11743ab.show();
                    }
                    C4904y.m18634a("GET_VERSION_NOTICE failed becuase netwrok error", getClass().getSimpleName());
                }
            }
        }
    }
}
