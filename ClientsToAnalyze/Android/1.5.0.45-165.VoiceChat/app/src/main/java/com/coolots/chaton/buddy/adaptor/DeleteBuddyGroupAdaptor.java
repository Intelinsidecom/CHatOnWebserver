package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.DeleteBuddyGroupAsk;
import com.coolots.p2pmsg.model.DeleteBuddyGroupRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class DeleteBuddyGroupAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[DeleteBuddyGroupAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public DeleteBuddyGroupAdaptor(long groupCode, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.DeleteBuddyGroupAsk, null, handler, 6000);
        DeleteBuddyGroupAsk ask = new DeleteBuddyGroupAsk();
        ask.setGroupCode(groupCode);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof DeleteBuddyGroupRep) {
            this.mResultHandler.deleteBuddyGroup(((DeleteBuddyGroupRep) p2pMsg.getMsgBody()).getGroupCode());
            if (this.mHandler != null) {
                sendEvent(0, 0, null);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeleteBuddyGroupAdaptor DeleteBuddyGroupAsk");
    }
}
