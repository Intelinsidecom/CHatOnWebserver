package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.bc */
/* loaded from: classes.dex */
class C0481bc implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3172a;

    C0481bc(ActivitySettings activitySettings) {
        this.f3172a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3172a.f3001h = false;
            this.f3172a.f2995b.putBoolean("Setting Notification", false).commit();
            this.f3172a.m3133a(this.f3172a.f3011r, this.f3172a.f3008o, this.f3172a.getResources().getColor(C0062R.color.gray));
            this.f3172a.m3133a(this.f3172a.f3009p, this.f3172a.f3010q, this.f3172a.getResources().getColor(C0062R.color.gray));
        } else {
            this.f3172a.f3001h = true;
            this.f3172a.f2995b.putBoolean("Setting Notification", true).commit();
            this.f3172a.m3133a(this.f3172a.f3011r, this.f3172a.f3008o, this.f3172a.getResources().getColor(C0062R.color.blue_color_021));
            this.f3172a.m3133a(this.f3172a.f3009p, this.f3172a.f3010q, this.f3172a.getResources().getColor(C0062R.color.blue_color_021));
        }
        return true;
    }
}
