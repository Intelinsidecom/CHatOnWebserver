package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.LoginRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;

/* renamed from: com.sds.coolots.login.adaptor.c */
/* loaded from: classes.dex */
public class C1271c extends HttpAdaptor {
    public C1271c(MsgBody msgBody, Handler handler) {
        super(MessageInfo.LoginAsk, msgBody, handler, 6000);
    }

    /* renamed from: a */
    private boolean m3069a() {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE LoginAdaptor LoginAsk HTTPS : " + this.mUriScheme);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        switch (((Error) p2PMsg.getMsgBody()).getErrorCode()) {
            case 10002:
                logE("Login Error no ID");
                if (MainApplication.mPhoneManager.getClientType() == 0) {
                    logE("Invalid Password!!! delete password!!");
                    MainApplication.mConfig.setProfilePasswd("");
                }
                sendEvent(10002, 0, null);
                break;
            case ErrorCode.ERR_CENTER_AUTH_TIMEOUT /* 10081 */:
                logE("Login Error OVER time");
                sendEvent(ErrorCode.ERR_CENTER_AUTH_TIMEOUT, 0, null);
                break;
            default:
                logE("Login Error default");
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof LoginRep) {
            sendEvent(0, 0, (LoginRep) msgBody);
        } else {
            sendEvent(-1, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE LoginAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (m3069a()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        this.mUserID = MainApplication.mConfig.getProfileUserID();
        this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
        this.mPasswd = MainApplication.mConfig.getProfilePasswd();
    }
}
