package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4750bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC4749bh f17415a;

    DialogInterfaceOnClickListenerC4750bi(MenuItemOnMenuItemClickListenerC4749bh menuItemOnMenuItemClickListenerC4749bh) {
        this.f17415a = menuItemOnMenuItemClickListenerC4749bh;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
