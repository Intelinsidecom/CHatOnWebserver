package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.userprofile.BirthdayActivity;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bw */
/* loaded from: classes.dex */
class C2462bw implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9322a;

    C2462bw(ActivityPrivacy activityPrivacy) {
        this.f9322a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9322a.startActivity(new Intent(this.f9322a.f9064b, (Class<?>) BirthdayActivity.class));
        return true;
    }
}
