package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.as */
/* loaded from: classes.dex */
class C1021as implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f3622a;

    C1021as(ActivityNoti activityNoti) {
        this.f3622a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3622a.f3446h = false;
            this.f3622a.f3440b.putBoolean("Setting show blackscreen popup", false).commit();
        } else {
            this.f3622a.f3446h = true;
            this.f3622a.f3440b.putBoolean("Setting show blackscreen popup", true).commit();
        }
        return true;
    }
}
