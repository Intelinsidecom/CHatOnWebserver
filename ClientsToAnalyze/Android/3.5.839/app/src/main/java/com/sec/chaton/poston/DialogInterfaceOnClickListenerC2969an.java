package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2969an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC2968am f11066a;

    DialogInterfaceOnClickListenerC2969an(MenuItemOnMenuItemClickListenerC2968am menuItemOnMenuItemClickListenerC2968am) {
        this.f11066a = menuItemOnMenuItemClickListenerC2968am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
