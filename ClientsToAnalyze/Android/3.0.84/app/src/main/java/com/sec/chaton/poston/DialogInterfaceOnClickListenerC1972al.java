package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1972al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1971ak f7669a;

    DialogInterfaceOnClickListenerC1972al(MenuItemOnMenuItemClickListenerC1971ak menuItemOnMenuItemClickListenerC1971ak) {
        this.f7669a = menuItemOnMenuItemClickListenerC1971ak;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
