package com.sec.chaton.settings;

import android.content.res.Resources;
import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.cb */
/* loaded from: classes.dex */
class C3538cb implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13026a;

    C3538cb(ActivityNoti2 activityNoti2) {
        this.f13026a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        String str = (String) obj;
        if (str == null || str.trim().length() == 0) {
            str = "Silent";
        }
        this.f13026a.f12557g.m18128b("Ringtone", str);
        String strM13446f = this.f13026a.m13446f();
        preference.setSummary(strM13446f);
        this.f13026a.m13428a(strM13446f, preference, true);
        return true;
    }
}
