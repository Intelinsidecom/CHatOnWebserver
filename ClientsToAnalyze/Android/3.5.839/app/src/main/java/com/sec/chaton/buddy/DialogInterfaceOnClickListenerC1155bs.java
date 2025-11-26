package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1155bs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4374a;

    DialogInterfaceOnClickListenerC1155bs(BuddyFragment buddyFragment) {
        this.f4374a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4374a.f3626aG.dismiss();
    }
}
