package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.m */
/* loaded from: classes.dex */
class C2709m implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10015a;

    C2709m(ActivityChat activityChat) {
        this.f10015a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f10015a.f8943e = false;
            this.f10015a.f8942d.m10983b("Setting enter key", (Boolean) false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100013", "00000002");
            }
        } else {
            this.f10015a.f8943e = true;
            this.f10015a.f8942d.m10983b("Setting enter key", (Boolean) true);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100013", "00000001");
            }
        }
        return true;
    }
}
