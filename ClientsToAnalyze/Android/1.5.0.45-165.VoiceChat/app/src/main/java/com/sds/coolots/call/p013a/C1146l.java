package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ReturnPhoneNoAsk;
import com.coolots.p2pmsg.model.ReturnPhoneNoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;

/* renamed from: com.sds.coolots.call.a.l */
/* loaded from: classes.dex */
public class C1146l extends HttpAdaptor {
    public C1146l(String str, Handler handler) {
        super(MessageInfo.ReturnPhoneNoAsk, null, handler, 6000);
        ReturnPhoneNoAsk returnPhoneNoAsk = new ReturnPhoneNoAsk();
        returnPhoneNoAsk.setPhoneNo(str);
        this.mMsgBody = returnPhoneNoAsk;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ReturnPhoneNoAdaptor ReturnPhoneNoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case 10009:
            case ErrorCode.ERR_CENTER_NOT_ASSIGNED_NO /* 10085 */:
                sendEvent(error.getErrorCode(), 0, null);
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof ReturnPhoneNoRep) {
            sendEvent(0, 0, ((ReturnPhoneNoRep) msgBody).getPhoneNo());
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE ReturnPhoneNoAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        this.mUserID = MainApplication.mConfig.getProfileUserID();
        this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
        this.mPasswd = MainApplication.mConfig.getProfilePasswd();
    }
}
