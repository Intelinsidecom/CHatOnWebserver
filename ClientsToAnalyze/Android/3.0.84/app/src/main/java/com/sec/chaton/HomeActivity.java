package com.sec.chaton;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.BackGroundRegiService;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3169ak;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;

/* loaded from: classes.dex */
public class HomeActivity extends BaseActivity implements InterfaceC0047c, InterfaceC1601l, InterfaceC3226cn {

    /* renamed from: a */
    private static final String f698a = HomeActivity.class.getSimpleName();

    /* renamed from: b */
    private C0045a f699b = null;

    /* renamed from: c */
    private final Handler f700c = new HandlerC3252v(this);

    /* renamed from: d */
    private AccountManagerCallback<Bundle> f701d = new C3253w(this);

    /* renamed from: a */
    public static Intent m1157a(Context context) {
        return m1159a(context, false);
    }

    /* renamed from: a */
    public static Intent m1159a(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.setFlags(65536);
        intent.putExtra("skipSplash", z);
        return intent;
    }

    /* renamed from: a */
    public static Intent m1158a(Context context, Intent intent, boolean z) {
        intent.setClass(context, HomeActivity.class);
        intent.setFlags(65536);
        intent.putExtra("skipSplash", z);
        return intent;
    }

    /* renamed from: c */
    private void m1163c(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(C3169ak.f11483d, false);
        boolean booleanExtra2 = intent.getBooleanExtra(C3169ak.f11484e, false);
        if (booleanExtra || m1166d()) {
            C3169ak.m11035a().m11036a(this, C3169ak.f11480a);
        }
        if (booleanExtra2) {
            C3169ak.m11035a().m11036a(this, C3169ak.f11481b);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        m1163c(intent);
        if (m1164c()) {
            C3250y.m11453c("AuthenticatorActivity is requested finish.", getClass().getSimpleName());
            finish();
            return;
        }
        if (!m1166d()) {
            if (bundle == null) {
                if (C1493a.m6463a("chatonv_feature") && m1168f() && C3214cb.m11256a(this)) {
                    this.f699b = new C0045a();
                    if (this.f699b.m55d(this)) {
                        this.f699b.m51a(this, this);
                        C3214cb.m11260b(this, this.f699b);
                    }
                }
                overridePendingTransition(0, 0);
                AccountManager.get(this).addAccount("com.sec.chaton", null, null, null, this, this.f701d, null);
                return;
            }
            finish();
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("skipSplash", false);
        intent.removeExtra("skipSplash");
        if (GlobalApplication.f5515e == null || GlobalApplication.f5515e.getStatus() != AsyncTask.Status.FINISHED) {
            booleanExtra = false;
        }
        if (booleanExtra) {
            startActivity(m1165d(intent));
            finish();
            return;
        }
        setContentView(R.layout.layout_settings_starting);
        m1161a(getResources().getConfiguration());
        if (m1167e()) {
            Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) BackGroundRegiService.class);
            intent2.putExtra("request_type", 0);
            intent2.putExtra("request_on_chaton", true);
            GlobalApplication.m11493l().startService(intent);
        }
        this.f700c.sendMessageDelayed(Message.obtain(this.f700c, 0, intent), 500L);
        if (GlobalApplication.f5515e == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Application initialize logic isn't execute. execute it now.", f698a);
            }
            GlobalApplication.f5515e = new AsyncTaskC1599k();
            GlobalApplication.f5515e.m6776a(this);
            GlobalApplication.f5515e.execute(new Void[0]);
            return;
        }
        if (GlobalApplication.f5515e.getStatus() != AsyncTask.Status.FINISHED) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Application initialize logic alrady running.", f698a);
            }
            GlobalApplication.f5515e.m6776a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (GlobalApplication.f5515e != null) {
            GlobalApplication.f5515e.m6776a((InterfaceC1601l) null);
        }
        this.f700c.removeMessages(0);
        if (C1493a.m6463a("chatonv_feature") && this.f699b != null) {
            this.f699b.m51a(this, (InterfaceC0047c) null);
        }
    }

    @Override // com.sec.chaton.InterfaceC1601l
    /* renamed from: a */
    public void mo1169a() {
        if (!this.f700c.hasMessages(0)) {
            this.f700c.sendMessage(Message.obtain(this.f700c, 0, getIntent()));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C3250y.f11734b) {
            C3250y.m11450b("onConfigurationChanged", f698a);
        }
    }

    /* renamed from: c */
    private boolean m1164c() {
        return getIntent().getBooleanExtra("finish", false);
    }

    /* renamed from: a */
    private void m1161a(Configuration configuration) {
        if (C3250y.f11734b) {
            C3250y.m11450b("checkScreenMode : " + configuration.orientation, f698a);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (C3250y.f11734b) {
            C3250y.m11450b("densityDpi : " + displayMetrics.densityDpi + " Config : " + configuration, f698a);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Intent m1165d(Intent intent) {
        return TabActivity.m1227a(this, intent);
    }

    /* renamed from: d */
    private boolean m1166d() {
        return C3159aa.m10962a().m10987b("uid");
    }

    /* renamed from: e */
    private boolean m1167e() {
        return C3159aa.m10962a().m10977a("back_deregi_fail", (Boolean) false).booleanValue();
    }

    /* renamed from: f */
    private boolean m1168f() {
        return C3159aa.m10962a().m10977a("back_chatonv_deregi_fail", (Boolean) false).booleanValue();
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        C3250y.m11450b("onReceiveRemoveAccount : " + z, f698a);
        if (z) {
            C3159aa.m10962a().m10981a("back_chatonv_deregi_fail");
        }
        if (this.f699b != null) {
            this.f699b.m51a(this, (InterfaceC0047c) null);
            this.f699b = null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
