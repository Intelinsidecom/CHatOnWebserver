package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3223ck;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class PreviewPageActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private static final String f7220a = PreviewPageActivity.class.getSimpleName();

    /* renamed from: b */
    private BroadcastReceiver f7221b;

    /* renamed from: c */
    private PreviewPageView f7222c;

    /* renamed from: d */
    private InterfaceC1914q f7223d;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7223d = (InterfaceC1914q) m3089b();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f7222c = new PreviewPageView();
        this.f7223d = this.f7222c;
        return this.f7222c;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f7223d != null) {
            this.f7223d.mo7771a();
        }
    }

    /* renamed from: c */
    public void m7761c(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m3080a(this);
        m7758d();
        super.onResume();
    }

    /* renamed from: d */
    private void m7758d() {
        this.f7221b = new C1913p(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f7221b, intentFilter);
        m7759e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7759e() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m7760f();
    }

    /* renamed from: f */
    private void m7760f() {
        unregisterReceiver(this.f7221b);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f7223d != null) {
                    this.f7223d.mo7771a();
                    break;
                } else {
                    finish();
                    break;
                }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
    }
}
