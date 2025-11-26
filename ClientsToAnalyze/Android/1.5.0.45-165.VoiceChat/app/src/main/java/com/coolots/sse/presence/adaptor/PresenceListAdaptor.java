package com.coolots.sse.presence.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.CallPresenceInfo;
import com.coolots.p2pmsg.model.GetCallPresenceListAsk;
import com.coolots.p2pmsg.model.GetCallPresenceListRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class PresenceListAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[PresenceListAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public PresenceListAdaptor(GetCallPresenceListAsk ask, Handler handler) {
        super(MessageInfo.GetCallPresenceListAsk, ask, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE PresenceAdaptor GetCallPresenceListAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof GetCallPresenceListRep) {
            GetCallPresenceListRep presenceListRep = (GetCallPresenceListRep) p2pMsg.getMsgBody();
            if (presenceListRep == null) {
                sendEvent(-2, 0, null);
                return;
            }
            List<CallPresenceInfo> CallPresenceInfoList = presenceListRep.getCallPresenceInfoList();
            if (CallPresenceInfoList == null) {
                sendEvent(-1, 0, null);
                logE("<<presenceRep>> presence is null!!!");
            } else {
                sendEvent(0, 0, p2pMsg.getMsgBody());
            }
            logE("<<presenceListRep>> -------------------------------------------------------------------");
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        super.processErrorMessage(p2pMsg);
    }
}
