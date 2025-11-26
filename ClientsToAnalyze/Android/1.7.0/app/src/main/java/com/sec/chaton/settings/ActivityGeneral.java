package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1335j;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityGeneral extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    AboutNewNotice f3433c;

    /* renamed from: d */
    AboutNewNotice f3434d;

    /* renamed from: e */
    private Context f3435e;

    /* renamed from: g */
    private C1056c f3437g;

    /* renamed from: a */
    String f3431a = "Settings";

    /* renamed from: f */
    private SharedPreferences f3436f = null;

    /* renamed from: b */
    SharedPreferences.Editor f3432b = null;

    /* renamed from: h */
    private BroadcastReceiver f3438h = new C1044bo(this);

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            ((View) getListView().getParent()).setPadding(0, 0, 0, 0);
        }
        addPreferencesFromResource(R.xml.layout_setting_general);
        getListView().setScrollingCacheEnabled(false);
        this.f3435e = this;
        this.f3436f = C1323bs.m4575a();
        this.f3432b = this.f3436f.edit();
        this.f3437g = new C1056c(this.f3436f);
        this.f3432b.putBoolean("Lock Check", false);
        try {
            m3790a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m3791a(Context context) {
        C1335j.m4617a(context, context.getString(R.string.settings_invite_friend), context.getString(R.string.setting_chaton_tell_friends_email_text, "www.chaton.com/invite.html"), null);
    }

    /* renamed from: a */
    private void m3790a() {
        this.f3434d = (AboutNewNotice) findPreference("pref_item_noti");
        this.f3434d.setOnPreferenceClickListener(new C1050bu(this));
        this.f3433c = (AboutNewNotice) findPreference("pref_item_about");
        this.f3433c.setOnPreferenceClickListener(new C1049bt(this));
        findPreference("pref_item_help").setOnPreferenceClickListener(new C1048bs(this));
        findPreference("pref_item_invite_friend").setOnPreferenceClickListener(new C1047br(this));
        findPreference("pref_item_delete").setOnPreferenceClickListener(new C1046bq(this));
        findPreference("pref_item_VOC").setOnPreferenceClickListener(new C1045bp(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f3438h);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m3792b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.f3438h, intentFilter);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3792b() {
        C1341p.m4660c("#NOTCIE : " + C1323bs.m4575a().getInt("notice", 0) + " Update contain is " + C1323bs.m4575a().contains("UpdateIsCritical"), getClass().getSimpleName());
        if (C1323bs.m4575a().getInt("notice", 0) > 0) {
            this.f3434d.m3779a(true);
        } else {
            this.f3434d.m3779a(false);
        }
        if (C1323bs.m4575a().contains("UpdateIsCritical")) {
            this.f3433c.m3779a(true);
        } else {
            this.f3433c.m3779a(false);
        }
    }
}
