package com.sec.chaton.localbackup;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.f */
/* loaded from: classes.dex */
class C1644f implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f6106a;

    C1644f(ActivityLocalBackup activityLocalBackup) {
        this.f6106a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f6106a.startActivity(new Intent(this.f6106a.f5945c, (Class<?>) ActivityBackupList.class));
        return false;
    }
}
