package com.sec.chaton.samsungaccount;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bb */
/* loaded from: classes.dex */
class ViewOnClickListenerC3350bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12288a;

    ViewOnClickListenerC3350bb(MainActivity mainActivity) {
        this.f12288a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_phone_number /* 2131165964 */:
                this.f12288a.f12164r = true;
                this.f12288a.m13146o();
                break;
            case R.id.btn_samsung_account /* 2131165966 */:
            case R.id.btn_next /* 2131165970 */:
                this.f12288a.f12170x = true;
                if (!C2349a.m10301a("mum_enable_feature")) {
                    this.f12288a.m13142k();
                    break;
                } else {
                    this.f12288a.m13140b(true);
                    break;
                }
            case R.id.sns_or_skip /* 2131165967 */:
                this.f12288a.m13145n();
                break;
        }
    }
}
