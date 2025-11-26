package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0658dw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2877a;

    DialogInterfaceOnClickListenerC0658dw(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2877a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
