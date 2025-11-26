package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ba */
/* loaded from: classes.dex */
class C2440ba implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9300a;

    C2440ba(ActivityNoti activityNoti) {
        this.f9300a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9300a.startActivity(new Intent(this.f9300a, (Class<?>) ActivityAlertType2.class));
        return false;
    }
}
