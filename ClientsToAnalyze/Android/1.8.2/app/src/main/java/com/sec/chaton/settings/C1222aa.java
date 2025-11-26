package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.aa */
/* loaded from: classes.dex */
class C1222aa implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f4761a;

    C1222aa(ActivityNoti activityNoti) {
        this.f4761a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4761a.f4500f = false;
            this.f4761a.f4496b.putBoolean("Setting show receive message", false).commit();
        } else {
            this.f4761a.f4500f = true;
            this.f4761a.f4496b.putBoolean("Setting show receive message", true).commit();
        }
        return true;
    }
}
