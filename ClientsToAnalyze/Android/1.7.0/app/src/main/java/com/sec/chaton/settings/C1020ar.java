package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ar */
/* loaded from: classes.dex */
class C1020ar implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f3621a;

    C1020ar(ActivityNoti activityNoti) {
        this.f3621a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3621a.f3445g = false;
            this.f3621a.f3440b.putBoolean("Setting show receive message", false).commit();
        } else {
            this.f3621a.f3445g = true;
            this.f3621a.f3440b.putBoolean("Setting show receive message", true).commit();
        }
        return true;
    }
}
