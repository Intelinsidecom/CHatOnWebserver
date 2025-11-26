package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bm */
/* loaded from: classes.dex */
class C3171bm extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11923a;

    C3171bm(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11923a = fragmentDisclaimerGlobal;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getBoolean("isCritical")) {
                this.f11923a.getActivity().finish();
                return;
            }
            int i = extras.getInt("which_service");
            this.f11923a.m12844a();
            if (i == 0) {
                this.f11923a.f11641o.m9470a("FIRST");
                return;
            } else {
                if (i == 2) {
                    this.f11923a.f11641o.m9470a("FIRST");
                    return;
                }
                return;
            }
        }
        this.f11923a.getActivity().finish();
    }
}
