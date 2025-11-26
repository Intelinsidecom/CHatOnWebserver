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
public class GalleryActivity extends BaseSinglePaneActivity {

    /* renamed from: b */
    private static final String f7206b = GalleryActivity.class.getSimpleName();

    /* renamed from: a */
    public boolean f7207a;

    /* renamed from: c */
    private BroadcastReceiver f7208c;

    /* renamed from: d */
    private GalleryView f7209d;

    /* renamed from: e */
    private boolean f7210e;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f7209d = new GalleryView();
        return this.f7209d;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.sec.chaton.multimedia.multisend.C1908k> m7740a(java.util.ArrayList<com.sec.chaton.multimedia.multisend.C1908k> r12) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.multisend.GalleryActivity.m7740a(java.util.ArrayList):java.util.ArrayList");
    }

    /* renamed from: c */
    public void m7741c(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m3080a(this);
        m7737d();
        super.onResume();
    }

    /* renamed from: d */
    private void m7737d() {
        this.f7208c = new C1903f(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f7208c, intentFilter);
        m7738e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7738e() {
        if (!C3223ck.m11327a()) {
            if (!this.f7207a) {
                C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
                this.f7207a = true;
            }
            finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m7739f();
    }

    /* renamed from: f */
    private void m7739f() {
        unregisterReceiver(this.f7208c);
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
