package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2677v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f9593a;

    /* renamed from: b */
    final /* synthetic */ Runnable f9594b;

    /* renamed from: c */
    final /* synthetic */ C2660e f9595c;

    DialogInterfaceOnClickListenerC2677v(C2660e c2660e, CheckBox checkBox, Runnable runnable) {
        this.f9595c = c2660e;
        this.f9593a = checkBox;
        this.f9594b = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9593a.isChecked()) {
            C4809aa.m18104a().m18125b("do_not_show_delete_chat_list_popup", (Boolean) true);
        }
        this.f9594b.run();
    }
}
