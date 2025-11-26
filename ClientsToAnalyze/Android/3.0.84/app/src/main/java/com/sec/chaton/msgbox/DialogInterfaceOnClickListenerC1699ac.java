package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1699ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f6340a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f6341b;

    DialogInterfaceOnClickListenerC1699ac(MsgboxFragment msgboxFragment, CheckBox checkBox) {
        this.f6341b = msgboxFragment;
        this.f6340a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f6340a.isChecked()) {
            this.f6341b.m7011a(true);
        }
        ((InterfaceC1701ae) this.f6341b.getActivity()).mo1322c();
        this.f6341b.m7048l();
    }
}
