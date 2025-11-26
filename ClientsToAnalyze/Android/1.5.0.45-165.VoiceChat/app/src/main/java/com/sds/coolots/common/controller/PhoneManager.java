package com.sds.coolots.common.controller;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.C1173e;
import com.sds.coolots.call.C1178f;
import com.sds.coolots.call.C1181i;
import com.sds.coolots.call.HandlerC1227o;
import com.sds.coolots.call.HardwareManagerInterface;
import com.sds.coolots.call.KeyGuardManagerInterface;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.PreventUMTSManagerInterface;
import com.sds.coolots.call.ShareScreenInterface;
import com.sds.coolots.call.TextToSpeechInterface;
import com.sds.coolots.call.model.watch.IWatchCallbackInterface;
import com.sds.coolots.calllog.CallLogManagerInterface;
import com.sds.coolots.calllog.DataUsageManagerInterface;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.contact.ContactManagerInterface;
import com.sds.coolots.login.C1264a;
import com.sds.coolots.login.ConfigManagerInterface;
import com.sds.coolots.login.JoinManagerInterface;
import com.sds.coolots.login.LoginManagerInterface;
import com.sds.coolots.presence.PresenceManagerInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class PhoneManager {
    public static final int CELLUAR_NETWORK_2G = 2;
    public static final int CELLUAR_NETWORK_3G = 3;
    public static final int CELLUAR_NETWORK_LTE = 4;
    public static final int CELLUAR_NETWORK_UNKNOWN = 0;
    public static final int CELLUAR_NETWORK_WIFI = 1;
    public static final int CLIENT_TYPE_CHATONV = 1;
    public static final int CLIENT_TYPE_CHATONV_ICS_TEST = 4;
    public static final int CLIENT_TYPE_COOLOTS = 0;
    public static final int CLIENT_TYPE_FS = 3;
    public static final int CLIENT_TYPE_SSE = 2;
    public static final String CLIENT_TYPE_VAPP_IDPREFIX = "@v";
    public static final int FEATURE_ANIMATION = 4;
    public static final int FEATURE_BASIC_FUNCTION = 0;
    public static final int FEATURE_CARTOON_VIEW = 8;
    public static final int FEATURE_EYE_CONTACT = 1;
    public static final int FEATURE_THEME_SHOT = 2;
    public static final boolean LOG_TO_SDCARD = false;
    public static final int MEDIA_ENGINE_OMX = 2;
    public static final int MEDIA_ENGINE_OPENGL = 0;
    public static final int MEDIA_ENGINE_SEC = 1;
    public static final int VERSION_FROYO_DEMO = 0;
    public static final int VERSION_FROYO_LANDSCAPE = 3;
    public static final int VERSION_FROYO_USER = 1;
    public static final int VERSION_GB_USER = 2;
    public static final int VERSION_SEC_USER = 5;
    public static final int VERSION_SW_CODEC_USER = 4;
    public static final String XML_VERSION = "0.90";

    /* renamed from: a */
    private static final String f2919a = "[PhoneManager]";

    /* renamed from: b */
    private static final String f2920b = "enableHIPRI";

    /* renamed from: f */
    private static final String f2922f = "vappbuddy.db";

    /* renamed from: i */
    private static final int f2923i = 7;

    /* renamed from: j */
    private static final int f2924j = 4;

    /* renamed from: k */
    private static final int f2925k = 2;

    /* renamed from: l */
    private static final int f2926l = 1;

    /* renamed from: m */
    private static final int f2927m = 11;
    public static String mServerType = null;

    /* renamed from: n */
    private static final int f2928n = 14;

    /* renamed from: o */
    private static final int f2929o = 5;

    /* renamed from: p */
    private static final int f2930p = 6;

    /* renamed from: q */
    private static final int f2931q = 12;

    /* renamed from: r */
    private static final int f2932r = 8;

    /* renamed from: s */
    private static final int f2933s = 10;

    /* renamed from: t */
    private static final int f2934t = 15;

    /* renamed from: u */
    private static final int f2935u = 9;

    /* renamed from: v */
    private static final int f2936v = 3;

    /* renamed from: w */
    private static final int f2937w = 13;

    /* renamed from: x */
    private static final int f2938x = 0;
    protected String mApplicationID;
    public static boolean isSamsungAccountDeleted = false;
    public static String mServerRegion = "";
    public static boolean mSupportTcp = false;

    /* renamed from: d */
    private static int f2921d = -1;
    protected boolean mIsConfTest = false;
    protected boolean mIsTranslateTest = false;
    protected boolean mIsLinkagewithChatON = false;
    protected boolean mIsUsingChatONVAccount = false;
    protected boolean mIsRemoveNativeAnimation = true;
    protected boolean mIsPrivacyLogBlocked = false;
    protected boolean mIsCanada = false;
    protected int mAssetVersion = 0;
    protected boolean mUseProxymity = true;
    protected int mClientType = 1;

    /* renamed from: c */
    private boolean f2939c = false;
    protected int mSupportFeature = 0;
    protected String mAppVersion = "";
    protected int mVersion = 5;

    /* renamed from: e */
    private NotificationManager f2941e = null;
    protected HardwareManagerInterface mHardwareManager = null;
    protected PhoneStateMachine mPhoneStateMachine = null;
    protected ShareScreenInterface mShareScreenManager = null;
    protected LoginManagerInterface mLoginManager = null;
    protected CallLogManagerInterface mCallLogManager = null;
    protected ContactManagerInterface mContactManager = null;
    protected ArrayList mPushManager = null;
    protected ConfigManagerInterface mConfigManager = null;
    protected JoinManagerInterface mJoinManager = null;
    protected KeyGuardManagerInterface mKeyGuardLockManager = null;
    protected CoolotsEventListener mCoolotsEventListener = null;
    protected PresenceManagerInterface mPresenceManager = null;
    protected DataUsageManagerInterface mDataUsageManager = null;
    protected PreventUMTSManagerInterface mPreventUMTSManager = null;
    protected TextToSpeechInterface mTTSManager = null;
    protected AbstractC1241a mDbHelper = null;
    protected SQLiteDatabase mDb = null;

    /* renamed from: g */
    private final ReentrantLock f2942g = new ReentrantLock();

    /* renamed from: h */
    private boolean f2943h = false;

    /* renamed from: cm */
    public ConnectivityManager f2940cm = null;
    protected boolean mUseMuteNotification = false;

    /* renamed from: a */
    private void m2846a() throws Throwable {
        MainApplication.mConfig.setCallState(false);
        if (getCoolotsEventListener() != null) {
            getCoolotsEventListener().onCallState(false);
        }
        MainApplication.mNativeInterfaceCreator.createVoipStateController().resetForRecovery();
        MainApplication.mCallNotification.deleteCallNotification();
        getHardwareManager().getScreenLockManager().releaseLockForProximity(true);
        ((HandlerC1227o) this.mHardwareManager.getSoundManager()).m2794c();
        this.mKeyGuardLockManager.reenableKeyguardLock();
    }

    /* renamed from: a */
    private void m2847a(String str) {
        Log.m2958e(f2919a + str);
    }

    /* renamed from: a */
    private void m2848a(String str, String str2) {
        if (this.f2941e == null) {
            this.f2941e = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        }
        Notification notification = new Notification(MainApplication.mResources.getDrawableLuncher(), str, System.currentTimeMillis());
        notification.flags |= 16;
        notification.setLatestEventInfo(MainApplication.mContext, str, str2, PendingIntent.getBroadcast(MainApplication.mContext, 0, new Intent(IntentName.ACTION_VERSION_CLICK), 0));
        this.f2941e.notify(1002, notification);
    }

    /* renamed from: b */
    private void m2849b(String str) {
        Log.m2963i(f2919a + str);
    }

    public static boolean checkHipriState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0;
    }

    public static int getMediaEngineType() {
        return f2921d;
    }

    public static boolean is3GNetworkConnected(Context context) {
        if (MainApplication.mConfig.isBTTethering()) {
            return false;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isNetworkConnected(Context context) {
        if (MainApplication.mConfig.isBTTethering()) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiNetworkConnected(Context context) {
        if (MainApplication.mConfig.isBTTethering()) {
            return true;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void releaseHIPRI(Context context) {
        Log.m2958e("<<YHT100>> RELEASE HIPRI!!!!!!");
        ((ConnectivityManager) context.getSystemService("connectivity")).stopUsingNetworkFeature(0, f2920b);
    }

    public static void requestHIPRI(Context context) {
        ((ConnectivityManager) context.getSystemService("connectivity")).startUsingNetworkFeature(0, f2920b);
    }

    public static void requestRoute(Context context, ArrayList arrayList) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            connectivityManager.requestRouteToHost(5, ((Integer) arrayList.get(i2)).intValue());
            i = i2 + 1;
        }
    }

    public static void setMediaEngineType(int i) {
        f2921d = i;
    }

    public boolean IsLinkagewithChatON() {
        return this.mIsLinkagewithChatON;
    }

    public abstract boolean acquireDVFSHelper();

    public int checkNetworkType(Context context) {
        if (this.f2940cm == null) {
            this.f2940cm = (ConnectivityManager) context.getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = this.f2940cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                }
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1 || type == MainApplication.mNativeSetting.getBTTypeForConnectivityManager()) {
                return 1;
            }
        }
        return 0;
    }

    public abstract void clearSSODataBeforeCallStart();

    public void closeDatabase() {
        this.mDbHelper.close();
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getApplicationID() {
        return this.mApplicationID;
    }

    public int getAssetVersion() {
        return this.mAssetVersion;
    }

    public CallLogManagerInterface getCallLogManager() {
        return this.mCallLogManager;
    }

    public int getClientType() {
        return this.mClientType;
    }

    public ConfigManagerInterface getConfigManager() {
        return this.mConfigManager;
    }

    public ContactManagerInterface getContactManager() {
        return this.mContactManager;
    }

    public CoolotsEventListener getCoolotsEventListener() {
        return this.mCoolotsEventListener;
    }

    public ReentrantLock getDataBaseLock() {
        return this.f2942g;
    }

    public DataUsageManagerInterface getDataUsageManager() {
        return this.mDataUsageManager;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDb;
    }

    public int getEngineLogLevelWithServerType() {
        if (mServerType != null && !mServerType.isEmpty()) {
            m2847a("EI_LOGLEVEL_DEBUG");
            return 4;
        }
        m2849b("getEngineLogLevelWithServerType()");
        if (MainApplication.mSettingData.isLogON()) {
            m2847a("EI_LOGLEVEL_DEBUG");
            return 4;
        }
        if (MainApplication.LOGON) {
            m2847a("EI_LOGLEVEL_DEBUG");
            return 4;
        }
        m2847a("EI_LOGLEVEL_ERROR");
        return 1;
    }

    public HardwareManagerInterface getHardwareManager() {
        return this.mHardwareManager;
    }

    public abstract ISSOCallCallBack getISSOCallCallBack();

    public abstract IWatchCallbackInterface getIWatchManagerCallBack();

    public JoinManagerInterface getJoinManager() {
        return this.mJoinManager;
    }

    public KeyGuardManagerInterface getKeyGuardManager() {
        return this.mKeyGuardLockManager;
    }

    public LoginManagerInterface getLoginManager() {
        return this.mLoginManager;
    }

    public PhoneStateMachine getPhoneStateMachine() {
        return this.mPhoneStateMachine;
    }

    public PresenceManagerInterface getPresenceManager() {
        return this.mPresenceManager;
    }

    public PreventUMTSManagerInterface getPreventUMTSManager() {
        return this.mPreventUMTSManager;
    }

    public List getPushManager() {
        return this.mPushManager;
    }

    public ShareScreenInterface getShareScreenManager() {
        return this.mShareScreenManager;
    }

    public int getSupportFeature() {
        return this.mSupportFeature;
    }

    public TextToSpeechInterface getTTSManager() {
        return this.mTTSManager;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void init() {
        m2849b("init()++");
        setLogLevelWithServerType();
        setVersion();
        if (!openDatabase()) {
            m2847a("<init> open Database Error!!!!");
        }
        initPreventUMTSManager();
        initHardwareManager();
        initPhoneStateMachine();
        initLoginManager();
        initCallLogManager();
        initContactManager();
        initPushManager();
        initConfigManager();
        initJoinManager();
        initKeyGuardLockManager();
        initDataUsageManager();
        initTTSManager();
        if (MainApplication.mConfig.getCallState()) {
            m2846a();
        }
        EngineInterface.getInstance();
        m2849b("init()--");
    }

    protected abstract void initCallLogManager();

    protected void initConfigManager() {
        if (this.mConfigManager == null) {
            this.mConfigManager = new C1264a();
        }
    }

    protected abstract void initContactManager();

    protected abstract void initDataUsageManager();

    protected void initHardwareManager() {
        if (this.mHardwareManager == null) {
            this.mHardwareManager = new C1173e();
        }
    }

    protected abstract void initJoinManager();

    protected void initKeyGuardLockManager() {
        if (this.mKeyGuardLockManager == null) {
            this.mKeyGuardLockManager = new C1178f();
        }
    }

    protected abstract void initLoginManager();

    protected void initPhoneStateMachine() {
        if (this.mPhoneStateMachine == null) {
            this.mPhoneStateMachine = new C1181i();
            this.mShareScreenManager = (ShareScreenInterface) this.mPhoneStateMachine;
        }
    }

    protected abstract void initPreventUMTSManager();

    protected abstract void initPushManager();

    protected abstract void initTTSManager();

    public boolean isCanada() {
        return this.mIsCanada;
    }

    public boolean isConfTest() {
        return this.mIsConfTest;
    }

    public boolean isPrivacyLogBlockVer() {
        return this.mIsPrivacyLogBlocked;
    }

    public boolean isRemoveNativeAnimation() {
        return this.mIsRemoveNativeAnimation;
    }

    public boolean isStartedRequestHIPRI() {
        return this.f2939c;
    }

    public boolean isTestReceiveMode() {
        return this.f2943h;
    }

    public boolean isTranslateTest() {
        return this.mIsTranslateTest;
    }

    public boolean isUseMuteNotification() {
        return this.mUseMuteNotification;
    }

    public boolean isUseProxymity() {
        return this.mUseProxymity;
    }

    public boolean isUsingChatONVAccount() {
        return this.mIsUsingChatONVAccount;
    }

    public void lockDatabaseLock() {
        this.f2942g.lock();
    }

    protected boolean openDatabase() {
        try {
            this.mDbHelper = new DatabaseHelper(MainApplication.mContext, f2922f, null);
            this.mDb = this.mDbHelper.getWritableDatabase();
            return true;
        } catch (SQLiteException e) {
            m2847a("<openDatabase> open error!!!! " + e.getMessage());
            return false;
        }
    }

    public abstract void releaseDVFSHelper();

    public void releaseDatabaseLock() {
        this.f2942g.unlock();
    }

    public void resetDatabase() {
        if (this.mDb == null || this.mDbHelper == null) {
            return;
        }
        this.mDbHelper.mo2844b(this.mDb);
    }

    public void resetDatabaseWithoutNationalCode() {
        if (this.mDb == null || this.mDbHelper == null) {
            return;
        }
        this.mDbHelper.mo2843a(this.mDb);
    }

    public void setApplicationID(String str) {
        this.mApplicationID = str;
    }

    public void setClientType(int i) {
        this.mClientType = i;
    }

    public void setCoolotsEventListener(CoolotsEventListener coolotsEventListener) {
        this.mCoolotsEventListener = coolotsEventListener;
    }

    public void setEngineLogLevelWithServerType() {
        if (EngineInterface.getInstance().getState() == 2) {
            EngineInterface.getInstance().setLogLevel(getEngineLogLevelWithServerType());
        }
    }

    public void setIsCanada(boolean z) {
        this.mIsCanada = z;
    }

    public void setLogLevelWithServerType() {
        if (mServerType != null && !mServerType.isEmpty()) {
            m2847a("LOG_LEVEL_VERBOSE");
            Log.setLogLevel(5);
            return;
        }
        m2847a("setLogLevelWithServerType()");
        if (MainApplication.mSettingData.isLogON()) {
            m2847a("LOG_LEVEL_VERBOSE");
            Log.setLogLevel(5);
        } else if (MainApplication.LOGON) {
            m2847a("LOG_LEVEL_VERBOSE");
            Log.setLogLevel(5);
        } else {
            m2847a("LOG_LEVEL_ERROR");
            Log.setLogLevel(1);
        }
    }

    public void setStartedRequestHIPRI(boolean z) {
        this.f2939c = z;
    }

    public void setSupportFeature(int i) {
        this.mSupportFeature = i;
    }

    public void setTestMode(boolean z) {
        this.f2943h = z;
    }

    protected void setVersion() {
        switch (this.mVersion) {
            case 0:
                setMediaEngineType(0);
                m2848a("개발 펌웨어 용입니다.", "정식 펌웨어에서 영상 통화가 되지 않습니다.");
                break;
            case 1:
                setMediaEngineType(2);
                break;
            case 2:
                setMediaEngineType(1);
                break;
            case 3:
                setMediaEngineType(0);
                m2848a("개발 펌웨어 용입니다.", "해외향 탭에서만 정상 동작 합니다.");
                break;
            case 4:
                setMediaEngineType(0);
                break;
            case 5:
                setMediaEngineType(1);
                break;
        }
    }
}
