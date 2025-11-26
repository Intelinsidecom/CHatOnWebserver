package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.NonceRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.login.adaptor.d */
/* loaded from: classes.dex */
public class C1272d extends HttpAdaptor {
    public C1272d(MsgBody msgBody, Handler handler) {
        super(MessageInfo.NonceAsk, msgBody, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE NonceAdaptor NonceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        if (((Error) p2PMsg.getMsgBody()).getErrorCode() == 10001) {
            sendEvent(10001, 0, null);
        } else {
            super.processErrorMessage(p2PMsg);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof NonceRep) {
            NonceRep nonceRep = (NonceRep) msgBody;
            if (!MainApplication.mPhoneManager.getAppVersion().equals(nonceRep.getAppVersion())) {
                MainApplication.mConfig.notifyNewAppVersion();
            }
            MainApplication.mPhoneManager.getLoginManager().setNonce(nonceRep.getNonce());
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE NonceAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
