package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.q */
/* loaded from: classes.dex */
class C0506q implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3198a;

    C0506q(ActivitySettings activitySettings) {
        this.f3198a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3198a.startActivity(new Intent(this.f3198a.f2999f, (Class<?>) ActivityDeleteAccount.class));
        return true;
    }
}
