package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.l */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2637l implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AmsItemDownloads f9880a;

    DialogInterfaceOnCancelListenerC2637l(AmsItemDownloads amsItemDownloads) {
        this.f9880a = amsItemDownloads;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9880a.f9430b.finish();
    }
}
