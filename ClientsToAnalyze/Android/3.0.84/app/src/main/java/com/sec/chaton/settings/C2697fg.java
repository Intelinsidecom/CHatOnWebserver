package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.fg */
/* loaded from: classes.dex */
class C2697fg implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f9993a;

    C2697fg(SuggestionsActivity suggestionsActivity) {
        this.f9993a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f9993a.f9253a, R.string.popup_no_network_connection, 0).show();
            return false;
        }
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9993a.f9255c = true;
            this.f9993a.f9256d.m10983b("exclude_me", (Boolean) false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100003", "00000006");
            }
            this.f9993a.f9257e.m5751f(true);
            this.f9993a.f9261i.show();
            return true;
        }
        this.f9993a.f9255c = false;
        this.f9993a.f9256d.m10983b("exclude_me", (Boolean) true);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11847a("00100003", "00000005");
        }
        this.f9993a.f9257e.m5751f(false);
        this.f9993a.f9261i.show();
        return true;
    }
}
