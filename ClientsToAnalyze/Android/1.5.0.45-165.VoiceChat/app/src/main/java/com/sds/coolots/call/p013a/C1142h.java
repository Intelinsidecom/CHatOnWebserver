package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.JoinConferenceAsk;
import com.coolots.p2pmsg.model.JoinConferenceRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.C1260a;

/* renamed from: com.sds.coolots.call.a.h */
/* loaded from: classes.dex */
public class C1142h extends HttpAdaptor {
    public C1142h(String str, Handler handler) {
        super(MessageInfo.JoinConferenceAsk, null, handler, 16000);
        JoinConferenceAsk joinConferenceAsk = new JoinConferenceAsk();
        byte[] byteArray = (byte[]) null;
        try {
            logI("<CIH> toByteArray() in JoinConferenceAdaptor()");
            byteArray = ProtoBufHandler.toByteArray(C1260a.m2985a());
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
        }
        joinConferenceAsk.setFeatureSet(ByteString.copyFrom(byteArray));
        joinConferenceAsk.setConferenceNo(str);
        joinConferenceAsk.setCellularNetwork(MainApplication.mPhoneManager.checkNetworkType(MainApplication.mContext));
        this.mMsgBody = joinConferenceAsk;
    }

    /* renamed from: a */
    private void m2135a(JoinConferenceRep joinConferenceRep) {
        sendEvent(0, EventCode.EVENT_CONF_ENTER_SUCCESS, joinConferenceRep);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(-1, EventCode.EVENT_CONF_ENTER_ERROR, null);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE JoinConferenceAdaptor JoinConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case 10009:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_NOT_PARTICIPANT /* 10088 */:
            case ErrorCode.ERR_CENTER_ALREADY_PARTICIPANT /* 10089 */:
            case ErrorCode.ERR_CENTER_ADD_PARTICIPANT_FAIL /* 10091 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_ENTER_ERROR, null);
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof JoinConferenceRep) {
            m2135a((JoinConferenceRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE JoinConferenceAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
