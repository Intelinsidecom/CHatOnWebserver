package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p065io.entry.inner.PrivacyList;
import com.sec.chaton.userprofile.MyInfoFragment;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5033j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActivityPrivacy extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: b */
    private Context f12624b;

    /* renamed from: d */
    private CheckBoxPreference f12626d;

    /* renamed from: e */
    private CheckBoxPreference f12627e;

    /* renamed from: g */
    private String f12629g;

    /* renamed from: h */
    private String f12630h;

    /* renamed from: i */
    private String f12631i;

    /* renamed from: j */
    private String f12632j;

    /* renamed from: k */
    private String f12633k;

    /* renamed from: l */
    private String f12634l;

    /* renamed from: m */
    private String f12635m;

    /* renamed from: n */
    private String f12636n;

    /* renamed from: o */
    private C2128i f12637o;

    /* renamed from: p */
    private String f12638p;

    /* renamed from: r */
    private Preference f12640r;

    /* renamed from: u */
    private ArrayList<PrivacyList> f12643u;

    /* renamed from: v */
    private int f12644v;

    /* renamed from: x */
    private Boolean f12646x;

    /* renamed from: y */
    private Preference f12647y;

    /* renamed from: z */
    private Preference f12648z;

    /* renamed from: a */
    String f12623a = ActivityPrivacy.class.getSimpleName();

    /* renamed from: c */
    private C4810ab f12625c = null;

    /* renamed from: f */
    private ProgressDialog f12628f = null;

    /* renamed from: q */
    private String f12639q = ActivityPrivacy.class.getSimpleName();

    /* renamed from: s */
    private String[] f12641s = new String[2];

    /* renamed from: t */
    private int f12642t = 0;

    /* renamed from: w */
    private InterfaceC4936e f12645w = null;

    /* renamed from: A */
    private Handler f12622A = new HandlerC3561cy(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (C4822an.m18218a()) {
            this.f12628f = new ProgressDialogC4926s(this, false);
            this.f12628f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            this.f12628f.setOnKeyListener(new DialogInterfaceOnKeyListenerC3553cq(this));
            this.f12646x = false;
            this.f12637o = new C2128i(this.f12622A);
            this.f12637o.m9527f("phonenumber|showprofileimage|emailsamsung|showsnsid");
            this.f12628f.show();
            this.f12643u = new ArrayList<>();
            this.f12638p = C4809aa.m18104a().m18121a("samsung_account_email", "");
            this.f12629g = C4809aa.m18104a().m18121a("msisdn", "");
            this.f12630h = getResources().getString(R.string.phone_number_privacy_guide);
            this.f12631i = getResources().getString(R.string.phone_number_privacy_guide_off);
            this.f12633k = getResources().getString(R.string.privacy_contacts_only);
            this.f12634l = getResources().getString(R.string.setting_privacy_only_buddy_profile_description);
            this.f12635m = getResources().getString(R.string.setting_downloads_font_filter_all);
            this.f12636n = getResources().getString(R.string.setting_privacy_public_profile_description);
            this.f12632j = getResources().getString(R.string.settings_privacy_showmynumber);
        }
        addPreferencesFromResource(R.xml.pref_setting_privacy);
        this.f12624b = this;
        this.f12625c = C4809aa.m18104a();
        this.f12625c.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        this.f12640r = findPreference("pref_item_password_lock");
        this.f12641s = m13531a("GET", "", "");
        m13530a(this.f12641s[this.f12642t]);
        try {
            m13511a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
        if (!C4822an.m18218a()) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            preferenceScreen.removePreference(findPreference("pref_item_phonenumber"));
            preferenceScreen.removePreference(findPreference("pref_item_show_profileimage"));
            preferenceScreen.removePreference(findPreference("pref_item_samsung_account"));
            preferenceScreen.removePreference(findPreference("pref_item_birthday"));
            preferenceScreen.removePreference(findPreference("pref_item_poston"));
        }
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
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
    private void m13511a() {
        C4809aa.m18104a().m18121a("msisdn", "");
        if (C4822an.m18218a()) {
            this.f12626d = (CheckBoxPreference) findPreference("pref_item_phonenumber");
            if (this.f12629g == null || this.f12629g.length() == 0) {
                this.f12626d.setEnabled(false);
                this.f12626d.setChecked(false);
                m13518b(this.f12632j, this.f12626d, getResources().getColor(R.color.dark_gray));
                m13513a(this.f12631i, this.f12626d, getResources().getColor(R.color.setting_explain_text));
            } else {
                this.f12626d.setEnabled(true);
                this.f12626d.setChecked(C4809aa.m18104a().m18119a("show_phone_number_to_all", (Boolean) true).booleanValue());
                m13518b(this.f12632j, this.f12626d, getResources().getColor(R.color.black));
                if (C4809aa.m18104a().m18119a("show_phone_number_to_all", (Boolean) true).booleanValue()) {
                    m13515a("+" + this.f12629g, this.f12630h, this.f12626d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                } else {
                    m13515a("+" + this.f12629g, this.f12631i, this.f12626d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                }
            }
            this.f12626d.setOnPreferenceChangeListener(new C3554cr(this));
            this.f12648z = findPreference("pref_item_show_profileimage");
            if (C4809aa.m18104a().m18119a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
                m13515a(this.f12635m, this.f12636n, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            } else {
                m13515a(this.f12633k, this.f12634l, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
            }
            this.f12648z.setOnPreferenceClickListener(new C3555cs(this));
            this.f12627e = (CheckBoxPreference) findPreference("pref_item_samsung_account");
            if (this.f12638p == null || this.f12638p.length() == 0) {
                C4809aa.m18104a().m18125b("samsung_account_show", (Boolean) false);
                this.f12627e.setChecked(false);
                this.f12627e.setEnabled(false);
                m13518b(getString(R.string.privacy_show_my_samsung_account), this.f12627e, getResources().getColor(R.color.setting_explain_text));
            } else {
                this.f12627e.setEnabled(true);
                m13518b(getString(R.string.privacy_show_my_samsung_account), this.f12627e, getResources().getColor(R.color.black));
            }
            this.f12627e.setChecked(C4809aa.m18104a().m18119a("samsung_account_show", (Boolean) false).booleanValue());
            this.f12627e.setOnPreferenceChangeListener(new C3557cu(this));
            this.f12647y = findPreference("pref_item_birthday");
            m13520c();
            this.f12647y.setOnPreferenceClickListener(new C3558cv(this));
            Preference preferenceFindPreference = findPreference("pref_item_poston");
            preferenceFindPreference.setSummary(getResources().getString(R.string.poston_buddies_blocked));
            m13513a(getString(R.string.poston_buddies_blocked), preferenceFindPreference, getResources().getColor(R.color.setting_explain_text));
            preferenceFindPreference.setOnPreferenceClickListener(new C3559cw(this));
        }
        this.f12640r.setOnPreferenceClickListener(new C3560cx(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m13513a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: a */
    private void m13515a(String str, String str2, Preference preference, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        SpannableString spannableString2 = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str2.length(), 0);
        preference.setSummary(TextUtils.concat(spannableString, "\n", spannableString2));
    }

    /* renamed from: b */
    private void m13518b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: a */
    public String[] m13531a(String str, String str2, String str3) {
        String strM18588h;
        C4904y.m18639b("prePassword", this.f12639q);
        C4904y.m18639b("mode : " + str, this.f12639q);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        if (str.equals("GET")) {
            C4904y.m18639b("GET preference", this.f12639q);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C4892m.m18588h());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C4904y.m18639b("privacyData : " + strArr[i2], this.f12639q);
            }
        } else {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!str2.equals("OFF")) {
                strM18588h = C4892m.m18586g();
            } else {
                strM18588h = C4892m.m18588h();
            }
            String strM18567a = C4892m.m18567a(str3);
            editorEdit.putString("LOCK_STATE", strM18588h);
            editorEdit.putString("PASSWORD", strM18567a);
            C5033j.m19087a(editorEdit);
            C4904y.m18639b("SET preference", this.f12639q);
            C4904y.m18639b("state : " + str2, this.f12639q);
            C4904y.m18639b("pass : " + str3, this.f12639q);
        }
        return strArr;
    }

    /* renamed from: a */
    public void m13530a(String str) {
        C4904y.m18639b("changeSummary", this.f12639q);
        if (!str.equals(C4892m.m18588h())) {
            this.f12640r.setSummary(R.string.settings_password_lock_text_on);
            m13513a(getResources().getString(R.string.settings_password_lock_text_on), this.f12640r, getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            this.f12640r.setSummary(R.string.settings_password_lock_text_off);
            m13513a(getResources().getString(R.string.settings_password_lock_text_off), this.f12640r, getResources().getColor(R.color.buddy_list_item_status_changed));
        }
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4822an.m18218a()) {
            m13520c();
        }
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (C4822an.m18218a() && this.f12628f != null && this.f12628f.isShowing()) {
            this.f12628f.dismiss();
        }
        super.onDestroy();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        C4904y.m18641c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12639q);
        this.f12641s = m13531a("GET", "", "");
        m13530a(this.f12641s[this.f12642t]);
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13517b() {
        if (this.f12629g == null || this.f12629g.equals("")) {
            m13513a(this.f12631i, this.f12626d, getResources().getColor(R.color.setting_explain_text));
        } else if (this.f12626d.isChecked()) {
            m13515a("+" + this.f12629g, this.f12630h, this.f12626d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            m13515a("+" + this.f12629g, this.f12631i, this.f12626d, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
        if (C4809aa.m18104a().m18119a("samsung_profile_image_show", (Boolean) false).booleanValue()) {
            this.f12644v = 1;
            m13515a(this.f12635m, this.f12636n, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        } else {
            this.f12644v = 0;
            m13515a(this.f12633k, this.f12634l, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13514a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && C4822an.m18218a()) {
            if (str.equals("phonenumber") && this.f12626d.isEnabled()) {
                if (str2.equals("true")) {
                    C4809aa.m18104a().m18125b("show_phone_number_to_all", (Boolean) true);
                    this.f12626d.setChecked(true);
                } else {
                    C4809aa.m18104a().m18125b("show_phone_number_to_all", (Boolean) false);
                    this.f12626d.setChecked(false);
                }
                C4904y.m18646e("InitPrivacyCheck/ phonenumber : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("showprofileimage")) {
                if (str2.equals("true")) {
                    this.f12644v = 1;
                    C4809aa.m18104a().m18125b("samsung_profile_image_show", (Boolean) true);
                    m13515a(this.f12635m, this.f12636n, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                } else {
                    this.f12644v = 0;
                    C4809aa.m18104a().m18125b("samsung_profile_image_show", (Boolean) false);
                    m13515a(this.f12633k, this.f12634l, this.f12648z, getResources().getColor(R.color.buddy_list_item_status_changed), getResources().getColor(R.color.setting_explain_text));
                }
                C4904y.m18646e("InitPrivacyCheck/ showprofileimage : " + str2, getClass().getSimpleName());
                return;
            }
            if (str.equals("emailsamsung") && this.f12627e.isEnabled()) {
                if (str2.equals("true")) {
                    this.f12627e.setChecked(true);
                    C4809aa.m18104a().m18125b("samsung_account_show", (Boolean) true);
                } else {
                    this.f12627e.setChecked(false);
                    C4809aa.m18104a().m18125b("samsung_account_show", (Boolean) false);
                }
                C4904y.m18646e("InitPrivacyCheck/ emailsamsung : " + str2, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: c */
    private void m13520c() {
        String strM18121a = C4809aa.m18104a().m18121a("birthday", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("birthday_type", "");
        if (strM18121a.length() > 0) {
            if ("".equals(strM18121a2)) {
                strM18121a2 = "SHORT_HIDE";
            }
            if ("FULL".equals(strM18121a2)) {
                m13513a(MyInfoFragment.m17841a(strM18121a), this.f12647y, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
            if ("SHORT".equals(strM18121a2)) {
                String[] strArrSplit = strM18121a.split("-");
                m13513a(MyInfoFragment.m17841a(strArrSplit[1] + "-" + strArrSplit[2]), this.f12647y, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            } else if ("FULL_HIDE".equals(strM18121a2)) {
                m13513a(MyInfoFragment.m17841a(strM18121a), this.f12647y, getResources().getColor(R.color.setting_explain_text));
                return;
            } else if ("SHORT_HIDE".equals(strM18121a2)) {
                String[] strArrSplit2 = strM18121a.split("-");
                m13513a(MyInfoFragment.m17841a(strArrSplit2[1] + "-" + strArrSplit2[2]), this.f12647y, getResources().getColor(R.color.setting_explain_text));
                return;
            } else {
                m13513a(getResources().getString(R.string.add_your_birthday), this.f12647y, getResources().getColor(R.color.buddy_list_item_status_changed));
                return;
            }
        }
        m13513a(getResources().getString(R.string.add_your_birthday), this.f12647y, getResources().getColor(R.color.buddy_list_item_status_changed));
    }
}
