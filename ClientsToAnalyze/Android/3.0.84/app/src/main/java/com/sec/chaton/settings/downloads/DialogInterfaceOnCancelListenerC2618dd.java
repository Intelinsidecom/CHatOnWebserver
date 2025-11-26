package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.dd */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2618dd implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9843a;

    DialogInterfaceOnCancelListenerC2618dd(SoundDownloads soundDownloads) {
        this.f9843a = soundDownloads;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9843a.f9593b.finish();
    }
}
