package com.coolots.chaton.setting.view;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ChatONSettingTitleTabActivity extends Activity implements DisposeInterface {
    private static final String CLASSNAME = "[ChatONSettingTitleTabActivity]";
    private View mBackButton;
    private View mCustomView;
    private TextView mTitle;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(C0000R.layout.user_preference_action_bar_title_normal);
        actionBar.setDisplayOptions(16);
        this.mCustomView = actionBar.getCustomView();
        this.mTitle = (TextView) this.mCustomView.findViewById(C0000R.id.user_preference_tab_title_name);
        this.mBackButton = this.mCustomView.findViewById(C0000R.id.action_back);
        ChatOnService mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (mChatonservice.getBackgroundThema() == 1) {
            this.mCustomView.setBackgroundResource(C0000R.color.tw_light_color001);
            this.mTitle.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
        }
    }

    protected void setFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 19) {
            backButtonRequestFocus();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void backButtonRequestFocus() {
        this.mBackButton.requestFocus();
    }

    protected void setActionBarTitle(int titleId) {
        this.mTitle.setText(titleId);
    }

    public void onClickBackPage(View view) {
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getFragmentManager().executePendingTransactions();
    }
}
