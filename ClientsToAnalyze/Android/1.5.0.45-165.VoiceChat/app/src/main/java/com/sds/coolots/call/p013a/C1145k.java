package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.RemoveConferenceMemberAsk;
import com.coolots.p2pmsg.model.RemoveConferenceMemberRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;

/* renamed from: com.sds.coolots.call.a.k */
/* loaded from: classes.dex */
public class C1145k extends HttpAdaptor {

    /* renamed from: a */
    private final String f2352a;

    public C1145k(String str, String str2, int i, Handler handler) {
        super(MessageInfo.RemoveConferenceMemberAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_REMOVECONFERENCEMEMBER);
        RemoveConferenceMemberAsk removeConferenceMemberAsk = new RemoveConferenceMemberAsk();
        String string = new StringBuilder().append(Integer.valueOf(i)).toString();
        removeConferenceMemberAsk.setConferenceNo(str);
        removeConferenceMemberAsk.setUserID(str2);
        if (!"0".equals(string) && !"1".equals(string) && !SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(string)) {
            removeConferenceMemberAsk.setStatusCode(Integer.valueOf(i));
        }
        this.f2352a = str2;
        this.mMsgBody = removeConferenceMemberAsk;
        logI("RemoveConferenceMemberAdaptor() userID: " + this.f2352a);
    }

    /* renamed from: a */
    private void m2138a(RemoveConferenceMemberRep removeConferenceMemberRep) {
        logE("<handleRemoveConferenceMemberRep> result: " + removeConferenceMemberRep.getResult());
        sendEvent(0, EventCode.EVENT_CONF_REMOVE_SUCCESS, this.f2352a);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE RemoveConferenceMemberAdaptor RemoveConferenceMemberAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case 10001:
            case 10009:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_REMOVE_FAILURE, null);
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof RemoveConferenceMemberRep) {
            m2138a((RemoveConferenceMemberRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE RemoveConferenceMemberAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
