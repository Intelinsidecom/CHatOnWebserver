package com.sec.chaton.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.ak */
/* loaded from: classes.dex */
class C3493ak implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12981a;

    C3493ak(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12981a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f12981a.getView() != null) {
            this.f12981a.m60a().invalidateViews();
            if (((CheckBoxPreference) preference).isChecked()) {
                this.f12981a.f12512n.m18125b("auto_contact_sync", (Boolean) true);
            } else {
                this.f12981a.f12512n.m18125b("auto_contact_sync", (Boolean) false);
            }
        }
        return false;
    }
}
