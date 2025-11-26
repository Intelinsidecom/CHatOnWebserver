package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.HoldConferenceAsk;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.call.a.g */
/* loaded from: classes.dex */
public class C1141g extends HttpAdaptor {
    public C1141g(String str, boolean z, Handler handler) {
        super(MessageInfo.HoldConferenceAsk, null, handler, 16000);
        HoldConferenceAsk holdConferenceAsk = new HoldConferenceAsk();
        holdConferenceAsk.setConferenceNo(str);
        if (z) {
            holdConferenceAsk.setHoldYn("Y");
        } else {
            holdConferenceAsk.setHoldYn("N");
        }
        this.mMsgBody = holdConferenceAsk;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE HoldConferenceAdaptor HoldConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
    }
}
