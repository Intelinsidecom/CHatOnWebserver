package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1698ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f6338a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f6339b;

    DialogInterfaceOnClickListenerC1698ab(MsgboxFragment msgboxFragment, CheckBox checkBox) {
        this.f6339b = msgboxFragment;
        this.f6338a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        if (this.f6338a.isChecked()) {
            this.f6339b.m7011a(true);
        }
        this.f6339b.m7048l();
    }
}
