package com.coolots.chaton.common.controller;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.coolots.chaton.call.controller.CPUBoostController;
import com.coolots.chaton.call.util.CallTextToSpeech;
import com.coolots.chaton.calllog.CallLogManager;
import com.coolots.chaton.common.util.SecurePreferences;
import com.coolots.chaton.common.view.EngineeringConfigActivity;
import com.coolots.chaton.login.ChatOnVLoginManager;
import com.coolots.chaton.service.CoolotsService;
import com.coolots.chaton.setting.url.ChatONSettingWebPageURL;
import com.google.protobuf.CodedOutputStream;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;

/* loaded from: classes.dex */
public class ChatOnPhoneManagerKR extends VAppPhoneManager {
    private static final String CANADA_PACKAGE_NAME = "com.coolots.chatonforcanada";
    private static final String CANADA_PERMISSION = "com.coolots.permission.COOLOTS_CANADA";
    private static final String DEFAULT_SUB_PORT = ":7080";
    private static final String WEB_URL_PREFIX_RUN = "http://kr-m";
    private static final String WEB_URL_PREFIX_STG = "http://kr-stgm";
    public static boolean mIsDemoMode = false;
    private ChatONSettingWebPageURL mSettingWebURL;
    public boolean mIsSamsungAccount = true;
    private CPUBoostController mCpuBoost = null;
    private BroadcastReceiverManager mBRManager = null;

    public ChatOnPhoneManagerKR() throws PackageManager.NameNotFoundException {
        this.mAssetVersion = 6;
        this.mIsConfTest = false;
        this.mIsTranslateTest = false;
        this.mIsLinkagewithChatON = true;
        this.mIsUsingChatONVAccount = false;
        this.mIsRemoveNativeAnimation = true;
        this.mIsPrivacyLogBlocked = true;
        this.mUseMuteNotification = false;
        this.mClientType = 1;
        SecurePreferences.setSecure(true);
        mServerType = "";
        setCanadaFlag();
        EngineeringConfigActivity.defCenterDNS = "-v.coolots.com";
        if (mServerType.equals(EngineeringConfigActivity.PREF_DEV)) {
            mUnlimitedSMS = true;
        }
        initSettingWebURL(mServerType);
        this.mAppVersion = ModelInfoUtil.getAppVersion(MainApplication.mContext);
        setApplicationID("ChatONV_ICS_S3_BASE_001");
        setSupportFeature(15);
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initLoginManager() {
        if (this.mLoginManager == null) {
            this.mLoginManager = new ChatOnVLoginManager();
        }
    }

    public void setCanadaFlag() throws PackageManager.NameNotFoundException {
        PackageManager pm = MainApplication.mContext.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(CANADA_PACKAGE_NAME, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (packageInfo.requestedPermissions != null) {
                for (String permissionName : packageInfo.requestedPermissions) {
                    if (CANADA_PERMISSION.equals(permissionName)) {
                        Log.m2963i("<CIH> mIsCanada = true");
                        this.mIsCanada = true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            this.mIsCanada = false;
            e.printStackTrace();
        }
    }

    private void initSettingWebURL(String serverType) {
        EngineeringConfigActivity.setServerLevel(serverType);
        this.mSettingWebURL = new ChatONSettingWebPageURL();
        if (serverType.equals("")) {
            setWebURL(WEB_URL_PREFIX_RUN + EngineeringConfigActivity.defCenterDNS + DEFAULT_SUB_PORT + "/");
        } else {
            setWebURL(WEB_URL_PREFIX_STG + EngineeringConfigActivity.defCenterDNS + "/");
        }
    }

    public ChatONSettingWebPageURL getSettingWebURLInformation() {
        return this.mSettingWebURL;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initCallLogManager() {
        if (this.mCallLogManager == null) {
            this.mCallLogManager = new CallLogManager();
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initTTSManager() {
        if (this.mTTSManager == null) {
            this.mTTSManager = new CallTextToSpeech();
        }
    }

    @Override // com.coolots.chaton.common.controller.VAppPhoneManager
    public void setWebURL(String webURL) {
        this.mSettingWebURL.setWebURL(webURL);
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public boolean acquireDVFSHelper() {
        this.mCpuBoost = new CPUBoostController();
        return this.mCpuBoost.acquireDVFSHelper();
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public void releaseDVFSHelper() {
        this.mCpuBoost.releaseDVFSHelper();
    }

    @Override // com.coolots.chaton.common.controller.VAppPhoneManager
    public void initBRManager(CoolotsService service) {
        this.mBRManager = new BroadcastReceiverManager(service);
    }

    @Override // com.coolots.chaton.common.controller.VAppPhoneManager
    public void registerBR() {
        this.mBRManager.registerReceiver();
    }

    @Override // com.coolots.chaton.common.controller.VAppPhoneManager
    public void unregisterBR() {
        this.mBRManager.unregisterReceiver();
    }
}
