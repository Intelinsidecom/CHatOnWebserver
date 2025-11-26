package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0743h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2997a;

    DialogInterfaceOnClickListenerC0743h(AddBuddyFragment addBuddyFragment) {
        this.f2997a = addBuddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f2997a.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
    }
}
