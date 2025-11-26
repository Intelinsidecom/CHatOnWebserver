package com.sec.chaton.settings;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import com.sec.chaton.R;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class SettingContainerActivity extends TabActivity {
    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        setContentView(R.layout.setting_container);
        int intExtra = getIntent().getIntExtra("contentId", 0);
        ((GeneralHeaderView) findViewById(R.id.headerView)).setText(intExtra);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        if (tabHost != null) {
            try {
                tabHost.setup();
                switch (intExtra) {
                    case R.string.setting_category_general /* 2131558451 */:
                        intent = new Intent(this, (Class<?>) ActivityGeneral.class);
                        break;
                    case R.string.setting_category_privacy /* 2131558452 */:
                        intent = new Intent(this, (Class<?>) ActivityPrivacy.class);
                        break;
                    case R.string.settings_type /* 2131558469 */:
                        intent = new Intent(this, (Class<?>) ActivityAlertType2.class);
                        break;
                    case R.string.tab_buddies /* 2131558919 */:
                        intent = new Intent(this, (Class<?>) ActivityBuddyView.class);
                        break;
                    case R.string.tab_chat /* 2131558920 */:
                        intent = new Intent(this, (Class<?>) ActivityChat.class);
                        break;
                    case R.string.setting_body_notifications /* 2131559042 */:
                        intent = new Intent(this, (Class<?>) ActivityNoti.class);
                        break;
                    default:
                        intent = new Intent();
                        break;
                }
                tabHost.addTab(tabHost.newTabSpec("content").setIndicator("content").setContent(intent));
            } catch (SecurityException e) {
            }
        }
    }
}
