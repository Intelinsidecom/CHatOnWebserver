package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.LogoutAsk;
import com.coolots.p2pmsg.model.LogoutRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class LogoutAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[LogoutAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public LogoutAdaptor(Handler handler) {
        super(MessageInfo.LogoutAsk, new LogoutAsk(), handler, 3000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE LogoutAdaptor LogoutAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof LogoutRep) {
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int errorCode) {
        processTimeOutError();
    }
}
