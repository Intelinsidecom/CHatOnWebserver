package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1323bs;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.ch */
/* loaded from: classes.dex */
class C1064ch implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3709a;

    C1064ch(C1057ca c1057ca) {
        this.f3709a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj != null && "true".equals(str)) {
            C1323bs.m4575a().edit().putBoolean("Setting show receive message", true).commit();
        } else {
            C1323bs.m4575a().edit().putBoolean("Setting show receive message", false).commit();
        }
        return true;
    }
}
