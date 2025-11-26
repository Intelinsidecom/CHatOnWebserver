package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bu */
/* loaded from: classes.dex */
class C3530bu implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13018a;

    C3530bu(ActivityNoti2 activityNoti2) {
        this.f13018a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13018a.f12557g.m18125b("pref_setting_message_notification_on", (Boolean) obj);
        return true;
    }
}
