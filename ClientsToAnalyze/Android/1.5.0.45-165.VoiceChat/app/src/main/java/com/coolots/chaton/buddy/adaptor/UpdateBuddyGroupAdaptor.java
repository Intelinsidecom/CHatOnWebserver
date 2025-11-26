package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.UpdateBuddyGroupAsk;
import com.coolots.p2pmsg.model.UpdateBuddyGroupRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class UpdateBuddyGroupAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[UpdateBuddyGroupAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public UpdateBuddyGroupAdaptor(BuddyGroupInfo groupInfo, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.UpdateBuddyGroupAsk, null, handler, 6000);
        UpdateBuddyGroupAsk ask = new UpdateBuddyGroupAsk();
        ask.setBuddyGroupInfo(groupInfo);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof UpdateBuddyGroupRep) {
            this.mResultHandler.updateBuddyGroup(((UpdateBuddyGroupRep) p2pMsg.getMsgBody()).getBuddyGroupInfo());
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UpdateBuddyGroupAdaptor UpdateBuddyGroupAsk");
    }
}
