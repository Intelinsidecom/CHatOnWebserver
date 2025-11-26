package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2635j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9878a;

    DialogInterfaceOnClickListenerC2635j(AmsItemDownloads amsItemDownloads) {
        this.f9878a = amsItemDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9878a.f9436h != null) {
            this.f9878a.f9436h.m9431d();
        }
    }
}
