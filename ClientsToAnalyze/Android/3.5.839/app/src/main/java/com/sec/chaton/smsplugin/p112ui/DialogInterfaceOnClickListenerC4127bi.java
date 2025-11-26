package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4127bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15367a;

    DialogInterfaceOnClickListenerC4127bi(MessageListItem messageListItem) {
        this.f15367a = messageListItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
