package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityBuddyView extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    private Context f3424c;

    /* renamed from: a */
    String f3422a = "Settings";

    /* renamed from: d */
    private boolean f3425d = true;

    /* renamed from: e */
    private SharedPreferences f3426e = null;

    /* renamed from: b */
    SharedPreferences.Editor f3423b = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_buddies);
        this.f3424c = this;
        this.f3426e = C1323bs.m4575a();
        this.f3423b = this.f3426e.edit();
        this.f3423b.putBoolean("Lock Check", false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m3784a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m3784a() {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_birthday");
        if (this.f3426e.getBoolean("Profile Birth Chk", true)) {
            this.f3425d = true;
            this.f3423b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f3425d = false;
            this.f3423b.putBoolean("Profile Birth Chk", false).commit();
        }
        checkBoxPreference.setChecked(this.f3425d);
        m3785a(getResources().getString(R.string.setting_birthday_text), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C1053bx(this));
        findPreference("pref_item_blocked").setOnPreferenceClickListener(new C1052bw(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m3785a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
