package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1969ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1968ah f7664a;

    DialogInterfaceOnClickListenerC1969ai(MenuItemOnMenuItemClickListenerC1968ah menuItemOnMenuItemClickListenerC1968ah) {
        this.f7664a = menuItemOnMenuItemClickListenerC1968ah;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
