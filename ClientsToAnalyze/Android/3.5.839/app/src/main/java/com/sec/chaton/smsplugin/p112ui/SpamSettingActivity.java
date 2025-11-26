package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;

@TargetApi(14)
/* loaded from: classes.dex */
public class SpamSettingActivity extends BasePreferenceActivity {

    /* renamed from: a */
    private C4810ab f15164a = null;

    /* renamed from: b */
    private CheckBoxPreference f15165b;

    /* renamed from: c */
    private Preference f15166c;

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.spam_preferences);
        this.f15164a = C4809aa.m18104a();
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m16241a();
    }

    /* renamed from: a */
    private void m16241a() {
        this.f15165b = (CheckBoxPreference) findPreference("pref_key_spam_option_enable");
        this.f15166c = findPreference("pref_key_spam_num_add");
        boolean zBooleanValue = this.f15164a.m18119a("pref_key_spam_option_enable", (Boolean) true).booleanValue();
        this.f15164a.m18125b("pref_key_spam_option_enable", Boolean.valueOf(zBooleanValue));
        this.f15165b.setChecked(zBooleanValue);
        if (this.f15165b.isChecked()) {
            this.f15166c.setEnabled(true);
        } else {
            this.f15166c.setEnabled(false);
        }
        this.f15165b.setOnPreferenceChangeListener(new C4329iv(this));
        this.f15166c.setOnPreferenceClickListener(new C4330iw(this));
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m16244b();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    /* renamed from: b */
    private void m16244b() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().clear().apply();
        setPreferenceScreen(null);
        addPreferencesFromResource(R.xml.spam_preferences);
        m16241a();
    }

    /* renamed from: a */
    public static boolean m16242a(Context context) {
        return C4809aa.m18104a().m18119a("pref_key_spam_option_enable", (Boolean) true).booleanValue();
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C4904y.m18639b("onUserLeaveHint", getClass().getSimpleName());
    }
}
