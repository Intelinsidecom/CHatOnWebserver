package com.sec.chaton.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.BlackScreenNotification;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.ScreenOnNotification;

/* loaded from: classes.dex */
public abstract class BaseSinglePaneActivity extends BaseActivity {

    /* renamed from: a */
    private Fragment f775a;

    /* renamed from: a */
    protected abstract Fragment mo649a();

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        if (bundle == null) {
            this.f775a = mo649a();
            this.f775a.setArguments(m1828b(getIntent()));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, this.f775a, "com.sec.chaton:single_pane_fragment").commit();
        }
    }

    /* renamed from: b */
    protected Fragment m1834b() {
        return getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!ScreenOnNotification.f6289a && !BlackScreenNotification.f6234a) {
            m1833c();
        }
    }

    /* renamed from: c */
    private void m1833c() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
