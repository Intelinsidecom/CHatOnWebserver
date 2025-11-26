package com.sec.chaton.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.al */
/* loaded from: classes.dex */
class C3494al implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12982a;

    C3494al(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12982a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f12982a.getView() != null) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            checkBoxPreference.setChecked(!checkBoxPreference.isChecked());
        }
        this.f12982a.m60a().invalidateViews();
        return false;
    }
}
