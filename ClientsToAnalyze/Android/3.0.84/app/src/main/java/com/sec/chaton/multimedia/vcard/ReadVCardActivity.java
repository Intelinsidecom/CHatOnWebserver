package com.sec.chaton.multimedia.vcard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.actionbar.AbstractC3284a;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ReadVCardActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private BroadcastReceiver f7362a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new ReadVCardFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m7835d();
        super.onResume();
        m7838g();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m7837f();
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m7834a(android.net.Uri r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.ReadVCardActivity.m7834a(android.net.Uri):boolean");
    }

    /* renamed from: d */
    private void m7835d() {
        this.f7362a = new C1934h(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f7362a, intentFilter);
        m7836e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7836e() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: f */
    private void m7837f() {
        unregisterReceiver(this.f7362a);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: g */
    private void m7838g() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: c */
    public AbstractC3284a m7839c() {
        return m11543k();
    }
}
