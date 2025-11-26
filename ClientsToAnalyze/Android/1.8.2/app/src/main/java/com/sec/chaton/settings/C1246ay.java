package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.ay */
/* loaded from: classes.dex */
class C1246ay implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f4787a;

    C1246ay(ActivitySettings activitySettings) {
        this.f4787a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f4787a.f4570l != null) {
            if (!this.f4787a.f4570l.getKey().toString().equals(preference.getKey().toString())) {
                this.f4787a.m4567a(preference.getTitle().toString(), preference, this.f4787a.getResources().getColor(R.color.ics_orange_font_color));
                this.f4787a.m4567a(this.f4787a.f4570l.getTitle().toString(), this.f4787a.f4570l, this.f4787a.getResources().getColor(R.color.ics_main_font_color_2));
                preference.setLayoutResource(R.layout.preference_clicked);
                this.f4787a.f4570l.setLayoutResource(R.layout.preference_setting_menu);
            }
        } else {
            this.f4787a.m4567a(preference.getTitle().toString(), preference, this.f4787a.getResources().getColor(R.color.ics_orange_font_color));
            preference.setLayoutResource(R.layout.preference_clicked);
        }
        this.f4787a.f4570l = preference;
        this.f4787a.m4566i();
        this.f4787a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityGeneral(), "container").commit();
        return true;
    }
}
