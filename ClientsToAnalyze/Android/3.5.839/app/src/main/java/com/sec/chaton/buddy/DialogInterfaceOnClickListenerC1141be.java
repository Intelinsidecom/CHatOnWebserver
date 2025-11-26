package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1141be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f4359a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4360b;

    DialogInterfaceOnClickListenerC1141be(BuddyFragment buddyFragment, int i) {
        this.f4360b = buddyFragment;
        this.f4359a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4360b.m6494d(this.f4359a);
    }
}
