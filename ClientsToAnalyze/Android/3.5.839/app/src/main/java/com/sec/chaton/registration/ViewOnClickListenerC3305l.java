package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4847bl;

/* compiled from: ActivitySignInWithAccount.java */
/* renamed from: com.sec.chaton.registration.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC3305l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySignInWithAccount f12082a;

    ViewOnClickListenerC3305l(ActivitySignInWithAccount activitySignInWithAccount) {
        this.f12082a = activitySignInWithAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12082a.f12170x = true;
            if (!C2349a.m10301a("mum_enable_feature")) {
                this.f12082a.m13142k();
            } else {
                this.f12082a.m13140b(true);
            }
        }
    }
}
