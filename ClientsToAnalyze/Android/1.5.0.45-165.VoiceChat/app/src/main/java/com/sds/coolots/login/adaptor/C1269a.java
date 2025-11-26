package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.DeviceIDRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* renamed from: com.sds.coolots.login.adaptor.a */
/* loaded from: classes.dex */
public class C1269a extends HttpAdaptor {
    public C1269a(MsgBody msgBody, Handler handler) {
        super(MessageInfo.DeviceIDAsk, msgBody, handler, 6000);
    }

    /* renamed from: a */
    private boolean m3067a() {
        String sessionID = MainApplication.mConfig.getSessionID();
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (sessionID == null || sessionID.isEmpty() || decodedCipherKey == null || decodedCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeviceIdAdaptor DeviceIDAsk HTTPS : " + this.mUriScheme);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        if (((Error) p2PMsg.getMsgBody()).getErrorCode() == 10001) {
            sendEvent(10001, 0, null);
        } else {
            super.processErrorMessage(p2PMsg);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (!(msgBody instanceof DeviceIDRep)) {
            sendEvent(-1, 0, null);
            return;
        }
        DeviceIDRep deviceIDRep = (DeviceIDRep) msgBody;
        if (deviceIDRep.getDeviceID() == 0) {
            sendEvent(-1, 0, null);
        }
        if (!MainApplication.mPhoneManager.getAppVersion().equals(deviceIDRep.getAppVersion())) {
            MainApplication.mConfig.notifyNewAppVersion();
        }
        MainApplication.mConfig.setProfileDeviceID(Short.valueOf(deviceIDRep.getDeviceID()));
        MainApplication.mConfig.setAppVersion(deviceIDRep.getAppVersion());
        MainApplication.mPhoneManager.getLoginManager().setNonce(deviceIDRep.getNonce());
        sendEvent(0, 0, null);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE DeviceIdAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (m3067a()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        if (MainApplication.mConfig.getProfileUserID() != null && !MainApplication.mConfig.getProfileUserID().equals("")) {
            this.mUserID = MainApplication.mConfig.getProfileUserID();
        }
        if (MainApplication.mConfig.getProfileDeviceID() == null || MainApplication.mConfig.getProfileDeviceID().shortValue() == 0) {
            return;
        }
        this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
    }
}
