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
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* loaded from: classes.dex */
public class ActivityManageBuddy extends BasePreferenceActivity {

    /* renamed from: b */
    private Context f8992b;

    /* renamed from: a */
    String f8991a = "Settings";

    /* renamed from: c */
    private boolean f8993c = true;

    /* renamed from: d */
    private C3160ab f8994d = null;

    /* renamed from: e */
    private ProgressDialog f8995e = null;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f8992b = this;
        this.f8995e = new ProgressDialogC3265l(this, false);
        this.f8995e.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        addPreferencesFromResource(R.xml.pref_setting_buddies);
        this.f8994d = C3159aa.m10962a();
        this.f8994d.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m8977a(getPreferenceScreen());
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
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
    private void m8977a(PreferenceScreen preferenceScreen) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("pref_item_birthday");
        if (this.f8994d.m10977a("Profile Birth Chk", (Boolean) true).booleanValue()) {
            this.f8993c = true;
            this.f8994d.m10983b("Profile Birth Chk", (Boolean) true);
        } else {
            this.f8993c = false;
            this.f8994d.m10983b("Profile Birth Chk", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f8993c);
        m8978a(getResources().getString(R.string.setting_birthday_description), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C2428ap(this));
        findPreference("pref_item_hided").setOnPreferenceClickListener(new C2429aq(this));
        findPreference("pref_item_blocked").setOnPreferenceClickListener(new C2430ar(this));
        findPreference("pref_item_suggestions").setOnPreferenceClickListener(new C2431as(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m8978a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
