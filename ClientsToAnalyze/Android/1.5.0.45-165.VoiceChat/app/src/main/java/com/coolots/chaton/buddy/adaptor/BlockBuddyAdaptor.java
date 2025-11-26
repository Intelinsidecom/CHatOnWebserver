package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BlockBuddyAsk;
import com.coolots.p2pmsg.model.BlockBuddyRep;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BlockBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[BlockBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public BlockBuddyAdaptor(List<Long> userNos, boolean blockState, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.BlockBuddyAsk, null, handler, 6000);
        BlockBuddyAsk ask = new BlockBuddyAsk();
        ArrayList<BuddyInfo> buddyList = new ArrayList<>();
        Iterator<Long> it = userNos.iterator();
        while (it.hasNext()) {
            long userNo = it.next().longValue();
            BuddyInfo buddy = new BuddyInfo();
            buddy.setUserNo(userNo);
            if (blockState) {
                buddy.setBlock("Y");
            } else {
                buddy.setBlock("N");
            }
            buddyList.add(buddy);
        }
        ask.setBuddyInfoList(buddyList);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE BlockBuddyAdaptor BlockBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof BlockBuddyRep) && this.mResultHandler != null) {
            BlockBuddyRep rep = (BlockBuddyRep) p2pMsg.getMsgBody();
            this.mResultHandler.blockBuddy(rep.getBuddyInfoList(), rep.getRemovedMapList());
            if (!((BlockBuddyRep) p2pMsg.getMsgBody()).getBuddyInfoList().isEmpty()) {
                if (((BlockBuddyRep) p2pMsg.getMsgBody()).getBuddyInfoList().get(0).getBlock().equals("Y")) {
                    sendEvent(0, 1, null);
                    return;
                } else if (rep.getBuddyInfoList().size() == 1) {
                    sendEvent(0, 0, rep.getBuddyInfoList().get(0));
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
