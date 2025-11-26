package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* renamed from: com.sec.chaton.settings.m */
/* loaded from: classes.dex */
class C0502m implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3194a;

    C0502m(ActivitySettings activitySettings) {
        this.f3194a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3194a.startActivity(new Intent(this.f3194a.f2999f, (Class<?>) ActivityChatView.class));
        return true;
    }
}
