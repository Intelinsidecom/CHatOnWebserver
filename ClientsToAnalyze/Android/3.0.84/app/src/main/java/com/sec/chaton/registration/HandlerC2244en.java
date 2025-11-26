package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.en */
/* loaded from: classes.dex */
class HandlerC2244en extends HandlerC3176ar {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f8539a;

    HandlerC2244en(FragmentRegistPushName fragmentRegistPushName) {
        this.f8539a = fragmentRegistPushName;
    }

    @Override // com.sec.chaton.util.HandlerC3176ar
    /* renamed from: a */
    public void mo3031a(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            this.f8539a.m8619c();
        } else if (this.f8539a.getActivity() != null) {
            this.f8539a.m8622d();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8539a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            C3250y.m11450b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
            if (message.arg1 == 3004) {
                this.f8539a.f8334v = AbstractC3271a.m11494a(this.f8539a.f8314b).mo11500a(this.f8539a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8539a.getResources().getString(R.string.alert_exist_imei_spp_serivce)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2246ep(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2245eo(this)).mo11505a();
            } else {
                this.f8539a.f8334v = AbstractC3271a.m11494a(this.f8539a.getActivity()).mo11500a(this.f8539a.getResources().getString(R.string.registration_samsung_push_service)).mo11509b(this.f8539a.getResources().getString(R.string.registration_push_fail_noti_comment)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2248er(this)).mo11507b(R.string.registration_skip_button, new DialogInterfaceOnClickListenerC2247eq(this)).mo11505a();
            }
            this.f8539a.f8334v.show();
        } else {
            return;
        }
        this.f8539a.f8331s.setEnabled(true);
    }
}
