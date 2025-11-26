package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MuteConferenceAsk;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.call.a.j */
/* loaded from: classes.dex */
public class C1144j extends HttpAdaptor {
    public C1144j(String str, boolean z, boolean z2, Handler handler) {
        super(MessageInfo.MuteConferenceAsk, null, handler, 16000);
        MuteConferenceAsk muteConferenceAsk = new MuteConferenceAsk();
        muteConferenceAsk.setConferenceNo(str);
        if (z) {
            muteConferenceAsk.setMuteAudioYn("Y");
        } else {
            muteConferenceAsk.setMuteAudioYn("N");
        }
        if (z2) {
            muteConferenceAsk.setMuteVideoYn("Y");
        } else {
            muteConferenceAsk.setMuteVideoYn("N");
        }
        this.mMsgBody = muteConferenceAsk;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE MuteConferenceAdaptor MuteConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
    }
}
