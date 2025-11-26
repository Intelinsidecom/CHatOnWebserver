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
import android.preference.PreferenceFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.block.BlockActivity;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1335j;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.ca */
/* loaded from: classes.dex */
public class C1057ca extends PreferenceFragment {

    /* renamed from: a */
    public static Preference f3678a;

    /* renamed from: b */
    public static Preference f3679b;

    /* renamed from: g */
    private static String[] f3680g;

    /* renamed from: h */
    private static String[] f3681h;

    /* renamed from: i */
    private static SharedPreferences f3682i = null;

    /* renamed from: j */
    private static SharedPreferences.Editor f3683j = null;

    /* renamed from: l */
    private static int f3684l;

    /* renamed from: m */
    private static Context f3685m;

    /* renamed from: f */
    private int f3689f;

    /* renamed from: n */
    private String f3691n;

    /* renamed from: o */
    private String f3692o;

    /* renamed from: p */
    private C0224w f3693p;

    /* renamed from: q */
    private ProgressDialog f3694q;

    /* renamed from: s */
    private SyncStatePreference f3696s;

    /* renamed from: t */
    private FrameLayout f3697t;

    /* renamed from: c */
    private Map f3686c = new HashMap();

    /* renamed from: d */
    private Map f3687d = new HashMap();

    /* renamed from: e */
    private C1073e f3688e = new C1073e(this, null);

    /* renamed from: k */
    private boolean f3690k = true;

    /* renamed from: r */
    private ArrayList f3695r = new ArrayList();

    /* renamed from: u */
    private Handler f3698u = new HandlerC1065ci(this);

