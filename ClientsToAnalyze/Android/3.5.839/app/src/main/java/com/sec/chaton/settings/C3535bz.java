package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bz */
/* loaded from: classes.dex */
class C3535bz implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13023a;

    C3535bz(ActivityNoti2 activityNoti2) {
        this.f13023a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13023a.f12545E = ((Boolean) obj).booleanValue();
        this.f13023a.f12557g.m18125b("Setting is use popup while screen off", Boolean.valueOf(this.f13023a.f12545E));
        return true;
    }
}
