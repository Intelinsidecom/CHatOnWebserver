package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bc */
/* loaded from: classes.dex */
class HandlerC3351bc extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12289a;

    HandlerC3351bc(MainActivity mainActivity) {
        this.f12289a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f12289a.f12166t) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 208:
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12289a.m13186w();
                        String strM3112g = c0778b.m3112g();
                        AbstractC4932a abstractC4932aMo18747b = AbstractC4932a.m18733a(this.f12289a).mo18740a(this.f12289a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12289a.getResources().getString(R.string.toast_network_unable), this.f12289a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3358bj(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3357bi(this));
                        this.f12289a.f12230an = C4859bx.m18375a(abstractC4932aMo18747b, this.f12289a, strM3112g).mo18745a();
                        if (!this.f12289a.f12166t) {
                            this.f12289a.f12230an.show();
                            break;
                        }
                    } else {
                        C4809aa.m18108a("register_sns_type", this.f12289a.f12193C.m9424a());
                        this.f12289a.f12193C.m9432g();
                        break;
                    }
                    break;
                case 210:
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12289a.m13186w();
                        String strM3112g2 = c0778b.m3112g();
                        AbstractC4932a abstractC4932aMo18747b2 = AbstractC4932a.m18733a(this.f12289a).mo18740a(this.f12289a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12289a.getResources().getString(R.string.toast_network_unable), this.f12289a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3356bh(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3355bg(this));
                        this.f12289a.f12230an = C4859bx.m18375a(abstractC4932aMo18747b2, this.f12289a, strM3112g2).mo18745a();
                        if (!this.f12289a.f12166t) {
                            this.f12289a.f12230an.show();
                            break;
                        }
                    } else {
                        CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0778b.m3110e();
                        if (checkInRegisterParamEntry != null) {
                            if (checkInRegisterParamEntry.exist_imei == null || !checkInRegisterParamEntry.exist_imei.booleanValue()) {
                                this.f12289a.f12231ao.m9357b(this.f12289a.f12193C);
                                break;
                            } else {
                                AbstractC4932a.m18733a(this.f12289a.f12192B).mo18740a(this.f12289a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12289a.getResources().getString(R.string.register_with_sns_already_registered_alert)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3354bf(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3353be(this)).mo18737a(new DialogInterfaceOnCancelListenerC3352bd(this)).mo18745a().show();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
