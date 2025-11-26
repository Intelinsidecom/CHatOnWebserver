package com.sec.chaton.localbackup;

import android.preference.Preference;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.d */
/* loaded from: classes.dex */
class C2542d implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f9141a;

    C2542d(ActivityLocalBackup activityLocalBackup) {
        this.f9141a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C4873ck.m18500a()) {
            this.f9141a.m10826d();
        } else if (!C4822an.m18218a() || !C2349a.m10301a("sms_feature") || C4809aa.m18104a().m18119a("backup_sms_popup", (Boolean) false).booleanValue()) {
            this.f9141a.m10829f();
        } else {
            this.f9141a.m10819a(false);
        }
        return false;
    }
}
