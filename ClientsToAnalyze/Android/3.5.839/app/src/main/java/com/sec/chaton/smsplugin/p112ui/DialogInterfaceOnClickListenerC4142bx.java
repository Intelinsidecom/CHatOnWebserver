package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4142bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15422a;

    private DialogInterfaceOnClickListenerC4142bx(C4132bn c4132bn) {
        this.f15422a = c4132bn;
    }

    /* synthetic */ DialogInterfaceOnClickListenerC4142bx(C4132bn c4132bn, RunnableC4133bo runnableC4133bo) {
        this(c4132bn);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
