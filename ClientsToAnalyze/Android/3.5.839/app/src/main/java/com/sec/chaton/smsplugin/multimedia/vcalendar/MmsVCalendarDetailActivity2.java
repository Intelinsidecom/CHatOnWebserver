package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class MmsVCalendarDetailActivity2 extends BaseSinglePaneActivity {

    /* renamed from: n */
    private BroadcastReceiver f14165n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new MmsVCalendarDetailFragment();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("backKey", true);
        setResult(0, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m15187h();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m15189j();
        super.onPause();
    }

    /* renamed from: h */
    private void m15187h() {
        this.f14165n = new C3937a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f14165n, intentFilter);
        m15188i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m15188i() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: j */
    private void m15189j() {
        unregisterReceiver(this.f14165n);
    }
}
