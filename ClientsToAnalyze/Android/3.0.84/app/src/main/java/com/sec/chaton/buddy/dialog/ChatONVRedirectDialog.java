package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class ChatONVRedirectDialog extends Activity implements View.OnClickListener {

    /* renamed from: b */
    public static final String f2698b = ChatONVRedirectDialog.class.getSimpleName();

    /* renamed from: a */
    Context f2699a;

    /* renamed from: c */
    private final String f2700c = "com.sec.android.app.samsungapps";

    /* renamed from: d */
    private final String f2701d = "com.android.vending";

    /* renamed from: e */
    private final String f2702e = "com.coolots.chaton";

    /* renamed from: f */
    private InterfaceC3274d f2703f;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        this.f2699a = this;
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        m4211a();
    }

    /* renamed from: a */
    private void m4211a() {
        if (C3250y.f11734b) {
            C3250y.m11453c("showAlertDailog", f2698b);
        }
        this.f2703f = AbstractC3271a.m11494a(this.f2699a).mo11500a(getResources().getString(R.string.chaton_voice_video_chat)).mo11509b(getResources().getString(R.string.chatonv_redirect_dialog_content_new)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0636r(this)).mo11501a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0635q(this)).mo11505a();
        this.f2703f.setOnCancelListener(new DialogInterfaceOnCancelListenerC0637s(this));
        this.f2703f.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.v_redirect_dialog_cancel_btn /* 2131165487 */:
                finish();
                break;
            case R.id.v_redirect_dialog_ok_btn /* 2131165488 */:
                if (m4215b()) {
                    m4216c();
                } else {
                    m4218d();
                }
                finish();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m4215b() {
        return m4213a("com.sec.android.app.samsungapps");
    }

    /* renamed from: a */
    private boolean m4213a(String str) throws PackageManager.NameNotFoundException {
        try {
            GlobalApplication.m11493l().getPackageManager().getApplicationInfo(str, 128);
            if (C3250y.f11734b) {
                C3250y.m11450b("isInstalled(" + str + ") true", f2698b);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            if (C3250y.f11734b) {
                C3250y.m11450b("isInstalled(" + str + ") false", f2698b);
            }
            return false;
        }
    }

    /* renamed from: a */
    private Intent m4210a(Intent intent) {
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(32);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4216c() {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("CallerType", 1);
        intent.putExtra("GUID", "com.coolots.chaton");
        startActivity(m4210a(intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4218d() {
        try {
            startActivity(m4210a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.coolots.chaton"))));
        } catch (ActivityNotFoundException e) {
            if (C3250y.f11734b) {
                C3250y.m11450b("There is no google play in the device", f2698b);
            }
            startActivity(m4210a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.coolots.chaton"))));
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4219e();
    }

    /* renamed from: e */
    private void m4219e() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
