package com.coolots.chaton.setting.view.aboutchatoncall;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.ChatOnPhoneManagerKR;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.url.ChatONSettingWebPageURL;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Locale;

/* loaded from: classes.dex */
public class ChatONOpenSourceLicenceActivity extends Activity implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[ChatONOpenSourceLicenceActivity]";
    private View mBtnBack;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        setContentView(C0000R.layout.setting_subpage_mobile_web_link);
        ChatONSettingWebPageURL webPageURL = ((ChatOnPhoneManagerKR) MainApplication.mPhoneManager).getSettingWebURLInformation();
        Locale systemLocale = getResources().getConfiguration().locale;
        String strLanguage = systemLocale.getLanguage();
        webPageURL.setLangCode(strLanguage);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        this.mBtnBack = null;
        System.gc();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation != 1 && newConfig.orientation != 2) {
            setContentView(C0000R.layout.setting_subpage_mobile_web_link);
            ChatONSettingWebPageURL webPageURL = ((ChatOnPhoneManagerKR) MainApplication.mPhoneManager).getSettingWebURLInformation();
            Locale systemLocale = getResources().getConfiguration().locale;
            String strLanguage = systemLocale.getLanguage();
            webPageURL.setLangCode(strLanguage);
        }
        super.onConfigurationChanged(newConfig);
    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(C0000R.layout.action_bar_back_with_progress_bar);
            actionBar.setDisplayOptions(16);
            TextView txtTitle = (TextView) findViewById(C0000R.id.action_title);
            txtTitle.setText(getString(C0000R.string.preference_6_2_1_title));
            this.mBtnBack = findViewById(C0000R.id.action_back);
            this.mBtnBack.setOnClickListener(this);
        }
    }

    public void onClickBackPage(View view) {
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onClickBackPage(view);
    }
}
