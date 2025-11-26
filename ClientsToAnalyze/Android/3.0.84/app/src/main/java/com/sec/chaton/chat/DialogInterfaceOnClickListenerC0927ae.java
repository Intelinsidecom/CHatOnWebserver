package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0927ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f3866a;

    /* renamed from: b */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0926ad f3867b;

    DialogInterfaceOnClickListenerC0927ae(MenuItemOnMenuItemClickListenerC0926ad menuItemOnMenuItemClickListenerC0926ad, Intent intent) {
        this.f3867b = menuItemOnMenuItemClickListenerC0926ad;
        this.f3866a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3867b.f3865b.startActivity(this.f3866a);
    }
}
