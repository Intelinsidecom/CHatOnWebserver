package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.l */
/* loaded from: classes.dex */
class C0501l implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3193a;

    C0501l(ActivitySettings activitySettings) {
        this.f3193a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3193a.startActivity(new Intent(this.f3193a.f2999f, (Class<?>) ActivityAbout.class));
        return true;
    }
}
