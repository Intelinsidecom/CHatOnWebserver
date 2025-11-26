package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentDisclaimer.java */
/* renamed from: com.sec.chaton.registration.bw */
/* loaded from: classes.dex */
class ViewOnClickListenerC2172bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimer f8457a;

    ViewOnClickListenerC2172bw(FragmentDisclaimer fragmentDisclaimer) {
        this.f8457a = fragmentDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f8457a.f8207b = ProgressDialogC3265l.m11489a(this.f8457a.f8209d, null, this.f8457a.getResources().getString(R.string.dialog_provision_ing));
        new C1324bj(this.f8457a.f8206a).m5693a(this.f8457a.f8208c);
    }
}
