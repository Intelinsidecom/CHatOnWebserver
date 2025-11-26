package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.da */
/* loaded from: classes.dex */
class C3564da implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13053a;

    C3564da(ActivitySettings activitySettings) {
        this.f13053a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13053a.startActivity(new Intent(this.f13053a.f12656e, (Class<?>) ActivityManageBuddy.class));
        return true;
    }
}
