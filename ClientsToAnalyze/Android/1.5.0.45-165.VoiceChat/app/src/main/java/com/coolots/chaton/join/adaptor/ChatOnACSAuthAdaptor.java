package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnACSAuthAsk;
import com.coolots.p2pmsg.model.ChatOnACSAuthRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.PhoneNoAuthInfo;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnACSAuthAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[ChatOnACSAuthAdaptor]";
    private final PhoneNoAuthInfo mPhoneNoAuthInfo;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ChatOnACSAuthAdaptor(PhoneNoAuthInfo phoneNoAuthInfo, String deviceString, String language, String guid, Handler handler) {
        super(MessageInfo.ChatOnACSAuthAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_CHATONSMSAUTH);
        ChatOnACSAuthAsk ask = new ChatOnACSAuthAsk();
        ask.setGuidSamsungAccount(guid);
        ask.setCountryCode(phoneNoAuthInfo.getCountryCode().intValue());
        ask.setPhoneNo(phoneNoAuthInfo.getPhoneNo());
        ask.setDevicePlatform(1);
        ask.setDeviceString(deviceString);
        ask.setLanguage(language);
        ask.setAccessToken(ConfigActivity.getSamsungAccountAccessToken());
        this.mMsgBody = ask;
        this.mPhoneNoAuthInfo = phoneNoAuthInfo;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        this.mUserID = ConfigActivity.getSamsungAccountID();
        this.mDeviceID = ConfigActivity.getProfileDeviceID();
        this.mPasswd = ConfigActivity.getProfilePasswd();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (isCipherKey()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }

    private boolean isCipherKey() {
        String mSessionID = MainApplication.mConfig.getSessionID();
        byte[] mCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (mSessionID == null || mSessionID.isEmpty() || mCipherKey == null || mCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        Error rep = (Error) p2pMsg.getMsgBody();
        switch (rep.getErrorCode()) {
            case ErrorCode.ERR_CENTER_NONCE_REFRESH_NEEDED /* 10082 */:
                MainApplication.mConfig.setCipherKey("");
                MainApplication.mConfig.setSessionID("");
                sendEvent(ErrorCode.ERR_CENTER_NONCE_REFRESH_NEEDED, 0, null);
                break;
            case ErrorCode.ERR_CENTER_ERROR_CHATON_SERVER /* 10096 */:
            case ErrorCode.ERR_CENTER_DUPLICATE_AUTH_PROCESS /* 10105 */:
            case ErrorCode.ERR_CENTER_OVER_AUTH_LIMIT /* 10106 */:
                sendEvent(rep.getErrorCode(), 0, null);
                break;
            default:
                super.processErrorMessage(p2pMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ChatOnACSAuthAdaptor ChatOnACSAuthAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int errorCode) {
        logE("handleNetworkError!!!!!! RETRY!!!!");
        processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof ChatOnACSAuthRep) {
            ChatOnACSAuthRep rep = (ChatOnACSAuthRep) p2pMsg.getMsgBody();
            this.mPhoneNoAuthInfo.setAuthID(rep.getUserToken());
            sendEvent(0, 0, this.mPhoneNoAuthInfo);
        }
    }
}
