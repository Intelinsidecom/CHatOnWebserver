package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: OfflineMsgDialog.java */
/* renamed from: com.sec.chaton.chat.hq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1771hq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OfflineMsgDialog f6651a;

    DialogInterfaceOnClickListenerC1771hq(OfflineMsgDialog offlineMsgDialog) {
        this.f6651a = offlineMsgDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6651a.finish();
    }
}
