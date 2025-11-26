package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0770i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3040a;

    DialogInterfaceOnClickListenerC0770i(AddBuddyFragment addBuddyFragment) {
        this.f3040a = addBuddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
