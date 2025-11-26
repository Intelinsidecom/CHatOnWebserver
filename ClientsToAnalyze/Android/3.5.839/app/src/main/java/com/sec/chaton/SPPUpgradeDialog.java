package com.sec.chaton;

import android.content.Context;
import android.os.Bundle;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class SPPUpgradeDialog extends PasswordLockActivity {

    /* renamed from: a */
    private Context f2002a;

    /* renamed from: b */
    private InterfaceC4936e f2003b;

    /* renamed from: c */
    private final String f2004c = SPPUpgradeDialog.class.getClass().getSimpleName();

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        if (C4904y.f17873c) {
            C4904y.m18641c("onCreate", this.f2004c);
        }
        this.f2002a = this;
        m2966a();
    }

    /* renamed from: a */
    private void m2966a() {
        if (C4904y.f17872b) {
            C4904y.m18641c("showAlertDailog", this.f2004c);
        }
        this.f2003b = AbstractC4932a.m18733a(this.f2002a).mo18740a(getResources().getString(R.string.registration_samsung_push_service)).mo18749b(getResources().getString(R.string.upgrade_dialog_basic_message)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1882ck(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1881cj(this)).mo18745a();
        this.f2003b.setCancelable(false);
        this.f2003b.show();
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17873c) {
            C4904y.m18641c("onResume", this.f2004c);
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C4904y.f17873c) {
            C4904y.m18641c("onDestroy", this.f2004c);
        }
        if (this.f2003b != null && this.f2003b.mo18758a().isShowing()) {
            this.f2003b.dismiss();
        }
    }
}
