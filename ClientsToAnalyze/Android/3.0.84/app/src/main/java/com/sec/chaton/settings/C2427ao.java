package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.registration.ActivitySyncSignInPopup;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.ao */
/* loaded from: classes.dex */
class C2427ao implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f9287a;

    C2427ao(ActivityManageAccounts activityManageAccounts) {
        this.f9287a = activityManageAccounts;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f9287a.f8981h, (Class<?>) ActivitySyncSignInPopup.class);
        intent.setFlags(67108864);
        intent.putExtra("isSyncContacts", true);
        this.f9287a.startActivityForResult(intent, 1);
        return false;
    }
}
