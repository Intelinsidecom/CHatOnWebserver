package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1789u;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.di */
/* loaded from: classes.dex */
class C1311di implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4886a;

    C1311di(SettingFragment settingFragment) {
        this.f4886a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj != null && "true".equals(str)) {
            C1789u.m6075a().edit().putBoolean("Setting show receive message", true).commit();
        } else {
            C1789u.m6075a().edit().putBoolean("Setting show receive message", false).commit();
        }
        return true;
    }
}
