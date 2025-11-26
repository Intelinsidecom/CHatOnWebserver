package com.coolots.chaton.join;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.join.adaptor.ChatOnACSAuthAdaptor;
import com.coolots.chaton.join.adaptor.ChatOnAuthValidationAdaptor;
import com.coolots.chaton.join.adaptor.ChatOnSMSAuthAdaptor;
import com.coolots.chaton.join.adaptor.LogoutAdaptor;
import com.coolots.chaton.join.adaptor.PhoneNoAuthAdaptor;
import com.coolots.chaton.join.adaptor.PhoneNoAuthSMSAdaptor;
import com.coolots.chaton.join.adaptor.RegisterPhoneNoAdaptor;
import com.coolots.chaton.join.adaptor.VJoinAdaptor;
import com.coolots.chaton.join.model.BackupAuthInfo;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnJoinAsk;
import com.coolots.p2pmsg.model.CipherKeyRep;
import com.coolots.p2pmsg.model.PhoneNoAuthAsk;
import com.coolots.p2pmsg.model.PhoneNoAuthSMSAsk;
import com.coolots.p2pmsg.model.RegionInfoRep;
import com.coolots.p2pmsg.model.SAUserInfoRep;
import com.coolots.p2pmsg.model.VJoinAsk;
import com.coolots.p2pmsg.model.VJoinRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EventHandlerInterface;
import com.sds.coolots.common.httpAdaptor.ResetMsgKeyAdaptor;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.model.PhoneNoAuthInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.join.adaptor.RegionInfoAdaptor;
import com.sds.coolots.login.adaptor.CipherKeyAskAdaptor;
import com.sds.coolots.login.model.NationalCode;
import com.sec.samsungaccount.adaptor.CreateAccessTokenAdaptor;
import com.sec.samsungaccount.adaptor.SAUserInfoAdaptor;
import com.sec.samsungaccount.adaptor.UpdateAccessTokenAdaptor;
import com.sec.samsungaccount.msg.CreateAccessTokenRep;
import java.io.File;
import java.util.Random;

/* loaded from: classes.dex */
public class ChatOnVJoinManager implements ChatOnVJoinManagerInterface {
    private static final int AUTH_TYPE_CHATON_ACS = 2;
    private static final int AUTH_TYPE_CHATON_SMS = 1;
    private static final int AUTH_TYPE_COOLOTS = 0;
    public static final String CLASSNAME = "[ChatOnVJoinManager]";
    private static final String COOLOTS_PACKAGE = "com.coolots.chaton";
    private static final int PROCESS_IDLE = 0;
    private static final int PROCESS_REQ_AUTH = 3;
    private static final int PROCESS_REQ_JOIN = 4;
    private static final int PROCESS_REQ_REGION = 1;
    private static final int PROCESS_REQ_SMS = 2;
    private BackupAuthInfo mBackupAuthInfo;
    private String mRetryUserName;
    private String strCountryCode;
    private String strCountryCodeIso2;
    private String strMSISDN;
    private String strPassword;
    private String strUserID;
    private String strUserName;
    private String mUserName = null;
    private EventHandlerInterface mUIHandler = null;
    private final Handler mHandler = new JoinHandler(this, null);
    private PhoneNoAuthInfo mPhoneNoAuthInfo = null;
    private int phoneNoModFlag = 0;
    private String strDeviceSerialNo = "";
    private boolean isJoinProcessRun = false;
    private int mAuthType = 0;
    private int mJoinProcessID = 0;

