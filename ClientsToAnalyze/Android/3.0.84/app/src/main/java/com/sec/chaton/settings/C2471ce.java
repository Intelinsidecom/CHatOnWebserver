package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.ce */
/* loaded from: classes.dex */
class C2471ce implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9331a;

    C2471ce(ActivitySettings activitySettings) {
        this.f9331a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9331a.startActivity(new Intent(this.f9331a.f9096e, (Class<?>) ActivityNoti.class));
        return true;
    }
}
