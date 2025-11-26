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
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p065io.entry.inner.PrivacyList;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SuggestionsActivity extends BasePreferenceActivity implements View.OnClickListener, Runnable {

    /* renamed from: a */
    private Context f12828a;

    /* renamed from: c */
    private C2128i f12830c;

    /* renamed from: d */
    private C2128i f12831d;

    /* renamed from: e */
    private CheckBoxPreference f12832e;

    /* renamed from: f */
    private CheckBoxPreference f12833f;

    /* renamed from: h */
    private ArrayList<PrivacyList> f12835h;

    /* renamed from: b */
    private C4810ab f12829b = null;

    /* renamed from: g */
    private ProgressDialog f12834g = null;

    /* renamed from: i */
    private Handler f12836i = new HandlerC3652ge(this);

    /* renamed from: j */
    private Handler f12837j = new HandlerC3655gh(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f12828a = this;
        this.f12834g = new ProgressDialogC4926s(this, false);
        this.f12834g.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        addPreferencesFromResource(R.xml.pref_setting_buddies_suggestions);
        this.f12830c = new C2128i(this.f12837j);
        this.f12829b = C4809aa.m18104a();
        this.f12829b.m18125b("Lock Check", (Boolean) false);
        getListView().setScrollingCacheEnabled(false);
        try {
            m13680a();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
        this.f12831d = new C2128i(this.f12836i);
        this.f12831d.m9527f("recommendationbuddy|ignorerecommendation");
        this.f12834g.show();
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
    public void m13683a(String str, String str2) {
        if (str == null || str2 == null) {
            C4904y.m18646e("have no privacy", getClass().getSimpleName());
            return;
        }
        if (str.equals("recommendationbuddy")) {
            if (str2.equals("true")) {
                this.f12832e.setChecked(true);
                this.f12829b.m18125b("recomned_receive", (Boolean) true);
            } else {
                this.f12832e.setChecked(false);
                this.f12829b.m18125b("recomned_receive", (Boolean) false);
            }
            C4904y.m18646e("recommendationbuddy : " + str2, getClass().getSimpleName());
            return;
        }
        if (str.equals("ignorerecommendation")) {
            if (str2.equals("true")) {
                this.f12833f.setChecked(false);
                this.f12829b.m18125b("exclude_me", (Boolean) true);
            } else {
                this.f12833f.setChecked(true);
                this.f12829b.m18125b("exclude_me", (Boolean) false);
            }
            C4904y.m18646e("ignorerecommendation : " + str2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m13680a() {
        this.f12832e = (CheckBoxPreference) findPreference("pref_item_buddy_sugestions");
        this.f12832e.setChecked(this.f12829b.m18119a("recomned_receive", (Boolean) true).booleanValue());
        m13682a(getResources().getString(R.string.settings_suggestions_contact_description), this.f12832e, getResources().getColor(R.color.setting_explain_text));
        this.f12832e.setOnPreferenceChangeListener(new C3653gf(this));
        if (!this.f12829b.m18119a("recomned_special", (Boolean) true).booleanValue()) {
            this.f12829b.m18125b("recomned_special", (Boolean) true);
        }
        this.f12833f = (CheckBoxPreference) findPreference("pref_item_exclude_me");
        this.f12833f.setChecked(!this.f12829b.m18119a("exclude_me", (Boolean) false).booleanValue());
        m13682a(getResources().getString(R.string.manage_buddies_suggest_me_description), this.f12833f, getResources().getColor(R.color.setting_explain_text));
        this.f12833f.setOnPreferenceChangeListener(new C3654gg(this));
        this.f12833f.setTitle(getResources().getString(R.string.manage_buddies_suggest_me));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m13682a(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setSummary(spannableString);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f12834g != null && this.f12834g.isShowing()) {
            this.f12834g.dismiss();
            this.f12834g = null;
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
}
