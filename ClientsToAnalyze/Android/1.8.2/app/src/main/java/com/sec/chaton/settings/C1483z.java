package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.z */
/* loaded from: classes.dex */
class C1483z implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f5403a;

    C1483z(ActivityNoti activityNoti) {
        this.f5403a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f5403a.f4501g = false;
            this.f5403a.f4496b.putBoolean("Setting show blackscreen popup", false).commit();
        } else {
            this.f5403a.f4501g = true;
            this.f5403a.f4496b.putBoolean("Setting show blackscreen popup", true).commit();
        }
        return true;
    }
}
