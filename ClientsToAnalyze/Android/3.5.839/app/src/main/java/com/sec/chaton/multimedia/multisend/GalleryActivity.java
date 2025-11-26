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
public class GalleryActivity extends BaseSinglePaneActivity {

    /* renamed from: o */
    private static final String f10527o = GalleryActivity.class.getSimpleName();

    /* renamed from: n */
    public boolean f10528n;

    /* renamed from: p */
    private BroadcastReceiver f10529p;

    /* renamed from: q */
    private GalleryView f10530q;

    /* renamed from: r */
    private boolean f10531r;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f10530q = new GalleryView();
        return this.f10530q;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.sec.chaton.multimedia.multisend.C2877k> m11970a(java.util.ArrayList<com.sec.chaton.multimedia.multisend.C2877k> r12) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.multisend.GalleryActivity.m11970a(java.util.ArrayList):java.util.ArrayList");
    }

    /* renamed from: b */
    public void m11971b(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m6159a(this);
        m11967i();
        super.onResume();
    }

    /* renamed from: i */
    private void m11967i() {
        this.f10529p = new C2872f(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10529p, intentFilter);
        m11968j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m11968j() {
        if (!C4873ck.m18500a()) {
            if (!this.f10528n) {
                C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
                this.f10528n = true;
            }
            finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m11969k();
    }

    /* renamed from: k */
    private void m11969k() {
        unregisterReceiver(this.f10529p);
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
