package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2550aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9697a;

    DialogInterfaceOnClickListenerC2550aq(AniconPackageDownloads aniconPackageDownloads) {
        this.f9697a = aniconPackageDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9697a.f9485g != null) {
            this.f9697a.f9485g.m9484d();
        }
    }
}
