package com.sec.chaton.localbackup;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.common.actionbar.AbstractC4946a;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ActivityBackupList extends BaseSinglePaneActivity {

    /* renamed from: n */
    private static final String f8979n = ActivityBackupList.class.getSimpleName();

    /* renamed from: o */
    private BroadcastReceiver f8980o;

    /* renamed from: p */
    private BackupListView f8981p;

    /* renamed from: q */
    private InterfaceC2516b f8982q;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f8982q = (InterfaceC2516b) m6162g();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8982q != null && !this.f8982q.mo10846a()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f8981p = new BackupListView();
        this.f8982q = this.f8981p;
        return this.f8981p;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m10811j();
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: j */
    private void m10811j() {
        this.f8980o = new C2509a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f8980o, intentFilter);
        m10812k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10812k() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m10813l();
    }

    /* renamed from: l */
    private void m10813l() {
        unregisterReceiver(this.f8980o);
    }

    /* renamed from: h */
    public AbstractC4946a m10814h() {
        return m18784t();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
