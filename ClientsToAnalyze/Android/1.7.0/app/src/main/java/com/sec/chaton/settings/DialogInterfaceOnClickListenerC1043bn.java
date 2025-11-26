package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: RingtonePreference.java */
/* renamed from: com.sec.chaton.settings.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1043bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference f3654a;

    DialogInterfaceOnClickListenerC1043bn(RingtonePreference ringtonePreference) {
        this.f3654a = ringtonePreference;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3654a.callChangeListener(this.f3654a.f3595e);
        this.f3654a.m3906a(this.f3654a.f3595e);
    }
}
