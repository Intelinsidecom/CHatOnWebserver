package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.DeleteBuddyGroupMapAsk;
import com.coolots.p2pmsg.model.DeleteBuddyGroupMapRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeleteBuddyGroupMapAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[DeleteBuddyGroupMapAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public DeleteBuddyGroupMapAdaptor(long groupID, List<Long> deleteBuddys, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.DeleteBuddyGroupMapAsk, null, handler, 6000);
        DeleteBuddyGroupMapAsk ask = new DeleteBuddyGroupMapAsk();
        ArrayList<BuddyGroupMapInfo> infoList = new ArrayList<>();
        for (Long userNo : deleteBuddys) {
            BuddyGroupMapInfo info = new BuddyGroupMapInfo();
            info.setGroupCode(groupID);
            info.setUserNo(userNo.longValue());
            infoList.add(info);
        }
        ask.setMapList(infoList);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof DeleteBuddyGroupMapRep) {
            this.mResultHandler.deleteGroupBuddyMap(((DeleteBuddyGroupMapRep) p2pMsg.getMsgBody()).getMapList());
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeleteBuddyGroupMapAdaptor DeleteBuddyGroupMapAsk");
    }
}
