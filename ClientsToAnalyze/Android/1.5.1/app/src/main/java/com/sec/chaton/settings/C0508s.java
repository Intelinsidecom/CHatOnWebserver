package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.s */
/* loaded from: classes.dex */
class C0508s implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3200a;

    C0508s(ActivitySettings activitySettings) {
        this.f3200a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        ActivitySettings.m3131a((Context) this.f3200a);
        return true;
    }
}
