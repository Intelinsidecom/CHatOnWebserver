package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2676u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f9591a;

    /* renamed from: b */
    final /* synthetic */ C2660e f9592b;

    DialogInterfaceOnClickListenerC2676u(C2660e c2660e, CheckBox checkBox) {
        this.f9592b = c2660e;
        this.f9591a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9591a.isChecked()) {
            C4809aa.m18104a().m18125b("do_not_show_delete_chat_list_popup", (Boolean) true);
        }
        dialogInterface.cancel();
    }
}