    public enum PHONE_NO_MODE {
        PN_JOIN,
        PN_NONUMBER,
        PN_CONFIG;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static PHONE_NO_MODE[] valuesCustom() {
            PHONE_NO_MODE[] phone_no_modeArrValuesCustom = values();
            int length = phone_no_modeArrValuesCustom.length;
            PHONE_NO_MODE[] phone_no_modeArr = new PHONE_NO_MODE[length];
            System.arraycopy(phone_no_modeArrValuesCustom, 0, phone_no_modeArr, 0, length);
            return phone_no_modeArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void sendJoinEvent(int event) {
        if (this.mUIHandler != null) {
            this.mUIHandler.sendHandlerMessage(event, 0L);
        }
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            Message msg = new Message();
            msg.what = event;
            MainApplication.mPhoneManager.getCoolotsEventListener().onLoginEvent(msg);
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setMobileJoinParam(String identy, String pwd, String name, String number, Integer country, String email, String oriNo, String key) {
        logE("<<YHT11>> setMobileJoinParam!!!!");
        if (MainApplication.mConfig.getProfileUserID() == null || MainApplication.mConfig.getProfileUserID().isEmpty()) {
            this.mBackupAuthInfo = null;
            this.mPhoneNoAuthInfo = null;
            ConfigActivity.setAuthID("");
            logE("<<YHT56>> handleRegisterPhoneNoRep!!! setEnableAutoBuddy false");
            ConfigActivity.setEnableAutoBuddy(false);
            ConfigActivity.setSamsungAccountID(email);
            String guid = ConfigActivity.getSamsungAccountGUID();
            if (guid == null || guid.isEmpty()) {
                if (email != null && email.length() >= 6) {
                    ConfigActivity.setSamsungAccountGUID(email.substring(0, 6));
                } else {
                    return;
                }
            }
            sendJoinEvent(1000);
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinMember(String identy, String pwd, String name, String serial, String phone, String country) {
        if (identy != null && !identy.isEmpty() && country != null && !country.isEmpty()) {
            if (checkJoinedUserID(identy)) {
                if (!MainApplication.mPhoneManager.getLoginManager().isDuringLogin() && !MainApplication.mPhoneManager.getLoginManager().isLogin()) {
                    MainApplication.mPhoneManager.getLoginManager().login();
                    return;
                }
                return;
            }
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                MainApplication.mConfig.setProfileUserID(identy);
                MainApplication.mConfig.setProfileRawPwd("sds");
                MainApplication.mConfig.setProfileRawPwdCheck(true);
                MainApplication.mConfig.setProfileSerialNo("");
                ConfigActivity.setSamsungAccountID(ChatONStringConvert.getInstance().deleteFooter(identy));
                this.mUserName = name;
                ((ChatOnConfigInterface) MainApplication.mConfig).setBackupJoinUserID(identy);
                ((ChatOnConfigInterface) MainApplication.mConfig).setBackupJoinCountryCode(country);
                ((ChatOnConfigInterface) MainApplication.mConfig).setBackupLinkUserName(name);
            } else {
                MainApplication.mConfig.setProfileRawPwd("");
                MainApplication.mConfig.setProfileSerialNo("");
            }
            this.strCountryCodeIso2 = country;
            this.strMSISDN = identy;
            this.strUserID = getChatOnID(identy);
            this.strUserName = getUserName(identy);
            this.strPassword = getPassword(identy);
            this.strCountryCode = getISO2CountryCode(country);
            this.strDeviceSerialNo = ((ChatOnConfigInterface) MainApplication.mConfig).getChatonSerialNumber();
            if (this.strDeviceSerialNo == null || this.strDeviceSerialNo.isEmpty()) {
                this.strDeviceSerialNo = "000000000000000";
            }
            MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
            sendRegionInfoAsk();
        }
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void requestPhoneNoAuth(Integer countryCode, String phoneNo, String language, boolean useSMS, int isOk) {
        if (isOk != 0) {
            this.phoneNoModFlag = isOk;
        }
        PhoneNoAuthInfo authInfo = new PhoneNoAuthInfo();
        authInfo.setCountryCode(countryCode);
        authInfo.setPhoneNo(phoneNo);
        sendPhoneNoAuthAsk(useSMS, language, authInfo);
    }

    private void sendPhoneNoAuthAsk(boolean useSMS, String language, PhoneNoAuthInfo authInfo) {
        this.mJoinProcessID = 2;
        String serial = MainApplication.mConfig.getProfileSerialNo();
        if (((VAppPhoneManager) MainApplication.mPhoneManager).isUnlimitedSMS()) {
            serial = String.valueOf(serial) + new Random().nextInt();
        }
        String guid = ConfigActivity.getSamsungAccountGUID();
        if (useSMS) {
            this.mAuthType = 1;
            logE("<<YHT2>> BackupAuthInfo AUTH_TYPE_CHATON_SMS, true");
            this.mBackupAuthInfo = new BackupAuthInfo(authInfo.getCountryCode().intValue(), authInfo.getPhoneNo(), true, language, "");
            ChatOnSMSAuthAdaptor adaptor = new ChatOnSMSAuthAdaptor(authInfo, serial, guid, this.mHandler);
            adaptor.start();
            return;
        }
        this.mAuthType = 2;
        logE("<<YHT2>> BackupAuthInfo AUTH_TYPE_CHATON_ACS, false");
        this.mBackupAuthInfo = new BackupAuthInfo(authInfo.getCountryCode().intValue(), authInfo.getPhoneNo(), false, language, "");
        ChatOnACSAuthAdaptor adaptor2 = new ChatOnACSAuthAdaptor(authInfo, serial, language, guid, this.mHandler);
        adaptor2.start();
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthSMS(Integer countryCode, String phoneNo, Handler uiHandler, Object parent, int isOk) {
        if (isOk != 0) {
            this.phoneNoModFlag = isOk;
        }
        this.mPhoneNoAuthInfo = new PhoneNoAuthInfo();
        if (parent != null) {
            this.mPhoneNoAuthInfo.setParent(parent.getClass());
        }
        this.mPhoneNoAuthInfo.setCountryCode(countryCode);
        this.mPhoneNoAuthInfo.setPhoneNo(phoneNo);
        sendPhoneNoAuthSMSAsk(countryCode, phoneNo);
    }

    private void sendPhoneNoAuthSMSAsk(Integer countryCode, String phoneNo) {
        this.mJoinProcessID = 2;
        this.mAuthType = 0;
        logE("<<YHT2>> BackupAuthInfo AUTH_TYPE_COOLOTS, true");
        this.mBackupAuthInfo = new BackupAuthInfo(countryCode.intValue(), phoneNo, true, "", "");
        PhoneNoAuthSMSAsk ask = new PhoneNoAuthSMSAsk();
        ask.setCountryCode(countryCode);
        ask.setPhoneNo(phoneNo);
        PhoneNoAuthSMSAdaptor adaptor = new PhoneNoAuthSMSAdaptor(ask, this.mHandler, this.mPhoneNoAuthInfo);
        adaptor.start();
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthAsk(String authNo) {
        if (this.mPhoneNoAuthInfo == null || this.mPhoneNoAuthInfo.getAuthID() == null) {
            logE("------------------------------------- mPhoneNoAuthInfo == null ");
            return;
        }
        this.mJoinProcessID = 3;
        if (this.mBackupAuthInfo == null) {
            logE("<<YHT2>> BackupAuthInfo PROCESS_REQ_AUTH, true");
            this.mBackupAuthInfo = new BackupAuthInfo(0, "", true, "", authNo);
        } else {
            this.mBackupAuthInfo.authCode = authNo;
        }
        if (this.mAuthType == 0) {
            PhoneNoAuthAsk ask = new PhoneNoAuthAsk();
            ask.setAuthID(this.mPhoneNoAuthInfo.getAuthID());
            ask.setAuthNo(authNo);
            PhoneNoAuthAdaptor adaptor = new PhoneNoAuthAdaptor(ask, this.mHandler);
            adaptor.start();
            return;
        }
        String guid = ConfigActivity.getSamsungAccountGUID();
        ChatOnAuthValidationAdaptor adaptor2 = new ChatOnAuthValidationAdaptor(this.mPhoneNoAuthInfo, authNo, guid, this.mHandler);
        adaptor2.start();
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void startJoin(String userName) {
        sendVJoinAsk(userName);
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccount() {
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().setProcessingDataReset(true);
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            MainApplication.mPhoneManager.getLoginManager().notifyAbsenceToServer(null);
        }
        LogoutAdaptor adaptor = new LogoutAdaptor(this.mHandler);
        adaptor.start();
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            MainApplication.mPhoneManager.getLoginManager().logout(false);
            MainApplication.mPhoneManager.resetDatabase();
            File prefesFolders = MainApplication.mContext.getDir("shared_prefs", 0);
            String path = prefesFolders.getAbsolutePath();
            removeFiles(String.valueOf(path.replace("app_", "")) + "/");
            removeFiles(String.valueOf(MainApplication.mContext.getFilesDir().toString()) + "/");
            if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
                MainApplication.mPhoneManager.getDataUsageManager().setProcessingDataReset(false);
            }
            MainApplication.mConfig.clearCoolotsPref();
            MainApplication.mConfig.cleanSharedPreference(true);
            MainApplication.mConfig.resetPrefValues();
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccountFromWeb() {
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().setProcessingDataReset(true);
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            MainApplication.mPhoneManager.getLoginManager().notifyAbsenceToServer(null);
        }
        MainApplication.mPhoneManager.getLoginManager().logout(false);
        MainApplication.mPhoneManager.resetDatabase();
        File prefesFolders = MainApplication.mContext.getDir("shared_prefs", 0);
        String path = prefesFolders.getAbsolutePath();
        removeFiles(String.valueOf(path.replace("app_", "")) + "/");
        removeFiles(String.valueOf(MainApplication.mContext.getFilesDir().toString()) + "/");
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().setProcessingDataReset(false);
        }
        MainApplication.mConfig.clearCoolotsPref();
        MainApplication.mConfig.cleanSharedPreference(true);
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void resetPhoneNoAuthInfo() {
        this.mPhoneNoAuthInfo = null;
    }

    private void removeFiles(String path) {
        File dir = new File(path);
        String[] children = dir.list();
        if (children != null) {
            for (String filename : children) {
                File nFile = new File(String.valueOf(path) + filename);
                if (nFile.isDirectory()) {
                    removeFiles(String.valueOf(path) + filename + "/");
                } else {
                    nFile.delete();
                }
            }
        }
        dir.delete();
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface, com.sds.coolots.login.JoinManagerInterface
    public void sendCipherKeyAsk() {
        String mSessionID = MainApplication.mConfig.getSessionID();
        byte[] mCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            logI("sendCipherKeyAsk: " + mSessionID + " " + mCipherKey);
            CipherKeyAskAdaptor adaptor = new CipherKeyAskAdaptor(this.mHandler);
            adaptor.start();
        } else {
            if (mSessionID == null || mSessionID.isEmpty() || mCipherKey == null || mCipherKey.length == 0) {
                CipherKeyAskAdaptor adaptor2 = new CipherKeyAskAdaptor(this.mHandler);
                adaptor2.start();
                return;
            }
            if (this.mJoinProcessID == 1) {
                sendJoinEvent(1010);
            }
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                CipherKeyAskAdaptor adaptor3 = new CipherKeyAskAdaptor(this.mHandler);
                adaptor3.start();
            }
        }
    }

    private void sendResetMsgKeyAsk() {
        ResetMsgKeyAdaptor adaptor = new ResetMsgKeyAdaptor(this.mHandler);
        adaptor.start();
    }

    private void sendVJoinAsk(String userName) {
        this.mJoinProcessID = 4;
        this.mRetryUserName = userName;
        VJoinAsk ask = new VJoinAsk();
        ask.setUserID(ConfigActivity.getSamsungAccountID());
        ask.setSamsungAccountID(ConfigActivity.getSamsungAccountGUID());
        ask.setNationalCode(this.strCountryCode);
        ask.setUserName(userName);
        ask.setBirthDate(ConfigActivity.getSamsungAccountBirthDay());
        ConfigActivity.setSamsungAccountBirthDay("");
        VJoinAdaptor adaptor = new VJoinAdaptor(ask, this.mHandler);
        adaptor.start();
    }

    private void sendRegionInfoAsk() {
        this.mJoinProcessID = 1;
        RegionInfoAdaptor adaptor = new RegionInfoAdaptor(this.strCountryCodeIso2, null, this.mHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void sendCreateAccessTokenAsk(String strAuthCode) {
        if (ConfigActivity.getSamsungAccountClient_id().equals("") || ConfigActivity.getSamsungAccountSecret_key().equals("")) {
            logE("<<KTW-JOIN>> Client_id or Secret_key is null");
        } else {
            CreateAccessTokenAdaptor adaptor = new CreateAccessTokenAdaptor(ConfigActivity.getSamsungAccountClient_id(), ConfigActivity.getSamsungAccountSecret_key(), "", strAuthCode, this.mHandler);
            adaptor.start();
        }
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void sendSAUserInfoAsk(String accountID, String accessToken) {
        SAUserInfoAdaptor adaptor = new SAUserInfoAdaptor(accountID, accessToken, this.mHandler);
        adaptor.start();
    }

    private void sendUpdateAccessTokenAsk() {
        ChatOnJoinAsk ask = new ChatOnJoinAsk();
        ask.setUserID(getJoinID());
        MainApplication.mPhoneManager.IsLinkagewithChatON();
        ask.setNationalCode(this.strCountryCode);
        UpdateAccessTokenAdaptor adaptor = new UpdateAccessTokenAdaptor("", ConfigActivity.getSamsungAccountClient_id(), ConfigActivity.getSamsungAccountSecret_key(), "Http://SERVER_DOMAIN/auth/oauth2/token", this.mHandler);
        adaptor.start();
    }

    private void sendChatOnSkipAuthAsk() {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            if (this.mUserName != null) {
                ((ChatOnVJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).startJoin(this.mUserName);
                return;
            }
            return;
        }
        TelephonyManager telManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        String phoneNum = telManager.getLine1Number();
        String simCountryISO = telManager.getSimCountryIso();
        if (phoneNum == null || phoneNum.isEmpty() || simCountryISO == null || simCountryISO.isEmpty()) {
            sendJoinEvent(1010);
            return;
        }
        NationalCode nationalCode = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(simCountryISO);
        if (nationalCode == null) {
            sendJoinEvent(1010);
        } else {
            sendJoinEvent(1010);
        }
    }

    private boolean checkJoinedUserID(String identy) {
        String newID = getChatOnID(identy);
        String joinedID = MainApplication.mConfig.getProfileUserID();
        return newID.equals(joinedID);
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinID() {
        return this.strUserID;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinPwd() {
        return this.strPassword;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinName() {
        return this.strUserName;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinPhoneNo() {
        return this.strMSISDN;
    }

    private String getChatOnID(String strMsisdn) {
        return String.valueOf(strMsisdn) + "@v";
    }

    private String getUserName(String strMsisdn) {
        return strMsisdn;
    }

    private String getPassword(String strMsisdn) {
        return MainApplication.mPhoneManager.getConfigManager().getPassword(strMsisdn);
    }

    private String getISO2CountryCode(String iso2CountryCode) {
        NationalCode countryCode = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(iso2CountryCode);
        return countryCode == null ? "KR" : countryCode.getIso2();
    }

    private int getIntegerCountryCode(String iso3CountryCode) {
        NationalCode countryCode = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(iso3CountryCode);
        if (countryCode == null) {
            return 82;
        }
        return Integer.parseInt(countryCode.getcountryCode());
    }

    private void sendRegisterPhoneNoAsk(String authID) {
        RegisterPhoneNoAdaptor adaptor = new RegisterPhoneNoAdaptor(authID, this.mHandler);
        adaptor.start();
    }

    private class JoinHandler extends Handler {
        private JoinHandler() {
        }

        /* synthetic */ JoinHandler(ChatOnVJoinManager chatOnVJoinManager, JoinHandler joinHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws NumberFormatException {
            ChatOnVJoinManager.this.logE("handleMessage");
            if (msg.what != MessageInfo.CipherKeyAsk.getDispatchCode()) {
                if (msg.what != MessageInfo.RegionInfoAsk.getDispatchCode()) {
                    if (msg.what != MessageInfo.ChatOnSkipAuthAsk.getDispatchCode()) {
                        if (msg.what != MessageInfo.VJoinAsk.getDispatchCode()) {
                            if (msg.what != MessageInfo.PhoneNoAuthSMSAsk.getDispatchCode()) {
                                if (msg.what != MessageInfo.PhoneNoAuthAsk.getDispatchCode()) {
                                    if (msg.what != MessageInfo.ChatOnSMSAuthAsk.getDispatchCode()) {
                                        if (msg.what != MessageInfo.ChatOnACSAuthAsk.getDispatchCode()) {
                                            if (msg.what != MessageInfo.ChatOnAuthValidationAsk.getDispatchCode()) {
                                                if (msg.what != 90003) {
                                                    if (msg.what != MessageInfo.SAUserInfoAsk.getDispatchCode()) {
                                                        if (msg.what != MessageInfo.RegisterPhoneNoAsk.getDispatchCode()) {
                                                            if (msg.what != MessageInfo.LogoutAsk.getDispatchCode()) {
                                                                return;
                                                            }
                                                            ChatOnVJoinManager.this.handleLogoutRep();
                                                            return;
                                                        }
                                                        ChatOnVJoinManager.this.handleRegisterPhoneNoRep(msg);
                                                        return;
                                                    }
                                                    ChatOnVJoinManager.this.handleSAUserInfoRep(msg);
                                                    return;
                                                }
                                                ChatOnVJoinManager.this.handleCreateAccessToken(msg);
                                                return;
                                            }
                                            ChatOnVJoinManager.this.handlePhoneNoAuthRep(msg);
                                            return;
                                        }
                                        ChatOnVJoinManager.this.handlePhoneNoAuthSMSRep(msg);
                                        return;
                                    }
                                    ChatOnVJoinManager.this.handlePhoneNoAuthSMSRep(msg);
                                    return;
                                }
                                ChatOnVJoinManager.this.handlePhoneNoAuthRep(msg);
                                return;
                            }
                            ChatOnVJoinManager.this.handlePhoneNoAuthSMSRep(msg);
                            return;
                        }
                        ChatOnVJoinManager.this.handleVJoinRep(msg);
                        return;
                    }
                    ChatOnVJoinManager.this.handleChatOnSkipAuthRep(msg);
                    return;
                }
                ChatOnVJoinManager.this.handleRegionInfoRep(msg);
                return;
            }
            ChatOnVJoinManager.this.handleCipherKeyRep(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVJoinRep(Message msg) {
        logE("handleVJoinRep is called");
        if (msg.arg1 == 1) {
            MainApplication.mConfig.setProfileCountryCode(Integer.valueOf(getIntegerCountryCode(this.strCountryCode)));
            MainApplication.mConfig.setProfilePhoneNo(getJoinPhoneNo());
            MainApplication.mConfig.setProfileUserName(getJoinName());
            MainApplication.mConfig.setProfileUserID(getJoinID());
            MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
            MainApplication.mConfig.setProfileDeviceID((short) 0);
            MainApplication.mConfig.setUserNo(((VJoinRep) msg.obj).getUserNo().longValue());
            if (getJoinPwd() != null && getJoinPwd().length() != 0) {
                MainApplication.mConfig.setProfileRawPwd(getJoinPwd());
                MainApplication.mConfig.setProfileRawPwdCheck(true);
            }
            if (this.mPhoneNoAuthInfo != null && this.mPhoneNoAuthInfo.getResult()) {
                MainApplication.mConfig.setAuthID(this.mPhoneNoAuthInfo.getAuthID());
                logE("<<YHT56>> handleRegisterPhoneNoRep!!! setEnableAutoBuddy true");
                ConfigActivity.setEnableAutoBuddy(true);
            } else {
                MainApplication.mConfig.setAuthID("");
                logE("<<YHT56>> handleRegisterPhoneNoRep!!! setEnableAutoBuddy false");
                ConfigActivity.setEnableAutoBuddy(false);
            }
            this.mPhoneNoAuthInfo = null;
            this.mBackupAuthInfo = null;
            logE("join end!!");
            sendJoinEvent(EventCode.EVENT_JOIN_SUCCESS);
            if (VAppPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
                MainApplication.mPhoneManager.getLoginManager().login();
            } else {
                VAppPhoneManager.startCoolotsService(MainApplication.mContext, false);
            }
        } else if (msg.arg1 == -1) {
            logE("join error!!");
            sendJoinEvent(EventCode.EVENT_JOIN_FAIL);
        } else if (msg.arg1 == 10082) {
            sendCipherKeyAsk();
        } else {
            sendJoinEvent(EventCode.EVNET_JOIN_NETWORK_ERROR);
            logE("join failure!!");
        }
        this.isJoinProcessRun = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCipherKeyRep(Message msg) {
        if (msg.obj instanceof CipherKeyRep) {
            logI("haeri= session id?" + ((CipherKeyRep) msg.obj).getSessionID() + "/cipher key?" + ((CipherKeyRep) msg.obj).getCipherKey());
            MainApplication.mConfig.setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            MainApplication.mConfig.setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            switch (this.mJoinProcessID) {
                case 2:
                    if (this.mBackupAuthInfo != null) {
                        if (this.mAuthType == 0) {
                            sendPhoneNoAuthSMSAsk(Integer.valueOf(this.mBackupAuthInfo.countryCode), this.mBackupAuthInfo.phoneNo);
                            break;
                        } else {
                            PhoneNoAuthInfo authInfo = new PhoneNoAuthInfo();
                            authInfo.setCountryCode(Integer.valueOf(this.mBackupAuthInfo.countryCode));
                            authInfo.setPhoneNo(this.mBackupAuthInfo.phoneNo);
                            sendPhoneNoAuthAsk(this.mBackupAuthInfo.isSMS, this.mBackupAuthInfo.language, authInfo);
                            break;
                        }
                    } else {
                        return;
                    }
                case 3:
                    if (this.mBackupAuthInfo != null && this.mBackupAuthInfo.authCode != null) {
                        requestServerPhoneNoAuthAsk(this.mBackupAuthInfo.authCode);
                        break;
                    } else {
                        return;
                    }
                    break;
                case 4:
                    sendVJoinAsk(this.mRetryUserName);
                    break;
                default:
                    sendChatOnSkipAuthAsk();
                    break;
            }
            sendResetMsgKeyAsk();
            return;
        }
        sendJoinEvent(1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRegionInfoRep(Message msg) {
        Log.m2963i("handleRegionInfoRep()");
        if (msg.arg1 == 0) {
            if (msg.obj instanceof RegionInfoRep) {
                RegionInfoRep rep = (RegionInfoRep) msg.obj;
                ((ChatOnConfigInterface) MainApplication.mConfig).setLocalCenterDomain(rep.getDomain());
            }
            sendCipherKeyAsk();
            return;
        }
        logE("[handleRegionInfoRep] fail RegionInfoAsk!! error:" + msg.arg1);
        sendJoinEvent(1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChatOnSkipAuthRep(Message msg) {
        Log.m2963i("handleRegionInfoRep()");
        if (msg.arg1 == 0) {
            this.mPhoneNoAuthInfo = (PhoneNoAuthInfo) msg.obj;
            sendJoinEvent(1012);
        } else {
            sendJoinEvent(1010);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePhoneNoAuthSMSRep(Message msg) {
        if (msg.arg1 == 0 && msg.obj != null) {
            logE("<<YHT2>> handlePhoneNoAuthSMSRep set PhoneNoAuthInfo!!!!");
            this.mPhoneNoAuthInfo = (PhoneNoAuthInfo) msg.obj;
            sendJoinEvent(EventCode.EVENT_JOIN_REQUEST_AUTH_SUCCESS);
            return;
        }
        if (msg.arg1 == 10082) {
            sendCipherKeyAsk();
            return;
        }
        if (msg.arg1 == 10105) {
            if (this.mAuthType == 2) {
                sendJoinEvent(1024);
                return;
            } else {
                sendJoinEvent(EventCode.EVENT_JOIN_REQUEST_AUTH_SMS_WAIT);
                return;
            }
        }
        if (msg.arg1 == 10106) {
            if (this.mAuthType == 2) {
                sendJoinEvent(1025);
                return;
            } else {
                sendJoinEvent(EventCode.EVENT_JOIN_REQUEST_AUTH_SMS_OVER_LIMIT);
                return;
            }
        }
        sendJoinEvent(EventCode.EVNET_JOIN_REQUEST_AUTH_NETWORK_ERROR);
    }

    private void handlePhoneNoAuthACSRep(Message msg) {
        if (msg.arg1 == 0 && msg.obj != null) {
            logE("<<YHT2>> handlePhoneNoAuthACSRep set PhoneNoAuthInfo!!!!");
            this.mPhoneNoAuthInfo = (PhoneNoAuthInfo) msg.obj;
            sendJoinEvent(EventCode.EVENT_JOIN_REQUEST_AUTH_SUCCESS);
            return;
        }
        sendJoinEvent(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePhoneNoAuthRep(Message msg) {
        if (msg.arg1 == 0) {
            if (this.mPhoneNoAuthInfo != null) {
                this.mPhoneNoAuthInfo.setResult(true);
                sendJoinEvent(1030);
                handlerPhoneNoAuthAsk();
                return;
            }
            return;
        }
        if (msg.arg1 == -9000 || msg.arg1 == 10086) {
            sendJoinEvent(1032);
        } else if (msg.arg1 == 10082) {
            sendCipherKeyAsk();
        } else {
            sendJoinEvent(1031);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCreateAccessToken(Message msg) {
        if (msg.arg1 == 0) {
            CreateAccessTokenRep rep = (CreateAccessTokenRep) msg.obj;
            sendSAUserInfoAsk(rep.parseUserID(), rep.parseAccessToken());
        } else {
            sendJoinEvent(1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSAUserInfoRep(Message msg) throws NumberFormatException {
        if (msg.arg1 == 0) {
            SAUserInfoRep rep = (SAUserInfoRep) msg.obj;
            int countryCode = 82;
            NationalCode code = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(rep.getCountryCode2());
            if (code != null) {
                try {
                    countryCode = Integer.parseInt(code.getcountryCode());
                } catch (Exception e) {
                    logE("<<YHT2>> fail to parse countryCode to integer!! countryCode:");
                }
            }
            ConfigActivity.setSamsungAccountBirthDay(rep.getBirthdate());
            ConfigActivity.setSamsungAccountCountryCode(rep.getCountryCode2());
            String accountID = ConfigActivity.getSamsungAccountID();
            if (accountID == null || accountID.isEmpty()) {
                sendJoinEvent(1001);
                return;
            } else {
                setMobileJoinParam("", "", "", "", Integer.valueOf(countryCode), accountID, "", "");
                return;
            }
        }
        sendJoinEvent(1001);
    }

    private void handlerPhoneNoAuthAsk() {
        if (this.mPhoneNoAuthInfo != null && this.mPhoneNoAuthInfo.getAuthID() != null && this.mPhoneNoAuthInfo.getClass() != null) {
            switch (this.phoneNoModFlag) {
                case 0:
                    break;
                case 1:
                case 2:
                    sendRegisterPhoneNoAsk(this.mPhoneNoAuthInfo.getAuthID());
                    break;
                default:
                    clearSmsAuth();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRegisterPhoneNoRep(Message msg) {
        if (msg.arg1 == 0) {
            logE("<<YHT56>> handleRegisterPhoneNoRep!!! setEnableAutoBuddy true");
            ConfigActivity.setEnableAutoBuddy(true);
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().updateProfileInfo(null);
            sendJoinEvent(EventCode.EVENT_PHONENO_REGISTER_SUCCESS);
            return;
        }
        sendJoinEvent(EventCode.EVENT_PHONENO_REGISTER_FAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogoutRep() {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            MainApplication.mPhoneManager.getLoginManager().logout(false);
            MainApplication.mPhoneManager.resetDatabase();
            File prefesFolders = MainApplication.mContext.getDir("shared_prefs", 0);
            String path = prefesFolders.getAbsolutePath();
            removeFiles(String.valueOf(path.replace("app_", "")) + "/");
            removeFiles(String.valueOf(MainApplication.mContext.getFilesDir().toString()) + "/");
            if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
                MainApplication.mPhoneManager.getDataUsageManager().setProcessingDataReset(false);
            }
            MainApplication.mConfig.clearCoolotsPref();
            MainApplication.mConfig.cleanSharedPreference(true);
            MainApplication.mConfig.resetPrefValues();
            MainApplication.mPhoneManager.getLoginManager().setLogoutState();
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestDuplicateCheck(String _id) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void clearSmsAuth() {
        this.mPhoneNoAuthInfo = null;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinActivity(EventHandlerInterface activity) {
        logE("<<YHT11>> setJoinActivity!!!!");
        this.mUIHandler = activity;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinPhoneNoActivity(EventHandlerInterface activity) {
        logE("<<YHT11>> setJoinPhoneNoActivity!!!!");
        this.mUIHandler = activity;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void handleFinishLogin() {
        sendJoinEvent(3000);
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getSMSAuthID() {
        if (this.mPhoneNoAuthInfo == null) {
            return null;
        }
        return this.mPhoneNoAuthInfo.getAuthID();
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public boolean isExistChatONVAccount() {
        AccountManager accountManager = AccountManager.get(MainApplication.mContext);
        Account[] accounts = accountManager.getAccountsByType(COOLOTS_PACKAGE);
        if (accounts.length > 0) {
            logE("<CIH> return true");
            return true;
        }
        logE("<CIH> return false");
        return false;
    }

    @Override // com.coolots.chaton.join.ChatOnVJoinManagerInterface
    public void deleteChatONVAccount() {
        AccountManager accountManager = AccountManager.get(MainApplication.mContext);
        Account[] accounts = accountManager.getAccountsByType(COOLOTS_PACKAGE);
        for (Account account : accounts) {
            logI("<CIH> account.name = " + account.name + ", account.type = " + account.type);
            accountManager.removeAccount(account, null, null);
        }
    }
}
