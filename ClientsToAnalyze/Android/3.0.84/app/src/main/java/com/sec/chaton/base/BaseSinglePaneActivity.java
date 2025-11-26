package com.sec.chaton.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public abstract class BaseSinglePaneActivity extends BaseActivity {

    /* renamed from: a */
    private Fragment f1525a;

    /* renamed from: a */
    protected abstract Fragment mo1193a();

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        if (bundle == null) {
            this.f1525a = mo1193a();
            if (this.f1525a != null) {
                this.f1525a.setArguments(m3082b(getIntent()));
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, this.f1525a, "com.sec.chaton:single_pane_fragment").commit();
            }
        }
    }

    /* renamed from: b */
    protected Fragment m3089b() {
        return getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3088c();
    }

    /* renamed from: c */
    private void m3088c() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
