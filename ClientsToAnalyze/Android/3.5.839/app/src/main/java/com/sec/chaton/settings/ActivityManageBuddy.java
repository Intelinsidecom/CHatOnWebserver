package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* loaded from: classes.dex */
public class ActivityManageBuddy extends BasePreferenceActivity {

    /* renamed from: b */
    private Context f12537b;

    /* renamed from: a */
    String f12536a = "Settings";

    /* renamed from: c */
    private boolean f12538c = true;

    /* renamed from: d */
    private C4810ab f12539d = null;

    /* renamed from: e */
    private ProgressDialog f12540e = null;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12537b = this;
        this.f12540e = new ProgressDialogC4926s(this, false);
        this.f12540e.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        addPreferencesFromResource(R.xml.pref_setting_buddies);
        this.f12539d = C4809aa.m18104a();
        this.f12539d.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m13418a(getPreferenceScreen());
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m13418a(PreferenceScreen preferenceScreen) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_birthday");
        if (this.f12539d.m18119a("Profile Birth Chk", (Boolean) true).booleanValue()) {
            this.f12538c = true;
            this.f12539d.m18125b("Profile Birth Chk", (Boolean) true);
        } else {
            this.f12538c = false;
            this.f12539d.m18125b("Profile Birth Chk", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f12538c);
        m13419a(getResources().getString(R.string.setting_birthday_description_of_contact), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C3517bh(this));
        findPreference("pref_item_hided").setOnPreferenceClickListener(new C3518bi(this));
        findPreference("pref_item_blocked").setOnPreferenceClickListener(new C3519bj(this));
        findPreference("pref_item_suggestions").setOnPreferenceClickListener(new C3520bk(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m13419a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
