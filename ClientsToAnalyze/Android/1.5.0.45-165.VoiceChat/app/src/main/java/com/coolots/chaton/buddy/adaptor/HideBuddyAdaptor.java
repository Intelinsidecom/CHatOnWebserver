package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.HideBuddyAsk;
import com.coolots.p2pmsg.model.HideBuddyRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class HideBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[HideBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public HideBuddyAdaptor(ArrayList<Long> userNos, boolean hideState, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.HideBuddyAsk, null, handler, 6000);
        HideBuddyAsk ask = new HideBuddyAsk();
        ArrayList<BuddyInfo> buddys = new ArrayList<>();
        Iterator<Long> it = userNos.iterator();
        while (it.hasNext()) {
            long userNo = it.next().longValue();
            BuddyInfo buddy = new BuddyInfo();
            buddy.setUserNo(userNo);
            if (hideState) {
                buddy.setHide("Y");
            } else {
                buddy.setHide("N");
            }
            buddys.add(buddy);
        }
        ask.setBuddyList(buddys);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE HideBuddyAdaptor HideBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof HideBuddyRep) && this.mResultHandler != null) {
            HideBuddyRep rep = (HideBuddyRep) p2pMsg.getMsgBody();
            this.mResultHandler.hideBuddys(rep.getBuddyList(), rep.getRemovedMapList());
            if (!((HideBuddyRep) p2pMsg.getMsgBody()).getBuddyList().isEmpty()) {
                if (((HideBuddyRep) p2pMsg.getMsgBody()).getBuddyList().get(0).getHide().equals("Y")) {
                    sendEvent(0, 1, null);
                    return;
                } else if (rep.getBuddyList().size() == 1) {
                    sendEvent(0, 0, rep.getBuddyList().get(0));
                    return;
                } else {
                    sendEvent(0, 0, null);
                    return;
                }
            }
            sendEvent(0, 0, null);
        }
    }
}
