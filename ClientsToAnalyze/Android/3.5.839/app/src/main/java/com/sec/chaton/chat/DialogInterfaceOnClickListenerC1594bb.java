package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1594bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1581ba f6099a;

    DialogInterfaceOnClickListenerC1594bb(MenuItemOnMenuItemClickListenerC1581ba menuItemOnMenuItemClickListenerC1581ba) {
        this.f6099a = menuItemOnMenuItemClickListenerC1581ba;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
