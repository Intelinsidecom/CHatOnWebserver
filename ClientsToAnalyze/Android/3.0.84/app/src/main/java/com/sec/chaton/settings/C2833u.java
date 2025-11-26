package com.sec.chaton.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.u */
/* loaded from: classes.dex */
class C2833u implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10376a;

    C2833u(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10376a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f10376a.getView() != null) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            checkBoxPreference.setChecked(!checkBoxPreference.isChecked());
        }
        this.f10376a.getListView().invalidateViews();
        return false;
    }
}
