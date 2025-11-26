package com.sec.chaton;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Build;
import android.os.Bundle;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class ExitAppDialogActivity extends PasswordLockActivity {

    /* renamed from: a */
    private int f1931a;

    /* renamed from: b */
    private C0416a f1932b;

    /* renamed from: c */
    private InterfaceC4936e f1933c;

    /* renamed from: d */
    private Context f1934d;

    /* renamed from: e */
    private ProgressDialog f1935e = null;

    /* renamed from: f */
    private final String f1936f = ExitAppDialogActivity.class.getSimpleName();

    /* renamed from: a */
    public static Intent m2890a(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) ExitAppDialogActivity.class);
        intent.addFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.putExtra("reason", i);
        return intent;
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        m2899e();
        this.f1934d = this;
        this.f1931a = getIntent().getIntExtra("reason", 0);
        if (C4904y.f17872b) {
            C4904y.m18639b("mExitReason : " + this.f1931a, this.f1936f);
        }
        if (C4859bx.m18386a((Context) this)) {
            this.f1932b = new C0416a();
            if (this.f1932b.m1495d(this)) {
                C4859bx.m18388b(this, this.f1932b);
            }
        }
        m2896c();
    }

    /* renamed from: c */
    private void m2896c() {
        if (C4904y.f17872b) {
            C4904y.m18641c("showAlertDailog", this.f1936f);
        }
        this.f1933c = AbstractC4932a.m18733a(this.f1934d).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(m2898d()).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1068bh(this)).mo18745a();
        this.f1933c.mo18758a().setCancelable(false);
        this.f1933c.show();
    }

    /* renamed from: d */
    private String m2898d() {
        if (2 == this.f1931a) {
            return getResources().getString(R.string.registration_popup_reset_device);
        }
        if (3 == this.f1931a) {
            return getResources().getString(R.string.auth_error_restart);
        }
        if (4 == this.f1931a) {
            return getResources().getString(R.string.mum_alert_samsungaccount, C4809aa.m18104a().m18121a("samsung_account_email", ""));
        }
        if (5 == this.f1931a) {
            return getResources().getString(R.string.registration_popup_reset_device_by_sns);
        }
        return getResources().getString(R.string.provision_error_end);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f1935e != null && this.f1935e.isShowing()) {
            this.f1935e.dismiss();
        }
    }

    @Deprecated
    /* renamed from: a */
    public static boolean m2892a() {
        return false;
    }

    @Deprecated
    /* renamed from: b */
    public static void m2894b() {
        C4904y.m18634a("Exit App. Unauthorized.", (String) null);
        if (C4809aa.m18104a().m18129b("uid")) {
            m2891a(0);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("Currently, there is NO UID", "ExitAppDialogActivity");
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m2891a(int i) {
        C0991aa.m6037a().m18962d(new C1067bg(i));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private void m2899e() {
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
    }
}
