package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityRecommendation.java */
/* renamed from: com.sec.chaton.settings.ca */
/* loaded from: classes.dex */
class C2467ca implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRecommendation f9327a;

    C2467ca(ActivityRecommendation activityRecommendation) {
        this.f9327a = activityRecommendation;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9327a.f9090b = false;
            this.f9327a.f9091c.m10983b("recomned_normal", (Boolean) false);
        } else {
            this.f9327a.f9090b = true;
            this.f9327a.f9091c.m10983b("recomned_normal", (Boolean) true);
        }
        return true;
    }
}
