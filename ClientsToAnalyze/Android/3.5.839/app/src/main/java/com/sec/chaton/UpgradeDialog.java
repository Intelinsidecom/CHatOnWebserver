package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0096i;
import com.sec.chaton.registration.AbstractUpgradeDialog;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class UpgradeDialog extends AbstractUpgradeDialog {

    /* renamed from: o */
    private final String f2098o = UpgradeDialog.class.getSimpleName();

    /* renamed from: p */
    private C0096i f2099p;

    /* renamed from: q */
    private BroadcastReceiver f2100q;

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f2098o);
        }
        this.f2099p = C0096i.m358a(CommonApplication.m18732r());
        this.f2100q = new C2319em(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.ACTION_DISMISS");
        this.f2099p.m362a(this.f2100q, intentFilter);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", this.f2098o);
        }
        this.f2099p.m361a(this.f2100q);
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume", this.f2098o);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog
    /* renamed from: f */
    protected void mo2879f() {
        if (C4904y.f17872b) {
            C4904y.m18639b("initializeView", this.f2098o);
        }
        m12770b(0);
        m12769a(this, 0);
    }
}
