package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cx */
/* loaded from: classes.dex */
class C0593cx extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2556a;

    private C0593cx(BuddyFragment buddyFragment) {
        this.f2556a = buddyFragment;
    }

    /* synthetic */ C0593cx(BuddyFragment buddyFragment, ViewOnClickListenerC0544bb viewOnClickListenerC0544bb) {
        this(buddyFragment);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2556a.m3214A();
    }
}
