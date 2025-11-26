package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cb */
/* loaded from: classes.dex */
class C2468cb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9328a;

    C2468cb(ActivitySettings activitySettings) {
        this.f9328a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9328a.startActivity(new Intent(this.f9328a.f9096e, (Class<?>) ActivityManageBuddy.class));
        return true;
    }
}
