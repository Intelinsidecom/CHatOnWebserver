package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cu */
/* loaded from: classes.dex */
class C3557cu implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13046a;

    C3557cu(ActivityPrivacy activityPrivacy) {
        this.f13046a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (obj == null || !"true".equals(obj.toString())) {
            this.f13046a.f12637o.m9521d(false);
        } else {
            this.f13046a.f12637o.m9521d(true);
        }
        this.f13046a.f12628f.show();
        return true;
    }
}
