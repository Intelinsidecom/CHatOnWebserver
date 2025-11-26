package com.sec.chaton.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.k */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1807k implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialogC1806j f6499a;

    DialogInterfaceOnKeyListenerC1807k(ProgressDialogC1806j progressDialogC1806j) {
        this.f6499a = progressDialogC1806j;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
