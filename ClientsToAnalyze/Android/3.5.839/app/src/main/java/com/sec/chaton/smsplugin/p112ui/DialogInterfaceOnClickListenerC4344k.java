package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: ClassZeroActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4344k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ClassZeroActivity f15781a;

    DialogInterfaceOnClickListenerC4344k(ClassZeroActivity classZeroActivity) {
        this.f15781a = classZeroActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f15781a.finish();
    }
}
