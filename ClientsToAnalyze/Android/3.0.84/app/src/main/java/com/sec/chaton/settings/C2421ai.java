package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.settings.downloads.ActivityFontDownloads;
import com.sec.chaton.util.C3197bl;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.ai */
/* loaded from: classes.dex */
class C2421ai implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f9279a;

    C2421ai(ActivityDownloads activityDownloads) {
        this.f9279a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3197bl.m11159a()) {
            if (this.f9279a.m8962a(EnumC2422aj.Internal)) {
                this.f9279a.startActivity(new Intent(this.f9279a.f8956d, (Class<?>) ActivityFontDownloads.class));
            }
            return true;
        }
        return false;
    }
}
