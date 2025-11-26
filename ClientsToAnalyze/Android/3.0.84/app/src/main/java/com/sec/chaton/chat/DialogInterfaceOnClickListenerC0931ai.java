package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0931ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0930ah f3876a;

    DialogInterfaceOnClickListenerC0931ai(MenuItemOnMenuItemClickListenerC0930ah menuItemOnMenuItemClickListenerC0930ah) {
        this.f3876a = menuItemOnMenuItemClickListenerC0930ah;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
