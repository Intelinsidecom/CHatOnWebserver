package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChangeConferenceTypeAsk;
import com.coolots.p2pmsg.model.ChangeConferenceTypeRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;

/* renamed from: com.sds.coolots.call.a.c */
/* loaded from: classes.dex */
public class C1137c extends HttpAdaptor {

    /* renamed from: a */
    private final int f2349a;

    public C1137c(String str, String str2, String str3, int i, Handler handler) {
        super(MessageInfo.ChangeConferenceTypeAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_CHANGECONFERENCETYPE);
        ChangeConferenceTypeAsk changeConferenceTypeAsk = new ChangeConferenceTypeAsk();
        changeConferenceTypeAsk.setConferenceNo(str);
        changeConferenceTypeAsk.setConferenceType(str2);
        changeConferenceTypeAsk.setPresenterUserID(str3);
        this.mMsgBody = changeConferenceTypeAsk;
        this.f2349a = i;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ChangeConferenceTypeAdaptor ChangeConferenceTypeAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        if (p2PMsg.getMsgBody() instanceof ChangeConferenceTypeRep) {
            sendEvent(0, this.f2349a, (ChangeConferenceTypeRep) p2PMsg.getMsgBody());
        }
    }
}
