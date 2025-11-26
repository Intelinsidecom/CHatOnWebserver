package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cj */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC4155cj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Runnable f15461a;

    DialogInterfaceOnClickListenerC4155cj(Runnable runnable) {
        this.f15461a = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f15461a != null) {
            this.f15461a.run();
        }
        dialogInterface.dismiss();
    }
}
