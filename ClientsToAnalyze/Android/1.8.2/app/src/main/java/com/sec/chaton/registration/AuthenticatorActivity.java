package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    /* renamed from: a */
    public String f4294a;

    /* renamed from: b */
    public String f4295b;

    /* renamed from: c */
    public String f4296c;

    /* renamed from: h */
    private String f4301h;

    /* renamed from: i */
    private String f4302i;

    /* renamed from: j */
    private ImageSwitcher f4303j;

    /* renamed from: k */
    private C0647s f4304k;

    /* renamed from: e */
    private boolean f4298e = false;

    /* renamed from: f */
    private boolean f4299f = false;

    /* renamed from: g */
    private boolean f4300g = false;

    /* renamed from: l */
    private Runnable f4305l = new RunnableC1168av(this);

    /* renamed from: m */
    private Runnable f4306m = new RunnableC1169aw(this);

    /* renamed from: d */
    AsyncTask f4297d = new AsyncTaskC1175bb(this);

    /* renamed from: n */
    private Handler f4307n = new HandlerC1176bc(this);

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (bundle == null) {
            setContentView(R.layout.layout_settings_starting);
            findViewById(R.id.intro_loading).setVisibility(0);
            findViewById(R.id.loading).setVisibility(0);
            findViewById(R.id.logo).setVisibility(0);
            findViewById(R.id.samsung_ltd).setVisibility(0);
            new Handler().postDelayed(this.f4305l, 700L);
        } else if (bundle.getBoolean("isDisclaimer", false)) {
            m4426f();
        } else {
            setContentView(R.layout.layout_settings_starting);
        }
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar().hide();
        }
    }

    /* renamed from: a */
    void m4427a() {
        this.f4303j = (ImageSwitcher) findViewById(R.id.switcher);
        this.f4303j.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        this.f4303j.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        this.f4303j.showNext();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f4300g) {
            super.onBackPressed();
        }
        C1786r.m6061b("[LIFE] onBackPressed, Memory address :" + this + " isSavedInstnace :" + this.f4300g, getClass().getSimpleName());
        this.f4298e = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f4300g) {
            this.f4300g = false;
        }
        C1786r.m6061b("[LIFE] onResume, Memory address :" + this + " isSavedInstnace :" + this.f4300g, getClass().getSimpleName());
    }

    /* renamed from: b */
    public void m4428b() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
        ((Button) findViewById(R.id.setting_about_btn1)).setOnClickListener(new ViewOnClickListenerC1170ax(this));
        ((Button) findViewById(R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC1171ay(this));
        ((Button) findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC1172az(this));
    }

    /* renamed from: a */
    private void m4417a(String str, String str2) {
        Account account = new Account(str, "com.sec.chaton");
        AccountManager.get(getApplicationContext()).addAccountExplicitly(account, str2, null);
        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
        new AsyncTaskC1177bd(null).execute(GlobalApplication.m3260b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4420c() {
        Intent intent = new Intent(this, (Class<?>) ActivityProvisioning.class);
        this.f4294a = C1789u.m6075a().getString("Push Name", "");
        this.f4295b = C1789u.m6075a().getString("msisdn", "");
        intent.putExtra("REG_NAME", this.f4294a);
        intent.putExtra("REG_PNO", this.f4295b);
        C0107h c0107h = new C0107h();
        c0107h.m687c("0000-12-31");
        this.f4304k = new C0647s(this.f4307n);
        this.f4304k.m2963a(c0107h, "DONT");
        startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4422d() {
        Intent intent = new Intent(this, (Class<?>) ActivityRegistPushName.class);
        this.f4295b = C1789u.m6075a().getString("msisdn", "");
        intent.putExtra("REG_PNO", this.f4295b);
        intent.putExtra("REG_AUTH", this.f4302i);
        intent.putExtra("REG_TOKEN", this.f4301h);
        startActivityForResult(intent, 0);
    }

    /* renamed from: e */
    private void m4424e() {
        Intent intent = new Intent();
        this.f4295b = C1789u.m6075a().getString("msisdn", "");
        this.f4296c = C1789u.m6075a().getString("uid", "");
        m4417a(this.f4295b, this.f4296c);
        intent.putExtra("authAccount", this.f4295b);
        intent.putExtra("accountType", "com.sec.chaton");
        intent.putExtra("authtoken", this.f4296c);
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4426f() {
        ActionBar actionBar;
        boolean z = false;
        String strM5883j = C1721ad.m5883j();
        if (TextUtils.isEmpty(strM5883j)) {
            strM5883j = "234";
            z = true;
        }
        String string = C1789u.m6075a().getString("country_letter", "GB");
        if (strM5883j.equals("450") || (string.equals("KR") && z)) {
            startActivityForResult(new Intent(this, (Class<?>) NewDisclaimerView.class), 6);
            return;
        }
        this.f4299f = true;
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.layout_settings_disclaimer);
        m4428b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4300g = true;
        C1786r.m6061b("[LIFE] onSaveInstanceState, Memory address :" + this + " isSavedInstnace :" + this.f4300g, getClass().getSimpleName());
        bundle.putBoolean("isDisclaimer", this.f4299f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C1789u.m6075a().edit().remove("token").commit();
                    C1789u.m6075a().edit().remove("authnum").commit();
                    C1789u.m6075a().edit().remove("acstoken").commit();
                    this.f4294a = intent.getStringExtra("PUSH_NAME");
                    C1789u.m6075a().edit().putString("Push Name", this.f4294a).commit();
                    C1789u.m6075a().edit().putString("provisioning_pushname_status", "DONE").commit();
                    m4420c();
                    break;
                } else if (i2 == 2) {
                    C1789u.m6075a().edit().remove("token").commit();
                    C1789u.m6075a().edit().remove("authnum").commit();
                    C1789u.m6075a().edit().remove("provisioning_selfsms_status").commit();
                    C1789u.m6075a().edit().remove("acstoken").commit();
                    startActivityForResult(new Intent(this, (Class<?>) ActivityRegist.class), 1);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    this.f4295b = intent.getStringExtra("MSISDN");
                    this.f4302i = intent.getStringExtra("AUTH_NUM");
                    this.f4301h = intent.getStringExtra("TOKEN");
                    C1786r.m6061b("mAuthNum" + this.f4302i + "sToken" + this.f4301h + "Auther_SMS_OK", "ChatON");
                    C1789u.m6079a("provisioning_selfsms_status", "DONE");
                    if (!C1789u.m6075a().getString("provisioning_disclaimer_status", "").equals("DONE")) {
                        m4426f();
                        break;
                    } else {
                        m4422d();
                        break;
                    }
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 2:
                if (C1789u.m6075a().contains("skipRegi")) {
                    C1789u.m6075a().edit().remove("skipRegi").commit();
                }
                this.f4296c = C1789u.m6075a().getString("uid", "");
                if (i2 == -1 || !TextUtils.isEmpty(this.f4296c)) {
                    m4424e();
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 4:
                if (C1721ad.m5883j() == null && !C1789u.m6075a().getString("selected_country", "").equals("DONE")) {
                    startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                    break;
                } else {
                    m4426f();
                    break;
                }
                break;
            case 5:
                if (i2 == -1) {
                    C1789u.m6075a().edit().putString("selected_country", "DONE").commit();
                    m4426f();
                    break;
                } else {
                    finish();
                    break;
                }
            case 6:
                if (i2 == -1) {
                    this.f4297d.execute(new Void[0]);
                    C1789u.m6079a("provisioning_disclaimer_status", "DONE");
                    C1789u.m6079a("accept_mcc", C1721ad.m5883j());
                    startActivityForResult(new Intent(this, (Class<?>) ActivityRegist.class), 1);
                    break;
                } else {
                    finish();
                    break;
                }
        }
    }
}
