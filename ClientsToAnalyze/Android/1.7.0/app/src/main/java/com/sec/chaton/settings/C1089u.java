package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.u */
/* loaded from: classes.dex */
class C1089u implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3733a;

    C1089u(ActivitySettings activitySettings) {
        this.f3733a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3733a.startActivity(new Intent(this.f3733a.f3471f, (Class<?>) ActivityPrivacy.class));
        return true;
    }
}
