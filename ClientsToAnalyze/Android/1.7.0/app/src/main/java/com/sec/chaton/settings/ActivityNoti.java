package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityNoti extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    AlarmManager f3441c;

    /* renamed from: d */
    private Context f3442d;

    /* renamed from: f */
    private int f3444f;

    /* renamed from: j */
    private String[] f3448j;

    /* renamed from: k */
    private String[] f3449k;

    /* renamed from: l */
    private Preference f3450l;

    /* renamed from: a */
    String f3439a = "Settings";

    /* renamed from: e */
    private SharedPreferences f3443e = null;

    /* renamed from: b */
    SharedPreferences.Editor f3440b = null;

    /* renamed from: g */
    private boolean f3445g = true;

    /* renamed from: h */
    private boolean f3446h = true;

    /* renamed from: i */
    private boolean f3447i = true;

    /* renamed from: a */
    static /* synthetic */ int m3794a(ActivityNoti activityNoti) {
        int i = activityNoti.f3444f + 1;
        activityNoti.f3444f = i;
        return i;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_noti);
        this.f3442d = this;
        this.f3443e = C1323bs.m4575a();
        this.f3440b = this.f3443e.edit();
        this.f3440b.putBoolean("Lock Check", false);
        this.f3441c = (AlarmManager) this.f3442d.getSystemService("alarm");
        this.f3448j = this.f3442d.getResources().getStringArray(R.array.settings_type_options_value);
        this.f3449k = this.f3442d.getResources().getStringArray(R.array.settings_type_options);
        getListView().setScrollingCacheEnabled(false);
        try {
            m3796a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m3796a() {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (this.f3443e.getBoolean("Setting Notification", true)) {
            this.f3447i = true;
            this.f3440b.putBoolean("Setting Notification", true).commit();
        } else {
            this.f3447i = false;
            this.f3440b.putBoolean("Setting Notification", false).commit();
        }
        checkBoxPreference.setChecked(this.f3447i);
        m3798a(getResources().getString(R.string.push_notification_text), checkBoxPreference, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference.setOnPreferenceChangeListener(new C1022at(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("pref_item_blackscreen_popup");
        if (this.f3443e.getBoolean("Setting show blackscreen popup", true)) {
            this.f3446h = true;
            this.f3440b.putBoolean("Setting show blackscreen popup", true).commit();
        } else {
            this.f3446h = false;
            this.f3440b.putBoolean("Setting show blackscreen popup", false).commit();
        }
        checkBoxPreference2.setChecked(this.f3446h);
        m3798a(getResources().getString(R.string.settings_popup_information), checkBoxPreference2, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference2.setOnPreferenceChangeListener(new C1021as(this));
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("pref_item_received_message");
        if (this.f3443e.getBoolean("Setting show receive message", true)) {
            this.f3445g = true;
            this.f3440b.putBoolean("Setting show receive message", true).commit();
        } else {
            this.f3445g = false;
            this.f3440b.putBoolean("Setting show receive message", false).commit();
        }
        checkBoxPreference3.setChecked(this.f3445g);
        m3798a(getResources().getString(R.string.settings_received_message_summary), checkBoxPreference3, getResources().getColor(R.color.setting_explain_text));
        checkBoxPreference3.setOnPreferenceChangeListener(new C1020ar(this));
        this.f3450l = findPreference("pref_item_type");
        if (this.f3443e.getString("Set Type Text", "") == "") {
            this.f3440b.putString("Set Type Text", this.f3442d.getResources().getStringArray(R.array.settings_type_options_value)[0]);
            this.f3440b.commit();
        }
        m3799a(this.f3447i);
        this.f3450l.setOnPreferenceClickListener(new C1019aq(this));
        C0192ae.m739a().mo744c(new HandlerC1018ap(this, Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3799a(boolean z) {
        String str;
        int i = 0;
        String string = this.f3443e.getString("Set Type Text", this.f3442d.getResources().getStringArray(R.array.settings_type_options_value)[0]);
        while (true) {
            if (i >= this.f3448j.length) {
                str = string;
                break;
            } else if (!string.equals(this.f3448j[i])) {
                i++;
            } else {
                str = this.f3449k[i];
                break;
            }
        }
        if (z) {
            m3798a(str, this.f3450l, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            m3798a(str, this.f3450l, getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3798a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
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
        m3799a(this.f3447i);
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
