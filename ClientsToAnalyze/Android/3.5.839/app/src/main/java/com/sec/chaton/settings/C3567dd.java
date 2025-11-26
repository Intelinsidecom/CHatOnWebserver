package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.dd */
/* loaded from: classes.dex */
class C3567dd implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13056a;

    C3567dd(ActivitySettings activitySettings) {
        this.f13056a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13056a.startActivity(new Intent(this.f13056a.f12656e, (Class<?>) ActivityNoti2.class));
        return true;
    }
}
