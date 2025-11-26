package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.bh */
/* loaded from: classes.dex */
class C3517bh implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f13005a;

    C3517bh(ActivityManageBuddy activityManageBuddy) {
        this.f13005a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f13005a.f12538c = false;
            this.f13005a.f12539d.m18125b("Profile Birth Chk", (Boolean) false);
        } else {
            this.f13005a.f12538c = true;
            this.f13005a.f12539d.m18125b("Profile Birth Chk", (Boolean) true);
        }
        return true;
    }
}
