package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.CloseConferenceAsk;
import com.coolots.p2pmsg.model.CloseConferenceRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;

/* renamed from: com.sds.coolots.call.a.d */
/* loaded from: classes.dex */
public class C1138d extends HttpAdaptor {

    /* renamed from: a */
    private static final String f2350a = "1";

    public C1138d(String str, int i, Handler handler) {
        super(MessageInfo.CloseConferenceAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_CLOSECONFERENCE);
        CloseConferenceAsk closeConferenceAsk = new CloseConferenceAsk();
        closeConferenceAsk.setConferenceNo(str);
        closeConferenceAsk.setStatusCode(Integer.valueOf(i));
        this.mMsgBody = closeConferenceAsk;
    }

    /* renamed from: a */
    private CloseConferenceRep m2131a() {
        CloseConferenceRep closeConferenceRep = new CloseConferenceRep();
        closeConferenceRep.setResult("1");
        return closeConferenceRep;
    }

    /* renamed from: a */
    private void m2132a(CloseConferenceRep closeConferenceRep) {
        if (closeConferenceRep.getResult().equals("1")) {
            sendEvent(0, EventCode.EVENT_CONF_CLOSE_SUCCESS, closeConferenceRep);
        } else {
            sendEvent(0, EventCode.EVENT_CONF_CLOSE_ERROR, closeConferenceRep);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(-1, EventCode.EVENT_CONF_CLOSE_ERROR, p2PMsg.getMsgBody());
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE CloseConferenceAdaptor CloseConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            case ErrorCode.ERR_CENTER_NOT_HOST /* 10093 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_CLOSE_ERROR, p2PMsg.getMsgBody());
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof CloseConferenceRep) {
            m2132a((CloseConferenceRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE CloseConferenceAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        super.start();
    }
}
