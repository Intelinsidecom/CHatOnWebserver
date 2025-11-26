package com.sds.coolots.common.httpAdaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ResetMsgKeyAsk;
import com.coolots.p2pmsg.model.ResetMsgKeyRep;

/* loaded from: classes.dex */
public class ResetMsgKeyAdaptor extends HttpAdaptor {
    public ResetMsgKeyAdaptor(Handler handler) {
        super(MessageInfo.ResetMsgKeyAsk, null, handler, 6000);
        this.mMsgBody = new ResetMsgKeyAsk();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ResetMsgKeyAdaptor ResetMsgKeyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof ResetMsgKeyRep) {
            if (this.mHandler == null) {
                sendEvent(-1, 0, msgBody);
            } else {
                MsgKeyGenerator.getInstance().resetKey();
                sendEvent(0, 0, msgBody);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        super.setUserInfo();
        if (this.mUserID == null || this.mUserID.isEmpty()) {
            this.mUserID = "Client";
        }
    }
}
