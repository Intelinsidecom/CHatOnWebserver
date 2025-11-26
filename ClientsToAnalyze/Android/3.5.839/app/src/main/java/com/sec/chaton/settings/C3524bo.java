package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bo */
/* loaded from: classes.dex */
class C3524bo implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13012a;

    C3524bo(ActivityNoti2 activityNoti2) {
        this.f13012a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13012a.f12549I = ((Boolean) obj).booleanValue();
        this.f13012a.f12557g.m18125b("LED Indicator", Boolean.valueOf(this.f13012a.f12549I));
        return true;
    }
}
