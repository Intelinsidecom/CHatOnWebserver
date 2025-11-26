package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bv */
/* loaded from: classes.dex */
class C3531bv implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13019a;

    C3531bv(ActivityNoti2 activityNoti2) {
        this.f13019a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13019a.f12557g.m18125b("pref_setting_update_notification_on", (Boolean) obj);
        return true;
    }
}
