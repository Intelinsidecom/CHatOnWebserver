package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.ba */
/* loaded from: classes.dex */
class C1030ba extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f3634a;

    C1030ba(PhoneSettingFragment phoneSettingFragment) {
        this.f3634a = phoneSettingFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f3634a.m3889f();
    }
}
