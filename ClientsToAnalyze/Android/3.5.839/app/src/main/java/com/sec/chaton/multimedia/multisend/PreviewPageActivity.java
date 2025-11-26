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
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class PreviewPageActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    private static final String f10541n = PreviewPageActivity.class.getSimpleName();

    /* renamed from: o */
    private BroadcastReceiver f10542o;

    /* renamed from: p */
    private PreviewPageView f10543p;

    /* renamed from: q */
    private InterfaceC2880n f10544q;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10544q = (InterfaceC2880n) m6162g();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f10543p = new PreviewPageView();
        this.f10544q = this.f10543p;
        return this.f10543p;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f10544q != null) {
            this.f10544q.mo12001a();
        }
    }

    /* renamed from: b */
    public void m11991b(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m6159a(this);
        m11988i();
        super.onResume();
    }

    /* renamed from: i */
    private void m11988i() {
        this.f10542o = new C2879m(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10542o, intentFilter);
        m11989j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m11989j() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m11990k();
    }

    /* renamed from: k */
    private void m11990k() {
        unregisterReceiver(this.f10542o);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f10544q != null) {
                    this.f10544q.mo12001a();
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
        BaseActivity.m6159a(this);
    }
}
