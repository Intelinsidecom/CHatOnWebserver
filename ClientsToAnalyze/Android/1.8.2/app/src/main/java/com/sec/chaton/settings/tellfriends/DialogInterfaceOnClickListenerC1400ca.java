package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1400ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsPreferenceAct f5263a;

    DialogInterfaceOnClickListenerC1400ca(TellFriendsPreferenceAct tellFriendsPreferenceAct) {
        this.f5263a = tellFriendsPreferenceAct;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f5263a.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
    }
}
