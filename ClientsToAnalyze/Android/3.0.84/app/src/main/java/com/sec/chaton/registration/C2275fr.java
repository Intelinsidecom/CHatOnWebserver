package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.fr */
/* loaded from: classes.dex */
class C2275fr extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerFragment f8571a;

    C2275fr(NewDisclaimerFragment newDisclaimerFragment) {
        this.f8571a = newDisclaimerFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i = intent.getExtras().getInt("which_service");
        this.f8571a.m8658b();
        if (i == 0) {
            this.f8571a.f8370l.m5693a("FIRST");
        } else if (i == 2) {
            this.f8571a.f8370l.m5693a("FIRST");
        }
    }
}
