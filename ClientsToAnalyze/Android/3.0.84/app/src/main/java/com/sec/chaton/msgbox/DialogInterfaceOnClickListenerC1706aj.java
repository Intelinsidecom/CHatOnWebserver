package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.widget.CheckBox;
import com.sec.chaton.util.C3159aa;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1706aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f6352a;

    /* renamed from: b */
    final /* synthetic */ MsgboxSelectionFragment f6353b;

    DialogInterfaceOnClickListenerC1706aj(MsgboxSelectionFragment msgboxSelectionFragment, CheckBox checkBox) {
        this.f6353b = msgboxSelectionFragment;
        this.f6352a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        boolean z = true;
        if (this.f6352a.isChecked()) {
            z = false;
        }
        C3159aa.m10962a().m10983b("msgbox_close_popup_show", Boolean.valueOf(z));
        this.f6353b.m7097k();
    }
}
