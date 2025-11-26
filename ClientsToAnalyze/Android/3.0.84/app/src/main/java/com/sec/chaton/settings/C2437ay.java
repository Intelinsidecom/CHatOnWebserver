package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ay */
/* loaded from: classes.dex */
class C2437ay implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9297a;

    C2437ay(ActivityNoti activityNoti) {
        this.f9297a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9297a.f9010o = false;
            this.f9297a.f9007l.m10983b("Setting alert_new_groupchat", (Boolean) false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000006");
            }
        } else {
            this.f9297a.f9010o = true;
            this.f9297a.f9007l.m10983b("Setting alert_new_groupchat", (Boolean) true);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000005");
            }
        }
        return true;
    }
}
