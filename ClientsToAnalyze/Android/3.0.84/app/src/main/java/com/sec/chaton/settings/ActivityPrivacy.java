package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.userprofile.MyInfoFragment;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.InterfaceC3274d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActivityPrivacy extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: A */
    private Preference f9060A;

    /* renamed from: B */
    private Preference f9061B;

    /* renamed from: b */
    private Context f9064b;

    /* renamed from: d */
    private CheckBoxPreference f9066d;

    /* renamed from: e */
    private CheckBoxPreference f9067e;

    /* renamed from: g */
    private String f9069g;

    /* renamed from: h */
    private String f9070h;

    /* renamed from: i */
    private String f9071i;

    /* renamed from: j */
    private String f9072j;

    /* renamed from: k */
    private String f9073k;

    /* renamed from: l */
    private String f9074l;

    /* renamed from: m */
    private String f9075m;

    /* renamed from: n */
    private String f9076n;

    /* renamed from: o */
    private C1330h f9077o;

    /* renamed from: p */
    private String f9078p;

    /* renamed from: q */
    private String f9079q;

    /* renamed from: r */
    private String f9080r;

    /* renamed from: t */
    private Preference f9082t;

    /* renamed from: w */
    private ArrayList<PrivacyList> f9085w;

    /* renamed from: x */
    private int f9086x;

    /* renamed from: z */
    private Boolean f9088z;

    /* renamed from: a */
    String f9063a = ActivityPrivacy.class.getSimpleName();

    /* renamed from: c */
    private C3160ab f9065c = null;

    /* renamed from: f */
    private ProgressDialog f9068f = null;

    /* renamed from: s */
    private String f9081s = ActivityPrivacy.class.getSimpleName();

    /* renamed from: u */
    private String[] f9083u = new String[2];

    /* renamed from: v */
    private int f9084v = 0;

    /* renamed from: y */
    private InterfaceC3274d f9087y = null;

    /* renamed from: C */
    private Handler f9062C = new HandlerC2465bz(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f9068f = new ProgressDialogC3265l(this, false);
        this.f9068f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f9068f.setOnKeyListener(new DialogInterfaceOnKeyListenerC2457br(this));
        this.f9088z = false;
        this.f9077o = new C1330h(this.f9062C);
        this.f9077o.m5753g("phonenumber|showprofileimage|emailsamsung");
        this.f9068f.show();
        this.f9085w = new ArrayList<>();
        addPreferencesFromResource(R.xml.pref_setting_privacy);
        this.f9064b = this;
        this.f9065c = C3159aa.m10962a();
        this.f9065c.m10983b("Lock Check", (Boolean) false);
        this.f9078p = C3159aa.m10962a().m10979a("samsung_account_email", "");
        this.f9069g = C3159aa.m10962a().m10979a("msisdn", "");
        this.f9070h = getResources().getString(R.string.phone_number_privacy_guide);
        this.f9071i = getResources().getString(R.string.phone_number_privacy_guide_off);
        this.f9073k = getResources().getString(R.string.tab_buddies);
        this.f9074l = getResources().getString(R.string.setting_privacy_only_buddy_profile_description);
        this.f9075m = getResources().getString(R.string.setting_downloads_font_filter_all);
        this.f9076n = getResources().getString(R.string.setting_privacy_public_profile_description);
        this.f9079q = getResources().getString(R.string.privacy_show_my_samsung_account_detail);
        this.f9080r = getResources().getString(R.string.setting_privacy_blind_samsung_account_description);
        this.f9072j = getResources().getString(R.string.settings_privacy_showmynumber);
        getListView().setScrollingCacheEnabled(false);
        this.f9082t = findPreference("pref_item_password_lock");
        this.f9083u = m9062a("GET", "", "");
        m9061a(this.f9083u[this.f9084v]);
        try {
            m9042a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m9042a() {
        C3159aa.m10962a().m10979a("msisdn", "");
        this.f9066d = (CheckBoxPreference) findPreference("pref_item_phonenumber");
        if (this.f9069g == null || this.f9069g.length() == 0) {
            C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
            this.f9066d.setEnabled(false);
            this.f9066d.setChecked(false);
        } else {
            this.f9066d.setEnabled(true);
        }
        this.f9066d.setChecked(C3159aa.m10962a().m10977a("show_phone_number_to_all", (Boolean) true).booleanValue());
        if (this.f9066d.isChecked()) {
            if (this.f9069g == null || this.f9069g == "") {
                m9044a(this.f9070h, this.f9066d, getResources().getColor(R.color.setting_explain_text));
            } else {
                m9046a("+" + this.f9069g, this.f9070h, this.f9066d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            }
        } else if (this.f9069g == null || this.f9069g == "") {
            m9049b(this.f9072j, this.f9066d, getResources().getColor(R.color.dark_gray));
            m9044a(this.f9071i, this.f9066d, getResources().getColor(R.color.setting_explain_text));
        } else {
            m9049b(this.f9072j, this.f9066d, getResources().getColor(R.color.black));
            m9046a("+" + this.f9069g, this.f9071i, this.f9066d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        this.f9066d.setOnPreferenceChangeListener(new C2458bs(this));
        this.f9061B = findPreference("pref_item_show_profileimage");
        if (C3159aa.m10962a().m10977a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
            m9046a(this.f9075m, this.f9076n, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            m9046a(this.f9073k, this.f9074l, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        this.f9061B.setOnPreferenceClickListener(new C2459bt(this));
        this.f9067e = (CheckBoxPreference) findPreference("pref_item_samsung_account");
        if (this.f9078p == null || this.f9078p.length() == 0) {
            C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) false);
            this.f9067e.setChecked(false);
            this.f9067e.setEnabled(false);
        } else {
            this.f9067e.setEnabled(true);
        }
        this.f9067e.setChecked(C3159aa.m10962a().m10977a("samsung_account_show", (Boolean) false).booleanValue());
        if (this.f9067e.isChecked()) {
            this.f9067e.setSummary(this.f9079q);
            m9044a(this.f9079q, this.f9067e, getResources().getColor(R.color.setting_explain_text));
        } else {
            this.f9067e.setSummary(this.f9080r);
            m9044a(this.f9080r, this.f9067e, getResources().getColor(R.color.setting_explain_text));
        }
        this.f9067e.setOnPreferenceChangeListener(new C2461bv(this));
        this.f9060A = findPreference("pref_item_birthday");
        m9051c();
        this.f9060A.setOnPreferenceClickListener(new C2462bw(this));
        Preference preferenceFindPreference = findPreference("pref_item_poston");
        preferenceFindPreference.setSummary(getResources().getString(R.string.poston_buddies_blocked));
        m9044a(getString(R.string.poston_buddies_blocked), preferenceFindPreference, getResources().getColor(R.color.setting_explain_text));
        preferenceFindPreference.setOnPreferenceClickListener(new C2463bx(this));
        this.f9082t.setOnPreferenceClickListener(new C2464by(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m9044a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: a */
    private void m9046a(String str, String str2, Preference preference, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        SpannableString spannableString2 = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str2.length(), 0);
        preference.setSummary(TextUtils.concat(spannableString, "\n", spannableString2));
    }

    /* renamed from: b */
    private void m9049b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: a */
    public String[] m9062a(String str, String str2, String str3) {
        C3250y.m11450b("prePassword", this.f9081s);
        C3250y.m11450b("mode : " + str, this.f9081s);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C3250y.m11450b("GET preference", this.f9081s);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C3241p.m11409e());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C3250y.m11450b("data : " + strArr[i2], this.f9081s);
            }
        } else {
            C3250y.m11450b("SET preference", this.f9081s);
            C3250y.m11450b("state : " + str2, this.f9081s);
            C3250y.m11450b("pass : " + str3, this.f9081s);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM11401b = C3241p.m11401b(str2);
            String strM11401b2 = C3241p.m11401b(str3);
            editorEdit.putString("LOCK_STATE", strM11401b);
            editorEdit.putString("PASSWORD", strM11401b2);
            editorEdit.commit();
        }
        return strArr;
    }

    /* renamed from: a */
    public void m9061a(String str) {
        C3250y.m11450b("changeSummary", this.f9081s);
        if (str.equals(C3241p.m11408d())) {
            this.f9082t.setSummary(R.string.settings_password_lock_text_on);
            m9044a(getResources().getString(R.string.settings_password_lock_text_on), this.f9082t, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            this.f9082t.setSummary(R.string.settings_password_lock_text_off);
            m9044a(getResources().getString(R.string.settings_password_lock_text_off), this.f9082t, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m9051c();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f9068f != null && this.f9068f.isShowing()) {
            this.f9068f.dismiss();
        }
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        C3250y.m11453c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9081s);
        this.f9083u = m9062a("GET", "", "");
        m9061a(this.f9083u[this.f9084v]);
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9048b() {
        if (this.f9066d.isChecked()) {
            if (this.f9069g == null || this.f9069g == "") {
                C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
                m9044a(this.f9070h, this.f9066d, getResources().getColor(R.color.setting_explain_text));
            } else {
                m9046a("+" + this.f9069g, this.f9070h, this.f9066d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            }
        } else if (this.f9069g == null || this.f9069g == "") {
            m9044a(this.f9071i, this.f9066d, getResources().getColor(R.color.setting_explain_text));
        } else {
            m9046a("+" + this.f9069g, this.f9071i, this.f9066d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        if (C3159aa.m10962a().m10977a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
            this.f9086x = 1;
            m9046a(this.f9075m, this.f9076n, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            this.f9086x = 0;
            m9046a(this.f9073k, this.f9074l, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        if (this.f9067e.isChecked()) {
            this.f9067e.setSummary(this.f9079q);
            m9044a(this.f9079q, this.f9067e, getResources().getColor(R.color.setting_explain_text));
        } else {
            this.f9067e.setSummary(this.f9080r);
            m9044a(this.f9080r, this.f9067e, getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9045a(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.equals("phonenumber") && this.f9066d.isEnabled()) {
                if (str2.equals("true")) {
                    C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) true);
                    this.f9066d.setChecked(true);
                } else {
                    C3159aa.m10962a().m10983b("show_phone_number_to_all", (Boolean) false);
                    this.f9066d.setChecked(false);
                }
                C3250y.m11456e("InitPrivacyCheck/ phonenumber : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("showprofileimage")) {
                if (str2.equals("true")) {
                    this.f9086x = 1;
                    C3159aa.m10962a().m10983b("samsung_profile_image_show", (Boolean) true);
                    m9046a(this.f9075m, this.f9076n, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                } else {
                    this.f9086x = 0;
                    C3159aa.m10962a().m10983b("samsung_profile_image_show", (Boolean) false);
                    m9046a(this.f9073k, this.f9074l, this.f9061B, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                }
                C3250y.m11456e("InitPrivacyCheck/ showprofileimage : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("emailsamsung") && this.f9067e.isEnabled()) {
                if (str2.equals("true")) {
                    this.f9067e.setChecked(true);
                    C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) true);
                } else {
                    this.f9067e.setChecked(false);
                    C3159aa.m10962a().m10983b("samsung_account_show", (Boolean) false);
                }
                C3250y.m11456e("InitPrivacyCheck/ emailsamsung : " + str2, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: c */
    private void m9051c() {
        String strM10979a = C3159aa.m10962a().m10979a("birthday", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("birthday_type", "");
        if (strM10979a.length() > 0) {
            if ("".equals(strM10979a2)) {
                strM10979a2 = "SHORT_HIDE";
            }
            if ("FULL".equals(strM10979a2)) {
                m9044a(MyInfoFragment.m10678b(strM10979a), this.f9060A, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
            if ("SHORT".equals(strM10979a2)) {
                String[] strArrSplit = strM10979a.split("-");
                m9044a(MyInfoFragment.m10678b(strArrSplit[1] + "-" + strArrSplit[2]), this.f9060A, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            } else if ("FULL_HIDE".equals(strM10979a2)) {
                m9044a(MyInfoFragment.m10678b(strM10979a), this.f9060A, getResources().getColor(R.color.setting_explain_text));
                return;
            } else if ("SHORT_HIDE".equals(strM10979a2)) {
                String[] strArrSplit2 = strM10979a.split("-");
                m9044a(MyInfoFragment.m10678b(strArrSplit2[1] + "-" + strArrSplit2[2]), this.f9060A, getResources().getColor(R.color.setting_explain_text));
                return;
            } else {
                m9044a(getResources().getString(R.string.add_your_birthday), this.f9060A, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
        }
        m9044a(getResources().getString(R.string.add_your_birthday), this.f9060A, getResources().getColor(R.color.buddy_list_item_status_changed));
    }
}
