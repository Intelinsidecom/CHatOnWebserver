package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.DenyConferenceAsk;
import com.coolots.p2pmsg.model.DenyConferenceRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;

/* renamed from: com.sds.coolots.call.a.f */
/* loaded from: classes.dex */
public class C1140f extends HttpAdaptor {
    public C1140f(String str, int i, String str2, Handler handler) {
        super(MessageInfo.DenyConferenceAsk, null, handler, 16000);
        DenyConferenceAsk denyConferenceAsk = new DenyConferenceAsk();
        denyConferenceAsk.setConferenceNo(str);
        denyConferenceAsk.setStatusCode(i);
        denyConferenceAsk.setRejectedMessage(str2);
        logE("<<YHT2>> SEND DENY HANGUP REASON!! reason:" + i);
        this.mMsgBody = denyConferenceAsk;
    }

    /* renamed from: a */
    private void m2134a() {
        sendEvent(0, EventCode.EVENT_CONF_DENY_SUCCESS, null);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DenyConferenceAdaptor DenyConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_DENY_SUCCESS, null);
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        if (p2PMsg.getMsgBody() instanceof DenyConferenceRep) {
            m2134a();
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE DenyConferenceAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
