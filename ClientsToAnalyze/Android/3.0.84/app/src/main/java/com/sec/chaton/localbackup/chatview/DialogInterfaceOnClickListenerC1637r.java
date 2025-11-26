package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1637r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f6090a;

    /* renamed from: b */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1636q f6091b;

    DialogInterfaceOnClickListenerC1637r(MenuItemOnMenuItemClickListenerC1636q menuItemOnMenuItemClickListenerC1636q, Intent intent) {
        this.f6091b = menuItemOnMenuItemClickListenerC1636q;
        this.f6090a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6091b.f6089e.startActivity(this.f6090a);
    }
}
