package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.PreferenceListFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PhoneSettingFragment extends PreferenceListFragment implements InterfaceC0726l {

    /* renamed from: a */
    private AboutNewNotice f3563a;

    /* renamed from: b */
    private SyncStatePreference f3564b;

    /* renamed from: c */
    private Preference f3565c;

    /* renamed from: d */
    private AboutNewNotice f3566d;

    /* renamed from: e */
    private List f3567e;

    /* renamed from: f */
    private BroadcastReceiver f3568f = new C1030ba(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate Memory Address:" + this, getClass().getSimpleName());
        this.f3567e = m3888e();
        m5872a(this.f3567e);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("[LIFE] onDestroy Memory Address:" + this, getClass().getSimpleName());
    }

    /* renamed from: e */
    private List m3888e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m3884a(R.string.tab_buddies, 0, null, new Intent(getActivity(), (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.tab_buddies)));
        arrayList.add(m3884a(R.string.tab_chat, 0, null, new Intent(getActivity(), (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.tab_chat)));
        arrayList.add(m3884a(R.string.setting_category_privacy, 0, null, new Intent(getActivity(), (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.setting_category_privacy)));
        arrayList.add(m3884a(R.string.setting_body_notifications, 0, null, new Intent(getActivity(), (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.setting_body_notifications)));
        this.f3563a = new AboutNewNotice(getActivity(), null);
        this.f3563a.setLayoutResource(R.layout.preference);
        this.f3563a.setWidgetLayoutResource(R.layout.preference_widget_arrow);
        this.f3563a.setTitle(R.string.setting_category_general);
        this.f3563a.setIntent(new Intent(getActivity(), (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.setting_category_general));
        arrayList.add(this.f3563a);
        this.f3564b = new SyncStatePreference(getActivity(), null);
        this.f3564b.setLayoutResource(R.layout.preference);
        this.f3564b.setTitle(R.string.settings_sync_now);
        this.f3564b.setSummary(R.string.setting_sync_now_text);
        this.f3564b.setOnPreferenceChangeListener(new C1015am(this));
        arrayList.add(this.f3564b);
        if (C1323bs.m4575a().getInt(C1341p.f4582f, 0) > 0) {
            Preference preferenceM3884a = m3884a(R.string.settings_send_log, 0, null, null);
            preferenceM3884a.setOnPreferenceClickListener(new C1028az(this));
            arrayList.add(preferenceM3884a);
        }
        return arrayList;
    }

    /* renamed from: a */
    private Preference m3884a(int i, int i2, String str, Intent intent) {
        Preference preference = new Preference(getActivity());
        preference.setLayoutResource(R.layout.preference);
        preference.setWidgetLayoutResource(R.layout.preference_widget_arrow);
        preference.setTitle(i);
        if (str != null) {
            preference.setKey(str);
        }
        if (i2 > 0) {
            preference.setSummary(i2);
        }
        if (intent != null) {
            preference.setIntent(intent);
        }
        return preference;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1341p.m4660c("[LIFE] onStart Memory Address:" + this, getClass().getSimpleName());
        if (C1323bs.m4575a().getBoolean("ChatONVDownloadalbe", false) && this.f3566d == null) {
            this.f3566d = new AboutNewNotice(getActivity(), null);
            this.f3566d.setLayoutResource(R.layout.preference);
            this.f3566d.setWidgetLayoutResource(R.layout.preference_widget_arrow);
            this.f3566d.setTitle(R.string.downloads);
            this.f3566d.m3779a(true);
            this.f3566d.setOnPreferenceClickListener(new C1027ay(this));
            this.f3567e.add(5, this.f3566d);
        }
        if (AbstractC0617h.m2831a(getActivity()) && this.f3565c == null) {
            this.f3565c = m3884a(R.string.menu_call, 0, null, null);
            this.f3565c.setOnPreferenceClickListener(new C1031bb(this));
            this.f3567e.add(5, this.f3565c);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume Memory Address:" + this, getClass().getSimpleName());
        this.f3564b.m3915a();
        m3889f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f3568f, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause Memory Address:" + this, getClass().getSimpleName());
        this.f3564b.m3916b();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f3568f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3889f() {
        if (m3886c()) {
            this.f3563a.m3779a(true);
        } else {
            this.f3563a.m3779a(false);
        }
        getListView().invalidateViews();
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: a */
    public void mo2192a() {
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: b */
    public void mo2200b() {
    }

    /* renamed from: c */
    public static boolean m3886c() {
        return C1323bs.m4575a().contains("UpdateIsCritical") || C1323bs.m4575a().getInt("notice", 0) > 0;
    }

    /* renamed from: d */
    public static boolean m3887d() {
        return C1323bs.m4575a().getBoolean("ChatONVDownloadalbe", false);
    }
}
