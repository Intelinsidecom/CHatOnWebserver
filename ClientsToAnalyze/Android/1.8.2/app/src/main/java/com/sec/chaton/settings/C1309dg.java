package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1789u;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dg */
/* loaded from: classes.dex */
class C1309dg implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4884a;

    C1309dg(SettingFragment settingFragment) {
        this.f4884a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        C1789u.m6075a().edit().putBoolean("Profile Birth Chk", ((Boolean) obj).booleanValue()).commit();
        return true;
    }
}
