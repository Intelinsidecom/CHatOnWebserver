package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dy */
/* loaded from: classes.dex */
class ViewOnClickListenerC2228dy implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8522a;

    ViewOnClickListenerC2228dy(FragmentRegist fragmentRegist) {
        this.f8522a = fragmentRegist;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8522a.f8276P != null) {
            this.f8522a.f8276P.dismiss();
        }
        this.f8522a.m8592h();
        switch (view.getId()) {
            case R.id.dialog_regist_btnSMS /* 2131165499 */:
                this.f8522a.m8574a("SMS");
                break;
            case R.id.dialog_regist_btnVoice /* 2131165500 */:
                this.f8522a.m8574a("ACS");
                break;
        }
    }
}
