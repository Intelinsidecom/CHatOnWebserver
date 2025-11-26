package com.sec.chaton.settings;

import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;

/* loaded from: classes.dex */
public class ActivityAlertType2 extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    private SharedPreferences f3416a;

    /* renamed from: b */
    private SharedPreferences.Editor f3417b;

    /* renamed from: c */
    private CheckBoxPreference f3418c;

    /* renamed from: d */
    private CheckBoxPreference f3419d;

    /* renamed from: e */
    private Preference f3420e;

    /* renamed from: f */
    private String[] f3421f;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_alertype);
        this.f3416a = C1323bs.m4575a();
        this.f3417b = this.f3416a.edit();
        this.f3421f = getResources().getStringArray(R.array.settings_type_options_value);
        this.f3418c = (CheckBoxPreference) findPreference("pref_item_sound");
        this.f3419d = (CheckBoxPreference) findPreference("pref_item_vibration");
        this.f3420e = findPreference("pref_item_sound_type");
        this.f3418c.setOnPreferenceChangeListener(this);
        this.f3419d.setOnPreferenceChangeListener(this);
        this.f3420e.setOnPreferenceChangeListener(this);
        if (this.f3418c.isChecked()) {
            m3781a(m3782b(), this.f3420e, getResources().getColor(R.color.blue_color_021));
        } else {
            m3781a(m3782b(), this.f3420e, getResources().getColor(android.R.color.secondary_text_dark));
        }
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean zBooleanValue;
        boolean z;
        char c;
        boolean zIsChecked = this.f3418c.isChecked();
        boolean zIsChecked2 = this.f3419d.isChecked();
        if (preference == this.f3418c) {
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            if (zBooleanValue2) {
                m3781a(m3782b(), this.f3420e, getResources().getColor(R.color.blue_color_021));
                z = zBooleanValue2;
                zBooleanValue = zIsChecked2;
            } else {
                m3781a(m3782b(), this.f3420e, getResources().getColor(android.R.color.secondary_text_dark));
                z = zBooleanValue2;
                zBooleanValue = zIsChecked2;
            }
        } else if (preference == this.f3419d) {
            zBooleanValue = ((Boolean) obj).booleanValue();
            z = zIsChecked;
        } else {
            zBooleanValue = zIsChecked2;
            z = zIsChecked;
        }
        if (preference == this.f3418c || preference == this.f3419d) {
            if (z && zBooleanValue) {
                this.f3417b.putString("Set Type", "ALL");
                c = 0;
            } else if (z && !zBooleanValue) {
                this.f3417b.putString("Set Type", "MELODY");
                c = 1;
            } else if (!z && zBooleanValue) {
                this.f3417b.putString("Set Type", "VIBRATION");
                c = 2;
            } else {
                this.f3417b.putString("Set Type", "OFF");
                c = 3;
            }
            this.f3417b.putString("Set Type Text", this.f3421f[c]);
            this.f3417b.commit();
        } else if (preference == this.f3420e) {
            String str = (String) obj;
            if (str == null || str.trim().length() == 0) {
                str = "Silent";
            }
            this.f3417b.putString("Ringtone", str);
            this.f3417b.commit();
            preference.setSummary(m3782b());
            m3781a(m3782b(), this.f3420e, getResources().getColor(R.color.blue_color_021));
        }
        return true;
    }

    /* renamed from: a */
    private Ringtone m3780a() {
        Uri actualDefaultRingtoneUri;
        String string = this.f3416a.getString("Ringtone", null);
        if (string != null) {
            actualDefaultRingtoneUri = "Silent".equals(string) ? null : Uri.parse(string);
        } else {
            actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this, 2);
            this.f3417b.putString("Ringtone", actualDefaultRingtoneUri.toString());
            this.f3417b.commit();
        }
        if (actualDefaultRingtoneUri == null) {
            return null;
        }
        return RingtoneManager.getRingtone(this, actualDefaultRingtoneUri);
    }

    /* renamed from: b */
    private String m3782b() {
        Ringtone ringtoneM3780a = m3780a();
        return ringtoneM3780a == null ? getString(R.string.ringtone_silent) : ringtoneM3780a.getTitle(this);
    }

    /* renamed from: a */
    private void m3781a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }
}
