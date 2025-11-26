package com.coolots.sse.join;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.join.adaptor.LogoutAdaptor;
import com.coolots.common.CoolotsCode;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.CipherKeyRep;
import com.coolots.p2pmsg.model.RegionInfoRep;
import com.coolots.p2pmsg.model.ResetMsgKeyRep;
import com.coolots.p2pmsg.model.SSEJoinAsk;
import com.coolots.p2pmsg.model.SSEJoinRep;
import com.coolots.sse.common.controller.SSEPhoneManager;
import com.coolots.sse.common.util.SSELibraryInfo;
import com.coolots.sse.common.view.ConfigActivity;
import com.coolots.sse.join.adaptor.SSEJoinAdaptor;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EventHandlerInterface;
import com.sds.coolots.common.httpAdaptor.ResetMsgKeyAdaptor;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.model.PhoneNoAuthInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.join.adaptor.RegionInfoAdaptor;
import com.sds.coolots.login.LoginManagerInterface;
import com.sds.coolots.login.PushManagerInterface;
import com.sds.coolots.login.adaptor.CipherKeyAskAdaptor;
import com.sds.coolots.login.model.NationalCode;
import java.util.List;

/* loaded from: classes.dex */
public class SSEJoinManager implements SSEJoinMainagerInterface {
    public static final String CLASSNAME = "[SSEJoinManager]";
    private static final int PROCESS_IDLE = 0;
    private static final int PROCESS_REQ_AUTH = 3;
    private static final int PROCESS_REQ_JOIN = 4;
    private static final int PROCESS_REQ_REGION = 1;
    private static final int PROCESS_REQ_SMS = 2;
    private String mRetryAuthCode;
    private Integer mRetryCountryCode;
    private String mRetryPhoneNo;
    private String mRetryUserName;
    private String strCountryCode;
    private String strCountryCodeIso2;
    private String strMSISDN;
    private String strPassword;
    private String strUserID;
    private String strUserName;
    private EventHandlerInterface mUIHandler = null;
    private final Handler mHandler = new JoinHandler(this, null);
    private PhoneNoAuthInfo mPhoneNoAuthInfo = null;
    private int phoneNoModFlag = 0;
    private String strDeviceSerialNo = "";
    private boolean isJoinProcessRun = false;
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

    private void logE(String message) {
        Log.m2958e("[SSEJoinManager]" + message);
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
    }

