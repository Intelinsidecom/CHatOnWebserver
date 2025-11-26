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
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ActivityPasswordLockView extends BasePreferenceActivity implements View.OnClickListener {

    /* renamed from: c */
    private CheckBoxPreference f12616c;

    /* renamed from: d */
    private Preference f12617d;

    /* renamed from: e */
    private Preference f12618e;

    /* renamed from: a */
    private String f12614a = ActivityPasswordLockView.class.getSimpleName();

    /* renamed from: b */
    private String f12615b = "OFF";

    /* renamed from: f */
    private int f12619f = 0;

    /* renamed from: g */
    private String[] f12620g = new String[2];

    /* renamed from: h */
    private String f12621h = null;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
        addPreferencesFromResource(R.xml.pref_setting_password_lock);
        this.f12616c = (CheckBoxPreference) findPreference("pref_item_password_lock");
        this.f12617d = findPreference("pref_item_change_password_lock");
        this.f12618e = findPreference("pref_item_hint_password_lock");
        this.f12620g = m13506a("GET", "", "");
        m13505a(this.f12620g[this.f12619f]);
        this.f12616c.setOnPreferenceClickListener(new C3550cn(this));
        this.f12617d.setOnPreferenceClickListener(new C3551co(this));
        this.f12618e.setOnPreferenceClickListener(new C3552cp(this));
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    public void m13505a(String str) {
        C4904y.m18639b("changeSummary", this.f12614a);
        this.f12621h = getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        if (!str.equals(C4892m.m18588h())) {
            this.f12616c.setChecked(true);
            m13500b(getString(R.string.settings_password_lock_text_on), this.f12616c, getResources().getColor(R.color.buddy_list_item_status_changed));
            m13498a(getString(R.string.settings_password_lock_change), this.f12617d, getResources().getColor(R.color.color2));
            m13498a(getString(R.string.label_for_passlock_hint), this.f12618e, getResources().getColor(R.color.color2));
        } else {
            this.f12616c.setChecked(false);
            m13500b(getString(R.string.settings_password_lock_text_off), this.f12616c, getResources().getColor(R.color.setting_explain_text));
            m13498a(getString(R.string.settings_password_lock_change), this.f12617d, getResources().getColor(R.color.dark_gray));
            m13498a(getString(R.string.label_for_passlock_hint), this.f12618e, getResources().getColor(R.color.dark_gray));
        }
        if ("".equals(this.f12621h)) {
            m13500b(getString(R.string.description_for_passlock_hint), this.f12618e, getResources().getColor(R.color.setting_explain_text));
        } else {
            m13500b(getString(R.string.description_for_passlock_hint_change), this.f12618e, getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* renamed from: a */
    public String[] m13506a(String str, String str2, String str3) {
        String strM18588h;
        C4904y.m18639b("prePassword", this.f12614a);
        C4810ab c4810abM18104a = C4809aa.m18104a();
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C4904y.m18639b("GET preference", this.f12614a);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C4892m.m18588h());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C4904y.m18639b("data : " + strArr[i2], this.f12614a);
            }
        } else {
            C4904y.m18639b("SET preference", this.f12614a);
            C4904y.m18639b("state : " + str2, this.f12614a);
            C4904y.m18639b("pass : " + str3, this.f12614a);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!str2.equals("OFF")) {
                strM18588h = C4892m.m18586g();
            } else {
                strM18588h = C4892m.m18588h();
            }
            String strM18567a = C4892m.m18567a(str3);
            editorEdit.putString("LOCK_STATE", strM18588h);
            editorEdit.putString("PASSWORD", strM18567a);
            editorEdit.commit();
            C4809aa.m18104a().m18128b("OFF", str2);
            C4904y.m18639b("LOCK_STATE : " + c4810abM18104a.m18121a("OFF", "default"), this.f12614a);
        }
        return strArr;
    }

    /* renamed from: a */
    private void m13498a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: b */
    private void m13500b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C4904y.m18641c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
        this.f12620g = m13506a("GET", "", "");
        m13505a(this.f12620g[this.f12619f]);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C4904y.m18641c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12614a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
