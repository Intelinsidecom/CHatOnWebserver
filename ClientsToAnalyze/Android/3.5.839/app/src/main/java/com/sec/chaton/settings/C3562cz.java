package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityRecommendation.java */
/* renamed from: com.sec.chaton.settings.cz */
/* loaded from: classes.dex */
class C3562cz implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRecommendation f13051a;

    C3562cz(ActivityRecommendation activityRecommendation) {
        this.f13051a = activityRecommendation;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f13051a.f12650b = false;
            this.f13051a.f12651c.m18125b("recomned_normal", (Boolean) false);
        } else {
            this.f13051a.f12650b = true;
            this.f13051a.f12651c.m18125b("recomned_normal", (Boolean) true);
        }
        return true;
    }
}
