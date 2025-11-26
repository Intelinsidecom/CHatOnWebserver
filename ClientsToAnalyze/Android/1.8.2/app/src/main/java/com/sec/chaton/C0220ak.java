package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.ak */
/* loaded from: classes.dex */
class C0220ak extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f755a;

    C0220ak(HomeTabFragment homeTabFragment) {
        this.f755a = homeTabFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f755a.m613a();
    }
}
