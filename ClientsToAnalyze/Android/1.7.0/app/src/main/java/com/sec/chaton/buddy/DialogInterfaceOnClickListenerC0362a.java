package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0362a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1269a;

    DialogInterfaceOnClickListenerC0362a(BuddyFragment buddyFragment) {
        this.f1269a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
