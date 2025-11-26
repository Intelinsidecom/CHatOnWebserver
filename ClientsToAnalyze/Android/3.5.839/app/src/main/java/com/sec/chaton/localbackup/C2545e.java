package com.sec.chaton.localbackup;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.e */
/* loaded from: classes.dex */
class C2545e implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f9150a;

    C2545e(ActivityLocalBackup activityLocalBackup) {
        this.f9150a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f9150a.f8985c, (Class<?>) ActivitySecretKey.class);
        intent.putExtra("password_mode", true);
        this.f9150a.startActivityForResult(intent, 0);
        return false;
    }
}
