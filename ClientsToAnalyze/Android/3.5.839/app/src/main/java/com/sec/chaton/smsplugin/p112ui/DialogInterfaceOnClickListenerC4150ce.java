package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ce */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC4150ce implements DialogInterface.OnClickListener {
    DialogInterfaceOnClickListenerC4150ce() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            dialogInterface.dismiss();
        }
    }
}
