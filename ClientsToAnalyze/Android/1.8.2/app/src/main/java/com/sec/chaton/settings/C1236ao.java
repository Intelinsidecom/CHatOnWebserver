package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.userprofile.BirthdayActivity;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.ao */
/* loaded from: classes.dex */
class C1236ao implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4777a;

    C1236ao(ActivityPrivacy activityPrivacy) {
        this.f4777a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4777a.startActivity(new Intent(this.f4777a.f4546e, (Class<?>) BirthdayActivity.class));
        return true;
    }
}
