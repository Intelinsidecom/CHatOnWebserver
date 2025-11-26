package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityBuddyView extends PreferenceListFragment {

    /* renamed from: c */
    C0633e f4458c;

    /* renamed from: d */
    CheckBoxPreference f4459d;

    /* renamed from: e */
    private Context f4460e;

    /* renamed from: a */
    String f4456a = "Settings";

    /* renamed from: f */
    private boolean f4461f = true;

    /* renamed from: g */
    private boolean f4462g = true;

    /* renamed from: h */
    private SharedPreferences f4463h = null;

    /* renamed from: b */
    SharedPreferences.Editor f4457b = null;

    /* renamed from: i */
    private ProgressDialogC1806j f4464i = null;

    /* renamed from: j */
    private Handler f4465j = new HandlerC1329h(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        this.f4464i = new ProgressDialogC1806j(getActivity(), false);
        this.f4464i.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        m6122a(R.xml.layout_setting_buddies);
        this.f4460e = getActivity();
        this.f4458c = new C0633e(this.f4465j);
        this.f4463h = C1789u.m6075a();
        this.f4457b = this.f4463h.edit();
        this.f4457b.putBoolean("Lock Check", false);
        try {
            m4484a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    public void m4491a(String str, CheckBoxPreference checkBoxPreference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        checkBoxPreference.setTitle(spannableString);
    }

    /* renamed from: a */
    private void m4484a() {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) m6121a("pref_item_birthday");
        if (this.f4463h.getBoolean("Profile Birth Chk", true)) {
            this.f4461f = true;
            this.f4457b.putBoolean("Profile Birth Chk", true).commit();
        } else {
            this.f4461f = false;
            this.f4457b.putBoolean("Profile Birth Chk", false).commit();
        }
        checkBoxPreference.setChecked(this.f4461f);
        m4491a(checkBoxPreference.getTitle().toString(), checkBoxPreference, getResources().getColor(R.color.ics_main_font_color_2));
        m4485a(getResources().getString(R.string.setting_birthday_text), (Preference) checkBoxPreference, getResources().getColor(R.color.ics_orange_font_color));
        checkBoxPreference.setOnPreferenceChangeListener(new C1326e(this));
        m6121a("pref_item_blocked").setOnPreferenceClickListener(new C1327f(this));
        m6121a("pref_item_suggestions").setOnPreferenceClickListener(new C1328g(this));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m4485a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
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
