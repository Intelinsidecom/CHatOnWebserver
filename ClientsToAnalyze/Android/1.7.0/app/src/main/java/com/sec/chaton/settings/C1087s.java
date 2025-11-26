package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.s */
/* loaded from: classes.dex */
class C1087s implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3731a;

    C1087s(ActivitySettings activitySettings) {
        this.f3731a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3731a.startActivity(new Intent(this.f3731a.f3471f, (Class<?>) ActivityGeneral.class));
        return true;
    }
}
