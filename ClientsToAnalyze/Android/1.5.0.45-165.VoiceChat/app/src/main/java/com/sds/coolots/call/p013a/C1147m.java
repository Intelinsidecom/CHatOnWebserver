package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SwitchToSingleCallAsk;
import com.coolots.p2pmsg.model.SwitchToSingleCallRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.EventCode;

/* renamed from: com.sds.coolots.call.a.m */
/* loaded from: classes.dex */
public class C1147m extends HttpAdaptor {
    public C1147m(String str, int i, Handler handler) {
        super(MessageInfo.SwitchToSingleCallAsk, null, handler, 16000);
        SwitchToSingleCallAsk switchToSingleCallAsk = new SwitchToSingleCallAsk();
        switchToSingleCallAsk.setConferenceNo(str);
        this.mMsgBody = switchToSingleCallAsk;
    }

    /* renamed from: a */
    private void m2139a(SwitchToSingleCallRep switchToSingleCallRep) {
        sendEvent(0, EventCode.EVENT_ENGINE_CHANGE_TO_P2P, switchToSingleCallRep);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE SwithToSingleCallAdaptor SwitchToSingleCallAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof SwitchToSingleCallRep) {
            m2139a((SwitchToSingleCallRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE SwitchToSingleCallAsk's processTimeOutError");
        super.processTimeOutError();
    }
}
