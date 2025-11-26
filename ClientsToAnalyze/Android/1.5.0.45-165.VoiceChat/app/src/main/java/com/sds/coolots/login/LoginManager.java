package com.sds.coolots.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.coolots.p2pmsg.model.CipherKeyRep;
import com.coolots.p2pmsg.model.DeviceConfigAsk;
import com.coolots.p2pmsg.model.DeviceConfigInfo;
import com.coolots.p2pmsg.model.DeviceConfigRep;
import com.coolots.p2pmsg.model.DeviceIDAsk;
import com.coolots.p2pmsg.model.LoginAsk;
import com.coolots.p2pmsg.model.LoginRep;
import com.coolots.p2pmsg.model.NonceAsk;
import com.coolots.p2pmsg.model.ResetMsgKeyRep;
import com.coolots.p2pmsg.model.Server;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.EventTraceUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.controller.EngineLoginCallbackInterface;
import com.sds.coolots.common.controller.EventHandlerInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.httpAdaptor.ResetMsgKeyAdaptor;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.login.adaptor.C1269a;
import com.sds.coolots.login.adaptor.C1271c;
import com.sds.coolots.login.adaptor.C1272d;
import com.sds.coolots.login.adaptor.C1274f;
import com.sds.coolots.login.adaptor.CipherKeyAskAdaptor;
import com.sds.coolots.login.adaptor.DeviceConfigAdaptor;
import com.sds.coolots.login.model.C1282a;
import com.sds.coolots.login.model.C1283b;
import com.sds.coolots.login.model.C1284c;
import com.sds.coolots.login.model.C1285d;
import com.sds.coolots.login.model.C1287f;
import com.sds.coolots.login.model.C1288g;
import com.sds.coolots.login.model.C1289h;
import com.sds.coolots.login.model.C1290i;
import com.sds.coolots.login.model.C1291j;
import com.sds.coolots.login.model.C1292k;
import com.sds.coolots.login.model.LoginStateInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class LoginManager implements EngineLoginCallbackInterface, LoginManagerInterface {
    public static final String CLASSNAME = "[LoginMng]";

    /* renamed from: a */
    private static final String f3123a = "M";

    /* renamed from: b */
    private static final int f3124b = 0;

    /* renamed from: c */
    private static final int f3125c = 1;

    /* renamed from: d */
    private static final int f3126d = 2;

    /* renamed from: e */
    private static final int f3127e = 3;

    /* renamed from: f */
    private static final int f3128f = 4;

    /* renamed from: g */
    private static final int f3129g = 5;

    /* renamed from: h */
    private static final int f3130h = 6;

    /* renamed from: i */
    private static final int f3131i = 8;

    /* renamed from: j */
    private static final int f3132j = 9;

    /* renamed from: k */
    private static final int f3133k = 10;

    /* renamed from: l */
    private static final int f3134l = 86400000;

    /* renamed from: m */
    private static final int f3135m = 82800000;

    /* renamed from: n */
    private static final int f3136n = 30000;

    /* renamed from: w */
    private static final String f3137w = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static long NONCEEXPIREEDFLAGTIME = 3600000;

    /* renamed from: p */
    private boolean f3148p = true;

    /* renamed from: q */
    private String f3149q = "";

    /* renamed from: r */
    private String f3150r = "";

    /* renamed from: s */
    private ArrayList f3151s = new ArrayList();

    /* renamed from: t */
    private final C1284c f3152t = new C1284c();

    /* renamed from: u */
    private final Handler f3153u = new HandlerC1278d(this, null);
    protected final Handler mHandler = new HandlerC1277c(this, 0 == true ? 1 : 0);

    /* renamed from: v */
    private EventHandlerInterface f3154v = null;

    /* renamed from: x */
    private TelephonyManager f3155x = null;

    /* renamed from: y */
    private AlarmManager f3156y = null;

    /* renamed from: z */
    private final C1285d f3157z = new C1285d(this);

    /* renamed from: A */
    private final C1289h f3138A = new C1289h(this);

    /* renamed from: B */
    private final C1292k f3139B = new C1292k(this);

    /* renamed from: C */
    private final C1291j f3140C = new C1291j(this);

    /* renamed from: D */
    private final C1290i f3141D = new C1290i(this);

    /* renamed from: E */
    private final C1287f f3142E = new C1287f(this);

    /* renamed from: F */
    private final C1283b f3143F = new C1283b(this);

    /* renamed from: G */
    private final C1288g f3144G = new C1288g(this);

    /* renamed from: H */
    private final C1282a f3145H = new C1282a(this);

    /* renamed from: I */
    private LoginStateInterface f3146I = this.f3157z;

    /* renamed from: o */
    private final Context f3147o = MainApplication.mContext;

    public LoginManager() {
        init();
    }

    /* renamed from: a */
    private void m2998a() {
        new ResetMsgKeyAdaptor(this.mHandler).start();
    }

    /* renamed from: a */
    private void m2999a(int i) {
        if (this.f3154v != null) {
            this.f3154v.sendHandlerMessage(i, 0L);
        }
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            Message message = new Message();
            message.what = i;
            MainApplication.mPhoneManager.getCoolotsEventListener().onLoginEvent(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3000a(Message message) {
        if (message.arg1 != 0) {
            this.f3153u.sendEmptyMessage(8);
        } else if (message.obj instanceof ResetMsgKeyRep) {
            m3011b("resetmsg success");
            new C1271c(new LoginAsk(), null).start();
        }
    }

    /* renamed from: a */
    private void m3001a(LoginRep loginRep) {
        MainApplication.mConfig.setUserNo(loginRep.getUserNo());
        m3011b("msg.getServicePolicy() is null");
        MainApplication.mConfig.setServicePolicyInfoEnableVoice(true);
        MainApplication.mConfig.setServicePolicyInfoEnableVideo(true);
        handleServicePolicyInfo();
        MainApplication.mConfig.setSessionID(loginRep.getSessionID());
        MainApplication.mConfig.setCipherKey(loginRep.getCipherKey());
        EngineInterface.getInstance().setCipherKey(loginRep.getCipherKey());
        EngineInterface.getInstance().setSessionID(loginRep.getSessionID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3004a(String str) {
        Log.m2958e(CLASSNAME + str);
    }

    /* renamed from: a */
    private void m3005a(boolean z) {
        MainApplication.mConfig.cleanSharedPreference(z);
    }

    /* renamed from: b */
    private void m3006b() {
        String networkOperator;
        DeviceIDAsk deviceIDAsk = new DeviceIDAsk();
        deviceIDAsk.setDeviceType(f3123a);
        deviceIDAsk.setSerialNo(this.f3149q);
        deviceIDAsk.setOsName(ModelInfoUtil.SYSTEM_OS);
        deviceIDAsk.setOsVersion(ModelInfoUtil.OSVERSION);
        deviceIDAsk.setDeviceModel(ModelInfoUtil.MODEL);
        deviceIDAsk.setAppVersion(ModelInfoUtil.getAppVersion(MainApplication.mContext));
        deviceIDAsk.setApplicationID(MainApplication.mPhoneManager.getApplicationID());
        deviceIDAsk.setPassWord(MainApplication.mConfig.getProfileRawPwd());
        if (this.f3155x == null) {
            this.f3155x = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        }
        if (this.f3155x != null && (networkOperator = this.f3155x.getNetworkOperator()) != null && networkOperator.length() > 3) {
            deviceIDAsk.setMCC(networkOperator.substring(0, 3));
            deviceIDAsk.setMNC(networkOperator.substring(3));
        }
        String authID = MainApplication.mConfig.getAuthID();
        if (authID != null && !authID.isEmpty()) {
            deviceIDAsk.setAuthID(authID);
        }
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            deviceIDAsk.setChatOnUID(MainApplication.mConfig.getChatONUID());
        }
        new C1269a(deviceIDAsk, this.mHandler).start();
    }

    /* renamed from: b */
    private void m3007b(int i) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3147o, 0, new Intent(IntentName.ACTION_ALARM_NONCE_TIME), 0);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f3156y == null) {
            this.f3156y = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
        }
        this.f3156y.set(2, jElapsedRealtime + i, broadcast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3008b(Message message) {
        switch (message.arg1) {
            case -1:
                this.f3153u.sendEmptyMessage(8);
                break;
            case 0:
                if (MainApplication.mConfig.getProfileRawPwd() != null && !MainApplication.mConfig.getProfileRawPwd().equals("")) {
                    m3015c(String.valueOf(MainApplication.mConfig.getProfileRawPwd()) + MainApplication.mConfig.getNonce());
                    m3019e();
                    if (this.f3150r != null && !this.f3150r.equals("")) {
                        MainApplication.mConfig.setProfilePasswd(this.f3150r);
                    }
                    if (MainApplication.mPhoneManager.getClientType() != 2) {
                        MainApplication.mStoreUserUsage.sendToServerStaticsData();
                    }
                }
                MainApplication.mConfig.setAuthID("");
                this.f3153u.sendEmptyMessage(3);
                break;
            case 10001:
                m2999a(3002);
                this.f3153u.sendEmptyMessage(8);
                break;
            default:
                this.f3153u.sendEmptyMessage(8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3011b(String str) {
        Log.m2963i(CLASSNAME + str);
    }

    /* renamed from: c */
    private void m3012c() {
        new C1271c(new LoginAsk(), this.mHandler).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3013c(Message message) throws NumberFormatException {
        if (message.arg1 == 1) {
            for (DeviceConfigInfo deviceConfigInfo : ((DeviceConfigRep) message.obj).getDeviceConfigInfoList()) {
                if (deviceConfigInfo.getConfigKey().equals(DeviceConfigInfo.CONFERENCE_MEMBER_AUDIO_MAX)) {
                    int i = Integer.parseInt(deviceConfigInfo.getConfigValue());
                    if (i > 0) {
                        MainApplication.mConfig.setConferenceCallMaxPeopleNum(false, i);
                    }
                } else if (deviceConfigInfo.getConfigKey().equals(DeviceConfigInfo.CONFERENCE_MEMBER_VIDEO_MAX)) {
                    int i2 = Integer.parseInt(deviceConfigInfo.getConfigValue());
                    if (i2 > 0) {
                        MainApplication.mConfig.setConferenceCallMaxPeopleNum(true, i2);
                    }
                } else if (deviceConfigInfo.getConfigKey().equals("call.data.send.interval")) {
                    MainApplication.mConfig.setCallDataSendInterval(Integer.parseInt(deviceConfigInfo.getConfigValue()));
                }
            }
        }
        sendNonceAskSecond();
    }

    /* renamed from: c */
    private void m3015c(String str) {
        try {
            this.f3150r = EncodingUtil.getMd5Hash(str);
        } catch (Exception e) {
            m3004a("HASHING ERROR");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m3016d() {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3147o, 0, new Intent(IntentName.ACTION_ALARM_NONCE_DELETE_TIME), 0);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f3156y == null) {
            this.f3156y = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
        }
        this.f3156y.cancel(broadcast);
        this.f3156y.set(2, jElapsedRealtime + 86400000, broadcast);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.m2963i("LOGINOPTIMIZATION MainApplication.mConfig.setNonceExpiredTime(absoluteCurerntTime + NONCE_DELETE_TIMEOUT);");
        MainApplication.mConfig.setNonceExpiredTime(jCurrentTimeMillis + 86400000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3017d(Message message) {
        switch (message.arg1) {
            case 0:
                m3015c(String.valueOf(MainApplication.mConfig.getProfileRawPwd()) + MainApplication.mConfig.getNonce());
                MainApplication.mConfig.setProfilePasswd(this.f3150r);
                EngineInterface.getInstance().setPasswd(this.f3150r);
                if (MainApplication.mPhoneManager.getClientType() != 2) {
                    MainApplication.mStoreUserUsage.sendToServerStaticsData();
                }
                m3004a("NONCE CHANGED");
                break;
            case 10001:
                m2999a(3002);
                logout(false);
                break;
            default:
                if (!"".equals(MainApplication.mConfig.getNonce())) {
                    m3007b(30000);
                    break;
                } else {
                    this.f3153u.sendEmptyMessage(1);
                    break;
                }
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_NONCE_REFRESH);
    }

    /* renamed from: e */
    private void m3019e() {
        new Thread(new RunnableC1276b(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3020e(Message message) {
        switch (message.arg1) {
            case ErrorCode.ERROR_LOGIN_NO_NUMBER /* -101 */:
                m3004a("ERROR_LOGIN_NO_NUMBER");
                if (message.obj instanceof LoginRep) {
                    m3001a((LoginRep) message.obj);
                }
                m2999a(EventCode.EVENT_LOGIN_NO_NUMBER);
                this.f3153u.sendEmptyMessage(8);
                break;
            case 0:
                if (message.obj instanceof LoginRep) {
                    m3001a((LoginRep) message.obj);
                }
                if (!MainApplication.mConfig.isProfileRawPwdCheck()) {
                    MainApplication.mPhoneManager.resetDatabaseWithoutNationalCode();
                    m3005a(false);
                }
                MainApplication.mConfig.setProfileRawPwdCheck(true);
                this.f3153u.sendEmptyMessage(4);
                if (!MainApplication.mPhoneManager.IsLinkagewithChatON() && MainApplication.mPhoneManager.isUsingChatONVAccount()) {
                    if ((MainApplication.mPhoneManager.getClientType() == 0 || MainApplication.mPhoneManager.getClientType() == 1) && MainApplication.mConfig != null && MainApplication.mConfig.getSamsungAccountID() != null && !MainApplication.mConfig.getSamsungAccountID().isEmpty()) {
                        m3004a("<CIH> add account");
                        AccountManager accountManager = AccountManager.get(MainApplication.mContext);
                        Account account = new Account(MainApplication.mConfig.getSamsungAccountID(), MainApplication.mContext.getPackageName());
                        if (accountManager != null) {
                            accountManager.addAccountExplicitly(account, null, null);
                            break;
                        }
                    }
                }
                break;
            case 10002:
                m3004a("ID/PWD WRONG");
                m2999a(3002);
                this.f3153u.sendEmptyMessage(8);
                break;
            case ErrorCode.ERR_CENTER_AUTH_TIMEOUT /* 10081 */:
                m2999a(3004);
                m3004a("COOLOTS login fail 5 times");
                this.f3153u.sendEmptyMessage(8);
                break;
            default:
                m2999a(3010);
                this.f3153u.sendEmptyMessage(8);
                m3004a("LOGINASK ERROR LOGIN START AGAIN");
                break;
        }
    }

    /* renamed from: f */
    private void m3022f() {
        MainApplication.mConfig.deleteAllImg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3023f(Message message) {
        m3011b("handleCipherKeyRep()");
        switch (message.arg1) {
            case 0:
                if (message.obj instanceof CipherKeyRep) {
                    MainApplication.mConfig.setSessionID(((CipherKeyRep) message.obj).getSessionID());
                    MainApplication.mConfig.setCipherKey(((CipherKeyRep) message.obj).getCipherKey());
                    EngineInterface.getInstance().setCipherKey(((CipherKeyRep) message.obj).getCipherKey());
                    EngineInterface.getInstance().setSessionID(((CipherKeyRep) message.obj).getSessionID());
                    m2998a();
                    this.f3153u.sendEmptyMessage(10);
                    return;
                }
                break;
        }
        this.f3153u.sendEmptyMessage(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3025g(Message message) {
        switch (message.arg1) {
            case 0:
                this.f3151s = (ArrayList) message.obj;
                if (!isLogin()) {
                    this.f3153u.sendEmptyMessage(2);
                    if (this.f3151s != null) {
                        m3004a("<<YHT2>> LIST COUNT:" + this.f3151s.size());
                        break;
                    }
                }
                break;
            default:
                this.f3153u.sendEmptyMessage(8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3027h(Message message) {
        if (message.arg1 == 0) {
            if (message.obj != null) {
                ((Handler) message.obj).sendEmptyMessage(10004);
            }
        } else if (message.obj != null) {
            ((Handler) message.obj).sendEmptyMessage(10005);
        }
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void changePassword(String str) {
        m3015c(String.valueOf(str) + MainApplication.mConfig.getNonce());
        EngineInterface.getInstance().setPasswd(this.f3150r);
        MainApplication.mConfig.setProfileRawPwd(str);
        MainApplication.mConfig.setProfilePasswd(this.f3150r);
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void checkNonceExpiredTimePassed() {
        long nonceExpiredTime = MainApplication.mConfig.getNonceExpiredTime() - System.currentTimeMillis();
        Log.m2963i("LOGINOPTIMIZATION remainTime to 24Hour After Nonce Refresh : " + nonceExpiredTime);
        if (nonceExpiredTime <= NONCEEXPIREEDFLAGTIME) {
            Log.m2963i("LOGINOPTIMIZATION Nonce Expired!!!!!!!!!!!!!!!!!!!!!!");
            MainApplication.mConfig.setNonceExpiredTime(-1L);
            setNonce("");
            return;
        }
        if (this.f3156y == null) {
            this.f3156y = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3147o, 0, new Intent(IntentName.ACTION_ALARM_NONCE_TIME), 0);
        this.f3156y.cancel(broadcast);
        this.f3156y.set(2, SystemClock.elapsedRealtime() + (nonceExpiredTime - NONCEEXPIREEDFLAGTIME), broadcast);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f3147o, 0, new Intent(IntentName.ACTION_ALARM_NONCE_DELETE_TIME), 0);
        this.f3156y.cancel(broadcast2);
        this.f3156y.set(2, nonceExpiredTime + SystemClock.elapsedRealtime(), broadcast2);
        Log.m2963i("LOGINOPTIMIZATION Nonce is not Expired regist Alarm Timer!!!!!!!!!!");
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void deleteNonce() {
        setNonce("");
        sendNonceAsk();
    }

    public LoginStateInterface getCurrentLoginState() {
        return this.f3146I;
    }

    public C1282a getEngineReLoginState() {
        return this.f3145H;
    }

    public C1283b getLoginState() {
        return this.f3143F;
    }

    public C1285d getLogoutState() {
        return this.f3157z;
    }

    public C1287f getReqEngineLoginState() {
        return this.f3142E;
    }

    public C1288g getReqEngineLogoutState() {
        return this.f3144G;
    }

    public C1289h getSendCipherKeyAskState() {
        return this.f3138A;
    }

    public C1290i getSendLoginAskState() {
        return this.f3141D;
    }

    public C1291j getSendNonceAskState() {
        return this.f3140C;
    }

    public C1292k getSendServerInfoAskState() {
        return this.f3139B;
    }

    protected abstract void handleAfterLoginProcess();

    public void handlePostLogin(LoginStateInterface loginStateInterface) {
        m3004a("<<YHT2>> login success!!!!!!");
        this.f3152t.m3081b();
        MainApplication.mPhoneManager.getConfigManager().requestReturnPhoneNoAsk();
        handleAfterLoginProcess();
        MainApplication.mPhoneManager.getJoinManager().handleFinishLogin();
        m2999a(EventCode.EVENT_LOGIN_FINISH);
        List pushManager = MainApplication.mPhoneManager.getPushManager();
        if (pushManager != null) {
            Iterator it = pushManager.iterator();
            while (it.hasNext()) {
                ((PushManagerInterface) it.next()).registerDevice(MainApplication.mConfig.getProfileUserID(), MainApplication.mConfig.getProfileDeviceID(), EngineInterface.getInstance());
            }
        }
        this.f3146I = loginStateInterface;
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_START_LOGIN);
    }

    public void handlePostLogout(LoginStateInterface loginStateInterface) {
        m3004a("<<YHT>> handlePostLogout!! bRelogin: " + this.f3148p);
        this.f3146I = loginStateInterface;
        MainApplication.mConfig.setLoginSuccess(false);
        Log.m2963i("LOGINOPTIMIZATION MainApplication.mConfig.setLoginSuccess(false);");
        int iM3080a = this.f3152t.m3080a();
        if (iM3080a <= 0) {
            this.f3152t.m3081b();
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_START_LOGIN);
            m2999a(3001);
        } else {
            if (this.f3148p) {
                this.f3153u.sendEmptyMessageDelayed(0, iM3080a);
            } else {
                MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_START_LOGIN);
            }
            m2999a(3006);
        }
    }

    public final void init() {
        EngineInterface.getInstance().setEngineLoginCallback(this);
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public boolean isDuringLogin() {
        return ((this.f3146I instanceof C1283b) || (this.f3146I instanceof C1285d)) ? false : true;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public boolean isLogin() {
        return this.f3146I instanceof C1283b;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public boolean isValidNonce() {
        if (MainApplication.mConfig.getNonce() != null && !MainApplication.mConfig.getNonce().equals("")) {
            return true;
        }
        Log.m2963i("LOGINOPTIMIZATION Valid Nonce!!!!!!!!!!!!!!!!!!");
        return false;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void login() {
        m3004a("<<YHT2>> login!! start");
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            MainApplication.mPhoneManager.getConfigManager().initCountryCode();
        }
        if (MainApplication.mConfig.getProfileUserID() == null || MainApplication.mConfig.getProfileUserID().equals("")) {
            m3004a("<<YHT3>> login() invalid userID!!");
            m2999a(3005);
            return;
        }
        if (MainApplication.mConfig.getProfileRawPwd() == null || MainApplication.mConfig.getProfileRawPwd().equals("")) {
            m3004a("<<YHT3>> login() invalid userPassword!!");
            m2999a(3005);
            return;
        }
        EventTraceUtil.writeEventTrace(0);
        this.f3148p = true;
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquirePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_START_LOGIN);
        this.f3153u.sendEmptyMessage(0);
        m3004a("QuickPanel - delete Call NOTI!! when ABNORMAL ENDING!!!!- LOG IN");
        MainApplication.mCallNotification.deleteCallNotification();
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void logout(boolean z) {
        m3004a("LOGOUT STARTED");
        if (!z) {
            this.f3148p = false;
        }
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (callStatusData.isValidity() && !CallState.isDisconnected(callStatusData.getCallState())) {
            MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callStatusData.getDestination(), 1001);
            MainApplication.mPhoneManager.getPhoneStateMachine().logout();
        }
        EventTraceUtil.writeEventTrace(1);
        this.f3153u.sendEmptyMessage(1);
        m3004a("QuickPanel - delete Call NOTI!! when ABNORMAL ENDING!!!!- LOGOUT");
        MainApplication.mCallNotification.deleteCallNotification();
        MainApplication.mConfig.setLoginSuccess(false);
        Log.m2963i("LOGINOPTIMIZATION MainApplication.mConfig.setLoginSuccess(false);");
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            m3004a("clean login_preference : nonce reset!!");
            MainApplication.mConfig.setNoce("");
            MainApplication.mConfig.setNonceExpiredTime(-1L);
        }
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void notifyAbsenceToServer(Handler handler) {
        new C1274f(null, null, handler).start();
    }

    @Override // com.sds.coolots.common.controller.EngineLoginCallbackInterface
    public void onAbnormalLogout(int i) {
        this.f3153u.sendEmptyMessage(9);
    }

    @Override // com.sds.coolots.common.controller.EngineLoginCallbackInterface
    public void onLoginSuccess() {
        this.f3153u.sendEmptyMessage(5);
    }

    @Override // com.sds.coolots.common.controller.EngineLoginCallbackInterface
    public void onLogoutSuccess() {
        this.f3153u.sendEmptyMessage(6);
    }

    public void requestEngineLogin(LoginStateInterface loginStateInterface) {
        MainApplication.mConfig.setLoginSuccess(true);
        Log.m2963i("LOGINOPTIMIZATION MainApplication.mConfig.setLoginSuccess(true);");
        EngineInterface.getInstance().initialize(MainApplication.mConfig.getUserNo(), MainApplication.mConfig.getProfileUserID(), MainApplication.mConfig.getProfileDeviceID().shortValue(), MainApplication.mConfig.getProfilePasswd(), f3137w, MainApplication.mConfig.getSessionID(), MainApplication.mConfig.getDecodedCipherKey());
        this.f3146I = loginStateInterface;
    }

    public void requestEngineLogout(LoginStateInterface loginStateInterface) {
        EngineInterface.getInstance().destroy();
        this.f3146I = loginStateInterface;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void resetServerInfo() {
        this.f3153u.sendEmptyMessage(8);
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void sendCipherKeyAsk() {
        m3011b("sendCipherKeyAsk()");
        new CipherKeyAskAdaptor(this.mHandler).start();
    }

    public void sendCipherKeyAsk(LoginStateInterface loginStateInterface) {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        if (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) {
            new CipherKeyAskAdaptor(this.mHandler).start();
        } else {
            this.f3153u.sendEmptyMessage(10);
        }
        this.f3146I = loginStateInterface;
    }

    public void sendDeviceConfigAsk() {
        new DeviceConfigAdaptor(new DeviceConfigAsk(), this.mHandler).start();
    }

    public void sendDeviceIDAsk(LoginStateInterface loginStateInterface) {
        this.f3146I = loginStateInterface;
        if (MainApplication.mConfig.getNonce() != null && !MainApplication.mConfig.getNonce().equals("") && MainApplication.mConfig.getProfileRawPwd() != null && !MainApplication.mConfig.getProfileRawPwd().equals("") && MainApplication.mConfig.getProfilePasswd() != null && !MainApplication.mConfig.getProfilePasswd().equals("") && MainApplication.mConfig.getProfileDeviceID().shortValue() != 0) {
            Log.m2963i("LOGINOPTIMIZATION Valid Nonce - DeviceIDAsk Skip!!!!!!!!!!!!!!");
            m3004a("<<YHT2>> already I have nonce!!!!!!!!!!!!!!!!!!");
            this.f3153u.sendEmptyMessage(3);
        } else {
            m3004a("<<YHT2>> get nonce from server!!!!!!!!!!!!!!!!!!");
            Log.m2963i("LOGINOPTIMIZATION Invalid Nonce - Do DeviceIDAsk!!!!!!!!!!!!!");
            this.f3149q = MainApplication.mConfig.getProfileSerialNo();
            m3006b();
        }
    }

    public void sendLoginAsk(LoginStateInterface loginStateInterface) {
        this.f3146I = loginStateInterface;
        String cipherKey = MainApplication.mConfig.getCipherKey();
        if (!MainApplication.mConfig.getLoginSuccess() || cipherKey == null || cipherKey.isEmpty()) {
            Log.m2963i("LOGINOPTIMIZATION Do LogINAsk !!!!!!!!!!!!!!!!!");
            m3012c();
        } else {
            Log.m2963i("LOGINOPTIMIZATION LogINAsk Skip!!!!!!!!!!!!!!!!!!!!!");
            this.f3153u.sendEmptyMessage(4);
        }
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void sendNonceAsk() {
        sendDeviceConfigAsk();
    }

    public void sendNonceAskSecond() {
        NonceAsk nonceAsk = new NonceAsk();
        nonceAsk.setAppVersion(ModelInfoUtil.getAppVersion(MainApplication.mContext));
        nonceAsk.setApplicationID(MainApplication.mPhoneManager.getApplicationID());
        new C1272d(nonceAsk, this.mHandler).start();
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquirePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_NONCE_REFRESH);
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void sendServerInfoAsk() {
        this.f3153u.sendEmptyMessage(2);
        Server server = new Server();
        server.setServerType("CN");
        this.f3151s.add(server);
        Server server2 = new Server();
        server2.setServerType("UR");
        this.f3151s.add(server2);
        Log.m2963i("LOGINOPTIMIZATION ServerInfo Skip!!!!!!!!!!!!!!!!");
    }

    public void sendServerInfoAsk(LoginStateInterface loginStateInterface) {
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            m3004a("sendServerInfoAsk Network unavailable");
            return;
        }
        if (MainApplication.mConfig.getProfileRawPwd() == null || MainApplication.mConfig.getProfileRawPwd().equals("")) {
            m3004a("sendServerInfoAsk Password Empty");
            return;
        }
        if (this.f3151s == null || this.f3151s.isEmpty()) {
            sendServerInfoAsk();
            updateMediaSettingIfNeeded();
        } else {
            m3004a("sendServerInfoAsk Servers Empty!!!");
            this.f3153u.sendEmptyMessage(2);
        }
        this.f3146I = loginStateInterface;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public ArrayList serverInfo() {
        Iterator it = this.f3151s.iterator();
        while (it.hasNext()) {
            m3011b(((Server) it.next()).getIP());
        }
        return this.f3151s;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void setLoginActivity(EventHandlerInterface eventHandlerInterface) {
        this.f3154v = eventHandlerInterface;
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void setLogoutState() {
        requestEngineLogout(this.f3157z);
        MainApplication.mConfig.setLoginSuccess(false);
        Log.m2963i("LOGINOPTIMIZATION MainApplication.mConfig.setLoginSuccess(false);");
    }

    public void setLogoutStateByError() {
        this.f3146I = this.f3157z;
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_START_LOGIN);
        m2999a(3001);
    }

    @Override // com.sds.coolots.login.LoginManagerInterface
    public void setNonce(String str) {
        MainApplication.mConfig.setNoce(str);
        Log.m2963i("LOGINOPTIMIZATION Nonce Save!!!!!!!!!!!!!! ");
        if ("".equals(str)) {
            return;
        }
        m3007b(f3135m);
        m3016d();
    }

    public void setReLoginState(LoginStateInterface loginStateInterface) {
        this.f3146I = loginStateInterface;
    }

    protected abstract void updateMediaSettingIfNeeded();
}
