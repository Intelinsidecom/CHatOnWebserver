package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.RegionDomainInfoAsk;
import com.coolots.p2pmsg.model.RegionDomainInfoRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RegionDomainInfoAdaptor extends HttpAdaptor {
    private final BuddyAdaptorHandlerInterface mResultHandler;

    public RegionDomainInfoAdaptor(Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.RegionDomainInfoAsk, null, handler, 6000);
        RegionDomainInfoAsk ask = new RegionDomainInfoAsk();
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof RegionDomainInfoRep) && this.mResultHandler != null) {
            RegionDomainInfoRep rep = (RegionDomainInfoRep) p2pMsg.getMsgBody();
            this.mResultHandler.makeRegionInfoTable((ArrayList) rep.getRegionDomainInfoList());
            if (this.mHandler != null) {
                sendEvent(0, 0, null);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE RegionDomainInfoAdaptor RegionDomainInfoAsk");
    }
}
