package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.ch */
/* loaded from: classes.dex */
class C2184ch extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8471a;

    C2184ch(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8471a = fragmentGlobalDisclaimer;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i = intent.getExtras().getInt("which_service");
        if (this.f8471a.getActivity() != null) {
            this.f8471a.f8215c = ProgressDialogC3265l.m11489a(this.f8471a.getActivity(), null, this.f8471a.getResources().getString(R.string.dialog_provision_ing));
        }
        if (i == 0) {
            this.f8471a.f8217e.m5693a("FIRST");
        } else if (i == 2) {
            this.f8471a.f8217e.m5693a("FIRST");
        }
    }
}
