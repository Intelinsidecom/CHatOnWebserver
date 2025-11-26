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
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;

/* loaded from: classes.dex */
public class ActivitySettings extends PreferenceActivity implements InterfaceC3226cn {

    /* renamed from: b */
    AboutNewNotice f9093b;

    /* renamed from: c */
    SyncStatePreference f9094c;

    /* renamed from: d */
    PreferenceScreen f9095d;

    /* renamed from: e */
    private Context f9096e;

    /* renamed from: g */
    private ProgressDialog f9098g;

    /* renamed from: a */
    String f9092a = "Settings";

    /* renamed from: f */
    private C3160ab f9097f = null;

    /* renamed from: h */
    private ProgressDialog f9099h = null;

    /* renamed from: i */
    private boolean f9100i = false;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT >= 11) {
            LinearLayout linearLayout = (LinearLayout) getListView().getParent();
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).setMargins(0, 0, 0, 0);
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.main_background_color));
        }
        addPreferencesFromResource(R.xml.pref_setting_headers);
        this.f9096e = this;
        this.f9097f = C3159aa.m10962a();
        this.f9097f.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m9069a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m9069a() {
        this.f9095d = (PreferenceScreen) findPreference("pref_screen");
        findPreference("pref_item_Buddies").setOnPreferenceClickListener(new C2468cb(this));
        findPreference("pref_item_Chats").setOnPreferenceClickListener(new C2469cc(this));
        findPreference("pref_item_Privacy").setOnPreferenceClickListener(new C2470cd(this));
        findPreference("pref_item_Noti").setOnPreferenceClickListener(new C2471ce(this));
        this.f9093b = (AboutNewNotice) findPreference("pref_item_General");
        this.f9093b.setOnPreferenceClickListener(new C2472cf(this));
        findPreference("pref_item_Downloads").setOnPreferenceClickListener(new C2473cg(this));
        C3250y.m11450b("# notice in setting : " + C3159aa.m10962a().m10978a("notice", (Integer) 0), "ChatON");
        if (C3159aa.m10962a().m10987b("UpdateIsCritical") || C3159aa.m10962a().m10978a("notice", (Integer) 0).intValue() > 0) {
            this.f9093b.m8910a(true, (C3159aa.m10962a().m10987b("UpdateIsCritical") ? 1 : 0) + C3159aa.m10962a().m10978a("notice", (Integer) 0).intValue());
        } else {
            this.f9093b.m8909a(false);
        }
        Preference preferenceFindPreference = findPreference("pref_item_send_log");
        if (C3159aa.m10962a().m10978a(C3250y.f11739g, (Integer) 0).intValue() > 0) {
            preferenceFindPreference.setOnPreferenceClickListener(new C2474ch(this));
        } else {
            this.f9095d.removePreference(preferenceFindPreference);
        }
        this.f9094c = (SyncStatePreference) findPreference("pref_item_sync_now");
        m9070a(getResources().getString(R.string.setting_sync_now_text), this.f9094c, getResources().getColor(R.color.buddy_list_item_status));
        this.f9094c.setOnPreferenceClickListener(new C2476cj(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m9070a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f9094c.m9212b();
        if (this.f9098g != null) {
            this.f9098g.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f9094c.m9211a();
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f9100i = true;
        if (this.f9099h != null && this.f9099h.isShowing()) {
            this.f9099h.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black_Setting;
    }
}
