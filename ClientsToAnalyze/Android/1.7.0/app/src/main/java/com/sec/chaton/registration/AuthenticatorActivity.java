package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    /* renamed from: a */
    public String f3269a;

    /* renamed from: b */
    public String f3270b;

    /* renamed from: c */
    public String f3271c;

    /* renamed from: d */
    public ImageView f3272d;

    /* renamed from: e */
    public ImageView f3273e;

    /* renamed from: i */
    private String f3277i;

    /* renamed from: j */
    private String f3278j;

    /* renamed from: k */
    private ImageSwitcher f3279k;

    /* renamed from: f */
    private boolean f3274f = false;

    /* renamed from: g */
    private boolean f3275g = false;

    /* renamed from: h */
    private boolean f3276h = false;

    /* renamed from: l */
    private Runnable f3280l = new RunnableC0936ah(this);

    /* renamed from: m */
    private Runnable f3281m = new RunnableC0938aj(this);

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate Mode :" + getResources().getConfiguration().orientation + ", isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (bundle == null) {
            setContentView(R.layout.layout_settings_starting);
            this.f3272d = (ImageView) findViewById(R.id.logo_off);
            this.f3273e = (ImageView) findViewById(R.id.logo_on);
            m3740a(getResources().getConfiguration());
            findViewById(R.id.progress).setVisibility(8);
            findViewById(R.id.loading).setVisibility(8);
            View viewFindViewById = findViewById(R.id.logo_differerent_for_canada);
            if (viewFindViewById != null && getResources().getBoolean(R.bool.is_canada_overlay)) {
                viewFindViewById.setVisibility(4);
            }
            new Handler().postDelayed(this.f3280l, 700L);
            return;
        }
        if (bundle.getBoolean("isDisclaimer", false)) {
            m3738f();
        } else {
            setContentView(R.layout.layout_settings_starting);
        }
    }

    /* renamed from: a */
    void m3740a(Configuration configuration) {
        if (this.f3272d != null && this.f3273e != null) {
            if (configuration.orientation == 2) {
                this.f3272d.setImageResource(R.drawable.intro_icon_off_h);
                this.f3273e.setImageResource(R.drawable.intro_icon_on_h);
            } else {
                this.f3272d.setImageResource(R.drawable.intro_icon_off);
                this.f3273e.setImageResource(R.drawable.intro_icon_on);
            }
        }
    }

    /* renamed from: a */
    void m3739a() {
        this.f3279k = (ImageSwitcher) findViewById(R.id.switcher);
        this.f3279k.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        this.f3279k.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        this.f3279k.showNext();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f3276h) {
            super.onBackPressed();
        }
        C1341p.m4658b("[LIFE] onBackPressed, Memory address :" + this + " isSavedInstnace :" + this.f3276h, getClass().getSimpleName());
        this.f3274f = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f3276h) {
            this.f3276h = false;
        }
        C1341p.m4658b("[LIFE] onResume, Memory address :" + this + " isSavedInstnace :" + this.f3276h, getClass().getSimpleName());
    }

    /* renamed from: b */
    public void m3741b() {
        ((GeneralHeaderView) findViewById(R.id.txt_title)).setMarquee();
        Button button = (Button) findViewById(R.id.setting_about_btn1);
        button.setFocusable(true);
        button.requestFocus();
        button.setOnClickListener(new ViewOnClickListenerC0939ak(this));
        ((Button) findViewById(R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC0940al(this));
        ((Button) findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC0941am(this));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1341p.m4658b("onConfigurationChanged", getClass().getSimpleName());
        m3740a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3729a(String str, String str2) {
        Account account = new Account(str, "com.sec.chaton");
        AccountManager.get(getApplicationContext()).addAccountExplicitly(account, str2, null);
        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
        new AsyncTaskC0982n(null).execute(GlobalApplication.m3100a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3732c() {
        Intent intent = new Intent(this, (Class<?>) ActivityProvisioning.class);
        this.f3269a = C1323bs.m4575a().getString("Push Name", "");
        this.f3270b = C1323bs.m4575a().getString("msisdn", "");
        intent.putExtra("REG_NAME", this.f3269a);
        intent.putExtra("REG_PNO", this.f3270b);
        startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3734d() {
        Intent intent = new Intent(this, (Class<?>) ActivityRegistPushName.class);
        this.f3270b = C1323bs.m4575a().getString("msisdn", "");
        intent.putExtra("REG_PNO", this.f3270b);
        intent.putExtra("REG_AUTH", this.f3278j);
        intent.putExtra("REG_TOKEN", this.f3277i);
        startActivityForResult(intent, 0);
    }

    /* renamed from: e */
    private void m3736e() {
        Intent intent = new Intent();
        this.f3270b = C1323bs.m4575a().getString("msisdn", "");
        this.f3271c = C1323bs.m4575a().getString("uid", "");
        m3729a(this.f3270b, this.f3271c);
        intent.putExtra("authAccount", this.f3270b);
        intent.putExtra("accountType", "com.sec.chaton");
        intent.putExtra("authtoken", this.f3271c);
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3738f() {
        setContentView(R.layout.layout_settings_disclaimer);
        this.f3275g = true;
        m3741b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3276h = true;
        C1341p.m4658b("[LIFE] onSaveInstanceState, Memory address :" + this + " isSavedInstnace :" + this.f3276h, getClass().getSimpleName());
        bundle.putBoolean("isDisclaimer", this.f3275g);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C1323bs.m4579a("registration_mcc", C1336k.m4630g());
                    C1323bs.m4575a().edit().remove("token").commit();
                    C1323bs.m4575a().edit().remove("authnum").commit();
                    C1323bs.m4575a().edit().remove("acstoken").commit();
                    this.f3269a = intent.getStringExtra("PUSH_NAME");
                    C1323bs.m4575a().edit().putString("Push Name", this.f3269a).commit();
                    C1323bs.m4575a().edit().putString("provisioning_pushname_status", "DONE").commit();
                    C0684a.m3050b();
                    C1341p.m4662e("FacebookAvailableCheck() ", "runProvisioning");
                    m3732c();
                    break;
                } else if (i2 == 2) {
                    C1323bs.m4575a().edit().remove("token").commit();
                    C1323bs.m4575a().edit().remove("authnum").commit();
                    C1323bs.m4575a().edit().remove("provisioning_selfsms_status").commit();
                    C1323bs.m4575a().edit().remove("acstoken").commit();
                    startActivityForResult(new Intent(this, (Class<?>) ActivityRegist.class), 1);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    this.f3270b = intent.getStringExtra("MSISDN");
                    this.f3278j = intent.getStringExtra("AUTH_NUM");
                    this.f3277i = intent.getStringExtra("TOKEN");
                    C1341p.m4658b("mAuthNum" + this.f3278j + "sToken" + this.f3277i + "Auther_SMS_OK", "ChatON");
                    C1323bs.m4579a("provisioning_selfsms_status", "DONE");
                    if (!C1323bs.m4575a().getString("provisioning_disclaimer_status", "").equals("DONE")) {
                        m3738f();
                        break;
                    } else {
                        m3734d();
                        break;
                    }
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 2:
                if (C1323bs.m4575a().contains("wasSMSregi")) {
                    C1323bs.m4575a().edit().remove("wasSMSregi").commit();
                }
                C1323bs.m4579a("first_disclaimer_status", "DONE");
                this.f3271c = C1323bs.m4575a().getString("uid", "");
                if (i2 == -1 || !TextUtils.isEmpty(this.f3271c)) {
                    m3736e();
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 4:
                if (i2 == -1) {
                    if (C1336k.m4630g() == null && !C1323bs.m4575a().getString("selected_country", "").equals("DONE")) {
                        startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                        break;
                    } else {
                        m3738f();
                        break;
                    }
                } else {
                    finish();
                    break;
                }
                break;
            case 5:
                if (i2 == -1) {
                    C1323bs.m4575a().edit().putString("selected_country", "DONE").commit();
                    m3738f();
                    break;
                } else {
                    finish();
                    break;
                }
        }
    }
}
