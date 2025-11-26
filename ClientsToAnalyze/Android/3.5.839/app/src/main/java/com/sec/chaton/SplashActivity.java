package com.sec.chaton;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.registration.C3134ac;
import com.sec.chaton.registration.C3299gf;
import com.sec.chaton.registration.InterfaceC3162bd;
import com.sec.chaton.registration.RegisterSMSActivity;
import com.sec.chaton.service.BackGroundRegiService;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import java.io.File;

/* loaded from: classes.dex */
public class SplashActivity extends BaseActivity implements InterfaceC4693u, InterfaceC4876cn {

    /* renamed from: p */
    private static final String f2006p = SplashActivity.class.toString();

    /* renamed from: A */
    private C2132m f2007A;

    /* renamed from: B */
    private boolean f2008B;

    /* renamed from: t */
    private boolean f2018t;

    /* renamed from: x */
    private Context f2022x;

    /* renamed from: y */
    private InterfaceC3162bd f2023y;

    /* renamed from: q */
    private final int f2015q = 1;

    /* renamed from: r */
    private boolean f2016r = false;

    /* renamed from: s */
    private boolean f2017s = false;

    /* renamed from: u */
    private boolean f2019u = false;

    /* renamed from: v */
    private boolean f2020v = false;

    /* renamed from: w */
    private boolean f2021w = false;

    /* renamed from: z */
    private Intent f2024z = null;

    /* renamed from: C */
    private Runnable f2009C = new RunnableC1884cm(this);

    /* renamed from: D */
    private final Handler f2010D = new HandlerC1885cn(this);

    /* renamed from: E */
    private AccountManagerCallback<Bundle> f2011E = new C1886co(this);

    /* renamed from: n */
    HandlerC4826ar f2013n = new HandlerC1887cp(this);

    /* renamed from: F */
    private BroadcastReceiver f2012F = new C1888cq(this);

