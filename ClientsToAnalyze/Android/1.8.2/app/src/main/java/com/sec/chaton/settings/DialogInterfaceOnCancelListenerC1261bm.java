package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: BuddiesSaySettings.java */
/* renamed from: com.sec.chaton.settings.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1261bm implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ BuddiesSaySettings f4802a;

    DialogInterfaceOnCancelListenerC1261bm(BuddiesSaySettings buddiesSaySettings) {
        this.f4802a = buddiesSaySettings;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4802a.f4579j.m2903c();
        this.f4802a.f4583n = true;
        this.f4802a.finish();
    }
}
