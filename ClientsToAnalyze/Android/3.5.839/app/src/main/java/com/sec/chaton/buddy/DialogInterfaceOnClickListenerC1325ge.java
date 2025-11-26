package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ge */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1325ge implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1324gd f4862a;

    DialogInterfaceOnClickListenerC1325ge(MenuItemOnMenuItemClickListenerC1324gd menuItemOnMenuItemClickListenerC1324gd) {
        this.f4862a = menuItemOnMenuItemClickListenerC1324gd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
