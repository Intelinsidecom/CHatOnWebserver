package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AddBuddyGroupAsk;
import com.coolots.p2pmsg.model.AddBuddyGroupRep;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyGroupAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[AddBuddyGroupAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public AddBuddyGroupAdaptor(BuddyGroupInfo buddyGroupInfo, List<BuddyGroupMapInfo> mapList, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.AddBuddyGroupAsk, null, handler, 6000);
        AddBuddyGroupAsk ask = new AddBuddyGroupAsk();
        ask.setBuddyGroupInfo(buddyGroupInfo);
        ask.setMapList(mapList);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof AddBuddyGroupRep) && this.mResultHandler != null) {
            AddBuddyGroupRep rep = (AddBuddyGroupRep) p2pMsg.getMsgBody();
            this.mResultHandler.addBuddyGroup(rep.getBuddyGroupInfo());
            this.mResultHandler.addBuddyGroupMap(rep.getMapList());
            sendEvent(0, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AddBuddyGroupAdaptor AddBuddyGroupAsk");
    }
}
