package com.sec.chaton.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.t */
/* loaded from: classes.dex */
class C2722t implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10045a;

    C2722t(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10045a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f10045a.getView() != null) {
            this.f10045a.getListView().invalidateViews();
            if (((CheckBoxPreference) preference).isChecked()) {
                this.f10045a.f8951e.m10983b("auto_contact_sync", (Boolean) true);
            } else {
                this.f10045a.f8951e.m10983b("auto_contact_sync", (Boolean) false);
            }
        }
        return false;
    }
}
