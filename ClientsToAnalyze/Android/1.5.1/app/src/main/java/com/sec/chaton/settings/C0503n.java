package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.n */
/* loaded from: classes.dex */
class C0503n implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3195a;

    C0503n(ActivitySettings activitySettings) {
        this.f3195a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3195a.startActivity(new Intent(this.f3195a.f2999f, (Class<?>) ActivitySkinChange.class));
        return true;
    }
}
