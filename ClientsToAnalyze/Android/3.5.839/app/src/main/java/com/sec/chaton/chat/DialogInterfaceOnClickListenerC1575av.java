package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.av */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1575av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f6001a;

    /* renamed from: b */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1574au f6002b;

    DialogInterfaceOnClickListenerC1575av(MenuItemOnMenuItemClickListenerC1574au menuItemOnMenuItemClickListenerC1574au, Intent intent) {
        this.f6002b = menuItemOnMenuItemClickListenerC1574au;
        this.f6001a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6002b.f6000b.startActivity(this.f6001a);
    }
}
