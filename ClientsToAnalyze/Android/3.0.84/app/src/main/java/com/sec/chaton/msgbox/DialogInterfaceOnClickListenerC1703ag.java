package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1703ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6349a;

    DialogInterfaceOnClickListenerC1703ag(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6349a = msgboxSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        this.f6349a.m7097k();
    }
}
