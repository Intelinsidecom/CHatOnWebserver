package com.sec.common.p123a;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;

/* compiled from: AlertDialogBuilderWrapper.java */
/* renamed from: com.sec.common.a.d */
/* loaded from: classes.dex */
class DialogInterfaceOnShowListenerC4935d implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ C4934c f18024a;

    DialogInterfaceOnShowListenerC4935d(C4934c c4934c) {
        this.f18024a = c4934c;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.setOnShowListener(null);
        View viewFindViewById = alertDialog.findViewById(Resources.getSystem().getIdentifier("titleDivider", "id", "android"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }
}
