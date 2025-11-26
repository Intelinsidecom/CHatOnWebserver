package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.da */
/* loaded from: classes.dex */
class C1191da extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4419a;

    C1191da(BuddyFragment buddyFragment) {
        this.f4419a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f4419a.m6557p() != 1) {
            this.f4419a.f3653ah.setVisibility(8);
            this.f4419a.f3654ai.setVisibility(8);
        } else {
            if (C2948h.m12190a().m12192a(this.f4419a.getActivity(), EnumC2949i.ChatONV)) {
                this.f4419a.f3653ah.setVisibility(0);
                this.f4419a.f3654ai.setVisibility(0);
                return;
            }
            C0416a c0416a = this.f4419a.f3766i;
            if (!C0416a.m1477b(this.f4419a.getActivity())) {
                this.f4419a.f3653ah.setVisibility(0);
                this.f4419a.f3654ai.setVisibility(0);
            }
        }
    }
}
