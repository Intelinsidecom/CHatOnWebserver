package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.n */
/* loaded from: classes.dex */
class C2716n implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10039a;

    C2716n(ActivityChat activityChat) {
        this.f10039a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (obj != null) {
            this.f10039a.f8942d.m10983b("Setting push to talk", Boolean.valueOf(Boolean.parseBoolean(obj.toString())));
            if (Boolean.parseBoolean(obj.toString())) {
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11847a("00100013", "00000003");
                }
            } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100013", "00000004");
            }
        }
        return true;
    }
}
