package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.cl */
/* loaded from: classes.dex */
class C1068cl implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3713a;

    C1068cl(C1057ca c1057ca) {
        this.f3713a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !"true".equals(str)) {
            this.f3713a.f3690k = false;
            C1057ca.f3683j.putBoolean("Setting Notification", false).commit();
            C1057ca.m3942c(this.f3713a.f3691n, C1057ca.f3678a, this.f3713a.getResources().getColor(R.color.gray));
            C1057ca.f3678a.setEnabled(false);
            C1057ca.m3942c(this.f3713a.f3692o, C1057ca.f3679b, this.f3713a.getResources().getColor(R.color.gray));
            C1057ca.f3679b.setEnabled(false);
        } else {
            this.f3713a.f3690k = true;
            C1057ca.f3683j.putBoolean("Setting Notification", true).commit();
            C1057ca.m3942c(this.f3713a.f3691n, C1057ca.f3678a, this.f3713a.getResources().getColor(R.color.blue_color_021));
            C1057ca.f3678a.setEnabled(true);
            C1057ca.m3942c(this.f3713a.f3692o, C1057ca.f3679b, this.f3713a.getResources().getColor(R.color.blue_color_021));
            C1057ca.f3679b.setEnabled(true);
        }
        return true;
    }
}
