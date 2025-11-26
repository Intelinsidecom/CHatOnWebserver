package com.sec.chaton.settings;

import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.az */
/* loaded from: classes.dex */
class C0477az implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3168a;

    C0477az(ActivitySettings activitySettings) {
        this.f3168a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3168a.f3000g = false;
            this.f3168a.f2995b.putBoolean("Setting show receive message", false).commit();
        } else {
            this.f3168a.f3000g = true;
            this.f3168a.f2995b.putBoolean("Setting show receive message", true).commit();
        }
        return true;
    }
}
