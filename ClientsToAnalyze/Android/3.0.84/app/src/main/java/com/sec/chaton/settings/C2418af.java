package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.ActivityAmsItemDownloads;
import com.sec.chaton.util.C3197bl;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.af */
/* loaded from: classes.dex */
class C2418af implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f9276a;

    C2418af(ActivityDownloads activityDownloads) {
        this.f9276a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3197bl.m11159a()) {
            if (this.f9276a.m8962a(EnumC2422aj.External)) {
                Intent intent = new Intent(this.f9276a.f8956d, (Class<?>) ActivityAmsItemDownloads.class);
                intent.putExtra("amsType", EnumC1327e.Stamp);
                this.f9276a.startActivity(intent);
            }
            return true;
        }
        return false;
    }
}
