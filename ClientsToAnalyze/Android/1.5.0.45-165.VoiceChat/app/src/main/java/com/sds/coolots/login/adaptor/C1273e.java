package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ServerInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.login.adaptor.e */
/* loaded from: classes.dex */
public class C1273e extends HttpAdaptor {
    public C1273e(MsgBody msgBody, Handler handler) {
        super(MessageInfo.ServerInfoAsk, msgBody, handler, 6000);
    }

    /* renamed from: a */
    private boolean m3070a() {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ServerInfoAdaptor ServerInfoAsk HTTPS : " + this.mUriScheme);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof ServerInfoRep) {
            sendEvent(0, 0, ((ServerInfoRep) msgBody).getServers());
        } else {
            sendEvent(-1, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE ServerInfoAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (m3070a()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }
}
