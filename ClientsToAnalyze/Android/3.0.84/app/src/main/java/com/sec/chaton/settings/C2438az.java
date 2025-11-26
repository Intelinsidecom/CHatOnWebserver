package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.az */
/* loaded from: classes.dex */
class C2438az implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9298a;

    C2438az(ActivityNoti activityNoti) {
        this.f9298a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9298a.f9008m = false;
            this.f9298a.f9007l.m10983b("Setting show receive message", (Boolean) false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000004");
            }
        } else {
            this.f9298a.f9008m = true;
            this.f9298a.f9007l.m10983b("Setting show receive message", (Boolean) true);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000003");
            }
        }
        return true;
    }
}
