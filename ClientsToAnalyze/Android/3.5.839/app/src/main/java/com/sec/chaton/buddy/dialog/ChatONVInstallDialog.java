package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class ChatONVInstallDialog extends PasswordLockActivity implements InterfaceC0418c {

    /* renamed from: b */
    public static final String f4532b = ChatONVInstallDialog.class.getSimpleName();

    /* renamed from: a */
    Context f4533a;

    /* renamed from: c */
    private C0416a f4534c;

    /* renamed from: e */
    private C2128i f4536e;

    /* renamed from: g */
    private InterfaceC4936e f4538g;

    /* renamed from: i */
    private C2075ah f4540i;

    /* renamed from: d */
    private ProgressDialog f4535d = null;

    /* renamed from: f */
    private InterfaceC4936e f4537f = null;

    /* renamed from: h */
    private boolean f4539h = false;

    /* renamed from: j */
    private Handler f4541j = new HandlerC1238p(this);

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4533a = this;
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4534c = new C0416a();
        this.f4534c.m1491a(this, this);
        this.f4536e = new C2128i(this.f4541j);
        this.f4540i = new C2075ah(this.f4541j);
        m7269a();
    }

    /* renamed from: a */
    private void m7269a() {
        if (C4904y.f17872b) {
            C4904y.m18641c("showAlertDailog", f4532b);
        }
        this.f4538g = AbstractC4932a.m18733a(this.f4533a).mo18740a(getResources().getString(R.string.setting_samsung_account)).mo18749b(getResources().getString(R.string.chatonv_install_dialog_content)).mo18755c(getResources().getString(R.string.chatonv_install_dialog_continue), new DialogInterfaceOnClickListenerC1233k(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1232j(this)).mo18745a();
        this.f4538g.setOnCancelListener(new DialogInterfaceOnCancelListenerC1234l(this));
        this.f4538g.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7272b() throws Throwable {
        if (C4822an.m18255w()) {
            this.f4535d = ProgressDialogC4926s.m18727a(this.f4533a, null, getResources().getString(R.string.buddy_list_progress_dialog_message));
            this.f4540i.m9312c(null);
        } else {
            Intent intent = new Intent(this.f4533a, (Class<?>) MainActivity.class);
            intent.putExtra("is_mapping_mode", true);
            startActivity(intent);
            finish();
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", getClass().getSimpleName());
        }
        if (this.f4534c != null) {
            this.f4534c.m1491a(this, (InterfaceC0418c) null);
        }
        if (this.f4537f != null && this.f4537f.isShowing()) {
            this.f4537f.dismiss();
        }
        if (this.f4538g != null && this.f4538g.isShowing()) {
            this.f4538g.dismiss();
        }
        if (this.f4535d != null && this.f4535d.isShowing()) {
            this.f4535d.dismiss();
        }
        this.f4539h = true;
        this.f4536e.m9526f();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveCreateAccount : " + z + " msg : " + str, getClass().getSimpleName());
        }
        if (z) {
            this.f4536e.m9499a("voip", 1, false);
            return;
        }
        if (this.f4535d != null && this.f4535d.isShowing()) {
            this.f4535d.dismiss();
        }
        this.f4537f = AbstractC4932a.m18733a(this.f4533a).mo18740a(getResources().getString(R.string.chaton_voice_video_chat)).mo18749b(getResources().getString(R.string.chatonv_sign_in_error)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1236n(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1235m(this)).mo18745a();
        this.f4537f.setOnCancelListener(new DialogInterfaceOnCancelListenerC1237o(this));
        if (!this.f4539h) {
            this.f4537f.show();
        }
        C4904y.m18634a("[ChatONV] Fail to create account", getClass().getSimpleName());
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
    }
}
