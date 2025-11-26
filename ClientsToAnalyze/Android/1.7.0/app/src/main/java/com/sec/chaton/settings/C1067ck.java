package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1323bs;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.ck */
/* loaded from: classes.dex */
class C1067ck implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3712a;

    C1067ck(C1057ca c1057ca) {
        this.f3712a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        C1323bs.m4575a().edit().putBoolean("Profile Birth Chk", ((Boolean) obj).booleanValue()).commit();
        return true;
    }
}
