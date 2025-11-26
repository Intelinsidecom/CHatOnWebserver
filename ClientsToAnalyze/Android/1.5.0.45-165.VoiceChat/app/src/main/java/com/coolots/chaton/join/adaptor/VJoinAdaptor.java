package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.VJoinAsk;
import com.coolots.p2pmsg.model.VJoinRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VJoinAdaptor extends HttpAdaptor implements DisposeInterface {
    public VJoinAdaptor(VJoinAsk ask, Handler handler) {
        super(MessageInfo.VJoinAsk, ask, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        VJoinAsk ask = (VJoinAsk) getMsgBody();
        this.mUserID = ask.getUserID();
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
    protected void processRecvMessage(P2PMsg p2pMsg) {
        MsgBody msgBody = p2pMsg.getMsgBody();
        if (msgBody instanceof VJoinRep) {
            sendEvent(1, 0, msgBody);
        }
        if (MainApplication.mPhoneManager.IsLinkagewithChatON() && (msgBody instanceof Error)) {
            sendEvent(ErrorCode.ERR_CENTER_ACCOUNT_DUPLICATE, 0, msgBody);
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
    protected void handleNetworkError(int errorCode) {
        processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
