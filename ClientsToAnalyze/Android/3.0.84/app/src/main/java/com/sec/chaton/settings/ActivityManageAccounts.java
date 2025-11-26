package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.tellfriends.C2733aj;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ActivityManageAccounts extends PreferenceActivity {

    /* renamed from: e */
    private Preference f8978e;

    /* renamed from: g */
    private String f8980g;

    /* renamed from: h */
    private Context f8981h;

    /* renamed from: i */
    private C2733aj f8982i;

    /* renamed from: j */
    private C2737an f8983j;

    /* renamed from: k */
    private C2739ap f8984k;

    /* renamed from: l */
    private C2735al f8985l;

    /* renamed from: m */
    private SnsSignInOutPreference f8986m;

    /* renamed from: n */
    private SnsSignInOutPreference f8987n;

    /* renamed from: o */
    private SnsSignInOutPreference f8988o;

    /* renamed from: p */
    private SnsSignInOutPreference f8989p;

    /* renamed from: q */
    private ProgressDialog f8990q;

    /* renamed from: a */
    private String f8974a = ActivityManageAccounts.class.getSimpleName();

    /* renamed from: b */
    private final int f8975b = 0;

    /* renamed from: c */
    private final int f8976c = 1;

    /* renamed from: d */
    private final int f8977d = 32665;

    /* renamed from: f */
    private ProgressDialog f8979f = null;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!GlobalApplication.m6456e()) {
            C3225cm.m11337a(this);
            setTheme(0);
        }
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8974a);
        addPreferencesFromResource(R.xml.pref_setting_manage_accounts);
        getListView().setItemsCanFocus(true);
        this.f8978e = findPreference("pref_item_samsung_account");
        this.f8978e.setTitle(R.string.setting_samsung_account);
        this.f8981h = this;
        this.f8980g = C3159aa.m10962a().m10979a("samsung_account_email", "");
        if (C3171am.m11080r()) {
            if (!TextUtils.isEmpty(this.f8980g)) {
                this.f8978e.setTitle(this.f8980g);
            }
            this.f8978e.setWidgetLayoutResource(R.layout.preference_widget_nothing);
            this.f8978e.setSummary(R.string.setting_samsung_account);
        } else {
            this.f8978e.setOnPreferenceClickListener(new C2427ao(this));
        }
        m8973a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        String stringExtra = getIntent().getStringExtra("INTENT_FROM");
        if (GlobalApplication.m6456e() && stringExtra != null && stringExtra.equalsIgnoreCase("TWITTER_SUB_MENU")) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        setResult(-1);
        finish();
        return true;
    }

    /* renamed from: a */
    private void m8973a() {
        this.f8986m = (SnsSignInOutPreference) findPreference("pref_item_facebook");
        this.f8987n = (SnsSignInOutPreference) findPreference("pref_item_twitter");
        this.f8988o = (SnsSignInOutPreference) findPreference("pref_item_weibo");
        this.f8989p = (SnsSignInOutPreference) findPreference("pref_item_renren");
        getPreferenceScreen().removePreference(this.f8986m);
        getPreferenceScreen().removePreference(this.f8987n);
        getPreferenceScreen().removePreference(this.f8988o);
        getPreferenceScreen().removePreference(this.f8989p);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                String stringExtra = null;
                if (intent != null) {
                    stringExtra = intent.getStringExtra("country_code");
                }
                if (i2 == -1) {
                    m8974a(C3159aa.m10962a().m10979a("samsung_account_email", ""));
                    if (stringExtra != null) {
                        C3214cb.m11253a(stringExtra, this.f8981h, true);
                        break;
                    }
                } else if (this.f8979f != null && this.f8979f.isShowing()) {
                    this.f8979f.dismiss();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    String strM10979a = C3159aa.m10962a().m10979a("samsung_account_email", "");
                    m8974a(strM10979a);
                    C3250y.m11450b("email : " + strM10979a, getClass().getSimpleName());
                    break;
                } else {
                    C3250y.m11450b("SIGNING_SSO : result is ERROR", getClass().getSimpleName());
                    break;
                }
            case 32665:
                this.f8982i.mo9768a(i, i2, intent);
                break;
        }
    }

    /* renamed from: a */
    private void m8974a(String str) {
        this.f8978e.setTitle(str);
        this.f8978e.setSummary(R.string.setting_samsung_account);
        this.f8978e.setWidgetLayoutResource(R.layout.preference_widget_nothing);
        this.f8978e.setOnPreferenceClickListener(null);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: b */
    private void m8975b() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8974a);
    }

    @Override // android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8974a);
        String stringExtra = getIntent().getStringExtra("INTENT_FROM");
        if (GlobalApplication.m6456e() && stringExtra != null && stringExtra.equalsIgnoreCase("TWITTER_SUB_MENU")) {
            BaseActivity.m3080a(this);
        }
        m8975b();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8974a);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8974a);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        if (this.f8982i != null) {
            this.f8982i.mo9767a();
        }
        if (this.f8983j != null) {
            this.f8983j.mo9767a();
        }
        if (this.f8984k != null) {
            this.f8984k.mo9767a();
        }
        if (this.f8985l != null) {
            this.f8985l.mo9767a();
        }
        if (this.f8979f != null) {
            this.f8979f.dismiss();
        }
        if (this.f8990q != null) {
            this.f8990q.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(-1);
        finish();
        return true;
    }
}
