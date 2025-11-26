package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.eu */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC2684eu implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f9977a;

    DialogInterfaceOnDismissListenerC2684eu(RingtonePreference2 ringtonePreference2) {
        this.f9977a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f9977a.f9243b != null) {
            this.f9977a.f9243b.stopPreviousRingtone();
        }
        if (this.f9977a.f9246e != null) {
            this.f9977a.f9246e.m7285a();
            this.f9977a.f9246e = null;
        }
    }
}
