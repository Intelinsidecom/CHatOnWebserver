package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0692fc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0691fb f2915a;

    DialogInterfaceOnClickListenerC0692fc(MenuItemOnMenuItemClickListenerC0691fb menuItemOnMenuItemClickListenerC0691fb) {
        this.f2915a = menuItemOnMenuItemClickListenerC0691fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
