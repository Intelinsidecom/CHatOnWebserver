package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1265dz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4798a;

    DialogInterfaceOnClickListenerC1265dz(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4798a = alertDialogC1262dw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f4798a.m7420b()) {
            this.f4798a.m7423c();
        }
    }
}
