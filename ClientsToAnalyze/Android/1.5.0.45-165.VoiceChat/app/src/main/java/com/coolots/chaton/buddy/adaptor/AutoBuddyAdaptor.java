package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.chaton.buddy.model.NativeNameAndPhoneNumberInfo;
import com.coolots.chaton.buddy.util.RegionDomainUtil;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AutoBuddyAsk;
import com.coolots.p2pmsg.model.AutoBuddyRep;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.PhoneBookInfo;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AutoBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[AutoBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;
    private List<NativeNameAndPhoneNumberInfo> nativeNameInfoList;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public AutoBuddyAdaptor(List<PhoneBookInfo> phoneBook, List<NativeNameAndPhoneNumberInfo> nativeNameInfoList, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.AutoBuddyAsk, null, handler, 6000);
        this.nativeNameInfoList = new ArrayList();
        AutoBuddyAsk ask = new AutoBuddyAsk();
        ask.setPhoneBookInfoList(phoneBook);
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
        this.nativeNameInfoList = nativeNameInfoList;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AutoBuddyAdaptor AutoBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof AutoBuddyRep) && this.mResultHandler != null) {
            AutoBuddyRep rep = (AutoBuddyRep) p2pMsg.getMsgBody();
            this.mResultHandler.insertBuddys(rep.getBuddyInfoList(), this.nativeNameInfoList);
            Iterator<BuddyInfo> it = rep.getBuddyInfoList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BuddyInfo bi = it.next();
                if (bi.getRegion() != null && !RegionDomainUtil.isExistDomainInfo(Long.valueOf(bi.getRegion()).longValue())) {
                    RegionDomainUtil.setNeededToRegionDomainSync(true);
                    break;
                }
            }
            sendEvent(0, 0, null);
        }
    }
}
