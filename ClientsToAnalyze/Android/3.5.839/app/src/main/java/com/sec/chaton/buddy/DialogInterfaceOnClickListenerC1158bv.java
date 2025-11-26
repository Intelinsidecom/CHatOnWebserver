package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1158bv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4377a;

    DialogInterfaceOnClickListenerC1158bv(BuddyFragment buddyFragment) {
        this.f4377a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
