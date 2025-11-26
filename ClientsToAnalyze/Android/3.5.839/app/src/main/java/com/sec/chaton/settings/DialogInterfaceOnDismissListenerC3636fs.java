package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.fs */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC3636fs implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f13197a;

    DialogInterfaceOnDismissListenerC3636fs(RingtonePreference2 ringtonePreference2) {
        this.f13197a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f13197a.f12818b != null) {
            this.f13197a.f12818b.stopPreviousRingtone();
        }
        if (this.f13197a.f12821e != null) {
            this.f13197a.f12821e.m11425a();
            this.f13197a.f12821e = null;
        }
    }
}
