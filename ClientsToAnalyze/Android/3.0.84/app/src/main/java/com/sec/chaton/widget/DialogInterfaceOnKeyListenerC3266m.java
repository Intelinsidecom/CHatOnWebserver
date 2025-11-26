package com.sec.chaton.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.m */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC3266m implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialogC3265l f11791a;

    DialogInterfaceOnKeyListenerC3266m(ProgressDialogC3265l progressDialogC3265l) {
        this.f11791a = progressDialogC3265l;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
