package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.settings.RingtonePreference2;
import com.sec.chaton.settings.downloads.C2559az;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3225cm;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentAlertType extends BasePreferenceFragment implements Preference.OnPreferenceChangeListener {
    private static final String SILENT_STRING = "Silent";
    private PreferenceActivity mActivity;
    private CheckBoxPreference mLedPreference;
    private C3160ab mPref;
    private CheckBoxPreference mSoundPreference;
    private Preference mSoundTypePreference;
    private CheckBoxPreference mVibrationPreference;
    private BreadCrumbsPreference prefItemTitle;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Vibrator vibrator;
        this.mActivity = (PreferenceActivity) getActivity();
        C3225cm.m11337a(this.mActivity);
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_setting_alertype);
        this.mPref = C3159aa.m10962a();
        this.prefItemTitle = (BreadCrumbsPreference) findPreference("pref_item_breadcrumbs");
        this.prefItemTitle.setActivity(this.mActivity);
        this.mLedPreference = (CheckBoxPreference) findPreference("pref_item_led");
        this.mSoundPreference = (CheckBoxPreference) findPreference("pref_item_sound");
        this.mVibrationPreference = (CheckBoxPreference) findPreference("pref_item_vibration");
        this.mSoundTypePreference = findPreference("pref_item_sound_type");
        if (Build.VERSION.SDK_INT > 10 && ((vibrator = (Vibrator) CommonApplication.m11493l().getSystemService("vibrator")) == null || !vibrator.hasVibrator())) {
            this.mVibrationPreference.setEnabled(false);
            this.mVibrationPreference.setChecked(false);
        }
        this.mLedPreference.setOnPreferenceChangeListener(this);
        this.mSoundPreference.setOnPreferenceChangeListener(this);
        this.mVibrationPreference.setOnPreferenceChangeListener(this);
        this.mSoundTypePreference.setOnPreferenceChangeListener(this);
    }

    private void setAlertPreference() throws Resources.NotFoundException {
        boolean z;
        boolean z2 = false;
        String strM5474i = C1103a.m5432a(this.mActivity).m5474i();
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
        this.mSoundPreference.setChecked(z);
        this.mVibrationPreference.setChecked(z2);
        this.mLedPreference.setChecked(this.mPref.m10977a("LED Indicator", (Boolean) true).booleanValue());
        setSummaryWithColor(getCurrentRingtoneTitle(), this.mSoundTypePreference, this.mSoundPreference.isChecked());
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        boolean zBooleanValue;
        boolean z;
        boolean zIsChecked = this.mSoundPreference.isChecked();
        boolean zIsChecked2 = this.mVibrationPreference.isChecked();
        if (preference == this.mSoundPreference) {
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            setSummaryWithColor(getCurrentRingtoneTitle(), this.mSoundTypePreference, zBooleanValue2);
            z = zBooleanValue2;
            zBooleanValue = zIsChecked2;
        } else if (preference == this.mVibrationPreference) {
            zBooleanValue = ((Boolean) obj).booleanValue();
            z = zIsChecked;
        } else {
            zBooleanValue = zIsChecked2;
            z = zIsChecked;
        }
        if (preference == this.mSoundPreference || preference == this.mVibrationPreference) {
            if (z && zBooleanValue) {
                this.mPref.m10986b("Set Type", "ALL");
                return true;
            }
            if (z && !zBooleanValue) {
                this.mPref.m10986b("Set Type", "MELODY");
                return true;
            }
            if (!z && zBooleanValue) {
                this.mPref.m10986b("Set Type", "VIBRATION");
                return true;
            }
            this.mPref.m10986b("Set Type", "OFF");
            return true;
        }
        if (preference == this.mSoundTypePreference) {
            String str = (String) obj;
            if (str == null || str.trim().length() == 0) {
                str = SILENT_STRING;
            }
            this.mPref.m10986b("Ringtone", str);
            preference.setSummary(getCurrentRingtoneTitle());
            setSummaryWithColor(getCurrentRingtoneTitle(), this.mSoundTypePreference, z);
            return true;
        }
        if (preference == this.mLedPreference) {
            this.mPref.m10983b("LED Indicator", (Boolean) obj);
            return true;
        }
        return true;
    }

    private String getCurrentRingtoneTitle() {
        boolean z;
        String str;
        String strM10979a = this.mPref.m10979a("Ringtone title", getString(R.string.ringtone_silent));
        String strM10979a2 = this.mPref.m10979a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM10979a2)) {
            if (strM10979a2.startsWith("content://")) {
                Ringtone ringtone = RingtoneManager.getRingtone(this.mActivity, Uri.parse(strM10979a2));
                if (ringtone != null) {
                    return ringtone.getTitle(this.mActivity);
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
                        return initDefaultRingtoneTitle();
                    }
                    return str;
                }
                if (strM10979a2.startsWith("file://")) {
                    if (!new File(strM10979a2.substring(7)).exists()) {
                        strM10979a = initDefaultRingtoneTitle();
                    }
                    return strM10979a;
                }
            }
            return strM10979a;
        }
        return initDefaultRingtoneTitle();
    }

    private String initDefaultRingtoneTitle() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.mActivity, 2);
        if (actualDefaultRingtoneUri == null) {
            return null;
        }
        this.mPref.m10986b("Ringtone", actualDefaultRingtoneUri.toString());
        Ringtone ringtone = RingtoneManager.getRingtone(this.mActivity, actualDefaultRingtoneUri);
        if (ringtone == null) {
            return null;
        }
        String title = ringtone.getTitle(this.mActivity);
        this.mPref.m10986b("Ringtone title", title);
        return title;
    }

    @Override // android.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        setAlertPreference();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mSoundTypePreference != null) {
            ((RingtonePreference2) this.mSoundTypePreference).m9185a();
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        if (this.mSoundTypePreference != null) {
            ((RingtonePreference2) this.mSoundTypePreference).m9186b();
        }
        super.onDestroy();
    }

    private void setSummaryWithColor(String str, Preference preference, boolean z) throws Resources.NotFoundException {
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
