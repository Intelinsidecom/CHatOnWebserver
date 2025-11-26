package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivitySettings extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    AboutNewNotice f3468c;

    /* renamed from: d */
    SyncStatePreference f3469d;

    /* renamed from: e */
    PreferenceScreen f3470e;

    /* renamed from: f */
    private Context f3471f;

    /* renamed from: h */
    private C1056c f3473h;

    /* renamed from: i */
    private ProgressDialog f3474i;

    /* renamed from: a */
    String f3466a = "Settings";

    /* renamed from: g */
    private SharedPreferences f3472g = null;

    /* renamed from: b */
    SharedPreferences.Editor f3467b = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.preference_setting2);
        this.f3471f = this;
        this.f3472g = C1323bs.m4575a();
        this.f3467b = this.f3472g.edit();
        this.f3473h = new C1056c(this.f3472g);
        this.f3467b.putBoolean("Lock Check", false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m3816a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m3816a() {
        this.f3470e = (PreferenceScreen) findPreference("pref_screen");
        findPreference("pref_item_Buddies").setOnPreferenceClickListener(new C1081m(this));
        findPreference("pref_item_Chats").setOnPreferenceClickListener(new C1090v(this));
        findPreference("pref_item_Privacy").setOnPreferenceClickListener(new C1089u(this));
        findPreference("pref_item_Noti").setOnPreferenceClickListener(new C1088t(this));
        this.f3468c = (AboutNewNotice) findPreference("pref_item_General");
        this.f3468c.setOnPreferenceClickListener(new C1087s(this));
        C1341p.m4658b("# notice in setting : " + C1323bs.m4575a().getInt("notice", 0), "ChatON");
        if (C1323bs.m4575a().contains("UpdateIsCritical") || C1323bs.m4575a().getInt("notice", 0) > 0) {
            this.f3468c.m3779a(true);
        } else {
            this.f3468c.m3779a(false);
        }
        Preference preferenceFindPreference = findPreference("pref_item_send_log");
        if (C1323bs.m4575a().getInt(C1341p.f4582f, 0) > 0) {
            preferenceFindPreference.setOnPreferenceClickListener(new C1086r(this));
        } else {
            this.f3470e.removePreference(preferenceFindPreference);
        }
        this.f3469d = (SyncStatePreference) findPreference("pref_item_sync_now");
        m3817a(getResources().getString(R.string.setting_sync_now_text), this.f3469d, getResources().getColor(R.color.blue_color_018));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m3817a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f3469d.m3916b();
        if (this.f3474i != null) {
            this.f3474i.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f3469d.m3915a();
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
