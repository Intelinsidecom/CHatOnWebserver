package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.chaton.buddy.util.RegionDomainUtil;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AddBuddyAsk;
import com.coolots.p2pmsg.model.AddBuddyRep;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.BuddyResponseInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AddBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[AddBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public AddBuddyAdaptor(ArrayList<String> userIDList, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.AddBuddyAsk, null, handler, 6000);
        AddBuddyAsk ask = new AddBuddyAsk();
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
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AddBuddyAdaptor AddBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof AddBuddyRep) && this.mResultHandler != null) {
            AddBuddyRep rep = (AddBuddyRep) p2pMsg.getMsgBody();
            ArrayList<BuddyInfo> success = new ArrayList<>();
            ArrayList<BuddyInfo> failure = new ArrayList<>();
            int addMySelf = 0;
            for (BuddyResponseInfo response : rep.getResponseList()) {
                switch (response.getResponseCode()) {
                    case 200:
                        success.add(response.getBuddyInfo());
                        break;
                    case 400:
                        addMySelf = 1;
                        break;
                    case 404:
                        failure.add(response.getBuddyInfo());
                        break;
                }
            }
            if (!success.isEmpty()) {
                this.mResultHandler.insertBuddys(success);
                Iterator<BuddyInfo> it = success.iterator();
                while (true) {
                    if (it.hasNext()) {
                        BuddyInfo bi = it.next();
                        if (bi.getRegion() != null && !RegionDomainUtil.isExistDomainInfo(Long.valueOf(bi.getRegion()).longValue())) {
                            RegionDomainUtil.setNeededToRegionDomainSync(true);
                        }
                    }
                }
            }
            if (!failure.isEmpty()) {
                this.mResultHandler.withdrawBuddys(failure);
            }
            sendEvent(0, addMySelf, failure);
        }
    }
}
