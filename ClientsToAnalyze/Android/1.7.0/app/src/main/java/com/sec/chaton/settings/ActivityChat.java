package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityChat extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    private Context f3429c;

    /* renamed from: a */
    String f3427a = "Settings";

    /* renamed from: d */
    private SharedPreferences f3430d = null;

    /* renamed from: b */
    SharedPreferences.Editor f3428b = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_chats);
        this.f3429c = this;
        this.f3430d = C1323bs.m4575a();
        this.f3428b = this.f3430d.edit();
        this.f3428b.putBoolean("Lock Check", false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m3788a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m3788a() {
        findPreference("pref_item_change_background").setOnPreferenceClickListener(new C1034be(this));
        findPreference("pref_item_change_bubble").setOnPreferenceClickListener(new C1033bd(this));
        findPreference("pref_item_font_size").setOnPreferenceClickListener(new C1032bc(this));
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
