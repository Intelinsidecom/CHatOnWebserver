package com.sec.chaton;

import android.os.Bundle;
import com.sec.chaton.registration.AbstractUpgradeDialog;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class NewSPPUpgradeDialog extends AbstractUpgradeDialog {

    /* renamed from: o */
    private final String f1955o = NewSPPUpgradeDialog.class.getSimpleName();

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f1955o);
        }
        this.f11530n.setText(R.string.registration_samsung_push_service);
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog
    /* renamed from: f */
    protected void mo2879f() {
        if (C4904y.f17872b) {
            C4904y.m18639b("initializeView", this.f1955o);
        }
        m12768a(2);
        m12769a(this, 2);
    }
}
