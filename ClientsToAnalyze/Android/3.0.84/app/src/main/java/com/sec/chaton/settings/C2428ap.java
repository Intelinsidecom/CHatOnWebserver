package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.ap */
/* loaded from: classes.dex */
class C2428ap implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f9288a;

    C2428ap(ActivityManageBuddy activityManageBuddy) {
        this.f9288a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9288a.f8993c = false;
            this.f9288a.f8994d.m10983b("Profile Birth Chk", (Boolean) false);
        } else {
            this.f9288a.f8993c = true;
            this.f9288a.f8994d.m10983b("Profile Birth Chk", (Boolean) true);
        }
        return true;
    }
}
