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
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ActivityRecommendation extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: a */
    String f12649a = "Settings";

    /* renamed from: b */
    private boolean f12650b = true;

    /* renamed from: c */
    private C4810ab f12651c = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(R.xml.pref_setting_recommend);
        this.f12651c = C4809aa.m18104a();
        this.f12651c.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m13533a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m13533a() {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_recommend_normal");
        if (this.f12651c.m18119a("recomned_normal", (Boolean) true).booleanValue()) {
            this.f12650b = true;
            this.f12651c.m18125b("recomned_normal", (Boolean) true);
        } else {
            this.f12650b = false;
            this.f12651c.m18125b("recomned_normal", (Boolean) false);
        }
        checkBoxPreference.setChecked(this.f12650b);
        m13534a(getResources().getString(R.string.setting_birthday_description_of_contact), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C3562cz(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m13534a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
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
