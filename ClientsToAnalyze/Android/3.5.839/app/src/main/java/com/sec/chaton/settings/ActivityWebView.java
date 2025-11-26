package com.sec.chaton.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivityWebView extends BaseSinglePaneActivity {

    /* renamed from: n */
    private FragmentWebView f12661n;

    /* renamed from: o */
    private boolean f12662o;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        String string;
        String string2 = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            string = extras.getString(FragmentWebView.PARAM_MENU);
            string2 = extras.getString(FragmentWebView.ERROR_CODE);
        } else {
            string = null;
        }
        if (string != null) {
            if (string.equals("TERMS_AND_CONDITION") || string.equals("PRIVACY_POLICY") || string.equals("ACCEPT_USE_DATA") || string.equals("PUSH_MARKETING")) {
                setTitle(R.string.setting_about_btn1_text);
            } else if (string.equals("Help")) {
                setTitle(R.string.settings_support_FAQs);
            } else if (string.equals("Noti")) {
                setTitle(R.string.attach_title_announcements);
            } else if (string.equals("VOC")) {
                setTitle(R.string.contact_us);
            } else if (string.equals("License")) {
                setTitle(R.string.settings_license);
            } else if (string.equals("NewHelp")) {
                setTitle(R.string.settings_help);
                this.f12662o = true;
            }
        }
        this.f12661n = new FragmentWebView(string2);
        return this.f12661n;
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
        if (this.f12662o) {
            if (this.f12661n != null && !this.f12661n.onBackKeyPressed()) {
                super.onBackPressed();
                return;
            }
            return;
        }
        super.onBackPressed();
    }
}
