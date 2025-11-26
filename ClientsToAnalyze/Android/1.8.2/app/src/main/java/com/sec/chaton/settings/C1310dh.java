package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dh */
/* loaded from: classes.dex */
class C1310dh implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4885a;

    C1310dh(SettingFragment settingFragment) {
        this.f4885a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !"true".equals(str)) {
            this.f4885a.f4734j = false;
            SettingFragment.f4728i.putBoolean("Setting Notification", false).commit();
            SettingFragment.m4708c(SettingFragment.f4723a.getSummary().toString(), SettingFragment.f4723a, this.f4885a.getResources().getColor(R.color.gray));
            SettingFragment.f4723a.setEnabled(false);
            SettingFragment.m4708c(SettingFragment.f4724b.getSummary().toString(), SettingFragment.f4724b, this.f4885a.getResources().getColor(R.color.gray));
            SettingFragment.f4724b.setEnabled(false);
        } else {
            this.f4885a.f4734j = true;
            SettingFragment.f4728i.putBoolean("Setting Notification", true).commit();
            SettingFragment.m4708c(SettingFragment.f4723a.getSummary().toString(), SettingFragment.f4723a, this.f4885a.getResources().getColor(R.color.ics_orange_font_color));
            SettingFragment.f4723a.setEnabled(true);
            SettingFragment.m4708c(SettingFragment.f4724b.getSummary().toString(), SettingFragment.f4724b, this.f4885a.getResources().getColor(R.color.ics_orange_font_color));
            SettingFragment.f4724b.setEnabled(true);
        }
        return true;
    }
}
