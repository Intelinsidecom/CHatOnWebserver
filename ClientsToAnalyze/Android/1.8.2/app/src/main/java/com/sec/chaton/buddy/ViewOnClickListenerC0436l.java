package com.sec.chaton.buddy;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC0436l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1652a;

    ViewOnClickListenerC0436l(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1652a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1652a.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
    }
}
