package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0559bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2518a;

    DialogInterfaceOnClickListenerC0559bq(BuddyFragment buddyFragment) {
        this.f2518a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
