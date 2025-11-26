package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.registration.ActivityChatonVDownloads;

/* compiled from: ActivityDownload2.java */
/* renamed from: com.sec.chaton.settings.m */
/* loaded from: classes.dex */
class C1334m implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownload2 f4910a;

    C1334m(ActivityDownload2 activityDownload2) {
        this.f4910a = activityDownload2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4910a.startActivity(new Intent(this.f4910a.f4476f, (Class<?>) ActivityChatonVDownloads.class));
        return true;
    }
}
