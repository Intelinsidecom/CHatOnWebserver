package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.util.C1766bv;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SettingFragment extends PreferenceListFragment implements InterfaceC0221al {

    /* renamed from: a */
    public static Preference f4723a;

    /* renamed from: b */
    public static Preference f4724b;

    /* renamed from: f */
    private static String[] f4725f;

    /* renamed from: g */
    private static String[] f4726g;

    /* renamed from: h */
    private static SharedPreferences f4727h = null;

    /* renamed from: i */
    private static SharedPreferences.Editor f4728i = null;

    /* renamed from: k */
    private static int f4729k;

    /* renamed from: l */
    private static Context f4730l;

    /* renamed from: m */
    private String f4735m;

    /* renamed from: n */
    private String f4736n;

    /* renamed from: o */
    private C0638j f4737o;

    /* renamed from: p */
    private ProgressDialog f4738p;

    /* renamed from: r */
    private SyncStatePreference f4740r;

    /* renamed from: s */
    private FrameLayout f4741s;

    /* renamed from: c */
    private Map f4731c = new HashMap();

    /* renamed from: d */
    private Map f4732d = new HashMap();

    /* renamed from: e */
    private C1317do f4733e = new C1317do(this, null);

    /* renamed from: j */
    private boolean f4734j = true;

    /* renamed from: q */
    private ArrayList f4739q = new ArrayList();

    /* renamed from: t */
    private Handler f4742t = new HandlerC1316dn(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        f4730l = getActivity();
        f4727h = C1789u.m6075a();
        f4728i = f4727h.edit();
        m6122a(R.xml.preference_setting_tab);
        f4729k = getResources().getColor(R.color.ics_orange_font_color);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4740r.m4736a();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f4740r.m4737b();
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f4725f = getActivity().getResources().getStringArray(R.array.settings_type_options_value);
        f4726g = getActivity().getResources().getStringArray(R.array.settings_type_options);
        getActivity().getActionBar().setTitle(R.string.setting_settings_title);
        m4715c();
        this.f4741s = (FrameLayout) getActivity().findViewById(R.id.fragment_container);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4741s.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, 0, 0);
        this.f4741s.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    public static void m4701a(Context context) {
        C1766bv.m5998a(context, context.getString(R.string.settings_invite_friend), context.getString(R.string.tellfriends_post_message), null);
    }

    /* renamed from: c */
    public void m4715c() {
        Uri defaultUri;
        this.f4731c.put("pref_item_change_background", new FragmentSkinChange2());
        this.f4731c.put("pref_item_change_bubble", new FragmentSkinChange2());
        this.f4731c.put("pref_item_font_size", new FragmentChatView());
        this.f4731c.put("pref_item_about", new AboutFragment());
        this.f4731c.put("pref_item_help", new FragmentWebView());
        this.f4731c.put("pref_item_blocked", new FragmentWebView());
        this.f4731c.put("pref_item_delete", new FragmentDeleteAccount());
        this.f4731c.put("pref_item_hide", new RelationHideFragment());
        this.f4731c.put("pref_item_type", new FragmentAlertTypeView2());
        this.f4731c.put("pref_item_ringtone", new FragmentRingToneView());
        this.f4731c.put("pref_item_sync_now", new AboutFragment());
        AboutNewNotice aboutNewNotice = (AboutNewNotice) m6121a("pref_item_about");
        aboutNewNotice.setOnPreferenceClickListener(this.f4733e);
        if (C1789u.m6075a().contains("UpdateIsCritical")) {
            aboutNewNotice.m4481a(true);
        } else {
            aboutNewNotice.m4481a(false);
        }
        Preference preferenceA = m6121a("pref_item_help");
        preferenceA.setOnPreferenceClickListener(this.f4733e);
        m6121a("pref_item_invite_friend").setOnPreferenceClickListener(new C1308df(this));
        Preference preferenceA2 = m6121a("pref_item_blocked");
        preferenceA2.setOnPreferenceClickListener(this.f4733e);
        Preference preferenceA3 = m6121a("pref_item_delete");
        preferenceA3.setOnPreferenceClickListener(this.f4733e);
        Preference preferenceA4 = m6121a("pref_item_hide");
        preferenceA4.setOnPreferenceClickListener(this.f4733e);
        Preference preferenceA5 = m6121a("pref_item_change_background");
        preferenceA5.setOnPreferenceClickListener(this.f4733e);
        Preference preferenceA6 = m6121a("pref_item_change_bubble");
        preferenceA6.setOnPreferenceClickListener(this.f4733e);
        Preference preferenceA7 = m6121a("pref_item_font_size");
        preferenceA7.setOnPreferenceClickListener(this.f4733e);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) m6121a("pref_item_birthday");
        checkBoxPreference.setChecked(C1789u.m6075a().getBoolean("Profile Birth Chk", true));
        checkBoxPreference.setOnPreferenceChangeListener(new C1309dg(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) m6121a("pref_item_push_notification");
        if (f4727h.getBoolean("Setting Notification", true)) {
            this.f4734j = true;
            f4728i.putBoolean("Setting Notification", true).commit();
        } else {
            this.f4734j = false;
            f4728i.putBoolean("Setting Notification", false).commit();
        }
        checkBoxPreference2.setChecked(this.f4734j);
        checkBoxPreference2.setOnPreferenceChangeListener(new C1310dh(this));
        f4723a = m6121a("pref_item_type");
        f4723a.setOnPreferenceClickListener(this.f4733e);
        this.f4735m = f4727h.getString("Set Type Text", f4725f[0]);
        int i = 0;
        while (true) {
            if (i >= f4725f.length) {
                break;
            }
            if (!this.f4735m.equals(f4725f[i])) {
                i++;
            } else {
                this.f4735m = f4726g[i];
                break;
            }
        }
        f4723a.setSummary(this.f4735m);
        m4708c(this.f4735m, f4723a, getResources().getColor(R.color.ics_orange_font_color));
        f4724b = m6121a("pref_item_ringtone");
        f4724b.setOnPreferenceClickListener(this.f4733e);
        String string = f4727h.getString("Ringtone", null);
        if (string != null) {
            if (!"Silent".equals(string)) {
                defaultUri = Uri.parse(string);
            } else {
                defaultUri = null;
            }
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri == null || RingtoneManager.getActualDefaultRingtoneUri(f4730l, 2) == null) {
            this.f4736n = "Silent";
        } else {
            this.f4736n = RingtoneManager.getRingtone(f4730l, defaultUri).getTitle(f4730l);
        }
        f4724b.setSummary(this.f4736n);
        m4708c(this.f4736n, f4724b, getResources().getColor(R.color.ics_orange_font_color));
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) m6121a("pref_item_received_message");
        checkBoxPreference3.setChecked(C1789u.m6075a().getBoolean("Setting show receive message", true));
        m4708c(getResources().getString(R.string.settings_received_message_summary), checkBoxPreference3, getResources().getColor(R.color.ics_orange_font_color));
        checkBoxPreference3.setOnPreferenceChangeListener(new C1311di(this));
        Preference preferenceA8 = m6121a("pref_item_type");
        preferenceA8.setOnPreferenceClickListener(this.f4733e);
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) m6121a("pref_item_blackscreen_popup");
        checkBoxPreference4.setChecked(C1789u.m6075a().getBoolean("Setting show blackscreen popup", true));
        m4708c(getResources().getString(R.string.settings_popup_information), checkBoxPreference4, getResources().getColor(R.color.ics_orange_font_color));
        checkBoxPreference4.setOnPreferenceChangeListener(new C1312dj(this));
        Preference preferenceA9 = m6121a("pref_item_send_log");
        m6125f().removePreference(preferenceA9);
        if (C1789u.m6075a().getInt(C1786r.f6456f, 0) > 0) {
            preferenceA9.setOnPreferenceClickListener(new C1313dk(this));
        } else {
            ((PreferenceCategory) m6121a("settings_category_backup_sync")).removePreference(preferenceA9);
        }
        this.f4740r = (SyncStatePreference) m6121a("pref_item_sync_now");
        m4708c(getResources().getString(R.string.setting_sync_now_text), this.f4740r, getResources().getColor(R.color.ics_orange_font_color));
        C0620aj.m2804a().mo2705c(new HandlerC1314dl(this, Looper.getMainLooper()));
        Preference preferenceA10 = m6121a("pref_item_buddies_say");
        preferenceA10.setOnPreferenceClickListener(new C1315dm(this));
        this.f4732d.put("pref_item_change_background", preferenceA5);
        this.f4732d.put("pref_item_change_bubble", preferenceA6);
        this.f4732d.put("pref_item_font_size", preferenceA7);
        this.f4732d.put("pref_item_about", aboutNewNotice);
        this.f4732d.put("pref_item_help", preferenceA);
        this.f4732d.put("pref_item_blocked", preferenceA2);
        this.f4732d.put("pref_item_delete", preferenceA3);
        this.f4732d.put("pref_item_type", preferenceA8);
        this.f4732d.put("pref_item_ringtone", f4724b);
        this.f4732d.put("pref_item_buddies_say", preferenceA10);
        this.f4732d.put("pref_item_hide", preferenceA4);
        if (!this.f4734j) {
            m4708c(f4723a.getSummary().toString(), f4723a, getResources().getColor(R.color.gray));
            f4723a.setEnabled(false);
            m4708c(f4724b.getSummary().toString(), f4724b, getResources().getColor(R.color.gray));
            f4724b.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m4708c(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: a */
    public void m4714a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: a */
    public static void m4702a(String str) {
        if (str.equals(f4725f[0])) {
            f4723a.setSummary(str);
            m4708c(f4726g[0], f4723a, f4729k);
            return;
        }
        if (str.equals(f4725f[1])) {
            f4723a.setSummary(str);
            m4708c(f4726g[1], f4723a, f4729k);
        } else if (str.equals(f4725f[2])) {
            f4723a.setSummary(str);
            m4708c(f4726g[2], f4723a, f4729k);
        } else if (str.equals(f4725f[3])) {
            f4723a.setSummary(str);
            m4708c(f4726g[3], f4723a, f4729k);
        }
    }

    /* renamed from: b */
    public static void m4705b(String str) {
        m4708c(str, f4724b, f4729k);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        C1786r.m6061b("onTabSelected...", getClass().getSimpleName());
        BaseActivity.m1827a(this, true);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentSkinChange2(), "container").commit();
        getActivity().findViewById(R.id.base_divider).setVisibility(0);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        C1786r.m6061b("onTabUnSelected...", getClass().getSimpleName());
        BaseActivity.m1827a(this, false);
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_settings);
        if (fragmentFindFragmentById instanceof MsgboxFragment) {
            ((MsgboxFragment) fragmentFindFragmentById).m3533a("");
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }
}
