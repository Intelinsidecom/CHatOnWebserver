package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.cs */
/* loaded from: classes.dex */
class C1294cs extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f4845a;

    C1294cs(PhoneSettingFragment phoneSettingFragment) {
        this.f4845a = phoneSettingFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f4845a.m4683g();
    }
}
