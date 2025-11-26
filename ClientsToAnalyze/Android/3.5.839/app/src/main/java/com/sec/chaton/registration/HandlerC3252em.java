package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.em */
/* loaded from: classes.dex */
class HandlerC3252em extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12019a;

    HandlerC3252em(FragmentRegist fragmentRegist) {
        this.f12019a = fragmentRegist;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            this.f12019a.f11735X.m9359b(this.f12019a.f11768h, this.f12019a.f11759ar.getText().toString(), this.f12019a.f11757ap);
            return;
        }
        if (this.f12019a.getActivity() != null) {
            if (this.f12019a.f11729R != null && this.f12019a.f11729R.isShowing()) {
                this.f12019a.f11729R.dismiss();
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12019a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            C4904y.m18639b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
            if (message.arg1 == 3004) {
                this.f12019a.f11743ab = AbstractC4932a.m18733a(this.f12019a.f11731T).mo18740a(this.f12019a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12019a.getResources().getString(R.string.alert_exist_imei_spp_serivce)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3254eo(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3253en(this)).mo18745a();
            } else {
                this.f12019a.f11743ab = AbstractC4932a.m18733a(this.f12019a.getActivity()).mo18740a(this.f12019a.getResources().getString(R.string.registration_samsung_push_service)).mo18749b(this.f12019a.getResources().getString(R.string.registration_push_fail_noti_comment)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3256eq(this)).mo18747b(R.string.registration_skip_button, new DialogInterfaceOnClickListenerC3255ep(this)).mo18745a();
            }
            this.f12019a.f11743ab.show();
        }
    }
}
