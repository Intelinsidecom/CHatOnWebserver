package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cl */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4157cl implements DialogInterface.OnKeyListener {
    private DialogInterfaceOnKeyListenerC4157cl() {
    }

    /* synthetic */ DialogInterfaceOnKeyListenerC4157cl(DialogInterfaceOnClickListenerC4150ce dialogInterfaceOnClickListenerC4150ce) {
        this();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
