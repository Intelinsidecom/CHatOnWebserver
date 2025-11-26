package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2568bh implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FontDownloads f9748a;

    DialogInterfaceOnCancelListenerC2568bh(FontDownloads fontDownloads) {
        this.f9748a = fontDownloads;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9748a.f9524c.finish();
    }
}
