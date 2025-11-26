package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.UpdateBuddyAsk;
import com.coolots.p2pmsg.model.UpdateBuddyRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class UpdateBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[UpdateBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public UpdateBuddyAdaptor(long userNo, String userName, String mainPhoneNo, boolean deletePhoneNo, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.UpdateBuddyAsk, null, handler, 6000);
        UpdateBuddyAsk ask = new UpdateBuddyAsk();
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setUserNo(userNo);
        if (userName != null && !userName.isEmpty()) {
            buddyInfo.setEditedUserName(userName);
        }
        if (mainPhoneNo != null && !mainPhoneNo.isEmpty()) {
            buddyInfo.setMainPhoneNo(mainPhoneNo);
        }
        if (deletePhoneNo) {
            buddyInfo.setMainPhoneNo("");
        }
        ask.setBuddyInfo(buddyInfo);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UpdateBuddyAdaptor UpdateBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof UpdateBuddyRep) {
            BuddyInfo buddyInfo = ((UpdateBuddyRep) p2pMsg.getMsgBody()).getBuddyInfo();
            if (buddyInfo.getEditedUserName() != null) {
                this.mResultHandler.changeBuddyName(buddyInfo.getUserNo(), buddyInfo.getEditedUserName());
            }
            if (buddyInfo.getMainPhoneNo() != null) {
                this.mResultHandler.changeMainPhoneNo(buddyInfo.getUserNo(), buddyInfo.getMainPhoneNo());
            }
            sendEvent(0, 0, null);
        }
    }
}
