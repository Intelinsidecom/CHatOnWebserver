package com.sec.chaton.buddy;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.AbstractC0024aj;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.util.C4892m;

/* loaded from: classes.dex */
public class BuddyActivity2 extends BaseMultiPaneActivity {

    /* renamed from: n */
    private InterfaceC1061c f3556n;

    /* renamed from: o */
    private BuddyFragment f3557o;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (bundle == null) {
            this.f3557o = new BuddyFragment();
            this.f3556n = this.f3557o;
            Bundle bundleA = m6158a(getIntent());
            if ("android.intent.action.PICK".equals(getIntent().getAction())) {
                bundleA.putInt("ACTIVITY_PURPOSE", 1000);
                C4892m.m18577c(true);
            }
            this.f3557o.setArguments(bundleA);
            AbstractC0024aj abstractC0024ajMo183a = m50e().mo183a();
            abstractC0024ajMo183a.mo95a(R.id.fragment_controller, this.f3557o);
            if (findViewById(R.id.fragment_container) != null) {
            }
            abstractC0024ajMo183a.mo99b();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f3556n == null || !this.f3556n.onBackKeyPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m6159a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
    }
}
