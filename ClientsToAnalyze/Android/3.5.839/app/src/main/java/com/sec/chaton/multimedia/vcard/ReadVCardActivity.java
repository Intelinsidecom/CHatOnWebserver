package com.sec.chaton.multimedia.vcard;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.common.actionbar.AbstractC4946a;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ReadVCardActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    private BroadcastReceiver f10683n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new ReadVCardFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m12064i();
        super.onResume();
        m6159a((Activity) this);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m12066k();
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m12063a(android.net.Uri r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.ReadVCardActivity.m12063a(android.net.Uri):boolean");
    }

    /* renamed from: i */
    private void m12064i() {
        this.f10683n = new C2903h(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10683n, intentFilter);
        m12065j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12065j() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: k */
    private void m12066k() {
        unregisterReceiver(this.f10683n);
    }

    /* renamed from: h */
    public AbstractC4946a m12067h() {
        return m18784t();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6159a((Activity) this);
    }
}
