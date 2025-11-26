package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityChat extends PreferenceListFragment {

    /* renamed from: c */
    private Context f4468c;

    /* renamed from: e */
    private boolean f4470e;

    /* renamed from: a */
    String f4466a = "Settings";

    /* renamed from: d */
    private SharedPreferences f4469d = null;

    /* renamed from: b */
    SharedPreferences.Editor f4467b = null;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.layout_setting_chats);
        this.f4468c = getActivity();
        this.f4469d = C1789u.m6075a();
        this.f4467b = this.f4469d.edit();
        this.f4467b.putBoolean("Lock Check", false);
        try {
            m4493a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m4493a() {
        m6121a("pref_item_change_background").setOnPreferenceClickListener(new C1330i(this));
        m6121a("pref_item_change_bubble").setOnPreferenceClickListener(new C1331j(this));
        m6121a("pref_item_font_size").setOnPreferenceClickListener(new C1332k(this));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) m6121a("pref_item_enter_key");
        if (this.f4469d.getBoolean("Setting enter key", false)) {
            this.f4470e = true;
            this.f4467b.putBoolean("Setting enter key", true).commit();
        } else {
            this.f4470e = false;
            this.f4467b.putBoolean("Setting enter key", false).commit();
        }
        checkBoxPreference.setChecked(this.f4470e);
        m4494a(getResources().getString(R.string.setting_enter_key_summary_new), checkBoxPreference, getResources().getColor(R.color.ics_orange_font_color));
        checkBoxPreference.setOnPreferenceChangeListener(new C1333l(this));
    }

    /* renamed from: a */
    private void m4494a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
    }
}
