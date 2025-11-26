package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.StoreEPInfoAsk;
import com.coolots.p2pmsg.model.StoreEPInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.login.adaptor.f */
/* loaded from: classes.dex */
public class C1274f extends HttpAdaptor {

    /* renamed from: a */
    private final String f3201a;

    /* renamed from: b */
    private final String f3202b;

    public C1274f(String str, String str2, Handler handler) {
        super(MessageInfo.StoreEPInfoAsk, null, handler, 3000);
        StoreEPInfoAsk storeEPInfoAsk = new StoreEPInfoAsk();
        storeEPInfoAsk.setPushSvcType(str);
        storeEPInfoAsk.setPushRegID(str2);
        this.mMsgBody = storeEPInfoAsk;
        this.f3202b = str;
        this.f3201a = str2;
    }

    /* renamed from: a */
    private boolean m3071a() {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE StoreEPInfoAdaptor StoreEPInfoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        if (p2PMsg.getMsgBody() instanceof StoreEPInfoRep) {
            if (this.f3202b != null) {
                if (this.f3202b.equals(StoreEPInfoAsk.EP_TYPE_SPP)) {
                    MainApplication.mConfig.setSPPPUSHRegID(this.f3201a);
                }
                if (this.f3202b.equals(StoreEPInfoAsk.EP_TYPE_GCM)) {
                    MainApplication.mConfig.setGCMPUSHRegID(this.f3201a);
                }
            }
            sendEvent(0, 0, this.mHandler);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE StoreEPInfoAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (m3071a()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }
}
