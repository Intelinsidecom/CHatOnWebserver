package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.ca */
/* loaded from: classes.dex */
class ViewOnClickListenerC2177ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8463a;

    ViewOnClickListenerC2177ca(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8463a = fragmentGlobalDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f8463a.f8215c = ProgressDialogC3265l.m11489a(this.f8463a.getActivity(), null, this.f8463a.getResources().getString(R.string.dialog_provision_ing));
        this.f8463a.f8216d.m5775a();
    }
}
