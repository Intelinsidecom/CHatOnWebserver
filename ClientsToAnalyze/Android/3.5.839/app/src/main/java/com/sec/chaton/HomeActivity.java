package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4820al;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4876cn;

/* loaded from: classes.dex */
public class HomeActivity extends BaseActivity implements InterfaceC4876cn {

    /* renamed from: n */
    private static final String f1954n = HomeActivity.class.getSimpleName();

    /* renamed from: a */
    public static Intent m2912a(Context context) {
        return m2915a(context, false);
    }

    @Deprecated
    /* renamed from: a */
    public static Intent m2915a(Context context, boolean z) {
        return m2913a(context, z ? 1 : 0);
    }

    /* renamed from: a */
    public static Intent m2913a(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.setFlags(65536);
        intent.putExtra("skipSplash", i);
        return intent;
    }

    /* renamed from: a */
    public static Intent m2914a(Context context, Intent intent, int i) {
        intent.setClass(context, HomeActivity.class);
        intent.setFlags(65536);
        intent.putExtra("skipSplash", i);
        return intent;
    }

    /* renamed from: b */
    private void m2916b(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(C4820al.f17593f, false);
        boolean booleanExtra2 = intent.getBooleanExtra(C4820al.f17594g, false);
        if (booleanExtra || m2919g()) {
            C4820al.m18181a().m18183a(this, C4820al.f17588a);
        }
        if (booleanExtra2) {
            C4820al.m18181a().m18183a(this, C4820al.f17589b);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        boolean z2 = false;
        super.onCreate(bundle);
        setContentView(R.layout.layout_settings_starting);
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12717a(System.currentTimeMillis());
        }
        Intent intent = getIntent();
        m2916b(intent);
        if (m2918f()) {
            C4904y.m18641c("AuthenticatorActivity is requested finish.", getClass().getSimpleName());
            finish();
            return;
        }
        if (m2919g()) {
            int intExtra = intent.getIntExtra("skipSplash", 0);
            intent.removeExtra("skipSplash");
            switch (intExtra) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (intExtra == 1 && (GlobalApplication.f8360f == null || GlobalApplication.f8360f.getStatus() != AsyncTask.Status.FINISHED)) {
                z = false;
            }
            z2 = true;
        } else {
            z = false;
        }
        if (z) {
            startActivity(m2917c(intent));
            finish();
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) SplashActivity.class);
        intent2.putExtra("is_registered", z2);
        intent2.putExtra("base_intent", intent);
        startActivity(intent2);
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: f */
    private boolean m2918f() {
        return getIntent().getBooleanExtra("finish", false);
    }

    /* renamed from: c */
    private Intent m2917c(Intent intent) {
        return TabActivity.m3016a(this, intent);
    }

    /* renamed from: g */
    private boolean m2919g() {
        return C4809aa.m18104a().m18129b("uid");
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
