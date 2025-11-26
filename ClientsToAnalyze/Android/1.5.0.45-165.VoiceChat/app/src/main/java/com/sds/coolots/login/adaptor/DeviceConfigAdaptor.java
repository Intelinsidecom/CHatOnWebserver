package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.DeviceConfigAsk;
import com.coolots.p2pmsg.model.DeviceConfigRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class DeviceConfigAdaptor extends HttpAdaptor implements DisposeInterface {
    public DeviceConfigAdaptor(DeviceConfigAsk deviceConfigAsk, Handler handler) {
        super(MessageInfo.DeviceConfigAsk, deviceConfigAsk, handler, 6000);
    }

    /* renamed from: a */
    private boolean m3066a() {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int i) {
        processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof DeviceConfigRep) {
            sendEvent(1, 0, msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (m3066a()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        if (profileUserID == null || profileUserID.equals("")) {
            profileUserID = "Client";
        }
        this.mUserID = profileUserID;
    }
}
