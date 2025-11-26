package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v4.content.LocalBroadcastManager;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.settings.downloads.C2620df;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.log.collector.C3358h;

/* loaded from: classes.dex */
public class ActivityDownloads extends BasePreferenceActivity {

    /* renamed from: b */
    AboutNewNotice f8954b;

    /* renamed from: c */
    PreferenceScreen f8955c;

    /* renamed from: d */
    private Context f8956d;

    /* renamed from: f */
    private AboutNewNotice f8958f;

    /* renamed from: g */
    private AboutNewNotice f8959g;

    /* renamed from: h */
    private AboutNewNotice f8960h;

    /* renamed from: i */
    private AboutNewNotice f8961i;

    /* renamed from: j */
    private AboutNewNotice f8962j;

    /* renamed from: k */
    private AboutNewNotice f8963k;

    /* renamed from: l */
    private AboutNewNotice f8964l;

    /* renamed from: m */
    private AbstractC3271a f8965m;

    /* renamed from: a */
    String f8953a = "Settings";

    /* renamed from: e */
    private C3160ab f8957e = null;

    /* renamed from: n */
    private BroadcastReceiver f8966n = new C2838z(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00110001");
        }
        this.f8956d = this;
        addPreferencesFromResource(R.xml.pref_setting_downloads);
        this.f8957e = C3159aa.m10962a();
        this.f8957e.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m8964b();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
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

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m8965c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_tab_badge_update");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f8966n, intentFilter);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f8966n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public boolean m8962a(EnumC2422aj enumC2422aj) {
        switch (enumC2422aj) {
            case External:
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    if (!C3223ck.m11330d()) {
                        m8959a();
                        return false;
                    }
                } else if (!C3223ck.m11331e()) {
                    m8959a();
                    return false;
                }
                return true;
            case Internal:
                if (!C3223ck.m11330d()) {
                    m8959a();
                    return false;
                }
                if ("mounted".equals(Environment.getExternalStorageState()) && !C3223ck.m11331e()) {
                    m8959a();
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private void m8959a() {
        if (this.f8965m == null) {
            this.f8965m = AbstractC3271a.m11494a(this.f8956d);
            this.f8965m.mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null);
        }
        this.f8965m.mo11512b();
    }

    /* renamed from: b */
    private void m8964b() {
        this.f8955c = (PreferenceScreen) findPreference("pref_screen");
        this.f8954b = (AboutNewNotice) findPreference("pref_item_downloads_chaton_v");
        if (C3159aa.m10962a().m10977a("ChatONVDownloadalbe", (Boolean) false).booleanValue()) {
            this.f8954b.setOnPreferenceClickListener(new C2414ab(this));
        } else {
            ((PreferenceCategory) findPreference("settings_title_more_apps")).removePreference(this.f8954b);
            this.f8955c.removePreference(findPreference("settings_title_more_apps"));
        }
        this.f8958f = (AboutNewNotice) findPreference("pref_item_downloads_ticcon");
        this.f8958f.setOnPreferenceClickListener(new C2415ac(this));
        this.f8959g = (AboutNewNotice) findPreference("pref_item_downloads_theme");
        this.f8959g.setOnPreferenceClickListener(new C2416ad(this));
        this.f8960h = (AboutNewNotice) findPreference("pref_item_downloads_ams_background");
        this.f8960h.setOnPreferenceClickListener(new C2417ae(this));
        this.f8961i = (AboutNewNotice) findPreference("pref_item_downloads_ams_stamp");
        this.f8961i.setOnPreferenceClickListener(new C2418af(this));
        this.f8962j = (AboutNewNotice) findPreference("pref_item_downloads_ams_template");
        this.f8962j.setOnPreferenceClickListener(new C2419ag(this));
        this.f8963k = (AboutNewNotice) findPreference("pref_item_downloads_sound");
        this.f8963k.setOnPreferenceClickListener(new C2420ah(this));
        this.f8964l = (AboutNewNotice) findPreference("pref_item_downloads_font");
        this.f8964l.setOnPreferenceClickListener(new C2421ai(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8965c() {
        if (C3159aa.m10962a().m10977a("ChatONVDownloadalbe", (Boolean) false).booleanValue() && this.f8954b != null) {
            this.f8954b.m8909a(true);
        }
        int iM9642a = C2646u.m9642a();
        if (iM9642a > 0) {
            this.f8958f.m8910a(true, iM9642a);
        } else {
            this.f8958f.m8909a(false);
        }
        int iM9580e = C2591cd.m9580e();
        if (iM9580e > 0) {
            this.f8959g.m8910a(true, iM9580e);
        } else {
            this.f8959g.m8909a(false);
        }
        int iM9632a = C2642q.m9632a(EnumC1327e.Background);
        if (iM9632a > 0) {
            this.f8960h.m8910a(true, iM9632a);
        } else {
            this.f8960h.m8909a(false);
        }
        int iM9632a2 = C2642q.m9632a(EnumC1327e.Stamp);
        if (iM9632a2 > 0) {
            this.f8961i.m8910a(true, iM9632a2);
        } else {
            this.f8961i.m8909a(false);
        }
        int iM9632a3 = C2642q.m9632a(EnumC1327e.Template);
        if (iM9632a3 > 0) {
            this.f8962j.m8910a(true, iM9632a3);
        } else {
            this.f8962j.m8909a(false);
        }
        int iM9592a = C2620df.m9592a();
        if (iM9592a > 0) {
            this.f8963k.m8910a(true, iM9592a);
        } else {
            this.f8963k.m8909a(false);
        }
        int iM9509a = C2570bj.m9509a();
        if (iM9509a > 0) {
            this.f8964l.m8910a(true, iM9509a);
        } else {
            this.f8964l.m8909a(false);
        }
        getListView().invalidateViews();
    }
}
