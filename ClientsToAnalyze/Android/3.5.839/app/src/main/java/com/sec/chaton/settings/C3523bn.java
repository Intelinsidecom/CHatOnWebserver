package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bn */
/* loaded from: classes.dex */
class C3523bn implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13011a;

    C3523bn(ActivityNoti2 activityNoti2) {
        this.f13011a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13011a.f12548H = ((Boolean) obj).booleanValue();
        this.f13011a.f12557g.m18125b("Setting alert_new_groupchat", Boolean.valueOf(this.f13011a.f12548H));
        return true;
    }
}
