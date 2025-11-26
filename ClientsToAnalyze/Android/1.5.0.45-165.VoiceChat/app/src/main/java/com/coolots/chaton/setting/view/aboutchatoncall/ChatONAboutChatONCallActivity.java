package com.coolots.chaton.setting.view.aboutchatoncall;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.update.ChatONVApkUpdate;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.URL;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONAboutChatONCallActivity extends Activity implements DisposeInterface {
    private static final String GET_LATEST_VERSION_URI_STR = "content://com.coolots.chaton/get_latest_version";
    private static final String KEY_URI_STR = "content://com.coolots.chaton/key";
    private ChatOnService mChatonservice;
    private UpdateHandler mUpdateHandler;
    private TextView mCurrentVersion = null;
    private TextView mLatestVersion = null;
    private Button mBtnUpgrade = null;
    private ProgressBar mLatestProgress = null;
    private String mCurrentVersionString = null;
    private String mLastVersionString = null;
    private String mGooglePlayURL = null;
    private String mSamsungAppsURL = null;
    private Dialog mCriticalUpdateDialog = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i("[ChatONAboutChatONCallActivity]" + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logI("onCreate()");
        setContentView(C0000R.layout.layout_settings_about);
        initView();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(C0000R.layout.layout_settings_about);
        initView();
        updateView();
    }

    private void initView() {
        ImageView divider = (ImageView) findViewById(C0000R.id.open_source_license_divider);
        ChatOnService mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (mChatonservice.getBackgroundThema() == 1) {
            divider.setBackground(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
        } else {
            divider.setBackground(getResources().getDrawable(C0000R.drawable.list_divider));
        }
        this.mCurrentVersionString = ModelInfoUtil.getAppVersion(this);
        this.mCurrentVersion = (TextView) findViewById(C0000R.id.current_version);
        this.mCurrentVersion.setText(String.valueOf(getString(C0000R.string.preference_1_1_summary)) + " " + this.mCurrentVersionString);
        this.mLatestVersion = (TextView) findViewById(C0000R.id.latest_version);
        this.mLatestVersion.setVisibility(4);
        this.mLatestProgress = (ProgressBar) findViewById(C0000R.id.progressive_loading);
        this.mLatestProgress.setVisibility(0);
        LinearLayout openSourceBtn = (LinearLayout) findViewById(C0000R.id.open_source_license);
        openSourceBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.aboutchatoncall.ChatONAboutChatONCallActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setAction("com.coolots.chaton.USER_SETTING_SUBPAGE_OPEN_SOURCE_LICENCE");
                ChatONAboutChatONCallActivity.this.startActivity(intent);
            }
        });
        TextView openSourceText = (TextView) findViewById(C0000R.id.open_source_license_text);
        ChatOnService mChatonservice2 = ChatOnService.createService(MainApplication.mContext);
        if (mChatonservice2.getBackgroundThema() == 1) {
            openSourceBtn.setBackground(getResources().getDrawable(C0000R.drawable.list_bg_selector_black));
            openSourceText.setTextColor(getResources().getColor(C0000R.color.tw_color001));
        } else {
            openSourceBtn.setBackground(getResources().getDrawable(C0000R.drawable.list_bg_selector));
            openSourceText.setTextColor(getResources().getColor(C0000R.color.tw_color002));
        }
        this.mBtnUpgrade = (Button) findViewById(C0000R.id.upgrade);
        this.mBtnUpgrade.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.aboutchatoncall.ChatONAboutChatONCallActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                ChatONAboutChatONCallActivity.this.gotoUpdatePage();
            }
        });
        this.mBtnUpgrade.setEnabled(false);
        this.mBtnUpgrade.setTextColor(getResources().getColor(C0000R.color.co_btn_text_color_disable));
    }

    @Override // android.app.Activity
    public void onResume() {
        logI("onResume()");
        if (this.mLastVersionString == null) {
            checkVersion();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onPause() {
        logI("onPause()");
        super.onPause();
    }

    private void checkVersion() {
        UpdateHandler updateHandler = null;
        if (this.mUpdateHandler != null) {
            this.mUpdateHandler.dispose();
            this.mUpdateHandler = null;
        }
        this.mUpdateHandler = new UpdateHandler(this, updateHandler);
        ChatONVApkUpdate.getInstance().checkVersion(this.mUpdateHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        logI("Last version name: " + this.mLastVersionString + " Current version name: " + this.mCurrentVersionString);
        this.mLatestProgress.setVisibility(8);
        this.mLatestVersion.setText(String.valueOf(getString(C0000R.string.preference_1_1_title)) + " " + this.mLastVersionString);
        this.mLatestVersion.setVisibility(0);
        if (this.mCurrentVersionString.compareTo(this.mLastVersionString) <= 0) {
            this.mBtnUpgrade.setEnabled(false);
            this.mBtnUpgrade.setTextColor(getResources().getColor(C0000R.color.co_btn_text_color_disable));
        } else {
            this.mBtnUpgrade.setEnabled(true);
            this.mBtnUpgrade.setTextColor(getResources().getColor(C0000R.color.co_btn_text_color_enable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCriticalUpdateDialog() {
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setMessage(C0000R.string.version_critical_update_msg);
        bld.setTitle(C0000R.string.information_str_title_1);
        bld.setNegativeButton(getResources().getString(C0000R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.aboutchatoncall.ChatONAboutChatONCallActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
                ChatONAboutChatONCallActivity.this.mCriticalUpdateDialog = null;
            }
        });
        bld.setPositiveButton(getResources().getString(C0000R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.aboutchatoncall.ChatONAboutChatONCallActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
                ChatONAboutChatONCallActivity.this.mCriticalUpdateDialog = null;
                ChatONAboutChatONCallActivity.this.gotoUpdatePage();
            }
        });
        this.mCriticalUpdateDialog = bld.create();
        this.mCriticalUpdateDialog.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        logI("onDestroy()");
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mCriticalUpdateDialog != null) {
            this.mCriticalUpdateDialog.dismiss();
            this.mCriticalUpdateDialog = null;
        }
        if (this.mUpdateHandler != null) {
            this.mUpdateHandler.dispose();
            this.mUpdateHandler = null;
        }
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }

    public String[] change2StringArrayServer(Object url) {
        List<URL> urlList = (List) url;
        if (urlList == null || urlList.isEmpty() || urlList.size() != 2 || urlList.get(0) == null || urlList.get(0).getURL() == null || urlList.get(0).getURL().isEmpty() || urlList.get(1) == null || urlList.get(1).getURL() == null || urlList.get(1).getURL().isEmpty()) {
            return null;
        }
        String[] urlArray = {urlList.get(0).getURL(), urlList.get(1).getURL()};
        return urlArray;
    }

    public void setDownLoadURL(String[] url) {
        this.mSamsungAppsURL = "samsungapps://ProductDetail/com.sec.chaton";
        this.mGooglePlayURL = "market://details?id=com.sec.chaton";
        logI("setDownLoadURL(): ");
        if (url != null && url.length == 2) {
            if (url[0] != null && url[0].contains("samsungapps://")) {
                this.mSamsungAppsURL = url[0];
            } else if (url[0] != null && url[0].contains("market://")) {
                this.mGooglePlayURL = url[0];
            }
            if (url[1] != null && url[1].contains("samsungapps://")) {
                this.mSamsungAppsURL = url[1];
            } else if (url[1] != null && url[1].contains("market://")) {
                this.mGooglePlayURL = url[1];
            }
            logI("samsung apps url: " + this.mSamsungAppsURL);
            logI("google play url: " + this.mGooglePlayURL);
        }
    }

    public void gotoUpdatePage() {
        if (isInstalledSamsungApps()) {
            gotoSamsungApps();
        } else if (isInstalledGooglePlay()) {
            gotoGooglePlay();
        } else if (MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivity(27);
        }
    }

    private boolean isInstalledSamsungApps() {
        return isInstalled("com.sec.android.app.samsungapps");
    }

    private boolean isInstalledGooglePlay() {
        return isInstalled("com.android.vending");
    }

    private boolean isInstalled(String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = MainApplication.mContext.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 128);
            logI("isInstalled(" + packageName + ") true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            logI("isInstalled(" + packageName + ") false");
            return false;
        }
    }

    private void gotoSamsungApps() {
        Uri uri;
        logI("mSamsungAppsURL = " + this.mSamsungAppsURL);
        if (this.mSamsungAppsURL == null || this.mSamsungAppsURL.isEmpty()) {
            uri = Uri.parse("samsungapps://ProductDetail/com.sec.chaton");
        } else {
            uri = Uri.parse(this.mSamsungAppsURL);
        }
        gotoDownLoadPage(uri);
    }

    private void gotoGooglePlay() {
        Uri uri;
        if (this.mGooglePlayURL == null || this.mGooglePlayURL.isEmpty()) {
            uri = Uri.parse("market://details?id=com.sec.chaton");
        } else {
            uri = Uri.parse(this.mGooglePlayURL);
        }
        gotoDownLoadPage(uri);
    }

    private void gotoDownLoadPage(Uri uri) {
        logI("gotoDownLoadPage(" + uri + ")");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(32);
            MainApplication.mContext.startActivity(intent);
        } catch (ActivityNotFoundException anfe) {
            logI("[ActivityNotFoundException] \n" + anfe);
            if (MainApplication.mInformationActivityGenerator != null) {
                MainApplication.mInformationActivityGenerator.showInformationActivity(27);
            }
        }
    }

    private class UpdateHandler extends Handler {
        private boolean mDispose;

        private UpdateHandler() {
            this.mDispose = false;
        }

        /* synthetic */ UpdateHandler(ChatONAboutChatONCallActivity chatONAboutChatONCallActivity, UpdateHandler updateHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (this.mDispose) {
                ChatONAboutChatONCallActivity.this.logI("This handler was removed");
                return;
            }
            if (msg.what == MessageInfo.VersionInfoAsk.getDispatchCode()) {
                ChatONAboutChatONCallActivity.this.mCurrentVersionString = ModelInfoUtil.getAppVersion(MainApplication.mContext);
                ChatONAboutChatONCallActivity.this.mLastVersionString = ChatONSettingData.getInstance().getLastVersionName();
                int versionInfo = ChatONVApkUpdate.getInstance().isLatestVersionNSaveVersionInfo(msg);
                ChatONAboutChatONCallActivity.this.logI("UpdateHandler: " + ChatONAboutChatONCallActivity.this.mCurrentVersionString + ", " + ChatONAboutChatONCallActivity.this.mLastVersionString + ", " + versionInfo);
                ChatONAboutChatONCallActivity.this.setDownLoadURL(ChatONVApkUpdate.getInstance().getDownloadURL());
                if (!ChatONAboutChatONCallActivity.this.mCurrentVersionString.equals(ChatONAboutChatONCallActivity.this.mLastVersionString) && versionInfo == 3) {
                    ChatONAboutChatONCallActivity.this.showCriticalUpdateDialog();
                }
                ChatONAboutChatONCallActivity.this.updateView();
                int retV = ChatONVApkUpdate.getInstance().isLatestVersionNSaveVersionInfo(msg);
                String lastVersionString = ChatONSettingData.getInstance().getLastVersionName();
                MainApplication.mChatONInterface.sendBroadcastUgradeNewApk(lastVersionString, retV, ChatONVApkUpdate.getInstance().getDownloadURL());
            }
            super.handleMessage(msg);
        }

        public void dispose() {
            this.mDispose = true;
        }
    }
}
