package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2539r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f9133a;

    /* renamed from: b */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC2538q f9134b;

    DialogInterfaceOnClickListenerC2539r(MenuItemOnMenuItemClickListenerC2538q menuItemOnMenuItemClickListenerC2538q, Intent intent) {
        this.f9134b = menuItemOnMenuItemClickListenerC2538q;
        this.f9133a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9134b.f9132d.startActivity(this.f9133a);
    }
}
