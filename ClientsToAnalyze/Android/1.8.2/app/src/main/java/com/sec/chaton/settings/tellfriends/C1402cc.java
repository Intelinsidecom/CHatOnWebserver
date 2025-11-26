package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cc */
/* loaded from: classes.dex */
class C1402cc implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsPreferenceAct f5265a;

    C1402cc(TellFriendsPreferenceAct tellFriendsPreferenceAct) {
        this.f5265a = tellFriendsPreferenceAct;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f5265a.startActivity(new Intent(this.f5265a.f5044e, (Class<?>) FacebookSubMenuActivity.class));
        return true;
    }
}
