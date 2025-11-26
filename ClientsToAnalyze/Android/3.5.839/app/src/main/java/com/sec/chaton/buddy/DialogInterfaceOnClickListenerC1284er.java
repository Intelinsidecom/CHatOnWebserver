package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.er */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1284er implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4817a;

    DialogInterfaceOnClickListenerC1284er(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4817a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
