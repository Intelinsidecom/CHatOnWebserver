package com.sec.chaton.localbackup;

import android.preference.Preference;
import com.sec.chaton.localbackup.noti.C1653a;
import com.sec.chaton.util.C3223ck;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.c */
/* loaded from: classes.dex */
class C1615c implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f6008a;

    C1615c(ActivityLocalBackup activityLocalBackup) {
        this.f6008a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f6008a.f5944b.m10983b("auto_backup_on", (Boolean) false);
            C1653a.m6925a(this.f6008a.f5945c);
            this.f6008a.f5951i = false;
        } else {
            if (!C3223ck.m11327a()) {
                this.f6008a.m6798d();
                return false;
            }
            this.f6008a.f5944b.m10983b("auto_backup_on", (Boolean) true);
            this.f6008a.f5951i = true;
            this.f6008a.m6801f();
            C1653a.m6926a(this.f6008a.f5945c, true);
        }
        return true;
    }
}
