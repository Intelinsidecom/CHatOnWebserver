package com.sec.chaton.settings;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TabHost;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.userprofile.EditProfileActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class SettingContainerActivity extends TabActivity {
    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        C3225cm.m11337a(this);
        setContentView(R.layout.setting_container);
        int intExtra = getIntent().getIntExtra("contentId", 0);
        boolean z = !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""));
        setTitle(intExtra);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        switch (intExtra) {
            case R.string.layout_regist_country_registration /* 2131427333 */:
                intent = new Intent(this, (Class<?>) ActivityRegist.class);
                break;
            case R.string.setting_category_privacy /* 2131427345 */:
                intent = new Intent(this, (Class<?>) ActivityPrivacy.class);
                break;
            case R.string.settings_type /* 2131427352 */:
                intent = new Intent(this, (Class<?>) ActivityAlertType2.class);
                break;
            case R.string.recommendation /* 2131427764 */:
                intent = new Intent(this, (Class<?>) SuggestionsActivity.class);
                break;
            case R.string.settings_password_lock /* 2131427778 */:
                intent = new Intent(this, (Class<?>) ActivityPasswordLockView.class);
                break;
            case R.string.manage_buddies /* 2131427810 */:
                intent = new Intent(this, (Class<?>) ActivityManageBuddy.class);
                break;
            case R.string.chat_display_settings /* 2131427811 */:
                intent = new Intent(this, (Class<?>) ActivityChat.class);
                break;
            case R.string.setting_alerts /* 2131427812 */:
                intent = new Intent(this, (Class<?>) ActivityNoti.class);
                break;
            case R.string.mypage_edit_profile /* 2131427838 */:
                intent = new Intent(this, (Class<?>) EditProfileActivity.class);
                break;
            case R.string.more_menu_support /* 2131427915 */:
                intent = new Intent(this, (Class<?>) ActivityGeneral.class);
                break;
            case R.string.buddy_contact_sync /* 2131427954 */:
                if (!z) {
                    intent = new Intent(this, (Class<?>) ActivityRegist.class);
                    break;
                } else {
                    intent = new Intent(this, (Class<?>) ActivityContactSync.class);
                    break;
                }
            case R.string.account_manage_accounts /* 2131427970 */:
                intent = new Intent(this, (Class<?>) ActivityManageAccounts.class);
                break;
            case R.string.account_connected_device /* 2131427971 */:
                intent = new Intent(this, (Class<?>) ActivityMultiDeviceView.class);
                break;
            case R.string.settings_title_downloads /* 2131428103 */:
                intent = new Intent(this, (Class<?>) ActivityDownloads.class);
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

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        m9187a();
    }

    /* renamed from: a */
    private void m9187a() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
