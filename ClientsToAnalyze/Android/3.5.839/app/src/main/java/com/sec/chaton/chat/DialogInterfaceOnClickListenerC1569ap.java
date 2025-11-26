package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1569ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1568ao f5991a;

    DialogInterfaceOnClickListenerC1569ap(MenuItemOnMenuItemClickListenerC1568ao menuItemOnMenuItemClickListenerC1568ao) {
        this.f5991a = menuItemOnMenuItemClickListenerC1568ao;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
