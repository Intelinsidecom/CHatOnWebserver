package com.sec.chaton.settings;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ActivityWebView extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        Bundle extras = getIntent().getExtras();
        String string = null;
        if (extras != null) {
            string = extras.getString("PARAM_MENU");
        }
        if (string != null) {
            if (string.equals("TERMS_AND_CONDITION") || string.equals("PRIVACY_POLICY")) {
                setTitle(R.string.setting_about_btn1_text);
            } else if (string.equals("Help")) {
                setTitle(R.string.settings_help);
            } else if (string.equals("ACCEPT_USE_DATA")) {
                setTitle(R.string.setting_about_btn1_text);
            } else if (string.equals("Noti")) {
                setTitle(R.string.setting_category_notice);
            } else if (string.equals("VOC")) {
                setTitle(R.string.contact_us);
            } else if (string.equals("License")) {
                setTitle(R.string.settings_license);
            }
        }
        return new FragmentWebView();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }
}
