package com.sec.chaton.samsungaccount;

import android.view.View;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4847bl;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bk */
/* loaded from: classes.dex */
class ViewOnClickListenerC3359bk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12297a;

    ViewOnClickListenerC3359bk(MainActivity mainActivity) {
        this.f12297a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12297a.f12170x = true;
            if (!C2349a.m10301a("mum_enable_feature")) {
                this.f12297a.m13142k();
            } else {
                this.f12297a.m13140b(true);
            }
        }
    }
}
