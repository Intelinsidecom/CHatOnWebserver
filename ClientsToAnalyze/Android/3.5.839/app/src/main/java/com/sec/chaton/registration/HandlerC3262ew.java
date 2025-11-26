package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ew */
/* loaded from: classes.dex */
class HandlerC3262ew extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f12029a;

    HandlerC3262ew(FragmentRegistPushName fragmentRegistPushName) {
        this.f12029a = fragmentRegistPushName;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            this.f12029a.m12972c();
        } else if (this.f12029a.getActivity() != null) {
            this.f12029a.m12975d();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12029a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            if (C4904y.f17875e) {
                C4904y.m18634a("[Dev]Push registration failed. Error is " + message.arg1 + " Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), getClass().getSimpleName());
            }
            if (message.arg1 == 3004) {
                this.f12029a.f11808v = AbstractC4932a.m18733a(this.f12029a.f11788b).mo18740a(this.f12029a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12029a.getResources().getString(R.string.alert_exist_imei_spp_serivce)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3264ey(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3263ex(this)).mo18745a();
            } else {
                this.f12029a.f11808v = AbstractC4932a.m18733a(this.f12029a.getActivity()).mo18740a(this.f12029a.getResources().getString(R.string.registration_samsung_push_service)).mo18749b(this.f12029a.getResources().getString(R.string.registration_push_fail_noti_comment)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3267fa(this)).mo18747b(R.string.registration_skip_button, new DialogInterfaceOnClickListenerC3265ez(this)).mo18745a();
            }
            this.f12029a.f11808v.show();
        } else {
            return;
        }
        if (this.f12029a.f11805s != null) {
            this.f12029a.f11805s.setEnabled(true);
        }
    }
}
