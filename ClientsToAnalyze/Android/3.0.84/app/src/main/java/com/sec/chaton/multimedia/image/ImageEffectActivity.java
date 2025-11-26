package com.sec.chaton.multimedia.image;

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
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ImageEffectActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private BroadcastReceiver f6883a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        Bundle bundleB = m3082b(getIntent());
        ImageEffectFragment imageEffectFragment = new ImageEffectFragment();
        imageEffectFragment.setArguments(bundleB);
        return imageEffectFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m7556c();
        m7557d();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m7559f();
    }

    /* renamed from: c */
    private void m7556c() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", ImageEffectActivity.class.getSimpleName());
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: d */
    private void m7557d() {
        this.f6883a = new C1875d(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f6883a, intentFilter);
        m7558e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7558e() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this, R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: f */
    private void m7559f() {
        unregisterReceiver(this.f6883a);
    }
}
