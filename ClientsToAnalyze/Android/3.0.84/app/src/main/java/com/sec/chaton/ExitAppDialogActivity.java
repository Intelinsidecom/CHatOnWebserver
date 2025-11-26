package com.sec.chaton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class ExitAppDialogActivity extends Activity {

    /* renamed from: a */
    private int f677a;

    /* renamed from: b */
    private C0045a f678b;

    /* renamed from: c */
    private InterfaceC3274d f679c;

    /* renamed from: d */
    private Context f680d;

    /* renamed from: e */
    private ProgressDialog f681e = null;

    /* renamed from: f */
    private final String f682f = ExitAppDialogActivity.class.getSimpleName();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f680d = this;
        this.f677a = getIntent().getIntExtra("reason", 0);
        if (C3250y.f11734b) {
            C3250y.m11450b("mExitReason : " + this.f677a, this.f682f);
        }
        if (C3214cb.m11256a(this)) {
            this.f678b = new C0045a();
            if (this.f678b.m55d(this)) {
                this.f678b.m54c(this);
                C3250y.m11450b("onCreate:mChatonV.removeAccountInDevice()", this.f682f);
            }
        }
        m1143c();
    }

    /* renamed from: c */
    private void m1143c() {
        if (C3250y.f11734b) {
            C3250y.m11453c("showAlertDailog", this.f682f);
        }
        this.f679c = AbstractC3271a.m11494a(this.f680d).mo11500a(getResources().getString(R.string.pop_up_attention)).mo11509b(m1144d()).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1947p(this)).mo11505a();
        this.f679c.mo11517a().setCancelable(false);
        this.f679c.show();
    }

    /* renamed from: d */
    private String m1144d() {
        if (1 == this.f677a) {
            return getResources().getString(R.string.popup_not_enough_memory);
        }
        if (2 == this.f677a) {
            return getResources().getString(R.string.registration_popup_reset_device);
        }
        if (3 == this.f677a) {
            return getResources().getString(R.string.auth_error_restart);
        }
        if (4 == this.f677a) {
            return getResources().getString(R.string.mum_alert_samsungaccount, C3159aa.m10962a().m10979a("samsung_account_email", ""));
        }
        return getResources().getString(R.string.provision_error_end);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            this.f677a = intent.getIntExtra("reason", 0);
        } else {
            this.f677a = 0;
        }
        m1143c();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f681e != null && this.f681e.isShowing()) {
            this.f681e.dismiss();
        }
    }

    /* renamed from: a */
    public static boolean m1139a() {
        return C3159aa.m10962a().m10977a("exit_app_done", (Boolean) false).booleanValue();
    }

    /* renamed from: b */
    public static void m1141b() {
        C3250y.m11442a("Exit App. Unauthorized.", (String) null);
        if (C3159aa.m10962a().m10987b("uid")) {
            m1138a(0);
        } else if (C3250y.f11734b) {
            C3250y.m11450b("Currently, there is NO UID", "ExitAppDialogActivity");
        }
    }

    /* renamed from: a */
    public static void m1138a(int i) {
        C3159aa.m10963a("exit_app_done", (Boolean) true);
        Intent intent = new Intent("com.sec.chaton.ACTION_EXIT_APP");
        intent.putExtra("reason", i);
        LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(intent);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", this.f682f);
    }
}
