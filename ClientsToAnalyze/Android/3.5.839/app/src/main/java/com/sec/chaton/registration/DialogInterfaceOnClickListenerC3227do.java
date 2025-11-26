package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.do */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3227do implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f11993a;

    DialogInterfaceOnClickListenerC3227do(FragmentRegist fragmentRegist) {
        this.f11993a = fragmentRegist;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C2349a.m10301a("for_wifi_only_device")) {
            C4809aa.m18105a("contact_sim_sync", Boolean.valueOf(this.f11993a.f11733V));
        }
        this.f11993a.m12936i();
        C2192f.m9877a();
        this.f11993a.f11734W.m9497a("append");
    }
}
