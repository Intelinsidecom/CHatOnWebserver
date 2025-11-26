package com.sec.chaton.localbackup;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.f */
/* loaded from: classes.dex */
class C2546f implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f9151a;

    C2546f(ActivityLocalBackup activityLocalBackup) {
        this.f9151a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9151a.startActivity(new Intent(this.f9151a.f8985c, (Class<?>) ActivityBackupList.class));
        return false;
    }
}
