package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1142bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4361a;

    DialogInterfaceOnClickListenerC1142bf(BuddyFragment buddyFragment) {
        this.f4361a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
