package com.sec.chaton.registration;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivityRegist extends BaseSinglePaneActivity {

    /* renamed from: p */
    private EnumC3297gd f11552p;

    /* renamed from: q */
    private boolean f11553q;

    /* renamed from: n */
    private boolean f11550n = false;

    /* renamed from: o */
    private boolean f11551o = false;

    /* renamed from: r */
    private Bundle f11554r = null;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new FragmentRegist();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = getIntent().getExtras();
        } else if (!bundle.containsKey("save_bundle")) {
            bundle2 = null;
        } else {
            bundle2 = bundle.getBundle("save_bundle");
        }
        if (bundle2 != null) {
            this.f11554r = bundle2;
            this.f11550n = bundle2.getBoolean(FragmentRegist.f11705a, false);
            this.f11551o = bundle2.getBoolean(FragmentRegist.f11706b, false);
            this.f11552p = (EnumC3297gd) bundle2.get(FragmentRegist.f11707c);
            if (bundle2.getBoolean(FragmentRegist.f11710f, false)) {
                setTitle(R.string.buddy_contact_sync);
            }
        }
        if (this.f11551o && ((EnumC3297gd.register_select_now.equals(this.f11552p) || !this.f11550n) && m18784t() != null)) {
            m18784t().mo18837f();
        }
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        String string;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            m6159a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        String string;
        super.onConfigurationChanged(configuration);
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            m6159a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle("save_bundle", this.f11554r);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                if (!this.f11553q) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f11553q = true;
        super.onDestroy();
    }
}
