package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.chaton.buddy.util.RegionDomainUtil;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.BuddyListAsk;
import com.coolots.p2pmsg.model.BuddyListRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyListAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[BuddyListAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public BuddyListAdaptor(Date lastUpdateTime, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.BuddyListAsk, null, handler, 6000);
        BuddyListAsk ask = new BuddyListAsk();
        ask.setUpdateDate(lastUpdateTime);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE BuddyListAdaptor BuddyListAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof BuddyListRep) && this.mResultHandler != null) {
            BuddyListRep rep = (BuddyListRep) p2pMsg.getMsgBody();
            this.mResultHandler.updateBuddys(rep.getBuddyList(), rep.getGroupList(), rep.getRemovedGroupList(), rep.getMapList(), rep.getRemovedMapList());
            this.mResultHandler.setBuddyUpdateFlag(rep.getUpdateDate());
            Iterator<BuddyInfo> it = rep.getBuddyList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BuddyInfo bi = it.next();
                if (bi.getRegion() != null && !RegionDomainUtil.isExistDomainInfo(Long.valueOf(bi.getRegion()).longValue())) {
                    Log.m2958e("BUDDY_TRACE setNeededToRegionDomainSync true");
                    RegionDomainUtil.setNeededToRegionDomainSync(true);
                    break;
                }
            }
            sendEvent(0, 0, null);
        }
    }
}
