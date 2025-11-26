package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.at */
/* loaded from: classes.dex */
class C2432at implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9292a;

    C2432at(ActivityNoti activityNoti) {
        this.f9292a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !"true".equals(str)) {
            this.f9292a.f9011p = false;
            this.f9292a.f9007l.m10983b("Setting Notification", (Boolean) false);
            this.f9292a.m8987a(false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000002");
            }
        } else {
            this.f9292a.f9011p = true;
            this.f9292a.f9007l.m10983b("Setting Notification", (Boolean) true);
            this.f9292a.m8987a(true);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100011", "00000001");
            }
        }
        return true;
    }
}
