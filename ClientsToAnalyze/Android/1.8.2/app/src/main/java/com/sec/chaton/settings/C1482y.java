package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.y */
/* loaded from: classes.dex */
class C1482y implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f5402a;

    C1482y(ActivityNoti activityNoti) {
        this.f5402a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !"true".equals(str)) {
            this.f5402a.f4502h = false;
            this.f5402a.f4496b.putBoolean("Setting Notification", false).commit();
            this.f5402a.m4507a(this.f5402a.f4509o, this.f5402a.f4506l, this.f5402a.getResources().getColor(R.color.gray));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_received_message), this.f5402a.f4507m, this.f5402a.getResources().getColor(R.color.gray));
            this.f5402a.m4507a(this.f5402a.getResources().getString(R.string.settings_received_message_summary), this.f5402a.f4507m, this.f5402a.getResources().getColor(R.color.gray));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_popup_notifications), this.f5402a.f4508n, this.f5402a.getResources().getColor(R.color.gray));
            this.f5402a.m4507a(this.f5402a.getResources().getString(R.string.settings_popup_information), this.f5402a.f4508n, this.f5402a.getResources().getColor(R.color.gray));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_type), this.f5402a.f4506l, this.f5402a.getResources().getColor(R.color.gray));
        } else {
            this.f5402a.f4502h = true;
            this.f5402a.f4496b.putBoolean("Setting Notification", true).commit();
            this.f5402a.m4507a(this.f5402a.f4509o, this.f5402a.f4506l, this.f5402a.getResources().getColor(R.color.ics_orange_font_color));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_received_message), this.f5402a.f4507m, this.f5402a.getResources().getColor(R.color.ics_main_font_color_2));
            this.f5402a.m4507a(this.f5402a.getResources().getString(R.string.settings_received_message_summary), this.f5402a.f4507m, this.f5402a.getResources().getColor(R.color.ics_orange_font_color));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_popup_notifications), this.f5402a.f4508n, this.f5402a.getResources().getColor(R.color.ics_main_font_color_2));
            this.f5402a.m4507a(this.f5402a.getResources().getString(R.string.settings_popup_information), this.f5402a.f4508n, this.f5402a.getResources().getColor(R.color.ics_orange_font_color));
            this.f5402a.m4513b(this.f5402a.getResources().getString(R.string.settings_type), this.f5402a.f4506l, this.f5402a.getResources().getColor(R.color.ics_main_font_color_2));
        }
        return true;
    }
}
