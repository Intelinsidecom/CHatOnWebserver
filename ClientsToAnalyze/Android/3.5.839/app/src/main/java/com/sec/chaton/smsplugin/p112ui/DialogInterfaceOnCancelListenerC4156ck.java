package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ck */
/* loaded from: classes.dex */
final class DialogInterfaceOnCancelListenerC4156ck implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ Runnable f15462a;

    DialogInterfaceOnCancelListenerC4156ck(Runnable runnable) {
        this.f15462a = runnable;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f15462a != null) {
            this.f15462a.run();
        }
        dialogInterface.dismiss();
    }
}
