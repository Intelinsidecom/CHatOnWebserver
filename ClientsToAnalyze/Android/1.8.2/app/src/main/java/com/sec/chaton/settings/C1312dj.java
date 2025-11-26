package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1789u;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dj */
/* loaded from: classes.dex */
class C1312dj implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4887a;

    C1312dj(SettingFragment settingFragment) {
        this.f4887a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (obj != null ? ((Boolean) obj).booleanValue() : false) {
            C1789u.m6075a().edit().putBoolean("Setting show blackscreen popup", true).commit();
        } else {
            C1789u.m6075a().edit().putBoolean("Setting show blackscreen popup", false).commit();
        }
        return true;
    }
}
