package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.dc */
/* loaded from: classes.dex */
class C3566dc implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13055a;

    C3566dc(ActivitySettings activitySettings) {
        this.f13055a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13055a.startActivity(new Intent(this.f13055a.f12656e, (Class<?>) ActivityPrivacy.class));
        return true;
    }
}
