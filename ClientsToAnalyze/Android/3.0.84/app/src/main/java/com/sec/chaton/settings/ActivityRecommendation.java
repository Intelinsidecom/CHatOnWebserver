package com.sec.chaton.settings;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ActivityRecommendation extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: a */
    String f9089a = "Settings";

    /* renamed from: b */
    private boolean f9090b = true;

    /* renamed from: c */
    private C3160ab f9091c = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(R.xml.pref_setting_recommend);
        this.f9091c = C3159aa.m10962a();
        this.f9091c.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m9064a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m9064a() {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_recommend_normal");
        if (this.f9091c.m10977a("recomned_normal", (Boolean) true).booleanValue()) {
            this.f9090b = true;
            this.f9091c.m10983b("recomned_normal", (Boolean) true);
        } else {
            this.f9090b = false;
            this.f9091c.m10983b("recomned_normal", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f9090b);
        m9065a(getResources().getString(R.string.setting_birthday_description), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C2467ca(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m9065a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
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

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
