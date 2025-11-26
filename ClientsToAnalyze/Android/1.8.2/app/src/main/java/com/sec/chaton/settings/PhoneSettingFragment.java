package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PhoneSettingFragment extends PreferenceListFragment implements InterfaceC0221al {

    /* renamed from: a */
    private AboutNewNotice f4691a;

    /* renamed from: b */
    private SyncStatePreference f4692b;

    /* renamed from: c */
    private AboutNewNotice f4693c;

    /* renamed from: d */
    private AboutNewNotice f4694d;

    /* renamed from: e */
    private List f4695e;

    /* renamed from: f */
    private BroadcastReceiver f4696f = new C1294cs(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        this.f4695e = m4682e();
        m6124a(this.f4695e);
    }

    /* renamed from: e */
    private List m4682e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m4678a(R.string.tab_buddies, 0, null, new Intent(getActivity(), (Class<?>) ActivityBuddyView.class)));
        arrayList.add(m4678a(R.string.tab_chat, 0, null, new Intent(getActivity(), (Class<?>) ActivityChat.class)));
        arrayList.add(m4678a(R.string.setting_category_privacy, 0, null, new Intent(getActivity(), (Class<?>) ActivityPrivacy.class)));
        arrayList.add(m4678a(R.string.setting_body_notifications, 0, null, new Intent(getActivity(), (Class<?>) ActivityNoti.class)));
        this.f4693c = new AboutNewNotice(getActivity(), null);
        this.f4693c.setLayoutResource(R.layout.preference_with_arrow);
        this.f4693c.setTitle(R.string.settings_about);
        this.f4693c.setIntent(new Intent(getActivity(), (Class<?>) ActivityAbout.class));
        arrayList.add(this.f4693c);
        this.f4691a = new AboutNewNotice(getActivity(), null);
        this.f4691a.setLayoutResource(R.layout.preference_with_arrow);
        this.f4691a.setTitle(R.string.setting_category_general);
        this.f4691a.setIntent(new Intent(getActivity(), (Class<?>) ActivityGeneral.class));
        arrayList.add(this.f4691a);
        this.f4694d = new AboutNewNotice(getActivity(), null);
        this.f4694d.setLayoutResource(R.layout.preference);
        this.f4694d.setWidgetLayoutResource(R.layout.preference_widget_arrow);
        this.f4694d.setTitle(R.string.settings_title_downloads);
        this.f4694d.setIntent(new Intent(getActivity(), (Class<?>) ActivityDownload2.class));
        arrayList.add(this.f4694d);
        this.f4692b = new SyncStatePreference(getActivity(), null);
        this.f4692b.setLayoutResource(R.layout.preference);
        this.f4692b.setTitle(R.string.settings_sync_now);
        this.f4692b.setSummary(R.string.setting_sync_now_text);
        this.f4692b.setOnPreferenceChangeListener(new C1292cq(this));
        arrayList.add(this.f4692b);
        if (C1789u.m6075a().getInt(C1786r.f6456f, 0) > 0) {
            Preference preferenceM4678a = m4678a(R.string.settings_send_log, 0, null, null);
            preferenceM4678a.setOnPreferenceClickListener(new C1293cr(this));
            arrayList.add(preferenceM4678a);
        }
        return arrayList;
    }

    /* renamed from: a */
    private Preference m4678a(int i, int i2, String str, Intent intent) {
        Preference preference = new Preference(getActivity());
        preference.setLayoutResource(R.layout.preference_with_arrow);
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
        C1786r.m6063c("[LIFE] onStart Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6063c("[LIFE] onResume Memory Address:" + this, getClass().getSimpleName());
        this.f4692b.m4736a();
        m4683g();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f4696f, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause Memory Address:" + this, getClass().getSimpleName());
        this.f4692b.m4737b();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f4696f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4683g() {
        int i = C1789u.m6075a().getInt("notice", 0) > 0 ? C1789u.m6075a().getInt("notice", 0) + 0 : 0;
        this.f4691a.m4481a(false);
        if (C1789u.m6075a().contains("UpdateIsCritical")) {
            i = 1;
        }
        if (i > 0) {
            this.f4693c.m4482a(true, i);
        } else {
            this.f4693c.m4481a(false);
        }
        int iM4681d = m4681d() + C1003c.m3945c();
        if (iM4681d > 0) {
            this.f4694d.m4482a(true, iM4681d);
        } else {
            this.f4694d.m4481a(false);
        }
        getListView().invalidateViews();
    }

    /* renamed from: c */
    public static int m4680c() {
        int i = C1789u.m6075a().contains("UpdateIsCritical") ? 1 : 0;
        if (C1789u.m6075a().getInt("notice", 0) > 0) {
            i += C1789u.m6075a().getInt("notice", 0);
        }
        return i + C1003c.m3945c();
    }

    /* renamed from: d */
    public static int m4681d() {
        int iM3783a = C0921d.m3783a();
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            return iM3783a + 1;
        }
        return iM3783a;
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
    }

    /* renamed from: a */
    public static int m4677a(EnumC1296cu enumC1296cu) {
        int iM3783a = C0921d.m3783a();
        switch (C1295ct.f4846a[enumC1296cu.ordinal()]) {
            case 1:
                if (C1789u.m6075a().contains("UpdateIsCritical")) {
                    return 1;
                }
                break;
            case 2:
                if (C1789u.m6075a().getInt("notice", 0) > 0) {
                    return C1789u.m6075a().getInt("notice", 0) + 0;
                }
                break;
            case 3:
                if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
                    return iM3783a + 1;
                }
                return iM3783a;
        }
        return 0;
    }
}
