package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ec */
/* loaded from: classes.dex */
class ViewOnClickListenerC3242ec implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12009a;

    ViewOnClickListenerC3242ec(FragmentRegist fragmentRegist) {
        this.f12009a = fragmentRegist;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12009a.f11743ab != null) {
            this.f12009a.f11743ab.dismiss();
        }
        this.f12009a.m12934h();
        switch (view.getId()) {
            case R.id.dialog_regist_btnSMS /* 2131165536 */:
                this.f12009a.m12918a("SMS");
                break;
            case R.id.dialog_regist_btnVoice /* 2131165537 */:
                this.f12009a.m12918a("ACS");
                break;
        }
    }
}
