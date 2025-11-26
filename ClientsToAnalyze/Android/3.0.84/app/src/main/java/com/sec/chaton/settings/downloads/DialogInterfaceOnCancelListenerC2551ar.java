package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2551ar implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9698a;

    DialogInterfaceOnCancelListenerC2551ar(AniconPackageDownloads aniconPackageDownloads) {
        this.f9698a = aniconPackageDownloads;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9698a.f9480b.finish();
    }
}
