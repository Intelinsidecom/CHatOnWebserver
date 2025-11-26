package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AddBuddyGroupMapAsk;
import com.coolots.p2pmsg.model.AddBuddyGroupMapRep;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyGroupMapAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[AddBuddyGroupMapAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public AddBuddyGroupMapAdaptor(long groupID, List<Long> newBuddys, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.AddBuddyGroupMapAsk, null, handler, 6000);
        AddBuddyGroupMapAsk ask = new AddBuddyGroupMapAsk();
        ArrayList<BuddyGroupMapInfo> mapInfoList = new ArrayList<>();
        for (Long userNo : newBuddys) {
            BuddyGroupMapInfo mapInfo = new BuddyGroupMapInfo();
            mapInfo.setGroupCode(groupID);
            mapInfo.setUserNo(userNo.longValue());
            mapInfoList.add(mapInfo);
        }
        ask.setMapList(mapInfoList);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof AddBuddyGroupMapRep) {
            this.mResultHandler.addBuddyGroupMap(((AddBuddyGroupMapRep) p2pMsg.getMsgBody()).getMapList());
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AddBuddyGroupMapAdaptor AddBuddyGroupMapAsk");
    }
}
