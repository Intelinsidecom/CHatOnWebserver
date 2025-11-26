package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3220dh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11985a;

    DialogInterfaceOnClickListenerC3220dh(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11985a = fragmentNonSelfSMS;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f11985a.f11674K) {
            C4809aa.m18104a().m18123a("msisdn_temp");
        }
        C4809aa.m18104a().m18123a("phonenumber");
        if (!C2349a.m10301a("for_wifi_only_device")) {
            C4809aa.m18105a("contact_sim_sync", Boolean.valueOf(this.f11985a.f11672I));
        }
        if (this.f11985a.f11676M) {
            this.f11985a.m12889j();
            C2192f.m9877a();
            this.f11985a.f11668E.m9497a("append");
        } else if (this.f11985a.getActivity() != null) {
            this.f11985a.getActivity().setResult(-1, new Intent());
            this.f11985a.getActivity().finish();
        }
    }
}
