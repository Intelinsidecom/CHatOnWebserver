package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.dc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2617dc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9842a;

    DialogInterfaceOnClickListenerC2617dc(SoundDownloads soundDownloads) {
        this.f9842a = soundDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9842a.f9598g != null) {
            this.f9842a.f9598g.m9630e();
        }
    }
}
