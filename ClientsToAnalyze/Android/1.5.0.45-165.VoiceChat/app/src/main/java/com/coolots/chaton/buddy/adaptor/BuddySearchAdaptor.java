package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddySearchAsk;
import com.coolots.p2pmsg.model.BuddySearchRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class BuddySearchAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[BuddySearchAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public BuddySearchAdaptor(BuddySearchInfo searchInfo, Handler handler) {
        super(MessageInfo.BuddySearchAsk, null, handler, 6000);
        BuddySearchAsk ask = new BuddySearchAsk();
        if (searchInfo.searchByPhoneNumber) {
            ask.setSearchType(2);
            ask.setCountryCode(Integer.valueOf(searchInfo.countryCode));
            ask.setPhoneNo(searchInfo.phoneNo);
        } else {
            ask.setSearchType(1);
            ask.setUserID(searchInfo.userID);
        }
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE BuddySearchAdaptor BuddySearchAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof BuddySearchRep) {
            BuddySearchRep rep = (BuddySearchRep) p2pMsg.getMsgBody();
            sendEvent(0, 0, rep);
        }
    }
}
