package com.sec.chaton.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.b */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1355b implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialogC1354a f4614a;

    DialogInterfaceOnKeyListenerC1355b(ProgressDialogC1354a progressDialogC1354a) {
        this.f4614a = progressDialogC1354a;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
