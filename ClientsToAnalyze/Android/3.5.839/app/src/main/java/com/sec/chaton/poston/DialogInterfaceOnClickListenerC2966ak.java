package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2966ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC2965aj f11061a;

    DialogInterfaceOnClickListenerC2966ak(MenuItemOnMenuItemClickListenerC2965aj menuItemOnMenuItemClickListenerC2965aj) {
        this.f11061a = menuItemOnMenuItemClickListenerC2965aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
