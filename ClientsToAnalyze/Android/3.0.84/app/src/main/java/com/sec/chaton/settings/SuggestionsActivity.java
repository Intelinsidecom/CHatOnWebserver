package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SuggestionsActivity extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: a */
    private Context f9253a;

    /* renamed from: e */
    private C1330h f9257e;

    /* renamed from: f */
    private C1330h f9258f;

    /* renamed from: g */
    private CheckBoxPreference f9259g;

    /* renamed from: h */
    private CheckBoxPreference f9260h;

    /* renamed from: j */
    private ArrayList<PrivacyList> f9262j;

    /* renamed from: b */
    private boolean f9254b = true;

    /* renamed from: c */
    private boolean f9255c = false;

    /* renamed from: d */
    private C3160ab f9256d = null;

    /* renamed from: i */
    private ProgressDialog f9261i = null;

    /* renamed from: k */
    private Handler f9263k = new HandlerC2695fe(this);

    /* renamed from: l */
    private Handler f9264l = new HandlerC2698fh(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f9253a = this;
        this.f9261i = new ProgressDialogC3265l(this, false);
        this.f9261i.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        addPreferencesFromResource(R.xml.pref_setting_buddies_suggestions);
        this.f9257e = new C1330h(this.f9264l);
        this.f9256d = C3159aa.m10962a();
        this.f9256d.m10983b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m9192a();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        this.f9258f = new C1330h(this.f9263k);
        this.f9258f.m5753g("recommendationbuddy|ignorerecommendation");
        this.f9261i.show();
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9195a(String str, String str2) {
        if (str == null || str2 == null) {
            C3250y.m11456e("have no privacy", getClass().getSimpleName());
            return;
        }
        if (str.equals("recommendationbuddy")) {
            if (str2.equals("true")) {
                this.f9259g.setChecked(true);
                this.f9256d.m10983b("recomned_receive", (Boolean) true);
            } else {
                this.f9259g.setChecked(false);
                this.f9256d.m10983b("recomned_receive", (Boolean) false);
            }
            C3250y.m11456e("recommendationbuddy : " + str2, getClass().getSimpleName());
            return;
        }
        if (str.equals("ignorerecommendation")) {
            if (str2.equals("true")) {
                this.f9260h.setChecked(false);
                this.f9256d.m10983b("exclude_me", (Boolean) true);
            } else {
                this.f9260h.setChecked(true);
                this.f9256d.m10983b("exclude_me", (Boolean) false);
            }
            C3250y.m11456e("ignorerecommendation : " + str2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m9192a() {
        this.f9259g = (CheckBoxPreference) findPreference("pref_item_buddy_sugestions");
        if (this.f9256d.m10977a("recomned_receive", (Boolean) true).booleanValue()) {
            this.f9254b = true;
            this.f9256d.m10983b("recomned_receive", (Boolean) true);
        } else {
            this.f9254b = false;
            this.f9256d.m10983b("recomned_receive", (Boolean) false);
        }
        this.f9259g.setChecked(this.f9254b);
        m9194a(getResources().getString(R.string.settings_suggestions_buddy_description), this.f9259g, getResources().getColor(R.color.setting_explain_text));
        this.f9259g.setOnPreferenceChangeListener(new C2696ff(this));
        if (!this.f9256d.m10977a("recomned_special", (Boolean) true).booleanValue()) {
            this.f9256d.m10983b("recomned_special", (Boolean) true);
        }
        this.f9260h = (CheckBoxPreference) findPreference("pref_item_exclude_me");
        if (this.f9256d.m10977a("exclude_me", (Boolean) true).booleanValue()) {
            this.f9255c = false;
            this.f9256d.m10983b("exclude_me", (Boolean) true);
        } else {
            this.f9255c = true;
            this.f9256d.m10983b("exclude_me", (Boolean) false);
        }
        this.f9260h.setChecked(!this.f9255c);
        m9194a(getResources().getString(R.string.manage_buddies_suggest_me_description), this.f9260h, getResources().getColor(R.color.setting_explain_text));
        this.f9260h.setOnPreferenceChangeListener(new C2697fg(this));
        this.f9260h.setTitle(getResources().getString(R.string.manage_buddies_suggest_me));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m9194a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f9261i != null && this.f9261i.isShowing()) {
            this.f9261i.dismiss();
            this.f9261i = null;
        }
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
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
}
