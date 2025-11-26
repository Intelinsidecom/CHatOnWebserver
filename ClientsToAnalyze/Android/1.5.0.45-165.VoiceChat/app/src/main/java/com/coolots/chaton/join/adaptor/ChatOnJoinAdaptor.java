package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnJoinAsk;
import com.coolots.p2pmsg.model.ChatOnJoinRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ChatOnJoinAdaptor extends HttpAdaptor implements DisposeInterface {
    public ChatOnJoinAdaptor(ChatOnJoinAsk ask, Handler handler) {
        super(MessageInfo.ChatOnJoinAsk, ask, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_JOIN);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        ChatOnJoinAsk ask = (ChatOnJoinAsk) getMsgBody();
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
        if (msgBody instanceof ChatOnJoinRep) {
            ChatOnJoinRep rep = (ChatOnJoinRep) msgBody;
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                sendEvent(1, 0, msgBody);
            } else {
                MainApplication.mConfig.setUserNo(rep.getUserNo().longValue());
                sendEvent(1, 0, null);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        Error rep = (Error) p2pMsg.getMsgBody();
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            sendEvent(-1, 0, rep);
        } else {
            if (rep.getErrorCode() == 10082) {
                MainApplication.mConfig.setCipherKey("");
                MainApplication.mConfig.setSessionID("");
                handleNormalError(p2pMsg);
                return;
            }
            super.processErrorMessage(p2pMsg);
        }
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
