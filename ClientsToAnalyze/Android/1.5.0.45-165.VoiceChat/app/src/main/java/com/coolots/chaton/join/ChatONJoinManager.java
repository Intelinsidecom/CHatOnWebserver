package com.coolots.chaton.join;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.calllog.util.CallLogStringUtil;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.join.adaptor.ChatOnJoinAdaptor;
import com.coolots.chaton.join.adaptor.LogoutAdaptor;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnJoinAsk;
import com.coolots.p2pmsg.model.ChatOnJoinRep;
import com.coolots.p2pmsg.model.CipherKeyRep;
import com.coolots.p2pmsg.model.DeviceConfigAsk;
import com.coolots.p2pmsg.model.DeviceConfigInfo;
import com.coolots.p2pmsg.model.DeviceConfigRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.RegionInfoRep;
import com.coolots.p2pmsg.model.ResetMsgKeyRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EventHandlerInterface;
import com.sds.coolots.common.httpAdaptor.ResetMsgKeyAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.join.adaptor.RegionInfoAdaptor;
import com.sds.coolots.login.PushManagerInterface;
import com.sds.coolots.login.adaptor.CipherKeyAskAdaptor;
import com.sds.coolots.login.adaptor.DeviceConfigAdaptor;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONJoinManager implements ChatONJoinManagerInterface {
    public static final String CLASSNAME = "[ChatOnJoinManager]";
    private static final int PROCESS_IDLE = 0;
    private static final int PROCESS_REQ_CIPHERKEY = 2;
    private static final int PROCESS_REQ_JOIN = 3;
    private static final int PROCESS_REQ_REGION = 1;
    private int mJoinProcessID = 0;
    private final Handler mHandler = new ChatONVJoinHandler(this, null);
    private EventHandlerInterface mUIHandler = null;
    private String mSAccount = null;
    private String mUserName = null;
    private String mGUID = null;
    private String mCountryCodeIso2 = null;
    private String mDeviceSerialNo = null;
    private String mChatONNO = null;
    private String mChatONUID = null;
    private String mBirthday = null;
    private int mVoiceConfMaxNum = 0;
    private int mVideoConfMaxNum = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class ChatONVJoinHandler extends Handler {
        private ChatONVJoinHandler() {
        }

        /* synthetic */ ChatONVJoinHandler(ChatONJoinManager chatONJoinManager, ChatONVJoinHandler chatONVJoinHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws NumberFormatException {
            ChatONJoinManager.this.logE("handleMessage");
            if (msg.what != MessageInfo.CipherKeyAsk.getDispatchCode()) {
                if (msg.what != MessageInfo.RegionInfoAsk.getDispatchCode()) {
                    if (msg.what != MessageInfo.ResetMsgKeyAsk.getDispatchCode()) {
                        if (msg.what != MessageInfo.DeviceConfigAsk.getDispatchCode()) {
                            if (msg.what != MessageInfo.ChatOnJoinAsk.getDispatchCode()) {
                                if (msg.what != MessageInfo.StoreEPInfoAsk.getDispatchCode()) {
                                    if (msg.what != MessageInfo.LogoutAsk.getDispatchCode()) {
                                        if (msg.what != MessageInfo.Error.getDispatchCode()) {
                                            return;
                                        }
                                        ChatONJoinManager.this.handleErrorMessage(msg);
                                        return;
                                    }
                                    ChatONJoinManager.this.handleLogoutRep(msg);
                                    return;
                                }
                                ChatONJoinManager.this.handleStoreEPInfoRep(msg);
                                return;
                            }
                            ChatONJoinManager.this.handleChatONJoinRep(msg);
                            return;
                        }
                        ChatONJoinManager.this.handleDeviceConfigRep(msg);
                        return;
                    }
                    ChatONJoinManager.this.handleResetMsgKeyRep(msg);
                    return;
                }
                ChatONJoinManager.this.handleRegionInfoRep(msg);
                return;
            }
            ChatONJoinManager.this.handleCipherKeyRep(msg);
        }
    }

    private void sendRegionInfoAsk() {
        this.mJoinProcessID = 1;
        RegionInfoAdaptor adaptor = new RegionInfoAdaptor(this.mCountryCodeIso2, null, this.mGUID, this.mHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface, com.sds.coolots.login.JoinManagerInterface
    public void sendCipherKeyAsk() {
        logI("sendCipherKeyAsk()");
        this.mJoinProcessID = 2;
        CipherKeyAskAdaptor adaptor = new CipherKeyAskAdaptor(this.mHandler);
        adaptor.start();
    }

    public void sendDeviceConfigAsk() {
        DeviceConfigAsk ask = new DeviceConfigAsk();
        DeviceConfigAdaptor adaptor = new DeviceConfigAdaptor(ask, this.mHandler);
        adaptor.start();
    }

    private void sendChatONJoinAsk() {
        this.mJoinProcessID = 3;
        ChatOnJoinAsk ask = new ChatOnJoinAsk();
        ask.setUserID(ChatONStringConvert.getInstance().toUserID(this.mChatONNO));
        ask.setSamsungAccountID(this.mGUID);
        ask.setEmail(this.mSAccount);
        ask.setNationalCode(this.mCountryCodeIso2);
        ChatOnJoinAdaptor adaptor = new ChatOnJoinAdaptor(ask, this.mHandler);
        adaptor.start();
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
        this.mJoinProcessID = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCipherKeyRep(Message msg) {
        if (msg.obj instanceof CipherKeyRep) {
            MainApplication.mConfig.setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            MainApplication.mConfig.setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setCipherKey(((CipherKeyRep) msg.obj).getCipherKey());
            EngineInterface.getInstance().setSessionID(((CipherKeyRep) msg.obj).getSessionID());
            sendResetMsgKeyAsk();
            return;
        }
        sendJoinEvent(1011);
        this.mJoinProcessID = 0;
    }

    private void sendResetMsgKeyAsk() {
        ResetMsgKeyAdaptor adaptor = new ResetMsgKeyAdaptor(this.mHandler);
        adaptor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResetMsgKeyRep(Message msg) {
        if (msg.arg1 == 0) {
            if (msg.obj instanceof ResetMsgKeyRep) {
                sendDeviceConfigAsk();
            }
        } else {
            sendJoinEvent(1011);
            this.mJoinProcessID = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceConfigRep(Message msg) throws NumberFormatException {
        if (msg.arg1 == 1) {
            for (DeviceConfigInfo info : ((DeviceConfigRep) msg.obj).getDeviceConfigInfoList()) {
                if (info.getConfigKey().equals(DeviceConfigInfo.CONFERENCE_MEMBER_AUDIO_MAX)) {
                    this.mVoiceConfMaxNum = Integer.parseInt(info.getConfigValue());
                } else if (info.getConfigKey().equals(DeviceConfigInfo.CONFERENCE_MEMBER_VIDEO_MAX)) {
                    this.mVideoConfMaxNum = Integer.parseInt(info.getConfigValue());
                } else if (info.getConfigKey().equals("call.data.send.interval")) {
                    int callSendInterval = Integer.parseInt(info.getConfigValue());
                    MainApplication.mConfig.setCallDataSendInterval(callSendInterval);
                }
            }
            sendChatONJoinAsk();
            return;
        }
        sendJoinEvent(1011);
        this.mJoinProcessID = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChatONJoinRep(Message msg) {
        if (msg.arg1 == 1) {
            ((ChatOnConfigInterface) MainApplication.mConfig).setProfileUserName(this.mUserName);
            MainApplication.mConfig.setProfileDeviceID((short) 0);
            MainApplication.mConfig.setProfileUserID(ChatONStringConvert.getInstance().toUserID(this.mChatONNO));
            MainApplication.mConfig.setUserNo(((ChatOnJoinRep) msg.obj).getUserNo().longValue());
            MainApplication.mConfig.setConferenceCallMaxPeopleNum(false, this.mVoiceConfMaxNum);
            MainApplication.mConfig.setConferenceCallMaxPeopleNum(true, this.mVideoConfMaxNum);
            if (getPassword(this.mChatONNO) != null && getPassword(this.mChatONNO).length() != 0) {
                MainApplication.mConfig.setProfileRawPwd(getPassword(this.mChatONNO));
                MainApplication.mConfig.setProfileRawPwdCheck(true);
            }
            logE("join end!!");
            sendJoinEvent(EventCode.EVENT_JOIN_SUCCESS);
            if (VAppPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
                MainApplication.mPhoneManager.getLoginManager().login();
            } else {
                VAppPhoneManager.startCoolotsService(MainApplication.mContext, false);
            }
        } else if (msg.arg1 == -1) {
            logE("join error!! errorCode: " + ((Error) msg.obj).getErrorCode() + ", errorMsg" + ((Error) msg.obj).getErrorMsg());
            sendJoinEvent(EventCode.EVENT_JOIN_FAIL);
        } else if (msg.arg1 == 10082) {
            sendCipherKeyAsk();
        } else {
            sendJoinEvent(EventCode.EVNET_JOIN_NETWORK_ERROR);
            logE("join failure!!");
        }
        this.mJoinProcessID = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorMessage(Message msg) {
        logE("handleErrorMessage msg.arg : " + msg.arg1);
        switch (msg.arg1) {
            case ErrorCode.ERR_CENTER_ACCOUNT_DUPLICATE /* 10101 */:
                sendJoinEvent(EventCode.EVENT_JOIN_FAIL);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogoutRep(Message msg) {
        logI("handleLogoutRep() msg : " + msg.arg1);
        MainApplication.mPhoneManager.getLoginManager().logout(false);
        MainApplication.mPhoneManager.getLoginManager().serverInfo().clear();
        MainApplication.mPhoneManager.resetDatabase();
        File prefesFolders = MainApplication.mContext.getDir("shared_prefs", 0);
        String path = prefesFolders.getAbsolutePath();
        removeFiles(String.valueOf(path.replace("app_", "")) + "/");
        removeFiles(String.valueOf(MainApplication.mContext.getFilesDir().toString()) + "/");
        MainApplication.mConfig.clearCoolotsPref();
        MainApplication.mConfig.cleanSharedPreference(true);
        MainApplication.mConfig.resetPrefValues();
        MainApplication.mPhoneManager.setLogLevelWithServerType();
        MainApplication.mChatONInterface.sendBroadcastRemoveAccountResult(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStoreEPInfoRep(Message msg) {
        logI("handleStoreEPInfoRep() msg : " + msg.arg1);
        LogoutAdaptor adaptor = new LogoutAdaptor(this.mHandler);
        adaptor.start();
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
    public void setJoinMember(String identy, String pwd, String name, String serial, String phone, String country) {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void setChatONJoinMember(String identy, String name, String country, String GUID, String chatONNO, String IMEI, String chatONUID, String birthday) {
        if (checkJoinedUserID(identy)) {
            if (!MainApplication.mPhoneManager.getLoginManager().isDuringLogin() && !MainApplication.mPhoneManager.getLoginManager().isLogin()) {
                MainApplication.mPhoneManager.getLoginManager().login();
            }
            MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(true);
            return;
        }
        if (this.mJoinProcessID == 0) {
            this.mSAccount = identy;
            this.mUserName = name;
            this.mGUID = GUID;
            this.mCountryCodeIso2 = country;
            this.mDeviceSerialNo = IMEI;
            ((ChatOnConfigInterface) MainApplication.mConfig).setProfileSerialNo(this.mDeviceSerialNo);
            this.mChatONNO = chatONNO;
            this.mChatONUID = chatONUID;
            ((ChatOnConfigInterface) MainApplication.mConfig).setChatONUID(this.mChatONUID);
            if (birthday.length() == 8) {
                birthday = String.valueOf(birthday) + "000000";
            }
            this.mBirthday = CallLogStringUtil.getInstance().getCallDateString(birthday, "yyyy/MM/dd");
        } else {
            logI("setChatONJoinMember() ERROR !!! mJoinProcessID: " + this.mJoinProcessID + " 가입진행중!!! ");
        }
        sendRegionInfoAsk();
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinID() {
        return this.mChatONNO;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinPwd() {
        return null;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinName() {
        return null;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getJoinPhoneNo() {
        return null;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthSMS(Integer countryCode, String phoneNo, Handler uiHandler, Object parent, int isOk) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestServerPhoneNoAuthAsk(String authNo) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setMobileJoinParam(String identy, String pwd, String name, String number, Integer country, String email, String oriNo, String key) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void requestDuplicateCheck(String _id) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void clearSmsAuth() {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinActivity(EventHandlerInterface activity) {
        logE("<<YHT11>> setJoinActivity!!!!");
        this.mUIHandler = activity;
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void setJoinPhoneNoActivity(EventHandlerInterface activity) {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void handleFinishLogin() {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccount() {
        MainApplication.mPhoneManager.getLoginManager().notifyAbsenceToServer(this.mHandler);
        List<PushManagerInterface> pushManagerList = MainApplication.mPhoneManager.getPushManager();
        if (pushManagerList != null) {
            for (PushManagerInterface pushManager : pushManagerList) {
                pushManager.unregisterDevice();
            }
        }
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public void deleteAccountFromWeb() {
    }

    @Override // com.sds.coolots.login.JoinManagerInterface
    public String getSMSAuthID() {
        return null;
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void sendCreateAccessTokenAsk(String strAuthCode) {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void sendSAUserInfoAsk(String accountID, String accessToken) {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void startJoin(String userName) {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void requestPhoneNoAuth(Integer countryCode, String phoneNo, String language, boolean useSMS, int isOk) {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void resetPhoneNoAuthInfo() {
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public boolean isExistChatONVAccount() {
        return false;
    }

    @Override // com.coolots.chaton.join.ChatONJoinManagerInterface
    public void deleteChatONVAccount() {
    }

    private boolean checkJoinedUserID(String identy) {
        String newID = ChatONStringConvert.getInstance().toUserID(identy);
        String joinedID = MainApplication.mConfig.getProfileUserID();
        return newID.equals(joinedID);
    }

    private String getPassword(String strMsisdn) {
        return MainApplication.mPhoneManager.getConfigManager().getPassword(strMsisdn);
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
}
