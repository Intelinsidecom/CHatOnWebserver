package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;

/* loaded from: classes.dex */
public class FragmentAlertTypeView2 extends PreferenceListFragment implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    private SharedPreferences f4590a;

    /* renamed from: b */
    private SharedPreferences.Editor f4591b;

    /* renamed from: c */
    private CheckBoxPreference f4592c;

    /* renamed from: d */
    private CheckBoxPreference f4593d;

    /* renamed from: e */
    private Preference f4594e;

    /* renamed from: f */
    private String[] f4595f;

    /* renamed from: g */
    private Context f4596g;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_alertype);
        this.f4596g = getActivity();
        this.f4590a = C1789u.m6075a();
        this.f4591b = this.f4590a.edit();
        this.f4595f = getResources().getStringArray(R.array.settings_type_options_value);
        this.f4592c = (CheckBoxPreference) m6121a("pref_item_sound");
        this.f4593d = (CheckBoxPreference) m6121a("pref_item_vibration");
        this.f4594e = m6121a("pref_item_sound_type");
        this.f4592c.setOnPreferenceChangeListener(this);
        this.f4593d.setOnPreferenceChangeListener(this);
        this.f4594e.setOnPreferenceChangeListener(this);
        if (this.f4592c.isChecked()) {
            m4587a(m4588b(), this.f4594e, getResources().getColor(R.color.ics_orange_font_color));
        } else {
            m4587a(m4588b(), this.f4594e, getResources().getColor(android.R.color.secondary_text_dark));
        }
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean zBooleanValue;
        boolean z;
        int i;
        boolean zIsChecked = this.f4592c.isChecked();
        boolean zIsChecked2 = this.f4593d.isChecked();
        if (preference == this.f4592c) {
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            if (zBooleanValue2) {
                m4587a(m4588b(), this.f4594e, getResources().getColor(R.color.ics_orange_font_color));
                z = zBooleanValue2;
                zBooleanValue = zIsChecked2;
            } else {
                m4587a(m4588b(), this.f4594e, getResources().getColor(android.R.color.secondary_text_dark));
                z = zBooleanValue2;
                zBooleanValue = zIsChecked2;
            }
        } else if (preference == this.f4593d) {
            zBooleanValue = ((Boolean) obj).booleanValue();
            z = zIsChecked;
        } else {
            zBooleanValue = zIsChecked2;
            z = zIsChecked;
        }
        if (preference == this.f4592c || preference == this.f4593d) {
            if (z && zBooleanValue) {
                this.f4591b.putString("Set Type", "ALL");
                i = 0;
            } else if (z && !zBooleanValue) {
                this.f4591b.putString("Set Type", "MELODY");
                i = 1;
            } else if (!z && zBooleanValue) {
                this.f4591b.putString("Set Type", "VIBRATION");
                i = 2;
            } else {
                this.f4591b.putString("Set Type", "OFF");
                i = 3;
            }
            this.f4591b.putString("Set Type Text", Integer.toString(i));
            this.f4591b.commit();
        } else if (preference == this.f4594e) {
            String str = (String) obj;
            if (str == null || str.trim().length() == 0) {
                str = "Silent";
            }
            this.f4591b.putString("Ringtone", str);
            this.f4591b.commit();
            preference.setSummary(m4588b());
            m4587a(m4588b(), this.f4594e, getResources().getColor(R.color.ics_orange_font_color));
        }
        return true;
    }

    /* renamed from: a */
    private Ringtone m4586a() {
        Uri actualDefaultRingtoneUri;
        String string = this.f4590a.getString("Ringtone", null);
        if (string != null) {
            actualDefaultRingtoneUri = "Silent".equals(string) ? null : Uri.parse(string);
        } else {
            actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f4596g, 2);
            this.f4591b.putString("Ringtone", actualDefaultRingtoneUri.toString());
            this.f4591b.commit();
        }
        if (actualDefaultRingtoneUri == null) {
            return null;
        }
        return RingtoneManager.getRingtone(this.f4596g, actualDefaultRingtoneUri);
    }

    /* renamed from: b */
    private String m4588b() {
        Ringtone ringtoneM4586a = m4586a();
        return ringtoneM4586a == null ? getString(R.string.ringtone_silent) : ringtoneM4586a.getTitle(this.f4596g);
    }

    /* renamed from: a */
    private void m4587a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }
}
