package com.sec.chaton.localbackup;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.e */
/* loaded from: classes.dex */
class C1643e implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f6105a;

    C1643e(ActivityLocalBackup activityLocalBackup) {
        this.f6105a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f6105a.f5945c, (Class<?>) ActivitySecretKey.class);
        intent.putExtra("password_mode", true);
        this.f6105a.startActivityForResult(intent, 0);
        return false;
    }
}
