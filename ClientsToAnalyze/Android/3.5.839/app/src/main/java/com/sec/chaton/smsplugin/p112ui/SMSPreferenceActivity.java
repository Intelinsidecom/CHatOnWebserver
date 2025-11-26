package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.p061g.C2346e;
import com.sec.chaton.settings.BasePreferenceActivity;
import com.sec.chaton.settings.FreeSmsInfoPreference;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C5043h;

/* loaded from: classes.dex */
public class SMSPreferenceActivity extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: o */
    private static String f15079o = null;

    /* renamed from: b */
    PreferenceScreen f15081b;

    /* renamed from: c */
    Preference f15082c;

    /* renamed from: d */
    CheckBoxPreference f15083d;

    /* renamed from: e */
    CheckBoxPreference f15084e;

    /* renamed from: f */
    CheckBoxPreference f15085f;

    /* renamed from: g */
    CheckBoxPreference f15086g;

    /* renamed from: h */
    FreeSmsInfoPreference f15087h;

    /* renamed from: i */
    PreferenceCategory f15088i;

    /* renamed from: l */
    private C2097bc f15091l;

    /* renamed from: m */
    private SharedPreferencesOnSharedPreferenceChangeListenerC4292hl f15092m;

    /* renamed from: n */
    private SharedPreferences f15093n;

    /* renamed from: a */
    String f15080a = "Settings";

    /* renamed from: k */
    private C4810ab f15090k = null;

    /* renamed from: j */
    Handler f15089j = new HandlerC4284hd(this, Looper.getMainLooper());

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        f15079o = getPackageName();
        addPreferencesFromResource(R.xml.sms_preferences);
        this.f15090k = C4809aa.m18104a();
        getListView().setScrollingCacheEnabled(false);
        this.f15093n = CommonApplication.m18732r().getSharedPreferences("ChatON", 0);
        this.f15092m = new SharedPreferencesOnSharedPreferenceChangeListenerC4292hl(this, null);
        this.f15093n.registerOnSharedPreferenceChangeListener(this.f15092m);
        this.f15091l = new C2097bc(this.f15089j);
        this.f15091l.m9369a();
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16177a() throws Resources.NotFoundException {
        this.f15081b = (PreferenceScreen) findPreference("pref_key_sms_settings_screen");
        this.f15083d = (CheckBoxPreference) findPreference("pref_key_send_and_receive_sms_mms");
        this.f15084e = (CheckBoxPreference) findPreference("pref_key_auto_transform_to_mms");
        this.f15085f = (CheckBoxPreference) findPreference("pref_key_vibrate_on_switching_to_mms");
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("pref_key_is_free_sms_enable");
        if (checkBoxPreference != null) {
            this.f15086g = checkBoxPreference;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("pref_category_free_message");
        if (preferenceCategory != null) {
            this.f15088i = preferenceCategory;
        }
        FreeSmsInfoPreference freeSmsInfoPreference = (FreeSmsInfoPreference) findPreference("pref_key_freesms_info");
        if (freeSmsInfoPreference != null) {
            if (this.f15087h != null && this.f15087h != freeSmsInfoPreference) {
                this.f15087h.m13647a();
            }
            this.f15087h = freeSmsInfoPreference;
        }
        this.f15082c = findPreference("pref_key_kikat_default_sms");
        if (C3847e.m14686ar()) {
            C3892o.m15032f();
            if (this.f15083d != null) {
                this.f15081b.removePreference(this.f15083d);
            }
            if (this.f15082c != null) {
                if (C3892o.m15023b()) {
                    this.f15090k.m18128b("pref_key_kikat_default_sms", getPackageName());
                    m16178a(this.f15082c, true);
                    this.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
                    C5043h.m19179a().m19183a("0300", "2120");
                } else {
                    this.f15090k.m18128b("pref_key_kikat_default_sms", C3892o.m15011a(this));
                    m16178a(this.f15082c, false);
                    this.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) false);
                    C5043h.m19179a().m19183a("0300", "2119");
                }
                this.f15082c.setOnPreferenceClickListener(new C4285he(this));
            }
        } else {
            if (this.f15082c != null) {
                this.f15081b.removePreference(this.f15082c);
            }
            if (this.f15083d != null) {
                this.f15083d.setSummary(getResources().getString(R.string.pref_summary_send_and_receive_sms_mms) + "\n" + getResources().getString(R.string.messages_will_be_charged));
                if (C4822an.m18218a()) {
                    if (this.f15090k.m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue()) {
                        this.f15083d.setChecked(true);
                        this.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
                    } else {
                        this.f15083d.setChecked(false);
                        this.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) false);
                    }
                    this.f15083d.setOnPreferenceChangeListener(new C4286hf(this));
                } else {
                    this.f15081b.removePreference(this.f15083d);
                }
            }
        }
        if (this.f15090k.m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue()) {
            if (this.f15084e != null) {
                this.f15084e.setEnabled(true);
            }
            if (this.f15085f != null) {
                this.f15085f.setEnabled(true);
            }
            if (this.f15088i != null) {
                this.f15088i.setEnabled(true);
            }
            if (this.f15086g != null) {
                this.f15086g.setEnabled(true);
            }
            if (this.f15087h != null) {
                this.f15087h.setEnabled(true);
            }
        } else {
            if (this.f15084e != null) {
                this.f15084e.setEnabled(false);
            }
            if (this.f15085f != null) {
                this.f15085f.setEnabled(false);
            }
            if (this.f15088i != null) {
                this.f15088i.setEnabled(false);
            }
            if (this.f15086g != null) {
                this.f15086g.setEnabled(false);
            }
            if (this.f15087h != null) {
                this.f15087h.setEnabled(false);
            }
        }
        if (this.f15084e != null) {
            if (C4822an.m18243k() != null && !C4822an.m18243k().equals("450")) {
                if (this.f15090k.m18119a("pref_key_auto_transform_to_mms", (Boolean) false).booleanValue()) {
                    this.f15084e.setChecked(true);
                    this.f15090k.m18125b("pref_key_auto_transform_to_mms", (Boolean) true);
                } else {
                    this.f15084e.setChecked(false);
                    this.f15090k.m18125b("pref_key_auto_transform_to_mms", (Boolean) false);
                }
                this.f15084e.setOnPreferenceChangeListener(new C4287hg(this));
            } else {
                this.f15081b.removePreference(this.f15084e);
            }
        }
        if (this.f15085f != null) {
            if (this.f15090k.m18119a("pref_key_vibrate_on_switching_to_mms", (Boolean) true).booleanValue()) {
                this.f15085f.setChecked(true);
                this.f15090k.m18125b("pref_key_vibrate_on_switching_to_mms", (Boolean) true);
            } else {
                this.f15085f.setChecked(false);
                this.f15090k.m18125b("pref_key_vibrate_on_switching_to_mms", (Boolean) false);
            }
            this.f15085f.setOnPreferenceChangeListener(new C4288hh(this));
        }
        if (this.f15086g != null) {
            if (!C3847e.m14691aw()) {
                if (this.f15088i != null) {
                    this.f15081b.removePreference(this.f15088i);
                }
                this.f15081b.removePreference(this.f15086g);
                if (this.f15087h != null) {
                    this.f15081b.removePreference(this.f15087h);
                    return;
                }
                return;
            }
            if (checkBoxPreference == null) {
                this.f15081b.addPreference(this.f15088i);
                this.f15081b.addPreference(this.f15086g);
                boolean z = this.f15086g.getSharedPreferences().getBoolean("pref_key_is_free_sms_enable", false);
                this.f15090k.m18125b("pref_key_is_free_sms_enable", Boolean.valueOf(z));
                if (z) {
                    this.f15081b.addPreference(this.f15087h);
                }
            }
            this.f15086g.setOnPreferenceChangeListener(new C4289hi(this));
            boolean z2 = this.f15086g.getSharedPreferences().getBoolean("pref_key_is_free_sms_enable", false);
            this.f15090k.m18125b("pref_key_is_free_sms_enable", Boolean.valueOf(z2));
            if (!z2 && this.f15087h != null) {
                this.f15081b.removePreference(this.f15087h);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        getWindow().clearFlags(4194304);
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        try {
            m16177a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f15087h != null) {
            this.f15087h.m13647a();
        }
        try {
            if (this.f15093n != null && this.f15092m != null) {
                this.f15093n.unregisterOnSharedPreferenceChangeListener(this.f15092m);
                this.f15092m = null;
            }
        } catch (Exception e) {
            C3890m.m14996b(this.f15080a, "caught Exception:" + e);
            e.printStackTrace();
        }
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* renamed from: a */
    public static int m16175a(String str) {
        if ("restricted".equals(str)) {
            return 0;
        }
        if ("warning".equals(str)) {
            return 1;
        }
        if ("free".equals(str)) {
            return 2;
        }
        throw new IllegalArgumentException("Unknown MMS creation mode.");
    }

    /* renamed from: a */
    private void m16178a(Preference preference, boolean z) throws Resources.NotFoundException {
        CharSequence string;
        if (z) {
            string = getApplicationInfo().loadLabel(getPackageManager());
        } else {
            string = getResources().getString(R.string.change_your_default_sms_app_into_chaton);
        }
        preference.setSummary(string);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 == -1) {
            }
        } else if (i == 98345) {
            C2346e.m10272a(this, i2, intent, true, null);
        }
    }
}
