package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C3197bl;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.ad */
/* loaded from: classes.dex */
class C2416ad implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f9274a;

    C2416ad(ActivityDownloads activityDownloads) {
        this.f9274a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3197bl.m11159a()) {
            if (this.f9274a.m8962a(EnumC2422aj.External)) {
                this.f9274a.startActivity(new Intent(this.f9274a.f8956d, (Class<?>) ActivitySkinDownloads.class));
            }
            return true;
        }
        return false;
    }
}
