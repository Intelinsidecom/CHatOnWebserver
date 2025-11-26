package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0315c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1434a;

    DialogInterfaceOnClickListenerC0315c(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1434a = addBuddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f1434a.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
    }
}
