package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.database.Cursor;

/* compiled from: ManageSimMessages.java */
/* renamed from: com.sec.chaton.smsplugin.ui.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4105an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Cursor f15236a;

    /* renamed from: b */
    final /* synthetic */ ManageSimMessages f15237b;

    DialogInterfaceOnClickListenerC4105an(ManageSimMessages manageSimMessages, Cursor cursor) {
        this.f15237b = manageSimMessages;
        this.f15236a = cursor;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15237b.m15774a(2);
        this.f15237b.m15785c(this.f15236a);
        dialogInterface.dismiss();
    }
}
