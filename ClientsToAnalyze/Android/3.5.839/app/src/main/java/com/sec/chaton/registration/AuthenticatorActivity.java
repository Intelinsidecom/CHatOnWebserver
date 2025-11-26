package com.sec.chaton.registration;

import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.NewSPPUpgradeDialog;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.SplashActivity;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.samsungaccount.AutoRegiSamsungAccountActivity;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    /* renamed from: a */
    public String f11569a;

    /* renamed from: b */
    public String f11570b;

    /* renamed from: g */
    private String f11575g;

    /* renamed from: h */
    private String f11576h;

    /* renamed from: i */
    private C2122ca f11577i;

    /* renamed from: j */
    private C2132m f11578j;

    /* renamed from: k */
    private C2122ca f11579k;

    /* renamed from: l */
    private Context f11580l;

    /* renamed from: m */
    private InterfaceC4936e f11581m;

    /* renamed from: u */
    private InterfaceC4936e f11589u;

    /* renamed from: e */
    private boolean f11573e = false;

    /* renamed from: f */
    private boolean f11574f = false;

    /* renamed from: n */
    private ProgressDialog f11582n = null;

    /* renamed from: o */
    private boolean f11583o = false;

    /* renamed from: p */
    private boolean f11584p = false;

    /* renamed from: q */
    private boolean f11585q = false;

    /* renamed from: r */
    private boolean f11586r = false;

    /* renamed from: s */
    private int f11587s = 0;

    /* renamed from: t */
    private int f11588t = 0;

    /* renamed from: v */
    private boolean f11590v = false;

    /* renamed from: w */
    private boolean f11591w = false;

    /* renamed from: x */
    private boolean f11592x = false;

    /* renamed from: y */
    private String f11593y = AuthenticatorActivity.class.getSimpleName();

    /* renamed from: c */
    AsyncTask<Void, Void, Void> f11571c = new AsyncTaskC3311r(this);

    /* renamed from: d */
    public Handler f11572d = new HandlerC3312s(this);

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate Mode :" + getResources().getConfiguration().orientation + ", isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f11593y);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f11592x = intent.getExtras().getBoolean("key_skip_contact_sync");
        }
        this.f11580l = this;
        this.f11577i = new C2122ca(this.f11572d);
        this.f11578j = new C2132m(this.f11572d);
        this.f11579k = new C2122ca(this.f11572d);
        if (m12796a(bundle)) {
            if (bundle == null) {
                finish();
            }
        } else {
            if (!C4809aa.m18104a().m18119a("chaton_auth_from_splash", (Boolean) false).booleanValue()) {
                C4904y.m18639b("[LIFE] onCreate PREF_AUTH_FROM_SPLASH", this.f11593y);
                Intent intent2 = new Intent(this, (Class<?>) SplashActivity.class);
                intent2.putExtra("base_intent", intent);
                intent2.putExtra("regi_from_settings", true);
                startActivityForResult(intent2, 21);
                return;
            }
            m12813a();
            m12800b(bundle);
        }
    }

    /* renamed from: a */
    private boolean m12796a(Bundle bundle) {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        if (AccountManager.get(CommonApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0) {
            String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
            String strM18121a2 = C4809aa.m18104a().m18121a("samsung_account_email", "");
            String strM18121a3 = C4809aa.m18104a().m18121a("uid", "");
            if (!TextUtils.isEmpty(strM18121a)) {
                C4859bx.m18385a(strM18121a, strM18121a3, true);
            } else if (!TextUtils.isEmpty(strM18121a2)) {
                C4859bx.m18385a(strM18121a2, strM18121a3, false);
            }
        }
        if (!C2349a.m10301a("auto_regi_feature")) {
            return true;
        }
        if (C4809aa.m18104a().m18129b("back_regi_status")) {
            startActivity(TabActivity.m3014a(this.f11580l));
            return true;
        }
        if (bundle != null) {
            return true;
        }
        C5179v.m19810a(this, R.string.regist_already_regist, 0).show();
        return true;
    }

    /* renamed from: b */
    private void m12800b(Bundle bundle) {
        this.f11584p = C4809aa.m18104a().m18119a("chaton_sa_is_valid", (Boolean) false).booleanValue();
        if (bundle == null) {
            m12799b();
        } else if (bundle.getBoolean("isDisclaimer", false)) {
            m12814a(102);
        }
    }

    /* renamed from: a */
    void m12813a() {
        if (C4809aa.m18104a().m18129b("provisioning_account_login")) {
            return;
        }
        if (C4809aa.m18104a().m18121a("provisioning_pushname_status", "").equals("DONE") || C4809aa.m18104a().m18121a("provisioning_disclaimer_status", "").equals("DONE")) {
            C4904y.m18639b("Previous version is under multi device", this.f11593y);
            C4809aa.m18104a().m18123a("provisioning_pushname_status");
            C4809aa.m18104a().m18123a("provisioning_disclaimer_status");
            C4809aa.m18104a().m18123a("provisioning_selfsms_status");
            C4809aa.m18104a().m18123a("skipRegi");
            C4809aa.m18104a().m18123a("authnum");
        }
    }

    public void onWindowStatusChanged(boolean z, boolean z2, boolean z3) {
        if (GlobalApplication.m10288g()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            View decorView = getWindow().getDecorView();
            if (decorView != null && displayMetrics != null) {
                m12792a(decorView, displayMetrics);
            }
        }
    }

    /* renamed from: a */
    private void m12792a(View view, DisplayMetrics displayMetrics) {
        ImageView imageView = (ImageView) view.findViewById(R.id.logo_on);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.logo_text);
        double d = view.getLayoutParams().width / displayMetrics.widthPixels;
        double d2 = view.getLayoutParams().height / displayMetrics.heightPixels;
        if (d <= 0.0d || d2 <= 0.0d) {
            imageView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_width);
            imageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_height);
            imageView2.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_width);
            imageView2.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_height);
            return;
        }
        imageView.getLayoutParams().width = (int) (r6.width * d);
        imageView.getLayoutParams().height = (int) (r0.height * d2);
        imageView2.getLayoutParams().width = (int) (d * r0.width);
        imageView2.getLayoutParams().height = (int) (r0.height * d2);
    }

    /* renamed from: b */
    private void m12799b() {
        boolean z = C2349a.m10301a("for_wifi_only_device") || C4822an.m18196F();
        if (!this.f11573e) {
            if (z || (this.f11584p && C4809aa.m18104a().m18120a("provisioning_state", (Integer) 100).intValue() != 105)) {
                if (z) {
                    startActivityForResult(new Intent(this, (Class<?>) MainActivity.class), 5);
                } else {
                    startActivityForResult(new Intent(this, (Class<?>) AutoRegiSamsungAccountActivity.class), 5);
                }
                overridePendingTransition(0, 0);
            } else {
                C4809aa.m18108a("provisioning_account_login", "PHONE");
                C4904y.m18639b("[PHONE SMS]", "ChatON");
                this.f11587s = C4809aa.m18104a().m18120a("provisioning_state", (Integer) 100).intValue();
                if (this.f11587s != 100) {
                    m12814a(this.f11587s);
                } else if (C4822an.m18243k() == null) {
                    m12814a(101);
                } else {
                    m12814a(102);
                }
            }
            this.f11573e = false;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f11574f) {
            super.onBackPressed();
        }
        C4904y.m18639b("[LIFE] onBackPressed, Memory address :" + this + " isSavedInstnace :" + this.f11574f, this.f11593y);
        this.f11573e = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f11574f) {
            this.f11574f = false;
        }
        C4904y.m18639b("[LIFE] onResume, Memory address :" + this + " isSavedInstnace :" + this.f11574f, this.f11593y);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4904y.m18639b("onConfigurationChanged", this.f11593y);
    }

    /* renamed from: c */
    private void m12802c() {
        Intent intent = new Intent();
        this.f11569a = C4809aa.m18104a().m18121a("msisdn", "");
        this.f11570b = C4809aa.m18104a().m18121a("uid", "");
        C4859bx.m18385a(this.f11569a, this.f11570b, true);
        intent.putExtra("authAccount", this.f11569a);
        intent.putExtra("accountType", Config.CHATON_PACKAGE_NAME);
        intent.putExtra("authtoken", this.f11570b);
        m12791a(intent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4809aa.m18104a().m18123a("chaton_auth_from_splash");
        if (this.f11581m != null && this.f11581m.isShowing()) {
            this.f11581m.dismiss();
        }
        m12805e();
        if (this.f11589u != null && this.f11589u.isShowing()) {
            this.f11589u.dismiss();
        }
        this.f11580l = null;
        this.f11591w = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f11574f = true;
        C4904y.m18639b("[LIFE] onSaveInstanceState, Memory address :" + this + " isSavedInstnace :" + this.f11574f, this.f11593y);
    }

    /* renamed from: a */
    protected void m12814a(int i) {
        C4809aa.m18106a("provisioning_state", Integer.valueOf(i));
        switch (i) {
            case 101:
                startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 4);
                break;
            case 102:
                String strM18236g = C4822an.m18236g();
                if (!TextUtils.isEmpty(strM18236g)) {
                    strM18236g = strM18236g.toUpperCase();
                }
                if (!C4859bx.m18387a(strM18236g, this)) {
                    String strM18243k = C4822an.m18243k();
                    String strM18121a = C4809aa.m18104a().m18121a("country_letter", "GB");
                    if (TextUtils.isEmpty(strM18243k)) {
                        strM18243k = "234";
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[CallNextStage(102);] SCC : " + strM18121a + " MCC : " + strM18243k, this.f11593y);
                    }
                    if (strM18243k.equals("450") || strM18121a.equals("KR")) {
                        startActivityForResult(new Intent(this, (Class<?>) ActivityDisclaimerKR.class), 2);
                        break;
                    } else {
                        startActivityForResult(new Intent(this, (Class<?>) ActivityDisclaimerGlobal.class), 2);
                        break;
                    }
                }
                break;
            case 103:
                Intent intent = new Intent(this, (Class<?>) ActivityRegist.class);
                intent.putExtra(FragmentRegist.f11705a, true);
                intent.putExtra(FragmentRegist.f11706b, true);
                startActivityForResult(intent, 1);
                break;
            case 104:
                Intent intent2 = new Intent(this, (Class<?>) ActivitySignInWithAccount.class);
                intent2.putExtra("is_sns_mode", true);
                startActivityForResult(intent2, 10);
                break;
            case 105:
                Intent intent3 = new Intent(this, (Class<?>) ActivityRegistPushName.class);
                this.f11569a = C4809aa.m18104a().m18121a("msisdn", "");
                intent3.putExtra("REG_PNO", this.f11569a);
                startActivityForResult(intent3, 0);
                break;
            default:
                if (C4904y.f17874d) {
                    C4904y.m18645d("requestStage is NOT available", this.f11593y);
                }
                finish();
                break;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C4904y.m18646e("push name was finished and skip sync ", "runProvisioning");
                    if (C4809aa.m18104a().m18121a("provisioning_selfsms_status", "").equals("DONE")) {
                        m12802c();
                        break;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("accountManagerResponse", 5);
                        m12791a(intent2);
                        break;
                    }
                } else if (i2 == 7) {
                    C4809aa.m18104a().m18123a("token");
                    C4809aa.m18104a().m18123a("authnum");
                    C4809aa.m18104a().m18123a("provisioning_selfsms_status");
                    C4809aa.m18104a().m18123a("acstoken");
                    Intent intent3 = new Intent(this, (Class<?>) ActivityRegist.class);
                    intent3.putExtra(FragmentRegist.f11705a, true);
                    startActivityForResult(intent3, 1);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    if (intent != null) {
                        this.f11569a = intent.getStringExtra("MSISDN");
                        this.f11576h = intent.getStringExtra("AUTH_NUM");
                        this.f11575g = intent.getStringExtra("TOKEN");
                        C4904y.m18639b("mAuthNum" + this.f11576h + "sToken" + this.f11575g + "Auther_SMS_OK", "ChatON");
                    }
                    C4809aa.m18105a("prov_phone", (Boolean) true);
                    m12814a(105);
                    break;
                } else if (i2 == 0) {
                    C4809aa.m18108a("provisioning_selfsms_status", "CANCEL");
                    finish();
                    break;
                } else if (i2 == 2) {
                    C4809aa.m18104a().m18123a("prov_phone");
                    C4809aa.m18104a().m18123a("provisioning_selfsms_status");
                    C4809aa.m18104a().m18123a("provisioning_select_bridge");
                    C4809aa.m18104a().m18123a("provisioning_disclaimer_status");
                    m12814a(102);
                    break;
                } else if (i2 == 3) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[Skip Registration]", this.f11593y);
                    }
                    m12814a(105);
                    break;
                } else if (i2 == 6) {
                    m12814a(104);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                }
                break;
            case 2:
                if (i2 == -1) {
                    m12814a(103);
                    break;
                } else if (i2 == 2) {
                    if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("country_letter", ""))) {
                        finish();
                        break;
                    } else {
                        m12814a(101);
                        break;
                    }
                } else {
                    finish();
                    break;
                }
            case 4:
                if (i2 == -1) {
                    m12814a(102);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 5:
                if (i2 == -1) {
                    C4904y.m18639b("[SamsungAccount] LogIn", this.f11593y);
                    C4809aa.m18108a("provisioning_account_login", "DONE");
                    m12814a(105);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                } else if (i2 == 3) {
                    C4904y.m18639b("[Skip SMS]", "ChatON");
                    m12814a(105);
                    break;
                } else if (i2 == 6) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("accountManagerResponse", 5);
                    m12791a(intent4);
                    break;
                } else if (i2 == 4) {
                    if (this.f11592x) {
                        Intent intent5 = new Intent();
                        intent5.putExtra("accountManagerResponse", 5);
                        m12791a(intent5);
                        break;
                    } else if (!C2349a.m10301a("for_wifi_only_device") && !C4822an.m18196F()) {
                        Intent intent6 = new Intent(this.f11580l, (Class<?>) ActivityRegist.class);
                        intent6.putExtra(FragmentRegist.f11708d, true);
                        intent6.putExtra(FragmentRegist.f11706b, true);
                        startActivityForResult(intent6, 8);
                        break;
                    } else {
                        Intent intent7 = new Intent();
                        intent7.putExtra("accountManagerResponse", 5);
                        m12791a(intent7);
                        break;
                    }
                } else if (i2 == 2) {
                    m12814a(103);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                }
                break;
            case 7:
                if (i2 == -1) {
                    C4809aa.m18104a().m18128b("provisioning_sns_login_state", "DONE");
                    C4904y.m18646e("connect sns accounts finished", "runProvisioning");
                    Intent intent8 = new Intent();
                    intent8.putExtra("accountManagerResponse", 5);
                    m12791a(intent8);
                    break;
                } else if (i2 == 2) {
                    C4809aa.m18104a().m18123a("provisioning_disclaimer_status");
                    m12814a(102);
                    break;
                } else if (i2 == 3) {
                    C4809aa.m18104a().m18128b("provisioning_sns_login_state", "DONE");
                    m12814a(105);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    C4809aa.m18104a().m18128b("provisioning_sns_login_state", "CANCEL");
                    finish();
                    break;
                }
            case 8:
                if (i2 == -1) {
                    Intent intent9 = new Intent();
                    intent9.putExtra("accountManagerResponse", 5);
                    C4809aa.m18104a().m18125b("first_time_after_regi", (Boolean) true);
                    m12791a(intent9);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                } else if (i2 == 3) {
                    startActivity(new Intent(this, (Class<?>) TabActivity.class));
                    finish();
                    break;
                }
                break;
            case 10:
                if (i2 == 6 || i2 == 4) {
                    Intent intent10 = new Intent();
                    intent10.putExtra("accountManagerResponse", 5);
                    m12791a(intent10);
                    finish();
                    break;
                } else if (i2 == 2) {
                    m12814a(103);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 21:
                if (i2 == -1) {
                    m12813a();
                    m12800b((Bundle) null);
                    break;
                } else {
                    finish();
                    break;
                }
            case 100:
                if (!this.f11591w) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12795a(EnumC3316w enumC3316w, String str) {
        m12805e();
        if (C4904y.f17872b) {
            C4904y.m18639b("network error, type : " + enumC3316w.toString() + " errorCode : " + str, this.f11593y);
        }
        if (GlobalApplication.m18732r() != null && this.f11580l != null) {
            InterfaceC4936e interfaceC4936eMo18745a = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11580l).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.error_code_common), str)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3314u(this, enumC3316w)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3313t(this)), this, str).mo18745a();
            if (!this.f11591w) {
                interfaceC4936eMo18745a.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12803d() {
        this.f11582n = ProgressDialogC4926s.m18727a(this.f11580l, null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12805e() {
        if (this.f11582n != null && this.f11582n.isShowing()) {
            this.f11582n.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12807f() {
        if (!MainActivity.m13087a(this.f11580l)) {
            this.f11577i.m9470a("FIRST");
            return;
        }
        if (!this.f11586r) {
            m12805e();
            this.f11586r = true;
            Intent intent = new Intent(this.f11580l, (Class<?>) NewSPPUpgradeDialog.class);
            intent.putExtra("isCritical", false);
            intent.putExtra("isFromHome", false);
            startActivity(intent);
            return;
        }
        this.f11577i.m9470a("FIRST");
    }

    /* renamed from: a */
    private void m12791a(Intent intent) {
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }
}
