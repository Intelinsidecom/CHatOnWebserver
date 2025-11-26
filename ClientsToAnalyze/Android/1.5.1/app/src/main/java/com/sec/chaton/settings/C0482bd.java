package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.bd */
/* loaded from: classes.dex */
class C0482bd implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3173a;

    C0482bd(ActivitySettings activitySettings) {
        this.f3173a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = (String) obj;
        if (str.equals(this.f3173a.f3006m[0])) {
            this.f3173a.f2995b.putString("Set Type", "ALL");
            this.f3173a.m3133a(this.f3173a.f3007n[0], this.f3173a.f3008o, this.f3173a.getResources().getColor(C0062R.color.blue_color_021));
            this.f3173a.f2995b.putString("Set Type Text", this.f3173a.f3006m[0]);
            this.f3173a.f2995b.commit();
            return true;
        }
        if (str.equals(this.f3173a.f3006m[1])) {
            this.f3173a.f2995b.putString("Set Type", "MELODY");
            this.f3173a.m3133a(this.f3173a.f3007n[1], this.f3173a.f3008o, this.f3173a.getResources().getColor(C0062R.color.blue_color_021));
            this.f3173a.f2995b.putString("Set Type Text", this.f3173a.f3006m[1]);
            this.f3173a.f2995b.commit();
            return true;
        }
        if (str.equals(this.f3173a.f3006m[2])) {
            this.f3173a.f2995b.putString("Set Type", "VIBRATION");
            this.f3173a.m3133a(this.f3173a.f3007n[2], this.f3173a.f3008o, this.f3173a.getResources().getColor(C0062R.color.blue_color_021));
            this.f3173a.f2995b.putString("Set Type Text", this.f3173a.f3006m[2]);
            this.f3173a.f2995b.commit();
            return true;
        }
        if (!str.equals(this.f3173a.f3006m[3])) {
            return false;
        }
        this.f3173a.f2995b.putString("Set Type", "OFF");
        this.f3173a.m3133a(this.f3173a.f3007n[3], this.f3173a.f3008o, this.f3173a.getResources().getColor(C0062R.color.blue_color_021));
        this.f3173a.f2995b.putString("Set Type Text", this.f3173a.f3006m[3]);
        this.f3173a.f2995b.commit();
        return true;
    }
}
