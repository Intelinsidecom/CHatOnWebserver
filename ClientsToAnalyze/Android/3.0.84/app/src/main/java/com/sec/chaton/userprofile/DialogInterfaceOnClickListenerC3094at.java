package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.at */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3094at implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC3093as f11307a;

    DialogInterfaceOnClickListenerC3094at(MenuItemOnMenuItemClickListenerC3093as menuItemOnMenuItemClickListenerC3093as) {
        this.f11307a = menuItemOnMenuItemClickListenerC3093as;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
