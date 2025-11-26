package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.registration.AbstractUpgradeDialog;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class UpgradeDialog extends AbstractUpgradeDialog {

    /* renamed from: b */
    private final String f804b = UpgradeDialog.class.getSimpleName();

    /* renamed from: c */
    private LocalBroadcastManager f805c;

    /* renamed from: d */
    private BroadcastReceiver f806d;

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreate", this.f804b);
        }
        this.f805c = LocalBroadcastManager.getInstance(CommonApplication.m11493l());
        this.f806d = new C0814bx(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.ACTION_DISMISS");
        this.f805c.registerReceiver(this.f806d, intentFilter);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy", this.f804b);
        }
        this.f805c.unregisterReceiver(this.f806d);
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume", this.f804b);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog
    /* renamed from: a */
    protected void mo1132a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("initializeView", this.f804b);
        }
        m8387b(0);
        m8386a(this, 0);
    }
}
