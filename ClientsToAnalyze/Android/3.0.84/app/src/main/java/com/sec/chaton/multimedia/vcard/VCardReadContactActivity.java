package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.actionbar.AbstractC3284a;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class VCardReadContactActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    public static String f7371a = "extra vard name";

    /* renamed from: b */
    public static String f7372b = "extra fileuri";

    /* renamed from: c */
    private BroadcastReceiver f7373c;

    /* renamed from: d */
    private InterfaceC1940n f7374d;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        VCardReadContactFragment vCardReadContactFragment = new VCardReadContactFragment();
        this.f7374d = vCardReadContactFragment;
        return vCardReadContactFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7374d = (InterfaceC1940n) m3089b();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f7374d != null) {
            this.f7374d.mo7860a();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        m7847d();
        super.onResume();
        m7850g();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m7849f();
        super.onPause();
    }

    /* renamed from: d */
    private void m7847d() {
        this.f7373c = new C1939m(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f7373c, intentFilter);
        m7848e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7848e() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: f */
    private void m7849f() {
        unregisterReceiver(this.f7373c);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: g */
    private void m7850g() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: c */
    public AbstractC3284a m7851c() {
        return m11543k();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }
}
