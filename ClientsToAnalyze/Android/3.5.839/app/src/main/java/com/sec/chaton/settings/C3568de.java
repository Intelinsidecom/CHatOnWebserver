package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.de */
/* loaded from: classes.dex */
class C3568de implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13057a;

    C3568de(ActivitySettings activitySettings) {
        this.f13057a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13057a.startActivity(new Intent(this.f13057a.f12656e, (Class<?>) ActivityGeneral.class));
        return true;
    }
}
