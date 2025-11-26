package com.sec.chaton.settings;

import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.settings.downloads.C2559az;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityAlertType2 extends BasePreferenceActivity implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    private C3160ab f8934a;

    /* renamed from: b */
    private CheckBoxPreference f8935b;

    /* renamed from: c */
    private CheckBoxPreference f8936c;

    /* renamed from: d */
    private CheckBoxPreference f8937d;

    /* renamed from: e */
    private Preference f8938e;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Vibrator vibrator;
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_setting_alertype);
        this.f8934a = C3159aa.m10962a();
        this.f8935b = (CheckBoxPreference) findPreference("pref_item_led");
        this.f8936c = (CheckBoxPreference) findPreference("pref_item_sound");
        this.f8937d = (CheckBoxPreference) findPreference("pref_item_vibration");
        this.f8938e = findPreference("pref_item_sound_type");
        if (Build.VERSION.SDK_INT > 10 && ((vibrator = (Vibrator) CommonApplication.m11493l().getSystemService("vibrator")) == null || !vibrator.hasVibrator())) {
            this.f8937d.setEnabled(false);
            this.f8937d.setChecked(false);
        }
        this.f8935b.setOnPreferenceChangeListener(this);
        this.f8936c.setOnPreferenceChangeListener(this);
        this.f8937d.setOnPreferenceChangeListener(this);
        this.f8938e.setOnPreferenceChangeListener(this);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        m8935a();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m8935a() throws Resources.NotFoundException {
        boolean z;
        boolean z2 = false;
        String strM5474i = C1103a.m5432a(this).m5474i();
        if (strM5474i.equals("ALL")) {
            z2 = true;
            z = true;
        } else if (strM5474i.equals("MELODY")) {
            z = true;
        } else if (strM5474i.equals("VIBRATION")) {
            z = false;
            z2 = true;
        } else {
            z = false;
        }
        this.f8936c.setChecked(z);
        this.f8937d.setChecked(z2);
        this.f8935b.setChecked(this.f8934a.m10977a("LED Indicator", (Boolean) true).booleanValue());
        m8936a(m8937b(), this.f8938e, this.f8936c.isChecked());
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        boolean zBooleanValue;
        boolean z;
        boolean zIsChecked = this.f8936c.isChecked();
        boolean zIsChecked2 = this.f8937d.isChecked();
        if (preference == this.f8936c) {
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            m8936a(m8937b(), this.f8938e, zBooleanValue2);
            z = zBooleanValue2;
            zBooleanValue = zIsChecked2;
        } else if (preference == this.f8937d) {
            zBooleanValue = ((Boolean) obj).booleanValue();
            z = zIsChecked;
        } else {
            zBooleanValue = zIsChecked2;
            z = zIsChecked;
        }
        if (preference == this.f8936c || preference == this.f8937d) {
            if (z && zBooleanValue) {
                this.f8934a.m10986b("Set Type", "ALL");
                return true;
            }
            if (z && !zBooleanValue) {
                this.f8934a.m10986b("Set Type", "MELODY");
                return true;
            }
            if (!z && zBooleanValue) {
                this.f8934a.m10986b("Set Type", "VIBRATION");
                return true;
            }
            this.f8934a.m10986b("Set Type", "OFF");
            return true;
        }
        if (preference == this.f8938e) {
            String str = (String) obj;
            if (str == null || str.trim().length() == 0) {
                str = "Silent";
            }
            this.f8934a.m10986b("Ringtone", str);
            preference.setSummary(m8937b());
            m8936a(m8937b(), this.f8938e, z);
            return true;
        }
        if (preference == this.f8935b) {
            this.f8934a.m10983b("LED Indicator", (Boolean) obj);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    private String m8937b() {
        boolean z;
        String str;
        String strM10979a = this.f8934a.m10979a("Ringtone title", getString(R.string.ringtone_silent));
        String strM10979a2 = this.f8934a.m10979a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM10979a2)) {
            if (strM10979a2.startsWith("content://")) {
                Ringtone ringtone = RingtoneManager.getRingtone(this, Uri.parse(strM10979a2));
                if (ringtone != null) {
                    return ringtone.getTitle(this);
                }
            } else {
                if (strM10979a2.startsWith("android.resource://")) {
                    Iterator<Map.Entry<String, C2559az>> it = C2559az.m9506a().entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            str = strM10979a;
                            break;
                        }
                        Map.Entry<String, C2559az> next = it.next();
                        if (strM10979a2.equals(next.getValue().f9738s)) {
                            z = true;
                            str = next.getValue().f9734o;
                            break;
                        }
                    }
                    if (!z) {
                        return m8938c();
                    }
                    return str;
                }
                if (strM10979a2.startsWith("file://")) {
                    if (!new File(strM10979a2.substring(7)).exists()) {
                        strM10979a = m8938c();
                    }
                    return strM10979a;
                }
            }
            return strM10979a;
        }
        return m8938c();
    }

    /* renamed from: c */
    private String m8938c() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this, 2);
        if (actualDefaultRingtoneUri == null) {
            return null;
        }
        this.f8934a.m10986b("Ringtone", actualDefaultRingtoneUri.toString());
        Ringtone ringtone = RingtoneManager.getRingtone(this, actualDefaultRingtoneUri);
        if (ringtone == null) {
            return null;
        }
        String title = ringtone.getTitle(this);
        this.f8934a.m10986b("Ringtone title", title);
        return title;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f8938e != null) {
            ((RingtonePreference2) this.f8938e).m9185a();
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f8938e != null) {
            ((RingtonePreference2) this.f8938e).m9186b();
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private void m8936a(String str, Preference preference, boolean z) throws Resources.NotFoundException {
        if (str != null) {
            int color = getResources().getColor(R.color.buddy_popup_center_background_focused);
            if (!z) {
                color = getResources().getColor(R.color.setting_explain_text);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 0);
            preference.setSummary(spannableString);
        }
    }
}
