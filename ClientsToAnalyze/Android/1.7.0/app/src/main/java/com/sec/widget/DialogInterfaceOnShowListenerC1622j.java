package com.sec.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.j */
/* loaded from: classes.dex */
class DialogInterfaceOnShowListenerC1622j implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialog f5737a;

    /* renamed from: b */
    final /* synthetic */ AlertDialogBuilderC1625m f5738b;

    DialogInterfaceOnShowListenerC1622j(AlertDialogBuilderC1625m alertDialogBuilderC1625m, AlertDialog alertDialog) {
        this.f5738b = alertDialogBuilderC1625m;
        this.f5737a = alertDialog;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) throws Resources.NotFoundException {
        this.f5737a.setOnShowListener(null);
        AlertDialogBuilderC1625m.m5911a(this.f5737a);
    }
}
