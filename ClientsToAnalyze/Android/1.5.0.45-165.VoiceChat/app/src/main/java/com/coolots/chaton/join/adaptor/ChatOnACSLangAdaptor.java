package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnACSLangAsk;
import com.coolots.p2pmsg.model.ChatOnACSLangRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnACSLangAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[ChatOnACSLangAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ChatOnACSLangAdaptor(Handler handler) {
        super(MessageInfo.ChatOnACSLangAsk, new ChatOnACSLangAsk(), handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_CHATONSMSAUTH);
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
        logE("ADAPTOR_TRACE ChatOnACSLangAdaptor ChatOnACSLangAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int errorCode) {
        logE("handleNetworkError!!!!!! RETRY!!!!");
        processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof ChatOnACSLangRep) {
            ChatOnACSLangRep rep = (ChatOnACSLangRep) p2pMsg.getMsgBody();
            sendEvent(0, 0, rep.getChatOnACSLangList());
        }
    }
}
