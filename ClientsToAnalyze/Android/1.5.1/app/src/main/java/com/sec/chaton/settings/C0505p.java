package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.p */
/* loaded from: classes.dex */
class C0505p implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3197a;

    C0505p(ActivitySettings activitySettings) {
        this.f3197a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3197a.startActivity(new Intent(this.f3197a.f2999f, (Class<?>) RelationHideActivity.class));
        return true;
    }
}
