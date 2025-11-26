package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.v */
/* loaded from: classes.dex */
class C1090v implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3734a;

    C1090v(ActivitySettings activitySettings) {
        this.f3734a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3734a.startActivity(new Intent(this.f3734a.f3471f, (Class<?>) ActivityChat.class));
        return true;
    }
}
