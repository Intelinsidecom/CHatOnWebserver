package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings2.HeaderAdapter;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityGeneral extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: e */
    private static List<PreferenceActivity.Header> f8967e;

    /* renamed from: b */
    AboutNewNotice f8969b;

    /* renamed from: c */
    private Context f8970c;

    /* renamed from: a */
    String f8968a = "Settings";

    /* renamed from: d */
    private C3160ab f8971d = null;

    /* renamed from: f */
    private HeaderAdapter f8972f = null;

    /* renamed from: g */
    private BroadcastReceiver f8973g = new C2426an(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00130001");
        }
        this.f8970c = this;
        if (!GlobalApplication.m6456e()) {
            addPreferencesFromResource(R.xml.pref_setting_general);
            getListView().setScrollingCacheEnabled(false);
        }
        this.f8971d = C3159aa.m10962a();
        this.f8971d.m10983b("Lock Check", (Boolean) false);
        try {
            if (GlobalApplication.m6456e()) {
                m8969b();
            } else {
                m8968a();
            }
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m8968a() {
        this.f8969b = (AboutNewNotice) findPreference("pref_item_noti");
        this.f8969b.setOnPreferenceClickListener(new C2423ak(this));
        findPreference("pref_item_help").setOnPreferenceClickListener(new C2424al(this));
        findPreference("pref_item_VOC").setOnPreferenceClickListener(new C2425am(this));
    }

    /* renamed from: b */
    private void m8969b() {
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List<PreferenceActivity.Header> list) {
        super.onBuildHeaders(list);
        f8967e = list;
        if (GlobalApplication.m6456e()) {
            loadHeadersFromResource(R.xml.pref_setting_general_headers, list);
        }
    }

    @Override // android.app.ListActivity
    public void setListAdapter(ListAdapter listAdapter) {
        if (listAdapter == null) {
            super.setListAdapter(null);
        } else {
            this.f8972f = new HeaderAdapter(this, f8967e);
            super.setListAdapter(this.f8972f);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f8973g);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m8971c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_tab_badge_update");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.f8973g, intentFilter);
        if (GlobalApplication.m6456e()) {
            getListView().setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_holo_light);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8971c() {
        if (!GlobalApplication.m6456e()) {
            C3250y.m11453c("#NOTCIE : " + C3159aa.m10962a().m10978a("notice", (Integer) 0), getClass().getSimpleName());
            if (C3159aa.m10962a().m10978a("notice", (Integer) 0).intValue() > 0) {
                this.f8969b.m8910a(true, C3159aa.m10962a().m10978a("notice", (Integer) 0).intValue());
            } else {
                this.f8969b.m8909a(false);
            }
        }
    }

    @Override // android.preference.PreferenceActivity
    public void onHeaderClick(PreferenceActivity.Header header, int i) {
        super.onHeaderClick(header, i);
        if (this.f8972f != null) {
            this.f8972f.setSelectedPosition(i);
            getListView().invalidateViews();
        }
    }
}
