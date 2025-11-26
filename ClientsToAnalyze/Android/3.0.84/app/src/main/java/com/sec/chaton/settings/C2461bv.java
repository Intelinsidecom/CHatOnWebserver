package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bv */
/* loaded from: classes.dex */
class C2461bv implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9321a;

    C2461bv(ActivityPrivacy activityPrivacy) {
        this.f9321a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9321a.f9077o.m5743d(false);
        } else {
            this.f9321a.f9077o.m5743d(true);
        }
        this.f9321a.f9068f.show();
        return true;
    }
}
