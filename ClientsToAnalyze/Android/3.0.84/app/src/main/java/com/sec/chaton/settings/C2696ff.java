package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.ff */
/* loaded from: classes.dex */
class C2696ff implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f9992a;

    C2696ff(SuggestionsActivity suggestionsActivity) {
        this.f9992a = suggestionsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f9992a.f9253a, R.string.popup_no_network_connection, 0).show();
            return false;
        }
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f9992a.f9254b = false;
            this.f9992a.f9256d.m10983b("recomned_receive", (Boolean) false);
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11847a("00100003", "00000002");
            }
            this.f9992a.f9257e.m5754g(false);
            this.f9992a.f9261i.show();
            return true;
        }
        this.f9992a.f9254b = true;
        this.f9992a.f9256d.m10983b("recomned_receive", (Boolean) true);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11847a("00100003", "00000001");
        }
        this.f9992a.f9257e.m5754g(true);
        this.f9992a.f9261i.show();
        return true;
    }
}
