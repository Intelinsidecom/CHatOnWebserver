package com.sec.chaton.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* renamed from: com.sec.chaton.widget.a */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC0620a implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ SMSProgressBar f3803a;

    DialogInterfaceOnKeyListenerC0620a(SMSProgressBar sMSProgressBar) {
        this.f3803a = sMSProgressBar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 84;
    }
}
