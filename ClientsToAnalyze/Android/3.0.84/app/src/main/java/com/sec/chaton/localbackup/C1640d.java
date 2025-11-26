package com.sec.chaton.localbackup;

import android.preference.Preference;
import com.sec.chaton.util.C3223ck;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.d */
/* loaded from: classes.dex */
class C1640d implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f6098a;

    C1640d(ActivityLocalBackup activityLocalBackup) {
        this.f6098a = activityLocalBackup;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C3223ck.m11327a()) {
            this.f6098a.m6798d();
        } else {
            this.f6098a.m6801f();
        }
        return false;
    }
}
