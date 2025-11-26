package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.preference.Preference;
import android.provider.ContactsContract;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cb */
/* loaded from: classes.dex */
class C1401cb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsPreferenceAct f5264a;

    C1401cb(TellFriendsPreferenceAct tellFriendsPreferenceAct) {
        this.f5264a = tellFriendsPreferenceAct;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f5264a.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
        return true;
    }
}
