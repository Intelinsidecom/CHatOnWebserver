package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cd */
/* loaded from: classes.dex */
class C2470cd implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9330a;

    C2470cd(ActivitySettings activitySettings) {
        this.f9330a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9330a.startActivity(new Intent(this.f9330a.f9096e, (Class<?>) ActivityPrivacy.class));
        return true;
    }
}
