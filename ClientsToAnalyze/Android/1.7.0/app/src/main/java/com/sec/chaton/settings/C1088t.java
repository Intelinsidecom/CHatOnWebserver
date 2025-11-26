package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.t */
/* loaded from: classes.dex */
class C1088t implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3732a;

    C1088t(ActivitySettings activitySettings) {
        this.f3732a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3732a.startActivity(new Intent(this.f3732a.f3471f, (Class<?>) ActivityNoti.class));
        return true;
    }
}
