package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.dh */
/* loaded from: classes.dex */
class C3571dh implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13060a;

    C3571dh(ActivitySettings activitySettings) {
        this.f13060a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13060a.startActivity(new Intent(this.f13060a.f12656e, (Class<?>) ActivityContactSync.class));
        return true;
    }
}
