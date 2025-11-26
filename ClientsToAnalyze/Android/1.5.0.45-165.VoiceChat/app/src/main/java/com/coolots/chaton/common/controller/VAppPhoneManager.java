package com.coolots.chaton.common.controller;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.coolots.chaton.account.AuthenticationService;
import com.coolots.chaton.buddy.BuddyManager;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.ChatONBuddyManager;
import com.coolots.chaton.calllog.DataUsageManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.join.ChatONJoinManager;
import com.coolots.chaton.join.ChatOnVJoinManager;
import com.coolots.chaton.login.GCMPushManager;
import com.coolots.chaton.login.SPPPushManager;
import com.coolots.chaton.profile.ProfileManager;
import com.coolots.chaton.profile.ProfileManagerInterface;
import com.coolots.chaton.service.CoolotsService;
import com.coolots.sso.SSOManager;
import com.coolots.watch.WatchManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.watch.IWatchCallbackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class VAppPhoneManager extends PhoneManager {
    protected static final String DEV_SERVER = "dev";
    protected static final String DNS_EXTERNAL = "-v.coolots.com";
    protected static final String OPERATING_SERVER = "";
    public static final String SAMSUNGACCOUNT_TYPESTRING = "com.osp.app.signin";
    protected static final String STAGE_SERVER = "stg";
    protected static boolean mUnlimitedSMS = false;
    protected SSOManager mSSOManager = null;
    protected ProfileManagerInterface mProfileManager = null;
    protected WatchManager mWatchManager = null;

    public abstract void initBRManager(CoolotsService coolotsService);

    public abstract void registerBR();

    public abstract void setWebURL(String str);

    public abstract void unregisterBR();

    public boolean isUnlimitedSMS() {
        return mUnlimitedSMS;
    }

    public static void setUnlimitedSMS(boolean unlimitedSMS) {
        mUnlimitedSMS = unlimitedSMS;
    }

    public VAppPhoneManager() {
        this.mClientType = 1;
        mSupportTcp = false;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void setVersion() {
        this.mVersion = 5;
        super.setVersion();
    }

    protected void initSSOManager() {
        if (this.mSSOManager == null) {
            this.mSSOManager = new SSOManager();
        }
    }

    protected void initWatchManager() {
        if (this.mWatchManager == null) {
            this.mWatchManager = new WatchManager();
        }
    }

    public WatchManager getWatchManager() {
        return this.mWatchManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public IWatchCallbackInterface getIWatchManagerCallBack() {
        return this.mWatchManager;
    }

    protected void initProfileManager() {
        if (this.mProfileManager == null) {
            this.mProfileManager = new ProfileManager();
        }
    }

    public SSOManager getSSOManager() {
        return this.mSSOManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public ISSOCallCallBack getISSOCallCallBack() {
        return this.mSSOManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public void clearSSODataBeforeCallStart() {
        this.mSSOManager.clearDataBeforeStartCall();
    }

    public ProfileManagerInterface getProfileManager() {
        return this.mProfileManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public void init() {
        super.init();
        initSSOManager();
        initWatchManager();
        initProfileManager();
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            getConfigManager().initCountryCode();
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initContactManager() {
        if (this.mContactManager == null) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                this.mContactManager = new ChatONBuddyManager();
            } else {
                this.mContactManager = new BuddyManager();
            }
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initPushManager() {
        if (this.mPushManager == null) {
            this.mPushManager = new ArrayList();
            this.mPushManager.add(new SPPPushManager());
            this.mPushManager.add(new GCMPushManager());
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initJoinManager() {
        if (this.mJoinManager == null) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                this.mJoinManager = new ChatONJoinManager();
            } else {
                this.mJoinManager = new ChatOnVJoinManager();
            }
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initDataUsageManager() {
        if (this.mDataUsageManager == null) {
            this.mDataUsageManager = new DataUsageManager();
        }
        if (this.mDataUsageManager != null) {
            this.mDataUsageManager.initDataUsageManager();
        }
    }

    public BuddyManagerInterface getChatOnContactManager() {
        return (BuddyManagerInterface) this.mContactManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initPreventUMTSManager() {
        if (this.mPreventUMTSManager == null) {
            this.mPreventUMTSManager = new PreventUMTSManager();
        }
    }

    public static boolean startCoolotsService(Context context, boolean forceStart) {
        if (!forceStart && (ConfigActivity.getProfileUserID() == null || ConfigActivity.getProfileUserID().equals(""))) {
            return true;
        }
        ComponentName compname = context.startService(new Intent(context, (Class<?>) CoolotsService.class));
        return compname != null;
    }

    public static void stopCoolotsService(Context context) {
        if (isCoolotsServiceRunning(context)) {
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) CoolotsService.class);
            context.stopService(intent);
        }
    }

    public static boolean isCoolotsServiceRunning(Context context) throws SecurityException {
        boolean bServiceRunning = false;
        ActivityManager activity = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningServiceInfo> serviceInfo = activity.getRunningServices(10000);
        int i = 0;
        while (true) {
            if (i >= serviceInfo.size()) {
                break;
            }
            ActivityManager.RunningServiceInfo info = serviceInfo.get(i);
            if (!info.service.getClassName().equals(CoolotsService.class.getName())) {
                i++;
            } else if (info.pid != 0) {
                bServiceRunning = info.started;
            }
        }
        return bServiceRunning;
    }

    public static boolean isAccountServiceRunning(Context context) throws SecurityException {
        boolean bServiceRunning = false;
        ActivityManager activity = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningServiceInfo> serviceInfo = activity.getRunningServices(10000);
        int i = 0;
        while (true) {
            if (i >= serviceInfo.size()) {
                break;
            }
            ActivityManager.RunningServiceInfo info = serviceInfo.get(i);
            if (!info.service.getClassName().equals(AuthenticationService.class.getName())) {
                i++;
            } else if (info.pid != 0) {
                bServiceRunning = info.started;
            }
        }
        return bServiceRunning;
    }

    public static boolean checkAirPlainMode(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 1) {
            return false;
        }
        Log.m2963i("[checkCurrentNetworkConnection] airplain mode is on!");
        return true;
    }
}
