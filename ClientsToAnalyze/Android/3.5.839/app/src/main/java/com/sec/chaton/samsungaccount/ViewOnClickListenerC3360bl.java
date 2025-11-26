package com.sec.chaton.samsungaccount;

import android.view.View;
import com.sec.chaton.global.C2349a;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC3360bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12298a;

    ViewOnClickListenerC3360bl(MainActivity mainActivity) {
        this.f12298a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12298a.f12170x = true;
        if (!C2349a.m10301a("mum_enable_feature")) {
            this.f12298a.m13142k();
        } else {
            this.f12298a.m13140b(true);
        }
    }
}
