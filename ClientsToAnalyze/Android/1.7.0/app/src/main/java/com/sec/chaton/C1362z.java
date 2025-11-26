package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.z */
/* loaded from: classes.dex */
class C1362z extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f4621a;

    C1362z(HomeTabFragment homeTabFragment) {
        this.f4621a = homeTabFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f4621a.m658a();
    }
}
