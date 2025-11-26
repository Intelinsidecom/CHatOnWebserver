package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.ar */
/* loaded from: classes.dex */
class C0227ar extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f761a;

    C0227ar(HomeTabletFragment homeTabletFragment) {
        this.f761a = homeTabletFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f761a.m643h();
    }
}
