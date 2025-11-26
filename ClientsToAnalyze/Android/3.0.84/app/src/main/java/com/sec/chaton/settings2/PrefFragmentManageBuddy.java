package com.sec.chaton.settings2;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class PrefFragmentManageBuddy extends BasePreferenceFragment {
    CheckBoxPreference prefItemBirthdayCategory;
    Preference prefItemBlocked;
    Preference prefItemHided;
    Preference prefItemSuggestions;
    private boolean isBirthdayCategory = true;
    private C3160ab sharedPref = null;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        addPreferencesFromResource(R.xml.pref_setting_buddies);
        try {
            initializeForPreference(getPreferenceScreen());
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    @Override // android.preference.PreferenceFragment
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        PreferenceActivity preferenceActivity = (PreferenceActivity) getActivity();
        if (preference == this.prefItemHided) {
            preferenceActivity.startPreferencePanel(PrefFragmentHide.class.getName(), null, 0, getString(R.string.settings_hided), null, 0);
            return true;
        }
        if (preference == this.prefItemBlocked) {
            preferenceActivity.startPreferencePanel(PrefFragmentBlock.class.getName(), null, 0, getString(R.string.settings_blocked), null, 0);
            return true;
        }
        if (preference != this.prefItemSuggestions) {
            return false;
        }
        preferenceActivity.startPreferencePanel(PrefFragmentSuggestion.class.getName(), null, 0, getString(R.string.recommendation), null, 0);
        return true;
    }

    private void initializeForPreference(PreferenceScreen preferenceScreen) {
        this.prefItemBirthdayCategory = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_birthday");
        if (this.sharedPref.m10977a("Profile Birth Chk", (Boolean) true).booleanValue()) {
            this.isBirthdayCategory = true;
            this.sharedPref.m10983b("Profile Birth Chk", (Boolean) true);
        } else {
            this.isBirthdayCategory = false;
            this.sharedPref.m10983b("Profile Birth Chk", (Boolean) false);
        }
        this.prefItemBirthdayCategory.setChecked(this.isBirthdayCategory);
        setTextWitColor(getResources().getString(R.string.setting_birthday_description), this.prefItemBirthdayCategory, getResources().getColor(R.color.setting_explain_text));
        this.prefItemBirthdayCategory.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentManageBuddy.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentManageBuddy.this.isBirthdayCategory = false;
                    PrefFragmentManageBuddy.this.sharedPref.m10983b("Profile Birth Chk", (Boolean) false);
                } else {
                    PrefFragmentManageBuddy.this.isBirthdayCategory = true;
                    PrefFragmentManageBuddy.this.sharedPref.m10983b("Profile Birth Chk", (Boolean) true);
                }
                return true;
            }
        });
        this.prefItemHided = preferenceScreen.findPreference("pref_item_hided");
        this.prefItemBlocked = preferenceScreen.findPreference("pref_item_blocked");
        this.prefItemSuggestions = preferenceScreen.findPreference("pref_item_suggestions");
    }

    private void setTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }
}
