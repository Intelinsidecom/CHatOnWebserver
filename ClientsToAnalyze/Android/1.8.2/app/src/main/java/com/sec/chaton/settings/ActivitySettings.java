package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivitySettings extends PreferenceListFragment implements InterfaceC0221al {

    /* renamed from: g */
    public static String f4559g = "Settings";

    /* renamed from: c */
    AboutNewNotice f4562c;

    /* renamed from: d */
    AboutNewNotice f4563d;

    /* renamed from: e */
    Preference f4564e;

    /* renamed from: f */
    PreferenceScreen f4565f;

    /* renamed from: h */
    private Context f4566h;

    /* renamed from: j */
    private C1306dd f4568j;

    /* renamed from: k */
    private ProgressDialog f4569k;

    /* renamed from: a */
    String f4560a = "Settings";

    /* renamed from: i */
    private SharedPreferences f4567i = null;

    /* renamed from: b */
    SharedPreferences.Editor f4561b = null;

    /* renamed from: l */
    private Preference f4570l = null;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.preference_setting2);
        this.f4566h = getActivity();
        this.f4567i = C1789u.m6075a();
        this.f4561b = this.f4567i.edit();
        this.f4568j = new C1306dd(this.f4567i);
        this.f4561b.putBoolean("Lock Check", false);
        try {
            m4564g();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m4567a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: g */
    private void m4564g() {
        this.f4565f = (PreferenceScreen) m6121a("pref_screen");
        this.f4562c = (AboutNewNotice) m6121a("pref_item_about");
        if (this.f4570l == null) {
            m4567a(this.f4562c.getTitle().toString(), this.f4562c, getResources().getColor(R.color.ics_orange_font_color));
            this.f4562c.setLayoutResource(R.layout.preference_clicked);
            this.f4570l = this.f4562c;
        }
        this.f4562c.setOnPreferenceClickListener(new C1240as(this));
        if (m4561c() > 0) {
            this.f4562c.m4482a(true, m4561c());
        } else {
            this.f4562c.m4481a(false);
        }
        m6121a("pref_item_Buddies").setOnPreferenceClickListener(new C1242au(this));
        m6121a("pref_item_Chats").setOnPreferenceClickListener(new C1243av(this));
        m6121a("pref_item_Privacy").setOnPreferenceClickListener(new C1244aw(this));
        m6121a("pref_item_Noti").setOnPreferenceClickListener(new C1245ax(this));
        this.f4563d = (AboutNewNotice) m6121a("pref_item_General");
        this.f4563d.setOnPreferenceClickListener(new C1246ay(this));
        if (m4562d() > 0) {
            this.f4563d.m4482a(true, m4562d());
        } else {
            this.f4563d.m4481a(false);
        }
        AboutNewNotice aboutNewNotice = (AboutNewNotice) m6121a("pref_item_Downloads");
        aboutNewNotice.setOnPreferenceClickListener(new C1247az(this));
        if (m4563e() > 0) {
            aboutNewNotice.m4482a(true, m4563e());
        } else {
            aboutNewNotice.m4481a(false);
        }
        Preference preferenceA = m6121a("pref_item_Call");
        if (!AbstractC0521a.m2697a(getActivity())) {
            this.f4565f.removePreference(preferenceA);
        } else {
            preferenceA.setOnPreferenceClickListener(new C1249ba(this));
        }
        Preference preferenceA2 = m6121a("pref_item_send_log");
        m6125f().removePreference(preferenceA2);
        if (C1789u.m6075a().getInt(C1786r.f6456f, 0) > 0) {
            preferenceA2.setOnPreferenceClickListener(new C1250bb(this));
        } else {
            this.f4565f.removePreference(preferenceA2);
        }
        this.f4564e = m6121a("pref_item_sync");
        this.f4564e.setOnPreferenceClickListener(new C1241at(this));
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setDivider(this.f4566h.getResources().getDrawable(R.drawable.list_divider_h));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f4569k != null) {
            this.f4569k.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        m4565h();
    }

    /* renamed from: h */
    private void m4565h() {
        if (this.f4570l != null) {
            String key = this.f4570l.getKey();
            if (key.equals("pref_item_Chats")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityChat(), "container").commit();
                return;
            }
            if (key.equals("pref_item_Privacy")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityPrivacy(), "container").commit();
                return;
            }
            if (key.equals("pref_item_Noti")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityNoti(), "container").commit();
                return;
            }
            if (key.equals("pref_item_General")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityGeneral(), "container").commit();
                return;
            }
            if (key.equals("pref_item_Downloads")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityDownload2(), "container").commit();
                return;
            }
            if (key.equals("pref_item_sync")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SyncNowFragment(), "container").commit();
                return;
            } else if (key.equals("pref_item_Buddies")) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityBuddyView(), "container").commit();
                return;
            } else {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment(), "container").commit();
                return;
            }
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment(), "container").commit();
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        m4566i();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }

    /* renamed from: c */
    public static int m4561c() {
        if (!C1789u.m6075a().contains("UpdateIsCritical")) {
            return 0;
        }
        return 1;
    }

    /* renamed from: d */
    public static int m4562d() {
        if (C1789u.m6075a().getInt("notice", 0) > 0) {
            return C1789u.m6075a().getInt("notice", 0);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m4563e() {
        int iM3783a = C0921d.m3783a();
        if (C1789u.m6075a().getBoolean("ChatONVDownloadalbe", false)) {
            return iM3783a + 1;
        }
        return iM3783a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4566i() {
        FragmentManager fragmentManager = getFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount() && fragmentManager.getBackStackEntryAt(i).getName().equals(f4559g); i++) {
            fragmentManager.popBackStack(f4559g, 1);
        }
    }
}
