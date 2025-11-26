package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.account.ContactManager;

/* renamed from: com.sec.chaton.settings.bl */
/* loaded from: classes.dex */
class C0490bl implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SyncStatePreference f3181a;

    C0490bl(SyncStatePreference syncStatePreference) {
        this.f3181a = syncStatePreference;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        ContactManager.m405a(true);
        return true;
    }
}
