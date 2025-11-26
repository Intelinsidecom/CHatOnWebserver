package com.sec.chaton.registration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;

/* loaded from: classes.dex */
public class ActivityRegist extends BaseSinglePaneActivity {

    /* renamed from: a */
    private boolean f8094a = false;

    /* renamed from: b */
    private boolean f8095b = false;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8094a = extras.getBoolean(FragmentRegist.f8259a, false);
            this.f8095b = extras.getBoolean(FragmentRegist.f8260b, false);
        }
        if (this.f8094a || this.f8095b) {
            setTitle(R.string.layout_regist_country_registration);
        }
        if (C3171am.m11080r() && this.f8095b && m11543k() != null) {
            m11543k().mo11597f();
        }
        return new FragmentRegist();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        C3159aa.m10966a("first_time_launch", "BACK_PRESSED");
        super.onBackPressed();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        C3159aa.m10962a().m10981a("provisioning_disclaimer_status");
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        String string;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        String string;
        super.onConfigurationChanged(configuration);
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            m3080a(this);
        }
    }
}
