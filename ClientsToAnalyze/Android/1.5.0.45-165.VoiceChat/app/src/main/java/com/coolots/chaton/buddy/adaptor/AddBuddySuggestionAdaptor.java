package com.coolots.chaton.buddy.adaptor;

import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AddBuddySuggestionAsk;
import com.coolots.p2pmsg.model.AddBuddySuggestionRep;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AddBuddySuggestionAdaptor extends HttpAdaptor {
    public AddBuddySuggestionAdaptor(ArrayList<String> userIDList) {
        super(MessageInfo.AddBuddySuggestionAsk, null, null, 6000);
        AddBuddySuggestionAsk ask = new AddBuddySuggestionAsk();
        ArrayList<BuddyInfo> buddyList = new ArrayList<>();
        Iterator<String> it = userIDList.iterator();
        while (it.hasNext()) {
            String userID = it.next();
            BuddyInfo bl = new BuddyInfo();
            bl.setUserID(userID);
            buddyList.add(bl);
        }
        ask.setBuddyList(buddyList);
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        boolean z = p2pMsg.getMsgBody() instanceof AddBuddySuggestionRep;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AddBuddyAdaptor AddBuddySuggestionAsk");
    }
}
