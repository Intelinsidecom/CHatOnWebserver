package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.StoreUserUsageAsk;
import com.coolots.p2pmsg.model.StoreUserUsageRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class StoreUserUsageAdaptor extends HttpAdaptor {
    public StoreUserUsageAdaptor(StoreUserUsageAsk ask, Handler handler) {
        super(MessageInfo.StoreUserUsageAsk, ask, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        Log.m2963i("SUJIN processRecvMessage");
        MsgBody msgBody = p2pMsg.getMsgBody();
        if (msgBody instanceof StoreUserUsageRep) {
            sendEvent(0, 0, msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        logE("ADAPTOR_TRACE StoreUserUsageAdaptor's processErrorMessage");
        Error rep = (Error) p2pMsg.getMsgBody();
        Log.m2963i("SUJIN" + rep.getErrorCode());
        rep.getErrorCode();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE StoreUserUsageAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE StoreUserUsageAdaptor StoreUserUsageAsk");
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
}
