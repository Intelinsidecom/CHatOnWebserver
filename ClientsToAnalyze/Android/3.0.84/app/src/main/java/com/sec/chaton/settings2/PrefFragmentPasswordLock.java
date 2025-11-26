package com.sec.chaton.settings2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockHint;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class PrefFragmentPasswordLock extends BasePreferenceFragment {
    private Preference passwordChange;
    private Preference passwordHint;
    private CheckBoxPreference passwordLock;
    private BreadCrumbsPreference passwordTitle;
    private String TAG = PrefFragmentPasswordLock.class.getSimpleName();
    private String LOCK_STATE = "OFF";
    private int INDEX_LOCKSTATE = 0;
    private String[] passwordData = new String[2];
    private String Hint = null;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_setting_password_lock);
        this.passwordTitle = (BreadCrumbsPreference) findPreference("pref_item_breadcrumbs");
        this.passwordTitle.setActivity(getActivity());
        this.passwordLock = (CheckBoxPreference) findPreference("pref_item_password_lock");
        this.passwordChange = findPreference("pref_item_change_password_lock");
        this.passwordHint = findPreference("pref_item_hint_password_lock");
        this.passwordLock.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPasswordLock.1
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3250y.m11450b("passwordLock select ok", PrefFragmentPasswordLock.this.TAG);
                C3250y.m11450b("now password state : " + PrefFragmentPasswordLock.this.passwordData[PrefFragmentPasswordLock.this.INDEX_LOCKSTATE], PrefFragmentPasswordLock.this.TAG);
                PrefFragmentPasswordLock.this.passwordData = PrefFragmentPasswordLock.this.prePassword("GET", "", "");
                if (PrefFragmentPasswordLock.this.passwordData[PrefFragmentPasswordLock.this.INDEX_LOCKSTATE].equals(C3241p.m11408d())) {
                    C3250y.m11450b("LOCK_STATE : " + PrefFragmentPasswordLock.this.LOCK_STATE, PrefFragmentPasswordLock.this.TAG);
                    PrefFragmentPasswordLock.this.changeSummary(C3241p.m11409e());
                    PrefFragmentPasswordLock.this.prePassword("SET", "OFF", "0000");
                    return false;
                }
                PrefFragmentPasswordLock.this.changeSummary(C3241p.m11409e());
                C3250y.m11450b("LOCK_STATE : " + PrefFragmentPasswordLock.this.LOCK_STATE, PrefFragmentPasswordLock.this.TAG);
                Intent intent = new Intent(PrefFragmentPasswordLock.this.getActivity(), (Class<?>) ActivityPasswordLockSet.class);
                intent.putExtra("MODE", "SET");
                PrefFragmentPasswordLock.this.startActivity(intent);
                return false;
            }
        });
        this.passwordChange.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPasswordLock.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3250y.m11450b("passwordLock select ok", PrefFragmentPasswordLock.this.TAG);
                C3250y.m11450b("now password state : " + PrefFragmentPasswordLock.this.passwordData[PrefFragmentPasswordLock.this.INDEX_LOCKSTATE], PrefFragmentPasswordLock.this.TAG);
                Intent intent = new Intent(PrefFragmentPasswordLock.this.getActivity(), (Class<?>) ActivityPasswordLockSet.class);
                intent.putExtra("MODE", "CHANGE");
                PrefFragmentPasswordLock.this.startActivity(intent);
                return false;
            }
        });
        this.passwordHint.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPasswordLock.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3250y.m11450b("passwordLock passwordHint", PrefFragmentPasswordLock.this.TAG);
                C3250y.m11450b("now password state : " + PrefFragmentPasswordLock.this.passwordData[PrefFragmentPasswordLock.this.INDEX_LOCKSTATE], PrefFragmentPasswordLock.this.TAG);
                PrefFragmentPasswordLock.this.startActivity(new Intent(PrefFragmentPasswordLock.this.getActivity(), (Class<?>) ActivityPasswordLockHint.class));
                return false;
            }
        });
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.passwordData = prePassword("GET", "", "");
        changeSummary(this.passwordData[this.INDEX_LOCKSTATE]);
    }

    public void changeSummary(String str) {
        C3250y.m11450b("changeSummary", this.TAG);
        this.Hint = getActivity().getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        if (str.equals(C3241p.m11408d())) {
            this.passwordLock.setChecked(true);
            setSummaryWitColor(getString(R.string.settings_password_lock_text_on), this.passwordLock, getResources().getColor(R.color.setting_explain_text));
            setTitleTextWitColor(getString(R.string.settings_password_lock_change), this.passwordChange, getResources().getColor(R.color.color2));
            setTitleTextWitColor(getString(R.string.label_for_passlock_hint), this.passwordHint, getResources().getColor(R.color.color2));
        } else {
            this.passwordLock.setChecked(false);
            setSummaryWitColor(getString(R.string.settings_password_lock_text_off), this.passwordLock, getResources().getColor(R.color.setting_explain_text));
            setTitleTextWitColor(getString(R.string.settings_password_lock_change), this.passwordChange, getResources().getColor(R.color.dark_gray));
            setTitleTextWitColor(getString(R.string.label_for_passlock_hint), this.passwordHint, getResources().getColor(R.color.dark_gray));
        }
        if ("".equals(this.Hint)) {
            setSummaryWitColor(getString(R.string.description_for_passlock_hint), this.passwordHint, getResources().getColor(R.color.setting_explain_text));
        } else {
            setSummaryWitColor(getString(R.string.description_for_passlock_hint_change), this.passwordHint, getResources().getColor(R.color.setting_explain_text));
        }
    }

    public String[] prePassword(String str, String str2, String str3) {
        C3250y.m11450b("prePassword", this.TAG);
        C3160ab c3160abM10962a = C3159aa.m10962a();
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C3250y.m11450b("GET preference", this.TAG);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C3241p.m11409e());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C3250y.m11450b("data : " + strArr[i2], this.TAG);
            }
        } else {
            C3250y.m11450b("SET preference", this.TAG);
            C3250y.m11450b("state : " + str2, this.TAG);
            C3250y.m11450b("pass : " + str3, this.TAG);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM11401b = C3241p.m11401b(str2);
            String strM11401b2 = C3241p.m11401b(str3);
            editorEdit.putString("LOCK_STATE", strM11401b);
            editorEdit.putString("PASSWORD", strM11401b2);
            editorEdit.commit();
            C3159aa.m10962a().m10986b("OFF", str2);
            C3250y.m11450b("LOCK_STATE : " + c3160abM10962a.m10979a("OFF", "default"), this.TAG);
        }
        return strArr;
    }

    private void setTitleTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    private void setSummaryWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }
}
