package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.model.PhoneNoInfo;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnAuthValidationAsk;
import com.coolots.p2pmsg.model.ChatOnAuthValidationRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.PhoneNoAuthInfo;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnAuthValidationAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[ChatOnAuthValidationAdaptor]";
    private PhoneNoInfo authPhoneNoInfo;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ChatOnAuthValidationAdaptor(PhoneNoAuthInfo phoneNoAuthInfo, String authNo, String guid, Handler handler) {
        super(MessageInfo.ChatOnAuthValidationAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_CHATONSMSAUTH);
        this.authPhoneNoInfo = new PhoneNoInfo();
        ChatOnAuthValidationAsk ask = new ChatOnAuthValidationAsk();
        ask.setAccessToken("");
        ask.setGuidSamsungAccount(guid);
        ask.setCountryCode(phoneNoAuthInfo.getCountryCode().intValue());
        ask.setPhoneNo(phoneNoAuthInfo.getPhoneNo());
        ask.setUserToken(phoneNoAuthInfo.getAuthID());
        ask.setAuthNumber(authNo);
        ask.setAccessToken(ConfigActivity.getSamsungAccountAccessToken());
        this.mMsgBody = ask;
        this.authPhoneNoInfo.phoneNo = phoneNoAuthInfo.getPhoneNo();
        this.authPhoneNoInfo.countryCode = Integer.toString(phoneNoAuthInfo.getCountryCode().intValue());
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
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ChatOnAuthValidationAdaptor ChatOnAuthValidationAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        MsgBody msgBody = p2pMsg.getMsgBody();
        if (msgBody instanceof ChatOnAuthValidationRep) {
            ((ChatOnConfigInterface) MainApplication.mConfig).setSMSAuthNumber(this.authPhoneNoInfo.phoneNo);
            ((ChatOnConfigInterface) MainApplication.mConfig).setSMSAuthCountryCode(this.authPhoneNoInfo.countryCode);
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int errorCode) {
        processTimeOutError();
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
            case ErrorCode.ERR_CENTER_INVALID_AUTH_NO /* 10086 */:
            case ErrorCode.ERR_CENTER_ERROR_CHATON_SERVER /* 10096 */:
                sendEvent(rep.getErrorCode(), 0, null);
                break;
            default:
                super.processErrorMessage(p2pMsg);
                break;
        }
    }
}
