package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.cj */
/* loaded from: classes.dex */
class C2476cj implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9336a;

    C2476cj(ActivitySettings activitySettings) {
        this.f9336a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9336a.startActivity(new Intent(this.f9336a.f9096e, (Class<?>) ActivityContactSync.class));
        return true;
    }
}
