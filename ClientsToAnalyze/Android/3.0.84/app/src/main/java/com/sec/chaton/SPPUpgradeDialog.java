package com.sec.chaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class SPPUpgradeDialog extends Activity {

    /* renamed from: a */
    private Context f728a;

    /* renamed from: b */
    private InterfaceC3274d f729b;

    /* renamed from: c */
    private final String f730c = SPPUpgradeDialog.class.getClass().getSimpleName();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("onCreate", this.f730c);
        }
        this.f728a = this;
        m1191a();
    }

    /* renamed from: a */
    private void m1191a() {
        if (C3250y.f11734b) {
            C3250y.m11453c("showAlertDailog", this.f730c);
        }
        this.f729b = AbstractC3271a.m11494a(this.f728a).mo11500a(getResources().getString(R.string.registration_samsung_push_service)).mo11509b(getResources().getString(R.string.upgrade_dialog_basic_message)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0434al(this)).mo11501a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0433ak(this)).mo11505a();
        this.f729b.setCancelable(false);
        this.f729b.show();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11735c) {
            C3250y.m11453c("onResume", this.f730c);
        }
        m1192b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11735c) {
            C3250y.m11453c("onDestroy", this.f730c);
        }
        if (this.f729b != null && this.f729b.mo11517a().isShowing()) {
            this.f729b.dismiss();
        }
    }

    /* renamed from: b */
    private void m1192b() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", this.f730c);
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
