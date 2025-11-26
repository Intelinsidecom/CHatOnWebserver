package com.sec.chaton.settings;

import android.content.res.Resources;
import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bx */
/* loaded from: classes.dex */
class C3533bx implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13021a;

    C3533bx(ActivityNoti2 activityNoti2) {
        this.f13021a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        this.f13021a.f12543C = ((Boolean) obj).booleanValue();
        this.f13021a.f12557g.m18125b("Setting show receive message", Boolean.valueOf(this.f13021a.f12543C));
        this.f13021a.m13426a();
        return true;
    }
}