    @Override // com.coolots.sse.join.SSEJoinMainagerInterface
    public void setSSEJoinMember(String email, String country, String Userid) {
        if (!this.isJoinProcessRun && email != null && !email.isEmpty() && country != null && !country.isEmpty() && Userid != null && !Userid.isEmpty()) {
            if (checkJoinedUserID(Userid)) {
                if (!MainApplication.mPhoneManager.getLoginManager().isDuringLogin() && !MainApplication.mPhoneManager.getLoginManager().isLogin()) {
                    MainApplication.mPhoneManager.getLoginManager().login();
                    return;
                }
                return;
            }
            MainApplication.mConfig.setProfileRawPwd("");
            MainApplication.mConfig.setProfileSerialNo("");
            ConfigActivity.setSamsungAccountID(getChatOnID(email));
            ConfigActivity.setSamsungAccountGUID(Userid);
            this.strCountryCodeIso2 = country;
            this.strMSISDN = email;
            this.strUserID = getChatOnID(email);
            this.strUserName = getUserName(email);
            this.strPassword = getPassword(email);
            this.strCountryCode = getISO2CountryCode(country);
            this.strDeviceSerialNo = ((ChatOnConfigInterface) MainApplication.mConfig).getChatonSerialNumber();
            if (this.strDeviceSerialNo == null || this.strDeviceSerialNo.isEmpty()) {
                this.strDeviceSerialNo = "000000000000000";
                MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
            } else {
                MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
            }
            ((ChatOnConfigInterface) MainApplication.mConfig).setLocalCenterDomain(SSELibraryInfo.getServerDomain());
            sendCipherKeyAsk();
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinMember(String identy, String pwd, String name, String serial, String phone, String country) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthSMS(Integer countryCode, String phoneNo, Handler uiHandler, Object parent, int isOk) {
    }

    private void sendPhoneNoAuthSMSAsk(Integer countryCode, String phoneNo) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthAsk(String authNo) {
    }

    @Override // com.coolots.sse.join.SSEJoinMainagerInterface
    public void startJoin(String userName) {
        sendSSEJoinAsk(userName);
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccount() {
        List<PushManagerInterface> pushManagerList = MainApplication.mPhoneManager.getPushManager();
        if (pushManagerList != null) {
            for (PushManagerInterface pushManager : pushManagerList) {
                pushManager.unregisterDevice();
            }
        }
        LogoutAdaptor adaptor = new LogoutAdaptor(this.mHandler);
        adaptor.start();
        MainApplication.mConfig.setProfileUserID("");
        MainApplication.mConfig.setProfileRawPwd("");
        MainApplication.mConfig.setProfileSerialNo("");
        MainApplication.mPhoneManager.getLoginManager().logout(false);
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void sendCipherKeyAsk() {
        logE("sendCipherKeyAsk is start");
        String mSessionID = MainApplication.mConfig.getSessionID();
        byte[] mCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        if (mSessionID == null || mSessionID.isEmpty()) {
            logE("sessionID is null");
        }
        if (mCipherKey == null || mCipherKey.length == 0) {
            logE("cipherKey is null");
        }
        if (mSessionID == null || mSessionID.isEmpty() || mCipherKey == null || mCipherKey.length == 0) {
            logE("sendCipherKeyAsk is start- 1");
            CipherKeyAskAdaptor adaptor = new CipherKeyAskAdaptor(this.mHandler);
            adaptor.start();
        } else {
            logE("CipherKeyAskAdaptor is start- 2");
            if (this.mJoinProcessID == 1) {
                sendJoinEvent(1010);
            }
        }
    }

    private void sendResetMsgKeyAsk() {
        logE("sendResetMsgKeyAsk is start");
        ResetMsgKeyAdaptor adaptor = new ResetMsgKeyAdaptor(this.mHandler);
        adaptor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResetMsgKeyRep(Message msg) {
        logE("handleResetMsgKeyRep is start");
        if (msg.arg1 == 0) {
            if (msg.obj instanceof ResetMsgKeyRep) {
                sendSSEJoinAsk("UserName");
            }
        } else {
            logE("handleResetMsgKeyRep -2");
            sendJoinEvent(1011);
            this.mJoinProcessID = 0;
        }
    }

    private void sendSSEJoinAsk(String userName) {
        logE("sendSSEJoinAsk is start");
        this.mJoinProcessID = 4;
        this.mRetryUserName = userName;
        SSEJoinAsk ask = new SSEJoinAsk();
        String userID = ConfigActivity.getSamsungAccountID();
        ask.setUserID(userID);
        ask.setSamsungAccountID(ConfigActivity.getSamsungAccountGUID());
        ask.setNationalCode(this.strCountryCode);
        ask.setUserName(userName);
        ask.setBirthDate("");
        SSEJoinAdaptor adaptor = new SSEJoinAdaptor(ask, this.mHandler);
        adaptor.start();
    }

    private void sendRegionInfoAsk() {
        this.mJoinProcessID = 1;
        RegionInfoAdaptor adaptor = new RegionInfoAdaptor(this.strCountryCodeIso2, null, this.mHandler);
        adaptor.start();
    }

    @Override // com.coolots.sse.join.SSEJoinMainagerInterface
    public void sendCreateAccessTokenAsk(String strAuthCode) {
    }

    @Override // com.coolots.sse.join.SSEJoinMainagerInterface
    public void sendSAUserInfoAsk(String accountID, String accessToken) {
    }

    private void sendUpdateAccessTokenAsk() {
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
        return String.valueOf(strMsisdn) + CoolotsCode.ID_DOMAIN_SSE;
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

    private int getIntegerCountryCode(String iso2CountryCode) {
        NationalCode countryCode = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(iso2CountryCode);
        if (countryCode == null) {
            return 82;
        }
        return Integer.parseInt(countryCode.getcountryCode());
    }

    private class JoinHandler extends Handler {
        private JoinHandler() {
        }

        /* synthetic */ JoinHandler(SSEJoinManager sSEJoinManager, JoinHandler joinHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != MessageInfo.CipherKeyAsk.getDispatchCode()) {
                if (msg.what != MessageInfo.RegionInfoAsk.getDispatchCode()) {
                    if (msg.what == MessageInfo.ResetMsgKeyAsk.getDispatchCode()) {
                        SSEJoinManager.this.handleResetMsgKeyRep(msg);
                        return;
                    }
                    if (msg.what != MessageInfo.SSEJoinAsk.getDispatchCode()) {
                        if (msg.what != MessageInfo.PhoneNoAuthSMSAsk.getDispatchCode()) {
                            if (msg.what != MessageInfo.PhoneNoAuthAsk.getDispatchCode()) {
                                if (msg.what != MessageInfo.Error.getDispatchCode()) {
                                    return;
                                }
                                SSEJoinManager.this.handleSSEDupicateID(msg);
                                return;
                            }
                            SSEJoinManager.this.handlePhoneNoAuthRep(msg);
                            return;
                        }
                        SSEJoinManager.this.handlePhoneNoAuthSMSRep(msg);
                        return;
                    }
                    SSEJoinManager.this.handleSSEJoinRep(msg);
                    return;
                }
                SSEJoinManager.this.handleRegionInfoRep(msg);
                return;
            }
            SSEJoinManager.this.handleCipherKeyRep(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSSEDupicateID(Message msg) {
        logE("handleSSEDupicateID is called");
        MainApplication.mConfig.setProfileCountryCode(Integer.valueOf(getIntegerCountryCode(this.strCountryCode)));
        MainApplication.mConfig.setProfilePhoneNo(getJoinPhoneNo());
        MainApplication.mConfig.setProfileUserName(getJoinName());
        MainApplication.mConfig.setProfileUserID(getJoinID());
        MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
        MainApplication.mConfig.setProfileDeviceID((short) 0);
        MainApplication.mConfig.setUserNo(((SSEJoinRep) msg.obj).getUserNo().longValue());
        if (getJoinPwd() != null && getJoinPwd().length() != 0) {
            MainApplication.mConfig.setProfileRawPwd(getJoinPwd());
            MainApplication.mConfig.setProfileRawPwdCheck(true);
        }
        logE("join end!!");
        logE("SSE Join success");
        LoginManagerInterface loginManager = MainApplication.mPhoneManager.getLoginManager();
        if (!loginManager.isLogin() && !loginManager.isDuringLogin()) {
            if (SSEPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
                loginManager.login();
            } else {
                SSEPhoneManager.startCoolotsService(MainApplication.mContext, false);
            }
        }
        this.isJoinProcessRun = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSSEJoinRep(Message msg) {
        logE("handleSSEJoinRep is called");
        if (msg.arg1 == 1) {
            logE("handleSSEJoinRep is called - 1");
            MainApplication.mConfig.setProfileCountryCode(Integer.valueOf(getIntegerCountryCode(this.strCountryCode)));
            MainApplication.mConfig.setProfilePhoneNo(getJoinPhoneNo());
            MainApplication.mConfig.setProfileUserName(getJoinName());
            MainApplication.mConfig.setProfileUserID(getJoinID());
            MainApplication.mConfig.setProfileSerialNo(this.strDeviceSerialNo);
            MainApplication.mConfig.setProfileDeviceID((short) 0);
            if (getJoinPwd() != null && getJoinPwd().length() != 0) {
                MainApplication.mConfig.setProfileRawPwd(getJoinPwd());
                MainApplication.mConfig.setProfileRawPwdCheck(true);
            }
            logE("join end!!");
            logE("SSE Join success");
            LoginManagerInterface loginManager = MainApplication.mPhoneManager.getLoginManager();
            if (!loginManager.isLogin() && !loginManager.isDuringLogin()) {
                if (SSEPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
                    loginManager.login();
                } else {
                    SSEPhoneManager.startCoolotsService(MainApplication.mContext, false);
                }
            }
        } else if (msg.arg1 == -1) {
            logE("join error!!");
            sendJoinEvent(EventCode.EVENT_JOIN_FAIL);
        } else if (msg.arg1 == 10082) {
            sendCipherKeyAsk();
        } else {
            logE("handleSSEJoinRep is called - ELSE");
            sendJoinEvent(EventCode.EVNET_JOIN_NETWORK_ERROR);
            logE("join failure!!");
        }
        this.isJoinProcessRun = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCipherKeyRep(Message msg) {
        if (msg.obj instanceof CipherKeyRep) {
            logE("<<YHT2>> SESSION ID:" + ((CipherKeyRep) msg.obj).getSessionID());
            MainApplication.mConfig.setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            MainApplication.mConfig.setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            sendResetMsgKeyAsk();
            return;
        }
        sendJoinEvent(1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRegionInfoRep(Message msg) {
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
    public void handlePhoneNoAuthSMSRep(Message msg) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePhoneNoAuthRep(Message msg) {
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

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccountFromWeb() {
    }
}
