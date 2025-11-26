package com.sec.chaton.buddy;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0458c;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class BuddyActivity2 extends BaseMultiPaneActivity {

    /* renamed from: a */
    private InterfaceC0459d f1706a;

    /* renamed from: b */
    private BuddyFragment f1707b;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (bundle == null) {
            this.f1707b = new BuddyFragment();
            this.f1706a = this.f1707b;
            Bundle bundleB = m3082b(getIntent());
            if ("android.intent.action.PICK".equals(getIntent().getAction())) {
                bundleB.putInt("ACTIVITY_PURPOSE", 1000);
                C3241p.m11403b(true);
            }
            this.f1707b.setArguments(bundleB);
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.fragment_controller, this.f1707b);
            if (findViewById(R.id.fragment_container) != null) {
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1706a == null || !this.f1706a.mo3094a()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0458c mo3086a(String str) {
        return super.mo3086a(str);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m3080a(this);
        m3199a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
    }

    /* renamed from: a */
    private void m3199a() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
