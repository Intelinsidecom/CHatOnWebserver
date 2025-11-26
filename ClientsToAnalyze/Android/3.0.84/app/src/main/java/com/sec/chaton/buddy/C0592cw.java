package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cw */
/* loaded from: classes.dex */
class C0592cw extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2555a;

    private C0592cw(BuddyFragment buddyFragment) {
        this.f2555a = buddyFragment;
    }

    /* synthetic */ C0592cw(BuddyFragment buddyFragment, ViewOnClickListenerC0544bb viewOnClickListenerC0544bb) {
        this(buddyFragment);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f2555a.f1862bx) {
            this.f2555a.m3241O();
            this.f2555a.m3244P();
        }
    }
}
