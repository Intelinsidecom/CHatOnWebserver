package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.multimedia.emoticon.CategoryActivity;
import com.sec.chaton.util.C3197bl;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.ac */
/* loaded from: classes.dex */
class C2415ac implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f9273a;

    C2415ac(ActivityDownloads activityDownloads) {
        this.f9273a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3197bl.m11159a()) {
            if (this.f9273a.m8962a(EnumC2422aj.External)) {
                this.f9273a.startActivity(new Intent(this.f9273a.f8956d, (Class<?>) CategoryActivity.class));
            }
            return true;
        }
        return false;
    }
}
