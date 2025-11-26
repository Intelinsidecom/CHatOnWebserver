package com.sec.chaton.localbackup;

import android.preference.Preference;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.localbackup.noti.C2555a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.c */
/* loaded from: classes.dex */
class C2517c implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f9052a;

    C2517c(ActivityLocalBackup activityLocalBackup) {
        this.f9052a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9052a.f8984b.m18125b("auto_backup_on", (Boolean) false);
            C2555a.m10956a(this.f9052a.f8985c);
            this.f9052a.f8991i = false;
        } else {
            if (!C4873ck.m18500a()) {
                this.f9052a.m10826d();
                return false;
            }
            if (!C4822an.m18218a() || !C2349a.m10301a("sms_feature") || C4809aa.m18104a().m18119a("backup_sms_popup", (Boolean) false).booleanValue()) {
                this.f9052a.f8984b.m18125b("auto_backup_on", (Boolean) true);
                this.f9052a.f8991i = true;
                this.f9052a.m10829f();
                C2555a.m10957a(this.f9052a.f8985c, true);
            } else {
                this.f9052a.m10819a(true);
            }
        }
        return true;
    }
}