    /* renamed from: c */
    static /* synthetic */ int m3940c(C1057ca c1057ca) {
        int i = c1057ca.f3689f + 1;
        c1057ca.f3689f = i;
        return i;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f3685m = getActivity();
        f3682i = C1323bs.m4575a();
        f3683j = f3682i.edit();
        addPreferencesFromResource(R.xml.preference_setting_tab);
        f3684l = getResources().getColor(R.color.blue_color_021);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f3696s.m3915a();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.f3696s.m3916b();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f3680g = getActivity().getResources().getStringArray(R.array.settings_type_options_value);
        f3681h = getActivity().getResources().getStringArray(R.array.settings_type_options);
        getActivity().getActionBar().setTitle("Setting");
        m3949a();
        ((ListView) ((LinearLayout) getView()).getChildAt(0)).setPadding(0, 0, 0, 0);
        this.f3697t = (FrameLayout) getActivity().findViewById(R.id.fragment_container);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3697t.getLayoutParams();
        marginLayoutParams.setMargins(14, 14, 14, 0);
        this.f3697t.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    public static void m3933a(Context context) {
        C1335j.m4617a(context, context.getString(R.string.settings_invite_friend), context.getString(R.string.setting_chaton_tell_friends_email_text, "www.chaton.com/invite.html"), null);
    }

    /* renamed from: a */
    public void m3949a() {
        Uri defaultUri;
        this.f3686c.put("pref_item_change_skins", ActivitySkinChange.class);
        this.f3686c.put("pref_item_font_size", ActivityChatView.class);
        this.f3686c.put("pref_item_about", ActivityAbout.class);
        this.f3686c.put("pref_item_help", ActivityWebView.class);
        this.f3686c.put("pref_item_blocked", BlockActivity.class);
        this.f3686c.put("pref_item_delete", ActivityDeleteAccount.class);
        this.f3686c.put("pref_item_hide", RelationHideActivity.class);
        this.f3686c.put("pref_item_type", ActivityAlertType.class);
        this.f3686c.put("pref_item_ringtone", ActivityRingTone.class);
        this.f3686c.put("pref_item_sync_now", ActivityAbout.class);
        AboutNewNotice aboutNewNotice = (AboutNewNotice) findPreference("pref_item_about");
        aboutNewNotice.setOnPreferenceClickListener(this.f3688e);
        if (C1323bs.m4575a().contains("UpdateIsCritical")) {
            aboutNewNotice.m3779a(true);
        } else {
            aboutNewNotice.m3779a(false);
        }
        Preference preferenceFindPreference = findPreference("pref_item_help");
        preferenceFindPreference.setOnPreferenceClickListener(this.f3688e);
        findPreference("pref_item_invite_friend").setOnPreferenceClickListener(new C1069cm(this));
        Preference preferenceFindPreference2 = findPreference("pref_item_blocked");
        preferenceFindPreference2.setOnPreferenceClickListener(this.f3688e);
        Preference preferenceFindPreference3 = findPreference("pref_item_delete");
        preferenceFindPreference3.setOnPreferenceClickListener(this.f3688e);
        Preference preferenceFindPreference4 = findPreference("pref_item_hide");
        preferenceFindPreference4.setOnPreferenceClickListener(this.f3688e);
        Preference preferenceFindPreference5 = findPreference("pref_item_change_skins");
        preferenceFindPreference5.setOnPreferenceClickListener(this.f3688e);
        Preference preferenceFindPreference6 = findPreference("pref_item_font_size");
        preferenceFindPreference6.setOnPreferenceClickListener(this.f3688e);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_birthday");
        checkBoxPreference.setChecked(C1323bs.m4575a().getBoolean("Profile Birth Chk", true));
        checkBoxPreference.setOnPreferenceChangeListener(new C1067ck(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (f3682i.getBoolean("Setting Notification", true)) {
            this.f3690k = true;
            f3683j.putBoolean("Setting Notification", true).commit();
        } else {
            this.f3690k = false;
            f3683j.putBoolean("Setting Notification", false).commit();
        }
        checkBoxPreference2.setChecked(this.f3690k);
        checkBoxPreference2.setOnPreferenceChangeListener(new C1068cl(this));
        f3678a = findPreference("pref_item_type");
        f3678a.setOnPreferenceClickListener(this.f3688e);
        this.f3691n = f3682i.getString("Set Type Text", "");
        int i = 0;
        while (true) {
            if (i >= f3680g.length) {
                break;
            }
            if (!this.f3691n.equals(f3680g[i])) {
                i++;
            } else {
                this.f3691n = f3681h[i];
                break;
            }
        }
        f3678a.setSummary(this.f3691n);
        m3942c(this.f3691n, f3678a, getResources().getColor(R.color.blue_color_021));
        f3679b = findPreference("pref_item_ringtone");
        f3679b.setOnPreferenceClickListener(this.f3688e);
        String string = f3682i.getString("Ringtone", null);
        if (string != null) {
            defaultUri = !"Silent".equals(string) ? Uri.parse(string) : null;
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri == null || RingtoneManager.getActualDefaultRingtoneUri(f3685m, 2) == null) {
            this.f3692o = "Silent";
        } else {
            this.f3692o = RingtoneManager.getRingtone(f3685m, defaultUri).getTitle(f3685m);
        }
        f3679b.setSummary(this.f3692o);
        m3942c(this.f3692o, f3679b, getResources().getColor(R.color.blue_color_021));
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("pref_item_received_message");
        checkBoxPreference3.setChecked(C1323bs.m4575a().getBoolean("Setting show receive message", true));
        m3942c(getResources().getString(R.string.settings_received_message_summary), checkBoxPreference3, getResources().getColor(R.color.blue_color_021));
        checkBoxPreference3.setOnPreferenceChangeListener(new C1064ch(this));
        Preference preferenceFindPreference7 = findPreference("pref_item_type");
        preferenceFindPreference7.setOnPreferenceClickListener(this.f3688e);
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) findPreference("pref_item_blackscreen_popup");
        checkBoxPreference4.setChecked(C1323bs.m4575a().getBoolean("Setting show blackscreen popup", true));
        m3942c(getResources().getString(R.string.settings_popup_information), checkBoxPreference4, getResources().getColor(R.color.blue_color_021));
        checkBoxPreference4.setOnPreferenceChangeListener(new C1063cg(this));
        Preference preferenceFindPreference8 = findPreference("pref_item_send_log");
        if (C1323bs.m4575a().getInt(C1341p.f4582f, 0) > 0) {
            preferenceFindPreference8.setOnPreferenceClickListener(new C1062cf(this));
        } else {
            ((PreferenceCategory) findPreference("settings_category_backup_sync")).removePreference(preferenceFindPreference8);
        }
        this.f3696s = (SyncStatePreference) findPreference("pref_item_sync_now");
        m3942c(getResources().getString(R.string.setting_sync_now_text), this.f3696s, getResources().getColor(R.color.blue_color_021));
        C0192ae.m739a().mo744c(new HandlerC1061ce(this, Looper.getMainLooper()));
        Preference preferenceFindPreference9 = findPreference("pref_item_buddies_say");
        preferenceFindPreference9.setOnPreferenceClickListener(new C1066cj(this));
        this.f3687d.put("pref_item_change_skins", preferenceFindPreference5);
        this.f3687d.put("pref_item_font_size", preferenceFindPreference6);
        this.f3687d.put("pref_item_about", aboutNewNotice);
        this.f3687d.put("pref_item_help", preferenceFindPreference);
        this.f3687d.put("pref_item_blocked", preferenceFindPreference2);
        this.f3687d.put("pref_item_delete", preferenceFindPreference3);
        this.f3687d.put("pref_item_type", preferenceFindPreference7);
        this.f3687d.put("pref_item_ringtone", f3679b);
        this.f3687d.put("pref_item_buddies_say", preferenceFindPreference9);
        this.f3687d.put("pref_item_hide", preferenceFindPreference4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m3942c(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: a */
    public void m3950a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: a */
    public static void m3934a(String str) {
        if (str.equals(f3680g[0])) {
            f3678a.setSummary(str);
            m3942c(f3681h[0], f3678a, f3684l);
            return;
        }
        if (str.equals(f3680g[1])) {
            f3678a.setSummary(str);
            m3942c(f3681h[1], f3678a, f3684l);
        } else if (str.equals(f3680g[2])) {
            f3678a.setSummary(str);
            m3942c(f3681h[2], f3678a, f3684l);
        } else if (str.equals(f3680g[3])) {
            f3678a.setSummary(str);
            m3942c(f3681h[3], f3678a, f3684l);
        }
    }

    /* renamed from: b */
    public static void m3938b(String str) {
        m3942c(str, f3679b, f3684l);
    }
}
