package com.sec.chaton.settings;

import android.app.AlarmManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class ActivityPrivacy extends PreferenceListFragment {

    /* renamed from: c */
    AlarmManager f4544c;

    /* renamed from: d */
    CheckBoxPreference f4545d;

    /* renamed from: e */
    private Context f4546e;

    /* renamed from: g */
    private C1306dd f4548g;

    /* renamed from: h */
    private String[] f4549h;

    /* renamed from: i */
    private String[] f4550i;

    /* renamed from: j */
    private String f4551j;

    /* renamed from: k */
    private ProgressDialog f4552k;

    /* renamed from: n */
    private Preference f4555n;

    /* renamed from: a */
    String f4542a = "Settings";

    /* renamed from: f */
    private SharedPreferences f4547f = null;

    /* renamed from: b */
    SharedPreferences.Editor f4543b = null;

    /* renamed from: l */
    private boolean f4553l = true;

    /* renamed from: m */
    private String f4554m = ActivityPrivacy.class.getSimpleName();

    /* renamed from: o */
    private String[] f4556o = new String[2];

    /* renamed from: p */
    private int f4557p = 0;

    /* renamed from: q */
    private Handler f4558q = new HandlerC1239ar(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_privacy);
        this.f4546e = getActivity();
        this.f4547f = C1789u.m6075a();
        this.f4548g = new C1306dd(this.f4547f);
        this.f4543b = this.f4547f.edit();
        this.f4543b.putBoolean("Lock Check", false);
        Context context = this.f4546e;
        getActivity();
        this.f4544c = (AlarmManager) context.getSystemService("alarm");
        this.f4549h = this.f4546e.getResources().getStringArray(R.array.settings_type_options_value);
        this.f4550i = this.f4546e.getResources().getStringArray(R.array.settings_type_options);
        this.f4555n = m6121a("pref_item_password_lock");
        this.f4556o = m4557a("GET", "", "");
        m4556a(this.f4556o[this.f4557p]);
        try {
            m4546a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m4546a() {
        this.f4551j = C1789u.m6075a().getString("msisdn", "");
        this.f4545d = (CheckBoxPreference) m6121a("phone_number_privacy");
        StringBuilder sb = new StringBuilder();
        this.f4545d.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
        if (this.f4545d.isChecked()) {
            sb.append("+").append(this.f4551j).append("\n").append(getResources().getString(R.string.phone_number_privacy_guide));
        } else {
            sb.append("+").append(this.f4551j).append("\n").append(getResources().getString(R.string.phone_number_privacy_guide_off));
        }
        this.f4545d.setSummary(sb);
        m4548a(this.f4545d.getSummary().toString(), this.f4545d, getResources().getColor(R.color.ics_orange_font_color));
        this.f4545d.setOnPreferenceChangeListener(new C1234am(this));
        m6121a("pref_item_hide").setOnPreferenceClickListener(new C1235an(this));
        m6121a("pref_item_birthday").setOnPreferenceClickListener(new C1236ao(this));
        m6121a("pref_item_buddies_say").setOnPreferenceClickListener(new C1237ap(this));
        m6121a("pref_item_password_lock").setOnPreferenceClickListener(new C1238aq(this));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onActivityResult(i, i2, intent);
        getActivity();
        if (i2 == -1) {
            switch (i) {
                case 2:
                    Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                    if (uri != null) {
                        this.f4543b.putString("Ringtone", uri.toString()).commit();
                        break;
                    } else {
                        this.f4543b.putString("Ringtone", "Ringtone").commit();
                        break;
                    }
                case 3:
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentPasswordLockView(), "container").addToBackStack(ActivitySettings.f4559g).commitAllowingStateLoss();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4548a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    /* renamed from: a */
    public String[] m4557a(String str, String str2, String str3) throws NoSuchAlgorithmException {
        C1786r.m6061b("prePassword", this.f4554m);
        C1786r.m6061b("mode : " + str, this.f4554m);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("password_lock", 0);
        if (str.equals("GET")) {
            C1786r.m6061b("GET preference", this.f4554m);
            strArr[0] = sharedPreferences.getString("app_lock_state", C1781m.m6027d());
            strArr[1] = sharedPreferences.getString("app_lock_password", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C1786r.m6061b("data : " + strArr[i2], this.f4554m);
            }
        } else {
            C1786r.m6061b("SET preference", this.f4554m);
            C1786r.m6061b("state : " + str2, this.f4554m);
            C1786r.m6061b("pass : " + str3, this.f4554m);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM6021b = C1781m.m6021b(str2);
            String strM6021b2 = C1781m.m6021b(str3);
            editorEdit.putString("app_lock_state", strM6021b);
            editorEdit.putString("app_lock_password", strM6021b2);
            editorEdit.commit();
        }
        return strArr;
    }

    /* renamed from: a */
    public void m4556a(String str) {
        C1786r.m6061b("changeSummary", this.f4554m);
        if (str.equals(C1781m.m6025c())) {
            this.f4555n.setSummary(R.string.settings_password_lock_text_on);
        } else {
            this.f4555n.setSummary(R.string.settings_password_lock_text_off);
        }
        m4548a(this.f4555n.getSummary().toString(), this.f4555n, getResources().getColor(R.color.ics_orange_font_color));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4556o = m4557a("GET", "", "");
        m4556a(this.f4556o[this.f4557p]);
    }
}
