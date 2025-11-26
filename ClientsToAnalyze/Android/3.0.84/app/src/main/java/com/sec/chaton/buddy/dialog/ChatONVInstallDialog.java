package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ChatONVInstallDialog extends Activity implements View.OnClickListener, InterfaceC0047c {

    /* renamed from: b */
    public static final String f2689b = ChatONVInstallDialog.class.getSimpleName();

    /* renamed from: a */
    Context f2690a;

    /* renamed from: c */
    private C0045a f2691c;

    /* renamed from: e */
    private C1330h f2693e;

    /* renamed from: g */
    private InterfaceC3274d f2695g;

    /* renamed from: d */
    private ProgressDialog f2692d = null;

    /* renamed from: f */
    private InterfaceC3274d f2694f = null;

    /* renamed from: h */
    private boolean f2696h = false;

    /* renamed from: i */
    private Handler f2697i = new HandlerC0631m(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        this.f2690a = this;
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f2691c = new C0045a();
        this.f2691c.m51a(this, this);
        this.f2693e = new C1330h(this.f2697i);
        m4202a();
    }

    /* renamed from: a */
    private void m4202a() {
        if (C3250y.f11734b) {
            C3250y.m11453c("showAlertDailog", f2689b);
        }
        this.f2695g = AbstractC3271a.m11494a(this.f2690a).mo11500a(getResources().getString(R.string.chatonv_install_dialog_title)).mo11509b(getResources().getString(R.string.chatonv_install_dialog_content)).mo11510b(getResources().getString(R.string.chatonv_install_dialog_continue), new DialogInterfaceOnClickListenerC0626h(this)).mo11501a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0625g(this)).mo11505a();
        this.f2695g.setOnCancelListener(new DialogInterfaceOnCancelListenerC0627i(this));
        this.f2695g.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4205b() {
        if (C3171am.m11080r()) {
            this.f2692d = ProgressDialogC3265l.m11489a(this.f2690a, null, getResources().getString(R.string.buddy_list_progress_dialog_message));
            if (C3214cb.m11245a(this.f2690a, this.f2691c) != 0) {
                if (this.f2692d != null && this.f2692d.isShowing()) {
                    this.f2692d.dismiss();
                }
                C3641ai.m13210a(this.f2690a, R.string.toast_setting_communication_failed, 0).show();
                finish();
                return;
            }
            return;
        }
        Intent intent = new Intent(this.f2690a, (Class<?>) MainActivity.class);
        intent.putExtra("is_mapping_mode", true);
        intent.putExtra("is_multi_device_mode", true);
        startActivity(intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy", getClass().getSimpleName());
        }
        if (this.f2691c != null) {
            this.f2691c.m51a(this, (InterfaceC0047c) null);
        }
        if (this.f2694f != null && this.f2694f.isShowing()) {
            this.f2694f.dismiss();
        }
        if (this.f2695g != null && this.f2695g.isShowing()) {
            this.f2695g.dismiss();
        }
        if (this.f2692d != null && this.f2692d.isShowing()) {
            this.f2692d.dismiss();
        }
        this.f2696h = true;
        this.f2693e.m5745e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.v_install_dialog__cancel_btn /* 2131165484 */:
                finish();
                break;
            case R.id.v_install_dialog__continue_btn /* 2131165485 */:
                if (C3171am.m11080r()) {
                    this.f2692d = ProgressDialogC3265l.m11489a(this.f2690a, null, getResources().getString(R.string.buddy_list_progress_dialog_message));
                    if (C3214cb.m11245a(this.f2690a, this.f2691c) != 0) {
                        if (this.f2692d != null && this.f2692d.isShowing()) {
                            this.f2692d.dismiss();
                        }
                        C3641ai.m13210a(this.f2690a, R.string.toast_setting_communication_failed, 0).show();
                        finish();
                        break;
                    }
                } else {
                    Intent intent = new Intent(this.f2690a, (Class<?>) MainActivity.class);
                    intent.putExtra("is_mapping_mode", true);
                    intent.putExtra("is_multi_device_mode", true);
                    startActivity(intent);
                    finish();
                    break;
                }
                break;
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
        m4207c();
    }

    /* renamed from: c */
    private void m4207c() {
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

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + z, getClass().getSimpleName());
        }
        if (z) {
            this.f2693e.m5723a("voip", 1, false);
            return;
        }
        if (this.f2692d != null && this.f2692d.isShowing()) {
            this.f2692d.dismiss();
        }
        this.f2694f = AbstractC3271a.m11494a(this.f2690a).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.chatonv_sign_in_error)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0629k(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0628j(this)).mo11505a();
        this.f2694f.setOnCancelListener(new DialogInterfaceOnCancelListenerC0630l(this));
        if (!this.f2696h) {
            this.f2694f.show();
        }
        C3250y.m11442a("[ChatONV] Fail to create account", getClass().getSimpleName());
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
    }
}
