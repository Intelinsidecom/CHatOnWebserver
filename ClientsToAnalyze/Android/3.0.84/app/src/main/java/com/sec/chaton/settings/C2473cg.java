package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cg */
/* loaded from: classes.dex */
class C2473cg implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9333a;

    C2473cg(ActivitySettings activitySettings) {
        this.f9333a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9333a.startActivity(new Intent(this.f9333a.f9096e, (Class<?>) ActivityDownloads.class));
        return true;
    }
}
