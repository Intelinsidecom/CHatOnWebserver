package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.RegisterPhoneNoAsk;
import com.coolots.p2pmsg.model.RegisterPhoneNoRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class RegisterPhoneNoAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[RegisterPhoneNoAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public RegisterPhoneNoAdaptor(String authID, Handler handler) {
        super(MessageInfo.RegisterPhoneNoAsk, null, handler, 6000);
        RegisterPhoneNoAsk msg = new RegisterPhoneNoAsk();
        msg.setAuthID(authID);
        this.mMsgBody = msg;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE RegisterPhoneNoAdaptor RegisterPhoneNoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg msg) {
        if (msg.getMsgBody() instanceof RegisterPhoneNoRep) {
            RegisterPhoneNoRep rep = (RegisterPhoneNoRep) msg.getMsgBody();
            if ("1".equals(rep.getResult())) {
                sendEvent(0, 0, null);
            } else {
                sendEvent(-1, 0, null);
            }
        }
    }
}
