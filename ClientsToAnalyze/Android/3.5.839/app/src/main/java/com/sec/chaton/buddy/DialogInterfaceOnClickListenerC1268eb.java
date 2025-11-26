package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.eb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1268eb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1267ea f4801a;

    DialogInterfaceOnClickListenerC1268eb(C1267ea c1267ea) {
        this.f4801a = c1267ea;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialogC1262dw alertDialogC1262dw = new AlertDialogC1262dw(this.f4801a.f4800a.f4785d, this.f4801a.f4800a.f4788g);
        alertDialogC1262dw.m7435a(true);
        alertDialogC1262dw.show();
    }
}
