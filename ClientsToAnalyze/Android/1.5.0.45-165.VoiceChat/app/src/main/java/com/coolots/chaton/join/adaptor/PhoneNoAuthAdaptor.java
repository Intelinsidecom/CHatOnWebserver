package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.PhoneNoAuthRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PhoneNoAuthAdaptor extends HttpAdaptor implements DisposeInterface {
    public PhoneNoAuthAdaptor(MsgBody msgBody, Handler handler) {
        super(MessageInfo.PhoneNoAuthAsk, msgBody, handler, 6000);
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
    protected void processRecvMessage(P2PMsg p2pmsg) throws NumberFormatException {
        MsgBody msgBody = p2pmsg.getMsgBody();
        if (msgBody instanceof PhoneNoAuthRep) {
            PhoneNoAuthRep rep = (PhoneNoAuthRep) msgBody;
            Integer result = Integer.valueOf(rep.getResult());
            if (result.intValue() == 1) {
                logE("SMS AUTH SUCCESS");
                sendEvent(0, 0, null);
            } else {
                processErrorMessage(p2pmsg);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        Error rep = (Error) p2pMsg.getMsgBody();
        if (rep.getErrorCode() == 10082) {
            MainApplication.mConfig.setCipherKey("");
            MainApplication.mConfig.setSessionID("");
            sendEvent(ErrorCode.ERR_CENTER_NONCE_REFRESH_NEEDED, 0, null);
            return;
        }
        super.processErrorMessage(p2pMsg);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        Log.m2963i("ADAPTOR_TRACE PhoneNoAuthAdaptor PhoneNoAuthAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        Log.m2963i("ADAPTOR_TRACE PhoneNoAuthAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
