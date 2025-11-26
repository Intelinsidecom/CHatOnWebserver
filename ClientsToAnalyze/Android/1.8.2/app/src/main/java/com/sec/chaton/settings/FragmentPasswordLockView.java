package com.sec.chaton.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class FragmentPasswordLockView extends PreferenceListFragment implements View.OnClickListener {

    /* renamed from: b */
    private CheckBoxPreference f4624b;

    /* renamed from: c */
    private Preference f4625c;

    /* renamed from: d */
    private Preference f4626d;

    /* renamed from: a */
    private String f4623a = FragmentPasswordLockView.class.getSimpleName();

    /* renamed from: e */
    private int f4627e = 0;

    /* renamed from: f */
    private String[] f4628f = new String[2];

    /* renamed from: g */
    private String f4629g = null;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
        m6122a(R.xml.layout_setting_password_lock);
        this.f4624b = (CheckBoxPreference) m6121a("pref_item_password_lock");
        this.f4625c = m6121a("pref_item_change_password_lock");
        this.f4626d = m6121a("pref_item_hint_password_lock");
        this.f4628f = m4611a("GET", "", "");
        m4610a(this.f4628f[this.f4627e]);
        this.f4624b.setOnPreferenceClickListener(new C1274bz(this));
        this.f4625c.setOnPreferenceClickListener(new C1276ca(this));
        this.f4626d.setOnPreferenceClickListener(new C1277cb(this));
    }

    /* renamed from: a */
    public void m4610a(String str) {
        C1786r.m6061b("changeSummary", this.f4623a);
        this.f4629g = getActivity().getSharedPreferences("password_lock", 0).getString("password_hint", "");
        if ("".equals(this.f4629g)) {
            this.f4626d.setSummary(getResources().getString(R.string.description_for_passlock_hint));
        } else {
            this.f4626d.setSummary(getResources().getString(R.string.description_for_passlock_hint_change));
        }
        if (str.equals(C1781m.m6025c())) {
            this.f4624b.setChecked(true);
            this.f4625c.setEnabled(true);
            this.f4624b.setSummary(R.string.settings_password_lock_text_on);
            m4605a(getString(R.string.settings_password_lock_change), this.f4625c, getResources().getColor(R.color.ics_main_font_color_2));
            m4605a(getString(R.string.label_for_passlock_hint), this.f4626d, getResources().getColor(R.color.ics_main_font_color_2));
            m4607b(this.f4624b.getSummary().toString(), this.f4624b, getResources().getColor(R.color.ics_orange_font_color));
            m4607b(this.f4626d.getSummary().toString(), this.f4626d, getResources().getColor(R.color.ics_orange_font_color));
            return;
        }
        this.f4624b.setChecked(false);
        this.f4625c.setEnabled(false);
        this.f4624b.setSummary(R.string.settings_password_lock_text_off);
        m4605a(getString(R.string.settings_password_lock_change), this.f4625c, getResources().getColor(R.color.dark_gray));
        m4605a(getString(R.string.label_for_passlock_hint), this.f4626d, getResources().getColor(R.color.dark_gray));
        m4607b(this.f4624b.getSummary().toString(), this.f4624b, getResources().getColor(R.color.ics_orange_font_color));
        m4607b(this.f4626d.getSummary().toString(), this.f4626d, getResources().getColor(R.color.dark_gray));
    }

    /* renamed from: a */
    public String[] m4611a(String str, String str2, String str3) throws NoSuchAlgorithmException {
        C1786r.m6061b("prePassword", this.f4623a);
        SharedPreferences sharedPreferencesM6075a = C1789u.m6075a();
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("password_lock", 0);
        if (str.equals("GET")) {
            C1786r.m6061b("GET preference", this.f4623a);
            strArr[0] = sharedPreferences.getString("app_lock_state", C1781m.m6027d());
            strArr[1] = sharedPreferences.getString("app_lock_password", "0000");
            for (int i2 = 0; i2 < 2; i2++) {
                C1786r.m6061b("data : " + strArr[i2], this.f4623a);
            }
        } else {
            C1786r.m6061b("SET preference", this.f4623a);
            C1786r.m6061b("state : " + str2, this.f4623a);
            C1786r.m6061b("pass : " + str3, this.f4623a);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM6021b = C1781m.m6021b(str2);
            String strM6021b2 = C1781m.m6021b(str3);
            editorEdit.putString("app_lock_state", strM6021b);
            editorEdit.putString("app_lock_password", strM6021b2);
            editorEdit.commit();
            C1789u.m6075a().edit().putString("lock_state", str2).commit();
            C1786r.m6061b("LOCK_STATE : " + sharedPreferencesM6075a.getString("lock_state", "default"), this.f4623a);
        }
        return strArr;
    }

    /* renamed from: a */
    private void m4605a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    /* renamed from: b */
    private void m4607b(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6063c("[LIFE] onStart, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
        this.f4628f = m4611a("GET", "", "");
        m4610a(this.f4628f[this.f4627e]);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onStop();
        C1786r.m6063c("[LIFE] onStop, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
        C1786r.m6063c("[LIFE] onDestroy, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, this.f4623a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
