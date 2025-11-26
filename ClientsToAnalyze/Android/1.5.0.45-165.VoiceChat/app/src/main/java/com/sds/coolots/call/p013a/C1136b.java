package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChangeConferenceLayoutAsk;
import com.coolots.p2pmsg.model.ChangeConferenceLayoutRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.call.a.b */
/* loaded from: classes.dex */
public class C1136b extends HttpAdaptor {
    public C1136b(String str, int i, Handler handler) {
        super(MessageInfo.ChangeConferenceLayoutAsk, null, handler, 6000);
        ChangeConferenceLayoutAsk changeConferenceLayoutAsk = new ChangeConferenceLayoutAsk();
        changeConferenceLayoutAsk.setConferenceNo(str);
        changeConferenceLayoutAsk.setLayoutID(i);
        this.mMsgBody = changeConferenceLayoutAsk;
    }

    /* renamed from: a */
    private void m2130a(ChangeConferenceLayoutRep changeConferenceLayoutRep) {
        if (changeConferenceLayoutRep.getResult() == null || changeConferenceLayoutRep.getResult().equals("1")) {
            logE("[ChangeConferenceLayoutAdaptor]<handleChangeConferenceLayoutRep> change layout error!!");
        } else {
            sendEvent(0, ((ChangeConferenceLayoutAsk) this.mMsgBody).getLayoutID(), null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        logE("[ChangeConferenceLayoutAdaptor]<handleNormalError> ERROR!! code:" + error.getErrorCode() + ", msg:" + error.getErrorMsg());
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ChangeConferenceLayoutAdaptor AddConferenceMemberAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof ChangeConferenceLayoutRep) {
            m2130a((ChangeConferenceLayoutRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE ChangeConferenceLayoutAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
