package com.sec.chaton.settings;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TabHost;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4875cm;

/* loaded from: classes.dex */
public class SettingContainerActivity extends TabActivity {
    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        C4875cm.m18511a(this);
        setContentView(R.layout.setting_container);
        int intExtra = getIntent().getIntExtra("contentId", 0);
        boolean z = !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""));
        setTitle(intExtra);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        switch (intExtra) {
            case R.string.layout_regist_country_registration /* 2131427780 */:
                intent = new Intent(this, (Class<?>) ActivityRegist.class);
                break;
            case R.string.setting_category_privacy /* 2131427790 */:
                intent = new Intent(this, (Class<?>) ActivityPrivacy.class);
                break;
            case R.string.recommendation /* 2131428082 */:
                intent = new Intent(this, (Class<?>) SuggestionsActivity.class);
                break;
            case R.string.settings_password_lock /* 2131428093 */:
                intent = new Intent(this, (Class<?>) ActivityPasswordLockView.class);
                break;
            case R.string.room_setting /* 2131428116 */:
                intent = new Intent(this, (Class<?>) ActivityChat.class);
                break;
            case R.string.more_menu_support /* 2131428208 */:
                intent = new Intent(this, (Class<?>) ActivityGeneral.class);
                break;
            case R.string.buddy_contact_sync /* 2131428242 */:
                if (!z) {
                    intent = new Intent(this, (Class<?>) ActivityRegist.class);
                    break;
                } else {
                    intent = new Intent(this, (Class<?>) ActivityContactSync.class);
                    break;
                }
            case R.string.account_manage_accounts /* 2131428256 */:
                intent = new Intent(this, (Class<?>) ActivityManageAccounts.class);
                break;
            case R.string.account_connected_device /* 2131428257 */:
                intent = new Intent(this, (Class<?>) ActivityMultiDeviceView.class);
                break;
            case R.string.setting_alerts /* 2131428587 */:
                intent = new Intent(this, (Class<?>) ActivityNoti2.class);
                break;
            case R.string.manage_contacts /* 2131428931 */:
                intent = new Intent(this, (Class<?>) ActivityManageBuddy.class);
                break;
            default:
                intent = new Intent();
                break;
        }
        try {
            tabHost.addTab(tabHost.newTabSpec("content").setIndicator("content").setContent(intent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
