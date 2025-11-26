package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.df */
/* loaded from: classes.dex */
class C1308df implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4883a;

    C1308df(SettingFragment settingFragment) {
        this.f4883a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        SettingFragment.m4701a(this.f4883a.getActivity());
        return true;
    }
}
