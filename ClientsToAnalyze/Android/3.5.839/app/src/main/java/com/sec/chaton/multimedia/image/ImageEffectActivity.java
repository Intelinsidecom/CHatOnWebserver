package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ImageEffectActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    private BroadcastReceiver f10182n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        Bundle bundleA = m6158a(getIntent());
        ImageEffectFragment imageEffectFragment = new ImageEffectFragment();
        imageEffectFragment.setArguments(bundleA);
        return imageEffectFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m11762h();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m11764j();
    }

    /* renamed from: h */
    private void m11762h() {
        this.f10182n = new C2845e(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10182n, intentFilter);
        m11763i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m11763i() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this, R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: j */
    private void m11764j() {
        unregisterReceiver(this.f10182n);
    }
}
