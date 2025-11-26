package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.m */
/* loaded from: classes.dex */
class C1081m implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3725a;

    C1081m(ActivitySettings activitySettings) {
        this.f3725a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3725a.startActivity(new Intent(this.f3725a.f3471f, (Class<?>) ActivityBuddyView.class));
        return true;
    }
}
