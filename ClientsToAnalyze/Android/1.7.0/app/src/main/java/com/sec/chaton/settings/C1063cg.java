package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1323bs;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.cg */
/* loaded from: classes.dex */
class C1063cg implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3708a;

    C1063cg(C1057ca c1057ca) {
        this.f3708a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (obj != null ? ((Boolean) obj).booleanValue() : false) {
            C1323bs.m4575a().edit().putBoolean("Setting show blackscreen popup", true).commit();
        } else {
            C1323bs.m4575a().edit().putBoolean("Setting show blackscreen popup", false).commit();
        }
        return true;
    }
}
