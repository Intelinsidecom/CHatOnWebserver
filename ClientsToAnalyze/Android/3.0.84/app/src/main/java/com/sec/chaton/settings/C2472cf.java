package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cf */
/* loaded from: classes.dex */
class C2472cf implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9332a;

    C2472cf(ActivitySettings activitySettings) {
        this.f9332a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9332a.startActivity(new Intent(this.f9332a.f9096e, (Class<?>) ActivityGeneral.class));
        return true;
    }
}
