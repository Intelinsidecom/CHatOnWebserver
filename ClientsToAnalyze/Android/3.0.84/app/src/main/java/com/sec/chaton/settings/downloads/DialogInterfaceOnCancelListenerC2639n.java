package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.n */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2639n implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9882a;

    DialogInterfaceOnCancelListenerC2639n(AmsItemDownloads amsItemDownloads) {
        this.f9882a = amsItemDownloads;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9882a.m9300j();
    }
}
