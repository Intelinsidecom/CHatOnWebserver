package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cn */
/* loaded from: classes.dex */
class C0583cn extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2545a;

    C0583cn(BuddyFragment buddyFragment) {
        this.f2545a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f2545a.m3400q() != 1) {
            this.f2545a.f1760X.setVisibility(8);
            this.f2545a.f1761Y.setVisibility(8);
        } else {
            if (C1954g.m7916a().m7918a(this.f2545a.getActivity(), EnumC1955h.ChatONV)) {
                this.f2545a.f1760X.setVisibility(0);
                this.f2545a.f1761Y.setVisibility(0);
                return;
            }
            C0045a c0045a = this.f2545a.f1884j;
            if (!C0045a.m37b(this.f2545a.getActivity())) {
                this.f2545a.f1760X.setVisibility(0);
                this.f2545a.f1761Y.setVisibility(0);
            }
        }
    }
}
