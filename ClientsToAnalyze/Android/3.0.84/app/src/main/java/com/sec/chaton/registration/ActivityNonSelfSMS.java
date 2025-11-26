package com.sec.chaton.registration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivityNonSelfSMS extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        boolean z;
        boolean z2 = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            z = extras.getBoolean(FragmentRegist.f8259a, false);
            z2 = extras.getBoolean(FragmentRegist.f8260b, false);
        } else {
            z = false;
        }
        if (z || z2) {
            setTitle(R.string.layout_regist_country_registration);
        }
        return new FragmentNonSelfSMS();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        finish();
        return true;
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

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        String string;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            m3080a(this);
        }
    }
}
