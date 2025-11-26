package com.sec.chaton.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.t */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4927t implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ProgressDialogC4926s f17988a;

    DialogInterfaceOnKeyListenerC4927t(ProgressDialogC4926s progressDialogC4926s) {
        this.f17988a = progressDialogC4926s;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