    /* renamed from: o */
    public Handler f2014o = new HandlerC1889cr(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    /* renamed from: g */
    private void m2985g() {
        C3299gf c3299gf = new C3299gf(this);
        int iM13045e = c3299gf.m13045e();
        if (iM13045e == 1) {
            String strM13046f = c3299gf.m13046f();
            try {
                if (!TextUtils.isEmpty(strM13046f)) {
                    setContentView(R.layout.layout_settings_seasonal_theme);
                    ((ImageView) findViewById(R.id.seasnltheme)).setImageURI(Uri.fromFile(new File(strM13046f)));
                } else {
                    m2986h();
                }
                c3299gf.m13042b();
                return;
            } catch (OutOfMemoryError e) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("displayThemeSplashView :: " + e.toString(), f2006p);
                }
                m2986h();
                return;
            }
        }
        if (iM13045e == 2) {
            m2986h();
            c3299gf.m13043c();
        } else if (iM13045e == 3) {
            m2986h();
            c3299gf.m13044d();
        }
    }

    /* renamed from: h */
    private void m2986h() {
        setContentView(R.layout.layout_settings_starting);
        m2969a(getResources().getConfiguration());
    }

    /* renamed from: c */
    private void m2977c(boolean z) {
        this.f2023y = new C1883cl(this);
        new C3134ac(this, null, this.f2023y).m13036a();
        this.f2018t = true;
    }

    /* renamed from: i */
    private void m2987i() throws PackageManager.NameNotFoundException {
        int iM18394c = C4859bx.m18394c(this.f2022x);
        String strM18389b = C4859bx.m18389b(this.f2022x);
        if (C4904y.f17872b) {
            C4904y.m18639b("[checkSamsungAccountStatus] verSSO : " + iM18394c + " email : " + strM18389b, f2006p);
        }
        if (iM18394c >= 140032) {
            if (!TextUtils.isEmpty(strM18389b)) {
                if (iM18394c >= 150200) {
                    startActivityForResult(C4859bx.m18406f(), 1);
                    this.f2013n.m18262a(30000);
                    return;
                }
                this.f2016r = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_sso_check_validation");
                registerReceiver(this.f2012F, intentFilter);
                C4859bx.m18404e(this.f2022x);
                this.f2013n.m18262a(30000);
                return;
            }
            new Handler().postDelayed(this.f2009C, 300L);
            return;
        }
        new Handler().postDelayed(this.f2009C, 300L);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult : " + i + " , " + i2, f2006p);
        }
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                this.f2013n.m18261a();
                if (i2 != -1) {
                    z = false;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[ActivityResult] Validation : true", f2006p);
                    }
                    this.f2024z.putExtra("is_sa_validated", true);
                }
                C4809aa.m18104a().m18125b("chaton_sa_is_valid", Boolean.valueOf(z));
                m2990l();
                break;
            case 100:
                if (i2 == 11) {
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2007A = new C2132m(this.f2014o);
        this.f2022x = this;
        if (bundle != null) {
            this.f2019u = true;
        }
        Intent intent = getIntent();
        this.f2024z = (Intent) intent.getParcelableExtra("base_intent");
        this.f2021w = intent.getBooleanExtra("regi_from_settings", false);
        if (this.f2021w) {
            m2986h();
            m2970a(bundle);
            m2977c(false);
        } else {
            if (!m2988j()) {
                m2986h();
                m2970a(bundle);
                findViewById(R.id.progress).setVisibility(4);
                findViewById(R.id.loading).setVisibility(4);
                findViewById(R.id.step_comment).setVisibility(0);
                findViewById(R.id.registration_progress).setVisibility(0);
                m2977c(false);
                return;
            }
            m2985g();
            m2970a(bundle);
            m2977c(false);
        }
    }

    /* renamed from: b */
    public void m2992b(boolean z) throws PackageManager.NameNotFoundException {
        if (!z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f2008B = jCurrentTimeMillis >= 1427864400000L;
            if (C4904y.f17872b) {
                C4904y.m18639b("continueToSplash : " + jCurrentTimeMillis + ", need EOS : " + this.f2008B, f2006p);
            }
            if (this.f2008B) {
                new Handler().postDelayed(this.f2009C, 300L);
                return;
            } else {
                m2987i();
                return;
            }
        }
        if (m2989k()) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) BackGroundRegiService.class);
            intent.putExtra("request_type", 0);
            intent.putExtra("request_on_chaton", true);
            GlobalApplication.m18732r().startService(intent);
        }
        if (this.f2020v) {
            this.f2010D.sendMessageDelayed(Message.obtain(this.f2010D, 0, this.f2024z), 300L);
        } else {
            this.f2010D.sendMessage(Message.obtain(this.f2010D, 0, this.f2024z));
        }
        if (GlobalApplication.f8360f == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Application initialize logic isn't execute. execute it now.", f2006p);
            }
            GlobalApplication.f8360f = new AsyncTaskC4563t();
            GlobalApplication.f8360f.m17262a(this);
            GlobalApplication.f8360f.execute(new Void[0]);
            return;
        }
        if (GlobalApplication.f8360f.getStatus() != AsyncTask.Status.FINISHED) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Application initialize logic alrady running.", f2006p);
            }
            GlobalApplication.f8360f.m17262a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C4904y.f17872b) {
            C4904y.m18639b("onConfigurationChanged", f2006p);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (GlobalApplication.f8360f != null) {
            GlobalApplication.f8360f.m17262a(this);
        }
        this.f2010D.removeMessages(0);
        if (this.f2016r && !this.f2017s) {
            this.f2017s = true;
            unregisterReceiver(this.f2012F);
        }
    }

    @Override // com.sec.chaton.InterfaceC4693u
    /* renamed from: a */
    public void mo2991a() {
        if (!this.f2010D.hasMessages(0) && !this.f2018t) {
            this.f2010D.sendMessage(Message.obtain(this.f2010D, 0, this.f2024z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Intent m2974b(Intent intent) {
        return TabActivity.m3016a(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m2988j() {
        return C4809aa.m18104a().m18129b("uid") || C4809aa.m18104a().m18129b("skip_sms_register_now");
    }

    /* renamed from: a */
    private void m2969a(Configuration configuration) {
        if (C4904y.f17872b) {
            C4904y.m18639b("checkScreenMode : " + configuration.orientation, f2006p);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (C4904y.f17872b) {
            C4904y.m18639b("densityDpi : " + displayMetrics.densityDpi + " Config : " + configuration, f2006p);
        }
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            if (1 == defaultDisplay.getRotation()) {
                setRequestedOrientation(0);
                return;
            } else {
                if (3 == defaultDisplay.getRotation()) {
                    setRequestedOrientation(8);
                    return;
                }
                return;
            }
        }
        if (defaultDisplay.getRotation() == 0) {
            setRequestedOrientation(1);
        } else if (2 == defaultDisplay.getRotation()) {
            setRequestedOrientation(9);
        }
    }

    /* renamed from: k */
    private boolean m2989k() {
        return C4809aa.m18104a().m18119a("back_deregi_fail", (Boolean) false).booleanValue();
    }

    public void onWindowStatusChanged(boolean z, boolean z2, boolean z3) {
        if (GlobalApplication.m10288g()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            View decorView = getWindow().getDecorView();
            if (decorView != null && displayMetrics != null) {
                m2971a(decorView, displayMetrics);
            }
        }
    }

    /* renamed from: a */
    private void m2971a(View view, DisplayMetrics displayMetrics) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m2990l() {
        if (this.f2021w) {
            setResult(-1);
            finish();
            return;
        }
        if (C2349a.m10301a("sms_feature")) {
            if (C4822an.m18201K()) {
                Intent intent = new Intent(this, (Class<?>) RegisterSMSActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("base_intent", this.f2024z);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return;
            }
            if (C2349a.m10301a("for_wifi_only_device") || C4822an.m18196F()) {
                if (!this.f2019u) {
                    overridePendingTransition(0, 0);
                    C4809aa.m18104a().m18125b("chaton_auth_from_splash", (Boolean) true);
                    AccountManager.get(this).addAccount(Config.CHATON_PACKAGE_NAME, null, null, null, this, this.f2011E, null);
                    return;
                }
                finish();
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) RegisterSMSActivity.class);
            intent2.setFlags(67108864);
            intent2.putExtra("base_intent", this.f2024z);
            startActivity(intent2);
            overridePendingTransition(0, 0);
            finish();
            return;
        }
        if (!this.f2019u) {
            overridePendingTransition(0, 0);
            C4809aa.m18104a().m18125b("chaton_auth_from_splash", (Boolean) true);
            AccountManager.get(this).addAccount(Config.CHATON_PACKAGE_NAME, null, null, null, this, this.f2011E, null);
            return;
        }
        finish();
    }

    /* renamed from: a */
    private void m2970a(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (!C4822an.m18239h(GlobalApplication.m18732r())) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("isCurrentUserOwner is false", f2006p);
                }
                AbstractC4932a.m18733a(this).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.registration_pop_up_warning_mum_temp, getResources().getString(R.string.app_name))).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1890cs(this)).mo18751b(false).mo18745a().show();
                return;
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("This is owner", f2006p);
                    return;
                }
                return;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("android OS is lower than jelly bean MR1", f2006p);
        }
    }
}
