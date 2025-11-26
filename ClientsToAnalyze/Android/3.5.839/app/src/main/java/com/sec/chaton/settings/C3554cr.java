package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cr */
/* loaded from: classes.dex */
class C3554cr implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13043a;

    C3554cr(ActivityPrivacy activityPrivacy) {
        this.f13043a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f13043a.f12646x.booleanValue()) {
            C5179v.m19810a(this.f13043a.f12624b, R.string.popup_no_network_connection, 0).show();
        } else {
            if (obj == null || !"true".equals(obj.toString())) {
                this.f13043a.f12637o.m9517c(false);
            } else {
                this.f13043a.f12637o.m9517c(true);
            }
            this.f13043a.f12628f.show();
        }
        return true;
    }
}
