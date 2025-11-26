package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cc */
/* loaded from: classes.dex */
class C2469cc implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9329a;

    C2469cc(ActivitySettings activitySettings) {
        this.f9329a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9329a.startActivity(new Intent(this.f9329a.f9096e, (Class<?>) ActivityChat.class));
        return true;
    }
}
