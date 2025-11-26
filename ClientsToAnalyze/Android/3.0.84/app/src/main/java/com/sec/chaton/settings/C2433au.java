package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.au */
/* loaded from: classes.dex */
class C2433au implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9293a;

    C2433au(ActivityNoti activityNoti) {
        this.f9293a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9293a.f9009n = false;
            this.f9293a.f9007l.m10983b("Setting show blackscreen popup", (Boolean) false);
            this.f9293a.m8993b(false);
        } else {
            this.f9293a.f9009n = true;
            this.f9293a.f9007l.m10983b("Setting show blackscreen popup", (Boolean) true);
            this.f9293a.m8993b(true);
        }
        return true;
    }
}
