package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityDownload2 extends PreferenceListFragment {

    /* renamed from: c */
    AboutNewNotice f4473c;

    /* renamed from: d */
    AboutNewNotice f4474d;

    /* renamed from: e */
    PreferenceScreen f4475e;

    /* renamed from: f */
    private Context f4476f;

    /* renamed from: h */
    private AboutNewNotice f4478h;

    /* renamed from: i */
    private C1306dd f4479i;

    /* renamed from: a */
    String f4471a = "Settings";

    /* renamed from: g */
    private SharedPreferences f4477g = null;

    /* renamed from: b */
    SharedPreferences.Editor f4472b = null;

    /* renamed from: j */
    private BroadcastReceiver f4480j = new C1337p(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_downloads);
        this.f4476f = getActivity();
        this.f4477g = C1789u.m6075a();
        this.f4472b = this.f4477g.edit();
        this.f4479i = new C1306dd(this.f4477g);
        this.f4472b.putBoolean("Lock Check", false);
        try {
            m4497a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m4497a() {
        this.f4475e = (PreferenceScreen) m6121a("pref_screen");
        this.f4473c = (AboutNewNotice) m6121a("pref_item_downloads_chaton_v");
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            this.f4473c.setOnPreferenceClickListener(new C1334m(this));
        } else {
            ((PreferenceCategory) m6121a("settings_title_more_apps")).removePreference(this.f4473c);
            this.f4475e.removePreference((PreferenceCategory) m6121a("settings_title_more_apps"));
        }
        this.f4474d = (AboutNewNotice) m6121a("pref_item_downloads_ticcon");
        this.f4474d.setOnPreferenceClickListener(new C1335n(this));
        this.f4478h = (AboutNewNotice) m6121a("pref_item_downloads_theme");
        this.f4478h.setOnPreferenceClickListener(new C1336o(this));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f4480j);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4498b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f4480j, intentFilter);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4498b() {
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            this.f4473c.m4481a(true);
        } else {
            this.f4473c.m4481a(false);
        }
        int iM3783a = C0921d.m3783a();
        if (iM3783a > 0) {
            this.f4474d.m4482a(true, iM3783a);
        } else {
            this.f4474d.m4481a(false);
        }
        int iM3945c = C1003c.m3945c();
        if (iM3945c > 0) {
            this.f4478h.m4482a(true, iM3945c);
        } else {
            this.f4478h.m4481a(false);
        }
        getListView().invalidateViews();
    }
}
