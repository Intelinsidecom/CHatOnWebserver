package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.RingtonePreference;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.MemoControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ShareUtil;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ActivitySettings extends PreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: c */
    AboutNewNotice f2996c;

    /* renamed from: d */
    SyncStatePreference f2997d;

    /* renamed from: e */
    AlarmManager f2998e;

    /* renamed from: f */
    private Context f2999f;

    /* renamed from: j */
    private SettingBean f3003j;

    /* renamed from: l */
    private int f3005l;

    /* renamed from: m */
    private String[] f3006m;

    /* renamed from: n */
    private String[] f3007n;

    /* renamed from: o */
    private ListPreference f3008o;

    /* renamed from: p */
    private String f3009p;

    /* renamed from: q */
    private RingtonePreference f3010q;

    /* renamed from: r */
    private String f3011r;

    /* renamed from: s */
    private MemoControl f3012s;

    /* renamed from: v */
    private ProgressDialog f3015v;

    /* renamed from: a */
    String f2994a = "Settings";

    /* renamed from: g */
    private boolean f3000g = true;

    /* renamed from: h */
    private boolean f3001h = true;

    /* renamed from: i */
    private boolean f3002i = true;

    /* renamed from: k */
    private SharedPreferences f3004k = null;

    /* renamed from: b */
    SharedPreferences.Editor f2995b = null;

    /* renamed from: t */
    private ArrayList f3013t = new ArrayList();

    /* renamed from: u */
    private ArrayList f3014u = new ArrayList();

    /* renamed from: w */
    private Handler f3016w = new HandlerC0475ax(this);

    /* renamed from: a */
    public static void m3131a(Context context) {
        ShareUtil.m3656a(context, context.getString(C0062R.string.settings_invite_friend), context.getString(C0062R.string.setting_chaton_tell_friends_email_text, "www.chaton.com/invite.html"), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3133a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: b */
    private void m3136b() {
        this.f2996c = (AboutNewNotice) findPreference("pref_item_about");
        this.f2996c.setOnPreferenceClickListener(new C0501l(this));
        if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
            this.f2996c.m3119a(true);
        } else {
            this.f2996c.m3119a(false);
        }
        findPreference("pref_item_help").setOnPreferenceClickListener(new C0509t(this));
        findPreference("pref_item_invite_friend").setOnPreferenceClickListener(new C0508s(this));
        findPreference("pref_item_blocked").setOnPreferenceClickListener(new C0507r(this));
        findPreference("pref_item_delete").setOnPreferenceClickListener(new C0506q(this));
        findPreference("pref_item_hide").setOnPreferenceClickListener(new C0505p(this));
        findPreference("pref_item_buddies_say").setOnPreferenceClickListener(new C0504o(this));
        findPreference("pref_item_change_skins").setOnPreferenceClickListener(new C0503n(this));
        findPreference("pref_item_font_size").setOnPreferenceClickListener(new C0502m(this));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_item_birthday");
        if (this.f3004k.getBoolean("Profile Birth Chk", true)) {
            this.f3002i = true;
            this.f2995b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f3002i = false;
            this.f2995b.putBoolean("Profile Birth Chk", false).commit();
        }
        checkBoxPreference.setChecked(this.f3002i);
        checkBoxPreference.setOnPreferenceChangeListener(new C0480bb(this));
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("pref_item_push_notification");
        if (this.f3004k.getBoolean("Setting Notification", true)) {
            this.f3001h = true;
            this.f2995b.putBoolean("Setting Notification", true).commit();
        } else {
            this.f3001h = false;
            this.f2995b.putBoolean("Setting Notification", false).commit();
        }
        checkBoxPreference2.setChecked(this.f3001h);
        checkBoxPreference2.setOnPreferenceChangeListener(new C0481bc(this));
        this.f3008o = (ListPreference) findPreference("pref_item_type");
        if (this.f3004k.getString("Set Type Text", "") == "") {
            this.f2995b.putString("Set Type Text", this.f2999f.getResources().getStringArray(C0062R.array.settings_type_options_value)[0]);
            this.f2995b.commit();
        }
        this.f3011r = this.f3004k.getString("Set Type Text", "");
        int i = 0;
        while (true) {
            if (i >= this.f3006m.length) {
                break;
            }
            if (this.f3011r.equals(this.f3006m[i])) {
                this.f3011r = this.f3007n[i];
                break;
            }
            i++;
        }
        this.f3008o.setSummary(this.f3011r);
        m3133a(this.f3011r, this.f3008o, getResources().getColor(C0062R.color.blue_color_021));
        this.f3008o.setOnPreferenceChangeListener(new C0482bd(this));
        this.f3010q = (RingtonePreference) findPreference("pref_item_ringtone");
        this.f3010q.setDefaultValue(Uri.parse(this.f3004k.getString("Ringtone", Settings.System.DEFAULT_NOTIFICATION_URI.toString())));
        String string = this.f3004k.getString("Ringtone", null);
        Uri defaultUri = string != null ? !string.equals("Silent") ? Uri.parse(string) : null : RingtoneManager.getDefaultUri(2);
        if (defaultUri == null || RingtoneManager.getActualDefaultRingtoneUri(this.f2999f, 2) == null) {
            this.f3009p = "Silent";
        } else {
            this.f3009p = RingtoneManager.getRingtone(this.f2999f, defaultUri).getTitle(this.f2999f);
        }
        this.f3010q.setSummary(this.f3009p);
        m3133a(this.f3009p, this.f3010q, getResources().getColor(C0062R.color.blue_color_021));
        this.f3010q.setOnPreferenceChangeListener(new C0476ay(this));
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("pref_item_received_message");
        if (this.f3004k.getBoolean("Setting show receive message", true)) {
            this.f3000g = true;
            this.f2995b.putBoolean("Setting show receive message", true).commit();
        } else {
            this.f3000g = false;
            this.f2995b.putBoolean("Setting show receive message", false).commit();
        }
        checkBoxPreference3.setChecked(this.f3000g);
        m3133a(getResources().getString(C0062R.string.settings_received_message_summary), checkBoxPreference3, getResources().getColor(C0062R.color.blue_color_021));
        checkBoxPreference3.setOnPreferenceChangeListener(new C0477az(this));
        ((PreferenceCategory) findPreference("settings_category_backup_sync")).removePreference(findPreference("pref_item_send_log"));
        this.f2997d = (SyncStatePreference) findPreference("pref_item_sync_now");
        PushControlFactory.m2072a().mo1977c(new HandlerC0479ba(this, Looper.getMainLooper()));
    }

    /* renamed from: j */
    static /* synthetic */ int m3146j(ActivitySettings activitySettings) {
        int i = activitySettings.f3005l + 1;
        activitySettings.f3005l = i;
        return i;
    }

    /* renamed from: a */
    public void m3149a() {
        String str = getClass().getSimpleName() + " - getBlindListToSet()";
        Iterator it = this.f3013t.iterator();
        while (it.hasNext()) {
            ChatONLogWriter.m3511e("[mBlindOldList] " + ((String) it.next()), str);
        }
        Iterator it2 = this.f3014u.iterator();
        while (it2.hasNext()) {
            ChatONLogWriter.m3511e("[mBlindNewList] " + ((String) it2.next()), str);
        }
        for (int i = 0; i < this.f3014u.size(); i++) {
            String str2 = (String) this.f3014u.get(i);
            if (this.f3013t.remove(str2)) {
                this.f3014u.remove(str2);
            }
        }
        Iterator it3 = this.f3013t.iterator();
        while (it3.hasNext()) {
            ChatONLogWriter.m3511e("[1st mBlindOldList] " + ((String) it3.next()), str);
        }
        Iterator it4 = this.f3014u.iterator();
        while (it4.hasNext()) {
            ChatONLogWriter.m3511e("[1st mBlindNewList] " + ((String) it4.next()), str);
        }
        for (int i2 = 0; i2 < this.f3013t.size(); i2++) {
            String str3 = (String) this.f3013t.get(i2);
            if (this.f3014u.remove(str3)) {
                this.f3013t.remove(str3);
            }
        }
        Iterator it5 = this.f3013t.iterator();
        while (it5.hasNext()) {
            ChatONLogWriter.m3511e("[2nd mBlindOldList] " + ((String) it5.next()), str);
        }
        Iterator it6 = this.f3014u.iterator();
        while (it6.hasNext()) {
            ChatONLogWriter.m3511e("[2nd mBlindNewList] " + ((String) it6.next()), str);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
        }
        switch (i) {
            case 2:
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                if (uri != null) {
                    this.f2995b.putString("Ringtone", uri.toString()).commit();
                    break;
                } else {
                    this.f2995b.putString("Ringtone", "Ringtone").commit();
                    break;
                }
            case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                if (i == 10 && i2 == -1) {
                    ChatONLogWriter.m3511e("Get blind list from user", getClass().getSimpleName());
                    String[] stringArrayExtra = intent.getStringArrayExtra("blindlist");
                    this.f3014u.clear();
                    for (String str : stringArrayExtra) {
                        this.f3014u.add(str);
                    }
                    m3149a();
                    if (this.f3013t.size() != 0 || this.f3014u.size() != 0) {
                        this.f3012s.m2009a(this.f3013t, this.f3014u);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3508c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        addPreferencesFromResource(C0062R.xml.preference_setting);
        getListView().setScrollingCacheEnabled(false);
        this.f3004k = ChatONPref.m3519a();
        this.f3003j = new SettingBean(this.f3004k);
        this.f2995b = this.f3004k.edit();
        this.f2995b.putBoolean("Lock Check", false);
        this.f2999f = this;
        this.f2998e = (AlarmManager) this.f2999f.getSystemService("alarm");
        this.f3006m = this.f2999f.getResources().getStringArray(C0062R.array.settings_type_options_value);
        this.f3007n = this.f2999f.getResources().getStringArray(C0062R.array.settings_type_options);
        try {
            m3136b();
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3508c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatONLogWriter.m3508c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f2997d.m3219b();
        if (this.f3015v != null) {
            this.f3015v.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3508c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f2997d.m3218a();
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
