package com.sec.chaton.samsungaccount;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ak */
/* loaded from: classes.dex */
class HandlerC2322ak extends HandlerC3176ar {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8744a;

    HandlerC2322ak(MainActivity mainActivity) {
        this.f8744a = mainActivity;
    }

    @Override // com.sec.chaton.util.HandlerC3176ar
    /* renamed from: a */
    public void mo3031a(Message message) {
        if (!this.f8744a.f8695aq && !this.f8744a.isFinishing() && message.what == 1001) {
            if (!((Boolean) message.obj).booleanValue()) {
                if (this.f8744a.f8729z != null && this.f8744a.f8729z.isShowing()) {
                    this.f8744a.f8729z.dismiss();
                    this.f8744a.f8696ar = null;
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8744a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (C3250y.f11734b) {
                    C3250y.m11450b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()) + " Error is : " + message.arg1, this.f8744a.f8672W);
                }
                if (message.arg1 == 3004) {
                    this.f8744a.f8689ak = AbstractC3271a.m11494a(this.f8744a.f8714k).mo11500a(this.f8744a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8744a.getResources().getString(R.string.alert_exist_imei_spp_serivce)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2324am(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2323al(this)).mo11505a();
                    if (!this.f8744a.f8695aq) {
                        this.f8744a.f8689ak.show();
                        return;
                    }
                    return;
                }
                this.f8744a.f8689ak = AbstractC3271a.m11494a(this.f8744a.f8714k).mo11500a(this.f8744a.getResources().getString(R.string.registration_samsung_push_service)).mo11509b(this.f8744a.getResources().getString(R.string.registration_push_fail_noti_comment)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2326ao(this)).mo11507b(R.string.registration_skip_button, new DialogInterfaceOnClickListenerC2325an(this)).mo11505a();
                if (!this.f8744a.f8695aq) {
                    this.f8744a.f8689ak.show();
                    return;
                }
                return;
            }
            C3250y.m11450b("Push registration success.", this.f8744a.f8672W);
            this.f8744a.f8716m.m5617b();
        }
    }
}
