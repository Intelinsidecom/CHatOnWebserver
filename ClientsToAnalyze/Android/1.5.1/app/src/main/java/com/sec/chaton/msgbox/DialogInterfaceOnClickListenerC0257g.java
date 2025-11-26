package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.msgbox.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0257g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0261k f1997a;

    DialogInterfaceOnClickListenerC0257g(MenuItemOnMenuItemClickListenerC0261k menuItemOnMenuItemClickListenerC0261k) {
        this.f1997a = menuItemOnMenuItemClickListenerC0261k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
