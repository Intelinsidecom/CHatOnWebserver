package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.settings.downloads.ActivitySoundDownloads;
import com.sec.chaton.util.C3197bl;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.ah */
/* loaded from: classes.dex */
class C2420ah implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f9278a;

    C2420ah(ActivityDownloads activityDownloads) {
        this.f9278a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3197bl.m11159a()) {
            if (this.f9278a.m8962a(EnumC2422aj.External)) {
                this.f9278a.startActivity(new Intent(this.f9278a.f8956d, (Class<?>) ActivitySoundDownloads.class));
            }
            return true;
        }
        return false;
    }
}
