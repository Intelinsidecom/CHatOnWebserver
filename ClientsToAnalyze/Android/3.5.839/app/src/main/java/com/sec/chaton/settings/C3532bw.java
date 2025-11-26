package com.sec.chaton.settings;

import android.content.res.Resources;
import android.preference.Preference;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bw */
/* loaded from: classes.dex */
class C3532bw implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13020a;

    C3532bw(ActivityNoti2 activityNoti2) {
        this.f13020a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        this.f13020a.f12542B = ((Boolean) obj).booleanValue();
        this.f13020a.f12557g.m18125b("Setting show blackscreen popup", Boolean.valueOf(this.f13020a.f12542B));
        this.f13020a.m13426a();
        return true;
    }
}
