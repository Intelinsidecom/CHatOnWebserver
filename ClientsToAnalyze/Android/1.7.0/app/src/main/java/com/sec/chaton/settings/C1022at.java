package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.at */
/* loaded from: classes.dex */
class C1022at implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f3623a;

    C1022at(ActivityNoti activityNoti) {
        this.f3623a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !"true".equals(str)) {
            this.f3623a.f3447i = false;
            this.f3623a.f3440b.putBoolean("Setting Notification", false).commit();
            this.f3623a.m3799a(false);
        } else {
            this.f3623a.f3447i = true;
            this.f3623a.f3440b.putBoolean("Setting Notification", true).commit();
            this.f3623a.m3799a(true);
        }
        return true;
    }
}
