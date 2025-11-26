package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.db */
/* loaded from: classes.dex */
class C3565db implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13054a;

    C3565db(ActivitySettings activitySettings) {
        this.f13054a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13054a.startActivity(new Intent(this.f13054a.f12656e, (Class<?>) ActivityChat.class));
        return true;
    }
}
