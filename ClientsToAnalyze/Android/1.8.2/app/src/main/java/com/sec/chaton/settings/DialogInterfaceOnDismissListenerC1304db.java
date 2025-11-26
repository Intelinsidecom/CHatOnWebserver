package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: RingtonePreference.java */
/* renamed from: com.sec.chaton.settings.db */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1304db implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference f4871a;

    DialogInterfaceOnDismissListenerC1304db(RingtonePreference ringtonePreference) {
        this.f4871a = ringtonePreference;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f4871a.f4716a.stopPreviousRingtone();
    }
}
