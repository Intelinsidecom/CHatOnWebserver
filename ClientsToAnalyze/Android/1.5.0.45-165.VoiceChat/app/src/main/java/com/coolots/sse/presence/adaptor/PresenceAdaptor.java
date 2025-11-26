package com.coolots.sse.presence.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.GetCallPresenceAsk;
import com.coolots.p2pmsg.model.GetCallPresenceRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class PresenceAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[PresenceAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public PresenceAdaptor(GetCallPresenceAsk ask, Handler handler) {
        super(MessageInfo.GetCallPresenceAsk, ask, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE PresenceAdaptor GetCallPresenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof GetCallPresenceRep) {
            GetCallPresenceRep presenceRep = (GetCallPresenceRep) p2pMsg.getMsgBody();
            if (presenceRep == null) {
                sendEvent(-2, 0, null);
                return;
            }
            logE("<<presenceRep>> -------------------------------------------------------------------");
            String presence = presenceRep.getPresence();
            if (presence == null) {
                sendEvent(-1, 0, null);
                logE("<<presenceRep>> presence is null!!!");
            } else {
                sendEvent(0, 0, p2pMsg.getMsgBody());
            }
            logE("<<presenceRep>> -------------------------------------------------------------------");
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        super.processErrorMessage(p2pMsg);
    }
}
