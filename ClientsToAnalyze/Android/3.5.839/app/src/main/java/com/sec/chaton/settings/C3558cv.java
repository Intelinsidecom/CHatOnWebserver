package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.userprofile.BirthdayActivity;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cv */
/* loaded from: classes.dex */
class C3558cv implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13047a;

    C3558cv(ActivityPrivacy activityPrivacy) {
        this.f13047a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13047a.startActivity(new Intent(this.f13047a.f12624b, (Class<?>) BirthdayActivity.class));
        return true;
    }
}
