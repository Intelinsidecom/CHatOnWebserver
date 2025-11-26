package com.sec.chaton.localbackup;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3223ck;
import com.sec.common.actionbar.AbstractC3284a;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ActivityBackupList extends BaseSinglePaneActivity {

    /* renamed from: a */
    private static final String f5939a = ActivityBackupList.class.getSimpleName();

    /* renamed from: b */
    private BroadcastReceiver f5940b;

    /* renamed from: c */
    private BackupListView f5941c;

    /* renamed from: d */
    private InterfaceC1614b f5942d;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5942d = (InterfaceC1614b) m3089b();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f5942d != null && !this.f5942d.switchViewMode()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f5941c = new BackupListView();
        this.f5942d = this.f5941c;
        return this.f5941c;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m6785e();
        if (GlobalApplication.m6456e()) {
            m3080a((Activity) this);
        }
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            m3080a((Activity) this);
        }
    }

    /* renamed from: e */
    private void m6785e() {
        this.f5940b = new C1609a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f5940b, intentFilter);
        m6786f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6786f() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m6787g();
    }

    /* renamed from: g */
    private void m6787g() {
        unregisterReceiver(this.f5940b);
    }

    /* renamed from: c */
    public AbstractC3284a m6788c() {
        return m11543k();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
