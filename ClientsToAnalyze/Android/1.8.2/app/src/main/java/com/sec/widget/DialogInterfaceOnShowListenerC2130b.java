package com.sec.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.b */
/* loaded from: classes.dex */
class DialogInterfaceOnShowListenerC2130b implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialog f7774a;

    /* renamed from: b */
    final /* synthetic */ AlertDialogBuilderC2120a f7775b;

    DialogInterfaceOnShowListenerC2130b(AlertDialogBuilderC2120a alertDialogBuilderC2120a, AlertDialog alertDialog) {
        this.f7775b = alertDialogBuilderC2120a;
        this.f7774a = alertDialog;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.f7774a.setOnShowListener(null);
        AlertDialogBuilderC2120a.m7479a(this.f7774a);
    }
}
