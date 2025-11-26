package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class ActivityManageAccounts extends BasePreferenceActivity {

    /* renamed from: f */
    private Preference f12523f;

    /* renamed from: h */
    private String f12525h;

    /* renamed from: i */
    private Context f12526i;

    /* renamed from: j */
    private C2075ah f12527j;

    /* renamed from: k */
    private C2095ba f12528k;

    /* renamed from: l */
    private AbstractC4439w f12529l;

    /* renamed from: m */
    private SnsSignInOutPreference f12530m;

    /* renamed from: n */
    private ProgressDialog f12531n;

    /* renamed from: o */
    private InterfaceC4936e f12532o;

    /* renamed from: b */
    private String f12519b = ActivityManageAccounts.class.getSimpleName();

    /* renamed from: c */
    private final int f12520c = 0;

    /* renamed from: d */
    private final int f12521d = 1;

    /* renamed from: e */
    private final int f12522e = 32665;

    /* renamed from: g */
    private ProgressDialog f12524g = null;

    /* renamed from: p */
    private boolean f12533p = false;

    /* renamed from: a */
    Handler f12518a = new HandlerC3504av(this, Looper.getMainLooper());

    /* renamed from: q */
    private InterfaceC4377ac f12534q = new C3514be(this);

    /* renamed from: r */
    private InterfaceC4376ab f12535r = new C3515bf(this);

    @Override // com.sec.chaton.settings.BasePreferenceActivity, com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        C4875cm.m18511a(this);
        setTheme(0);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12519b);
        this.f12527j = new C2075ah(this.f12518a);
        this.f12528k = new C2095ba(this.f12518a);
        addPreferencesFromResource(R.xml.pref_setting_manage_accounts);
        getListView().setItemsCanFocus(true);
        this.f12523f = findPreference("pref_item_samsung_account");
        this.f12523f.setTitle(R.string.setting_samsung_account);
        this.f12526i = this;
        this.f12525h = C4822an.m18254v();
        if (C4822an.m18255w()) {
            if (!TextUtils.isEmpty(this.f12525h)) {
                this.f12523f.setTitle(this.f12525h);
            }
            this.f12523f.setWidgetLayoutResource(R.layout.preference_widget_nothing);
            this.f12523f.setSummary(R.string.setting_samsung_account);
            if (bundle == null) {
                this.f12524g = ProgressDialogC4926s.m18727a(this.f12526i, null, getResources().getString(R.string.dialog_provision_ing));
            }
            this.f12527j.m9312c(null);
        } else {
            this.f12523f.setOnPreferenceClickListener(new C3503au(this));
        }
        m13395a();
    }

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: a */
    private void m13395a() {
        this.f12530m = (SnsSignInOutPreference) findPreference("pref_item_sns_account");
        if (!C4822an.m18197G()) {
            getPreferenceScreen().removePreference(this.f12530m);
            return;
        }
        this.f12530m.m13676a(new C3508az(this));
        if (this.f12529l == null) {
            this.f12529l = AbstractC4439w.m16816a(C4822an.m18198H(), this.f12526i);
        }
        m13400c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m13397b() {
        boolean z = C4822an.m18255w() || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", (String) null));
        if (C4904y.f17872b) {
            C4904y.m18639b("didMappingSAContactSync : " + z, this.f12519b);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13400c() {
        if (this.f12529l.mo16650e() && C4822an.m18197G()) {
            this.f12530m.setTitle(this.f12529l.mo16647b());
            this.f12530m.setSummary(m13393a(C4822an.m18198H()));
            this.f12530m.m13677a(EnumC3651gd.SIGN_IN);
            return;
        }
        this.f12530m.m13677a(EnumC3651gd.SIGN_OUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m13393a(String str) {
        if (C4368e.f15815a.equals(str)) {
            return R.string.tellfriends_via_facebook;
        }
        if (C4368e.f15817c.equals(str)) {
            return R.string.tellfriends_via_weibo;
        }
        if (C4368e.f15819e.equals(str)) {
            return R.string.tellfriends_via_renren;
        }
        if (C4368e.f15816b.equals(str)) {
            return R.string.tellfriends_via_twitter;
        }
        if (C4368e.f15820f.equals(str)) {
            return R.string.tellfriends_via_vkontakte;
        }
        return C4368e.f15818d.equals(str) ? R.string.tellfriends_via_odnoklassniki : R.string.tellfriends_via_facebook;
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                String stringExtra = null;
                if (intent != null) {
                    stringExtra = intent.getStringExtra("country_code");
                }
                if (i2 == -1) {
                    m13396b(C4809aa.m18104a().m18121a("samsung_account_email", ""));
                    if (stringExtra != null) {
                        C4859bx.m18384a(stringExtra, this.f12526i, true);
                        break;
                    }
                } else if (this.f12524g != null && this.f12524g.isShowing()) {
                    this.f12524g.dismiss();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    String strM18121a = C4809aa.m18104a().m18121a("samsung_account_email", "");
                    m13396b(strM18121a);
                    C4904y.m18639b("email : " + strM18121a, getClass().getSimpleName());
                    break;
                } else {
                    C4904y.m18639b("SIGNING_SSO : result is ERROR", getClass().getSimpleName());
                    break;
                }
            case 32665:
                this.f12529l.mo16640a(i, i2, intent);
                break;
        }
    }

    /* renamed from: b */
    private void m13396b(String str) {
        this.f12523f.setTitle(str);
        this.f12523f.setSummary(R.string.setting_samsung_account);
        this.f12523f.setWidgetLayoutResource(R.layout.preference_widget_nothing);
        this.f12523f.setOnPreferenceClickListener(null);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12519b);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12519b);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12519b);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C4904y.m18641c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12519b);
    }

    @Override // com.sec.chaton.settings.BasePreferenceActivity, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        if (this.f12529l != null) {
            this.f12529l.mo16639a();
        }
        if (this.f12524g != null && this.f12524g.isShowing()) {
            this.f12524g.dismiss();
        }
        if (this.f12531n != null && this.f12531n.isShowing()) {
            this.f12531n.dismiss();
        }
        this.f12533p = true;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13402d() {
        if (this.f12531n == null) {
            this.f12531n = ProgressDialog.show(this, null, getString(R.string.dialog_connecting_server));
            this.f12531n.setCancelable(false);
            this.f12531n.setOnKeyListener(new DialogInterfaceOnKeyListenerC3513bd(this));
        } else {
            C4904y.m18639b("showProgressDialog() \t- not null. show", this.f12519b);
            this.f12531n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m13404e() {
        boolean zIsShowing;
        if (this.f12531n != null && (zIsShowing = this.f12531n.isShowing())) {
            C4904y.m18639b("dismissProgressDialog() \t- mProgressDialog : " + this.f12531n + ". isSowing : " + zIsShowing, this.f12519b);
            this.f12531n.dismiss();
            this.f12531n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13405f() {
        m13404e();
        m13408g();
    }

    /* renamed from: g */
    private void m13408g() {
        if (this.f12532o != null && this.f12532o.isShowing()) {
            this.f12532o.dismiss();
            this.f12532o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13410h() {
        if (this.f12532o == null) {
            this.f12532o = AbstractC4932a.m18733a(this.f12526i).mo18740a(getResources().getString(R.string.ams_attention_title)).mo18749b(getResources().getString(R.string.dev_network_error)).mo18751b(false).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3516bg(this)).mo18745a();
        }
        if (!this.f12533p) {
            this.f12532o.show();
        }
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
