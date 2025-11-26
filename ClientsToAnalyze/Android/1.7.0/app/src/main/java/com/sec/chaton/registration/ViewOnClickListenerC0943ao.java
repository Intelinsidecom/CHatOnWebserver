package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0218q;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: ActivityDisclaimer.java */
/* renamed from: com.sec.chaton.registration.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC0943ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDisclaimer f3330a;

    ViewOnClickListenerC0943ao(ActivityDisclaimer activityDisclaimer) {
        this.f3330a = activityDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3330a.f3150b = ProgressDialogC1354a.m4724a(this.f3330a, null, this.f3330a.getResources().getString(R.string.dialog_connecting_server), true);
        new C0218q(this.f3330a.f3149a).m800a(this.f3330a.f3151c);
    }
}
