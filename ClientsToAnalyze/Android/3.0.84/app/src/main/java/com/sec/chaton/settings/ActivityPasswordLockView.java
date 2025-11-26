package com.sec.chaton.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ActivityPasswordLockView extends BasePreferenceActivity implements View.OnClickListener {

    /* renamed from: c */
    private CheckBoxPreference f9054c;

    /* renamed from: d */
    private Preference f9055d;

    /* renamed from: e */
    private Preference f9056e;

    /* renamed from: a */
    private String f9052a = ActivityPasswordLockView.class.getSimpleName();

    /* renamed from: b */
    private String f9053b = "OFF";

    /* renamed from: f */
    private int f9057f = 0;

    /* renamed from: g */
    private String[] f9058g = new String[2];

    /* renamed from: h */
    private String f9059h = null;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
        addPreferencesFromResource(R.xml.pref_setting_password_lock);
        this.f9054c = (CheckBoxPreference) findPreference("pref_item_password_lock");
        this.f9055d = findPreference("pref_item_change_password_lock");
        this.f9056e = findPreference("pref_item_hint_password_lock");
        this.f9058g = m9037a("GET", "", "");
        m9036a(this.f9058g[this.f9057f]);
        this.f9054c.setOnPreferenceClickListener(new C2454bo(this));
        this.f9055d.setOnPreferenceClickListener(new C2455bp(this));
        this.f9056e.setOnPreferenceClickListener(new C2456bq(this));
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    public void m9036a(String str) {
        C3250y.m11450b("changeSummary", this.f9052a);
        this.f9059h = getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        if (str.equals(C3241p.m11408d())) {
            this.f9054c.setChecked(true);
            m9032b(getString(R.string.settings_password_lock_text_on), this.f9054c, getResources().getColor(R.color.buddy_list_item_status_changed));
            m9030a(getString(R.string.settings_password_lock_change), this.f9055d, getResources().getColor(R.color.color2));
            m9030a(getString(R.string.label_for_passlock_hint), this.f9056e, getResources().getColor(R.color.color2));
        } else {
            this.f9054c.setChecked(false);
            m9032b(getString(R.string.settings_password_lock_text_off), this.f9054c, getResources().getColor(R.color.setting_explain_text));
            m9030a(getString(R.string.settings_password_lock_change), this.f9055d, getResources().getColor(R.color.dark_gray));
            m9030a(getString(R.string.label_for_passlock_hint), this.f9056e, getResources().getColor(R.color.dark_gray));
        }
        if ("".equals(this.f9059h)) {
            m9032b(getString(R.string.description_for_passlock_hint), this.f9056e, getResources().getColor(R.color.setting_explain_text));
        } else {
            m9032b(getString(R.string.description_for_passlock_hint_change), this.f9056e, getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* renamed from: a */
    public String[] m9037a(String str, String str2, String str3) {
        C3250y.m11450b("prePassword", this.f9052a);
        C3160ab c3160abM10962a = C3159aa.m10962a();
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C3250y.m11450b("GET preference", this.f9052a);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C3241p.m11409e());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C3250y.m11450b("data : " + strArr[i2], this.f9052a);
            }
        } else {
            C3250y.m11450b("SET preference", this.f9052a);
            C3250y.m11450b("state : " + str2, this.f9052a);
            C3250y.m11450b("pass : " + str3, this.f9052a);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM11401b = C3241p.m11401b(str2);
            String strM11401b2 = C3241p.m11401b(str3);
            editorEdit.putString("LOCK_STATE", strM11401b);
            editorEdit.putString("PASSWORD", strM11401b2);
            editorEdit.commit();
            C3159aa.m10962a().m10986b("OFF", str2);
            C3250y.m11450b("LOCK_STATE : " + c3160abM10962a.m10979a("OFF", "default"), this.f9052a);
        }
        return strArr;
    }

    /* renamed from: a */
    private void m9030a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: b */
    private void m9032b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C3250y.m11453c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
        this.f9058g = m9037a("GET", "", "");
        m9036a(this.f9058g[this.f9057f]);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9052a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
