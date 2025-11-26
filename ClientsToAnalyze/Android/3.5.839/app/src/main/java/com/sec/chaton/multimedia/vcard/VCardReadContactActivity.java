package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.common.actionbar.AbstractC4946a;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class VCardReadContactActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    public static String f10692n = "extra vard name";

    /* renamed from: o */
    public static String f10693o = "extra fileuri";

    /* renamed from: p */
    private BroadcastReceiver f10694p;

    /* renamed from: q */
    private InterfaceC2909n f10695q;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        VCardReadContactFragment vCardReadContactFragment = new VCardReadContactFragment();
        this.f10695q = vCardReadContactFragment;
        return vCardReadContactFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10695q = (InterfaceC2909n) m6162g();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f10695q != null) {
            this.f10695q.mo12089l_();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m12075i();
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m12077k();
        super.onPause();
    }

    /* renamed from: i */
    private void m12075i() {
        this.f10694p = new C2908m(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10694p, intentFilter);
        m12076j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12076j() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: k */
    private void m12077k() {
        unregisterReceiver(this.f10694p);
    }

    /* renamed from: h */
    public AbstractC4946a m12078h() {
        return m18784t();
    }
}
