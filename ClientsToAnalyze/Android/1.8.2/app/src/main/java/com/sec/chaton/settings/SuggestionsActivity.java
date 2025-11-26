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
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class SuggestionsActivity extends PreferenceListFragment implements View.OnClickListener, Runnable {

    /* renamed from: b */
    private Context f4744b;

    /* renamed from: g */
    private C0633e f4749g;

    /* renamed from: h */
    private CheckBoxPreference f4750h;

    /* renamed from: i */
    private CheckBoxPreference f4751i;

    /* renamed from: j */
    private CheckBoxPreference f4752j;

    /* renamed from: c */
    private boolean f4745c = true;

    /* renamed from: d */
    private boolean f4746d = true;

    /* renamed from: e */
    private boolean f4747e = false;

    /* renamed from: f */
    private SharedPreferences f4748f = null;

    /* renamed from: a */
    SharedPreferences.Editor f4743a = null;

    /* renamed from: k */
    private ProgressDialogC1806j f4753k = null;

    /* renamed from: l */
    private Handler f4754l = new HandlerC1321ds(this);

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        this.f4748f = C1789u.m6075a();
        this.f4743a = this.f4748f.edit();
        this.f4753k = new ProgressDialogC1806j(getActivity(), false);
        this.f4753k.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        m6122a(R.xml.layout_setting_buddies_suggestions);
        this.f4744b = getActivity();
        this.f4749g = new C0633e(this.f4754l);
        this.f4748f = C1789u.m6075a();
        this.f4743a.putBoolean("Lock Check", false);
        this.f4743a.commit();
        try {
            m4717a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m4717a() {
        this.f4750h = (CheckBoxPreference) m6121a("pref_item_buddy_sugestions");
        if (this.f4748f.getBoolean("recomned_receive", true)) {
            this.f4745c = true;
            this.f4743a.putBoolean("recomned_receive", true);
        } else {
            this.f4745c = false;
            this.f4743a.putBoolean("recomned_receive", false);
        }
        this.f4743a.commit();
        this.f4750h.setChecked(this.f4745c);
        m4718a(getResources().getString(R.string.settings_suggestions_buddy_description), this.f4750h, getResources().getColor(R.color.ics_orange_font_color));
        this.f4750h.setOnPreferenceChangeListener(new C1318dp(this));
        this.f4751i = (CheckBoxPreference) m6121a("pref_item_special_buddy_sugestions");
        if (this.f4748f.getBoolean("recomned_special", true)) {
            this.f4746d = true;
            this.f4743a.putBoolean("recomned_special", true);
        } else {
            this.f4746d = false;
            this.f4743a.putBoolean("recomned_special", false);
        }
        this.f4743a.commit();
        this.f4751i.setChecked(this.f4746d);
        m4718a(getResources().getString(R.string.settings_suggestions_special_buddy_description), this.f4751i, getResources().getColor(R.color.ics_orange_font_color));
        this.f4751i.setOnPreferenceChangeListener(new C1319dq(this));
        this.f4752j = (CheckBoxPreference) m6121a("pref_item_exclude_me");
        if (this.f4748f.getBoolean("exclude_me", false)) {
            this.f4747e = true;
            this.f4743a.putBoolean("exclude_me", true);
        } else {
            this.f4747e = false;
            this.f4743a.putBoolean("exclude_me", false);
        }
        this.f4743a.commit();
        this.f4752j.setChecked(this.f4747e);
        m4718a(getResources().getString(R.string.settings_suggestions_excludeme_description), this.f4752j, getResources().getColor(R.color.ics_orange_font_color));
        this.f4752j.setOnPreferenceChangeListener(new C1320dr(this));
        this.f4751i.setTitle(getResources().getString(R.string.buddy_suggestion_special_buddy));
        this.f4752j.setTitle(getResources().getString(R.string.setting_suggestion_exclude_me));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m4718a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
