package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4876cn;

/* loaded from: classes.dex */
public class ActivitySettings extends PreferenceActivity implements InterfaceC4876cn {

    /* renamed from: b */
    AboutNewNotice f12653b;

    /* renamed from: c */
    SyncStatePreference f12654c;

    /* renamed from: d */
    PreferenceScreen f12655d;

    /* renamed from: e */
    private Context f12656e;

    /* renamed from: g */
    private ProgressDialog f12658g;

    /* renamed from: a */
    String f12652a = "Settings";

    /* renamed from: f */
    private C4810ab f12657f = null;

    /* renamed from: h */
    private ProgressDialog f12659h = null;

    /* renamed from: i */
    private boolean f12660i = false;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            LinearLayout linearLayout = (LinearLayout) getListView().getParent();
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).setMargins(0, 0, 0, 0);
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.main_background_color));
        }
        addPreferencesFromResource(R.xml.pref_setting_headers);
        this.f12656e = this;
        this.f12657f = C4809aa.m18104a();
        this.f12657f.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m13538a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m13538a() {
        this.f12655d = (PreferenceScreen) findPreference("pref_screen");
        findPreference("pref_item_Buddies").setOnPreferenceClickListener(new C3564da(this));
        findPreference("pref_item_Chats").setOnPreferenceClickListener(new C3565db(this));
        findPreference("pref_item_Privacy").setOnPreferenceClickListener(new C3566dc(this));
        findPreference("pref_item_Noti").setOnPreferenceClickListener(new C3567dd(this));
        this.f12653b = (AboutNewNotice) findPreference("pref_item_General");
        this.f12653b.setOnPreferenceClickListener(new C3568de(this));
        C4904y.m18639b("# notice in setting : " + C4809aa.m18104a().m18120a("notice", (Integer) 0), "ChatON");
        if (C4809aa.m18104a().m18129b("UpdateIsCritical") || C4809aa.m18104a().m18120a("notice", (Integer) 0).intValue() > 0) {
            this.f12653b.m13296a(true, (C4809aa.m18104a().m18129b("UpdateIsCritical") ? 1 : 0) + C4809aa.m18104a().m18120a("notice", (Integer) 0).intValue());
        } else {
            this.f12653b.m13295a(false);
        }
        Preference preferenceFindPreference = findPreference("pref_item_send_log");
        if (C4904y.m18630a() > 0) {
            preferenceFindPreference.setOnPreferenceClickListener(new C3569df(this));
        } else {
            this.f12655d.removePreference(preferenceFindPreference);
        }
        this.f12654c = (SyncStatePreference) findPreference("pref_item_sync_now");
        m13539a(getResources().getString(R.string.setting_sync_now_text), this.f12654c, getResources().getColor(R.color.buddy_list_item_status));
        this.f12654c.setOnPreferenceClickListener(new C3571dh(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m13539a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12654c.m13698b();
        if (this.f12658g != null) {
            this.f12658g.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12654c.m13697a();
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12660i = true;
        if (this.f12659h != null && this.f12659h.isShowing()) {
            this.f12659h.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_Setting;
    }
}
