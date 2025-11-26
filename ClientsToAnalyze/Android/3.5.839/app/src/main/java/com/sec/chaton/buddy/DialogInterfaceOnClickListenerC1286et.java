package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.et */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1286et implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4819a;

    DialogInterfaceOnClickListenerC1286et(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4819a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
