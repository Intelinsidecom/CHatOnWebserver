package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityGeneral extends PreferenceListFragment {

    /* renamed from: c */
    AboutNewNotice f4489c;

    /* renamed from: d */
    private Context f4490d;

    /* renamed from: f */
    private C1306dd f4492f;

    /* renamed from: a */
    String f4487a = "Settings";

    /* renamed from: e */
    private SharedPreferences f4491e = null;

    /* renamed from: b */
    SharedPreferences.Editor f4488b = null;

    /* renamed from: g */
    private BroadcastReceiver f4493g = new C1480w(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_general);
        this.f4490d = getActivity();
        this.f4491e = C1789u.m6075a();
        this.f4488b = this.f4491e.edit();
        this.f4492f = new C1306dd(this.f4491e);
        this.f4488b.putBoolean("Lock Check", false);
        try {
            m4502a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m4502a() {
        this.f4489c = (AboutNewNotice) m6121a("pref_item_noti");
        this.f4489c.setOnPreferenceClickListener(new C1340s(this));
        m6121a("pref_item_help").setOnPreferenceClickListener(new C1341t(this));
        m6121a("pref_item_delete").setOnPreferenceClickListener(new C1478u(this));
        m6121a("pref_item_VOC").setOnPreferenceClickListener(new C1479v(this));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f4493g);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4504b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f4493g, intentFilter);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4504b() {
        C1786r.m6063c("#NOTCIE : " + C1789u.m6075a().getInt("notice", 0) + " Update contain is " + C1789u.m6075a().contains("UpdateIsCritical"), getClass().getSimpleName());
        if (C1789u.m6075a().getInt("notice", 0) > 0) {
            this.f4489c.m4482a(true, C1789u.m6075a().getInt("notice", 0));
        } else {
            this.f4489c.m4481a(false);
        }
    }
}
