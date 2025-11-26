package com.sec.chaton.settings;

import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.bb */
/* loaded from: classes.dex */
class C0480bb implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3171a;

    C0480bb(ActivitySettings activitySettings) {
        this.f3171a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3171a.f3002i = false;
            this.f3171a.f2995b.putBoolean("Profile Birth Chk", false).commit();
        } else {
            this.f3171a.f3002i = true;
            this.f3171a.f2995b.putBoolean("Profile Birth Chk", true).commit();
        }
        return true;
    }
}
