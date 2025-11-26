package com.coolots.chaton;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.coolots.chaton.call.util.StaticsManager;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.controller.ChatOnPhoneManagerKR;
import com.coolots.chaton.common.controller.EngineLoader;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.coolotsinterface.CallButtonNotification;
import com.coolots.chaton.common.coolotsinterface.CallIntentGenerator;
import com.coolots.chaton.common.coolotsinterface.ChatOnNativeInterfaceCreator;
import com.coolots.chaton.common.coolotsinterface.CreditNotification;
import com.coolots.chaton.common.coolotsinterface.DeleteAccountIntentGenerator;
import com.coolots.chaton.common.coolotsinterface.NativeFormat;
import com.coolots.chaton.common.coolotsinterface.ScreenShareProcGenerator;
import com.coolots.chaton.common.util.BitmapCache;
import com.coolots.chaton.common.util.Config;
import com.coolots.chaton.common.util.FrameworkConfig;
import com.coolots.chaton.common.util.InformationActivityGenerator;
import com.coolots.chaton.common.util.NativeSetting;
import com.coolots.chaton.common.util.PopUpCreator;
import com.coolots.chaton.common.util.Resources;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.RingtoneSettingData;
import com.coolots.chaton.setting.update.ChatONVApkUpdate;
import com.coolots.sso.util.ChatONInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CoolotsChatOn extends Application {
    public static final String BROADCAST_CALL_END = "com.sds.coolots.broadcast.CALL_END";
    private static final String CLASSNAME = "[CoolotsChatOn]";
    public static Context mContext;
    public static VAppPhoneManager mPhoneManager;
    BitmapCache bitmapCache = BitmapCache.getInstance();

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Application
    public void onCreate() throws PackageManager.NameNotFoundException {
        super.onCreate();
        logE("onCreate is called!!!!");
        MainApplication.mIsFinishInit = false;
        Log.setVersionInfo(this);
        mContext = getApplicationContext();
        MainApplication.LOGON = false;
        MainApplication.mContext = mContext;
        mPhoneManager = new ChatOnPhoneManagerKR();
        MainApplication.mPhoneManager = mPhoneManager;
        MainApplication.mConfig = new Config();
        MainApplication.mConfig.setFrameworkConfig(new FrameworkConfig());
        MainApplication.mResources = new Resources();
        MainApplication.mCallNotification = new CallButtonNotification();
        MainApplication.mCreditNotification = new CreditNotification();
        MainApplication.mNativeInterfaceCreator = new ChatOnNativeInterfaceCreator();
        MainApplication.mCallIntentGenerator = new CallIntentGenerator();
        MainApplication.mDeleteAccountIntentGenerator = new DeleteAccountIntentGenerator();
        MainApplication.mSettingData = ChatONSettingData.getInstance();
        MainApplication.mNativeFormat = new NativeFormat();
        MainApplication.mPopupCreator = new PopUpCreator();
        MainApplication.mInformationActivityGenerator = new InformationActivityGenerator();
        MainApplication.mEngineLoader = new EngineLoader();
        MainApplication.mFilePathInfo = new BuddyImageUtil();
        MainApplication.mScreenShareProcGenerator = new ScreenShareProcGenerator();
        MainApplication.mRingtoneSettingData = new RingtoneSettingData();
        MainApplication.mPhoneManager.init();
        MainApplication.mChatONInterface = new ChatONInterface();
        MainApplication.mNativeSetting = new NativeSetting();
        MainApplication.mStoreUserUsage = StaticsManager.getInstance();
        MainApplication.mApkUpdateInterface = ChatONVApkUpdate.getInstance();
        logI("--------[FrameworkConfig Setting]--------");
        logI("AirGesture:" + MainApplication.mConfig.isAirGesture());
        logI("Barge-In:" + MainApplication.mConfig.isBargeIn());
        logI("Driving Mode:" + MainApplication.mConfig.isDrivingMode());
        logI("Dual Camera:" + MainApplication.mConfig.isDualCamera());
        logI("Screen Share:" + MainApplication.mConfig.isScreenShare());
        logI("Clear Cover:" + MainApplication.mConfig.isClearCover());
        logI("CPU Boost:" + MainApplication.mConfig.isCPUBoost());
        logI("BT Connectivity:" + MainApplication.mConfig.isBTConnectivity());
        logI("Fixed LCD Frame:" + MainApplication.mConfig.isFixedLCDFrame());
        logI("TTS Audio Stream:" + MainApplication.mConfig.isTTSAudioStream());
        logI("BT Audio Stream:" + MainApplication.mConfig.isBTAudioStream());
        logI("Blocking Mode:" + MainApplication.mConfig.isBlockingMode());
        logI("AlertWhenRinging:" + MainApplication.mConfig.isAlertWhenRinging());
        logI("CallAnswerHomeKey:" + MainApplication.mConfig.isCallAnswerHomeKey());
        logI("CallEndPowerKey:" + MainApplication.mConfig.isCallEndPowerKey());
        logI("-----------------------------------------");
        try {
            ChatONStatusBarController.init(0);
        } catch (SecurityException e) {
        }
        MainApplication.mIsFinishInit = true;
        logE("onCreate()--");
    }

    protected void onDestroy() {
        this.bitmapCache.clear();
        mContext = null;
        MainApplication.mContext = null;
    }
}
