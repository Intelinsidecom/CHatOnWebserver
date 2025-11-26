package com.sec.chaton.samsungaccount;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.k */
/* loaded from: classes.dex */
class HandlerC3391k extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12352a;

    HandlerC3391k(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12352a = abstractMultiDeviceActivity;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (!this.f12352a.f12166t && !this.f12352a.isFinishing() && message.what == 1001) {
            if (!((Boolean) message.obj).booleanValue()) {
                if (this.f12352a.f12129U != null && this.f12352a.f12129U.isShowing()) {
                    this.f12352a.f12129U.dismiss();
                    this.f12352a.f12145ak = null;
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12352a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (C4904y.f17875e) {
                    C4904y.m18634a("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()) + " Error is : " + message.arg1, this.f12352a.f12139ae);
                }
                if (message.arg1 == 3004) {
                    this.f12352a.f12141ag = AbstractC4932a.m18733a(this.f12352a.f12118J).mo18740a(this.f12352a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12352a.getResources().getString(R.string.alert_exist_imei_spp_serivce)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3393m(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3392l(this)).mo18745a();
                    if (!this.f12352a.f12166t) {
                        this.f12352a.f12141ag.show();
                        return;
                    }
                    return;
                }
                this.f12352a.f12141ag = AbstractC4932a.m18733a(this.f12352a.f12118J).mo18740a(this.f12352a.getResources().getString(R.string.registration_samsung_push_service)).mo18749b(this.f12352a.getResources().getString(R.string.registration_push_fail_noti_comment)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3395o(this)).mo18747b(R.string.registration_skip_button, new DialogInterfaceOnClickListenerC3394n(this)).mo18745a();
                if (!this.f12352a.f12166t) {
                    this.f12352a.f12141ag.show();
                    return;
                }
                return;
            }
            C4904y.m18639b("Push registration success.", this.f12352a.f12139ae);
            if (!this.f12352a.f12169w) {
                this.f12352a.f12119K.m9390b();
            } else {
                this.f12352a.mo12790j();
            }
        }
    }
}
