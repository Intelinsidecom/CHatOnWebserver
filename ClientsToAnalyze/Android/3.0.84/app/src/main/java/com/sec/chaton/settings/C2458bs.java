package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bs */
/* loaded from: classes.dex */
class C2458bs implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9318a;

    C2458bs(ActivityPrivacy activityPrivacy) {
        this.f9318a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f9318a.f9088z.booleanValue()) {
            C3641ai.m13210a(this.f9318a.f9064b, R.string.popup_no_network_connection, 0).show();
        } else {
            String str = obj + "";
            if (obj == null || !str.equals("true")) {
                this.f9318a.f9077o.m5739c(false);
            } else {
                this.f9318a.f9077o.m5739c(true);
            }
            this.f9318a.f9068f.show();
        }
        return true;
    }
}
